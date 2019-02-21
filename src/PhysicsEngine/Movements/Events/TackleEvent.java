package PhysicsEngine.Movements.Events;

import Game.GamePlay.GamePlayer;
import Utils.Event.Event;
import Utils.Signature;

import java.util.Arrays;
import java.util.List;

public final class TackleEvent extends Event {

    private final GamePlayer mTackled;
    private final List<GamePlayer> mTacklers;

    public TackleEvent(final Signature signature, final GamePlayer tackled, final GamePlayer ... tacklers) {
        super(signature, new TackleEventType());
        mTackled = tackled;
        mTacklers = Arrays.asList(tacklers);
    }

    public TackleEvent(final Signature signature, final GamePlayer tackled, final List<GamePlayer> tacklers){
        super(signature, new TackleEventType());
        mTackled = tackled;
        mTacklers = tacklers;
    }

    public final GamePlayer getTackledPlayer(){
        return mTackled;
    }

    public final List<GamePlayer> getTacklers(){
        return mTacklers;
    }

    @Override
    public String toString() {
        return getType().getEventType()+" "+mTackled;
    }
}
