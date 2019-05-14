package Game.GamePlay.Formation.Offensive;

import Game.GamePlay.Formation.Formation;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class OffensiveFormation extends Formation{

    private final int snapLocation = 0;
    private final int leftTackleLocation = 1;
    private final int leftGuardLocation  = 2;
    private final int centerLocation     = 3;
    private final int rightGuardLocation = 4;
    private final int rightTackleLocation = 5;

    private final int lastPosition = 10;
    /**
     * Position 0 needs to be the player getting the ball off the snap
     * Positions 1-5 need to be the offensive line (should be as follows
     * 1 - Left Tackle
     * 2 - Left Guard
     * 3 - Center'
     * 4 - Right Guard
     * 5 - Right Tackle
     *
     * 6-10 need to be eligible receivers. Runningbacks, Fullbacks, WideReceivers, and TightEnds needs to go here
     */
    public OffensiveFormation(final List<Tuple2<String, Tuple2<Double, Double>>> locations){
//        TODO We should probably allow xml files for this as well...
        super(locations);
    }

    public final Tuple2<Double, Double> getSnapReceiverPosition(){
        return getLocation(snapLocation);
    }

    public final List<Tuple2<Double, Double>> getOffensiveLinePositions(){
        final List<Tuple2<Double, Double>> positions = new ArrayList<>(5);
        for(int i = leftTackleLocation; i <= rightTackleLocation; i ++){
            positions.add(getLocation(i));
        }

        return positions;
    }

    public final List<Tuple2<Double, Double>> getRemainingPositions(){
        final List<Tuple2<Double, Double>> positions = new ArrayList<>(5);
        for(int i = rightTackleLocation + 1; i < lastPosition; i ++){
            positions.add(getLocation(i));
        }

        return positions;
    }
}
