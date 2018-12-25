package FieldDep;

public enum FieldCellState {

    NORTH_ENDZONE ("North Endzone"),
    GAME_FIELD    ( "Game Field"),
    SOUTH_ENDZONE ("South Endzone");

    private final String tag;

    FieldCellState(final String tag){
        this.tag = tag;
    }

    public final boolean isEndzone(){
        return isNorthEndzone() || isSouthEndzone();
    }

    public final boolean isGameField(){
        return tag.equals(GAME_FIELD.tag);
    }

    public final boolean isNorthEndzone(){
        return tag.equals(NORTH_ENDZONE.tag);
    }

    public final boolean isSouthEndzone(){
        return tag.equals(SOUTH_ENDZONE.tag);
    }

    @Override
    public String toString() {
        return tag;
    }

    public static final FieldCellState parse(final String type){
        FieldCellState state = null;
        if(type.equals(NORTH_ENDZONE.tag)) state = NORTH_ENDZONE;
        if(type.equals(GAME_FIELD.tag)) state = GAME_FIELD;
        if(type.equals(SOUTH_ENDZONE.tag)) state = SOUTH_ENDZONE;
        if(state == null){
//            Handle logging due to invalid type being passed
        }
        return state;
    }
}
