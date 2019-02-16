package Utils.Event;

public interface IEvent {
    void fire();
    IEventType getType();
}
