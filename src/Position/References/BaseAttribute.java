package Position.References;

public final class BaseAttribute {
    private final String name;
    private double mean;
    private double deviation;

    public BaseAttribute(final double mean, final double deviation){
        this("", mean, deviation);
    }

    public BaseAttribute(final String name, final double mean, final double deviation){
        this.mean = mean;
        this.deviation = deviation;
        this.name = name;
    }

    @Deprecated
    protected final void updateMean(final double newMean){
        this.mean = newMean;
    }

    @Deprecated
    protected final void updateDeviation(final double newDeviation){
        this.deviation = newDeviation;
    }

    public final String getName(){
        return name;
    }

    public final double getMean(){
        return mean;
    }

    public final double getDeviation(){
        return deviation;
    }
}