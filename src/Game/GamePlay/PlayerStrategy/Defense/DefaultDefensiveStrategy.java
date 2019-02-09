package Game.GamePlay.PlayerStrategy.Defense;

import Game.*;
import Game.Field.FieldObject;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluences;
import PhysicsEngine.Vector;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Utils.Location;

import java.util.List;

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
//        Should check the player state and determine if we are currently
//        being blocked. If we are, we should engage in block shedding,
//        as opposed to tackle targeting

        move = new MovementInstruction(hostPlayer, new Vector(new Tuple2<>(0.0, - hostPlayer.getMaxMovement())));
//        targetPoint = calculateGoal(hostPlayer, field, null);
//        final Vector movement = new Vector(new Tuple2<>(targetPoint.getFirst() - hostPlayer.getLocation().getFirst(), targetPoint.getSecond() - hostPlayer.getLocation().getSecond()));
//
//        move = new MovementInstruction(hostPlayer, movement);
    }

    @Override
    public final MovementInstruction getMove() {
        return move;
    }

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {
//        Calculates the target needed for the defender
        FieldObject ballCarrier = hostPlayer.getBallCarrier();
//        We need to handle if we are "down". If we are down we should try to get back up, instead of
//        staying down and hoping the game gets you up
        if(targetPoint != null && cacheBallCarrierLocation != null && Location.GetDistance(ballCarrier.getLocation(), cacheBallCarrierLocation) <= TARGET_RADIUS) return targetPoint;
        cacheBallCarrierLocation = ballCarrier.getLocation();

        Vector ballCarrierPredictedMovement = new Vector(new Tuple2<>(cacheBallCarrierLocation.getFirst() - ballCarrier.getPreviousLocation(TARGET_POLL_MAX).getFirst(),
                ballCarrier.getLocation().getSecond() - ballCarrier.getPreviousLocation(TARGET_POLL_MAX).getSecond()));
        if(ballCarrierPredictedMovement.getLength() == 0){
//            If there is no ballCarrier Movement History, we assume the ball carrier is going towards the
//            Endzone that we are "defending". This means, we assume a Y movement towards us.
            ballCarrierPredictedMovement.add(new Vector(new Tuple2<>(0.0, hostPlayer.getLocation().getSecond() > ballCarrier.getLocation().getSecond() ? 1.0 : -1.0)));
        }
        ballCarrierPredictedMovement = ballCarrierPredictedMovement.scale(TARGET_FEET/ballCarrierPredictedMovement.getLength());

//        This needs some better logic here, instead of just narrowing down the target by 1 every step
        if(TARGET_FEET > 1 ) TARGET_FEET -=1 ;

        return new Tuple2<>(ballCarrier.getLocation().getFirst() + ballCarrierPredictedMovement.getChangeX(), ballCarrier.getLocation().getSecond() + ballCarrierPredictedMovement.getChangeY());
    }

    @Override
    public List<PlayerInfluences> getInfluences(GamePlayer hostPlayer, GameField field) {
        return null;
    }
}