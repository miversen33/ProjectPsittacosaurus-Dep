package Event;

import Utils.Signature;

public interface IEvent {
    void fire();
    IEventType getType();
}
