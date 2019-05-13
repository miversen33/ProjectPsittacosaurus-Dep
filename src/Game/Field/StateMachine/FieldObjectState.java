package Game.Field.StateMachine;

import Utils.StateMachines.State;

public final class FieldObjectState extends State {

    public final static String OUT_OF_BOUNDS = "Out Of Bounds";
    public final static String IN_BOUNDS     = "In Bounds";
    public final static String IN_ENDZONE    = "In Endzone";

    public final static FieldObjectState OutOfBounds = new FieldObjectState(OUT_OF_BOUNDS);
    public final static FieldObjectState Endzone = new FieldObjectState(IN_ENDZONE);
    public final static FieldObjectState InBounds = new FieldObjectState(IN_BOUNDS);

    private FieldObjectState(final String newState) {
        super(newState);
    }

    public final boolean isOutOfBounds(){
        return this.equals(OutOfBounds);
    }

    public final boolean isInFieldOfPlay(){
        return !isOutOfBounds();
    }

    public final boolean isInEndzone(){
        return this.equals(Endzone);
    }
}
