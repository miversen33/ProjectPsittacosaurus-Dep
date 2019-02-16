package Game.GamePlay.Events;

import Utils.Event.IEvent;
import Utils.Event.IEventType;

public final class PlayerInEndzoneEventType implements IEventType {
    private final String NAME = "Player Is In Endzone";

    @Override
    public String getEventType() {
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
