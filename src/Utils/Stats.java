package Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Stats{

    public final static double Normal(final double mean, final double deviation){
        return new Random().nextGaussian() * deviation + mean;
    }

}
