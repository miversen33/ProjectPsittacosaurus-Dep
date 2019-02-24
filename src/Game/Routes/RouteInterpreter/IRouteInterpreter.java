package Game.Routes.RouteInterpreter;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import PhysicsEngine.Movements.MovementInstruction;

public interface IRouteInterpreter {
    double gradeRoute(GamePlayer hostPlayer, GameField field);
    MovementInstruction getMovement();
    void calculateMovement(GamePlayer hostPlayer, GameField field);
}
