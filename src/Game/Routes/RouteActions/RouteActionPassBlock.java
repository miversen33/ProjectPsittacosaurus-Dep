package Game.Routes.RouteActions;

import Game.PlayerState;

public final class RouteActionPassBlock extends RouteActionBlock{
    public final static String NAME = "Pass Block";

    public RouteActionPassBlock(){
        super();
    }

    @Override
    public PlayerState getMovementState() {
        return PlayerState.PASS_BLOCKING;
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
