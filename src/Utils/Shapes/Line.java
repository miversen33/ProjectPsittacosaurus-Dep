package Utils.Shapes;

import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;
import Utils.Location;

public final class Line{
    private final Tuple2<Double, Double> startingPoint;
    private final Tuple2<Double, Double> endingPoint;
    private final double slope;
    private final double yInt;

    private enum Orientation{
        COUNTERCLOCKWISE,
        COLLINEAR,
        CLOCKWISE
    }

    private final static Orientation FindOrientation(final Tuple2<Double, Double> point1, final Tuple2<Double, Double> point2, final Tuple2<Double, Double> point3){
        double slopeDiff = (point2.getSecond() - point1.getSecond()) * (point3.getFirst() - point2.getFirst())-
                (point2.getFirst()  - point1.getFirst()) *  (point3.getSecond() - point2.getSecond());
        if(slopeDiff == 0) return Orientation.COLLINEAR;
        return slopeDiff > 0 ? Orientation.CLOCKWISE : Orientation.COUNTERCLOCKWISE;
    }

    public Line(final Tuple2<Double, Double> start, final Tuple2<Double, Double> end){
        startingPoint = start;
        endingPoint = end;
        slope = (endingPoint.getSecond() - startingPoint.getSecond()) / (endingPoint.getFirst() - startingPoint.getFirst());
        yInt = startingPoint.getSecond() - (slope * startingPoint.getFirst());
    }

    public Line(final Tuple2<Double, Double> start, final Vector move){
        this(start, new Tuple2<>(start.getFirst() + move.getChangeX(), start.getSecond() + move.getChangeY()));
    }
//
//    public Line(final Tuple2<Double, Double> start, final double slope){
//        startingPoint = start;
//        endingPoint = null;
//        this.slope = slope;
//        yInt = startingPoint.getSecond() - (slope * startingPoint.getFirst());
//    }

    public final Tuple2<Double, Double> getStartingPoint(){
        return startingPoint;
    }

    public final double getSlope(){
        return slope;
    }

    public final double getYInt(){
        return yInt;
    }

    public final boolean containsPoint(final Tuple2<Double, Double> point){
        return
               ((startingPoint.getFirst() <= point.getFirst() && point.getFirst() <= endingPoint.getFirst()) ||
               (endingPoint.getFirst() <= point.getFirst() && point.getFirst() <= startingPoint.getFirst()))
                                                    &&
               ((startingPoint.getSecond() <= point.getSecond() && point.getSecond() <= endingPoint.getSecond()) ||
               (endingPoint.getSecond() <= point.getSecond() && point.getSecond() <= startingPoint.getSecond()))
        ;
    }

    public final Tuple2<Double, Double> doesIntersect(final Line line) {
        final Orientation firstLineFirstHalf = FindOrientation(startingPoint, endingPoint, line.endingPoint);
        final Orientation firstLineSecondHalf = FindOrientation(startingPoint, endingPoint, line.startingPoint);
        final Orientation secondLineFirstHalf = FindOrientation(line.startingPoint, line.endingPoint, startingPoint);
        final Orientation secondLineSecondHalf = FindOrientation(line.startingPoint, line.endingPoint, endingPoint);

        if (firstLineFirstHalf == Orientation.COLLINEAR &&
                firstLineSecondHalf == Orientation.COLLINEAR &&
                secondLineFirstHalf == Orientation.COLLINEAR &&
                secondLineSecondHalf == Orientation.COLLINEAR) {
            return handleCollinearFirstIntersection(line);

        } else {

            Double x = (line.getYInt() - getYInt())/(getSlope() - line.getSlope());
            Double y = ((line.getSlope()*getYInt()) - (getSlope()*line.getYInt()))/(line.getSlope()-getSlope());
            final Tuple2<Double, Double> interceptPoint = new Tuple2<>(x,y);

            if((x.isNaN() || x.isInfinite() || y.isNaN() || y.isInfinite()) ||
               (!line.containsPoint(interceptPoint) || !containsPoint(interceptPoint))) return null;
            return interceptPoint;
        }
    }

    private final Tuple2<Double, Double> handleCollinearFirstIntersection(final Line line){
        Vector v = new Vector(startingPoint, endingPoint);
        double d = Location.GetDistance(startingPoint, line.startingPoint);
        v = v.scale((d/2) / v.getMagnitude());
        final Tuple2<Double, Double> interceptPoint = new Tuple2<>(startingPoint.getFirst() + v.getChangeX(), startingPoint.getSecond() + v.getChangeY());
        if(containsPoint(interceptPoint) && line.containsPoint(interceptPoint)) return interceptPoint;
        return null;
    }
}
