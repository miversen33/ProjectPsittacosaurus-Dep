package Position.Offense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class Quarterback extends Position{

    private Quarterback(final String  subPositionName){
        super(PositionList.QUARTERBACK.getName(), subPositionName);
    }

    public final static Quarterback GenerateRushingQuarterback(final int overallSeed){
        final Quarterback quarterback = new Quarterback(SubPositionList.QUARTERBACK.RUSHING);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

    public final static Quarterback GeneratePassingQuarterback(final int overallSeed){
        final Quarterback quarterback = new Quarterback(SubPositionList.QUARTERBACK.PASSING);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

    public final static Quarterback GenerateNeutralQuarterback(final int overallSeed){
        final Quarterback quarterback = new Quarterback(SubPositionList.QUARTERBACK.NEUTRAL);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

}