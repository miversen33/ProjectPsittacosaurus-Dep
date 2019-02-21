package PhysicsEngine.Movements.Events;

import Utils.Event.IEventType;

public final class BreakTackleEventType implements IEventType {
    public final static String NAME = "Break Tackle Event";

    @Override
    public String getEventType() {
        return NAME;
    }
}
