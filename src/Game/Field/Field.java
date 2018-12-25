package Game.Field;

import Tuple.Tuple2;

public class Field{

    public static final double ENDZONE_HEIGHT = 30.0;
    public static final double FIELD_WIDTH    = 160.0;
    public static final double FIELD_HEIGHT   = 360.0;

    private final double leftBoundary   = 0.0;
    private final double topBoundary    = 0.0;
    private final double rightBoundary  = leftBoundary + FIELD_WIDTH;
    private final double bottomBoundary = topBoundary + FIELD_HEIGHT;

    public final PlayerLocationState getLocationState(final Location location){
        if(!isInBounds(location)) return PlayerLocationState.OutOfBounds;
        if(isInEndzone(location)) return PlayerLocationState.FieldOfPlay_Endzone;
        return PlayerLocationState.FieldOfPlay;
    }

    public final boolean isInBounds(final Location location){
        return location.getX() > leftBoundary && location.getX() < rightBoundary &&
               location.getY() > topBoundary  && location.getY() < bottomBoundary;
    }

    public final boolean isInNorthEndzone(final Location location){
        return location.getY() >= topBoundary && location.getY() <= topBoundary + ENDZONE_HEIGHT;
    }

    public final boolean isInSouthEndzone(final Location location){
        return location.getY() >= bottomBoundary - ENDZONE_HEIGHT && location.getY() <= bottomBoundary;
    }

    public final boolean isInEndzone(final Location location){
        return isInNorthEndzone(location) || isInSouthEndzone(location);
    }

//    This will return the top left corner of the north endzone
    public final Tuple2<Double, Double> getNorthEndzone(){
        return new Tuple2<>(1.0,1.0);
    }

//    This will return the bottom left corner of the south endzone
    public final Tuple2<Double, Double> getSouthEndzone(){
        return new Tuple2<>(1.0, bottomBoundary - 1);
    }
}