package Game;

@Deprecated
public enum PlayerState {

    UP,
    DOWN,
    BLOCKED,
    TACKLED,
    CATCHING,
    COLLIDING;

    public final boolean isUp(){ return UP.equals(this); }

    public final boolean isDown(){ return DOWN.equals(this); }

    public final boolean isBlocked(){ return BLOCKED.equals(this); }

    public final boolean isTackled(){ return TACKLED.equals(this); }

    public final boolean isCatching(){ return CATCHING.equals(this); }

    public final boolean isColliding(){ return COLLIDING.equals(this); }

}
