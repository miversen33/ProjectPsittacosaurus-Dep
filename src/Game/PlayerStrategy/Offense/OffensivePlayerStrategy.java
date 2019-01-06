package Game.PlayerStrategy.Offense;

import Game.PlayerStrategy.IPlayerStrategy;
import Tuple.Tuple2;

public abstract class OffensivePlayerStrategy implements IPlayerStrategy {

    private final double baseAvoidance;
    private final double baseCushion;

    public OffensivePlayerStrategy(){
        baseAvoidance = Double.NEGATIVE_INFINITY;
        baseCushion = Double.NEGATIVE_INFINITY;
    }

    public OffensivePlayerStrategy(final double avoidance, final double cushion){
        if(avoidance == Double.NEGATIVE_INFINITY || cushion == Double.NEGATIVE_INFINITY){
            throw new RuntimeException("Cannot pass Infinity as parameter");
        }
        baseAvoidance = avoidance;
        baseCushion = cushion;
    }

//        There is very likely a much cleaner way to do this whole method. Consider coming back to that later
    final double calculateAngleOfMove(final Tuple2<Double, Double> defenderLocation, final Tuple2<Double, Double> hostLocation,
                                      final double maxDefenderDistance, final double influenceDistanceModifier){
        if(baseAvoidance == Double.NEGATIVE_INFINITY || baseCushion == Double.NEGATIVE_INFINITY){
//            Handle correct logging of unsupported strategy implementation
            System.out.println("The child implementation of OffensivePlayerStrategy does not support this operation");
            return 0;
        }
        double avoidance = Math.abs(defenderLocation.getFirst() - hostLocation.getFirst()) <= baseAvoidance ? baseAvoidance : baseCushion;
        if(defenderLocation.getFirst() > hostLocation.getFirst()) avoidance *= -1;
        double a = Math.sqrt((Math.pow(defenderLocation.getFirst()-hostLocation.getFirst(),2) + Math.pow(defenderLocation.getSecond() - hostLocation.getSecond(),2)));
        double b = Math.sqrt((Math.pow((defenderLocation.getFirst()+avoidance)-hostLocation.getFirst(),2) + Math.pow(defenderLocation.getSecond() - hostLocation.getSecond(),2)));
        double c = Math.abs(avoidance);
//        This will essentially correct the angle to go the right way, if the defender is to the right of the player
        int angleCorrection = defenderLocation.getFirst() <= hostLocation.getFirst() ? 1 : -1;

        double theta = Math.acos((a*a + b*b - c*c) / (2*a*b)) * angleCorrection;
//                We need to determine which side of the field is desirable for this, and then allow the influence to guide us to it
        theta = ((theta * ((maxDefenderDistance - a)/(maxDefenderDistance - 1))) * influenceDistanceModifier);
        return theta;
    }

}
