package Game;

import Game.Field.Location;
import Game.Field.PlayerLocationState;
import Game.Field.Vector;
import Game.PlayerStrategy.IPlayerStrategy;
import Observable.Observer;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;


public final class GamePlayer implements Observer {

    private GamePlayerOwner mTeam;
    private GameField mOwner = null;
    private final String mName;
    private IPlayerStrategy mStrategy;
    private PlayerState mPlayerState = null;
    private Tuple2<Double, Double> mLocation = new Tuple2<Double, Double>(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
    private List<Vector> mPreviousLocations = new ArrayList<>();
    private PlayerLocationState mLocationState = null;

    public GamePlayer(final String name, final IPlayerStrategy playerStrategy){
//        Save the Hash from the Game.GameTeam
        mName = name;
        setStrategy(playerStrategy);
    }

//    This is handled automatically by the GameField.
//    IE the field automatically registers and unregisters the GamePlayer as an observer
//    of its location
    @Override
    public final void updateObserver(Object key, Object itemChanged) {
        if(key.equals(Location.LocationKey.LOCATION_UPDATED_KEY)) mLocation = (Tuple2<Double, Double>) itemChanged;
        if(key.equals(Location.LocationKey.LOCATION_VECTOR_KEY))  mPreviousLocations.add((Vector) itemChanged);
    }

    public final Tuple2<Double, Double> getLocation(){
        return mLocation;
    }

    public final void setStrategy(final IPlayerStrategy playerStrategy){
        mStrategy = playerStrategy;
    }

    public final void assignTeam(final GamePlayerOwner team){
        if(mTeam != null){
//            Handle logging of already owned player.
//            Refuse to assign new owner
            return;
        }
        mTeam = team;
    }

    public final String getTeamHash(){
        return mTeam.getTeamHash();
    }

//    At some point create logic here so we can determine goal point logic
    public final Tuple2<Double, Double> getGoal(){
//        For now we are just going to return the endzone
        return mTeam.getGoal();
    }

    final void placeOnField(final GameField field){
        if(mOwner != null){
//            Handle logging of invalid field assignment
//            due to player already being assigned field.
//            refuse to assign new field
            return;
        }
        mOwner = field;
        mPreviousLocations.clear();
        mLocation = new Tuple2<>(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        mPlayerState = PlayerState.UP;
    }

    final void setLocationState(final GameField field, final PlayerLocationState newState){
        if(!field.equals(mOwner)){
//            Yell some profanity for trying to abuse the system
//            Log event and do not do anything
            return;
        }
        mLocationState = newState;
    }

    final void setPlayerState(final GameField field, final PlayerState newState){
        if(!field.equals(mOwner)){
//            Handle incorrect parent attempting change
//            Log event and do nothing
            return;
        }
        mPlayerState = newState;
    }

    public final PlayerLocationState getLocationState(){
        return mLocationState;
    }

    public final PlayerState getPlayerState(){
        return mPlayerState;
    }

    public final void removeFromField(){
        if(mOwner == null){
//            Log null Field
            return;
        }
        mOwner.removePlayer(this);
        mOwner = null;
        mLocationState = null;
        mPlayerState = null;
    }

    public final String getName(){
        return mName;
    }

    public final boolean isOnField(){
        return mOwner != null;
    }

    public final void calculateMovement(){
        mStrategy.calculateMove(this, mOwner);
        requestMovement(mStrategy.getMove());
    }

    private final void requestMovement(final MovementInstruction requestedLocation){
        if(requestedLocation == null){
//            Handle logging due to location not existing
//            Refuse to move player
            System.out.println(getName()+"| Unable to process movement as requested location does not exist");
            return;
        }
        if(!isOnField()) {
//            Handle logging due to player not being on the field
//            Refuse to move player
            System.out.println(getName()+" | Unable to process movement as we are not currently on the field");
            return;
        } else {
            mOwner.requestMovement(requestedLocation);
        }
    }
}
