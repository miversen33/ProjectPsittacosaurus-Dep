package Utils.Event;

import Utils.Observable.Observer;
import Utils.Signature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EventListener{

    private final static Map<Signature, EventHandler> handlers = new HashMap<>();

    public static EventHandler CreateListener(final Observer<IEvent> observer, final IEventType ... types){
        return CreateListener(observer, Arrays.asList(types));
    }

    public static EventHandler CreateListener(final Observer<IEvent> observer, final List<IEventType> types){
        final EventHandler newEventHandler = new EventHandler(Signature.GenerateNewSignature(), types);
        handlers.put(newEventHandler.getSignature(), newEventHandler);
        newEventHandler.registerObserver(observer);
        return newEventHandler;
    }

    static void HandleEventFire(final Event eventFired){
        final EventHandler handler = handlers.get(eventFired.getSignature());
        if(handler == null){
//            Log event with no handler
//            TODO
            System.out.println("Received event that has no attached handler | "+eventFired.toString());
            return;
        }
        if(!VerifyHandleExpectsEventType(handler, eventFired)){
//            Log potential malicious event. Then Discard
//            TODO
            System.out.println("Potential Malicious Event found. "+eventFired);
            return;
        }
        handler.handleEvent(eventFired);
    }

    private static boolean VerifyHandleExpectsEventType(final EventHandler handler, final Event event){
        return handler.expectsEventType(event.getType());
    }

}
