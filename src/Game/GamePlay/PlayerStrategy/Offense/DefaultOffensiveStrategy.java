package Game.GamePlay.PlayerStrategy.Offense;

import Game.*;
import Game.Field.Field;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.GameField;
import Game.GamePlay.PlayerInfluences;
import Utils.Location;
import PhysicsEngine.Movements.MovementInstruction;
import PhysicsEngine.PhysicsObjects.Vector;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;

//This is the "fallback" Offensive Player Strategy. This will likely be moved into OffensivePlayerStrategy, but for now it stays here
public class DefaultOffensiveStrategy extends OffensivePlayerStrategy{

//    About 2 yards
    private final static double ACTION_RADIUS = 6;
//    About 3 yards
    private final static double BLOCKER_RADIUS = 9;
    private final static double CENTER_WIDTH_IGNORE = .15;
    private final static int DEFENDER_DISTANCE_TO_POLL = 5;

    private MovementInstruction move = null;
    private Tuple2<Double, Double> mCacheGoal;

    public DefaultOffensiveStrategy() {
        super(0,0);
    }

    @Override
    public final void calculateMove(final GamePlayer hostPlayer, final GameField field) {
        resetMove();
        if(isDefenderInActionRadius(hostPlayer, field)) handleInitiateBlock(hostPlayer, field);
        if(move == null && isPlayerWithinBlockingRadius(hostPlayer, field)) handleMoveWithinBlockingRadius(hostPlayer, field);
        if(move == null) handleCatchupToBallCarrier(hostPlayer, field);
    }

    @Override
    public final MovementInstruction getMove() {
        return move;
    }

    private final void resetMove(){
        move = null;
    }

//    We should also check if we are currently blocking someone
    private final void handleInitiateBlock(final GamePlayer hostPlayer, final GameField field){

    }

//    This is slightly broken, causing the blocker to move in a zigzag pattern both N-S and E-W
    private final void handleMoveWithinBlockingRadius(final GamePlayer hostPlayer, final GameField field){
//        Not perfect, we should be trying to get between the ballcarrier and the "open field"
//        We need to poll the distanceCheck here
        final GamePlayer ballCarrier = hostPlayer.getBallCarrier();
        final List<GamePlayer> defendersToBlock = getDefendersInRadius(ballCarrier, field, 15);
        Vector movement;
        if(defendersToBlock.size() > 0){
            movement = handleMoveWithinBlockRadiusDefenders(hostPlayer, ballCarrier, defendersToBlock);
        } else {
            movement = handleMoveWithinBlockRadiusNoDefenders(hostPlayer, ballCarrier);
        }
        move = new MovementInstruction(hostPlayer, movement);
    }

    private final Vector handleMoveWithinBlockRadiusNoDefenders(final GamePlayer hostPlayer, final GamePlayer ballCarrier){
//        Establishing whether we are outside the "center" of the field
        double fieldAdjust = 0;
        if((hostPlayer.getLocation().getFirst() < Field.FIELD_LEFT_CENTER) || (hostPlayer.getLocation().getFirst() > Field.FIELD_RIGHT_CENTER)){
            double xDistance;
            double directionCorrection;
            if(ballCarrier.getLocation().getFirst() < Field.FIELD_LEFT_CENTER){
                xDistance = (Field.FIELD_WIDTH - 1) - (Field.FIELD_WIDTH - 1 - ballCarrier.getLocation().getFirst());
                directionCorrection = 1;
            }
            else{
                xDistance = (Field.FIELD_WIDTH - 1) - ballCarrier.getLocation().getFirst();
                directionCorrection = -1;
            }
            double d = (Field.FIELD_WIDTH/2) - xDistance;
            fieldAdjust = (d / (Field.FIELD_WIDTH/2)) * (Math.PI/2) * (directionCorrection);
        }
        final double predicatedBallCarrierAngle =
                ballCarrier.getPreviousMovement(DEFENDER_DISTANCE_TO_POLL).getMovement().getAngle();
        Vector movement = new Vector(hostPlayer.getMaxMovement(), predicatedBallCarrierAngle - fieldAdjust);
//        Vector movement = new Vector(predicatedBallCarrierAngle, 1);
//        This ends with us basically right on top of the ball carrier on the X axis. We should strive to be between 3-5 yards away in whatever
//        our cushion direction is
        return movement;
    }

    private final Vector handleMoveWithinBlockRadiusDefenders(final GamePlayer hostPlayer, final GamePlayer ballCarrier, final List<GamePlayer> defendersToBlock){
        final GamePlayer defender = handleDefendersInBlockingRadius(hostPlayer, ballCarrier, defendersToBlock);
        Vector defenderMovement = new Vector(defender.getLocation(), ballCarrier.getLocation());
        defenderMovement = defenderMovement.scale(.5);
        Vector movement = new Vector(hostPlayer.getLocation(), new Tuple2<>(defender.getLocation().getFirst() + defenderMovement.getChangeX(), defender.getLocation().getSecond() + defenderMovement.getChangeY()));
        return movement;
    }

    private final GamePlayer handleDefendersInBlockingRadius(final GamePlayer hostPlayer, final GamePlayer ballCarrier, final List<GamePlayer> defenders){

        class DefenderWrapper{
            private final double ballCarrierDistance;
            private final double defenderDistanceToGoal;
            private final double distanceToHost;
            private final double danger;
            private final GamePlayer defender;
            private final double bcDistanceWeight = 1.5;
            private final double dDistanceWeight = .75;
            private final double dHDistanceWeight = 1;
            private final double dWeight = 1.5;

            DefenderWrapper(final GamePlayer dd, final double bcDistance, final double ddDistance, final double dhDistance, final double d){
                defender = dd; ballCarrierDistance = bcDistance; defenderDistanceToGoal = ddDistance; danger = d; distanceToHost = dhDistance;
            }
            final double getValue(){ return
                    (ballCarrierDistance * bcDistanceWeight) + (defenderDistanceToGoal * dDistanceWeight) + (distanceToHost * dHDistanceWeight) +(danger * dWeight);
            }
        }

        final double MAX_DEFENDER_DISTANCE = 30;
        GamePlayer defenderToBlock = null;
        DefenderWrapper dwrapper = null;
//        Factors that matter here
//        Danger value of the defender (this is perceived, so if they are more intimidating to the blocker
//          we value this higher)
//        Distance of the defender to the ballCarrier
//        Distance from the defender to the ballCarrier's goal

        final List<DefenderWrapper> dWrappers = new ArrayList<>(defenders.size());
        for(final GamePlayer defender : defenders){
            final double ballCarrierDistance = (MAX_DEFENDER_DISTANCE - Location.GetDistance(defender, ballCarrier) + 1)/MAX_DEFENDER_DISTANCE;
            final double defenderDistanceToGoal = Location.GetDistance(
                    ballCarrier.getTeamGoal().getGoalLocation(ballCarrier), defender.getLocation());
            final double danger = 1;
            final double defenderDistanceToMe = Location.GetDistance(defender, hostPlayer);
            dWrappers.add(new DefenderWrapper(defender, ballCarrierDistance, defenderDistanceToGoal, defenderDistanceToMe, danger));
        }

        for(final DefenderWrapper defender : dWrappers){
            if(dwrapper == null || defender.getValue() > dwrapper.getValue()){
                dwrapper = defender;
            }
        }
        defenderToBlock = dwrapper.defender;

        return defenderToBlock;
    }

    private final void handleCatchupToBallCarrier(final GamePlayer hostPlayer, final GameField field){
        final double xChange =
                hostPlayer.getBallCarrier().getLocation().getFirst() -
                hostPlayer.getLocation().getFirst();
        final double yChange =
                hostPlayer.getBallCarrier().getLocation().getSecond() -
                hostPlayer.getLocation().getSecond();
        move = new MovementInstruction(hostPlayer, new Vector(new Tuple2<>(xChange, yChange)));
    }

    private final boolean isDefenderInActionRadius(final GamePlayer hostPlayer, final GameField field){
        return getDefendersInRadius(hostPlayer, field, ACTION_RADIUS).size() > 0;
    }

    private final List<GamePlayer> getDefendersInRadius(final GamePlayer hostPlayer, final GameField field, final double radius){
        final List<GamePlayer> playersInRadius = field.checkLocation(hostPlayer, radius);
//        No idea how to fix this
//        playersInRadius.removeIf(player -> hostPlayer.getOwnerHash().equals(player.getOwnerHash()));
        return playersInRadius;
    }

    private final boolean isPlayerWithinBlockingRadius(final GamePlayer hostPlayer, final GameField field){
//        Checking if we are between/alongside the BallCarrier and the Perceived Goal
        final GamePlayer ballCarrier = hostPlayer.getBallCarrier();
        final double distanceBetweenUs = Location.GetDistance(hostPlayer, ballCarrier);
        if(distanceBetweenUs > BLOCKER_RADIUS) return false;
        return
//                Goal check adds/removes endzone height so we aren't having issues
//                with blockers failing to block on/near goal line
                (hostPlayer.getLocation().getSecond() > ballCarrier.getLocation().getSecond() &&
                 Field.GetLocationForEndzone(hostPlayer.getTeamGoal()).getSecond() + Field.FIELD_HEIGHT > hostPlayer.getLocation().getSecond()) ||
                (hostPlayer.getLocation().getSecond() < ballCarrier.getLocation().getSecond() &&
                 Field.GetLocationForEndzone(hostPlayer.getTeamGoal()).getSecond() - Field.FIELD_HEIGHT < hostPlayer.getLocation().getSecond());
    }

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {
//        Calculate the perceivedGoal and then the point from the perceivedGoal
//        For now, assume TouchDown
        mCacheGoal = new Tuple2<>(hostPlayer.getBallCarrier().getLocation().getFirst(), Field.GetLocationForEndzone(hostPlayer.getTeamGoal()).getSecond());
        return mCacheGoal;
    }

    @Override
    public List<PlayerInfluences> getInfluences(GamePlayer hostPlayer, GameField field) {
        return null;
    }

}
