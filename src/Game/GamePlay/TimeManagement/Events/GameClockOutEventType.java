package Game.GamePlay.TimeManagement.Events;

import Event.IEventType;

public final class GameClockOutEventType implements IEventType {

    private final String NAME = "Game Clock Is Empty";

    @Override
    public final String getEventType() {
        return NAME;
    }
}
