package Game.GamePlay;

import Game.Field.StateMachine.FieldObjectState;
import Game.GamePlay.Events.PlayerOutOfBoundsEvent;
import Game.GamePlay.Events.PlayerInEndzoneEvent;
import PhysicsEngine.Movements.MovementEngine;
import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;
import Game.Field.FieldLockException;
import Game.Utils.Location;
import Game.Utils.Location.LocationKey;
import Utils.Signature;

import java.util.*;

public final class GameField {

    private String mFieldLock;
    private final FieldLockException fieldLockException = new FieldLockException();
    private Map<GamePlayer, Location> mPlayers = new HashMap<>();
    private Map<Location, GamePlayer> mLocationMap = new HashMap<>();
    private final Signature mSignature;
    private final double COLLISION_DISTANCE_CHECK = 2;

    public GameField(final Signature signature){
        mSignature = signature;
    }

    public final List<GamePlayer> checkLocation(final GamePlayer player, final double radius){
        final List<GamePlayer> playersInLocation = new ArrayList<>();
        final List<Location> offendingLocations = new ArrayList<>();
        final Location playerLocation = mPlayers.get(player);
        for(final Location l : mLocationMap.keySet()){
            if(Location.GetDistance(playerLocation, l) <= radius) offendingLocations.add(l);
        }
        offendingLocations.sort((Comparator.comparingDouble(firstLocation -> Location.GetDistance(playerLocation, (Location) firstLocation))).reversed());

        for(final Location l : offendingLocations){
            playersInLocation.add(mLocationMap.get(l));
        }
        playersInLocation.remove(player);
        return playersInLocation;
    }

    public final List<GamePlayer> checkLocation(final Tuple2<Double, Double> location, final double radius){
        final List<GamePlayer> playersInLocation = new ArrayList<>();
        final List<Location> offendingLocations = new ArrayList<>();
//        final Location playerLocation = mPlayers.get(player);
        for(final Location l : mLocationMap.keySet()){
            if(Location.GetDistance(new Location(location), l) <= radius && !l.getLocation().equals(location)) offendingLocations.add(l);
        }
        offendingLocations.sort((Comparator.comparingDouble(firstLocation -> Location.GetDistance(new Location(location), (Location) firstLocation))).reversed());

        for(final Location l : offendingLocations){
            playersInLocation.add(mLocationMap.get(l));
        }
        return playersInLocation;
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
        startingLocation.updateObservers(LocationKey.LOCATION_UPDATED_KEY, startingLocation.getLocation());
    }

    public final void removePlayer(final GamePlayer player){
        if(!player.isOnField() || !mPlayers.containsKey(player) || !mLocationMap.containsValue(player)){
//            Handle logging due to player not being on the field
            return;
        }
        mPlayers.get(player).unregisterObserver(player);
        mLocationMap.remove(mPlayers.get(player));
        mPlayers.remove(player);
    }

    public final void DEBUG_DumpPlayerLocations(){
        for(final GamePlayer player : mPlayers.keySet()) {
            System.out.println(player.getName() + " Location is | "+player.getLocation());
        }
    }

    /**
     * This will handle moving the player, and in return you will get a list of
     * all the players within "Collision Radius" of the moving player, after their
     * movement is complete
     */
    public final List<GamePlayer> movePlayer(final MovementEngine engine, final GamePlayer player, final Vector movement){
//        Validate engine
        if(!Signature.ValidateSignatures(mSignature, engine.getSignature())){
//            Log possible malicious attempt to move players. Do not move players
//            TODO
            System.out.println("Unable to verify engine");
            return null;
        }
        mPlayers.get(player).move(movement);
        List<GamePlayer> playersInSpace = checkLocation(player, COLLISION_DISTANCE_CHECK);
        if(player.getFieldState().equals(FieldObjectState.OutOfBounds)) new PlayerOutOfBoundsEvent(mSignature, player).fire();
        if(player.getFieldState().equals(FieldObjectState.Endzone)) new PlayerInEndzoneEvent(mSignature, player).fire();
        return playersInSpace;
    }

    final List<GamePlayer> getMovements(final Signature signature){
        if(Signature.ValidateSignatures(mSignature, signature)) return new ArrayList<>(mPlayers.keySet());
//        Handle possible malicious attempt at getting movement queue
//        TODO LOGGING
        return null;
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

    private final void clearMovements(){
        for(final GamePlayer player : mPlayers.keySet()){
            player.clearMovementInstruction(this);
        }
    }

}