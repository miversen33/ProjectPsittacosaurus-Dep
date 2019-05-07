package Position.Offense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class Fullback extends Position{

    private Fullback(final String  subPositionName){
        super(PositionList.FULLBACK.getName(), subPositionName);
    }

    public final static Fullback GenerateBlockingFullback(final int overallSeed){
        final Fullback fullback = new Fullback(SubPositionList.FULLBACK.BLOCKING);
        fullback.seedRating(overallSeed);
        return fullback;
    }

    public final static Fullback GenerateRushingFullback(final int overallSeed){
        final Fullback fullback = new Fullback(SubPositionList.FULLBACK.RUSHING);
        fullback.seedRating(overallSeed);
        return fullback;
    }

    public final static Fullback GenerateNeutralFullback(final int overallSeed){
        final Fullback fullback = new Fullback(SubPositionList.FULLBACK.NEUTRAL);
        fullback.seedRating(overallSeed);
        return fullback;
    }

}