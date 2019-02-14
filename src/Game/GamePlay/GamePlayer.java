package Game.GamePlay;

import Game.Field.Endzone;
import Game.Field.Field;
import Game.Field.FieldObject;
import Game.IPlayerObject;
import Game.PlayerState;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import PhysicsEngine.Movements.MovementEngine;
import PhysicsEngine.Movements.MovementInstruction;
import PhysicsEngine.PhysicsObjects.Vector;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer extends FieldObject implements IPlayerObject {
//    Find a better location than Field Package

    private GameTeam mTeam = null;
    private final String mName;
//    Consider having the GamePlayer owner be the GameManager object instead of the GameField
//    Then you can have the GameManager be a "middle" man for the 2, and allows the GamePlayer
//    to only have access to what they need access to. Plus the GamePlayer will need access to
//    the clock anyway, which will only be available in the GameManager
    private GameField mOwner;
    private MovementInstruction mCurrentInstructions;

    //    private final Player player = null;
    private PlayerState playerState = PlayerState.UP;

    private IPlayerStrategy mPlayerStrat;

    private boolean BALLCARRIER_FUCK_IS_THIS = false;

    public GamePlayer(double mass, final String name, final IPlayerStrategy playerLogic) {
        super(mass);
        mName = name;
        changePlayerStrategy(playerLogic);
    }

    public final void assignTeam(final GameTeam team){
        mTeam = team;
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
        return mOwner.getBallCarrier(this);
    }

//    // Eventually
//    public GamePlayer(final GameTeam mTeam, final Player player, final IPlayerStrategy strategy) {
//        super(player.getMass());
//    }

//    public final void changePlayerStrategy(final Player owningPlayer, final IPlayerStrategy newStrat){
    public final void changePlayerStrategy(final IPlayerStrategy newStrat){
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
    public final void setPlayerState(final MovementEngine engine, final PlayerState state) {
//        For now we accept any state. We will figure out a way to verify the engine is ours
        playerState = state;
    }

    @Override
    public boolean sameTeamCheck(final GamePlayer comparePlayer) {
        return comparePlayer.mTeam.equals(mTeam);
    }

    public final Tuple2<Double, Double> getGoal(){
        return mPlayerStrat.calculateGoal(this, mOwner, mTeam);
    }

    public final void clearMovementInstruction(final GameField field){
        if(!(mOwner.equals(field))){
//            Handle logging due to invalid field
        }
        setMovementInstruction(new MovementInstruction(this, new Vector(0,0)));
    }

    public final Field.Side getSideOfField(){
        return Field.GetSideOfField(getLocation());
    }

    public final void setMovementInstruction(final MovementEngine engine, final MovementInstruction instruction){
//        Pass Validity Check
        setMovementInstruction(instruction);
    }

    private final void setMovementInstruction(final MovementInstruction instruction){
        mCurrentInstructions = instruction;
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
        mPlayerStrat.calculateMove(this, mOwner);
        requestMovement(mPlayerStrat.getMove());
    }

    @Override
    public final void takeField(final GameField field) {
        if(mOwner != null){
//            Handle logging due to attempted overwrite of field
            return;
        }
        mOwner = field;
        clearMovementInstruction(field);
    }

    @Override
    public final void updateObserver(Object key, Tuple2<Double, Double> itemChanged) {
        super.updateObserver(key, itemChanged);
//        If we reach here, we can assume that the movement instruction has been executed
        if(mCurrentInstructions.hasBeenExecuted()) timeStampMovement();
    }

    private final void timeStampMovement(){
        if(mCurrentInstructions.getAction().getActionState().isColliding()){
            mCurrentInstructions.setUsedTime(MovementInstruction.COLLISION_USED_TIME);
        } else {
            mCurrentInstructions.setUsedTime(MovementInstruction.DEFAULT_USED_TIME);
        }
    }
}
