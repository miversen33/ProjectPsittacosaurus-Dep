package Game.GamePlay;

import Game.Field.Endzone;
import Game.IGamePlayerOwner;
import Utils.Signature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameTeam implements IGamePlayerOwner {

//    TODO
//    It is worth considering if this should be an array since it cannot change after being
//    initialized
    private final List<GamePlayer> mPlayers;
    private final String mHash = UUID.randomUUID().toString();
    private Endzone mGoal;
    private Signature mSig;

    public GameTeam(final List<GamePlayer> players, final Endzone currentGoal){
        mPlayers = new ArrayList<>(players);
        mGoal = currentGoal;
        requestPlayerOwnership();
    }

    public final void signTeam(final Signature signature){
        if(mSig != null){
//            Log invalid attempt to sign team.
//            TODO
            return;
        }
        mSig = signature;
    }

    protected final Signature getSignature(){
        return mSig;
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
            player.calculateMove();
        }
    }

    @Override
    public Endzone getGoal() {
        return mGoal;
    }

    public final String getTeamHash(){
        return mHash;
    }
}
