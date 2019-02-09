package Game.GamePlay.PlayerStrategy.Defense;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluences;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

import java.util.List;

public class CoverageStrategy extends DefensivePlayerStrategy{

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

    @Override
    public List<PlayerInfluences> getInfluences(GamePlayer hostPlayer, GameField field) {
        return null;
    }
}
