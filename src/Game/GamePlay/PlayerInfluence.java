package Game.GamePlay;

import PhysicsEngine.PhysicsObjects.Vector;

public final class PlayerInfluence {

    private final Vector influence;
    private final double readableInfluence;
    private final String influencingObjectName;

    /**
     * Remember that a positive direction will be a pull, while a negative direction will be a push
     */
    public PlayerInfluence(final Vector influence, final double readableInfluence, final String objectName){
        this.influence = influence;
        this.readableInfluence = Math.abs(readableInfluence);
        this.influencingObjectName = objectName;
    }

    public final String getInfluencingName(){
        return influencingObjectName;
    }

    public final Vector getInfluence(){
        return influence;
    }

    public final double getReadableInfluence(){
        return readableInfluence;
    }

    @Override
    public String toString() {
        return "Influencing Object "+influencingObjectName+" | Percent Influence "+readableInfluence+" | influence value " +influence;
    }
}
