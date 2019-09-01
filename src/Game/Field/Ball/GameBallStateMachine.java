package Game.Field.Ball;

import StateMachines.StateMachine;

public final class GameBallStateMachine extends StateMachine {

    public final static String ID = "Ball";

    public GameBallStateMachine() {
        super(ID, GameBallState.OutPossession, GameBallTransitions.GetTransitions());
    }
}
