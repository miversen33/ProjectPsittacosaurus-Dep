package Game.Routes.RouteActions;

import Game.PlayerState;

public final class RouteActionBlitz implements IRouteAction{
    public final static String NAME = "Blitz";

    public RouteActionBlitz(){}

    @Override
    public PlayerState getMovementState() {
        return PlayerState.NULL;
    }

    @Override
    public final String getType() {
        return NAME;
    }

    @Override
    public boolean isFinalAction() {
        return true;
    }
}
