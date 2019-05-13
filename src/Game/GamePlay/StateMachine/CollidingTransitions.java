package Game.GamePlay.StateMachine;

import Game.GamePlay.GamePlayer;
import Utils.StateMachines.State;
import Utils.StateMachines.Transition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CollidingTransitions{

    public final static String IN_COLLISION = "Colliding";
    public final static String NOT_IN_COLLISION = "Null";

    private final static Transition collision = new Transition(IN_COLLISION, GamePlayerState.Null, GamePlayerState.Colliding);
    private final static Transition noCollision = new Transition(NOT_IN_COLLISION, GamePlayerState.Colliding, GamePlayerState.Null);

    private static final List<Transition> transitions = Arrays.asList(
            collision,
            noCollision
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
