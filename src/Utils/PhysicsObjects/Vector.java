package Utils.PhysicsObjects;

import Observable.Observable;
import Tuple.Tuple2;
import Utils.Shapes.Line;

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

    public Vector(final Tuple2<Double, Double> startingLocation, final Tuple2<Double, Double> endingLocation){
        this(new Tuple2<>(endingLocation.getFirst() - startingLocation.getFirst(), endingLocation.getSecond() - startingLocation.getSecond()));
    }

    private final void calculateChangeByPoint(){
        magnitude = Math.sqrt((Math.pow(changeInXY.getFirst(),2)+Math.pow(changeInXY.getSecond(),2)));
        direction = Math.atan2(changeInXY.getSecond(),changeInXY.getFirst());
    }

    private final void calculateChangeByDirection(){
        changeInXY = new Tuple2<>(magnitude * Math.cos(direction), magnitude * Math.sin(direction));
    }

    /**
     * NOTICE! THIS DOES NOT ACTUALLY CHANCE THE VECTOR, RATHER IT RETURNS A NEW VECTOR THAT
     * IS A COPY OF THIS ONE, BUT WITH THE OTHER VECTOR ADDED TO IT!
     */
    public final Vector add(final Vector vector){
        return new Vector(new Tuple2<>(vector.getChangeX() + getChangeX(), vector.getChangeY() + getChangeY()));
    }

    /**
     * NOTICE! THIS DOES NOT ACTUALLY CHANGE THE VECTOR, RATHER IT RETURNS A NEW VECTOR THAT
     * IS A COPY OF THIS ONE, BUT SCALED
     */
    public final Vector scale(final double scale){
        return new Vector(new Tuple2<>(changeInXY.getFirst() * scale, changeInXY.getSecond() * scale));
    }

    public final double getChangeX(){
        return changeInXY.getFirst();
    }

    public final double getChangeY(){
        return changeInXY.getSecond();
    }

    public final Double getDirection(){
        return direction;
    }

    public final Double getAngle(){
        return direction;
    }

    public final Double getLength(){
        return magnitude;
    }

    public final Double getMagnitude(){
        return magnitude;
    }

    /**
     * This will return the vector in tuple2 form, with ChangeX and ChangeY as the values
     */
    public final Tuple2<Double, Double> getVectorAsTuple2(){
        return new Tuple2<>(getChangeX(), getChangeY());
    }

    public final Vector getInverse(){
        return new Vector(direction-Math.PI, magnitude);
    }

    public final static Tuple2<Double, Double> GetVectorIntersectionPoint(final Tuple2<Double, Double> firstStartPoint, final Tuple2<Double, Double> secondStartPoint, final Vector firstVector, final Vector secondVector) {
        final Line firstLine = new Line(firstStartPoint, new Tuple2<>(firstStartPoint.getFirst() + firstVector.getChangeX(), firstStartPoint.getSecond() + firstVector.getChangeY()));
        final Line secondLine = new Line(secondStartPoint, new Tuple2<>(secondStartPoint.getFirst() + secondVector.getChangeX(), secondStartPoint.getSecond() + secondVector.getChangeY()));

        final Tuple2<Double, Double> intersect = firstLine.doesIntersect(secondLine);
        return intersect;
    }
}