package Game.Routes.RouteInterpreter;

import Game.Routes.Route;
import Game.Routes.RouteActions.IRouteAction;

public abstract class RouteInterpreter implements IRouteInterpreter{
    private final Route mRoute;
    private IRouteAction mCurrentMove;

    public RouteInterpreter(final Route route){
        mRoute = route;
        mCurrentMove = mRoute.getNextAction();
    }


    public final IRouteAction getCurrentMove(){
        return mCurrentMove;
    }

    public final IRouteAction getNextMove(){
        if(mRoute.hasNext()){
            mCurrentMove = mRoute.getNextAction();
        } else {
            mCurrentMove = null;
        }
        return getCurrentMove();
    }
}
