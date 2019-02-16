package Game.GamePlay.Events;

import Utils.Event.Event;
import Game.GamePlay.GamePlayer;
import Utils.Signature;

public final class PlayerOutOfBoundsEvent extends Event {

    private final GamePlayer mPlayer;

    public PlayerOutOfBoundsEvent(final Signature signature, final GamePlayer player) {
        super(signature, new PlayerOutOfBoundsEventType());
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
