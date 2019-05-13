package Game.Routes.RouteActions;

import Game.Field.CardinalDirection;
import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Game.Utils.Location;
import Utils.PhysicsObjects.Vector;

public class RouteActionManCoverage extends BaseRouteAction{

    public final static String TYPE = "Man Coverage";
    private final static boolean IS_FINAL = true;
    private final GamePlayer playerToCover;
    private double initialCoverageDirection = 0.0;
    private final int PREDICATION_DISTANCE_POLL = 3;
    private boolean breakBackPedal = false;

    private final double DEBUG_DEFAULT_COVERAGE_CUSHION = 3;
    private final double DEBUG_DEFAULT_MAN_COVERAGE_CHANGE = 9;

    public RouteActionManCoverage(final GamePlayer playerToCover) {
        super(TYPE, IS_FINAL);
        this.playerToCover = playerToCover;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    //    TODO This needs massive amounts of optimization
    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField gameField) {
        final double BACKPEDAL_DIRECTIONAL_BREAK = .40;
        final double MAX_BACKPEDAL_DISTANCE = 1.5;

        MovementInstruction move;
        final double backPedalDirection = playerToCover.getTeamGoal().getCardinalDirection().getMovementAxisModifier();

        Vector routeRan = new Vector(playerToCover.getPreviousMovement(PREDICATION_DISTANCE_POLL).getStartingLocation(), playerToCover.getLocation());
        if(initialCoverageDirection == 0.0) initialCoverageDirection = routeRan.getDirection();
        if(!breakBackPedal && Math.abs(routeRan.getDirection() - initialCoverageDirection) >= BACKPEDAL_DIRECTIONAL_BREAK){
            breakBackPedal = true;
            System.out.println("Backpedal broken");
        }

        if(!breakBackPedal){
            final Vector vector = new Vector(new Tuple2<>(0.0, MAX_BACKPEDAL_DISTANCE * backPedalDirection));
            move = new MovementInstruction(hostPlayer, vector);
        } else {
            move = coverMan(hostPlayer, playerToCover);
        }

        return move;
    }

    private final MovementInstruction coverMan(final GamePlayer hostPlayer, final GamePlayer playerToCover){
        Vector routeRan = new Vector(playerToCover.getPreviousMovement(PREDICATION_DISTANCE_POLL).getStartingLocation(), playerToCover.getLocation());

        if(routeRan.getMagnitude() == 0 && routeRan.getDirection() == 0){
//            Offender hasn't moved yet.
            final double direction = (Math.PI / 2) * playerToCover.getTeamGoal().getCardinalDirection().getMovementAxisModifier();
            routeRan = new Vector(direction, routeRan.getMagnitude());
        }

//        Tweak this a bit
        routeRan = routeRan.scale((1.0/PREDICATION_DISTANCE_POLL) * Location.GetDistance(hostPlayer, playerToCover));

        Tuple2<Double, Double> predictionPoint = new Tuple2<>(
                playerToCover.getLocation().getFirst() + routeRan.getChangeX(),
                playerToCover.getLocation().getSecond() + routeRan.getChangeY());

        if(Location.GetDistance(hostPlayer, playerToCover) <= DEBUG_DEFAULT_MAN_COVERAGE_CHANGE) predictionPoint = playerToCover.getLocation();

        final CardinalDirection movementDirection = figureOffensivePlayerMovementDirection(playerToCover);

        Vector vMove = null;

        if(movementDirection.isHorizontal()){
            if(playerToCover.getTeamGoal().isNorth()){
                vMove = new Vector(hostPlayer.getLocation(), new Tuple2<>(predictionPoint.getFirst(), predictionPoint.getSecond() - DEBUG_DEFAULT_COVERAGE_CUSHION));
            }else{
                vMove = new Vector(hostPlayer.getLocation(), new Tuple2<>(predictionPoint.getFirst(), predictionPoint.getSecond() + DEBUG_DEFAULT_COVERAGE_CUSHION));
            }
        }
        if(movementDirection.isVertical()){
            if(Field.GetSideOfField(playerToCover.getLocation()).isLeft()){
                vMove = new Vector(hostPlayer.getLocation(), new Tuple2<>(predictionPoint.getFirst() + DEBUG_DEFAULT_COVERAGE_CUSHION, predictionPoint.getSecond()));
            } else {
                vMove = new Vector(hostPlayer.getLocation(), new Tuple2<>(predictionPoint.getFirst() - DEBUG_DEFAULT_COVERAGE_CUSHION, predictionPoint.getSecond() - 3));
            }
        }
        return new MovementInstruction(hostPlayer, vMove);
    }

    private final CardinalDirection figureOffensivePlayerMovementDirection(final GamePlayer player){
        final int PREVIOUS_MOVEMENT_CHECK = 2;
        final Vector previousMovement =
                new Vector(player.getPreviousMovement(PREVIOUS_MOVEMENT_CHECK).getStartingLocation(),
                        player.getLocation());

        if(previousMovement.getMagnitude() == 0.0){
            System.out.println("No Movement Found");
            return player.getTeamGoal().getCardinalDirection();
        }

        if(Math.abs(previousMovement.getChangeX() - previousMovement.getChangeY()) <= 1 ||
                Math.abs(previousMovement.getChangeY()) > Math.abs(previousMovement.getChangeX())){
//            Movement is diagonal
            if(previousMovement.getChangeY() > 0) return CardinalDirection.SOUTH;
            if(previousMovement.getChangeY() <= 0) return CardinalDirection.NORTH;
        } else {
            if(previousMovement.getChangeX() > 0) return CardinalDirection.EAST;
            if(previousMovement.getChangeX() <= 0) return CardinalDirection.WEST;
        }
//        Log invalid info passed.
//        TODO
        System.out.println("Unable to pick side correctly. Passing North");
        return CardinalDirection.NORTH;
    }
}
