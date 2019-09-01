package Game.StateMachine;

import Exceptions.TransitionFailureException;
import Exceptions.TransitionNonExistentException;
import Game.Field.Field;
import Tuple.Tuple2;
import Game.Utils.Location;
import StateMachines.State;
import StateMachines.StateMachine;

public class FieldObjectStateMachine extends StateMachine {

    public FieldObjectStateMachine(final String uID) {
        super(uID, FieldObjectState.OutOfBounds, FieldObjectTransitions.GetTransitions());
    }

    public final void handleMove(final Tuple2<Double, Double> newLocation){
        final State newState = Field.GetLocationState(new Location(newLocation));
        if(newState.equals(getCurrentState())) return;
        final String transition = FieldObjectTransitions.GetTransition(getCurrentState(), newState);
        try {
            transition(transition);
        } catch (TransitionNonExistentException | TransitionFailureException transitionFailure) {
            transitionFailure.printStackTrace();
        }
    }
}