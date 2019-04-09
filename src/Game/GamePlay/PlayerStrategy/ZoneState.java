package Game.GamePlay.PlayerStrategy;

public enum ZoneState {
    EMPTY,
    APPROACHING,
    FULL;

    public final boolean isEmpty(){
        return this.equals(EMPTY);
    }

    public final boolean isApproaching(){
        return this.equals(APPROACHING);
    }

    public final boolean isFull(){
        return this.equals(FULL);
    }
}
