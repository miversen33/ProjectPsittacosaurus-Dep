package Game;

import Game.Field.Endzone;
import Game.GamePlay.GamePlayer;
import Game.StateMachine.GamePlayerState;

public interface IPlayerObject {
    Endzone getTeamGoal();
    String getName();
    String getOwnerHash();
    String getPlayerHash();
    GamePlayerState getPlayerState();
    GamePlayerState getMovementState();
    void calculateMove();
//    void setPlayerState(MovementEngine engine, PlayerState state);
    boolean sameTeamCheck(GamePlayer comparePlayer);
}
