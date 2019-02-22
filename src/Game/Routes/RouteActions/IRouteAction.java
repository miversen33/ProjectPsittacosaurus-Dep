package Game.Routes.RouteActions;

import Game.PlayerState;

public interface IRouteAction {
    String getType();
    boolean isFinalAction();
    PlayerState getMovementState();
}
