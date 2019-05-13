package Utils.StateMachines;

public class Transition {
    private final String transition;
    private final State prevState;
    private final State newState;
    private final boolean bothWays;

    /**
     * This assumes the transition is only 1 way.
     */
    public Transition(final String transition, final State previousState, final State newState){
        this(transition, previousState, newState, false);
    }

    /**
     * This allows for a transition to be for both ways (to either state)
     */
    public Transition(final String transition, final State previousState, final State newState, final boolean bothWays){
        this.transition = transition;
        this.prevState = previousState;
        this.newState = newState;
        this.bothWays = bothWays;
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

    public final boolean isValidState(final State checkState){
        if(bothWays) {
            return getPreviousState().equals(checkState) || getNewState().equals(checkState);
        } else {
           return getNewState().equals(checkState);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String) return transition.equalsIgnoreCase((String) obj);
        return super.equals(obj);
    }
}
