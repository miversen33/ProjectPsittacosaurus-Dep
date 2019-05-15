package Position.Offense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class Guard extends Position{

    private Guard(final String  subPositionName){
        super(PositionList.GUARD.getName(), subPositionName);
    }

    public final static Guard GenerateRunblockGuard(final int overallSeed){
        final Guard guard = new Guard(SubPositionList.GUARD.RUN_BLOCK);
        guard.seedRating(overallSeed);
        return guard;
    }

    public final static Guard GeneratePassblockGuard(final int overallSeed){
        final Guard guard = new Guard(SubPositionList.GUARD.PASS_BLOCK);
        guard.seedRating(overallSeed);
        return guard;
    }

    public final static Guard GenerateNeutralGuard(final int overallSeed){
        final Guard guard = new Guard(SubPositionList.GUARD.NEUTRAL);
        guard.seedRating(overallSeed);
        return guard;
    }

}