package Game.PlayerStrategy.Offense;

import Game.Field.GameField;
import Game.Field.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
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
