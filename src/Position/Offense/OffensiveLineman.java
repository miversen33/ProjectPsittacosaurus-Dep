package Position.Offense;

import Position.Position;

public class OffensiveLineman extends Position {

    private final static double BASE_RATING = 1.13;

    OffensiveLineman(final String positionName, final String subPositionName) {
        super(positionName, subPositionName, BASE_RATING);
    }

}
