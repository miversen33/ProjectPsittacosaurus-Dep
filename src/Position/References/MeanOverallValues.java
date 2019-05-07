package Position.References;

import Position.Lists.PositionList;

import java.util.Arrays;
import java.util.List;

public enum MeanOverallValues {

    CB(PositionList.CORNERBACK.getName(), 0.73),
    DE(PositionList.DEFENSIVE_END.getName(), 0.75),
    DT(PositionList.DEFENSIVE_TACKLE.getName(), 0.74),
    FS(PositionList.FREE_SAFETY.getName(), 0.74),
    MLB(PositionList.MIDDLE_LINEBACKER.getName(), 0.71),
    OLB(PositionList.OUTSIDE_LINEBACKER.getName(), 0.72),
    SS(PositionList.STRONG_SAFETY.getName(), 0.73),
    C(PositionList.CENTER.getName(), 0.70),
    G(PositionList.GUARD.getName(), 0.70),
    OT(PositionList.OFFENSIVE_TACKLE.getName(), 0.70),
    FB(PositionList.FULLBACK.getName(), 0.67),
    HB(PositionList.HALFBACK.getName(), 0.74),
    QB(PositionList.QUARTERBACK.getName(), 0.72),
    TE(PositionList.TIGHT_END.getName(), 0.69),
    WR(PositionList.WIDE_RECEIVER.getName(), 0.73),
    K(PositionList.KICKER.getName(), 0.78),
    P(PositionList.PUNTER.getName(), 0.79)
    ;

    private final static List<MeanOverallValues> values = Arrays.asList(
        CB,
        DE,
        DT,
        FS,
        MLB,
        OLB,
        SS,
        C,
        G,
        OT,
        FB,
        HB,
        QB,
        TE,
        WR,
        K,
        P
    );

    private final String name;
    private final double mean;

    MeanOverallValues(final String name, final double mean){
        this.name = name;
        this.mean = mean;
    }

    public final String getName(){
        return name;
    }

    public final double getMean(){
        return mean;
    }

    public final static double GetPositionMeanOverall(final String position){
        for(final MeanOverallValues value : values){
            if(value.getName().equalsIgnoreCase(position)) return value.getMean();
        }
        System.out.println("Unable to find " + position + ". Please try again");
        return 0.0;
    }
}
