package Game.Field;

import Game.StateMachine.FieldObjectState;
import Tuple.Tuple2;
import Game.Utils.Location;

//0,0 is Top Left Corner

public class Field{

    public static final double ENDZONE_HEIGHT = 30.0;
    public static final double REDZONE_HEIGHT = 20.0;
    public static final double FIELD_WIDTH    = 160.0;
    public static final double FIELD_HEIGHT   = 360.0;
    public static final double FIELD_LEFT_CENTER = ((FIELD_WIDTH/2) - (FIELD_WIDTH * .15));
    public static final double FIELD_RIGHT_CENTER = ((FIELD_WIDTH/2) + (FIELD_WIDTH * .15));

    private static final Tuple2<Double, Double> NORTH_ENDZONE_LOCATION = new Tuple2<>(FIELD_WIDTH/2,ENDZONE_HEIGHT-1);
    private static final Tuple2<Double, Double> SOUTH_ENDZONE_LOCATION = new Tuple2<>(FIELD_WIDTH/2,FIELD_HEIGHT-ENDZONE_HEIGHT+1);

    public final static double WEST_BOUNDARY = 0.0;
    public final static double NORTH_BOUNDARY = 0.0;
    public final static double EAST_BOUNDARY = WEST_BOUNDARY + FIELD_WIDTH;
    public final static double SOUTH_BOUNDARY = NORTH_BOUNDARY + FIELD_HEIGHT;

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
        return location.getX() > WEST_BOUNDARY && location.getX() < EAST_BOUNDARY &&
               location.getY() > NORTH_BOUNDARY && location.getY() < SOUTH_BOUNDARY;
    }

    public final static boolean IsInNorthEndzone(final Location location){
        return location.getY() >= NORTH_BOUNDARY && location.getY() <= NORTH_BOUNDARY + ENDZONE_HEIGHT;
    }

    public final static boolean IsInSouthEndzone(final Location location){
        return location.getY() >= SOUTH_BOUNDARY - ENDZONE_HEIGHT && location.getY() <= SOUTH_BOUNDARY;
    }

    public final static boolean IsInEndzone(final Location location){
        return IsInNorthEndzone(location) || IsInSouthEndzone(location);
    }

    public final static boolean IsInBounds(final Tuple2<Double, Double> location){
        return location.getFirst() > WEST_BOUNDARY && location.getFirst() < EAST_BOUNDARY &&
               location.getSecond() > NORTH_BOUNDARY && location.getSecond() < SOUTH_BOUNDARY;
    }

    public final static boolean IsInNorthEndzone(final Tuple2<Double, Double> location){
        return location.getSecond() >= NORTH_BOUNDARY && location.getSecond() <= NORTH_BOUNDARY + ENDZONE_HEIGHT;
    }

    public final static boolean IsInSouthEndzone(final Tuple2<Double, Double> location){
        return location.getSecond() >= SOUTH_BOUNDARY - ENDZONE_HEIGHT && location.getSecond() <= SOUTH_BOUNDARY;
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