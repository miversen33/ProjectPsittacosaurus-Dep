package Game.Routes;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.Routes.RouteActions.IRouteAction;
import PhysicsEngine.Movements.MovementInstruction;

import java.util.LinkedList;

public final class Route{

    private LinkedList<IRouteAction> routeActions;

    final void createRoute(final LinkedList<IRouteAction> actions){
        if(routeActions == null) routeActions = new LinkedList<>(actions);
    }

    public final MovementInstruction getMove(final GamePlayer hostPlayer, final GameField field){
        if(routeActions.isEmpty()){
//            TODO LOG
            System.out.println("No More Available Route Actions");
            return null;
        }
        MovementInstruction move = routeActions.peek().isComplete() ? getMove(hostPlayer, field) : routeActions.peek().interpretRoute(hostPlayer, field);
        if(routeActions.peek().isComplete()) routeActions.pop();
        if(move.getVector() == null) return getMove(hostPlayer, field);
        return move;
    }

}
