package Game.Field.Ball;

import Utils.StateMachines.State;
import Utils.StateMachines.Transition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameBallTransitions {

    public final static String LOST_POSSESSION = "Lost Possession";
    public final static String GAINED_POSSESSION = "Gained Possession";

    private final static Transition LOST_POSSESSION_TRANSITION = new Transition(LOST_POSSESSION, GameBallState.InPossession, GameBallState.OutPossession);
    private final static Transition GAINED_POSSESSION_TRANSITION = new Transition(GAINED_POSSESSION, GameBallState.OutPossession, GameBallState.InPossession);

    private static final List<Transition> transitions = Arrays.asList(
            LOST_POSSESSION_TRANSITION,
            GAINED_POSSESSION_TRANSITION
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
