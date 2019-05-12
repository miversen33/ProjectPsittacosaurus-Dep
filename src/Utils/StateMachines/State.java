package Utils.StateMachines;

public class State {
    private final String state;

    public State(final String newState){
        state = newState;
    }

    public final String getState(){
        return state;
    }

    /**
     * This will be called via the StateMachine upon entering the state. There
     * will also be an event triggered. You may either override this method,
     * or listen for the event, or both in order to handle the transition
     */
    protected void enter(){}
}
