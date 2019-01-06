package Game;

import Game.Field.Location;
import Game.Field.PlayerLocationState;
import Game.PlayerStrategy.IPlayerStrategy;
import Observable.Observer;
import PhysicsEngine.Movement;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;


public final class GamePlayer implements Observer, IFieldObject {

//    This should be pulled from the attributes when we get that far. It should be either acceleration or speed,
//    depending on if we have finished accelerating or not
//    Measured in Feet Per Second
    private final static double MAX_VELOCITY = 3;

    private IGamePlayerOwner mTeam;
    private GameField mOwner = null;
    private final String mName;
    private IPlayerStrategy mStrategy;
    private PlayerState mPlayerState = null;
    private Tuple2<Double, Double> mLocation = new Tuple2<Double, Double>(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
    private final List<Movement> mMovements = new ArrayList<>();
    private PlayerLocationState mLocationState = null;
    private double currentVelocity;
//    ICKY NOPE FIX TODO
    private boolean ballCarrier = false;

    public GamePlayer(final String name, final IPlayerStrategy playerStrategy){
//        Save the Hash from the Game.IGameTeam
        mName = name;
        setStrategy(playerStrategy);
    }

//    This is handled automatically by the GameField.
//    IE the field automatically registers and unregisters the GamePlayer as an observer
//    of its location
    @Override
    public final void updateObserver(Object key, Object itemChanged) {
        if(key.equals(Location.LocationKey.LOCATION_UPDATED_KEY)){
            Tuple2 previousLocation = mLocation;
            mLocation = (Tuple2<Double, Double>) itemChanged;
            mMovements.add(new Movement(previousLocation, mLocation));
        }
    }

    protected final void clearMovementHistory(final GameField owner){
        if(mOwner != owner){
//            Log invalid attempt to change player
            System.out.println("Cant clear movement history as the field passed is not correct");
            return;
        }
        mMovements.clear();
    }

    @Override
    public final Tuple2<Double, Double> getLocation(){
        return mLocation;
    }

//    previousDistance needs to be the number of steps previous you want.
//    IE, if you want the place 10 steps back, you would pass 10 as the param.
//    If there aren't enough previous positions, we will just pass the furthest back we have.
//    If there are no previous positions, we will pass back our current location
    @Override
    public final Tuple2<Double, Double> getPreviousLocation(final int previousDistance){
        if(mMovements.isEmpty()){
            return getLocation();
        }
        if((mMovements.size()-1) < previousDistance){
            return mMovements.get(0).getEndingLocation();
        }
        return mMovements.get((mMovements.size()-1)-previousDistance).getEndingLocation();
    }

    public final void setStrategy(final IPlayerStrategy playerStrategy){
        mStrategy = playerStrategy;
    }

    public final void assignTeam(final IGamePlayerOwner team){
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
        return mStrategy.calculateGoal(this, mOwner, mTeam);
    }

    final void setIsBallCarrier(final boolean isBallCarrier){
//        We are trusting this is coming from the field. We should probably have a way to secure that a bit. For now, package level methods will work
        ballCarrier = isBallCarrier;
    }

    public final boolean isBallCarrier(){
        return ballCarrier;
    }

    final void placeOnField(final GameField field){
        if(mOwner != null){
//            Handle logging of invalid field assignment
//            due to player already being assigned field.
//            refuse to assign new field
            return;
        }
        mOwner = field;
        mMovements.clear();
        mLocation = new Tuple2<>(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        mPlayerState = PlayerState.UP;
    }

    @Override
    public final void setLocationState(final GameField field, final PlayerLocationState newState){
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

    @Override
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

    @Override
    public final boolean isOnField(){
        return mOwner != null;
    }

    public final void calculateMovement(){
        if(!isOnField()){
//            Handle logging due to trying to move player while player is not on field
            System.out.println(getName()+" | Unable to move player due to player not being on field");
            return;
        }
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
