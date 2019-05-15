package Position.Defense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class OutsideLinebacker extends Position{

    private OutsideLinebacker(final String  subPositionName){
        super(PositionList.OUTSIDE_LINEBACKER.getName(), subPositionName);
    }

    public final static OutsideLinebacker GenerateBlitzingOutsideLinebacker(final int overallSeed){
        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(SubPositionList.OUTSIDE_LINEBACKER.BLITZING);
        outsideLinebacker.seedRating(overallSeed);
        return outsideLinebacker;
    }

    public final static OutsideLinebacker GenerateCoverageOutsideLinebacker(final int overallSeed){
        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(SubPositionList.OUTSIDE_LINEBACKER.COVERAGE);
        outsideLinebacker.seedRating(overallSeed);
        return outsideLinebacker;
    }

    public final static OutsideLinebacker GenerateNeutralOutsideLinebacker(final int overallSeed){
        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(SubPositionList.OUTSIDE_LINEBACKER.NEUTRAL);
        outsideLinebacker.seedRating(overallSeed);
        return outsideLinebacker;
    }

}