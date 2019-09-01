package Game.GamePlay.TimeManagement.Events;

import Event.Event;

public final class PlayClockEmptyEvent extends Event {
    public final static String NAME  = "Play Clock Is Empty";

    public PlayClockEmptyEvent() {
        super(NAME);
    }

    @Override
    public String toString() {
        return getType();
    }
}
