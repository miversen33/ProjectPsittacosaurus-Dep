package Game;

import Game.Field.Endzone;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementEngine;

public interface IPlayerObject {
    Endzone getTeamGoal();
    String getName();
    String getOwnerHash();
    String getPlayerHash();
    PlayerState getPlayerState();
    void calculateMove();
    void setPlayerState(MovementEngine engine, PlayerState state);
    boolean sameTeamCheck(GamePlayer comparePlayer);
}
