package Game.Routes.RouteInterpreter;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;

public interface IRouteInterpreter {
    double gradeRoute(GamePlayer hostPlayer, GameField field);
    MovementInstruction getNextMovement(GamePlayer hostPlayer, GameField field);
}
