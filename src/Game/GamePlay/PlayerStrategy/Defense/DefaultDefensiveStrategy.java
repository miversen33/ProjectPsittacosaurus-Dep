package Game.GamePlay.PlayerStrategy.Defense;

import Game.*;
import Game.Field.FieldObject;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import PhysicsEngine.Movements.Movement;
import PhysicsEngine.PhysicsObjects.Vector;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Utils.Location;

import java.util.List;

//This will be the "fallBack" strategy. This may be moved to DefensivePlayerStrategy instead, but for now its on its own.
public class DefaultDefensiveStrategy extends DefensivePlayerStrategy {

    private MovementInstruction move = null;
    private final double ENDING_TARGET_DISTANCE = .05;
//    Adjusting this very slightly can be a way to
//    Have the players attributes affect targeting ability
//    A higher number is going to lead to a harder move on the x axis (more conservative).
//    Where as a lower number leads to a harder move on the y axis (more aggressive).

//    Raise this number to cover more of the x axis first
    private final double DIVISOR_TARGET = 1.1;
    private final double STARTING_TARGET_DISTANCE = 1;
    private double targetRatio = STARTING_TARGET_DISTANCE;
    private boolean targetResetSwitch = false;
    private final int TARGET_POLL_MAX = 3;
    private Tuple2<Double, Double> targetPoint;
    private Tuple2<Double, Double> cacheBallCarrierLocation;
    private final double TARGET_RADIUS = 1.5;

    @Override
    public void calculateMove(final GamePlayer hostPlayer, final GameField field) {
//        Should check the player state and determine if we are currently
//        being blocked. If we are, we should engage in block shedding,
//        as opposed to tackle targeting

        targetPoint = calculateGoal(hostPlayer, field, null);
        Vector movement = new Vector(new Tuple2<>(targetPoint.getFirst() - hostPlayer.getLocation().getFirst(), targetPoint.getSecond() - hostPlayer.getLocation().getSecond()));
//
        final List<PlayerInfluence> playerInfluences = getInfluences(hostPlayer);

        for(final PlayerInfluence influence : playerInfluences){
            movement = movement.add(influence.getInfluence());
        }
//        movement = new Vector(movement.getDirection(), hostPlayer.getMaxMovement(movement.getDirection()));
        movement = new Vector(new Tuple2<>(-3.0, 0.0));

        move = new MovementInstruction(hostPlayer, movement);
    }

    private final List<PlayerInfluence> getInfluences(final GamePlayer hostPlayer){
//        List of influences on the player
        final List<PlayerInfluence> playerInfluences = hostPlayer.getPlayerInfluenceBiases();
        /**
         * Potential Blockers
         * BallCarrier
         */
        return playerInfluences;
    }

    private final void handleIfBlocked(final GamePlayer hostPlayer){
        if(hostPlayer.getMovementInstruction().getAction().getActionState().isBlocked()){

        }
    }

    @Override
    public final MovementInstruction getMove() {
        return move;
    }

//    BallCarrier prediction is heavily flawed. It does not work correctly and
//    No matter the the distance the ballcarrier starts from us, we cannot close
//    the gap before we are passed

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {
//        Calculates the target needed for the defender
        FieldObject ballCarrier = hostPlayer.getBallCarrier();
//        We need to handle if we are "down". If we are down we should try to get back up, instead of
//        staying down and hoping the game gets you up
        if(targetPoint != null && cacheBallCarrierLocation != null && Location.GetDistance(ballCarrier.getLocation(), cacheBallCarrierLocation) <= TARGET_RADIUS) return targetPoint;
        cacheBallCarrierLocation = ballCarrier.getLocation();

        double changeY = Math.abs(hostPlayer.getLocation().getSecond() - ballCarrier.getLocation().getSecond());
        double changeX = Math.abs(hostPlayer.getLocation().getFirst() - ballCarrier.getLocation().getFirst());

        final Movement ballCarrierInitialMovement = ballCarrier.getPreviousMovement(TARGET_POLL_MAX);
        Vector ballCarrierPredictedMovement = new Vector(ballCarrierInitialMovement.getStartingLocation(), ballCarrier.getLocation());
//            If there is no ballCarrier Movement History, we assume the ball carrier is going towards the
//            Endzone that we are "defending". This means, we assume a Y movement towards us.
        if(ballCarrierPredictedMovement.getMagnitude() == 0 || ballCarrierPredictedMovement.getMagnitude() == Double.POSITIVE_INFINITY){
            ballCarrierPredictedMovement = new Vector(new Tuple2<>(hostPlayer.getLocation().getFirst() > ballCarrier.getLocation().getFirst() ? -1.0 : 1.0, 0.0));
        }

        ballCarrierPredictedMovement = ballCarrierPredictedMovement.scale(changeX / ballCarrierPredictedMovement.getMagnitude());
        ballCarrierPredictedMovement = ballCarrierPredictedMovement.scale(targetRatio);

        if(Math.abs(hostPlayer.getLocation().getFirst() - ballCarrier.getLocation().getFirst()) <= 15){
            return ballCarrier.getLocation();
        }

        if(!targetResetSwitch) targetRatio /= DIVISOR_TARGET;
        if(targetRatio < ENDING_TARGET_DISTANCE){
            targetRatio = 1;
            targetResetSwitch = true;
        }

        return new Tuple2<>(ballCarrier.getLocation().getFirst() + ballCarrierPredictedMovement.getChangeX(), ballCarrier.getLocation().getSecond() + ballCarrierPredictedMovement.getChangeY());
    }

    @Override
    public List<PlayerInfluence> getInfluences(GamePlayer hostPlayer, GameField field) {
        return null;
    }
}