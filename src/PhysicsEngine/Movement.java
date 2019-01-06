package PhysicsEngine;

import Game.Field.Vector;
import Tuple.Tuple2;

public final class Movement {

    private final Tuple2<Double, Double> startingLocation;
    private final Tuple2<Double, Double> endingLocation;
//    private final Vector movement;

    public Movement(final Tuple2<Double, Double> startingLocation, final Tuple2<Double, Double> endingLocation){
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
    }

    public final Tuple2<Double, Double> getStartingLocation(){
        return startingLocation;
    }

    public final Tuple2<Double, Double> getEndingLocation(){
        return endingLocation;
    }

//    public final Vector getMovement(){
//        return movement;
//    }
}
