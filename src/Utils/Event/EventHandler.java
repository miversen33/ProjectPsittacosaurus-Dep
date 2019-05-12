package Utils.Event;

import Utils.Observable.Observable;
import Utils.Signature;

import java.util.ArrayList;
import java.util.List;

public final class EventHandler extends Observable<IEvent> {

    private final List<String> mTypes;
    private final Signature mSignature;

    EventHandler(final Signature signature, final List<String> types){
        mTypes = new ArrayList<>(types);
        mSignature = signature;
    }

    final boolean expectsEventType(final String type){
        return mTypes.contains(type);
    }

    final void handleEvent(final IEvent event){
//        TEMP LOG TODO
        System.out.println("Handling event "+event);
        updateObservers(event.getType(), event);
    }

    public final Signature getSignature(){
        return mSignature;
    }

}
