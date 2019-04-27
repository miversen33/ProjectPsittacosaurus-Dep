package Attributes;

import Utils.RNG;

public final class AttributeInterpreter {

    public static double GetThrowPowerFeetPerSecond(final Attribute<Integer> throwPower){
        final double constantMin = 115;
        final double baseMin = -.10645;
        final double baseMax = .07413;
        final double maxPowerPerTier = 99;

        final double min = (constantMin - (throwPower.getValue() % maxPowerPerTier)) * baseMin;
        final double max = (throwPower.getValue() % maxPowerPerTier) * baseMax;
        final double rng = RNG.Generate(min, max);
        double baseThrowPower = 48;

        final double scaleValue = Math.floor(throwPower.getValue() / maxPowerPerTier);

//        Keeping for completeness
        if(scaleValue == 0) baseThrowPower = 48;
        if(scaleValue == 1) baseThrowPower = 56;
        if(scaleValue == 2) baseThrowPower = 64;
        if(scaleValue == 3) baseThrowPower = 72;
        if(scaleValue == 4) baseThrowPower = 80;

        return baseThrowPower + rng;
    }
}
