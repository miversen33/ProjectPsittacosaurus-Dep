package Game.Routes.RouteActions;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

public interface IRouteAction {
    String getType();
    Boolean isFinalAction();
    boolean isComplete();
    MovementInstruction interpretRoute(GamePlayer hostPlayer, GameField gameField);
}