package Game.Field.StateMachine;

import Utils.StateMachines.State;
import Utils.StateMachines.Transition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FieldObjectTransitions{

    public final static String TO_OUT_OF_BOUNDS = "Out Of Bounds";
    public final static String TO_ENDZONE       = "Endzone";
    public final static String TO_INBOUNDS      = "In Bounds";

    private final static Transition toOutOfBounds = new Transition(TO_OUT_OF_BOUNDS, FieldObjectState.OutOfBounds, FieldObjectState.FieldOfPlay, true);
    private final static Transition toEndzone = new Transition(TO_ENDZONE, FieldObjectState.OutOfBounds, FieldObjectState.Endzone, true);
    private final static Transition toInBounds = new Transition(TO_INBOUNDS, FieldObjectState.Endzone, FieldObjectState.FieldOfPlay, true);

    private static final List<Transition> transitions = Arrays.asList(
            toEndzone,
            toOutOfBounds,
            toInBounds
    );

    public final static List<Transition> GetTransitions(){
        return new ArrayList<>(transitions);
    }

    public final static String GetTransition(final State currentState){
        for(final Transition transition : transitions){
            if(transition.isValidState(currentState)) return transition.getTransition();
        }
//        TODO Handle logging
        System.out.println("Unable to find transition for State("+currentState+")");
        return "";
    }

}
