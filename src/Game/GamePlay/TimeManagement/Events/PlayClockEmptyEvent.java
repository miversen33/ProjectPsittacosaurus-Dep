package Game.GamePlay.TimeManagement.Events;

import Utils.Event.Event;
import Utils.Signature;

public final class PlayClockEmptyEvent extends Event {
    public final static String NAME  = "Play Clock Is Empty";

    public PlayClockEmptyEvent(final Signature signature) {
        super(signature, NAME);
    }

    @Override
    public String toString() {
        return getType();
    }
}
