package Game.Field;

import PhysicsEngine.Movements.Movement;
import PhysicsEngine.PhysicsObject;
import PhysicsEngine.Vector;
import Tuple.Tuple2;
import Utils.DEBUG_FRAME_INFO;
import Utils.Location;
import Utils.Observable.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class FieldObject extends PhysicsObject implements Observer<Tuple2<Double, Double>> {

    private final static int FRAME_LIMIT = DEBUG_FRAME_INFO.FRAME_LIMIT_PER_SECOND;

    private final List<Movement> movements = new ArrayList<>();
    private Vector currentMovement = new Vector(0,0);
    private Location currentLocation = null;
    private PlayerLocationState locationState = PlayerLocationState.OutOfBounds;
    private GameField mOwner;

    public FieldObject(double mass) {
        super(mass);
    }

    abstract void takeField(final GameField field);

    private final void handleLocationChange(final Tuple2<Double, Double> newLocation){
        if(currentLocation != null) movements.add(0, new Movement(currentLocation.getLocation(), currentMovement));
        currentMovement = new Vector(currentLocation.getLocation(), newLocation);
        currentLocation = new Location(newLocation);

        setCurrentMovement(currentMovement);
        if(movements.size() > FRAME_LIMIT){
            Vector previousMove = movements.get(FRAME_LIMIT).getMovement();
            setAcceleration((currentMovement.getMagnitude()-previousMove.getMagnitude())/FRAME_LIMIT);
        }
        locationState = Field.GetLocationState(new Location(getLocation()));
    }

    final boolean isOwner(final GameField field){
        return field.equals(mOwner);
    }

    final void placeOnField(final GameField owner){
        if(owner == null){
//            Log attempted override of mOwner
//            TODO
            return;
        }
        this.mOwner = owner;
        clearMovementsQueue(owner);
        takeField(mOwner);
    }

    final void removeFromField(final GameField owner){
        if(!(owner.equals(mOwner))){
//            Refuse to remove from field as its the wrong owner
            return;
        }
        clearMovementsQueue(owner);
        mOwner = null;
    }

    public final void clearMovementsQueue(final GameField owner){
        if (!(owner.equals(mOwner))) {
//            Spit out some shit about being the wrong field
            return;
        }
        movements.clear();
        currentMovement = new Vector(0,0);
        currentLocation = new Location(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    public final boolean isOnField() {
        return mOwner != null;
    }

    public final Tuple2<Double, Double> getLocation(){
        return currentLocation.getLocation();
    }

    public final Tuple2<Double, Double> getPreviousLocation(final int location){
        if(movements.size() == 0) return currentLocation.getLocation();
        if(location >= movements.size()) return movements.get(0).getEndingLocation();
        return movements.get(location).getEndingLocation();
    }

    public final Vector getPreviousMovement(){
        return getPreviousMovement(0);
    }

    public final Vector getPreviousMovement(int numberOfMovesBack){
        if(movements.size() <= numberOfMovesBack){
//            If they want a movement that is further back than we have available, just return the furthest movement available
            return movements.get(movements.size()-1).getMovement();
        } else {
            return movements.get(numberOfMovesBack).getMovement();
        }
    }

    @Override
    public void updateObserver(Object key, Tuple2<Double, Double> itemChanged) {
        if(key.equals(Location.LocationKey.LOCATION_UPDATED_KEY)){
            handleLocationChange(itemChanged);
        }
    }

    public final int getNumberOfMovementsMade(){
        return movements.size();
    }
}
