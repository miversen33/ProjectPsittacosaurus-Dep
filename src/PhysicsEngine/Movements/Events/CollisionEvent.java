package PhysicsEngine.Movements.Events;

import Game.GamePlay.GamePlayer;
import Tuple.Tuple2;
import Utils.Event.Event;
import Utils.Signature;

public final class CollisionEvent extends Event {

    public final static String NAME  = "Collision";
    private final GamePlayer mPlayer1;
    private final GamePlayer mPlayer2;

    public CollisionEvent(final Signature signature, final GamePlayer player1, final GamePlayer player2){
        super(signature, NAME);
        mPlayer1 = player1;
        mPlayer2 = player2;
    }

    public final Tuple2<GamePlayer, GamePlayer> getCollisionPair(){
        return new Tuple2<>(mPlayer1, mPlayer2);
    }

    @Override
    public String toString() {
        return getType()+" "+getCollisionPair();
    }
}
