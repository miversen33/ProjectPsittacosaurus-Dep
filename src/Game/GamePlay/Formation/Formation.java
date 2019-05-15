package Game.GamePlay.Formation;

import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Formation{

    private final List<Tuple2<GamePlayer, Tuple2<Double, Double>>> locations = new ArrayList<>(GameManager.ON_FIELD_TEAM_SIZE);

    public final void addLocation(final int slot, final GamePlayer player, final Tuple2<Double, Double> newLocation){
        locations.add(slot, new Tuple2<>(player, newLocation));
    }

    public final List<Tuple2<GamePlayer, Tuple2<Double, Double>>> getLocations(){
        return new ArrayList<>(Collections.unmodifiableList(locations));
    }

    /**
     * Returns a list (in importance order) of slots that are recommended for this player.
     * This may return an empty list, if that is the case, this player is not recommended
     * for this formation. That doesn't mean you can't use them, just that the
     * system doesn't believe that player will be effective in the provided formation
     */
    public abstract List<Integer> getRecommendedLocations(final GamePlayer player);
}
