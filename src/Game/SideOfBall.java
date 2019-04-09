package Game;

public enum SideOfBall {
    OFFENSE, DEFENSE;

    public final boolean isOffense(){
        return this.equals(OFFENSE);
    }

    public final boolean isDefense(){
        return this.equals(DEFENSE);
    }
}
