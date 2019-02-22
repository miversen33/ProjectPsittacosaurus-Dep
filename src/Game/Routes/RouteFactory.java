package Game.Routes;

import Game.Routes.RouteActions.IRouteAction;

import java.util.LinkedList;

public final class RouteFactory {

    private Route route;
    private LinkedList<IRouteAction> preRoute = new LinkedList<>();

    public RouteFactory(){
        route = new Route();
    }

    public final RouteFactory addToRoute(final IRouteAction routeAction){
//        Verify that the action added is not final. Once it is, we are done
//        Adding to the route.
        if(preRoute.size() == 0 || !preRoute.peekLast().isFinalAction()){
            preRoute.add(routeAction);
        }else{
//            TODO handle logging of inability to add routeAction
            System.out.println("Unable to add "+routeAction+" to route as route has already ended");
        }
        return this;
    }

    public final RouteFactory build(){
        if(preRoute.size() == 0){
//            TODO handle logging due to no actions in route
            System.out.println("There are no actions in the route queue!");
        } else {
            route.createRoute(preRoute);
        }
        return this;
    }

    public final Route getRoute(){
        return route;
    }


}
