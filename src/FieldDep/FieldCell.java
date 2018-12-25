package FieldDep;

import Game.GamePlayer;

import java.util.HashMap;
import java.util.Map;

public class FieldCell {

//    Replace with tuple getter
    public final int x;
    public final int y;
    private final FieldCellState mState;

    private GamePlayer occupier;

    private final Map<Object, Double> resistanceStates;

    public FieldCell(final int x, final int y, final FieldCellState state){
        this.x = x;
        this.y = y;
        mState = state;
        occupier = null;
        resistanceStates = new HashMap<>();
    }

    public final boolean isOccupied(){
        return occupier != null;
    }

    public final void occupy(final GamePlayer occupie){
        occupier = occupie;
    }

    public final void addResistanceState(final Object resistanceState, final Double resistanceValue){
        if(resistanceStates.containsKey(resistanceState)){
            resistanceStates.put(resistanceState, resistanceStates.get(resistanceState) + resistanceValue);
        } else {
            resistanceStates.put(resistanceState, resistanceValue);
        }
    }

    public final FieldCellState getCellState(){
        return mState;
    }

    public final GamePlayer getOccupier(){
//      I dont know how I feel about this
        return occupier;
    }


}
