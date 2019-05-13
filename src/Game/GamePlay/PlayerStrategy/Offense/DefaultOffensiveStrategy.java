package Game.GamePlay.PlayerStrategy.Offense;

import Game.Field.CardinalDirection;
import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.GamePlay.StateMachine.GamePlayerState;
import Game.IGamePlayerOwner;
import Game.Routes.Route;
import PhysicsEngine.Movements.Movement;
import PhysicsEngine.Movements.MovementAction;
import PhysicsEngine.Movements.MovementInstruction;
import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class DefaultOffensiveStrategy extends BasePlayerStrategy {

    private final double BLOCKING_DISTANCE_TRIGGER = 7;
    private final double DEFENDER_DISTANCE_TO_BALLCARRIER = 60;
    private final int BALLCARRIER_PREDICTION_LENGTH = 3;

//    This could be raised or lowered based on a players stats?
    private double sideInfluence = 4;

    private final static String SIDE_OF_FIELD_TAG = "Side of Field";
    private final static String BALLCARRIER_PREDICATED_MOVEMENT_TAG = "Ball Carrier Predicated Movement";
    private final static String ROUTE_TAG = "Route";
    private MovementInstruction move;

//    private RouteInterpreter routeInterpreter;

    private final boolean DEBUG_RAILS = true;

    public DefaultOffensiveStrategy(final Route route) {
        super(route);
    }

    @Override
    public final void calculateMove(final GamePlayer hostPlayer, final GameField field) {
        /**
         * We should be checking this in the following order.
         * 1) Do we have a route to execute.
         * 2) Is there anyone close that we can block? If so, pick the "most dangerous" one and
         *      attempt to block them
         * 3) Handle all influences.
         *
         * If any of these are tripped, use it to calculate the move and move forward.
         * DO NOT DO MORE THAN 1
         */

//        if(getRoute() != null && routeInterpreter == null) routeInterpreter = new OffensiveRouteInterpreter(getRoute());

//        1.
        double MOVE_BREAK_THRESHOLD = 0;

        Tuple2<Double, MovementInstruction> moveCheck = shouldUseRoute(hostPlayer, field);
        if(moveCheck.getSecond() != null && moveCheck.getFirst() >= MOVE_BREAK_THRESHOLD){
            setMove(moveCheck.getSecond());
            return;
        }

//        2.
        if(isBlockablePlayerNear(hostPlayer, field)){
//            Handling setting block
            handleInitiateBlock(hostPlayer, field);
            return;
        }

//        3.
        final List<PlayerInfluence> influences = getInfluences(hostPlayer, field);
        Vector movement = new Vector(0,0);
        for(final PlayerInfluence influence : influences){
            movement = movement.add(influence.getInfluence());
        }

        movement = new Vector(movement.getDirection(), hostPlayer.getMaxMovement(movement.getDirection()));
        if(DEBUG_RAILS){
            setMove(moveCheck.getSecond());
            return;
        }

//        if(routeMove != null){
//            if(routeMove.getAction().getActionState().isOverridable()) setMove(new MovementInstruction(routeMove.getAction(), movement));
//        } else {
        setMove(new MovementInstruction(hostPlayer, movement));
//        }
    }

    private final boolean isBlockablePlayerNear(final GamePlayer hostPlayer, final GameField field){
        return FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, BLOCKING_DISTANCE_TRIGGER)).size() > 0;
    }

    /**
     * Returns true if handled, false if not
     */
    private final void handleInitiateBlock(final GamePlayer hostPlayer, final GameField field){
        final GamePlayer defender = FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, BLOCKING_DISTANCE_TRIGGER)).get(0);
        Vector v = new Vector(hostPlayer.getLocation(), defender.getLocation());
        if(v.getMagnitude() < BLOCKING_DISTANCE_TRIGGER){
            final double magnitude = BLOCKING_DISTANCE_TRIGGER - v.getMagnitude();
            v = new Vector(v.getDirection(), magnitude);
        }

        final MovementAction a = new MovementAction(GamePlayerState.RunBlocking, hostPlayer, defender);

        setMove(new MovementInstruction(a, v));
    }

    private final void setMove(final MovementInstruction instruction){
        move = instruction;
    }

    @Override
    public final MovementInstruction getMove() {
        return move;
    }

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {
        return null;
    }

    @Override
    public final List<PlayerInfluence> getInfluences(final GamePlayer hostPlayer, final GameField field) {
//        Assume we are not currently blocking anyone. That will be handled before we get here

        final List<PlayerInfluence> playerInfluences = new ArrayList<>(hostPlayer.getPlayerInfluenceBiases());
//        Biases the Strategy will care about
        /**
         * * BallCarrier Location
         *  - The base movement vector is based on this bias.
         *
         * * Defenders
         *  - Anybody on the opposite team
         *      -If they are currently engaged
         *      -If they are not, they should emit a larger influence
         *
         * Down & Distance
         *  - In essence, what down is it, and how far does the offense need to get to get a first down. On third downs or goal downs, this should be
         *      the second most important influence
         *
         * * SameTeam
         *  - A very small influence, but basically a "Hey dont run into me" influence
         *
         * Staying in front of the ballcarrier
         *  - While you would think this goes along with the BallCarrier Location influence, this is a separate one because
         *      being in front of the ball carrier is more important than most things. You cant block from behind
         *
         * * Predicting where the ballcarrier will go
         *  - More used for determining an angle to get to the ballcarrier
         *
         * Sideline
         *  - We should want to avoid the sideline, though the influence shouldn't by anything large
         *
         * * Side of field with the most defenders (horizontally)
         *  - We should try to position ourselves between the max amount of blockers possible.
         *          By default, giving every defender some influence on the blocker should
         *          help cause this, but we will still want to move towards the largest group
         *          of them possible.
         *
         * We need a way to handle routes better. Default blocking is fine,
         * But a wide receiver who is running a route to possibly
         * catch the ball shouldn't care about blocking or staying
         * in front of the ballcarrier. We need to redo the influences
         */
//        if(routeMove != null && routeMove.getAction().getActionState().isOverridable())
//                playerInfluences.add(new PlayerInfluence(routeMove.getVector(), (routeMove.getVector().getDirection() / Math.PI) * 100, ROUTE_TAG));
        playerInfluences.add(getBallCarrierInfluence(hostPlayer));
        playerInfluences.addAll(scanPlayers(hostPlayer, field));
        playerInfluences.add(getSideOfFieldInfluence(hostPlayer, FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, Field.FIELD_HEIGHT))));
        playerInfluences.add(getBallCarrierPredicatedMovement(hostPlayer));
        return playerInfluences;
    }

    private final Tuple2<Double, MovementInstruction> shouldUseRoute(final GamePlayer hostPlayer, final GameField field){
        final double GRADE = 100;
        MovementInstruction move = null;
        if(!isRouteIgnored() && getRoute() != null) move = getMove(hostPlayer, field);
        return new Tuple2<>(GRADE, move);
    }

    private final List<PlayerInfluence> scanPlayers(final GamePlayer hostPlayer, final GameField field){
        CardinalDirection verticalDirection = hostPlayer.getBallCarrier().getLocation().getSecond() > hostPlayer.getLocation().getSecond() ? CardinalDirection.SOUTH : CardinalDirection.NORTH;
        CardinalDirection horizontalDirection = hostPlayer.getBallCarrier().getLocation().getFirst() > hostPlayer.getLocation().getFirst() ? CardinalDirection.EAST  : CardinalDirection.WEST;
        final List<PlayerInfluence> influences = new ArrayList<>();
        List<GamePlayer> playersBetweenUs = field.checkLocation(hostPlayer, Field.FIELD_HEIGHT);
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

    private final PlayerInfluence getOtherTeamPlayerInfluence(final GamePlayer hostPlayer, final GamePlayer defender){
//        This is the thing for attempting to get to defenders
        Vector defenderMovement = new Vector(defender.getLocation(), hostPlayer.getLocation());
        double revisedMagnitude = DEFENDER_DISTANCE_TO_BALLCARRIER - defenderMovement.getMagnitude();
        defenderMovement = new Vector(defenderMovement.getDirection(), revisedMagnitude);

        return new PlayerInfluence(defenderMovement, (defenderMovement.getDirection() / Math.PI) * 100, defender.getName());
    }

    private final PlayerInfluence getBallCarrierInfluence(final GamePlayer hostPlayer){
        final Vector v = new Vector(hostPlayer.getLocation(), hostPlayer.getBallCarrier().getLocation());
        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, hostPlayer.getBallCarrier().getName());
    }

    private final PlayerInfluence getBallCarrierPredicatedMovement(final GamePlayer hostPlayer){
        final Movement ballCarrierPreviousMovement = hostPlayer.getBallCarrier().getPreviousMovement(BALLCARRIER_PREDICTION_LENGTH);
        final Vector v = new Vector(ballCarrierPreviousMovement.getStartingLocation(), hostPlayer.getBallCarrier().getLocation());

        if(v.getMagnitude().isNaN() || v.getDirection().isNaN()) return GetNullInfluence(BALLCARRIER_PREDICATED_MOVEMENT_TAG);

        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, BALLCARRIER_PREDICATED_MOVEMENT_TAG);
    }

    private final PlayerInfluence getSideOfFieldInfluence(final GamePlayer hostPlayer, final List<GamePlayer> otherTeam){
        final List<GamePlayer> leftSide = FilterByDirection(hostPlayer, otherTeam, CardinalDirection.WEST);
        final List<GamePlayer> rightSide = FilterByDirection(hostPlayer, otherTeam, CardinalDirection.EAST);
        CardinalDirection side = null;
        if(leftSide.size() > rightSide.size()) side = CardinalDirection.WEST;
        if(leftSide.size() < rightSide.size()) side = CardinalDirection.EAST;
        if(leftSide.size() == rightSide.size()){
            if(hostPlayer.getSideOfField().isRight()) side = CardinalDirection.WEST;
            if(hostPlayer.getSideOfField().isLeft())  side = CardinalDirection.EAST;
        }

        //noinspection ConstantConditions
        double direction = side.isEast() ? 0 : -Math.PI;
        double magnitude = hostPlayer.getMaxMovement(direction);
        final Vector v = new Vector(direction, magnitude);
        return new PlayerInfluence(v, (direction / Math.PI) * 100, SIDE_OF_FIELD_TAG);
    }
}