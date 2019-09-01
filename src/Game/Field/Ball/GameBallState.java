package Game.Field.Ball;

import StateMachines.State;

public final class GameBallState extends State {

    public final static String IN_POSSESSION = "In Possession";
    public final static String OUT_POSSESSION = "Out of Possession";

    public final static GameBallState InPossession = new GameBallState(IN_POSSESSION);
    public final static GameBallState OutPossession = new GameBallState(OUT_POSSESSION);

    private GameBallState(final String newState) {
        super(newState);
    }

    public final boolean isInPossession(){
        return equals(InPossession);
    }

    public final boolean isOutOfPossession(){
        return equals(OutPossession);
    }
}

