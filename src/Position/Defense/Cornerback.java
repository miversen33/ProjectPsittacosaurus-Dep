package Position.Defense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class Cornerback extends Position{

    private Cornerback(final String  subPositionName){
        super(PositionList.CORNERBACK.getName(), subPositionName);
    }

    public final static Cornerback GenerateCoverageCornerback(final int overallSeed){
        final Cornerback cornerback = new Cornerback(SubPositionList.CORNERBACK.COVERAGE);
        cornerback.seedRating(overallSeed);
        return cornerback;
    }

    public final static Cornerback GenerateHardhittingCornerback(final int overallSeed){
        final Cornerback cornerback = new Cornerback(SubPositionList.CORNERBACK.HARDHITTER);
        cornerback.seedRating(overallSeed);
        return cornerback;
    }

    public final static Cornerback GenerateNeutralCornerback(final int overallSeed){
        final Cornerback cornerback = new Cornerback(SubPositionList.CORNERBACK.NEUTRAL);
        cornerback.seedRating(overallSeed);
        return cornerback;
    }

}