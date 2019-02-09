package Game.GamePlay.PlayerStrategy.Offense;

import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.PlayerInfluences;
import PhysicsEngine.PhysicsObjects.Vector;
import Game.GamePlay.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Utils.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BallCarrierStrategy extends OffensivePlayerStrategy {

    private MovementInstruction move = null;
    private final static int MAX_DISTANCE = 60;
    private final static double DEFAULT_AVOIDANCE = 15;
    private final static double DEFAULT_AVOIDANCE_CUSHION = MAX_DISTANCE-DEFAULT_AVOIDANCE;
    private final static double DEFAULT_AVOIDANCE_INFLUENCE = 1.5;
    private final static double DEFAULT_CUSHION_INFLUENCE = 1;
    private final static double SIDELINE_LEFT_MAX_DISTANCE = 12;
    private final static double SIDELINE_RIGHT_MAX_DISTANCE = Field.FIELD_WIDTH - SIDELINE_LEFT_MAX_DISTANCE;

    private final static String SIDELINE_TAG  = "SIDELINE";
    private final static String TOUCHDOWN_TAG = "TOUCHDOWN";
    private final static String FIRSTDOWN_TAG = "FIRST DOWN";

    private final static PlayerInfluences nullInfluence = new PlayerInfluences(0,0, "NULL");

    public BallCarrierStrategy() {
//        Consider having the defaults be provided so that every player has a "custom" strategy as they progress
        super(DEFAULT_AVOIDANCE, DEFAULT_AVOIDANCE_CUSHION);
    }

    @Override
    public final void calculateMove(final GamePlayer hostPlayer, final GameField field) {
//        Optimize me
//        This should be polled from the host player
        final double velocity = hostPlayer.getGoal().getSecond() < hostPlayer.getLocation().getSecond() ? -hostPlayer.getMaxMovement() : +hostPlayer.getMaxMovement();
        move = new MovementInstruction(hostPlayer, new Vector(new Tuple2<>(0.0, velocity)));

        final List<GamePlayer> defendersInRange = field.checkLocation(hostPlayer, MAX_DISTANCE);
        if(defendersInRange.size() > 0){
            handleDefenders(hostPlayer, defendersInRange);
        }
    }

//    Please remove the host player from the list
    private final void handleDefenders(final GamePlayer hostPlayer, final List<GamePlayer> defenders){
        double angle = 0;
        final Map<GamePlayer, Double> DEBUG_PLAYER_INFLUENCE = new HashMap<>();
        for(GamePlayer defender : defenders){

//            For now disregard the current defender if the defender is not between the ballcarrier
//            and the goal. This will be corrected at a later point when we have more
//            stuff to work with
            if((hostPlayer.getGoal().getSecond() < hostPlayer.getLocation().getSecond() && hostPlayer.getLocation().getSecond() < defender.getLocation().getSecond()) ||
               (hostPlayer.getGoal().getSecond() > hostPlayer.getLocation().getSecond() && hostPlayer.getLocation().getSecond() > defender.getLocation().getSecond())){
                continue;
            }

            double distanceFromDefenderOnX = Math.abs(defender.getLocation().getFirst() - hostPlayer.getLocation().getFirst());
            if(distanceFromDefenderOnX >= DEFAULT_AVOIDANCE_CUSHION) continue;
//            double influence = distanceFromDefenderOnX <= DEFAULT_AVOIDANCE ? DEFAULT_AVOIDANCE_INFLUENCE : DEFAULT_CUSHION_INFLUENCE;
//            double tAngle = calculateAngleOfMove(defender.getLocation(), hostPlayer.getLocation(), MAX_DISTANCE, influence);
//            double tAngle = findDesiredVectorDirectionAdjustment(hostPlayer, defender);
            double tAngle = findInfluenceOfDefender(hostPlayer, defender);
            DEBUG_PLAYER_INFLUENCE.put(defender, (tAngle/Math.PI) * 100);
            angle += tAngle;
        }
        angle = 0;
        Vector movement = new Vector(move.getVector().getDirection()+angle, move.getVector().getMagnitude());
        move = new MovementInstruction(hostPlayer, movement);
    }

    @Override
    public MovementInstruction getMove() {
        return move;
    }

    @Override
    public final Tuple2<Double, Double> calculateGoal(final GamePlayer hostPlayer, final GameField field, final IGamePlayerOwner hostTeam) {
//        TODO Put some sort of thinking logic here
        return Field.GetLocationForEndzone(hostTeam.getGoal());
    }

    @Override
    public List<PlayerInfluences> getInfluences(final GamePlayer hostPlayer, final GameField field) {
        final List<PlayerInfluences> playerBiases = hostPlayer.getPlayerInfluenceBiases();
//        Biases the Strategy will care about
        /**
         * Touchdown
         *  -The base movement vector is based on this bias. The desire to reach the touchdown in the shortest
         *      amount of time possible is what we are reaching for here. However, when the player
         *      approaches the goal endzone, this should also have its own bias attached to it, making a player
         *      view it more importantly. This should not outweigh the first down bias if it is applicable, as
         *      reaching a first down may still be more important than getting a touchdown
         * First Down (Only if we have not yet reached it. This bias needs to be null if we are past it already.
         *  -It might be helpful to grab this value (the Y value for the first down marker) on play set, and
         *      set a negative influence that is proportional to the distance away from the point. This would
         *      hopefully entice the player to strive for the first down marker first
         * Time
         *  -This will be well down the road, but eventually we might care about getting out of bounds/stopping
         *      the clock more than gaining significant yards. This would be handled here, and likely a bias that could
         *      be pulled from the team/coach
         * Sideline
         *  -This bias should only ever be enough to push the player to stay away from it. It should be enough to keep the ball
         *      carrier away from it, until a defender is within 4 yards of them (to which the defender should be
         *      able to outweigh this bias). Really, this bias should just amount to keeping the ball carrier
         *      from accidentally stepping out of bounds before they are ready.
         *  -This bias is null unless the ballcarrier is within 3 yards of a sideline, and it is at full force if the player is
         *      1 yard away from the sideline.
         * Field Position
         *  -A rather vague bias, but there are times where reaching a certain point on the field is important,
         *      say to get an easier setup for a field goal, for example.
         * Defenders
         *  -All defenders within our MAX_DISTANCE from us will have an influence.
         *  -If the defender is blocked it will receive a percentage of the original influence. This percentage will
         *      be calculated based on the player blocking them
         *  -If the defender is unblocked they will receive 100% of their influence
         * Lead Blockers
         *  -A Lead Blocker will have a negative influence.
         * Same Team
         *  -Players on the same team that are between you and goal will have a negative influence iff there are no unblocked defenders
         *      near them. If they are currently blocking a defender, they will have a slight negative influence
         */


        return null;
    }

    private final double findInfluenceOfDefender(final GamePlayer host, final GamePlayer defender){
        double distanceX = Math.abs(host.getLocation().getFirst() - defender.getLocation().getFirst());
        double distance = Location.GetDistance(defender, host);
        double avoidanceModifier = distanceX <= DEFAULT_AVOIDANCE ? DEFAULT_AVOIDANCE_INFLUENCE : DEFAULT_CUSHION_INFLUENCE;

//        Handle if the player is directly in front of you
        int angleCorrection = defender.getLocation().getFirst() <= host.getLocation().getFirst() ? 1 : -1;
        if(defender.getLocation().getFirst().equals(host.getLocation().getFirst())){
            if(host.getSideOfField().isLeft()) angleCorrection = -1;
            if(host.getSideOfField().isRight()) angleCorrection = 1;
        }

        final Vector v = new Vector(defender.getLocation(), host.getLocation());
        double theta = v.getDirection() * angleCorrection;
        theta = ((theta * ((MAX_DISTANCE - distance) / (MAX_DISTANCE - 1))) * avoidanceModifier);

        double defenderInfluence = getDefenderIsBlockedModifier(defender);

        return theta * defenderInfluence;
    }

    private final double getDefenderIsBlockedModifier(final GamePlayer defender){
        if(defender.getMovementInstruction().getAction().getActionState().isNull()) return 1;
//        If the defender is attempting a tackle, their influence should be much larger
        if(defender.getMovementInstruction().getAction().getActionState().tackle()) return 2;
//        Basically, if the defender is in the middle of a collision, its not impossible for them
//        to affect us, but the chances of them doing so are so slim we might as well call it impossible.
        if(defender.getMovementInstruction().getAction().getActionState().isColliding()) return .01;

//        Blocking is not the same as colliding, therefore we have to do math in order to figure out
//        how much influence we are able to radiate.
//        For now, since we still dont have attributes, we will just return 25% value
        if(defender.getMovementInstruction().getAction().getActionState().isBlocked()) return .25;

        return 1;
    }

    private final PlayerInfluences getSidelineInfluence(final GamePlayer hostPlayer){
        if(hostPlayer.getLocation().getFirst() > SIDELINE_LEFT_MAX_DISTANCE && hostPlayer.getLocation().getFirst() < SIDELINE_RIGHT_MAX_DISTANCE) return nullInfluence;

        final double minDistance = 3;
        final double distanceToSideLine = hostPlayer.getLocation().getFirst() < SIDELINE_LEFT_MAX_DISTANCE ?
                hostPlayer.getLocation().getFirst() : SIDELINE_RIGHT_MAX_DISTANCE - hostPlayer.getLocation().getFirst();

        final double maxInfluence = .65 * (Math.PI / 2);
        final double modInfluence = ((SIDELINE_LEFT_MAX_DISTANCE - minDistance) * (distanceToSideLine - minDistance))/(SIDELINE_LEFT_MAX_DISTANCE - minDistance);
        final int correctionInfluence = hostPlayer.getLocation().getFirst() < SIDELINE_LEFT_MAX_DISTANCE ? 1 : -1;
        final double influence = maxInfluence * modInfluence * correctionInfluence;

        return new PlayerInfluences(influence, (influence / Math.PI) * 100, SIDELINE_TAG);
    }

    private final PlayerInfluences getEndzoneInfluence(final GamePlayer hostPlayer){
        return null;
    }
}
