package Game.Routes.RouteActions;

import Game.PlayerState;

public final class RouteActionSpy implements IRouteAction{
    public final static String NAME = "Spy";

    @Override
    public final String getType() {
        return NAME;
    }

    @Override
    public PlayerState getMovementState() {
        return PlayerState.NULL;
    }

    @Override
    public final boolean isFinalAction() {
        return true;
    }
}
