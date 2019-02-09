package Game.GamePlay;

import Game.Field.Field;
import PhysicsEngine.Movements.MovementEngine;
import PhysicsEngine.Vector;
import Tuple.Tuple2;
import Utils.Exceptions.FieldLockException;
import Utils.Location;
import Utils.Location.LocationKey;
import Utils.Observable.Observer;

import java.util.*;

public final class GameField {

    private String mFieldLock;
    private final FieldLockException fieldLockException = new FieldLockException();
    private final Field mField;
    private Map<GamePlayer, Location> mPlayers = new HashMap<>();
    private Map<Location, GamePlayer> mLocationMap = new HashMap<>();
    private final LocationKey observerKey = LocationKey.LOCATION_UPDATED_KEY;
    private final LocationObserver playerLocationObserver = new LocationObserver();

    public GameField(final Field field){
        if(field == null) throw new NullPointerException("Field Cannot be null");
        mField = field;
    }

    public final List<GamePlayer> checkLocation(final GamePlayer player, final double radius){
        final List<GamePlayer> playersInLocation = new ArrayList<>();
        final List<Location> offendingLocations = new ArrayList<>();
        final Location playerLocation = mPlayers.get(player);
        for(final Location l : mLocationMap.keySet()){
            if(Location.GetDistance(playerLocation, l) <= radius) offendingLocations.add(l);
        }
//        Very high chance this breaks
        offendingLocations.sort((Comparator.comparingDouble(firstLocation -> Location.GetDistance(playerLocation, (Location) firstLocation))).reversed());

        for(final Location l : offendingLocations){
            playersInLocation.add(mLocationMap.get(l));
        }
        playersInLocation.remove(player);
        return playersInLocation;
    }

    public final void signEngine(final MovementEngine engine){
//        Check to see if we already have an engine. Yell if we do. Otherwise
//        Sign engine. Store it as our engine.
    }

    public final String lock(){
        if(isLocked()) throw new FieldLockException();
        clearMovements();

        mFieldLock = UUID.randomUUID().toString();
        return toString().substring(0, toString().length()/2) + mFieldLock + toString().substring(toString().length()/2);
    }

    public final boolean unlock(final String key){
        final String firstHalf = toString().substring(0, toString().length()/2);
        final String secondHalf = toString().substring(toString().length()/2);
        final String strippedKey = key.substring(firstHalf.length(), key.length()-secondHalf.length());
        if (mFieldLock.equals(strippedKey)) {
            mFieldLock = null;
            return true;
        } else {
            return false;
        }
    }

    public final boolean validateEngine(final MovementEngine engine){
//        Handle validity check
        return true;
    }

    public final boolean isLocked(){
        return mFieldLock != null;
    }

    public final void addPlayer(final GamePlayer newPlayer, final Location startingLocation){
        if(newPlayer.isOnField() || mPlayers.containsKey(newPlayer) || mLocationMap.containsKey(startingLocation)){
//            Handle logging due to invalid player/ownership on field
            return;
        }
        newPlayer.placeOnField(this);
        mPlayers.put(newPlayer, startingLocation);
        mLocationMap.put(startingLocation, newPlayer);
        startingLocation.registerObserver(newPlayer);
        startingLocation.registerObserver(playerLocationObserver);
        startingLocation.updateObservers(LocationKey.LOCATION_UPDATED_KEY, startingLocation.getLocation());
    }

    public final void removePlayer(final GamePlayer player){
        if(!player.isOnField() || !mPlayers.containsKey(player) || !mLocationMap.containsValue(player)){
//            Handle logging due to player not being on the field
            return;
        }
        mPlayers.get(player).unregisterObserver(playerLocationObserver);
        mPlayers.get(player).unregisterObserver(player);
        mLocationMap.remove(mPlayers.get(player));
        mPlayers.remove(player);
    }

    public final void movePlayer(final MovementEngine engine, final GamePlayer player, final Vector movement){
//        Validate engine
        mPlayers.get(player).move(movement);
    }

    public final void giveMovementsToEngine(final MovementEngine engine){
//        Validate engine
        engine.cycleQueue(new ArrayList<>(mPlayers.keySet()), this);
    }

//    TODO
    public final GamePlayer getBallCarrier(final GamePlayer currentPlayer){
//        This should check to see if the player knows where the ball carrier is
        for(final GamePlayer player : mPlayers.keySet()){
            if(player.DEBUG_isBallCarrier()) return player;
        }
//        Shit gonna break
        return null;
    }

    private final void handlePlayerLocationMoved(final GamePlayer player, final Location newLocation){
//        Set listen for endzone/out of bounds of player. Should be
//        pretty easy though
    }

    private final void clearMovements(){
        for(final GamePlayer player : mPlayers.keySet()){
            player.clearMovementInstruction(this);
        }
    }

    /**
     * Probably should consider moving this to its own class
     * instead of making it an inner class
     */
    class LocationObserver implements Observer<Tuple2<Double, Double>>{

        @Override
        public void updateObserver(Object key, Tuple2<Double, Double> newLocation) {
//            The only way we get here is if we have a key registered,
//            or if a null key is passed. So check to see if
//            its null (in which we need to update the entire object, ps, thats bad and should probably be removed later)
//            if its not, figure out which key we got.
//            if(key.equals(Observable.NULL_KEY)) handleNullObserverKey(newLocation);
            if(key.equals(observerKey)) handleLocationMoved(newLocation);
        }


        private final void handleLocationMoved(final Tuple2<Double, Double> locationMoved){
            final Location newLocation = new Location(locationMoved);
//            This might not be as clean as we would hope.
            handlePlayerLocationMoved(mLocationMap.get(newLocation), newLocation);
        }
    }

}