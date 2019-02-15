package PhysicsEngine.Movements.Events;

import Event.IEventType;

public final class TackleEventType implements IEventType {
    private final String NAME = "Tackle";

    @Override
    public final String getEventType() {
        return NAME;
    }
}
