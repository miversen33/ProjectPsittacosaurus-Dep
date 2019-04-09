package PhysicsEngine.Movements;

import Game.GamePlay.GameField;
import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.PlayerState;
import PhysicsEngine.Movements.Events.BreakTackleEvent;
import PhysicsEngine.Movements.Events.CollisionEvent;
import PhysicsEngine.Movements.Events.TackleEvent;
import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;
import Utils.Location;
import Utils.Signature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MovementEngine {

    private final static int CYCLE_LIMIT = 3;
    private final Signature mSig;

    public MovementEngine(final Signature signature) {
        mSig = signature;
    }

    public final Signature getSignature(){
        return mSig;
    }

    private final List<GamePlayer> prioritizeQueue(final List<GamePlayer> playerQueue) {
        final List<MovementInstruction> instructionsQueue = new ArrayList<>();
        final List<GamePlayer> sortedPlayerQueue = new ArrayList<>();
        for (final GamePlayer player : playerQueue) {
            instructionsQueue.add(player.getMovementInstruction());
        }
        instructionsQueue.sort(Comparator.naturalOrder());
        for (final MovementInstruction instruction : instructionsQueue) {
            sortedPlayerQueue.add(instruction.getPlayer());
        }
        return sortedPlayerQueue;
    }

    public final void cycleQueue(final List<GamePlayer> movementQueue, final GameField field, final GameManager gameManager) {
        final List<GamePlayer> prioritizedQueue = prioritizeQueue(movementQueue);
        boolean isDun;
        do {
            isDun = cycleQueue(0, prioritizedQueue, field, gameManager);
        } while (!isDun);
    }

    private final boolean cycleQueue(final int count, List<GamePlayer> playerQueue, final GameField field, final GameManager gameManager) {
        if (count >= CYCLE_LIMIT) return true;
        int interval = 1;

        boolean keepLooping = false;
        boolean tickClock = false;
//        First we need to handle existing collisions
        for (final GamePlayer player : playerQueue) {
            if(!player.getMovementInstruction().hasBeenExecuted() && player.getMovementState().isColliding()) {
                if (!tickClock){
                    tickClock = true;
                    gameManager.microTickGameClock(getSignature());
                }
                handleCollision(player.getMovementInstruction(), field, gameManager.getTimeStamp());
            }
        }

        tickClock = false;

        playerQueue = prioritizeQueue(playerQueue);

//        Checking if any new movements will result in a collision
        for (int i = 0; i < playerQueue.size() - 1; i++) {
            final GamePlayer p1 = playerQueue.get(i);
            if(p1.getMovementState().isColliding()) continue;

            for (int j = i + 1; j < playerQueue.size(); j++) {
                final GamePlayer p2 = playerQueue.get(j);
                if(p2.getMovementState().isColliding()) continue;

                final Tuple2<Double, Double> collision = checkMovementVectorsForCollision(p1, p2);

                if(collision == null) continue;

                final Vector p1Vector = p1.getMovementInstruction().getVector();
                final Vector p2Vector = p2.getMovementInstruction().getVector();

                final Vector revisedP1Vector = new Vector(p1.getLocation(), collision);
                final Vector revisedP2Vector = new Vector(p2.getLocation(), collision);

                PlayerState p1CollisionState = PlayerState.COLLIDING;
                PlayerState p2CollisionState = PlayerState.COLLIDING;

//                Quick check to see if we are blocking instead of "colliding"
                if(p1.getMovementState().isBlocking() || p1.getMovementState().isBlocked()){
                    p1CollisionState = p1.getMovementState();
                }
                if(p2.getMovementState().isBlocking() || p2.getMovementState().isBlocked()){
                    p2CollisionState = p2.getMovementState();
                }

                if(!tickClock){
                    tickClock = true;
                    gameManager.microTickGameClock(getSignature());
                }

                MovementInstruction revisedP1Instruction = new MovementInstruction(new MovementAction(PlayerState.NULL, p1, p2), revisedP1Vector);
                MovementInstruction revisedP2Instruction = new MovementInstruction(new MovementAction(PlayerState.NULL, p2, p1), revisedP2Vector);

                p1.setMovementInstruction(this, revisedP1Instruction);
                p2.setMovementInstruction(this, revisedP2Instruction);

                handleMovement(p1.getMovementInstruction(), field, gameManager.getTimeStamp());
                handleMovement(p2.getMovementInstruction(), field, gameManager.getTimeStamp());
                
                revisedP1Instruction = new MovementInstruction(new MovementAction(p1CollisionState, p1, p2), p1Vector);
                revisedP2Instruction = new MovementInstruction(new MovementAction(p2CollisionState, p2, p1), p2Vector);

                p1.setMovementInstruction(this, revisedP1Instruction);
                p2.setMovementInstruction(this, revisedP2Instruction);
            }
        }

        tickClock = false;

        for (final GamePlayer player : playerQueue) {
            if (!player.getMovementState().isColliding()) {
                if (!tickClock) {
                    tickClock = true;
                    gameManager.tickGameClock(getSignature());
                }
                keepLooping = !handleMovement(player.getMovementInstruction(), field, gameManager.getTimeStamp());
            } else {
                keepLooping = true;
            }
        }

        if (!keepLooping) interval = 3;
//        If the queue cycles and there are no existing collisions, we can set the count to 3 and return true
//        Otherwise, we need to increment the count +1 and cycle again. If a player is not currently
//        in a collision, they receive a NULL MovementAction, indicating that they are not currently
//        moving (done moving) and waiting to finish

        return cycleQueue(count + interval, playerQueue, field, gameManager);
    }

    private final void handleCollision(final MovementInstruction instruction, final GameField field, final int timestamp) {
        /**
         * (m1v1 + m2v2)
         * -------------  = Vf
         *   (m1 + m2)
         *
         * vf * (f1 / ff) = v1
         * vf * (f2 / ff) = v2
         *
         */
//        Quick catch to make sure that this is indeed a collision
        if (!instruction.getAction().getActionState().isColliding()) {
            handleMovement(instruction, field, timestamp);
            return;
        }

        final Vector p1Movement = instruction.getAction().getAffectingPlayer().getMovementInstruction().getVector();
        final Vector p2Movement = instruction.getAction().getAffectedPlayer().getMovementInstruction().getVector();

        final double mass1 = instruction.getAction().getAffectingPlayer().getMass();
        final double velX1 = p1Movement.getChangeX();
        final double velY1 = p1Movement.getChangeY();

        final double mass2 = instruction.getAction().getAffectedPlayer().getMass();
        final double velX2 = p2Movement.getChangeX();
        final double velY2 = p2Movement.getChangeY();

        final double totalForce = instruction.getAction().getAffectingPlayer().getForce() + instruction.getAction().getAffectedPlayer().getForce();

        final double totalMass = mass1 + mass2;
        final double totalVelX = ((mass1 * velX1) + (mass2 * velX2)) / totalMass;
        final double totalVelY = ((mass1 * velY1) + (mass2 * velY2)) / totalMass;

        final double resultVelX1 = totalVelX * (instruction.getAction().getAffectedPlayer().getForce() / totalForce);
        final double resultVelY1 = totalVelY * (instruction.getAction().getAffectedPlayer().getForce() / totalForce);
        final double resultVelX2 = totalVelX * (instruction.getAction().getAffectingPlayer().getForce() / totalForce);
        final double resultVelY2 = totalVelY * (instruction.getAction().getAffectingPlayer().getForce() / totalForce);
//
        final Vector resultantVector1 = new Vector(new Tuple2<>(resultVelX1, resultVelY1));
        final Vector resultantVector2 = new Vector(new Tuple2<>(resultVelX2, resultVelY2));
//
        final MovementInstruction instruction1 = new MovementInstruction(instruction.getAction().getAffectingPlayer(), resultantVector1);
        final MovementInstruction instruction2 = new MovementInstruction(instruction.getAction().getAffectedPlayer(), resultantVector2);
//
        handleMovement(instruction1, field, timestamp);
        handleMovement(instruction2, field, timestamp);

        if(Location.GetDistance(instruction.getAction().getAffectingPlayer(), instruction.getAction().getAffectedPlayer()) <= 1) return;
        instruction.getAction().getAffectingPlayer().getMovementInstruction().execute(timestamp);
        instruction.getAction().getAffectedPlayer().getMovementInstruction().execute(timestamp);

//        Throws new collision event
        new CollisionEvent(getSignature(), instruction1.getPlayer(), instruction2.getPlayer()).fire();
//        Also need to handle if collision force generated causes injury

    }

    private final boolean handleMovement(final MovementInstruction instruction, final GameField field, final int timeStamp) {
//        Quick catch to make sure that the movement is not a collision
        if (instruction.getAction().getActionState().isColliding()) {
            handleCollision(instruction, field, timeStamp);
            return false;
        }

        if(!handleMovementAction(instruction,field)) return true;

        Vector movement = instruction.getVector();
        if (movement.getMagnitude() > instruction.getPlayer().getMaxMovement(movement.getDirection())) {
            movement = movement.scale(instruction.getPlayer().getMaxMovement(movement.getDirection()) / movement.getMagnitude());
        }
        instruction.execute(timeStamp);

        List<GamePlayer> collidingPlayers = field.movePlayer(this, instruction.getPlayer(), movement);

        if(collidingPlayers.size() == 0) return true;

        handlePostMoveCollision(instruction, collidingPlayers);

        return false;
    }

    private final void handlePostMoveCollision(final MovementInstruction instruction, final List<GamePlayer> collidingPlayers){
        GamePlayer collidedPlayer = collidingPlayers.get(0);

        PlayerState affectingState = instruction.getAction().getActionState();
        PlayerState affectedState = PlayerState.COLLIDING;

        if(affectingState.isBlocking() || affectingState.isTackling()){
            if(affectingState.isBlocking()) affectedState = PlayerState.IS_BLOCKED;
            if(affectingState.isTackling()) affectedState = PlayerState.IS_TACKLED;
        }

        final MovementInstruction firstPlayerRevisedInstruction = new MovementInstruction(new MovementAction(PlayerState.COLLIDING, instruction.getPlayer(), collidedPlayer), instruction.getVector());
        final MovementInstruction secondPlayerRevisedInstruction = new MovementInstruction(new MovementAction(PlayerState.COLLIDING, collidedPlayer, instruction.getPlayer()), collidedPlayer.getMovementInstruction().getVector());

        instruction.getPlayer().setMovementInstruction(this, firstPlayerRevisedInstruction);
//        instruction.getPlayer().setPlayerState(this, affectingState);
        collidedPlayer.setMovementInstruction(this, secondPlayerRevisedInstruction);
        collidedPlayer.setPlayerState(this, affectedState);
    }

    //Returns true if the movement it to be completed, false if not
    private final boolean handleMovementAction(final MovementInstruction instruction, final GameField field){
        final PlayerState movementState = instruction.getAction().getActionState();
        final PlayerState playerCurrentState = instruction.getPlayer().getPlayerState();

        if(!playerCurrentState.getCounterState().isNull()){
            if(playerCurrentState.getCounterState().equals(movementState)) return handleCounterMovementAction(instruction);
            if(!playerCurrentState.getCounterState().equals(movementState)) return handleMissingCounterMovementAction(instruction);
        }
        if(playerCurrentState.isTackled() || playerCurrentState.isTackling()) return !handleTackleEvent(instruction, field);

        return true;
    }

    private final boolean handleCounterMovementAction(final MovementInstruction instruction){
        final PlayerState movementState = instruction.getAction().getActionState();
        final PlayerState playerCurrentState = instruction.getPlayer().getPlayerState();
        final double minValue = 0;
        final double maxValue = 100;
//        TODO There should be more in this than just that. Include attributes and such
        final double breakPoint = movementState.getDefaultCounterValue();

//        Just in case we end up here when we aren't supposed to
        if(!playerCurrentState.getCounterState().equals(movementState)){
            return handleMissingCounterMovementAction(instruction);
        }

        double rng = Utils.RNGGenerator.Generate(minValue, maxValue);
        return !(rng < breakPoint);
    }

    private final boolean handleMissingCounterMovementAction(final MovementInstruction instruction){
        final PlayerState movementState = instruction.getAction().getActionState();
        final PlayerState playerCurrentState = instruction.getPlayer().getPlayerState();
        final double minValue = 0;
        final double maxValue = 100;
//        TODO There should be more in this than just that. Include attributes and such
        final double breakPoint = playerCurrentState.getDefaultCounterValue();

//        Just in case we end up here when we aren't supposed to
        if(playerCurrentState.getCounterState().equals(movementState)){
            return handleCounterMovementAction(instruction);
        }

        double rng = Utils.RNGGenerator.Generate(minValue, maxValue);
        return !(rng < breakPoint);
    }

    // Returns true if movement is consumed, false if not
    private final boolean handleTackleEvent(final MovementInstruction instruction, final GameField field){
        if(!instruction.getAction().getActionState().isTackling() && !instruction.getAction().getActionState().isTackled()){
//            Handle logging due to invalid instruction event
//            TODO
            System.out.println("Provided MovementInstruction is not a Tackle");
            return false;
        }

        final GamePlayer tackler = instruction.getAction().getActionState().isTackling() ? instruction.getPlayer() : instruction.getAction().getAffectedPlayer();
        final GamePlayer tackled = instruction.getAction().getActionState().isTackling() ? instruction.getAction().getAffectedPlayer() : instruction.getPlayer();

        final double minValue = 0;
        final double maxValue = 100;
        final double breakPoint = tackled.getPlayerState().getDefaultCounterValue();

        double rng = Utils.RNGGenerator.Generate(minValue, maxValue);
        if(rng < breakPoint){
//            Handle break tackle event
            new BreakTackleEvent(mSig, tackled, tackler).fire();
            return false;
        }

        List<GamePlayer> defenders = field.checkLocation(tackled, 1.0);
        defenders = BasePlayerStrategy.FilterBySameTeam(tackler, defenders);
        defenders.remove(tackler);

        final List<GamePlayer> tacklers = new ArrayList<>();
        tacklers.add(tackler);
        for(final GamePlayer defender : defenders){
            if(defender.getPlayerState().isTackling()) tacklers.add(defender);
        }

        new TackleEvent(mSig, tackled, tacklers).fire();
        return true;
    }

    /**
     * Returns collision point if found, otherwise it returns null
     */
    private final Tuple2<Double, Double> checkMovementVectorsForCollision(final GamePlayer p1, final GamePlayer p2) {
        final Tuple2<Double, Double> collisionPoint = Vector.GetVectorIntersectionPoint(p1.getLocation(), p2.getLocation(), p1.getMovementInstruction().getVector(), p2.getMovementInstruction().getVector());

        if(collisionPoint == null) return null;

        double p1Max = p1.getMaxMovement(p1.getMovementInstruction().getVector().getDirection());
        double p2Max = p2.getMaxMovement(p2.getMovementInstruction().getVector().getDirection());

        final double p1DistanceFromCollision = Location.GetDistance(p1.getLocation(), collisionPoint);
        final double p2DistanceFromCollision = Location.GetDistance(p2.getLocation(), collisionPoint);

        boolean collisionFound = (p1DistanceFromCollision > p1.getMaxMovement(p1.getMovementInstruction().getVector().getDirection()) ||
                p2DistanceFromCollision > p2.getMaxMovement(p2.getMovementInstruction().getVector().getDirection()));

        return collisionFound ? collisionPoint : null;
    }
}