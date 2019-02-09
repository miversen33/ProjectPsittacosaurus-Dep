package PhysicsEngine.Movements;

import Game.GamePlay.GamePlayer;

public final class MovementAction {

    public enum State{
        /**
         * Jamming a receiver is technically blocking, so it receives the same state
         */
        BLOCK,
        IS_BLOCKED,
        TACKLE,
        BREAK_BLOCK,
        BREAK_TACKLE,
        COLLIDING,
        NULL;

        public final boolean block(){ return this.equals(BLOCK); }
        public final boolean isBlocked(){ return this.equals(IS_BLOCKED); }
        public final boolean tackle(){ return this.equals(TACKLE); }
        public final boolean breakBlock(){ return this.equals(BREAK_BLOCK); }
        public final boolean breakTackle(){ return this.equals(BREAK_TACKLE); }
        public final boolean isColliding(){ return this.equals(COLLIDING); }
        public final boolean isNull() { return this.equals(NULL); }
    }

    private final State mActionState;
    private final GamePlayer mAffectingPlayer;
    private final GamePlayer mAffectedPlayer;

    public MovementAction(final State actionState, final GamePlayer affectingPlayer, final GamePlayer affectedPlayer){
        mActionState = actionState;
        mAffectingPlayer = affectingPlayer;
        mAffectedPlayer = affectedPlayer;
    }

    public MovementAction(){
        this(State.NULL, null, null);
    }

    public final State getActionState(){ return mActionState; }

    /**
     * Player doing the action
     */
    public final GamePlayer getAffectingPlayer(){ return mAffectingPlayer; }

    /**
     * Player the action is happening to
     */
    public final GamePlayer getAffectedPlayer(){ return mAffectedPlayer; }


}
