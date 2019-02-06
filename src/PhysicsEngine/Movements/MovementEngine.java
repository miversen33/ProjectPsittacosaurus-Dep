package PhysicsEngine.Movements;

import Game.Field.GameField;
import Game.Field.GamePlayer;
import PhysicsEngine.Vector;
import Tuple.Tuple2;
import Utils.GeometricLine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MovementEngine {

    private final static int CYCLE_LIMIT = 3;
//    public final static int MAX_DISTANCE   = 3;
    private final static double COLLISION_RADIUS = 1.01;
//    RNG Needs to be higher than this number. However this may need to be set by the player instead
    private final static double DEFAULT_BREAK_TACKLE = .95;
//    RNG Needs to be higher than this number. These are if a state is provided
    private final static double DEFAULT_BREAK_ACTION = .98;
    private final static double DEFAULT_BREAK_BLOCK = .75;
    private final static double DEFAULT_CRITICAL_FAIL = .05;

    public MovementEngine(){
//        We should probably have some sort of hash provided by the field so we can
//        help ensure movement validity
    }

    private final List<GamePlayer> prioritizeQueue(final List<GamePlayer> playerQueue) {
        final List<MovementInstruction> instructionsQueue = new ArrayList<>();
        final List<GamePlayer> sortedPlayerQueue = new ArrayList<>();
        for(final GamePlayer player : playerQueue){
            instructionsQueue.add(player.getMovementInstruction());
        }
        instructionsQueue.sort(Comparator.naturalOrder());
        for(final MovementInstruction instruction : instructionsQueue){
            sortedPlayerQueue.add(instruction.getPlayer());
        }
        return sortedPlayerQueue;
//        final List<GamePlayer> playerQueue = new ArrayList<>();
//        movementQueue.sort(Comparator.naturalOrder());
//        for(final MovementInstruction instruction : movementQueue){
//            playerQueue.add(instruction.getPlayer());
//        }
//        return playerQueue;
    }

    public final void cycleQueue(final List<GamePlayer> movementQueue, final GameField field){
        final List<GamePlayer> prioritizedQueue = prioritizeQueue(movementQueue);
        boolean isDun;
        do{
            isDun = cycleQueue(0, prioritizedQueue, field);
        }while(!isDun);
    }

    private final boolean cycleQueue(final int count, List<GamePlayer> playerQueue, final GameField field){
        if(count >= CYCLE_LIMIT) return true;
        int interval = 1;

        boolean keepLooping = false;
//        First we need to handle existing collisions
        for(final GamePlayer player : playerQueue){
            if(player.getMovementInstruction().getAction().getActionState().isColliding()){
                handleCollision(player.getMovementInstruction(), field);
            }
//            } else {
////        Then we need to handle other movements
//                handleMovement(player.getMovementInstruction(), field);
//            }
        }

        playerQueue = prioritizeQueue(playerQueue);

//        Checking if any new movements will result in a collision
        for(int i = 0; i < playerQueue.size() - 1; i ++){
            final GamePlayer p1 = playerQueue.get(i);
            if(!p1.getMovementInstruction().getAction().getActionState().isColliding()){
                for(int j = i + 1; j < playerQueue.size(); j++){
                    final GamePlayer p2 = playerQueue.get(j);
                    if(!p2.getMovementInstruction().getAction().getActionState().isColliding()){
                        final Tuple2<Double, Double> collision = checkMovementVectorsForCollision(p1, p2);
                        if(collision != null){
                            final Vector p1Vector = p1.getCurrentMovement();
                            final Vector p2Vector = p2.getCurrentMovement();

                            final Vector revisedP1Vector = new Vector(p1.getLocation(), collision);
                            final Vector revisedP2Vector = new Vector(p2.getLocation(), collision);

                            MovementInstruction revisedP1Instruction = new MovementInstruction(new MovementAction(MovementAction.State.NULL, p1, p2), revisedP1Vector);
                            MovementInstruction revisedP2Instruction = new MovementInstruction(new MovementAction(MovementAction.State.NULL, p2, p1), revisedP2Vector);

                            p1.setMovementInstruction(this, revisedP1Instruction);
                            p2.setMovementInstruction(this, revisedP2Instruction);

                            handleMovement(p1.getMovementInstruction(), field);
                            handleMovement(p2.getMovementInstruction(), field);

                            revisedP1Instruction = new MovementInstruction(new MovementAction(MovementAction.State.COLLIDING, p1, p2), p1Vector);
                            revisedP2Instruction = new MovementInstruction(new MovementAction(MovementAction.State.COLLIDING, p2, p1), p2Vector);

                            p1.setMovementInstruction(this, revisedP1Instruction);
                            p2.setMovementInstruction(this, revisedP2Instruction);
                        }
                    }
                }
            }
        }

        for(final GamePlayer player : playerQueue){
            if(!player.getMovementInstruction().getAction().getActionState().isColliding()){
                handleMovement(player.getMovementInstruction(), field);
            } else {
                keepLooping = true;
            }
        }

        if(!keepLooping) interval = 3;

//        If the queue cycles and there are no existing collisions, we can set the count to 3 and return true
//        Otherwise, we need to increment the count +1 and cycle again. If a player is not currently
//        in a collision, they receive a NULL MovementAction, indicating that they are not currently
//        moving (done moving) and waiting to finish

        return cycleQueue(count + interval, playerQueue, field);
    }

    private final void handleCollision(final MovementInstruction instruction, final GameField field){
        /**
         * (2(m2v2)+(m1v1)-(m2v1))
         * ----------------------- = v1f
         *          (m1+m2)
         *
         * (2(m1v1)+(m2v2)-(m1v2))
         * ----------------------- = v2f
         *         (m1+m2)
         */
//        Quick catch to make sure that this is indeed a collision
        if(!instruction.getAction().getActionState().isColliding()) {
            handleMovement(instruction, field);
            return;
        }

        final Vector p1Movement = instruction.getVector();
        final Vector p2Movement = instruction.getAction().getAffectedPlayer().getMovementInstruction().getVector();

        final double mass1 = instruction.getAction().getAffectingPlayer().getMass();
        final double velX1 = p1Movement.getChangeX();
        final double velY1 = p1Movement.getChangeY();

        final double mass2 = instruction.getAction().getAffectedPlayer().getMass();
        final double velX2 = p2Movement.getChangeX();
        final double velY2 = p2Movement.getChangeY();

        final double resultVelX1 = (2*(mass2 * velX2) + (mass1 * velX1) - (mass2 * velX1)) / (mass1 + mass2);
        final double resultVelY1 = (2*(mass2 * velY2) + (mass1 * velY1) - (mass2 * velY1)) / (mass1 + mass2);
        final double resultVelX2 = (2*(mass1 * velX1) + (mass2 * velX2) - (mass1 * velX2)) / (mass1 + mass2);
        final double resultVelY2 = (2*(mass1 * velY1) + (mass2 * velY2) - (mass1 * velY2)) / (mass1 + mass2);
//
        final Vector resultantVector1 = new Vector(new Tuple2<>(resultVelX1, resultVelY1));
        final Vector resultantVector2 = new Vector(new Tuple2<>(resultVelX2, resultVelY2));
//
        final MovementInstruction instruction1 = new MovementInstruction(instruction.getAction().getAffectingPlayer(), resultantVector1);
        final MovementInstruction instruction2 = new MovementInstruction(instruction.getAction().getAffectedPlayer(),  resultantVector2);
//
        handleMovement(instruction1, field);
        handleMovement(instruction2, field);
//        Also need to handle if collision force generated causes injury
    }

    private final void handleMovement(final MovementInstruction instruction, final GameField field){
//        Quick catch to make sure that the movement is not a collision
        if(instruction.getAction().getActionState().isColliding()){
            handleCollision(instruction, field);
            return;
        }
        Vector movement = instruction.getVector();
        if(movement.getMagnitude() > instruction.getPlayer().getMaxMovement()){
            movement = movement.scale(instruction.getPlayer().getMaxMovement() / movement.getMagnitude());
        }
        field.movePlayer(this, instruction.getPlayer(), movement);
    }

    /**
     * Returns true if collision is found. False if not
     */
    private final Tuple2<Double, Double> checkMovementVectorsForCollision(final GamePlayer p1, final GamePlayer p2){
        return GeometricLine.DoVectorsIntersect(p1.getLocation(), p2.getLocation(), p1.getCurrentMovement(), p2.getCurrentMovement());
    }

}
