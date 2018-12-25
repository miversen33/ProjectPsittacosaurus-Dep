package PhysicsEngine;

public enum MovementDirection {

    NORTH     ("North"),
    SOUTH     ("South"),
    EAST      ("East"),
    WEST      ("West"),
    NORTHEAST ("Northeast"),
    NORTHWEST ("Northwest"),
    SOUTHEAST ("Southeast"),
    SOUTHWEST ("Southwest");

    private final String tag;

    MovementDirection(final String s){
        tag = s;
    }

    public final boolean isNorth(){
        return tag.equals(NORTH.tag);
    }

    public final boolean isSouth(){
        return tag.equals(SOUTH.tag);
    }

    public final boolean isEast(){
        return tag.equals(EAST.tag);
    }

    public final boolean isWest(){
        return tag.equals(WEST.tag);
    }

    public final boolean isNorthWest(){
        return tag.equals(NORTHWEST.tag);
    }

    public final boolean isNorthEast(){
        return tag.equals(NORTHEAST.tag);
    }

    public final boolean isSouthWest(){
        return tag.equals(SOUTHWEST.tag);
    }

    public final boolean isSouthEast(){
        return tag.equals(SOUTHEAST.tag);
    }

    @Override
    public String toString() {
        return tag;
    }
}
