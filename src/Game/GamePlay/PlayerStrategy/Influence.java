package Game.GamePlay.PlayerStrategy;

import Game.GamePlay.PlayerInfluence;
import Tuple.Tuple2;

import java.util.ArrayList;

public final class Influence {
    private final PlayerInfluence influenceType;
    private final double percentInfluence;
//    private final List<Tuple2<Attribute, Double>> influencingAttributes = new ArrayList<>();

    public Influence(final PlayerInfluence influence, final double percentInfluence){
        influenceType = influence;
        this.percentInfluence = percentInfluence;
    }

    public final PlayerInfluence getInfluence(){
        return influenceType;
    }

    public final double getPercentInfluence(){
        return percentInfluence;
    }
}
