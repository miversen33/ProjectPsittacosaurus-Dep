package Game.Field;

public enum PlayerLocationState {

    OutOfBounds,
    FieldOfPlay_Endzone,
    FieldOfPlay;

    public final boolean isOutOfBounds(){
        return this.equals(OutOfBounds);
    }

    public final boolean isInFieldOfPlay(){
        return !isOutOfBounds();
    }

    public final boolean isInEndzone(){
        return this.equals(FieldOfPlay_Endzone);
    }
}
