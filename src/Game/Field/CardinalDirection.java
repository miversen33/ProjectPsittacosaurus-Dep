package Game.Field;

public enum CardinalDirection {
    NORTH (-1),
    SOUTH (1),
    EAST  (1),
    WEST  (-1);

    private final int movementAxisModifier;

    CardinalDirection(final int movementModifier){
        movementAxisModifier = movementModifier;
    }

    public final int getMovementAxisModifier(){
        return movementAxisModifier;
    }

    public final boolean isNorth(){ return this.equals(NORTH); }
    public final boolean isSouth(){ return this.equals(SOUTH); }
    public final boolean isEast(){ return this.equals(EAST); }
    public final boolean isWest(){ return this.equals(WEST); }
    public final boolean isHorizontal(){ return isEast() || isWest(); }
    public final boolean isVertical(){ return isNorth() || isSouth(); }

}
