package Game.GamePlay.PlayerStrategy.Offense;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import PhysicsEngine.PhysicsObjects.Vector;
import Tuple.Tuple2;

import java.util.List;

public class DefaultOffensiveStrategy implements IPlayerStrategy {

    private MovementInstruction move;

    @Override
    public final void calculateMove(final GamePlayer hostPlayer, final GameField field) {
        final Vector v = new Vector(new Tuple2<>(0.0,3.0));
        move = new MovementInstruction(hostPlayer, v);
    }

    @Override
    public final MovementInstruction getMove() {
        return move;
    }

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {
        return null;
    }

    @Override
    public final List<PlayerInfluence> getInfluences(final GamePlayer hostPlayer, final GameField field) {
        return null;
    }
}
