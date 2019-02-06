package Game.PlayerStrategy;

import Game.Field.GameField;
import Game.Field.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

public interface IPlayerStrategy {
    void calculateMove(GamePlayer hostPlayer, GameField field);
    MovementInstruction getMove();
    Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam);
}
