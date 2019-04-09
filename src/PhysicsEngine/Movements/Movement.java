package PhysicsEngine.Movements;

import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;

public final class Movement {

    private final Tuple2<Double, Double> startingLocation;
    private final Tuple2<Double, Double> endingLocation;
    private final Vector movement;
    private final int timeStamp;

    public Movement(final Tuple2<Double, Double> startingLocation, final Tuple2<Double, Double> endingLocation, final int time){
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.movement = new Vector(startingLocation, endingLocation);
        this.timeStamp = time;
    }

    public Movement(final Tuple2<Double, Double> startingLocation, final Vector movement, final int time){
        this.startingLocation = startingLocation;
        this.endingLocation = new Tuple2<>(startingLocation.getFirst() + movement.getChangeX(), startingLocation.getSecond() + movement.getChangeY());
        this.movement = movement;
        this.timeStamp = time;
    }

    public final Tuple2<Double, Double> getStartingLocation(){
        return startingLocation;
    }

    public final Tuple2<Double, Double> getEndingLocation(){
        return endingLocation;
    }

    public final Vector getMovement(){
        return movement;
    }

    public final int getTimeStamp(){
        return timeStamp;
    }
}
