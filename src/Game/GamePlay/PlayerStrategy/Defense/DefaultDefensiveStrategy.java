package Game.GamePlay.PlayerStrategy.Defense;

import Game.*;
import Game.Field.CardinalDirection;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.StateMachine.GamePlayerState;
import Game.Routes.Route;
import PhysicsEngine.Movements.Movement;
import PhysicsEngine.Movements.MovementAction;
import Utils.PhysicsObjects.Vector;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Game.Utils.Location;

import java.util.ArrayList;
import java.util.List;

public class DefaultDefensiveStrategy extends BasePlayerStrategy {

    private MovementInstruction move = null;

    private final Double targetPredictionDistance = 27.0;
    private final int targetPollDistance = 3;

    private double tackleTargetDistance = 7;

    private final static String BALLCARRIER_TAG = "Ball Carrier";
    private final static String XCORRECTION_TAG = "X Correction";
    private final static String BALLCARRIER_PREDICTION_TAG = "Ball Carrier Prediction";

    private final boolean DEBUG_RAILS = false;

//    private RouteInterpreter routeInterpreter;

    public DefaultDefensiveStrategy(final Route route) {
        super(route);
    }

    @Override
    public void calculateMove(final GamePlayer hostPlayer, final GameField field) {
//        Should check the player state and determine if we are currently
//        being blocked. If we are, we should engage in isBlocking shedding,
//        as opposed to isTackling targeting

//        if(getRoute() != null && routeInterpreter == null) routeInterpreter = new DefensiveRouteInterpreter(getRoute());

//        THIS SHOULD BE PULLED FROM ATTRIBUTES
        double MOVE_BREAK_THRESHOLD = 0;

        Tuple2<Double, MovementInstruction> moveCheck = shouldUseRoute(hostPlayer, field);

//        if(routeMove != null && !routeMove.getAction().getActionState().isOverridable()){
//            setMove(routeMove);
//            return;
//        }
//        TODO
//        This does not account for blockers on blitz routes
        if(moveCheck.getSecond() != null && moveCheck.getFirst() >= MOVE_BREAK_THRESHOLD /*&& !routeMove.getAction().getActionState().isOverridable()*/){
            setMove(moveCheck.getSecond());
            return;
        }

        final List<PlayerInfluence> influences = getInfluences(hostPlayer, field);
        Vector movement = new Vector(0,0);
        for(final PlayerInfluence influence : influences){
            movement = movement.add(influence.getInfluence());
        }

        movement = new Vector(movement.getDirection(), hostPlayer.getMaxMovement(movement.getDirection()));

        final MovementAction action = new MovementAction(generateMovementState(hostPlayer), hostPlayer, hostPlayer.getBallCarrier());
        setMove(new MovementInstruction(action, movement));
    }

    private final Tuple2<Double, MovementInstruction> shouldUseRoute(final GamePlayer hostPlayer, final GameField field){
//        Where we grade the move
        final double GRADE = 100;
        MovementInstruction move = null;
        if(!isRouteIgnored() && getRoute() != null) move = getMove(hostPlayer, field);
        return new Tuple2<>(GRADE, move);
    }

    private final GamePlayerState generateMovementState(final GamePlayer host){
//        We need some actual logic here. For now, this works
        if(host.getPlayerState().isBlocked()) return GamePlayerState.BreakBlock;
        if(Location.GetDistance(host.getLocation(), host.getBallCarrier().getLocation()) <= tackleTargetDistance) return GamePlayerState.Tackling;
        return GamePlayerState.Null;
    }

    private final void setMove(final MovementInstruction movementInstruction){
        move = movementInstruction;
    }

    @Override
    public final MovementInstruction getMove() {
        return move;
    }

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {

        return hostPlayer.getBallCarrier().getLocation();
    }

    @Override
    public final List<PlayerInfluence> getInfluences(final GamePlayer hostPlayer, final GameField field) {
        final List<PlayerInfluence> playerInfluences = new ArrayList<>(hostPlayer.getPlayerInfluenceBiases());
//        Biases the Strategy will care about
        /**
         * *BallCarrier Location
         *  - The base movement vector is based on this bias.
         *
         * Blockers
         *  - Anybody on the opposite team
         *      -If they are engaged in blocking they will emit a very marginal influence
         *      -If they are not, they should emit a larger influence, but this influence
         *          should not amount to more than half the ball carrier influence. We do not
         *          want to be avoiding blockers more than we need to be
         *
         * Down & Distance
         *  - In essence, what down is it, and how far does the offense need to get to get a first down. On third downs or goal downs, this should be
         *      the second most important influence
         *
         * SameTeam
         *  - A very small influence, but basically a "Hey dont run into me" influence
         *
         * *Staying in front of the ballcarrier
         *  - While you would think this goes along with the BallCarrier Location influence, this is a separate one because
         *      being in front of the ball carrier is more important than chasing them down. It should help to prevent the
         *      defender from being "faked" out or "juked".
         *
         * *Predicting where the ballcarrier will go
         *  - More used for determining an angle to get to the ballcarrier, this should help handle evasion attempts
         */
        playerInfluences.add(getBallCarrierInfluence(hostPlayer));
        playerInfluences.add(getBallCarrierXInfluence(hostPlayer));
        playerInfluences.add(getPredictedBallCarrierInfluence(hostPlayer));
        playerInfluences.addAll(scanPlayers(hostPlayer, field));
        return playerInfluences;
    }

    private final List<PlayerInfluence> scanPlayers(final GamePlayer hostPlayer, final GameField field){
        final double distanceToBallCarrier = Location.GetDistance(hostPlayer, hostPlayer.getBallCarrier());
        CardinalDirection verticalDirection = hostPlayer.getBallCarrier().getLocation().getSecond() > hostPlayer.getLocation().getSecond() ? CardinalDirection.SOUTH : CardinalDirection.NORTH;
        CardinalDirection horizontalDirection = hostPlayer.getBallCarrier().getLocation().getFirst() > hostPlayer.getLocation().getFirst() ? CardinalDirection.EAST  : CardinalDirection.WEST;
        final List<PlayerInfluence> influences = new ArrayList<>();
        List<GamePlayer> playersBetweenUs = field.checkLocation(hostPlayer, distanceToBallCarrier);
        playersBetweenUs = FilterByDirection(hostPlayer, playersBetweenUs, verticalDirection, horizontalDirection);

        final List<GamePlayer> sameTeam = FilterBySameTeam(hostPlayer, playersBetweenUs);
        final List<GamePlayer> oppositeTeam = FilterByOppositeTeam(hostPlayer, playersBetweenUs);

        for(final GamePlayer player : sameTeam){
            influences.add(GetSameTeamPlayerInfluence(hostPlayer, player));
        }
        for(final GamePlayer player : oppositeTeam){
            influences.add(getOtherTeamPlayerInfluence(hostPlayer, player));
        }

        return influences;
    }

    private final PlayerInfluence getOtherTeamPlayerInfluence(final GamePlayer hostPlayer, final GamePlayer otherPlayer){
        if(hostPlayer.getBallCarrier().equals(otherPlayer)) return GetNullInfluence(otherPlayer.getName());

        final double magnitude = 1.01;
        Vector v = new Vector(otherPlayer.getLocation(), hostPlayer.getLocation());
        v = new Vector(v.getDirection(), magnitude);
        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, otherPlayer.getName());
    }


    private final PlayerInfluence getBallCarrierInfluence(final GamePlayer hostPlayer){
        Vector influence = new Vector(hostPlayer.getLocation(), hostPlayer.getBallCarrier().getLocation());

        if(influence.getMagnitude() < targetPredictionDistance) {
            final double magnitude = targetPredictionDistance - influence.getMagnitude();
            influence = new Vector(influence.getDirection(), magnitude);
        }

        return new PlayerInfluence(influence, (influence.getDirection() / Math.PI) * 100, BALLCARRIER_TAG);
    }

    private final PlayerInfluence getBallCarrierXInfluence(final GamePlayer hostPlayer){
        final double xChange = hostPlayer.getBallCarrier().getLocation().getFirst() - hostPlayer.getLocation().getFirst();
        final Vector xChangeVector = new Vector(new Tuple2<>(xChange, 0.0));
        return new PlayerInfluence(xChangeVector, (xChangeVector.getDirection() / Math.PI) * 100, XCORRECTION_TAG);
    }

    private final PlayerInfluence getPredictedBallCarrierInfluence(final GamePlayer hostPlayer){
        final Vector ballCarrierMovement = getPreviousBallCarrierMovement(hostPlayer);
        final Vector scaledMovement = ballCarrierMovement.scale(targetPredictionDistance / ballCarrierMovement.getMagnitude());
        if(scaledMovement.getMagnitude().isNaN() || scaledMovement.getDirection().isNaN())  return GetNullInfluence(BALLCARRIER_PREDICTION_TAG);
        final Tuple2<Double, Double> targetLocation = new Tuple2<>(hostPlayer.getBallCarrier().getLocation().getFirst() + scaledMovement.getChangeX(), hostPlayer.getBallCarrier().getLocation().getSecond() + scaledMovement.getChangeY());

        final Vector influence = new Vector(hostPlayer.getLocation(), targetLocation);
        return new PlayerInfluence(influence, (influence.getDirection() / Math.PI) * 100, BALLCARRIER_PREDICTION_TAG);
    }

    private final Vector getPreviousBallCarrierMovement(final GamePlayer hostPlayer){
        final Movement previousMovement = hostPlayer.getBallCarrier().getPreviousMovement(targetPollDistance);
        return new Vector(previousMovement.getStartingLocation(), hostPlayer.getBallCarrier().getLocation());
    }


}