package Game;

import Game.Field.Field;
import Game.Field.Location;
import Game.Field.Vector;
import Observable.Observer;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

import java.util.*;

public final class GameField{
//    This should also keep track of the ability of a player to be able to see the "ball carrier"
//    This should be based on a players awareness as well as location and eventually weather (if we ever get that far).

    private class FieldLockException extends RuntimeException{}
    private Observer playerLocationObserver = new Observer() {

        @Override
        public final void updateObserver(Object key, Object itemChanged) {
//            Assume it is the only key we have right now
//            This is ugly, fix it
            Tuple2<Double, Double> tuple = (Tuple2<Double, Double>) itemChanged;
            Location location = new Location(tuple.getFirst(), tuple.getSecond());
            IFieldObject playerInQuestion = getPlayerFromExactLocation(location);
            if(playerInQuestion == null){
                System.out.println("Invalid something or other");
            }
            playerInQuestion.setLocationState(GameField.this, mField.getLocationState(location));
        }
    };

    private final List<Enum> playerObservingKeys =
            Arrays.asList(Location.LocationKey.LOCATION_UPDATED_KEY);

    private final Field mField;
    private final List<MovementInstruction> mMovementQueue = new ArrayList<>();
    private String mFieldLock = null;
    private final static int DEFAULT_X_LOCATION = -1;
    private final static int DEFAULT_Y_LOCATION = -1;

//    Determine what you want to do with this
    private Map<GamePlayer, Location> mPlayersToLocations = new HashMap<>();
    private Map<Location, GamePlayer> mLocationToPlayers  = new HashMap<>();

    public GameField(final Field field){
        if(field == null) throw new NullPointerException("Field Cannot be null");
        mField = field;
    }

    private final IFieldObject getPlayerFromExactLocation(final Location location){
        if(mLocationToPlayers.containsKey(location)) {
            return mLocationToPlayers.get(location);
        }else{
            List<IFieldObject> playersInSpace = getPlayersInLocation(location, 0);
            if(playersInSpace.size() > 1){
//                Handle logging due to something mathematically broken
                System.out.println("Something is broken and more than 1 player was returned for the ");
                throw new RuntimeException("Multiple Players In Exact Same Space");
            }
            return playersInSpace.get(0);
        }
    }

    public final boolean isFieldLocked(){
        return mFieldLock != null;
    }

    public final void setBallCarrier(final GamePlayer player){
        if(isFieldLocked()){
//            Handle logging due to fuckery attempt
            System.out.println("You cannot change the ballcarrier manually while the field is locked");
            return;
        }
        if(!mPlayersToLocations.containsKey(player)){
//            Handle logging due to "possessing" player not being on the field
            System.out.println("Requested possession player is not on the field. Throwing exception");
            throw new RuntimeException("Unable to set BallCarrier status of player "+player.getName()+" | Player is not on field. Please check logs");
        }
        player.setIsBallCarrier(true);
    }

//    Should be called every time a new play is executed.
    public final String lock(){
        if(isFieldLocked()) throw new FieldLockException();
        clearMovementQueue();
        clearPlayersHistory();
        mFieldLock = UUID.randomUUID().toString();
        return toString().substring(0, toString().length()/2) + mFieldLock + toString().substring(toString().length()/2);
    }

//    Should be called as soon as the play execution is finished.
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

    private final void clearPlayersHistory(){
        for(GamePlayer player : mPlayersToLocations.keySet()){
            player.clearMovementHistory(this);
        }
    }

    public final IFieldObject DEBUG_requestBallCarrierLocation(){
        for(GamePlayer player : mPlayersToLocations.keySet()){
            if(player.isBallCarrier()) return player;
        }
//        Handle logging due to inability to find player on field
        System.out.println("No ball carrier found");
        return null;
    }

    public final Tuple2<Double, Double> requestPlayerLocation(final GamePlayer player){
        if(!player.isOnField() || !mPlayersToLocations.containsKey(player)){
//            handle logging due to player not being on this field
            return null;
        }
        return mPlayersToLocations.get(player).getLocation();
    }

    public final void addPlayer(final GamePlayer newPlayer, final Location startingLocation){
        if(mPlayersToLocations.containsKey(newPlayer) || newPlayer.isOnField() || mLocationToPlayers.containsKey(startingLocation)){
//            Handle logging of invalid player/ownership
            return;
        }
        newPlayer.placeOnField(this);
        mPlayersToLocations.put(newPlayer, startingLocation);
        mLocationToPlayers.put(startingLocation, newPlayer);
        startingLocation.registerObserver(newPlayer);
        for(Enum key : playerObservingKeys){
            startingLocation.registerObserver(key, playerLocationObserver);
        }
        startingLocation.updateObservers(Location.LocationKey.LOCATION_UPDATED_KEY, startingLocation.getLocation());
    }

    public final void addPlayer(final GamePlayer newPlayer){
        addPlayer(newPlayer, new Location(DEFAULT_X_LOCATION, DEFAULT_Y_LOCATION));
    }

//     Remember to remove the player you are comparing this to, from the list it returns.
    public final List<IFieldObject> getPlayersInLocation(final Location location, final double distanceCheck){
        final List<IFieldObject> players = new ArrayList<>();
        for(Location l : mLocationToPlayers.keySet()){
            if(location.getDistanceFromLocation(l) <= distanceCheck){
                players.add(mLocationToPlayers.get(l));
            }
        }
        return players;
    }

    public final void removePlayer(final GamePlayer player){
        if (!mPlayersToLocations.containsKey(player) || !player.isOnField()) {
//          Handle logging of player not being on field
            return;
        }
        mPlayersToLocations.get(player).unregisterObserver(player);
        mPlayersToLocations.get(player).unregisterObserver(playerLocationObserver);
        mLocationToPlayers.remove(mPlayersToLocations.get(player));
        mPlayersToLocations.remove(player);
    }

    public final void requestMovement(final MovementInstruction instruction){
        if(!isFieldLocked()){
//            Consider having this manually move players, instead of forcing through the
//            MovementEngine

//            Handle logging due to field not being locked. Do not process instruction.
            System.out.println(instruction.getPlayer().getName()+" | Unable to process movement request due to field not being locked");
            return;
        }
        mMovementQueue.add(instruction);
    }

    public final List<MovementInstruction> getMovementQueue(){
        return new ArrayList<>(mMovementQueue);
    }

    public final void clearMovementQueue(){
        mMovementQueue.clear();
    }

    public final void movePlayer(final GamePlayer player, final Vector vector){
//        Figure out how to secure this a bit more
        mPlayersToLocations.get(player).move(vector);
    }
}
