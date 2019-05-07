package Position.Offense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class WideReceiver extends Position{

    private WideReceiver(final String  subPositionName){
        super(PositionList.WIDE_RECEIVER.getName(), subPositionName);
    }

    public final static WideReceiver GeneratePossessionWideReceiver(final int overallSeed){
        final WideReceiver widereceiver = new WideReceiver(SubPositionList.WIDE_RECEIVER.POSSESSION);
        widereceiver.seedRating(overallSeed);
        return widereceiver;
    }

    public final static WideReceiver GenerateSpeedWideReceiver(final int overallSeed){
        final WideReceiver widereceiver = new WideReceiver(SubPositionList.WIDE_RECEIVER.SPEED);
        widereceiver.seedRating(overallSeed);
        return widereceiver;
    }

    public final static WideReceiver GenerateNeutralWideReceiver(final int overallSeed){
        final WideReceiver widereceiver = new WideReceiver(SubPositionList.WIDE_RECEIVER.NEUTRAL);
        widereceiver.seedRating(overallSeed);
        return widereceiver;
    }

}