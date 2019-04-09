package Game.GamePlay.PlayerStrategy;

import Game.Field.CardinalDirection;
import Game.GamePlay.GameField;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import Game.Routes.Route;
import PhysicsEngine.Movements.MovementInstruction;
import Utils.PhysicsObjects.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePlayerStrategy implements IPlayerStrategy {

    private final Route mPlayerRoute;
    private boolean ignoreRoute = false;

    public BasePlayerStrategy(final Route route){
        mPlayerRoute = route;
    }

    public final Route getRoute(){
        return mPlayerRoute;
    }

    protected final void ignoreRoute(){
        ignoreRoute = true;
    }

    protected final MovementInstruction getMove(final GamePlayer player, final GameField field){
        if(isRouteIgnored()) return null;
        return getRoute().getMove(player, field);
    }

    public final boolean isRouteIgnored(){
        return ignoreRoute;
    }

    public final static PlayerInfluence GetNullInfluence(final String name){
        return new PlayerInfluence(new Vector(0,0), 0, name);
    }

    public final static List<GamePlayer> FilterByDirection(final GamePlayer hostPlayer, final List<GamePlayer> players, final CardinalDirection ... directions){
        final ArrayList<GamePlayer> filteredPlayers = new ArrayList<>();

        if(players == null || players.isEmpty()) return filteredPlayers;

        boolean passedThrough = false;
        List<GamePlayer> filterList = players;
        for(CardinalDirection direction : directions) {
            if(passedThrough) filterList = filteredPlayers;
            switch (direction) {
                case NORTH:
                    for (final GamePlayer player : filterList) {
                        if (player.getLocation().getSecond() <= hostPlayer.getLocation().getSecond() && !filteredPlayers.contains(player))
                            filteredPlayers.add(player);
                    }
                    break;
                case SOUTH:
                    for (final GamePlayer player : filterList) {
                        if (player.getLocation().getSecond() >= hostPlayer.getLocation().getSecond() && !filteredPlayers.contains(player))
                            filteredPlayers.add(player);
                    }
                    break;
                case EAST:
                    for (final GamePlayer player : filterList) {
                        if (player.getLocation().getFirst() >= hostPlayer.getLocation().getFirst() && !filteredPlayers.contains(player))
                            filteredPlayers.add(player);
                    }
                    break;
                case WEST:
                    for (final GamePlayer player : filterList) {
                        if (player.getLocation().getFirst() <= hostPlayer.getLocation().getFirst() && !filteredPlayers.contains(player))
                            filteredPlayers.add(player);
                    }
                    break;
            }
            passedThrough = true;
        }
        return filteredPlayers;
    }

    public final static List<GamePlayer> FilterBySameTeam(final GamePlayer hostPlayer, final List<GamePlayer> players){
        final ArrayList<GamePlayer> filteredList = new ArrayList<>();

        if(players == null || players.isEmpty()) return filteredList;
        for(final GamePlayer player : players){
            if(player.sameTeamCheck(hostPlayer)) filteredList.add(player);
        }
        return filteredList;
    }

    public final static List<GamePlayer> FilterByOppositeTeam(final GamePlayer hostPlayer, final List<GamePlayer> players){
        if(players == null || players.isEmpty()) return new ArrayList<>();

        final ArrayList<GamePlayer> filteredList = new ArrayList<>();
        for(final GamePlayer player : players){
            if(!player.sameTeamCheck(hostPlayer)) filteredList.add(player);
        }
        return filteredList;
    }

    public final static List<GamePlayer> FilterByPosition(final GamePlayer hostPlayer, final List<GamePlayer> players){
//        TODO
        System.out.println("This doesn't exist yet");
        return null;
    }

    public final static GamePlayer GetPlayerFurthestInDirection(final CardinalDirection direction, final List<GamePlayer> players){
//        TODO We might need to add an additional parameter to check if we are in the field of play or not

//        Assuming players is not size 0;
        if(players == null || players.isEmpty()) return null;

        GamePlayer returnPlayer = players.get(0);

        switch (direction){
            case NORTH:
                for(final GamePlayer player : players){
                    if(player.getLocation().getSecond() < returnPlayer.getLocation().getSecond()) returnPlayer = player;
                }
                break;

            case SOUTH:
                for(final GamePlayer player : players){
                    if(player.getLocation().getSecond() > returnPlayer.getLocation().getSecond()) returnPlayer = player;
                }
                break;

            case EAST:
                for(final GamePlayer player : players){
                    if(player.getLocation().getFirst() > returnPlayer.getLocation().getFirst()) returnPlayer = player;
                }
                break;

            case WEST:
                for(final GamePlayer player : players){
                    if(player.getLocation().getFirst() < returnPlayer.getLocation().getFirst()) returnPlayer = player;
                }
                break;

        }

        return returnPlayer;
    }

    public final static PlayerInfluence GetSameTeamPlayerInfluence(final GamePlayer hostPlayer, final GamePlayer sameTeamPlayer){
        final double magnitude = 1.01;
        Vector influence = new Vector(sameTeamPlayer.getLocation(), hostPlayer.getLocation());
        influence = new Vector(influence.getDirection(), magnitude);
        return new PlayerInfluence(influence, (influence.getDirection() / Math.PI) * 100, sameTeamPlayer.getName());
    }
}
