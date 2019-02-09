package Game.GamePlay;

public final class PlayerInfluences {

    private final double influence;
    private final double readableInfluence;
    private final String influencingObjectName;

    public PlayerInfluences(final double influence, final double readableInfluence, final String objectName){
        this.influence = influence;
        this.readableInfluence = readableInfluence;
        this.influencingObjectName = objectName;
    }

    public final String getInfluencingName(){
        return influencingObjectName;
    }

    public final double getInfluence(){
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
