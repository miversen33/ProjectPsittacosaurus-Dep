package Utils.Shapes;

import Tuple.Tuple2;

public class Circle {
    private final double radius;
    private final double h;
    private final double k;

    public Circle(final Tuple2<Double, Double> center, final double radius){
        this(center.getFirst(), center.getSecond(), radius);
    }

    public Circle(final double x, final double y, final double radius){
        this.h = x;
        this.k = y;
        this.radius = radius;
    }

    public final double getRadius(){
        return radius;
    }

    public final double getX() {
        return h;
    }

    public final double getY(){
        return k;
    }

    public final Tuple2<Double, Double> getCenter(){
        return new Tuple2<>(h, k);
    }

//    TODO
//    If the line is infinite, we will calculate the line with no start/end points.
    public final Tuple2<Tuple2<Double, Double>, Tuple2<Double, Double>> doesLineIntersect(final Line line){
//           |-(2(m(b-k)-h) +/- sqrt((2(m(b-k)-h))^2 - 4((m^2)+1)(-2kb + b^2 + k^2 + h^2 - r^2))
//       x = |-------------------------------------------------------------------------
//           |                              (2a)

//           |-b +/- sqrt(b^2 - 4ac)
//       x = |----------------------
//           |         (2a)
        double a = (line.getSlope() * line.getSlope()) + 1;
        double b = 2 * (line.getSlope() * (line.getYInt() - k) - h);
        double c = -2 * k * line.getYInt() + (line.getYInt() * line.getYInt()) + k*k - radius*radius;

        double sqrt = (b*b) - (4*a*c);
        Double x1 = (-b + Math.sqrt(sqrt))/(2*a);
        Double x2 = (-b - Math.sqrt(sqrt))/(2*a);
        Double y1 = line.getSlope() * x1 + line.getYInt();
        Double y2 = line.getSlope() * x2 + line.getYInt();

        return new Tuple2<>(new Tuple2<>(x1, y1), new Tuple2<>(x2, y2));
    }
}
