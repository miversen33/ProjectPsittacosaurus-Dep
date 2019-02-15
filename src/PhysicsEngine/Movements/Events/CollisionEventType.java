package PhysicsEngine.Movements.Events;

import Event.IEventType;

public final class CollisionEventType implements IEventType {
    private final String NAME = "Collision";

    @Override
    public final String getEventType() {
        return NAME;
    }
}
