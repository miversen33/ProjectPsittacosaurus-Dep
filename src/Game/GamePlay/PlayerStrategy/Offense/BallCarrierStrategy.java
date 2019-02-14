package Game.GamePlay.PlayerStrategy.Offense;

import Game.Field.CardinalDirection;
import Game.Field.Field;
import Game.GamePlay.GameField;
import Game.GamePlay.PlayerInfluence;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import PhysicsEngine.PhysicsObjects.Vector;
import Game.GamePlay.GamePlayer;
import Game.IGamePlayerOwner;
import PhysicsEngine.Movements.MovementInstruction;
import Tuple.Tuple2;
import Utils.Location;

import java.util.ArrayList;
import java.util.List;

public final class BallCarrierStrategy implements IPlayerStrategy {

    private MovementInstruction move = null;
    private final static double MAX_DISTANCE_Y = 60;
    private final static double MAX_DISTANCE_X = 30;
//    This is terrible. Fix it
    private final static double MAX_DISTANCE = MAX_DISTANCE_X > MAX_DISTANCE_Y ? MAX_DISTANCE_X : MAX_DISTANCE_Y;
    private final static double DEFAULT_AVOIDANCE_INFLUENCE = 1.5;
    private final static double DEFAULT_CUSHION_INFLUENCE = 1;
    private final static double SIDELINE_LEFT_MAX_DISTANCE = 12;
    private final static double SIDELINE_RIGHT_MAX_DISTANCE = Field.FIELD_WIDTH - SIDELINE_LEFT_MAX_DISTANCE;

    private final static String SIDELINE_TAG_LEFT   = "SIDELINE_LEFT";
    private final static String SIDELINE_TAG_RIGHT  = "SIDELINE_RIGHT";
    private final static String TOUCHDOWN_TAG_NORTH = "TOUCHDOWN_NORTH";
    private final static String TOUCHDOWN_TAG_SOUTH = "TOUCHDOWN_SOUTH";
    private final static String FIRSTDOWN_TAG = "FIRST DOWN";

    private final boolean DEBUG_RAILS = false;

    public BallCarrierStrategy() {
//        Consider having the defaults be provided so that every player has a "custom" strategy as they progress
    }

    @Override
    public final void calculateMove(final GamePlayer hostPlayer, final GameField field) {
//        Optimize me
        if(DEBUG_RAILS){
            final Vector movement = new Vector(new Tuple2<>(0.0, hostPlayer.getTeamGoal().isNorth() ? -3.0 : 3.0));
            move = new MovementInstruction(hostPlayer, movement);
            return;
        }

        final List<PlayerInfluence> playerInfluences = getInfluences(hostPlayer, field);
        Vector movement = new Vector(0,0);
        for(final PlayerInfluence influence : playerInfluences){
            movement = movement.add(influence.getInfluence());
        }
        movement = new Vector(movement.getDirection(), hostPlayer.getMaxMovement(movement.getDirection()));

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
    public List<PlayerInfluence> getInfluences(final GamePlayer hostPlayer, final GameField field) {
        final List<PlayerInfluence> playerBiases = hostPlayer.getPlayerInfluenceBiases();
//        Biases the Strategy will care about
        /**
         * *Touchdown
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
         * *Sideline
         *  -This bias should only ever be enough to push the player to stay away from it. It should be enough to keep the ball
         *      carrier away from it, until a defender is within 4 yards of them (to which the defender should be
         *      able to outweigh this bias). Really, this bias should just amount to keeping the ball carrier
         *      from accidentally stepping out of bounds before they are ready.
         *  -This bias is null unless the ballcarrier is within 3 yards of a sideline, and it is at full force if the player is
         *      1 yard away from the sideline.
         * Field Position
         *  -A rather vague bias, but there are times where reaching a certain point on the field is important,
         *      say to get an easier setup for a field goal, for example.
         * *Defenders
         *  -All defenders within our MAX_DISTANCE_Y from us will have an influence.
         *  -If the defender is blocked it will receive a percentage of the original influence. This percentage will
         *      be calculated based on the player blocking them
         *  -If the defender is unblocked they will receive 100% of their influence
         * *Lead Blockers
         *  -A Lead Blocker will have a negative influence.
         */
        playerBiases.addAll(getEndzoneInfluence(hostPlayer));
        playerBiases.addAll(getSidelineInfluence(hostPlayer));
        playerBiases.addAll(scanPlayers(hostPlayer, field));

        return playerBiases;
    }

    private final List<PlayerInfluence> scanPlayers(final GamePlayer hostPlayer, final GameField field){
        final double distanceToFinalGoal = Location.GetDistance(hostPlayer.getLocation(), hostPlayer.getTeamGoal().getGoalLocation(hostPlayer));
        final List<PlayerInfluence> influences = new ArrayList<>();
        List<GamePlayer> playersBetweenGoal = field.checkLocation(hostPlayer, distanceToFinalGoal);
        List<GamePlayer> sameTeam;
        List<GamePlayer> otherTeam;
        if(hostPlayer.getTeamGoal().isNorth()){
            playersBetweenGoal = filterByDirection(hostPlayer, playersBetweenGoal, CardinalDirection.NORTH);
        } else{
            playersBetweenGoal = filterByDirection(hostPlayer, playersBetweenGoal, CardinalDirection.SOUTH);
        }
        sameTeam = filterBySameTeam(hostPlayer, playersBetweenGoal);
        otherTeam = filterByOppositeTeam(hostPlayer, playersBetweenGoal);
        for(final GamePlayer player : sameTeam){
            influences.add(getLeadBlockerInfluence(hostPlayer, player));
        }

        for(final GamePlayer player : otherTeam){
            influences.add(getDefenderInfluence(hostPlayer, player, field));
        }

        return influences;
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

    private final List<PlayerInfluence> getSidelineInfluence(final GamePlayer hostPlayer) {
        final List<PlayerInfluence> influences = new ArrayList<>();
        influences.add(getLeftSideLineInfluence(hostPlayer));
        influences.add(getRightSideLineInfluence(hostPlayer));

        return influences;
    }

    private final PlayerInfluence getLeftSideLineInfluence(final GamePlayer hostPlayer){
        final double baseInfluence = .65;

        if(hostPlayer.getLocation().getFirst() > SIDELINE_LEFT_MAX_DISTANCE) return getNullInfluence(SIDELINE_TAG_LEFT);
        Vector v = new Vector(new Tuple2<>(Field.FIELD_WIDTH - hostPlayer.getLocation().getFirst(), hostPlayer.getLocation().getSecond()));

        v = v.scale(baseInfluence);

        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, SIDELINE_TAG_LEFT);
    }

    private final PlayerInfluence getRightSideLineInfluence(final GamePlayer hostPlayer){
        final double baseInfluence = .65;

        if(hostPlayer.getLocation().getFirst() < SIDELINE_RIGHT_MAX_DISTANCE) return getNullInfluence(SIDELINE_TAG_RIGHT);
        Vector v = new Vector(new Tuple2<>(hostPlayer.getLocation().getFirst(), hostPlayer.getLocation().getSecond()));

        v = v.scale(baseInfluence);

        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, SIDELINE_TAG_RIGHT);
    }

    private final List<PlayerInfluence> getEndzoneInfluence(final GamePlayer hostPlayer){
        final List<PlayerInfluence> influences = new ArrayList<>();
        influences.add(getNorthEndzoneInfluence(hostPlayer));
        influences.add(getSouthEndzoneInfluence(hostPlayer));

        return influences;
    }

    private final PlayerInfluence getNorthEndzoneInfluence(final GamePlayer hostPlayer){
        Vector v = new Vector(0,0);
        if(hostPlayer.getTeamGoal().isNorth()){
            final double direction = -(Math.PI/2);
            final double magnitude = hostPlayer.getLocation().getSecond();
            v = new Vector(direction, magnitude);
        }
        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, TOUCHDOWN_TAG_NORTH);
    }

    private final PlayerInfluence getSouthEndzoneInfluence(final GamePlayer hostPlayer){
        Vector v = new Vector(0,0);
        if(hostPlayer.getTeamGoal().isSouth()){
            final double direction = Math.PI/2;
            final double magnitude = Field.FIELD_HEIGHT - hostPlayer.getLocation().getSecond();
            v = new Vector(direction, magnitude);
        }
        return new PlayerInfluence(v, (v.getDirection() / Math.PI) * 100, TOUCHDOWN_TAG_SOUTH);
    }

//    Default Defender Influence appears to be functional.
    private final PlayerInfluence getDefenderInfluence(final GamePlayer hostPlayer, final GamePlayer defender, final GameField field){
//        If the defender is to far away, we dont care
        if(Math.abs(hostPlayer.getLocation().getSecond() - defender.getLocation().getSecond()) > MAX_DISTANCE_Y) return getNullInfluence(defender.getName());
        if(Math.abs(hostPlayer.getLocation().getFirst() - defender.getLocation().getFirst()) > MAX_DISTANCE_X) return getNullInfluence(defender.getName());

        final Vector baseVector = new Vector(defender.getLocation(), hostPlayer.getLocation());

        final double baseMagnitude = 1.5;
        final double magnitude = baseMagnitude * (1+(MAX_DISTANCE - baseVector.getMagnitude()));
        double direction = defender.getLocation().getFirst() > hostPlayer.getLocation().getFirst() ? -Math.PI : 0;
        if(hostPlayer.getLocation().getFirst().equals(defender.getLocation().getFirst())){
            final List<GamePlayer> playersOnField = field.checkLocation(hostPlayer, Field.FIELD_HEIGHT);

            int sideLeft = -1 * filterByDirection(hostPlayer, filterByOppositeTeam(hostPlayer, playersOnField), CardinalDirection.WEST).size();
            sideLeft += filterByDirection(hostPlayer, filterBySameTeam(hostPlayer, playersOnField), CardinalDirection.WEST).size();

            int sideRight = filterByDirection(hostPlayer, filterByOppositeTeam(hostPlayer, playersOnField), CardinalDirection.EAST).size();
            sideLeft -= filterByDirection(hostPlayer, filterBySameTeam(hostPlayer, playersOnField), CardinalDirection.EAST).size();

            int sideTotal = sideRight + sideLeft;
            if(sideTotal == 0){
                sideTotal = Field.GetDistanceFromLeftSideLine(hostPlayer) > Field.GetDistanceFromRightSideLine(hostPlayer) ? -1 : 1;
            }

            direction = sideTotal > 0 ? -Math.PI : 0;
        }
        final Vector influenceVector = new Vector(direction, magnitude);

        return new PlayerInfluence(influenceVector, (direction / Math.PI) * 100, defender.getName());
    }

    private final PlayerInfluence getLeadBlockerInfluence(final GamePlayer hostPlayer, final GamePlayer potentialBlocker){
        Vector influence = new Vector(hostPlayer.getLocation(), potentialBlocker.getLocation());

        return new PlayerInfluence(influence, (influence.getDirection() / Math.PI) * 100, potentialBlocker.getName());
////        Check to ensure host and potential are on the same team
//        final double maxBlockDistanceInfluence = .75;
//        final double maxDistance = 45;
//        final double effectiveDistance = 30;
//        final double effectiveBlockDistanceInfluence = 1;
////        final int correctionInfluence = -1;
////        If the lead blocker is currently blocking someone, we should want to get near them.
//        final double blockingInfluence = potentialBlocker.getMovementInstruction().getAction().getActionState().isBlocked() ? 2 : 1;
//
//        if(!hostPlayer.sameTeamCheck(potentialBlocker)) return nullInfluence;
////        Check if the blocker is between us and the goal. If they aren't they have no influence on us
//        if(!((hostPlayer.getTeamGoal().getGoalLocation(hostPlayer).getSecond() < hostPlayer.getLocation().getSecond() &&
//                hostPlayer.getLocation().getSecond() > potentialBlocker.getLocation().getSecond()) ||
//           (hostPlayer.getTeamGoal().getGoalLocation(hostPlayer).getSecond() > hostPlayer.getLocation().getSecond() &&
//                hostPlayer.getLocation().getSecond() < potentialBlocker.getLocation().getSecond()))) return nullInfluence;
//        if(Location.GetDistance(hostPlayer, potentialBlocker) > maxDistance) return nullInfluence;
//
//        final double distance = Location.GetDistance(hostPlayer, potentialBlocker);
//        final double baseInfluence = distance > effectiveBlockDistanceInfluence ? maxBlockDistanceInfluence : effectiveBlockDistanceInfluence;
//
//        double influence = distance / (baseInfluence == maxBlockDistanceInfluence ? effectiveDistance : maxDistance);
//        influence = (baseInfluence * influence * blockingInfluence);
//
//        return new PlayerInfluence(influence, (influence / Math.PI) * 100, potentialBlocker.getName());
    }

//    All of these should not be housed in the BallCarrierStrat. Setup up
//    Some sort of heirarchy

    private final PlayerInfluence getNullInfluence(final String name){
        return new PlayerInfluence(new Vector(0,0), 0, name);
    }

    private final List<GamePlayer> filterByDirection(final GamePlayer hostPlayer, final List<GamePlayer> players, final CardinalDirection direction){
        final ArrayList<GamePlayer> filteredPlayers = new ArrayList<>();

        switch(direction){
            case NORTH:
                for(final GamePlayer player : players){
                    if(player.getLocation().getSecond() <= hostPlayer.getLocation().getSecond()) filteredPlayers.add(player);
                }
                break;
            case SOUTH:
                for(final GamePlayer player : players){
                        if(player.getLocation().getSecond() >= hostPlayer.getLocation().getSecond()) filteredPlayers.add(player);
                }
                break;
            case EAST:
                for(final GamePlayer player : players){
                    if(player.getLocation().getFirst() >= hostPlayer.getLocation().getFirst()) filteredPlayers.add(player);
                }
                break;
            case WEST:
                for(final GamePlayer player : players){
                    if(player.getLocation().getFirst() <= hostPlayer.getLocation().getFirst()) filteredPlayers.add(player);
                }
                break;
        }
        return filteredPlayers;
    }

    private final List<GamePlayer> filterBySameTeam(final GamePlayer hostPlayer, final List<GamePlayer> players){
        final ArrayList<GamePlayer> filteredList = new ArrayList<>();
        for(final GamePlayer player : players){
            if(player.sameTeamCheck(hostPlayer)) filteredList.add(player);
        }
        return filteredList;
    }

    private final List<GamePlayer> filterByOppositeTeam(final GamePlayer hostPlayer, final List<GamePlayer> players){
        final ArrayList<GamePlayer> filteredList = new ArrayList<>();
        for(final GamePlayer player : players){
            if(!player.sameTeamCheck(hostPlayer)) filteredList.add(player);
        }
        return filteredList;
    }
}
