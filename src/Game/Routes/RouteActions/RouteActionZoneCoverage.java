package Game.Routes.RouteActions;

import Game.PlayerState;

public final class RouteActionZoneCoverage extends RouteActionCoverage {
    public final static String NAME = "Zone Coverage";

    private final double radiusToCover;

    public RouteActionZoneCoverage(final double coverageRadius){
        super();
        radiusToCover = coverageRadius;
    }

    @Override
    public PlayerState getMovementState() {
        return PlayerState.NULL;
    }

    public final double getRadius(){
        return radiusToCover;
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
