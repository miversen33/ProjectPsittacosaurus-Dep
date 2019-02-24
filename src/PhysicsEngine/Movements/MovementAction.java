package PhysicsEngine.Movements;

import Game.GamePlay.GamePlayer;
import Game.PlayerState;

import java.util.Arrays;
import java.util.List;

public final class MovementAction {

    private final PlayerState mPlayerState;
    private final GamePlayer mAffectingPlayer;
    private final GamePlayer mAffectedPlayer;

    public MovementAction(final PlayerState actionState, final GamePlayer affectingPlayer, final GamePlayer affectedPlayer){
        mPlayerState = actionState;
        mAffectingPlayer = affectingPlayer;
        mAffectedPlayer = affectedPlayer;
    }

    public MovementAction(final GamePlayer affectingPlayer){
        this(PlayerState.NULL, affectingPlayer, null);
    }

    public final PlayerState getActionState(){ return mPlayerState; }

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
