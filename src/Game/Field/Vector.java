package Game.Field;

import Observable.Observable;

public class Vector extends Observable {

    private double magnitude;
    private double direction;
    private Location location;

    public Vector(final Location location){
        this.location = location;
        calculateChangeByPoint();
    }

    public Vector(final double direction, final double magnitude){
        this.direction = direction;
        this.magnitude = magnitude;
        calculateChangeByDirection();
    }

    private final void calculateChangeByPoint(){
        magnitude = Math.sqrt((Math.pow(location.getX(),2)+Math.pow(location.getY(),2)));
        direction = Math.atan2(location.getY(),location.getX());
    }

    private final void calculateChangeByDirection(){
        location = new Location(magnitude * Math.cos(direction), magnitude * Math.sin(direction));
    }

    public final void add(final Vector vector){
        location = new Location(location.getX() + vector.location.getX(), location.getY() + vector.location.getY());
        calculateChangeByPoint();
        updateObservers();
    }

    public final double getChangeX(){
        return location.getX();
    }

    public final double getChangeY(){
        return location.getY();
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