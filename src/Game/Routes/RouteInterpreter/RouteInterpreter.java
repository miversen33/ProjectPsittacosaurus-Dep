package Game.Routes.RouteInterpreter;

import Game.Routes.Route;
import Game.Routes.RouteActions.IRouteAction;
import Game.Routes.RouteActions.RouteActionMove;

public abstract class RouteInterpreter implements IRouteInterpreter{
    private final Route mRoute;
    private IRouteAction mCurrentMove;
    private boolean ignoreMe = false;

    public RouteInterpreter(final Route route){
        mRoute = route;
        mCurrentMove = mRoute.getNextAction();
    }

    public final void ignoreInterpreter(){
        ignoreMe = true;
    }

    public final boolean getIsIgnored(){
        return ignoreMe;
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
