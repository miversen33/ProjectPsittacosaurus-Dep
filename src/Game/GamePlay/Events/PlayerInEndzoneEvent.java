package Game.GamePlay.Events;

import Game.GamePlay.GamePlayer;
import Event.Event;

public final class PlayerInEndzoneEvent extends Event {
    public final static String NAME = "Player Is In Endzone";

    private final GamePlayer mPlayer;

    public PlayerInEndzoneEvent(final GamePlayer player) {
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