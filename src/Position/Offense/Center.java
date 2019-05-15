package Position.Offense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class Center extends Position{

    private Center(final String  subPositionName){
        super(PositionList.CENTER.getName(), subPositionName);
    }

    public final static Center GenerateRunblockCenter(final int overallSeed){
        final Center center = new Center(SubPositionList.CENTER.RUN_BLOCK);
        center.seedRating(overallSeed);
        return center;
    }

    public final static Center GeneratePassblockCenter(final int overallSeed){
        final Center center = new Center(SubPositionList.CENTER.PASS_BLOCK);
        center.seedRating(overallSeed);
        return center;
    }

    public final static Center GenerateNeutralCenter(final int overallSeed){
        final Center center = new Center(SubPositionList.CENTER.NEUTRAL);
        center.seedRating(overallSeed);
        return center;
    }

}