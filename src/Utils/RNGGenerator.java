package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class RNGGenerator {

    public final static double Generate(final double minimumRange, final double maximumRange){
//        Consider creating a way to seed this, so we can allow for semi random?
        return ThreadLocalRandom.current().nextDouble(minimumRange, maximumRange);
    }
}
