package Game.GamePlay.Events;

import Event.Event;
import Game.GamePlay.GamePlayer;

public final class PlayerOutOfBoundsEvent extends Event {
    public final static String NAME  = "Out Of Bounds";

    private final GamePlayer mPlayer;

    public PlayerOutOfBoundsEvent(final GamePlayer player) {
        super(NAME);
        mPlayer = player;
    }

    public final GamePlayer getPlayer(){
        return mPlayer;
    }

    @Override
    public String toString() {
        return getType()+" "+mPlayer;
    }
}
