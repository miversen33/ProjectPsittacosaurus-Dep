package Game.GamePlay.StateMachine;

import Utils.Signature;
import Utils.StateMachines.StateMachine;

public final class GamePlayerStateMachine extends StateMachine {

    private final CollidingStateMachine playerCollisionMachine;
    private final Signature mSignature;

    public GamePlayerStateMachine(final Signature signature) {
        super(signature, GamePlayerState.Null, GamePlayerTransitions.GetTransitions());
        playerCollisionMachine = new CollidingStateMachine(signature);
        mSignature = signature;
    }

    public final void setCollision(final Signature signature){
        if(!Signature.ValidateSignatures(signature, mSignature)){
//            TODO Handle Logging
            System.out.println("Unable to adjust collision State Machine as invalid signature was provided");
            return;
        }
        if(playerCollisionMachine.getCurrentState() != GamePlayerState.Colliding) {
            try {
                playerCollisionMachine.transition(CollidingTransitions.IN_COLLISION);
            } catch (TransitionNonExistFailure | TransitionFailure transitionNonExistFailure) {
                transitionNonExistFailure.printStackTrace();
            }
        }
    }

    public final void exitCollision(final Signature signature){
        if(!Signature.ValidateSignatures(signature, mSignature)){
//            TODO Handle Logging
            System.out.println("Unable to adjust collision State Machine as invalid signature was provided");
            return;
        }
        if(playerCollisionMachine.getCurrentState() == GamePlayerState.Colliding){
            try {
                playerCollisionMachine.transition(CollidingTransitions.NOT_IN_COLLISION);
            } catch (TransitionNonExistFailure | TransitionFailure transitionNonExistFailure) {
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
