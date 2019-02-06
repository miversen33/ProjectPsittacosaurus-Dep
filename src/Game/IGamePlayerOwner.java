package Game;

import Game.Field.Endzone;

public interface IGamePlayerOwner {
    Endzone getGoal();
    String getTeamHash();
}
