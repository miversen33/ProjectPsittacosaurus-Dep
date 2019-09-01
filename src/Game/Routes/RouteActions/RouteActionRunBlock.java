package Game.Routes.RouteActions;

import Game.Field.CardinalDirection;
import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.StateMachine.GamePlayerState;
import PhysicsEngine.Movements.MovementAction;
import PhysicsEngine.Movements.MovementInstruction;
import Utils.PhysicsObjects.Vector;

import java.util.List;

public class RouteActionRunBlock extends BaseRouteAction{

    public final static String TYPE = "Run Block";
    private final static boolean IS_FINAL = true;
    private final CardinalDirection blockingDirection;

    public RouteActionRunBlock(final CardinalDirection blockingSide) {
        super(TYPE, IS_FINAL);
        blockingDirection = blockingSide;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField field) {
        final double BLOCK_SEARCH_DISTANCE = 6;

        GamePlayer playerToBlock;

        if(hostPlayer.getMovementState().isBlocking()) {
            playerToBlock = hostPlayer.getMovementInstruction().getAction().getAffectedPlayer();
        }else{
            List<GamePlayer> playersToBlock = BasePlayerStrategy.FilterByDirection(
                    hostPlayer,
                    BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, Field.FIELD_HEIGHT)),
                    getBlockingDirection());

            if(playersToBlock.isEmpty()) playersToBlock = BasePlayerStrategy.FilterByDirection(
                    hostPlayer,
                    BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, field.checkLocation(hostPlayer, BLOCK_SEARCH_DISTANCE)),
                    hostPlayer.getTeamGoal().getCardinalDirection());

            if(!playersToBlock.isEmpty()){
                playerToBlock = playersToBlock.get(0);
            } else {
                final double direction = hostPlayer.getTeamGoal().isNorth() ? -(Math.PI/2) : Math.PI/2;
                final double magnitude = hostPlayer.getMaxMovement(direction);
                final Vector v = new Vector(direction, magnitude);
                return new MovementInstruction(hostPlayer, v);
            }
        }

        final MovementAction moveAction = new MovementAction(GamePlayerState.RunBlocking, hostPlayer, playerToBlock);
        return new MovementInstruction(moveAction, new Vector(hostPlayer.getLocation(), playerToBlock.getLocation()));
    }

    public final CardinalDirection getBlockingDirection(){
        return blockingDirection;
    }

}
