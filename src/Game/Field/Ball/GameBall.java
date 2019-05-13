package Game.Field.Ball;

import Game.Field.FieldObject;
import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import Utils.Signature;
import Utils.StateMachines.State;
import Utils.StateMachines.StateMachine;

public final class GameBall extends FieldObject {
    private final static double MASS = 0;
    private final GameBallStateMachine gameBallFSM;
    private final GameManager mOwner;

    public GameBall(final Signature signature, final GameManager owner) {
        super(MASS, signature);
        mOwner = owner;
        gameBallFSM = new GameBallStateMachine(signature);
    }

    public final void lostPossession(final GameManager owner){
        if(mOwner != owner){
//            TODO Handle logging
            System.out.println("We wont be changing the possession state as the provided owner does not match our owner. YOU DONT OWN ME!");
            return;
        }
        try {
            gameBallFSM.transition(GameBallTransitions.LOST_POSSESSION);
        } catch (StateMachine.TransitionNonExistFailure | StateMachine.TransitionFailure transitionNonExistFailure) {
            transitionNonExistFailure.printStackTrace();
        }
    }

    public final void changePossession(final GameManager owner){
        if(mOwner != owner){
//            TODO Handle logging
            System.out.println("We wont be changing the possession state as the provided owner does not match our owner. YOU DONT OWN ME!");
            return;
        }
        if(gameBallFSM.getCurrentState().getState().equalsIgnoreCase(GameBallState.OUT_POSSESSION)){
            try {
                gameBallFSM.transition(GameBallTransitions.GAINED_POSSESSION);
            } catch (StateMachine.TransitionNonExistFailure | StateMachine.TransitionFailure transitionNonExistFailure) {
                transitionNonExistFailure.printStackTrace();
            }
        }
    }

    public final GameBallState getPossessionState(){
        return ((GameBallState) gameBallFSM.getCurrentState());
    }

}
