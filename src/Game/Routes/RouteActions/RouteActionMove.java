package Game.Routes.RouteActions;

import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Utils.PhysicsObjects.Vector;

public final class RouteActionMove extends BaseRouteAction{

    public final static String TYPE = "Move";
    private final static boolean IS_FINAL = false;
    private final Vector mMove;
    private final Tuple2<Double, Double> mEndPoint;
    private boolean routeComplete = false;

//    private Tuple2<Double, Double> cacheEndPoint;
    private Vector cacheMove;
    private Tuple2<Double, Double> cacheStartPoint;

    public RouteActionMove(final Vector move) {
        super(TYPE, IS_FINAL);
        mMove = move;
        mEndPoint = null;
    }

    public RouteActionMove(final Tuple2<Double, Double> endPoint){
        super(TYPE, IS_FINAL);
        mMove = null;
        mEndPoint = endPoint;
    }

    @Override
    public boolean isComplete() {
        return routeComplete;
    }

    @Override
    public final MovementInstruction interpretRoute(final GamePlayer hostPlayer, final GameField gameField) {
//        This should be pulled from the hosts attributes
        final double SAME_LOCATION_DIFFERENCE = .01;

        if(cacheStartPoint == null) cacheStartPoint = hostPlayer.getLocation();
        if(cacheMove == null){
            if(hasEndPoint()) cacheMove = new Vector(hostPlayer.getLocation(), calculateEndPoint(hostPlayer));
            else cacheMove = getMotionVector();
        }
        final Vector totalMove = new Vector(cacheStartPoint, hostPlayer.getLocation());
        final double distanceRemaining = cacheMove.getMagnitude() - totalMove.getMagnitude();
        final Vector v = distanceRemaining <= SAME_LOCATION_DIFFERENCE ? null : new Vector(cacheMove.getDirection(), distanceRemaining);
        routeComplete = v == null;
        return new MovementInstruction(hostPlayer, v);
    }

    private final Tuple2<Double, Double> calculateEndPoint(final GamePlayer hostPlayer){
        if(mEndPoint == null) return null;
        return new Tuple2<>(
                mEndPoint.getFirst().isInfinite() ? hostPlayer.getLocation().getFirst() : mEndPoint.getFirst(),
                mEndPoint.getSecond().isInfinite() ? hostPlayer.getLocation().getSecond() : mEndPoint.getSecond()
        );
    }

    public final Boolean hasMotionVector(){
        return mMove!=null;
    }

    public final Boolean hasEndPoint(){
        return mEndPoint!=null;
    }

    public final Tuple2<Double, Double> getEndPoint(){
        return mEndPoint;
    }

    public final Vector getMotionVector(){
        return mMove;
    }

}
