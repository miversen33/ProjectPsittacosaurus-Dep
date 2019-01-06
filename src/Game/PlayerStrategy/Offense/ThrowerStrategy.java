package Game.PlayerStrategy.Offense;

import Game.GameField;
import Game.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

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

    @Override
    public Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam) {
        return null;
    }
}
