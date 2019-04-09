package Game.GamePlay.PlayerStrategy;

public enum PlayerInfluences {
    LEFT_SIDELINE("Left SideLine"),
    RIGHT_SIDELINE("Right Sideline"),
    GOAL_ENDZONE("Goal Endzone"),
    OTHER_ENDZONE("Other Endzone"),
    FIRST_DOWN("First Down"),
    TIME_LEFT("Time Left"),
    SCORE("Score"),
    BLOCKERS("Blockers"),
    BALL_IN_AIR("Ball In Air"),
    WEATHER("Weather"),
    IGNORE_INFLUENCES("Ignore Influences");

    private final String name;

    PlayerInfluences(final String string){
        name = string;
    }

    public final String getInfluenceName(){
        return name;
    }
}
