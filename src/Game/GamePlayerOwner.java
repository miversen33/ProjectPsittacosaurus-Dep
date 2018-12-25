package Game;

import Tuple.Tuple2;

public interface GamePlayerOwner {
    Tuple2<Double, Double> getGoal();
    String getTeamHash();
}
