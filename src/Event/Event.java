package Event;

import Utils.Signature;

public class Event implements IEvent{

    private final Signature mSig;
    private final IEventType mType;

    public Event(final Signature signature, final IEventType type){
        mSig = signature;
        mType = type;
    }

    final Signature getSignature(){
        return mSig;
    }

    @Override
    public final IEventType getType() {
        return mType;
    }

    @Override
    public final void fire() {
        EventListener.HandleEventFire(this);
    }
}
