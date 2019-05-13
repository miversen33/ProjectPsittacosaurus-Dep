package Game.Field;

import Game.Field.StateMachine.FieldObjectState;
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

    private final static double LEFT_BOUNDARY = 0.0;
    private final static double TOP_BOUNDARY = 0.0;
    private final static double RIGHT_BOUNDARY = LEFT_BOUNDARY + FIELD_WIDTH;
    private final static double BOTTOM_BOUNDARY = TOP_BOUNDARY + FIELD_HEIGHT;

    public enum Side{
        LEFT,
        RIGHT;

        public final boolean isRight(){ return this.equals(RIGHT); }
        public final boolean isLeft(){ return this.equals(LEFT); }
    }


    public final static FieldObjectState GetLocationState(final Location location){
        if(!IsInBounds(location)) return FieldObjectState.OutOfBounds;
        if(IsInEndzone(location)) return FieldObjectState.Endzone;
        return FieldObjectState.InBounds;
    }

    public final static boolean IsInBounds(final Location location){
        return location.getX() > LEFT_BOUNDARY && location.getX() < RIGHT_BOUNDARY &&
               location.getY() > TOP_BOUNDARY && location.getY() < BOTTOM_BOUNDARY;
    }

    public final static boolean IsInNorthEndzone(final Location location){
        return location.getY() >= TOP_BOUNDARY && location.getY() <= TOP_BOUNDARY + ENDZONE_HEIGHT;
    }

    public final static boolean IsInSouthEndzone(final Location location){
        return location.getY() >= BOTTOM_BOUNDARY - ENDZONE_HEIGHT && location.getY() <= BOTTOM_BOUNDARY;
    }

    public final static boolean IsInEndzone(final Location location){
        return IsInNorthEndzone(location) || IsInSouthEndzone(location);
    }

    public final static boolean IsInBounds(final Tuple2<Double, Double> location){
        return location.getFirst() > LEFT_BOUNDARY && location.getFirst() < RIGHT_BOUNDARY &&
               location.getSecond() > TOP_BOUNDARY && location.getSecond() < BOTTOM_BOUNDARY;
    }

    public final static boolean IsInNorthEndzone(final Tuple2<Double, Double> location){
        return location.getSecond() >= TOP_BOUNDARY && location.getSecond() <= TOP_BOUNDARY + ENDZONE_HEIGHT;
    }

    public final static boolean IsInSouthEndzone(final Tuple2<Double, Double> location){
        return location.getSecond() >= BOTTOM_BOUNDARY - ENDZONE_HEIGHT && location.getSecond() <= BOTTOM_BOUNDARY;
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