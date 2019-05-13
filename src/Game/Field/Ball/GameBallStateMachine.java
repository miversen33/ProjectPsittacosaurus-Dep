package Game.Field.Ball;

import Utils.Signature;
import Utils.StateMachines.StateMachine;

public final class GameBallStateMachine extends StateMachine {

    public GameBallStateMachine(final Signature signature) {
        super(signature, GameBallState.OutPossession, GameBallTransitions.GetTransitions());
    }
}
