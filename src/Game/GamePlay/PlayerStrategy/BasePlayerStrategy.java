package Game.GamePlay.PlayerStrategy;

import Game.Field.CardinalDirection;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.PlayerInfluence;
import PhysicsEngine.PhysicsObjects.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePlayerStrategy implements IPlayerStrategy {

    protected final PlayerInfluence getNullInfluence(final String name){
        return new PlayerInfluence(new Vector(0,0), 0, name);
    }

    protected final List<GamePlayer> filterByDirection(final GamePlayer hostPlayer, final List<GamePlayer> players, final CardinalDirection ... directions){
        final ArrayList<GamePlayer> filteredPlayers = new ArrayList<>();

        for(CardinalDirection direction : directions) {
            switch (direction) {
                case NORTH:
                    for (final GamePlayer player : players) {
                        if (player.getLocation().getSecond() <= hostPlayer.getLocation().getSecond())
                            filteredPlayers.add(player);
                    }
                    break;
                case SOUTH:
                    for (final GamePlayer player : players) {
                        if (player.getLocation().getSecond() >= hostPlayer.getLocation().getSecond())
                            filteredPlayers.add(player);
                    }
                    break;
                case EAST:
                    for (final GamePlayer player : players) {
                        if (player.getLocation().getFirst() >= hostPlayer.getLocation().getFirst())
                            filteredPlayers.add(player);
                    }
                    break;
                case WEST:
                    for (final GamePlayer player : players) {
                        if (player.getLocation().getFirst() <= hostPlayer.getLocation().getFirst())
                            filteredPlayers.add(player);
                    }
                    break;
            }
        }
        return filteredPlayers;
    }

    protected final List<GamePlayer> filterBySameTeam(final GamePlayer hostPlayer, final List<GamePlayer> players){
        final ArrayList<GamePlayer> filteredList = new ArrayList<>();
        for(final GamePlayer player : players){
            if(player.sameTeamCheck(hostPlayer)) filteredList.add(player);
        }
        return filteredList;
    }

    protected final List<GamePlayer> filterByOppositeTeam(final GamePlayer hostPlayer, final List<GamePlayer> players){
        final ArrayList<GamePlayer> filteredList = new ArrayList<>();
        for(final GamePlayer player : players){
            if(!player.sameTeamCheck(hostPlayer)) filteredList.add(player);
        }
        return filteredList;
    }

    protected final PlayerInfluence getSameTeamPlayerInfluence(final GamePlayer hostPlayer, final GamePlayer sameTeamPlayer){
        final double magnitude = 1;
        Vector influence = new Vector(sameTeamPlayer.getLocation(), hostPlayer.getLocation());
        influence = new Vector(influence.getDirection(), magnitude);
        return new PlayerInfluence(influence, (influence.getDirection() / Math.PI) * 100, sameTeamPlayer.getName());
    }
}
