package Position.Defense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class FreeSafety extends Position{

    private FreeSafety(final String  subPositionName){
        super(PositionList.FREE_SAFETY.getName(), subPositionName);
    }

    public final static FreeSafety GenerateCoverageFreeSafety(final int overallSeed){
        final FreeSafety freesafety = new FreeSafety(SubPositionList.FREE_SAFETY.COVERAGE);
        freesafety.seedRating(overallSeed);
        return freesafety;
    }

    public final static FreeSafety GenerateHardhittingFreeSafety(final int overallSeed){
        final FreeSafety freesafety = new FreeSafety(SubPositionList.FREE_SAFETY.HARDHITTER);
        freesafety.seedRating(overallSeed);
        return freesafety;
    }

    public final static FreeSafety GenerateNeutralFreeSafety(final int overallSeed){
        final FreeSafety freesafety = new FreeSafety(SubPositionList.FREE_SAFETY.NEUTRAL);
        freesafety.seedRating(overallSeed);
        return freesafety;
    }

}