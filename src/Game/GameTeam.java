package Game;

import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameTeam implements GamePlayerOwner{

//    It is worth considering if this should be an array since it cannot change after being
//    initialized
    private final List<GamePlayer> mPlayers;
    private final String mHash = UUID.randomUUID().toString();
    private Tuple2<Double, Double> mGoal;

    public GameTeam(final List<GamePlayer> players, final Tuple2<Double, Double> currentGoal){
        mPlayers = new ArrayList<>(players);
        mGoal = currentGoal;
        requestPlayerOwnership();
    }

    public final List<GamePlayer> getPlayers(){
        return mPlayers;
    }

    private final void requestPlayerOwnership(){
        for(GamePlayer player : mPlayers){
            player.assignTeam(this);
        }
    }

    public final void cycle(){
        for(GamePlayer player : mPlayers){
            player.calculateMovement();
        }
    }


    @Override
    public Tuple2<Double, Double> getGoal() {
        return mGoal;
    }

    public final String getTeamHash(){
        return mHash;
    }
}
