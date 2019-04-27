package Game.Routes.RouteActions;

import Game.Field.CardinalDirection;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.GamePlay.PlayerStrategy.ZoneState;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Utils.PhysicsObjects.Vector;
import Utils.RNG;

import java.util.ArrayList;
import java.util.List;

public class RouteActionZoneCoverage extends BaseRouteAction{

    public final static String TYPE = "Zone Coverage";
    private final static boolean IS_FINAL = true;
    private final Double zoneRadius;
    private ZoneState mCurrentState = null;
    private Tuple2<Double, Double> zoneCenter;

    private final static double DEBUG_OUTER_ZONE_RADIUS = 9;
    private final static double DEBUG_INTELLIGENCE_CHECK = 1;
    private final static double DEBUG_ZONE_Y_OFFSET = 5;
    private final static int DEBUG_PREVIOUS_MOVE_CHECK = 3;

    public RouteActionZoneCoverage(final double zoneRadius) {
        super(TYPE, IS_FINAL);
        this.zoneRadius = zoneRadius;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField gameField) {
        if(zoneCenter == null) zoneCenter = hostPlayer.getLocation();
        final List<GamePlayer> cacheZoneSet = setZoneState(hostPlayer, gameField);

        MovementInstruction move = null;
        if(mCurrentState.isEmpty()) move = handleEmptyZone(hostPlayer);
        if(mCurrentState.isFull()) move = handleFullZone(hostPlayer, gameField, cacheZoneSet);
        if(mCurrentState.isApproaching()) move = handleApproachingZone(hostPlayer, gameField, cacheZoneSet);

        return move;
    }

    private final List<GamePlayer> setZoneState(final GamePlayer hostPlayer, final GameField gameField){
        double outerZoneRadius = DEBUG_OUTER_ZONE_RADIUS;

        final List<GamePlayer> playersInZone = gameField.checkLocation(zoneCenter, zoneRadius);
        final List<GamePlayer> playersInOuterZone = gameField.checkLocation(zoneCenter, zoneRadius+outerZoneRadius);
//        TODO
//        Filter by eligble receivers as well
        final List<GamePlayer> receiversInZone = BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, playersInZone);
        final List<GamePlayer> receiversInOuterZone = BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, playersInOuterZone);

        if(receiversInZone.isEmpty() && !receiversInOuterZone.isEmpty()) {
            mCurrentState = ZoneState.APPROACHING;
            return receiversInOuterZone;
        }
        if(!receiversInZone.isEmpty()){
            mCurrentState = ZoneState.FULL;
            return receiversInZone;
        }

        mCurrentState = ZoneState.EMPTY;
        return new ArrayList<>();
    }

    private final MovementInstruction handleEmptyZone(final GamePlayer hostPlayer){
        return new MovementInstruction(hostPlayer, new Vector(hostPlayer.getLocation(), zoneCenter));
    }

    private final MovementInstruction handleFullZone(final GamePlayer hostPlayer, final GameField gameField, final List<GamePlayer> targetReceivers){

        double hostIntelligence = DEBUG_ZONE_Y_OFFSET;
        double hostIntelligenceCheck = DEBUG_INTELLIGENCE_CHECK;

        double yOffset = hostIntelligence * hostPlayer.getTeamGoal().getOpposite().getCardinalDirection().getMovementAxisModifier();

        boolean passesMultiplePlayerPerceptCheck =
                hostPlayer.getMovementInstruction().getAction().getAffectedPlayer() != null ||
                RNG.Generate(0,1) <= hostIntelligenceCheck;
        boolean passesMovementPerceptCheck       = RNG.Generate(0,1) <= hostIntelligenceCheck;

        Tuple2<Double, Double> coverLocation;
        Tuple2<Double, Double> leftLocation;
        Tuple2<Double, Double> rightLocation;
        Tuple2<Double, Double> verticalLocation;

        if(!passesMultiplePlayerPerceptCheck){
            coverLocation = passesMovementPerceptCheck ?
                    getReceiverPredicatedLocation(hostPlayer.getMovementInstruction().getAction().getAffectedPlayer()) :
                    hostPlayer.getMovementInstruction().getAction().getAffectedPlayer().getLocation();
        }else{
            final GamePlayer leftPlayer = BasePlayerStrategy.GetPlayerFurthestInDirection(CardinalDirection.WEST, targetReceivers);
            leftLocation = passesMovementPerceptCheck ? getReceiverPredicatedLocation(leftPlayer) : leftPlayer.getLocation();

            final GamePlayer rightPlayer = BasePlayerStrategy.GetPlayerFurthestInDirection(CardinalDirection.EAST, targetReceivers);
            rightLocation = passesMovementPerceptCheck ? getReceiverPredicatedLocation(rightPlayer) : rightPlayer.getLocation();

            final GamePlayer verticalPlayer = BasePlayerStrategy.GetPlayerFurthestInDirection(hostPlayer.getTeamGoal().getOpposite().getCardinalDirection(), targetReceivers);
            verticalLocation = passesMovementPerceptCheck ? getReceiverPredicatedLocation(verticalPlayer) : verticalPlayer.getLocation();

            double x = leftLocation.getFirst() + ((rightLocation.getFirst() - leftLocation.getFirst()) / 2);
            double y = verticalLocation.getSecond() + yOffset;

            coverLocation = new Tuple2<>(x,y);
        }

        final Vector vector = new Vector(hostPlayer.getLocation(), coverLocation);
        final MovementInstruction instruction = new MovementInstruction(hostPlayer, vector);

        return instruction;
    }

//    TODO?
    private final MovementInstruction handleApproachingZone(final GamePlayer hostPlayer, final GameField gameField, final List<GamePlayer> targetReceivers){
        return handleEmptyZone(hostPlayer);
    }

    private final Tuple2<Double, Double> getReceiverPredicatedLocation(final GamePlayer receiver){
        int previousMoveCheck = DEBUG_PREVIOUS_MOVE_CHECK;
        double moveScale = 1.0 / previousMoveCheck;

        final Vector movement = new Vector(receiver.getPreviousMovement(previousMoveCheck).getEndingLocation(),
                                           receiver.getLocation()).scale(moveScale);

        return new Tuple2<>(receiver.getLocation().getFirst() + movement.getChangeX(), receiver.getLocation().getSecond() + movement.getChangeY());
    }

}
