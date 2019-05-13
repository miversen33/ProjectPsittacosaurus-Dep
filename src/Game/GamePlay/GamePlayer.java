package Game.GamePlay;

import Game.Field.Endzone;
import Game.Field.Field;
import Game.Field.FieldObject;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Game.IPlayerObject;
import Game.PlayerState;
import PhysicsEngine.Movements.MovementEngine;
import PhysicsEngine.Movements.MovementInstruction;
import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;
import Utils.Signature;

import java.util.ArrayList;
import java.util.List;

public final class GamePlayer extends FieldObject implements IPlayerObject {
//    Find a better location than Field Package

    private GameTeam mTeam = null;
    private final String mName;
//    Consider having the GamePlayer owner be the GameManager object instead of the GameField
//    Then you can have the GameManager be a "middle" man for the 2, and allows the GamePlayer
//    to only have access to what they need access to. Plus the GamePlayer will need access to
//    the clock anyway, which will only be available in the GameManager
//    private GameField mOwner;
    private GameManager mManager;
    private MovementInstruction mCurrentInstructions;

//    private final Player player = null;
    private PlayerState playerState = PlayerState.NULL;

    private IPlayerStrategy mPlayerStrat;

    private boolean BALLCARRIER_FUCK_IS_THIS = false;

    public GamePlayer(double mass, final String name, final IPlayerStrategy playerLogic, final Signature signature) {
        super(mass, signature);
        mName = name;
        setPlayerStrategy(playerLogic);
    }
//    // Eventually
//    public GamePlayer(final GameTeam mTeam, final Player player, final IPlayerStrategy strategy) {
//        super(player.getMass());
//    }

    public final void assignTeam(final GameTeam team){
        mTeam = team;
    }

    final void assignManager(final GameManager manager){
        if(mManager != null){
//            Log invalid attempt to overwrite game manager
            System.out.println("Cannot overwite existing game manager in game player");
            return;
        }
        mManager= manager;
    }

    public final List<PlayerInfluence> getPlayerInfluenceBiases(){
//        Eventually this needs to be populated with individualized player influences.
//        TODO
        return new ArrayList<>();
    }

    public final void DEBUG_setBallCarrier(final boolean isBallCarrier){
//        Who cares about security, this is the worst thing in existence anyway
        BALLCARRIER_FUCK_IS_THIS = isBallCarrier;
    }

    public final boolean DEBUG_isBallCarrier(){
        return BALLCARRIER_FUCK_IS_THIS;
    }

//    Recommended way to fetch ball carrier
    public final GamePlayer getBallCarrier(){
        return getOwner().getBallCarrier(this);
    }

//    public final void setPlayerStrategy(final Player owningPlayer, final IPlayerStrategy newStrat){
    public final void setPlayerStrategy(final IPlayerStrategy newStrat){
        mPlayerStrat = newStrat;
    }

    private final void requestMovement(final MovementInstruction requestedLocation){
        if(requestedLocation == null){
//            Handle logging due to location not existing
//            Refuse to move player
            System.out.println(getName()+" | Unable to process movement as requested location does not exist");
            return;
        }
        if(!isOnField()) {
//            Handle logging due to player not being on the field
//            Refuse to move player
            System.out.println(getName()+" | Unable to process movement as we are not currently on the field");
            return;
        }
        else {
            setMovementInstruction(requestedLocation);
        }
    }

    @Override
    public final Endzone getTeamGoal() {
        return mTeam.getGoal();
    }

    @Override
    public final String getName() {
        return mName;
    }

    @Override
    public final String getOwnerHash() {
        return mTeam.getTeamHash();
    }

    @Override
    public final String getPlayerHash() {
        return "NO HASH SET";
    }

    @Override
    public final PlayerState getPlayerState() {
        return playerState;
    }

    @Override
    public final PlayerState getMovementState(){
        if(getMovementInstruction() == null) return PlayerState.NULL;
        return getMovementInstruction().getAction().getActionState();
    }

    @Override
    public String toString() {
        return getName()+" | "+getLocation();
    }

    @Override
    public final void setPlayerState(final MovementEngine engine, final PlayerState state) {
//        For now we accept any state. We will figure out a way to verify the engine is ours
        if(!Signature.ValidateSignatures(mTeam.getSignature(), engine.getSignature())){
//            Log invalid movement engine. Do not allow state change
//            TODO
            return;
        }
        playerState = state;
    }

    @Override
    public boolean sameTeamCheck(final GamePlayer comparePlayer) {
        return comparePlayer.mTeam.equals(mTeam);
    }

////    TODO
//    We will need to come back to this
//    public final boolean useRoute(final IRouteInterpreter routeInterpreter){
////        Check the grade the route viability is given, then decide if we want to use it or not
////        For now, we will always return true
//        if(routeInterpreter == null){
//            System.out.println("Ya the route interpreter shouldn't be null");
//            return false;
//        }
//        return true;
//    }

    final void clearMovementInstruction(final GameField field){
        if(!(getOwner().equals(field))){
//            Handle logging due to invalid field
//            TODO
        }
        setMovementInstruction(new MovementInstruction(this, new Vector(0,0)));
    }

    public final Field.Side getSideOfField(){
        return Field.GetSideOfField(getLocation());
    }

    public final void setMovementInstruction(final MovementEngine engine, final MovementInstruction instruction){
        if(!Signature.ValidateSignatures(mTeam.getSignature(), engine.getSignature())){
//            Log invalid engine.
//            TODO
            return;
        }
        setMovementInstruction(instruction);
    }

    private final void setMovementInstruction(final MovementInstruction instruction){
        final double direction = instruction.getVector().getDirection();
        final double magnitude = instruction.getVector().getMagnitude() > getMaxMovement(direction) ? getMaxMovement(direction) : instruction.getVector().getMagnitude();

        mCurrentInstructions = new MovementInstruction(instruction.getAction(), new Vector(direction, magnitude));
    }

    public final MovementInstruction getMovementInstruction(){
//        Consider a way to verify who is requesting this.
//        The only ones who should be requesting this are "this", the GameField, and the MovementEngine
        return mCurrentInstructions;
    }

    @Override
    public final void calculateMove() {
//        Consider making this different from the IPlayerObject
        if(!isOnField()){
//            Handle logging due to trying to move player while player is not on field
            System.out.println(getName()+" | Unable to move player due to player not being on field");
            return;
        }
        mPlayerStrat.calculateMove(this, getOwner());
        requestMovement(mPlayerStrat.getMove());
    }

    @Override
    public final void updateObserver(Object key, Tuple2<Double, Double> itemChanged) {
        provideTimeStamp(mManager.getTimeStamp());
        super.updateObserver(key, itemChanged);
//        If we reach here, we can assume that the movement instruction has been executed
//        if(mCurrentInstructions != null && mCurrentInstructions.hasBeenExecuted()) timeStampMovement();
    }

    private final void timeStampMovement(){
//        if(mCurrentInstructions.getAction().getActionState().isColliding()){
//            mCurrentInstructions.setUsedTime(MovementInstruction.COLLISION_USED_TIME);
//        } else {
//            mCurrentInstructions.setUsedTime(MovementInstruction.DEFAULT_USED_TIME);
//        }
    }
}
