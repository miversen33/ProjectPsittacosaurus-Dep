package Utils.Event;

import Utils.Signature;

public class Event implements IEvent {
//    TODO Document this

    private final Signature mSig;
    private final String mType;

    public Event(final Signature signature, final String type){
        mSig = signature;
        mType = type;
    }

    final Signature getSignature(){
        return mSig;
    }

    @Override
    public final String getType() {
        return mType;
    }

    @Override
    public final void fire() {
        EventListener.HandleEventFire(this);
    }
}
