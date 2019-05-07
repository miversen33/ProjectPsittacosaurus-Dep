package Position.Offense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class OffensiveTackle extends Position{

    private OffensiveTackle(final String  subPositionName){
        super(PositionList.OFFENSIVE_TACKLE.getName(), subPositionName);
    }

    public final static OffensiveTackle GenerateRunblockOffensiveTackle(final int overallSeed){
        final OffensiveTackle offensiveTackle = new OffensiveTackle(SubPositionList.OFFENSIVE_TACKLE.RUN_BLOCK);
        offensiveTackle.seedRating(overallSeed);
        return offensiveTackle;
    }

    public final static OffensiveTackle GeneratePassblockOffensiveTackle(final int overallSeed){
        final OffensiveTackle offensiveTackle = new OffensiveTackle(SubPositionList.OFFENSIVE_TACKLE.PASS_BLOCK);
        offensiveTackle.seedRating(overallSeed);
        return offensiveTackle;
    }

    public final static OffensiveTackle GenerateNeutralOffensiveTackle(final int overallSeed){
        final OffensiveTackle offensiveTackle = new OffensiveTackle(SubPositionList.OFFENSIVE_TACKLE.NEUTRAL);
        offensiveTackle.seedRating(overallSeed);
        return offensiveTackle;
    }

}