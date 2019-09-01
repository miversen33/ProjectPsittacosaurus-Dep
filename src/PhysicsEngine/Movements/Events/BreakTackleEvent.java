package PhysicsEngine.Movements.Events;

import Game.GamePlay.GamePlayer;
import Event.Event;

public final class BreakTackleEvent extends Event {
    public final static String NAME = "Break Tackle Event";

    private final GamePlayer mTacklee;
    private final GamePlayer mTackler;

    public BreakTackleEvent(final GamePlayer tacklee, final GamePlayer tackler) {
        super(NAME);
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
