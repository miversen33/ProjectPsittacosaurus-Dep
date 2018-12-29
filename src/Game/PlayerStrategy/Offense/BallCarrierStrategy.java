package Game.PlayerStrategy.Offense;

import Game.Field.Location;
import Game.Field.Vector;
import Game.GameField;
import Game.GamePlayer;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

import java.util.List;

public class BallCarrierStrategy extends OffensivePlayerStrategy {

    private MovementInstruction move = null;
    private int MAX_DISTANCE = 45;
    private final static double DEFAULT_AVOIDANCE = 6;
    private final static double DEFAULT_AVOIDANCE_CUSHION = 15;
    private final static double DEFAULT_AVOIDANCE_INFLUENCE = 1;
    private final static double DEFAULT_CUSHION_INFLUENCE = .5;

    public BallCarrierStrategy() {
//        Consider having the defaults be provided so that every player has a "custom" strategy as they progress
        super(DEFAULT_AVOIDANCE, DEFAULT_AVOIDANCE_CUSHION);
    }

    @Override
    public void calculateMove(final GamePlayer hostPlayer, final GameField field) {
//        This should be polled from the host player
        final double velocity = hostPlayer.getGoal().getSecond() < hostPlayer.getLocation().getSecond() ? -1 : +1;
        move = new MovementInstruction(hostPlayer, new Vector(new Location(0, velocity)));

        final List<GamePlayer> defendersInRange = field.getPlayersInLocation(new Location(hostPlayer.getLocation().getFirst(), hostPlayer.getLocation().getSecond()), MAX_DISTANCE);
        defendersInRange.remove(hostPlayer);
        if(defendersInRange.size() > 0){
            handleDefenders(hostPlayer, defendersInRange);
        }
    }

//    Please remove the host player from the list
    private final void handleDefenders(final GamePlayer hostPlayer, final List<GamePlayer> defenders){
        double angle = 0;
        for(GamePlayer defender : defenders){

//            For now disregard the current defender if the defender is not between the ballcarrier
//            and the goal. This will be corrected at a later point when we have more
//            stuff to work with
            if((hostPlayer.getGoal().getSecond() < hostPlayer.getLocation().getSecond() && hostPlayer.getLocation().getSecond() < defender.getLocation().getSecond()) ||
               (hostPlayer.getGoal().getSecond() > hostPlayer.getLocation().getSecond() && hostPlayer.getLocation().getSecond() > defender.getLocation().getSecond())){
                continue;
            }
            if(Math.abs(hostPlayer.getLocation().getFirst() - defender.getLocation().getFirst()) >= DEFAULT_AVOIDANCE_CUSHION) continue;
            double influence = Math.abs(hostPlayer.getLocation().getFirst() - defender.getLocation().getFirst()) <= DEFAULT_AVOIDANCE ? DEFAULT_AVOIDANCE_INFLUENCE : DEFAULT_CUSHION_INFLUENCE;
            double tAngle = calculateAngleOfMove(defender.getLocation(), hostPlayer.getLocation(), MAX_DISTANCE, influence);
            angle += tAngle;
        }
        Vector movement = new Vector(move.getVector().getDirection()+angle, move.getVector().getMagnitude());
        move = new MovementInstruction(hostPlayer, movement);
    }

    @Override
    public MovementInstruction getMove() {
        return move;
    }
}
