package Game.GamePlay.Events;

import Game.GamePlay.GamePlayer;
import Utils.Event.Event;
import Utils.Signature;

public final class PlayerInEndzoneEvent extends Event {
    public final static String NAME = "Player Is In Endzone";

    private final GamePlayer mPlayer;

    public PlayerInEndzoneEvent(final Signature signature, final GamePlayer player) {
        super(signature, NAME);
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