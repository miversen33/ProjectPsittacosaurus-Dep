package Game.Routes.RouteActions;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

public class RouteActionSpy extends BaseRouteAction {

    public final static String TYPE = "Spy";
    private final static boolean IS_FINAL = true;

    public RouteActionSpy() {
        super(TYPE, IS_FINAL);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField gameField) {
        return null;
    }

}
