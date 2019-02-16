package PhysicsEngine.Movements.Events;

import Utils.Event.IEventType;

public final class CollisionEventType implements IEventType {
    private final String NAME = "Collision";

    @Override
    public final String getEventType() {
        return NAME;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IEventType){
            return ((IEventType) obj).getEventType().equals(getEventType());
        }
        return super.equals(obj);
    }
}
