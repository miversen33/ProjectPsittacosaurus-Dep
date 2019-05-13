package Game.Field.StateMachine;

import Utils.StateMachines.State;
import Utils.StateMachines.Transition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FieldObjectTransitions{

    public final static String OUT_OF_BOUNDS_TO_IN_BOUNDS = "Out Of Bounds to In Bounds";
    public final static String OUT_OF_BOUNDS_TO_ENDZONE = "Out Of Bounds to Endzone";
    public final static String ENDZONE_TO_IN_BOUNDS = "Endzone to In Bounds";
    public final static String ENDZONE_TO_OUT_OF_BOUNDS = "Endzone to Out Of Bounds";
    public final static String IN_BOUNDS_TO_ENDZONE = "In Bounds to Endzone";
    public final static String IN_BOUNDS_TO_OUT_OF_BOUNDS = "In Bounds to Out of Bounds";

    private final static Transition outToInBounds = new Transition(OUT_OF_BOUNDS_TO_IN_BOUNDS, FieldObjectState.OutOfBounds, FieldObjectState.InBounds);
    private final static Transition outToEndzone = new Transition(OUT_OF_BOUNDS_TO_ENDZONE, FieldObjectState.OutOfBounds, FieldObjectState.Endzone);
    private final static Transition inBoundsToEndzone = new Transition(IN_BOUNDS_TO_ENDZONE, FieldObjectState.InBounds, FieldObjectState.Endzone);
    private final static Transition inBoundsToOutOfBounds = new Transition(IN_BOUNDS_TO_OUT_OF_BOUNDS, FieldObjectState.InBounds, FieldObjectState.OutOfBounds);
    private final static Transition endzoneToInBounds = new Transition(ENDZONE_TO_IN_BOUNDS, FieldObjectState.Endzone, FieldObjectState.InBounds);
    private final static Transition endzoneToOutOfBounds = new Transition(ENDZONE_TO_OUT_OF_BOUNDS, FieldObjectState.Endzone, FieldObjectState.OutOfBounds);

    private static final List<Transition> transitions = Arrays.asList(
            inBoundsToEndzone,
            inBoundsToOutOfBounds,
            outToInBounds,
            outToEndzone,
            endzoneToInBounds,
            endzoneToOutOfBounds
    );

    public final static List<Transition> GetTransitions(){
        return new ArrayList<>(transitions);
    }

    public final static String GetTransition(final State previousState, final State currentState){
        for(final Transition transition : transitions){
            if(transition.getPreviousState().equals(previousState) && transition.getNewState().equals(currentState)) return transition.getTransition();
        }
//        TODO Handle logging
        System.out.println("Unable to find transition for State("+currentState+")");
        return "";
    }

}
