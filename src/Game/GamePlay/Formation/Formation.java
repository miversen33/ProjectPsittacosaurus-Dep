package Game.GamePlay.Formation;

import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Formation{
    /**
     * Some rules
     * There has to be a minimum 7 players on the offensive line of scrimmage
     * 2 of these have to be eligible receivers
     * What is an eligible receiver?
     */

    private final List<Tuple2<GamePlayer, Tuple2<Double, Double>>> locations = new ArrayList<>(GameManager.ON_FIELD_TEAM_SIZE);
    private List<Tuple2<Double, Double>> locationPresets = new ArrayList<>(GameManager.ON_FIELD_TEAM_SIZE);

    protected Formation(final List<Tuple2<Double, Double>> locationsOffBall){
        if(locationsOffBall.size() != GameManager.ON_FIELD_TEAM_SIZE){
//            TODO HANDLE LOGGING
            System.out.println("Unable to create formation. Size of locations is incorrect");
            return;
        }
        locationPresets = Collections.unmodifiableList(new ArrayList<>(locationsOffBall));
    }

    public final void addLocation(final int slot, final GamePlayer player){
        locations.add(slot, new Tuple2<>(player, locationPresets.get(slot)));
    }

    public final List<Tuple2<GamePlayer, Tuple2<Double, Double>>> getLocations(){
//        TODO Handle signature check to verify who is asking for this
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
