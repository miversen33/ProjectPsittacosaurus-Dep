package PhysicsEngine.Movements;

import Game.GamePlay.GamePlayer;
import PhysicsEngine.Vector;
import Tuple.Tuple2;
import Utils.Location;

public final class MovementInstruction implements Comparable<MovementInstruction> {
    private final GamePlayer mPlayer;
    private final Vector mVector;
    private final MovementAction mAction;
    private boolean isExecuted = false;
    private int totalTimeInSeconds;

    private final static int GREATER_THAN = 1;
    private final static int EQUALS = 0;
    private final static int LESS_THAN = -1;

    public final static int COLLISION_USED_TIME = 200;
    public final static int DEFAULT_USED_TIME = 1000;

    public MovementInstruction(final GamePlayer player, final Vector vector){
        mPlayer = player;
        mVector = vector;
        mAction = new MovementAction();
    }

    public MovementInstruction(final MovementAction action, final Vector vector){
        mPlayer = action.getAffectingPlayer();
        mVector = vector;
        mAction = action;
    }

    public final GamePlayer getPlayer(){
        return mPlayer;
    }

    public final Vector getVector(){
        return mVector;
    }

    public final Location getEndingLocation(){
        return new Location(new Tuple2<>(
                mPlayer.getLocation().getFirst() + mVector.getChangeX(),
                mPlayer.getLocation().getSecond() + mVector.getChangeY()));
    }

    public final MovementAction getAction(){
        return mAction;
    }

    public final boolean hasBeenExecuted(){
        return isExecuted;
    }

    final void execute(){
//        Consider a way to verify ownership here
        isExecuted = true;
    }

    public final void setUsedTime(final int time){
        totalTimeInSeconds = time;
    }

    public final int getUsedTime(){
        return totalTimeInSeconds;
    }

    @Override
    public final int compareTo(final MovementInstruction movementInstruction) {
        final MovementAction.State theirState = movementInstruction.getAction().getActionState();
        final MovementAction.State ourState   = getAction().getActionState();
        if(ourState.isColliding() || theirState.isColliding()) return handleCollisionComparison(movementInstruction);
        if(getPlayer().getBallCarrier().equals(getPlayer())) return LESS_THAN;
        if(getPlayer().getBallCarrier().equals(movementInstruction.getPlayer())) return GREATER_THAN;
        return handleDistanceFromBallCarrier(movementInstruction.getPlayer());
    }

    private final int handleCollisionComparison(final MovementInstruction movementInstruction){
        if(getAction().getAffectedPlayer().equals(movementInstruction.getAction().getAffectingPlayer()) ||
          (getAction().getAffectingPlayer().equals(movementInstruction.getPlayer()))) return EQUALS;
        if(getAction().getActionState().isColliding()) return LESS_THAN;
        return GREATER_THAN;
    }

    private final int handleDistanceFromBallCarrier(final GamePlayer compareToPlayer){
        final double usToBallCarrier = Location.GetDistance(getPlayer().getBallCarrier(), getPlayer());
        final double themToBallCarrier = Location.GetDistance(getPlayer().getBallCarrier(), compareToPlayer);
        if(usToBallCarrier <= themToBallCarrier) return LESS_THAN;
        return GREATER_THAN;
    }
}
