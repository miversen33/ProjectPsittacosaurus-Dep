package Game.Field;

public enum CardinalDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public final boolean isNorth(){ return this.equals(NORTH); }
    public final boolean isSouth(){ return this.equals(SOUTH); }
    public final boolean isEast(){ return this.equals(EAST); }
    public final boolean isWest(){ return this.equals(WEST); }

}
