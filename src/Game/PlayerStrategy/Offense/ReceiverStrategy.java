package Game.PlayerStrategy.Offense;

import Game.Field.GameField;
import Game.Field.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

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

    @Override
    public Tuple2<Double, Double> calculateGoal(GamePlayer hostPlayer, GameField field, IGamePlayerOwner hostTeam) {
        return null;
    }
}
