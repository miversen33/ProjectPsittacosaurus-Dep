package Game.GamePlay.Formation.Templates.Offensive.ISO;

import Game.GamePlay.Formation.Formation;
import Game.GamePlay.GamePlayer;
import Position.References.Lists.PositionList;
import Position.Position;
import Tuple.Tuple2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TEST_Twins_Right extends Formation {

    private static final Tuple2<Double, Double> W1 = new Tuple2<>(15.0, 1.0);
    private static final Tuple2<Double, Double> FB = new Tuple2<>(0.0, 8.0);
    private static final Tuple2<Double, Double> W2 = new Tuple2<>(21.0, 1.0);
    private static final Tuple2<Double, Double> LT = new Tuple2<>(-6.0, 1.0);
    private static final Tuple2<Double, Double> LG = new Tuple2<>(-3.0, 1.0);
    private static final Tuple2<Double, Double> C  = new Tuple2<>(0.0, 1.0);
    private static final Tuple2<Double, Double> RG = new Tuple2<>(3.0, 1.0);
    private static final Tuple2<Double, Double> RT = new Tuple2<>(6.0, 1.0);
    private static final Tuple2<Double, Double> TE = new Tuple2<>(9.0, 3.0);
    private static final Tuple2<Double, Double> RB = new Tuple2<>(0.0, 16.0);
    private static final Tuple2<Double, Double> QB = new Tuple2<>(0.0, 4.0);

    private static final List<Tuple2<Double, Double>> locations = Arrays.asList(
            QB,
            LT,
            LG,
            C,
            RG,
            RT,
            TE,
            FB,
            RB,
            W1,
            W2
    );

    public TEST_Twins_Right() {
        super(locations);
    }

    /**
     * This should look something like this
     *
     *       OOOOO      OO
     *     O   O
     *         O
     *         O
     *
     * Qualified as
     * 0 = QB
     * 1-5 = LT-RT
     * 6-10 = Skill Players (left-right)
     *
     *         1 2 3 4 5       9 1O
     *       6     0
     *             7
     *             8
     */

    @Override
    public List<Integer> getRecommendedLocations(GamePlayer player) {
//        We should handle sub positions in order to choose between the slots.
        Position p = player.DEBUG_getPosition();
        if(p.getPosition().equalsIgnoreCase(PositionList.QUARTERBACK.getName())) return Arrays.asList(0);
        if(p.getPosition().equalsIgnoreCase(PositionList.OFFENSIVE_TACKLE.getName())) return Arrays.asList(1,5);
        if(p.getPosition().equalsIgnoreCase(PositionList.GUARD.getName())) return Arrays.asList(2,4);
        if(p.getPosition().equalsIgnoreCase(PositionList.CENTER.getName())) return Arrays.asList(3);
        if(p.getPosition().equalsIgnoreCase(PositionList.HALFBACK.getName())) return Arrays.asList(8);
        if(p.getPosition().equalsIgnoreCase(PositionList.FULLBACK.getName())) return Arrays.asList(7);
        if(p.getPosition().equalsIgnoreCase(PositionList.TIGHT_END.getName())) return Arrays.asList(6);
        if(p.getPosition().equalsIgnoreCase(PositionList.WIDE_RECEIVER.getName())) return Arrays.asList(9,10);
//        TODO HANDLE LOGGING
        System.out.println("Unable to find appropriate place for "+p.getPosition());
        return Collections.unmodifiableList(Collections.emptyList());
    }
}
