package Game.GamePlay.PlayerStrategy.Offense;

import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.PlayerState;
import Game.Routes.Route;
import Game.Routes.RouteActions.*;
import Game.Routes.RouteInterpreter.RouteInterpreter;
import PhysicsEngine.Movements.MovementAction;
import PhysicsEngine.Movements.MovementInstruction;
import PhysicsEngine.PhysicsObjects.Vector;
import Tuple.Tuple2;
import Utils.Location;

import java.util.List;

public final class OffensiveRouteInterpreter extends RouteInterpreter{

//    ALL MOVEMENTS NEED TO BE POSITIVE OR NEGATIVE RELATIVE TO
//    HOST PLAYERS GOAL!

    private IRouteAction cacheRouteAction;
    private Tuple2<Double, Double> cacheRouteStartPoint;
    private Tuple2<Double, Double> cacheRouteEndPoint;
    //    This should probably come from the player. This how close we can get to
    //    Completing the RouteAction before moving on to the next RouteAction
    private final double ROUTE_OBEDIENCE = .5;
    private final double BLOCK_SEARCH_DISTANCE = 6;
    private final double SAME_LOCATION_DIFFERENCE = .01;

    private MovementInstruction move;

    public OffensiveRouteInterpreter(final Route route) {
        super(route);
    }

    @Override
    public final double gradeRoute(final GamePlayer hostPlayer, final GameField field) {
        return 0;
    }

    @Override
    public final MovementInstruction getMovement() {
        final MovementInstruction cacheMove = move;
        move = null;
        return cacheMove;
    }

    @Override
    public final void calculateMovement(final GamePlayer hostPlayer, final GameField field){
        if(move != null) return;
        if(getCurrentMove() instanceof RouteActionMove) handleMove(hostPlayer, field);
        if(getCurrentMove() instanceof RouteActionPassBlock) handlePassBlock(hostPlayer, field);
        if(getCurrentMove() instanceof RouteActionRunBlock) handleRunBlock(hostPlayer, field);
        if(getCurrentMove() instanceof RouteActionLookForBall) handleLookForBall(hostPlayer, field);
    }

    private final void handleMove(final GamePlayer hostPlayer, final GameField field){
//        Assume we know this is going to be a RouteActionMove.
        if(!getCurrentMove().equals(cacheRouteAction)){
            cacheRouteAction = getCurrentMove();
            cacheRouteStartPoint = hostPlayer.getLocation();
            calculateMovement(hostPlayer, field);
            return;
        }
        if(Location.GetDistance(cacheRouteStartPoint, hostPlayer.getLocation()) <= SAME_LOCATION_DIFFERENCE){
            final RouteActionMove moveAction = (RouteActionMove) cacheRouteAction;
//            We need to figure out if the player is going North or South.
//            if they are going north, this works, however, if they are going south, this doesn't work
            final int directionCorrection = hostPlayer.getTeamGoal().isNorth() ? 1 : -1;
            cacheRouteEndPoint = new Tuple2<>(hostPlayer.getLocation().getFirst() + (moveAction.getMovement().getChangeX() * directionCorrection), hostPlayer.getLocation().getSecond() + (moveAction.getMovement().getChangeY() * directionCorrection));
        }
        if(Location.GetDistance(hostPlayer.getLocation(), cacheRouteEndPoint) <= SAME_LOCATION_DIFFERENCE){
            cacheRouteAction = getNextMove();
            cacheRouteStartPoint = hostPlayer.getLocation();
            calculateMovement(hostPlayer, field);
            return;
        }

        final Vector v = new Vector(hostPlayer.getLocation(), cacheRouteEndPoint);
//        Grade current movements?
        move = new MovementInstruction(hostPlayer, v);
    }

    private final void handlePassBlock(final GamePlayer hostPlayer, final GameField field){
        if(!getCurrentMove().equals(cacheRouteAction)){
            cacheRouteAction = getCurrentMove();
            calculateMovement(hostPlayer, field);
            return;
        }
        GamePlayer playerToBlock;
        if(hostPlayer.getMovementInstruction().getAction().getActionState().isBlocking()) {
            playerToBlock = hostPlayer.getMovementInstruction().getAction().getAffectedPlayer();
        }else{
            playerToBlock = BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, Field.FIELD_HEIGHT)).get(0);
        }

        cacheRouteEndPoint = playerToBlock.getLocation();

        final MovementAction action = new MovementAction(PlayerState.PASS_BLOCKING, hostPlayer, playerToBlock);
        move = new MovementInstruction(action, new Vector(hostPlayer.getLocation(), cacheRouteEndPoint));
    }

    private final void handleRunBlock(final GamePlayer hostPlayer, final GameField field){
        if(!getCurrentMove().equals(cacheRouteAction)){
            cacheRouteAction = getCurrentMove();
            calculateMovement(hostPlayer, field);
            return;
        }
        final RouteActionRunBlock action = (RouteActionRunBlock) cacheRouteAction;
        GamePlayer playerToBlock;
        if(hostPlayer.getMovementInstruction().getAction().getActionState().isBlocking()) {
            playerToBlock = hostPlayer.getMovementInstruction().getAction().getAffectedPlayer();
        }else{
//            Handle if there are no players to block
//            If there are no other players to block within blocking vicinity, we should move
//            directly along the y axis towards the teamGoal, until there is someone to block.
//            However, if there is no one to block after a few moves, we should begin to penalize the
//            viability of this

            final List<GamePlayer> playersToBlock = BasePlayerStrategy.FilterByDirection(
                    hostPlayer,
                    BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, Field.FIELD_HEIGHT)),
                    action.getBlockingDirection());

            if(playersToBlock.isEmpty()){
                handleRunBlockWithNoDefenders(hostPlayer, field);
                return;
            }
            playerToBlock = playersToBlock.get(0);
        }

        cacheRouteEndPoint = playerToBlock.getLocation();

        final MovementAction moveAction = new MovementAction(PlayerState.RUN_BLOCKING, hostPlayer, playerToBlock);
        move = new MovementInstruction(moveAction, new Vector(hostPlayer.getLocation(), cacheRouteEndPoint));
    }

    private final void handleRunBlockWithNoDefenders(final GamePlayer hostPlayer, final GameField field){
//        Look for any near by players in the direction the ball carrier is going
//        If there are none, just move in the direction the ball carrier is going.

//        If we do not get a block out of this, we need to penalize the viability of the route
        final List<GamePlayer> playersToBlock = BasePlayerStrategy.FilterByDirection(
                hostPlayer,
                BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, BLOCK_SEARCH_DISTANCE)),
                hostPlayer.getTeamGoal().getCardinalDirection());

        if(!playersToBlock.isEmpty()){
            final GamePlayer playerToBlock = playersToBlock.get(0);
            cacheRouteEndPoint = playerToBlock.getLocation();
            final MovementAction action = new MovementAction(PlayerState.RUN_BLOCKING, hostPlayer, playerToBlock);
            move = new MovementInstruction(action, new Vector(hostPlayer.getLocation(), cacheRouteEndPoint));
        } else {
            final double direction = hostPlayer.getTeamGoal().isNorth() ? -(Math.PI/2) : Math.PI/2;
            final double magnitude = hostPlayer.getMaxMovement(direction);
            final Vector v = new Vector(direction, magnitude);
            move = new MovementInstruction(hostPlayer, v);
//            Penalize viability
        }
    }

    private final void handleLookForBall(final GamePlayer hostPlayer, final GameField field){
        if(!getCurrentMove().equals(cacheRouteAction)){
            cacheRouteAction = getCurrentMove();
            calculateMovement(hostPlayer, field);
            return;
        }
        System.out.println("Not implemented yet!");
        move = new MovementInstruction(new MovementAction(hostPlayer), new Vector(0,0));
    }
}
