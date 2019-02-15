package Game.GamePlay.Events;

import Event.IEventType;

public final class PlayerOutOfBoundsEventType implements IEventType {
    private final String NAME = "Out Of Bounds";

    @Override
    public final String getEventType() {
        return NAME;
    }
}
