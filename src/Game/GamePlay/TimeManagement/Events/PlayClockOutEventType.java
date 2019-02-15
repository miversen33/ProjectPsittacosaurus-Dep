package Game.GamePlay.TimeManagement.Events;

import Event.IEventType;

public final class PlayClockOutEventType implements IEventType {
    private final String NAME = "Play Clock Is Empty";

    @Override
    public final String getEventType() {
        return NAME;
    }
}
