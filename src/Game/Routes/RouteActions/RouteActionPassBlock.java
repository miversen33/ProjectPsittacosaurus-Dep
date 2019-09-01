package Game.Routes.RouteActions;

import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerStrategy.BasePlayerStrategy;
import Game.StateMachine.GamePlayerState;
import PhysicsEngine.Movements.MovementAction;
import PhysicsEngine.Movements.MovementInstruction;
import Utils.PhysicsObjects.Vector;

public class RouteActionPassBlock extends BaseRouteAction {

    public final static String TYPE = "Pass Block";
    private final static boolean IS_FINAL = true;

    public RouteActionPassBlock() {
        super(TYPE, IS_FINAL);
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField gameField) {
        GamePlayer playerToBlock;
        if(hostPlayer.getMovementState().isBlocking()) {
            playerToBlock = hostPlayer.getMovementInstruction().getAction().getAffectedPlayer();
        }else{
            playerToBlock = BasePlayerStrategy.FilterByOppositeTeam(hostPlayer, gameField.checkLocation(hostPlayer, Field.FIELD_HEIGHT)).get(0);
        }

        final MovementAction action = new MovementAction(GamePlayerState.PassBlocking, hostPlayer, playerToBlock);
        return new MovementInstruction(action, new Vector(hostPlayer.getLocation(), playerToBlock.getLocation()));
    }
}
