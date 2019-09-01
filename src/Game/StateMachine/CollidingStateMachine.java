package Game.StateMachine;

import StateMachines.StateMachine;

public final class CollidingStateMachine extends StateMachine {

    @Deprecated
//    Do we really need this?
    public CollidingStateMachine() {
        super(GamePlayerState.Null, CollidingTransitions.GetTransitions());
    }
}
