package PhysicsEngine.PhysicsObjects;

public class PhysicsObject {

    private final double mass;
    private Vector movement = new Vector(0,0);
    private double acceleration = 0;
//    Eventually we want this to be based on the currentMovement Vector, and the
//    difference between that and the new proposed vector. For now we will simply say 3
//    TODO
    private double maxMovement = 3;

    /**
     * This should actually take a reference to an attribute polling object provided by
     * the player. For now this will work though
     */
    public PhysicsObject(final double mass) {
        this.mass = mass;
    }

    public final void setCurrentMovement(final Vector currentMovement){
        this.movement = currentMovement;
    }

    public final void setAcceleration(final double acceleration){
        this.acceleration = acceleration;
    }

    public final double getMass(){
        return this.mass;
    }

    public final double getAcceleration(){
        return this.acceleration;
    }

    public final Vector getCurrentMovement(){
        return this.movement;
    }

    public final double getForce(){
        return acceleration * mass;
    }

    public final double getMaxMovement(){
        return maxMovement;
    }

}
