package Game.GamePlay.StateMachine;

import Utils.Signature;
import Utils.StateMachines.StateMachine;

public final class CollidingStateMachine extends StateMachine {

    public CollidingStateMachine(final Signature signature) {
        super(signature, GamePlayerState.Null, CollidingTransitions.GetTransitions());
    }
}
