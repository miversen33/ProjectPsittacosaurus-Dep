package Game.GamePlay.Formation.Defensive;

import Game.GamePlay.Formation.Formation;
import Tuple.Tuple2;

import java.util.List;

public class DefensiveFormation extends Formation {
    protected DefensiveFormation(List<Tuple2<String, Tuple2<Double, Double>>> locations) {
        super(locations);
    }

//    public DefensiveFormation(){
//        super();
//    }
}
