package Game.Routes.RouteActions;

import Game.GamePlay.GamePlayer;
import Game.PlayerState;

public final class RouteActionManCoverage extends RouteActionCoverage {
    public final static String NAME = "Man Coverage";

    public final GamePlayer playerToCover;

    public RouteActionManCoverage(final GamePlayer coveragePlayer){
        super();
        playerToCover = coveragePlayer;
    }

    @Override
    public PlayerState getMovementState() {
        return PlayerState.NULL;
    }

    public final GamePlayer getCoveringPlayer(){
        return playerToCover;
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
