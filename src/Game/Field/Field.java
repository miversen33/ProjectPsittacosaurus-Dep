package Game.Field;

import Tuple.Tuple2;
import Utils.Location;

public class Field{

    public static final double ENDZONE_HEIGHT = 30.0;
    public static final double REDZONE_HEIGHT = 20.0;
    public static final double FIELD_WIDTH    = 160.0;
    public static final double FIELD_HEIGHT   = 360.0;
    public static final double FIELD_LEFT_CENTER = ((FIELD_WIDTH/2) - (FIELD_WIDTH * .15));
    public static final double FIELD_RIGHT_CENTER = ((FIELD_WIDTH/2) + (FIELD_WIDTH * .15));

    private static final Tuple2<Double, Double> NORTH_ENDZONE_LOCATION = new Tuple2<>(FIELD_WIDTH/2,ENDZONE_HEIGHT-1);
    private static final Tuple2<Double, Double> SOUTH_ENDZONE_LOCATION = new Tuple2<>(FIELD_WIDTH/2,FIELD_HEIGHT-ENDZONE_HEIGHT+1);

    private final static double LeftBoundary = 0.0;
    private final static double TopBoundary = 0.0;
    private final static double RightBoundary = LeftBoundary + FIELD_WIDTH;
    private final static double BottomBoundary = TopBoundary + FIELD_HEIGHT;

    public enum Side{
        LEFT,
        RIGHT;

        public final boolean isRight(){ return this.equals(RIGHT); }
        public final boolean isLeft(){ return this.equals(LEFT); }
    }


    public final static PlayerLocationState GetLocationState(final Location location){
        if(!IsInBounds(location)) return PlayerLocationState.OutOfBounds;
        if(IsInEndzone(location)) return PlayerLocationState.FieldOfPlay_Endzone;
        return PlayerLocationState.FieldOfPlay;
    }

    public final static boolean IsInBounds(final Location location){
        return location.getX() > LeftBoundary && location.getX() < RightBoundary &&
               location.getY() > TopBoundary && location.getY() < BottomBoundary;
    }

    public final static boolean IsInNorthEndzone(final Location location){
        return location.getY() >= TopBoundary && location.getY() <= TopBoundary + ENDZONE_HEIGHT;
    }

    public final static boolean IsInSouthEndzone(final Location location){
        return location.getY() >= BottomBoundary - ENDZONE_HEIGHT && location.getY() <= BottomBoundary;
    }

    public final static boolean IsInEndzone(final Location location){
        return IsInNorthEndzone(location) || IsInSouthEndzone(location);
    }

    public final static boolean IsInBounds(final Tuple2<Double, Double> location){
        return location.getFirst() > LeftBoundary && location.getFirst() < RightBoundary &&
               location.getSecond() > TopBoundary && location.getSecond() < BottomBoundary;
    }

    public final static boolean IsInNorthEndzone(final Tuple2<Double, Double> location){
        return location.getSecond() >= TopBoundary && location.getSecond() <= TopBoundary + ENDZONE_HEIGHT;
    }

    public final static boolean IsInSouthEndzone(final Tuple2<Double, Double> location){
        return location.getSecond() >= BottomBoundary - ENDZONE_HEIGHT && location.getSecond() <= BottomBoundary;
    }

    public final static boolean IsInEndzone(final Tuple2<Double, Double> location){
        return IsInNorthEndzone(location) || IsInSouthEndzone(location);
    }

    public final static boolean IsInEndzone(final Endzone endzone, final FieldObject location){
        if(endzone.isNorth()) return IsInNorthEndzone(location.getLocation());
        if(endzone.isSouth()) return IsInSouthEndzone(location.getLocation());
//        Handle logging due to invalid endzone flag
        return false;
    }

    public final static Side GetSideOfField(final Tuple2<Double, Double> location){
        return location.getFirst() <= Field.FIELD_WIDTH/2 ? Side.LEFT : Side.RIGHT;
    }

//    This will return the top left corner of the north endzone
    public final static Endzone GetNorthEndzone(){
        return Endzone.NORTH;
    }

//    This will return the bottom left corner of the south endzone
    public final static Endzone GetSouthEndzone(){
        return Endzone.SOUTH;
    }

    public final static Tuple2<Double, Double> GetLocationForEndzone(final Endzone endzone){
        return endzone == Endzone.NORTH ? NORTH_ENDZONE_LOCATION : SOUTH_ENDZONE_LOCATION;
    }

    public final static double GetDistanceFromLeftSideLine(final FieldObject object){
        return object.getLocation().getFirst();
    }

    public final static double GetDistanceFromRightSideLine(final FieldObject object){
        return Field.FIELD_WIDTH - object.getLocation().getFirst();
    }

}