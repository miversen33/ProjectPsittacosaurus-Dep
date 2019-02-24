package Game.GamePlay.PlayerStrategy;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import Game.IGamePlayerOwner;
import Game.Routes.Route;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

import java.util.List;

public interface IPlayerStrategy {
    void calculateMove(GamePlayer hostPlayer, GameField field);
    MovementInstruction getMove();
    Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam);
    List<PlayerInfluence> getInfluences(GamePlayer hostPlayer, GameField field);
}
