package Game.Field;

import Game.GameTeam;
import Game.IPlayerObject;
import Game.PlayerState;
import Game.PlayerStrategy.IPlayerStrategy;
import PhysicsEngine.Movements.MovementAction;
import PhysicsEngine.Movements.MovementEngine;
import PhysicsEngine.Movements.MovementInstruction;
import PhysicsEngine.Vector;
import Tuple.Tuple2;

public class GamePlayer extends FieldObject implements IPlayerObject {
//    Find a better location than Field Package

    private GameTeam mTeam = null;
    private final String mName;
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
    public void setPlayerState(final MovementEngine engine, final PlayerState state) {
//        For now we accept any state. We will figure out a way to verify the engine is ours
        playerState = state;
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
    public void calculateMove() {
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
    void takeField(final GameField field) {
        if(mOwner != null){
//            Handle logging due to attempted overwrite of field
            return;
        }
        mOwner = field;
        clearMovementInstruction(field);
    }
}
