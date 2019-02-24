package Game.GamePlay.PlayerStrategy.Defense;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.Routes.Route;
import Game.Routes.RouteInterpreter.RouteInterpreter;
import PhysicsEngine.Movements.MovementInstruction;

public final class DefensiveRouteInterpreter extends RouteInterpreter{

    private MovementInstruction move;

    public DefensiveRouteInterpreter(final Route route) {
        super(route);
    }

    @Override
    public final double gradeRoute(final GamePlayer hostPlayer, final GameField field) {
        return 0;
    }

    @Override
    public MovementInstruction getMovement() {
        return null;
    }

    @Override
    public void calculateMovement(GamePlayer hostPlayer, GameField field) {

    }
}
