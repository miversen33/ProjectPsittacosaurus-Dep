package PhysicsEngine;

public enum BallCarrierState {

    DOWN ("Down"),
    UP   ("Up");

    private final String tag;

    BallCarrierState(final String s){
        tag = s;
    }

    public final boolean isUp(){
        return IsUp(tag);
    }

    public final boolean isDown(){
        return IsDown(tag);
    }

    private static final boolean IsUp(final String s){
        return s.equals(UP.tag);
    }

    private static final boolean IsDown(final String s){
        return s.equals(DOWN.tag);
    }

    public static final BallCarrierState Parse(final String s){
        if(IsUp(s)) return UP;
        if(IsDown(s)) return DOWN;
//        Handle logging due to invalid String being passed to parse
//        return null
        return null;
    }
}
