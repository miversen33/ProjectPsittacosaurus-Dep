package Game.StateMachine;

import Exceptions.TransitionFailureException;
import Exceptions.TransitionNonExistentException;
import StateMachines.StateMachine;

public final class GamePlayerStateMachine extends StateMachine {

    private final CollidingStateMachine playerCollisionMachine;

    public GamePlayerStateMachine(final String uID) {
        super(uID, GamePlayerState.Null, GamePlayerTransitions.GetTransitions());
        playerCollisionMachine = new CollidingStateMachine();
    }

    public final void setCollision(){
        if(playerCollisionMachine.getCurrentState() != GamePlayerState.Colliding) {
            try {
                playerCollisionMachine.transition(CollidingTransitions.IN_COLLISION);
            } catch (TransitionNonExistentException | TransitionFailureException transitionNonExistFailure) {
                transitionNonExistFailure.printStackTrace();
            }
        }
    }

    public final void exitCollision(){
        if(playerCollisionMachine.getCurrentState() == GamePlayerState.Colliding){
            try {
                playerCollisionMachine.transition(CollidingTransitions.NOT_IN_COLLISION);
            } catch (TransitionNonExistentException | TransitionFailureException transitionNonExistFailure) {
                transitionNonExistFailure.printStackTrace();
            }
        }
    }

    public final GamePlayerState getPlayerState(){
        return (GamePlayerState) getCurrentState();
    }

    public final GamePlayerState getCollisionState(){
        return (GamePlayerState) playerCollisionMachine.getCurrentState();
    }
}
