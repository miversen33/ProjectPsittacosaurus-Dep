package Position.Defense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class StrongSafety extends Position{

    private StrongSafety(final String  subPositionName){
        super(PositionList.STRONG_SAFETY.getName(), subPositionName);
    }

    public final static StrongSafety GenerateCoverageStrongSafety(final int overallSeed){
        final StrongSafety strongSafety = new StrongSafety(SubPositionList.STRONG_SAFETY.COVERAGE);
        strongSafety.seedRating(overallSeed);
        return strongSafety;
    }

    public final static StrongSafety GenerateHardhittingStrongSafety(final int overallSeed){
        final StrongSafety strongSafety = new StrongSafety(SubPositionList.STRONG_SAFETY.HARDHITTER);
        strongSafety.seedRating(overallSeed);
        return strongSafety;
    }

    public final static StrongSafety GenerateNeutralStrongSafety(final int overallSeed){
        final StrongSafety strongSafety = new StrongSafety(SubPositionList.STRONG_SAFETY.NEUTRAL);
        strongSafety.seedRating(overallSeed);
        return strongSafety;
    }

}