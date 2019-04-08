package Game.Routes;

import Game.Routes.RouteActions.IRouteAction;
import PhysicsEngine.Movements.MovementInstruction;

import java.util.LinkedList;

public final class Route{

    private boolean locked = false;
    private LinkedList<IRouteAction> routeActions;

    final void createRoute(final LinkedList<IRouteAction> actions){
        if(routeActions == null) routeActions = new LinkedList<>(actions);
        lock();
    }

    final void lock(){
        locked = true;
    }

    final boolean isLocked(){
        return locked;
    }

    public final boolean hasNext(){
        return routeActions.size() > 0;
    }

    public final IRouteAction getNextAction(){
        return routeActions.pop();
    }


}
