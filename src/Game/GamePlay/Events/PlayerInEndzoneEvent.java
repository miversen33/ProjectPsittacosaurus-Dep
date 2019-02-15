package Game.GamePlay.Events;

import Event.Event;
import Game.GamePlay.GamePlayer;
import Utils.Signature;

public final class PlayerInEndzoneEvent extends Event {

    private final GamePlayer mPlayer;

    public PlayerInEndzoneEvent(final Signature signature, final GamePlayer player) {
        super(signature, new PlayerInEndzoneEventType());
        mPlayer = player;
    }

    public final GamePlayer getPlayer(){
        return mPlayer;
    }

    @Override
    public String toString() {
        return getType().getEventType()+" "+mPlayer;
    }
}