package Game.PlayerStrategy.Offense;

import Game.GameField;
import Game.GamePlayer;
import PhysicsEngine.MovementInstruction;

public class ReceiverStrategy extends OffensivePlayerStrategy{

    public ReceiverStrategy() {
        super(0,0);
    }

    @Override
    public void calculateMove(final GamePlayer hostPlayer, final GameField field) {

    }

    @Override
    public MovementInstruction getMove() {
        return null;
    }
}
