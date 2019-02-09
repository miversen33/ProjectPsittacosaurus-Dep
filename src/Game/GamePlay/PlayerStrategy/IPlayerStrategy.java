package Game.GamePlay.PlayerStrategy;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluences;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

import java.util.List;

public interface IPlayerStrategy {
    void calculateMove(GamePlayer hostPlayer, GameField field);
    MovementInstruction getMove();
    Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam);
    List<PlayerInfluences> getInfluences(GamePlayer hostPlayer, GameField field);
}
