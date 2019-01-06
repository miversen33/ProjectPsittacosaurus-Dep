package PhysicsEngine;

import Game.Field.Vector;
import Game.GamePlayer;

public class MovementInstruction {
    private final GamePlayer mPlayer;
    private final Vector mVector;

    public MovementInstruction(final GamePlayer player, final Vector vector){
        mPlayer = player;
        mVector = vector;
    }

    public final GamePlayer getPlayer(){
        return mPlayer;
    }

    public final Vector getVector(){
        return mVector;
    }

}
