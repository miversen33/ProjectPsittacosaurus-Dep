package Game.GamePlay.PlayerStrategy.Offense;

import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Tuple.Tuple2;

public abstract class OffensivePlayerStrategy implements IPlayerStrategy {

    private final double baseAvoidance;
    private final double baseCushion;

    public OffensivePlayerStrategy(){
        baseAvoidance = Double.NEGATIVE_INFINITY;
        baseCushion = Double.NEGATIVE_INFINITY;
    }

    public OffensivePlayerStrategy(final double avoidance, final double cushion){
        if(avoidance == Double.NEGATIVE_INFINITY || cushion == Double.NEGATIVE_INFINITY){
            throw new RuntimeException("Cannot pass Infinity as parameter");
        }
        baseAvoidance = avoidance;
        baseCushion = cushion;
    }

}
