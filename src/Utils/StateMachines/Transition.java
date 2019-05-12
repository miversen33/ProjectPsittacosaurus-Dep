package Utils.StateMachines;

public class Transition {
    private final String transition;
    private final State prevState;
    private final State newState;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String) return transition.equalsIgnoreCase((String) obj);
        return super.equals(obj);
    }
}
