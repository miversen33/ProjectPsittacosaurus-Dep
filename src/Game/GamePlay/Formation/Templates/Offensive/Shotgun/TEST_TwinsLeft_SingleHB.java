package Game.GamePlay.Formation.Templates.Offensive.Shotgun;

import Game.GamePlay.Formation.Formation;
import Game.GamePlay.GamePlayer;
import Position.References.Lists.PositionList;
import Position.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TEST_TwinsLeft_SingleHB extends Formation {

    /**
     * This should look something like this
     *
     * O        OOOOO          O
     *  O            O
     *           OO
     *
     * Qualified as
     * 0 = QB
     * 1-5 = LT-RT
     * 6-10 = Skill Players (left-right)
     *
     * 6        1 2 3 4 5          1O
     *  7                9
     *            8 O
     *
     * Realistically, this should be able to load from an XML as that
     * would be infinitely easier to save/create new formations.
     *
     * Therefore this should also save down to a xml
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
        if(p.getPosition().equalsIgnoreCase(PositionList.TIGHT_END.getName())) return Arrays.asList(9);
        if(p.getPosition().equalsIgnoreCase(PositionList.WIDE_RECEIVER.getName())) return Arrays.asList(6,7,10);
//        TODO HANDLE LOGGING
        System.out.println("Unable to find appropriate place for "+p.getPosition());
        return Collections.unmodifiableList(Collections.emptyList());
    }
}
