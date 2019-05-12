package PhysicsEngine.Movements.Events;

import Game.GamePlay.GamePlayer;
import Utils.Event.Event;
import Utils.Signature;

public final class BreakTackleEvent extends Event {
    public final static String NAME = "Break Tackle Event";

    private final GamePlayer mTacklee;
    private final GamePlayer mTackler;

    public BreakTackleEvent(final Signature signature, final GamePlayer tacklee, final GamePlayer tackler) {
        super(signature, NAME);
        mTacklee = tacklee;
        mTackler = tackler;
    }

    public final GamePlayer getTacklee(){
        return mTacklee;
    }

    public final GamePlayer getTackler(){
        return mTackler;
    }
}
