package Game.PlayerStrategy;

import Game.GameField;
import Game.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

public interface IPlayerStrategy {
    void calculateMove(GamePlayer hostPlayer, GameField field);
    MovementInstruction getMove();
    Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam);
}
