package Game;

import Game.Field.Field;
import Game.Field.Location;
import Game.Field.Vector;
import Observable.Observer;
import PhysicsEngine.MovementInstruction;
import Tuple.Tuple2;

import java.util.*;

public final class GameField{

    private class FieldLockException extends RuntimeException{}
    private Observer playerLocationObserver = new Observer() {

        @Override
        public final void updateObserver(Object key, Object itemChanged) {
//            Assume it is the only key we have right now
//            This is ugly, fix it
            Tuple2<Double, Double> tuple = (Tuple2<Double, Double>) itemChanged;
            Location location = new Location(tuple.getFirst(), tuple.getSecond());
            GamePlayer playerInQuestion = getPlayerFromExactLocation(location);
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

    private final GamePlayer getPlayerFromExactLocation(final Location location){
        if(mLocationToPlayers.containsKey(location)) {
            return mLocationToPlayers.get(location);
        }else{
            List<GamePlayer> playersInSpace = getPlayersInLocation(location, 0);
            if(playersInSpace.size() > 1){
//                Handle logging due to something mathematically broken
                System.out.println("Something is broken and more than 1 player was returned for the ");
                throw new NullPointerException("Not actually null pointer, Just dont feel like creating a new one for multiple players in one space");
            }
            return playersInSpace.get(0);
        }
    }

    public final boolean isFieldLocked(){
        return mFieldLock != null;
    }

    public final String lock(){
        if(isFieldLocked()) throw new FieldLockException();
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
        mPlayersToLocations.put(newPlayer, startingLocation);
        mLocationToPlayers.put(startingLocation, newPlayer);
        newPlayer.placeOnField(this);
        startingLocation.registerObserver(newPlayer);
        for(Enum key : playerObservingKeys){
            startingLocation.registerObserver(key, playerLocationObserver);
        }
    }

    public final void addPlayer(final GamePlayer newPlayer){
        addPlayer(newPlayer, new Location(DEFAULT_X_LOCATION, DEFAULT_Y_LOCATION));
    }

//     Remember to remove the player you are comparing this to, from the list it returns.
    public final List<GamePlayer> getPlayersInLocation(final Location location, final double distanceCheck){
        final List<GamePlayer> players = new ArrayList<>();
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
