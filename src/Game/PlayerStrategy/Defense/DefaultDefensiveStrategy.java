package Game.PlayerStrategy.Defense;

import Game.Field.Vector;
import Game.GameField;
import Game.GamePlayer;
import Game.IFieldObject;
import Game.IGamePlayerOwner;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

//This will be the "fallBack" strategy. This may be moved to DefensivePlayerStrategy instead, but for now its on its own.
public class DefaultDefensiveStrategy extends DefensivePlayerStrategy {

    private MovementInstruction move = null;
    private double TARGET_FEET = 10;
    private final int TARGET_POLL_MAX = 5;
    private Tuple2<Double, Double> targetPoint;
    private Tuple2<Double, Double> cacheBallCarrierLocation;
    private final int TARGET_RADIUS = 3;

    @Override
    public void calculateMove(final GamePlayer hostPlayer, final GameField field) {

        targetPoint = calculateGoal(hostPlayer, field, null);
        final Vector movement = new Vector(new Tuple2<>(targetPoint.getFirst() - hostPlayer.getLocation().getFirst(), targetPoint.getSecond() - hostPlayer.getLocation().getSecond()));

        move = new MovementInstruction(hostPlayer, movement);
    }

    @Override
    public MovementInstruction getMove() {
        return move;
    }

    @Override
    public Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam) {
//        Calculates the target needed for the defender
        IFieldObject ballCarrier = field.DEBUG_requestBallCarrierLocation();
        if(targetPoint != null && cacheBallCarrierLocation != null && calculateDistance(ballCarrier.getLocation(), cacheBallCarrierLocation) <= TARGET_RADIUS) return targetPoint;
        cacheBallCarrierLocation = ballCarrier.getLocation();

        final Vector ballCarrierPredictedMovement = new Vector(new Tuple2<>(cacheBallCarrierLocation.getFirst() - ballCarrier.getPreviousLocation(TARGET_POLL_MAX).getFirst(),
                ballCarrier.getLocation().getSecond() - ballCarrier.getPreviousLocation(TARGET_POLL_MAX).getSecond()));
        if(ballCarrierPredictedMovement.getLength() == 0){
//            If there is no ballCarrier Movement History, we assume the ball carrier is going towards the
//            Endzone that we are "defending". This means, we assume a Y movement towards us.
            ballCarrierPredictedMovement.add(new Vector(new Tuple2<>(0.0, hostPlayer.getLocation().getSecond() > ballCarrier.getLocation().getSecond() ? 1.0 : -1.0)));
        }
        ballCarrierPredictedMovement.scale(TARGET_FEET/ballCarrierPredictedMovement.getLength());

//        This needs some better logic here, instead of just narrowing down the target by 1 every step
        if(TARGET_FEET > 1 ) TARGET_FEET -=1 ;

        return new Tuple2<>(ballCarrier.getLocation().getFirst() + ballCarrierPredictedMovement.getChangeX(), ballCarrier.getLocation().getSecond() + ballCarrierPredictedMovement.getChangeY());
    }

//Find a home for this...?
    private final double calculateDistance(final Tuple2<Double, Double> startPoint, final Tuple2<Double, Double> endPoint){
        return Math.sqrt(Math.pow(endPoint.getFirst()-startPoint.getFirst(),2) + Math.pow(endPoint.getSecond()-startPoint.getSecond(),2));
    }
}