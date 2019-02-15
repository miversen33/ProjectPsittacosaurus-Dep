package Game.GamePlay.Events;

import Event.IEventType;

public final class PlayerInjuryEventType implements IEventType {
    private final String NAME = "Player Injured";

    @Override
    public String getEventType() {
        return NAME;
    }
}
