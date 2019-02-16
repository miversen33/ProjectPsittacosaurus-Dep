package Game.GamePlay.TimeManagement.Events;

import Utils.Event.Event;
import Utils.Signature;

public final class GameClockEmptyEvent extends Event {

    private final int clock;

    public GameClockEmptyEvent(final Signature signature, final int clockNum) {
        super(signature, new GameClockOutEventType());
        clock = clockNum;
    }

    public final int getClock(){
        return clock;
    }

    @Override
    public String toString() {
        return getType().getEventType()+" "+getClock();
    }

}
