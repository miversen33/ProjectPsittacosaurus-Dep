package Game.PlayerStrategy;

import Game.GameField;
import Game.GamePlayer;
import PhysicsEngine.MovementInstruction;

public interface IPlayerStrategy {
    void calculateMove(GamePlayer hostPlayer, GameField field);
    MovementInstruction getMove();
}
