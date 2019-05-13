package Utils;

import Game.Field.FieldObject;
import Utils.PhysicsObjects.Vector;
import Utils.Observable.Observable;
import Tuple.Tuple2;

public final class Location extends Observable<Tuple2<Double, Double>> {

    public enum LocationKey{
//        LOCATION_VECTOR_KEY,
        LOCATION_UPDATED_KEY
    }

    public final static double GetDistance(final Location primaryLocation, final Location secondaryLocation){
        return GetDistance(primaryLocation.getLocation(), secondaryLocation.getLocation());
    }

    public final static double GetDistance(final FieldObject primaryLocation, final FieldObject secondaryLocation){
        return GetDistance(primaryLocation.getLocation(), secondaryLocation.getLocation());
    }

    public final static double GetDistance(final Tuple2<Double, Double> primaryLocation, final Tuple2<Double, Double> secondaryLocation){
        return Math.sqrt(Math.pow(secondaryLocation.getFirst()-primaryLocation.getFirst(),2) + Math.pow(secondaryLocation.getSecond()-primaryLocation.getSecond(),2));
    }

    private double x;
    private double y;

    public Location(final double x, final double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Location(final Tuple2<Double, Double> location){
        super();
        this.x = location.getFirst();
        this.y = location.getSecond();
    }

    public final void move(final Vector movement){
        this.x += movement.getChangeX();
        this.y += movement.getChangeY();
//        updateObservers(LocationKey.LOCATION_VECTOR_KEY, this);
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

    @Override
    public final String toString(){
        return getLocation().toString();
    }

    @Override
    public final boolean equals(Object obj) {
        if(obj instanceof Location){
            return ((Location) obj).getX() == getX() && ((Location) obj).getY() == getY();
        }
        if(obj instanceof Tuple2){
            return ((Tuple2) obj).getFirst().equals(getX()) && ((Tuple2) obj).getSecond().equals(getY());
        }
        return super.equals(obj);
    }
}
