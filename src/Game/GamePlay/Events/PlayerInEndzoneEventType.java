package Game.GamePlay.Events;

import Event.IEventType;

public final class PlayerInEndzoneEventType implements IEventType {
    private final static String NAME = "Player Is In Endzone";

    @Override
    public String getEventType() {
        return NAME;
    }
}
