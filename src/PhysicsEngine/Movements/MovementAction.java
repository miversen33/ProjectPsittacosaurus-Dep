package PhysicsEngine.Movements;

import Game.GamePlay.GamePlayer;
import Game.GamePlay.StateMachine.GamePlayerState;

public final class MovementAction {

    private final GamePlayerState mGamePlayerState;
    private final GamePlayer mAffectingPlayer;
    private final GamePlayer mAffectedPlayer;

    public MovementAction(final GamePlayerState actionState, final GamePlayer affectingPlayer, final GamePlayer affectedPlayer){
        mGamePlayerState = actionState;
        mAffectingPlayer = affectingPlayer;
        mAffectedPlayer = affectedPlayer;
    }

    public MovementAction(final GamePlayer affectingPlayer){
        this(GamePlayerState.Null, affectingPlayer, null);
    }

    public final GamePlayerState getActionState(){ return mGamePlayerState; }

    /**
     * Player doing the action
     */
    public final GamePlayer getAffectingPlayer(){ return mAffectingPlayer; }

    /**
     * Player the action is happening to
     */
    public final GamePlayer getAffectedPlayer(){ return mAffectedPlayer; }

    @Override
    public String toString() {
        return getActionState().toString();
    }
}
