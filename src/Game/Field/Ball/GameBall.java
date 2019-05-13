package Game.Field.Ball;

import Game.Field.FieldObject;
import Utils.Signature;

public final class GameBall extends FieldObject {
    private final static double MASS = 0;

    public GameBall(final Signature signature) {
        super(MASS, signature);
    }
}
