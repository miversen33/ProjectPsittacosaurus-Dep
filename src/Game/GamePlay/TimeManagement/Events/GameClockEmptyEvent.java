package Game.GamePlay.TimeManagement.Events;

import Utils.Event.Event;
import Utils.Signature;

public final class GameClockEmptyEvent extends Event {
    public final static String NAME  = "Game Clock Is Empty";

    private final int clock;

    public GameClockEmptyEvent(final Signature signature, final int clockNum) {
        super(signature, NAME);
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
