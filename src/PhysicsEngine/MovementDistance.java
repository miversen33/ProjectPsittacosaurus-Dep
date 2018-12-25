package PhysicsEngine;

public enum MovementDistance {

    MIN,
    HALF,
    MAX;

    public final boolean isMinimum(){
        return this.equals(MIN);
    }

    public final boolean isMaximum(){
        return this.equals(MAX);
    }

    public final boolean isHalf(){
        return this.equals(HALF);
    }
}
