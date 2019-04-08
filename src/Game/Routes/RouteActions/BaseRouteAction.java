package Game.Routes.RouteActions;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;

public abstract class BaseRouteAction implements IRouteAction{

    private final String type;
    private final boolean isFinal;

    public BaseRouteAction(final String type, final Boolean isFinal){
        this.type = type;
        this.isFinal = isFinal;
    }

    @Override
    public final String getType() {
        return type;
    }

    @Override
    public final Boolean isFinalAction() {
        return isFinal;
    }

}
