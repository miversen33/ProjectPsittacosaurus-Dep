package Utils;

import PhysicsEngine.Vector;
import Tuple.Tuple2;

public final class GeometricLine {

//    Eww, figure out where we belong
//    TODO
    public final static Tuple2<Double, Double> DoVectorsIntersect(final Tuple2<Double, Double> firstStartPoint, final Tuple2<Double, Double> secondStartPoint, final Vector firstVector, final Vector secondVector){
        final Line firstLine = new Line(firstStartPoint, new Tuple2<>(firstStartPoint.getFirst() + firstVector.getChangeX(), firstStartPoint.getSecond() + firstVector.getChangeY()));
        final Line secondLine = new Line(secondStartPoint, new Tuple2<>(secondStartPoint.getFirst() + secondVector.getChangeX(), secondStartPoint.getSecond() + secondVector.getChangeY()));

        return firstLine.doesIntersect(secondLine);
    }

}
