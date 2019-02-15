package Game.GamePlay.TimeManagement.Events;

import Event.Event;
import Utils.Signature;

public final class PlayClockEmptyEvent extends Event {

    public PlayClockEmptyEvent(final Signature signature) {
        super(signature, new PlayClockOutEventType());
    }

    @Override
    public String toString() {
        return getType().getEventType();
    }
}
