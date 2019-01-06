package Game;

import Tuple.Tuple2;

public interface IGamePlayerOwner {
    Tuple2<Double, Double> getGoal();
    String getTeamHash();
}
