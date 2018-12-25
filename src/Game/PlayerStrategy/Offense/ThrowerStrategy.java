package Game.PlayerStrategy.Offense;

import Game.GameField;
import Game.GamePlayer;
import PhysicsEngine.MovementInstruction;

public class ThrowerStrategy extends OffensivePlayerStrategy{

    public ThrowerStrategy() {
        super();
    }

    @Override
    public void calculateMove(final GamePlayer hostPlayer, final GameField field) {

    }

    @Override
    public MovementInstruction getMove() {
        return null;
    }
}
