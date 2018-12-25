package Game.Field;

import Observable.Observable;
import Tuple.Tuple2;

public final class Location extends Observable {

    public enum LocationKey{
        LOCATION_VECTOR_KEY,
        LOCATION_UPDATED_KEY
    }

    private double x;
    private double y;

    public Location(final double x, final double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public final void move(final Vector movement){
        this.x += movement.getChangeX();
        this.y += movement.getChangeY();
        updateObservers(LocationKey.LOCATION_VECTOR_KEY, movement);
        updateObservers(LocationKey.LOCATION_UPDATED_KEY, getLocation());
    }

    public final double getX(){
        return x;
    }

    public final double getY(){
        return y;
    }

    public final Tuple2<Double, Double> getLocation(){
        return new Tuple2<>(getX(), getY());
    }

    public final double getDistanceFromLocation(final Location compareLocation){
        return Math.sqrt((
                    Math.pow((compareLocation.getX()-getX()),2)+
                    Math.pow((compareLocation.getY()-getY()),2)));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Location) && !(obj instanceof Tuple2)) return false;
        if(obj instanceof Location){
            return ((Location) obj).getX() == getX() && ((Location) obj).getY() == getY();
        }
        if(obj instanceof Tuple2){
            return ((Tuple2) obj).getFirst().equals(getX()) && ((Tuple2) obj).getSecond().equals(getY());
        }
        return false;
    }
}
