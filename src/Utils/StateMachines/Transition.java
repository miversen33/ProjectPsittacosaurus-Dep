package Utils.StateMachines;

public class Transition {
    private final String transition;
    private final State prevState;
    private final State newState;

    /**
     * This allows for a transition to be for both ways (to either state)
     */
    public Transition(final String transition, final State previousState, final State newState){
        this.transition = transition;
        this.prevState = previousState;
        this.newState = newState;
    }

    public final String getTransition(){
        return transition;
    }

    public final State getPreviousState(){
        return prevState;
    }

    public final State getNewState(){
        return newState;
    }

    public final boolean isValidState(final State previousState){
       return previousState == null || getPreviousState().equals(previousState);
    }

    @Override
    public final boolean equals(Object obj) {
        if(obj instanceof String) return transition.equalsIgnoreCase((String) obj);
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Transition ("+transition+")";
    }
}
