package PhysicsEngine;

import Tuple.Tuple2;

public final class PhysicsMath {

    public static double calculateVelocity(final Tuple2<Double, Double> startingPoint, final Tuple2<Double, Double> endingPoint, final double timeElapsed){
        return calculateDistance(startingPoint, endingPoint) / timeElapsed;
    }

    public static double calculateDistance(final Tuple2<Double, Double> firstPoint, final Tuple2<Double, Double> secondPoint){
        return Math.sqrt(Math.pow(secondPoint.getFirst() - firstPoint.getFirst(), 2) + Math.pow(secondPoint.getSecond()-firstPoint.getSecond(), 2));
    }
}
