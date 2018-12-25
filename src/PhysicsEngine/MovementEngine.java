package PhysicsEngine;

import FieldDep.FieldCell;
import Game.Field.Location;
import Game.GameField;
import Game.GameManager;
import Game.GamePlayer;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovementEngine {
//    These are debug values until we figure out dynamic movement ranges
    private final static int DEBUG_MIN_DISTANCE   = 1;
    private final static int DEBUG_HALF_DISTANCE  = 2;
    private final static int DEBUG_MAX_DISTANCE   = 3;


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
//            Check endLocation for player already being there
            final Tuple2<Double, Double> currentLocation = field.requestPlayerLocation(instructions.getPlayer());
            final Location endLocation =
                    new Location(
                            currentLocation.getFirst() + instructions.getVector().getChangeX(),
                            currentLocation.getSecond() + instructions.getVector().getChangeY());
//            final List<GamePlayer> collisionDetection = field.getPlayersInLocation(endLocation, TACKLE_DISTANCE);
//            collisionDetection.remove(instructions.getPlayer());
//            if(collisionDetection.size() > 0) handleCollision(instructions.getPlayer(), collisionDetection);
            field.movePlayer(instructions.getPlayer(), instructions.getVector());
        }
        field.clearMovementQueue();
    }

    private final void handleCollision(final GamePlayer encroachingPlayer, final List<GamePlayer> occupyingPlayer){
//        This will handle displacement of both players on the field, this will not return anything

//        DAS BAD
        GameManager.DEBUG_DUN = true;
    }

}
