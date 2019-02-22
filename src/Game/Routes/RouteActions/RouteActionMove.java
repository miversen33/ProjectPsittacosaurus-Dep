package Game.Routes.RouteActions;

import Game.PlayerState;
import PhysicsEngine.PhysicsObjects.Vector;

public final class RouteActionMove implements IRouteAction {
    public final static String NAME = "Move";
    private final Vector mMove;

    public RouteActionMove(final Vector move){
        mMove = move;
    }

    @Override
    public PlayerState getMovementState() {
        return PlayerState.NULL;
    }

    public final Vector getMovement(){
        return mMove;
    }

    @Override
    public final String getType() {
        return NAME;
    }

    @Override
    public boolean isFinalAction() {
        return false;
    }
}
