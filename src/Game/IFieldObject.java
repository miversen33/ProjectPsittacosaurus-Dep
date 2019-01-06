package Game;

import Game.Field.PlayerLocationState;
import Tuple.Tuple2;

public interface IFieldObject {
    Tuple2<Double, Double> getLocation();
    Tuple2<Double, Double> getPreviousLocation(int previousStep);
    PlayerState getPlayerState();
    boolean isOnField();
    void setLocationState(GameField field, PlayerLocationState locationState);
}
