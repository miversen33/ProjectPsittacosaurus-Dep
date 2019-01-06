package Game.Field;

import Observable.Observable;
import Tuple.Tuple2;

public class Vector extends Observable {

    private double magnitude;
    private double direction;
    private Tuple2<Double, Double> changeInXY;

    public Vector(final Tuple2<Double, Double> changeInXY){
        this.changeInXY = changeInXY;
        calculateChangeByPoint();
    }

    public Vector(final double direction, final double magnitude){
        this.direction = direction;
        this.magnitude = magnitude;
        calculateChangeByDirection();
    }

    private final void calculateChangeByPoint(){
        magnitude = Math.sqrt((Math.pow(changeInXY.getFirst(),2)+Math.pow(changeInXY.getSecond(),2)));
        direction = Math.atan2(changeInXY.getSecond(),changeInXY.getFirst());
    }

    private final void calculateChangeByDirection(){
        changeInXY = new Tuple2<>(magnitude * Math.cos(direction), magnitude * Math.sin(direction));
    }

    public final void add(final Vector vector){
        changeInXY = new Tuple2<>(changeInXY.getFirst() + vector.changeInXY.getFirst(), changeInXY.getSecond() + vector.changeInXY.getSecond());
        calculateChangeByPoint();
        updateObservers(Location.LocationKey.LOCATION_VECTOR_KEY, this);
    }

    public final void scale(final double scalar){
        changeInXY = new Tuple2<>(changeInXY.getFirst() * scalar, changeInXY.getSecond() * scalar);
        calculateChangeByPoint();
    }

    public final double getChangeX(){
        return changeInXY.getFirst();
    }

    public final double getChangeY(){
        return changeInXY.getSecond();
    }

    public final double getDirection(){
        return direction;
    }

    public final double getAngle(){
        return direction;
    }

    public final double getLength(){
        return magnitude;
    }

    public final double getMagnitude(){
        return magnitude;
    }

}