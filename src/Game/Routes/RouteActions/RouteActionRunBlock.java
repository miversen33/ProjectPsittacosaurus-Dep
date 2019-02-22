package Game.Routes.RouteActions;

import Game.Field.CardinalDirection;
import Game.PlayerState;

public final class RouteActionRunBlock extends RouteActionBlock{
    public final static String NAME = "Run Block";

    private final CardinalDirection blockToSide;

    public RouteActionRunBlock(final CardinalDirection sideToBlockTo){
        super();
        if(!sideToBlockTo.isEast() && !sideToBlockTo.isWest()){
//            TODO
//            Log invalid side provided.
//            Probably should throw some sort of exception here so as
//            to not mess things up
            System.out.println("Invalid side "+sideToBlockTo+" provided for blocking");
            blockToSide = null;
            return;
        }
        blockToSide = sideToBlockTo;
    }

    public final CardinalDirection getBlockingDirection(){
        return blockToSide;
    }

    @Override
    public PlayerState getMovementState() {
        return PlayerState.RUN_BLOCKING;
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
