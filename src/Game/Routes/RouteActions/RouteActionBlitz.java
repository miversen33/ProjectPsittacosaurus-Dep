package Game.Routes.RouteActions;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

public class RouteActionBlitz extends BaseRouteAction{
    public final static String TYPE = "Blitz";
    private final static boolean IS_FINAL = true;

    public RouteActionBlitz() {
        super(TYPE, IS_FINAL);
    }

    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField gameField) {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

}
