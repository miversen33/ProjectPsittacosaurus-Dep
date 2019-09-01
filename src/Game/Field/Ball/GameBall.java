package Game.Field.Ball;

import Exceptions.TransitionFailureException;
import Exceptions.TransitionNonExistentException;
import Game.Field.FieldObject;
import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import StateMachines.State;
import StateMachines.StateMachine;

public final class GameBall extends FieldObject {
    private final static double MASS = 0;
    private final GameBallStateMachine gameBallFSM;
    private final GameManager mOwner;

    public final static String DEBUG_UID = "Game Ball";

    public GameBall(final GameManager owner) {
        super(DEBUG_UID, MASS);
        mOwner = owner;
        gameBallFSM = new GameBallStateMachine();
    }

    public final void lostPossession(final GameManager owner){
        if(mOwner != owner){
//            TODO Handle logging
            System.out.println("We wont be changing the possession state as the provided owner does not match our owner. YOU DONT OWN ME!");
            return;
        }
        try {
            gameBallFSM.transition(GameBallTransitions.LOST_POSSESSION);
        } catch (TransitionNonExistentException | TransitionFailureException transitionNonExistFailure) {
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
            } catch (TransitionNonExistentException | TransitionFailureException transitionNonExistFailure) {
                transitionNonExistFailure.printStackTrace();
            }
        }
    }

    public final GameBallState getPossessionState(){
        return ((GameBallState) gameBallFSM.getCurrentState());
    }

}
