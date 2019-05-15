package Position.Offense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class TightEnd extends Position{

    private TightEnd(final String  subPositionName){
        super(PositionList.TIGHT_END.getName(), subPositionName);
    }

    public final static TightEnd GenerateBlockingTightEnd(final int overallSeed){
        final TightEnd tightend = new TightEnd(SubPositionList.TIGHT_END.BLOCKING);
        tightend.seedRating(overallSeed);
        return tightend;
    }

    public final static TightEnd GenerateReceivingTightEnd(final int overallSeed){
        final TightEnd tightend = new TightEnd(SubPositionList.TIGHT_END.RECEIVING);
        tightend.seedRating(overallSeed);
        return tightend;
    }

    public final static TightEnd GenerateNeutralTightEnd(final int overallSeed){
        final TightEnd tightend = new TightEnd(SubPositionList.TIGHT_END.NEUTRAL);
        tightend.seedRating(overallSeed);
        return tightend;
    }

}