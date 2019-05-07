package Position.Defense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class MiddleLinebacker extends Position{

    private MiddleLinebacker(final String  subPositionName){
        super(PositionList.MIDDLE_LINEBACKER.getName(), subPositionName);
    }

    public final static MiddleLinebacker GenerateBlitzingMiddleLinebacker(final int overallSeed){
        final MiddleLinebacker middleLinebacker = new MiddleLinebacker(SubPositionList.MIDDLE_LINEBACKER.BLITZING);
        middleLinebacker.seedRating(overallSeed);
        return middleLinebacker;
    }

    public final static MiddleLinebacker GenerateCoverageMiddleLinebacker(final int overallSeed){
        final MiddleLinebacker middleLinebacker = new MiddleLinebacker(SubPositionList.MIDDLE_LINEBACKER.COVERAGE);
        middleLinebacker.seedRating(overallSeed);
        return middleLinebacker;
    }

    public final static MiddleLinebacker GenerateNeutralMiddleLinebacker(final int overallSeed){
        final MiddleLinebacker middleLinebacker = new MiddleLinebacker(SubPositionList.MIDDLE_LINEBACKER.NEUTRAL);
        middleLinebacker.seedRating(overallSeed);
        return middleLinebacker;
    }

}