package PhysicsEngine.PhysicsObjects;

import Tuple.Tuple2;
import Utils.Location;

/**
 * Is this really the best place to do this?
 * TODO
 */
final class Line{
    private final Tuple2<Double, Double> startingPoint;
    private final Tuple2<Double, Double> endingPoint;

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
    
    Line(final Tuple2<Double, Double> start, final Tuple2<Double, Double> end){
        startingPoint = start;
        endingPoint = end;
    }

    final Tuple2<Double, Double> doesIntersect(final Line line){
        final Orientation firstLineFirstHalf = FindOrientation(startingPoint, endingPoint, line.endingPoint);
        final Orientation firstLineSecondHalf = FindOrientation(startingPoint, endingPoint, line.startingPoint);
        final Orientation secondLineFirstHalf = FindOrientation(line.startingPoint, line.endingPoint, startingPoint);
        final Orientation secondLineSecondHalf = FindOrientation(line.startingPoint, line.endingPoint, endingPoint);

        double intX;
        double intY;

        if(firstLineFirstHalf == Orientation.COLLINEAR &&
           firstLineSecondHalf == Orientation.COLLINEAR &&
           secondLineFirstHalf == Orientation.COLLINEAR &&
           secondLineSecondHalf == Orientation.COLLINEAR){
            final Tuple2<Double, Double> point = handleCollinearFirstIntersection(line);
            intX = point.getFirst();
            intY = point.getSecond();
        } else {
//        if((FindOrientation(startingPoint, endingPoint, line.endingPoint) == FindOrientation(startingPoint, endingPoint, line.startingPoint)) &&
//                FindOrientation(line.startingPoint, line.endingPoint, startingPoint) == FindOrientation(line.startingPoint, line.endingPoint, endingPoint)) return null;

            double a1 = endingPoint.getSecond() - startingPoint.getSecond();
            double b1 = startingPoint.getFirst() - endingPoint.getFirst();
            double c1 = a1 * startingPoint.getFirst() + b1 * startingPoint.getSecond();
            double a2 = line.endingPoint.getSecond() - line.startingPoint.getSecond();
            double b2 = line.startingPoint.getFirst() - line.endingPoint.getFirst();
            double c2 = a2 * line.startingPoint.getFirst() + b2 * line.startingPoint.getSecond();

            double denom = a1 * b2 - a2 * b2;

            intX = (b2 * c1 - b1 * c2) / denom;
            intY = (a1 * c2 - a2 * c1) / denom;
        }

        double rx0 = (intX - startingPoint.getFirst()) / (endingPoint.getFirst() - startingPoint.getFirst());
        double ry0 = (intY - startingPoint.getSecond()) / (endingPoint.getSecond() - startingPoint.getSecond());
        double rx1 = (intX - line.startingPoint.getFirst()) / (line.endingPoint.getFirst() - line.startingPoint.getFirst());
        double ry1 = (intY - line.startingPoint.getSecond()) / (line.endingPoint.getSecond() - line.startingPoint.getSecond());

        if(((rx0 >= 0 && rx0 <= 1) || (ry0 >= 0 && ry0 <= 1)) &&
                ((rx1 >= 0 && rx1 <= 1) || (ry1 >= 0 && ry1 <= 1))) {
            return new Tuple2<>(intX, intY);
        } else {
            return null;
        }
    }

    private final Tuple2<Double, Double> handleCollinearFirstIntersection(final Line line){
        Vector v = new Vector(startingPoint, endingPoint);
        double d = Location.GetDistance(startingPoint, line.startingPoint);
        v = v.scale((d/2) / v.getMagnitude());
        return new Tuple2<>(startingPoint.getFirst() + v.getChangeX(), startingPoint.getSecond() + v.getChangeY());
    }
}
