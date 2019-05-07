package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;
import Position.References.BaseAttribute;
import Position.References.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class HalfBack extends Position{

    private HalfBack(final String  subPositionName){
        super(PositionList.HALFBACK.getName(), subPositionName);
    }

    public final static HalfBack GenerateSpeedHalfBack(final int overallSeed){
        final HalfBack halfback = new HalfBack(SubPositionList.HALFBACK.SPEED);
        halfback.seedRating(overallSeed);
        return halfback;
    }

    public final static HalfBack GeneratePowerHalfBack(final int overallSeed){
        final HalfBack halfback = new HalfBack(SubPositionList.HALFBACK.POWER);
        halfback.seedRating(overallSeed);
        return halfback;
    }

    public final static HalfBack GenerateNeutralHalfBack(final int overallSeed){
        final HalfBack halfback = new HalfBack(SubPositionList.HALFBACK.NEUTRAL);
        halfback.seedRating(overallSeed);
        return halfback;
    }

}