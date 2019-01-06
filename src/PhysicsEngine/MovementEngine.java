package PhysicsEngine;

import Game.Field.Vector;
import Game.GameField;
import Game.GameManager;
import Game.GamePlayer;
import Tuple.Tuple2;

import java.util.Iterator;
import java.util.List;

public class MovementEngine {

    private final static int MAX_DISTANCE   = 3;


    public final void prioritizeQueue(final List<MovementInstruction> movementQueue){
//        This just runs whatever logic we setup to reprioritize the queue, making sure
//        the most important mover/movement is at the top
    }

    public final void cycleQueue(final List<MovementInstruction> movementQueue, final GameField field){
//        This will execute all movements in the queue in order.
//        Remember that each movement is affected by previous movements by other players.
//        This is why we dont handle move validity until this point, since it may be a valid move
//        when it is passed here, but becomes invalid after another player with higher priority
//        moves

        final int TACKLE_DISTANCE = 3;

        prioritizeQueue(movementQueue);

        final Iterator movementIterator = movementQueue.iterator();
        while(movementIterator.hasNext()){
            MovementInstruction instructions = (MovementInstruction) movementIterator.next();
            Vector movement = instructions.getVector();
            if(instructions.getVector().getLength() > MAX_DISTANCE) movement.scale(MAX_DISTANCE / movement.getLength());
//            We need to handle collisions, other wise stuff goes breaky break
            field.movePlayer(instructions.getPlayer(), movement);
        }
        field.clearMovementQueue();
    }

    private final void handleCollision(final GamePlayer encroachingPlayer, final List<GamePlayer> occupyingPlayer){
//        This will handle displacement of both players on the field, this will not return anything

//        DAS BAD
        GameManager.DEBUG_DUN = true;
    }

//    This should probably be somewhere else more accessible
    private final double distanceBetweenPoints(final Tuple2<Double, Double> firstPoint, final Tuple2<Double, Double> secondPoint){
        return Math.sqrt(Math.pow(secondPoint.getFirst() - firstPoint.getFirst(),2) + Math.pow(secondPoint.getSecond() - firstPoint.getSecond(),2));
    }

}
