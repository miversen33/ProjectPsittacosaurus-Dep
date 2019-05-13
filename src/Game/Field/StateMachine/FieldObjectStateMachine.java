package Game.Field.StateMachine;

import Game.Field.Field;
import Tuple.Tuple2;
import Utils.Location;
import Utils.Signature;
import Utils.StateMachines.State;
import Utils.StateMachines.StateMachine;

public class FieldObjectStateMachine extends StateMachine {

    public FieldObjectStateMachine(final Signature signature) {
        super(signature, FieldObjectState.OutOfBounds, FieldObjectTransitions.GetTransitions());
    }

    public final void handleMove(final Tuple2<Double, Double> newLocation){
        final State newState = Field.GetLocationState(new Location(newLocation));
        final String transition = FieldObjectTransitions.GetTransition(newState);
        try {
            transition(transition);
        } catch (TransitionNonExistFailure | TransitionFailure transitionFailure) {
            transitionFailure.printStackTrace();
        }
    }
}