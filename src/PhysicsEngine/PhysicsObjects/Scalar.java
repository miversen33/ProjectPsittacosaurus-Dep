package PhysicsEngine.PhysicsObjects;

public final class Scalar implements CommonScalarTypes{
    private final String name;
    private final double value;

    public Scalar(final String name, final double value){
        this.name = name;
        this.value = value;
    }

    public final String getName(){
        return name;
    }

    public final double getValue(){
        return value;
    }

    @Override
    public String toString() {
        return name + " | " + value;

    }
}
