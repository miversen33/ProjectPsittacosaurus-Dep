package Utils.StateMachines;

import Utils.Event.Event;
import Utils.Signature;

import java.util.*;

public class StateMachine {
    public final static String TRANSITIONING = "Transitioning";

    private final Map<String, Transition> transitionMap = new HashMap<>();
    private final Signature signature;
    private State previousState;
    private State currentState;

    public class TransitionNonExistFailure extends Exception{
        private TransitionNonExistFailure(final String transitionType){
            super(transitionType+" is not a valid transition type for this state");
        }
    }

    public class TransitionFailure extends Exception{
        private TransitionFailure(final String transitionType){
            super("Unable to transition as Transition:("+transitionType+") does not start at current State:("+currentState.getState()+")");
        }
    }

    class TransitionEvent extends Event{
        public TransitionEvent(final Signature signature, final String transition){
            super(signature, StateMachine.this+" - "+TRANSITIONING+" to "+transition+" state");
        }
    }

    public StateMachine(final Signature signature, final State initialState, final Transition ... transitions){
        this(signature, initialState, Arrays.asList(transitions));
    }

    public StateMachine(final Signature signature, final State initialState, final List<Transition> transitions){
        this.signature = signature;
        currentState = initialState;
        addTransition(signature, transitions);
    }

    private final void addTransition(final Signature signature, final List<Transition> transitions){
        for(final Transition t : transitions){
            addTransition(signature, t);
        }
    }

    private final void addTransition(final Signature signature, final Transition transition){
        if(!Signature.ValidateSignatures(this.signature, signature)){
            System.out.println("Unable to add new transition "+transition.getTransition()+" as signer is not valid");
            return;
        }
        transitionMap.put(transition.getTransition(), transition);
    }

    public final void transition(final String proposedTransition) throws TransitionNonExistFailure, TransitionFailure {
        if(!transitionMap.keySet().contains(proposedTransition)) throw new TransitionNonExistFailure(proposedTransition);
        final Transition transition = transitionMap.get(proposedTransition);
        if(!transition.isValidState(getCurrentState())) throw new TransitionFailure(proposedTransition);
        setState(transition.getNewState());
    }

    private final void setState(final State newState){
        previousState = currentState;
        currentState = newState;
        System.out.println("Transitioning to "+newState.getState());
        new TransitionEvent(signature, newState.getState()).fire();
        currentState.enter();
    }

    public final State getCurrentState(){
        return currentState;
    }

    public final State getPreviousState(){
        return previousState;
    }

}