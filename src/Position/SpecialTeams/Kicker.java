package Position.SpecialTeams;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class Kicker extends Position{

    private Kicker(final String  subPositionName){
        super(PositionList.KICKER.getName(), subPositionName);
    }

    public final static Kicker GeneratePowerKicker(final int overallSeed){
        final Kicker kicker = new Kicker(SubPositionList.KICKER.POWER);
        kicker.seedRating(overallSeed);
        return kicker;
    }

    public final static Kicker GenerateAccurateKicker(final int overallSeed){
        final Kicker kicker = new Kicker(SubPositionList.KICKER.ACCURATE);
        kicker.seedRating(overallSeed);
        return kicker;
    }

    public final static Kicker GenerateNeutralKicker(final int overallSeed){
        final Kicker kicker = new Kicker(SubPositionList.KICKER.NEUTRAL);
        kicker.seedRating(overallSeed);
        return kicker;
    }

}