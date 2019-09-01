package Game.Field;

import Tuple.Tuple2;

public enum Endzone {
    NORTH(CardinalDirection.NORTH, new Tuple2<>(Field.WEST_BOUNDARY, Field.EAST_BOUNDARY), new Tuple2<>(Field.NORTH_BOUNDARY, Field.ENDZONE_HEIGHT)),
    SOUTH(CardinalDirection.SOUTH, new Tuple2<>(Field.WEST_BOUNDARY, Field.EAST_BOUNDARY), new Tuple2<>(Field.SOUTH_BOUNDARY - Field.ENDZONE_HEIGHT, Field.SOUTH_BOUNDARY));

    private final CardinalDirection direction;
    private final Tuple2<Double, Double> xRange;
    private final Tuple2<Double, Double> yRange;

    Endzone(final CardinalDirection direction, final Tuple2<Double, Double> xRange, final Tuple2<Double, Double> yRange){
        this.direction = direction;
        this.xRange = xRange;
        this.yRange = yRange;
    }

    public final boolean contains(final Tuple2<Double, Double> location){
        return ((xRange.getFirst() <= location.getFirst() && xRange.getSecond() >= location.getFirst()) &&
                (yRange.getFirst() <= location.getSecond() && yRange.getSecond() >= location.getSecond()));
    }

    public final Endzone getOpposite(){
        return this == NORTH ? SOUTH : NORTH;
    }
    public final CardinalDirection getCardinalDirection(){
        return direction;
    }
    public final boolean isNorth(){ return this.equals(NORTH); }
    public final boolean isSouth(){ return this.equals(SOUTH); }

    public final Tuple2<Double, Double> getGoalLocation(final FieldObject player){
        if(this == NORTH) return new Tuple2<>(player.getLocation().getFirst(), Field.ENDZONE_HEIGHT);
        else return new Tuple2<>(player.getLocation().getFirst(), Field.FIELD_HEIGHT-Field.ENDZONE_HEIGHT);
    }
}
