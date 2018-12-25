package Game;

public enum PlayerState {

    UP,
    DOWN;

    public final boolean isUp(){
        return UP.equals(this);
    }

    public final boolean isDown(){
        return DOWN.equals(this);
    }
}
