package Game.Routes.RouteActions;

import Game.PlayerState;

public final class RouteActionLookForBall implements IRouteAction{
    public final static String NAME = "Look For Ball";

    @Override
    public PlayerState getMovementState() {
        return PlayerState.NULL;
    }

    @Override
    public final String getType() {
        return NAME;
    }

    @Override
    public final boolean isFinalAction() {
        return true;
    }
}
