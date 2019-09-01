package PhysicsEngine.Movements.Events;

import Game.GamePlay.GamePlayer;
import Event.Event;
import java.util.Arrays;
import java.util.List;

public final class TackleEvent extends Event {
    public final static String NAME  = "Tackle";
    
    private final GamePlayer mTackled;
    private final List<GamePlayer> mTacklers;

    public TackleEvent(final GamePlayer tackled, final GamePlayer ... tacklers) {
        super(NAME);
        mTackled = tackled;
        mTacklers = Arrays.asList(tacklers);
    }

    public TackleEvent(final GamePlayer tackled, final List<GamePlayer> tacklers){
        super(NAME);
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
        return getType()+" "+mTackled;
    }
}
