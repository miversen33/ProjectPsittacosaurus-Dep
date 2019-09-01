package Game.GamePlay.TimeManagement.Events;

import Event.Event;

public final class GameClockEmptyEvent extends Event {
    public final static String NAME  = "Game Clock Is Empty";

    private final int clock;

    public GameClockEmptyEvent(final int clockNum) {
        super(NAME);
        clock = clockNum;
    }

    public final int getClock(){
        return clock;
    }

    @Override
    public String toString() {
        return getType()+" "+getClock();
    }

}
