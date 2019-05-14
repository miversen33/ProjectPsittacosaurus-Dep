package Game.GamePlay.Formation;

import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Formation {
    private List<Tuple2<String, Tuple2<Double, Double>>> locations = new ArrayList<>(GameManager.ON_FIELD_TEAM_SIZE);

    protected Formation(final List<Tuple2<String, Tuple2<Double, Double>>> locations){
        if(locations.size() != GameManager.ON_FIELD_TEAM_SIZE){
//            TODO Handle Logging
            System.out.println("We cannot add the locations given as it is incorrectly formatted. Please check and try again");
            return;
        }
        this.locations.addAll(Collections.unmodifiableList(locations));
    }

    /**
     * This will return a Tuple2 with coordinates off the center (position 1)
     */
    public final Tuple2<Double, Double> getLocation(final int locationInList){
        if(locationInList > locations.size()){
//            TODO Handle logging
            System.out.println("Unable to get position "+locationInList+" as that is outside the locations list");
            return null;
        }
        return locations.get(locationInList).getSecond();
    }
//
//    public final List<Tuple2<Double, Double>> getRecommendedLocations(final GamePlayer player){
//        final List<Tuple2<Double, Double>> l = new ArrayList<>();
//        for(final Tuple2<String, Tuple2<Double, Double>> location : locations){
//            if(location.getFirst().equalsIgnoreCase(player.))
//        }
//    }
}
