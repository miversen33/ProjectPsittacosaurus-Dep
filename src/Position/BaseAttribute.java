package Position;

public final class BaseAttribute {
    private double mean;
    private double deviation;

    public BaseAttribute(final double mean, final double deviation){
        this.mean = mean;
        this.deviation = deviation;
    }

    protected final void updateMean(final double newMean){
        this.mean = newMean;
    }

    protected final void updateDeviation(final double newDeviation){
        this.deviation = newDeviation;
    }

    public final double getMean(){
        return mean;
    }

    public final double getDeviation(){
        return deviation;
    }
}