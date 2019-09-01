package Game.StateMachine;

import StateMachines.State;
import StateMachines.Transition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GamePlayerTransitions {

    public final static String NULL_TO_PASS_BLOCK = "Null To Pass Block";
    public final static String PASS_BLOCK_TO_NULL = "Pass Block To Null";
    public final static String NULL_TO_RUN_BLOCK  = "Null To Run Block";
    public final static String RUN_BLOCK_TO_NULL  = "Run Block To Null";
    public final static String NULL_TO_IS_TACKLED = "Null To Is Tackled";
    public final static String IS_TACKLED_TO_NULL = "Is Tackled To Null";
    public final static String NULL_TO_IS_BLOCKED = "Null To Is Blocked";
    public final static String IS_BLOCKED_TO_NULL = "Is Blocked To Null";
    public final static String NULL_TO_TACKLING   = "Null To Tackling";
    public final static String TACKLING_TO_NULL   = "Tackling To Null";
    public final static String NULL_TO_COVERING   = "Null To Covering";
    public final static String COVERING_TO_NULL   = "Covering To Null";

    private final static Transition nullToPassBlock = new Transition(NULL_TO_PASS_BLOCK, GamePlayerState.Null, GamePlayerState.PassBlocking);
    private final static Transition passBlockToNull = new Transition(PASS_BLOCK_TO_NULL, GamePlayerState.PassBlocking, GamePlayerState.Null);
    private final static Transition nullToRunBlock  = new Transition(NULL_TO_RUN_BLOCK,  GamePlayerState.Null, GamePlayerState.RunBlocking);
    private final static Transition runBlockToNull  = new Transition(RUN_BLOCK_TO_NULL,  GamePlayerState.RunBlocking, GamePlayerState.Null);
    private final static Transition nullToIsTackled = new Transition(NULL_TO_IS_TACKLED, GamePlayerState.Null, GamePlayerState.IsTackled);
    private final static Transition isTackledToNull = new Transition(IS_TACKLED_TO_NULL, GamePlayerState.IsTackled, GamePlayerState.Null);
    private final static Transition nullToIsBlocked = new Transition(NULL_TO_IS_BLOCKED, GamePlayerState.Null, GamePlayerState.IsBlocked);
    private final static Transition isBlockedToNull = new Transition(IS_BLOCKED_TO_NULL, GamePlayerState.IsBlocked, GamePlayerState.Null);
    private final static Transition nullToTackling  = new Transition(NULL_TO_TACKLING,   GamePlayerState.Null, GamePlayerState.Tackling);
    private final static Transition tacklingToNull  = new Transition(TACKLING_TO_NULL,   GamePlayerState.Tackling, GamePlayerState.Null);
    private final static Transition nullToCovering  = new Transition(NULL_TO_COVERING,   GamePlayerState.Null, GamePlayerState.Covering);
    private final static Transition coveringToNull  = new Transition(COVERING_TO_NULL,   GamePlayerState.Covering, GamePlayerState.Null);

    private static final List<Transition> transitions = Arrays.asList(
            nullToPassBlock,
            passBlockToNull,
            nullToRunBlock,
            runBlockToNull,
            nullToIsTackled,
            isTackledToNull,
            nullToIsBlocked,
            isBlockedToNull,
            nullToTackling,
            tacklingToNull,
            nullToCovering,
            coveringToNull
    );

    /**
     * TODO
     * Move these to a parent class. Its boilerplate stuff that can be compressed into one call
     */
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
