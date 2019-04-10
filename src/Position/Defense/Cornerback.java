package Position.Defense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.CORNERBACK;

public final class Cornerback extends Position {

    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String BALLHAWK_SUBPOSITION_NAME= "Ball Hawk";
    public final static String COVERAGE_SUBPOSITION_NAME = "Coverage";

    private final static int NEUTRAL_SPEED_VAR = 1;
    private final static int NEUTRAL_CATCHING_VAR = 2;
    private final static int NEUTRAL_AWARENESS_VAR = 4;
    private final static int NEUTRAL_ZONE_VAR = 4;
    private final static int NEUTRAL_MAN_VAR = 4;

    private final static int BALLHAWK_SPEED_VAR = 3;
    private final static int BALLHAWK_CATCHING_VAR = 5;
    private final static int BALLHAWK_AWARENESS_VAR = 3;
    private final static int BALLHAWK_TACKLE_VAR = -3;
    private final static int BALLHAWK_STRENGTH_VAR = -2;
    private final static int BALLHAWK_ZONE_VAR = 3;
    private final static int BALLHAWK_MAN_VAR = 3;

    private final static int COVERAGE_SPEED_VAR = 2;
    private final static int COVERAGE_AWARENESS_VAR = 4;
    private final static int COVERAGE_TACKLE_VAR = 2;
    private final static int COVERAGE_ZONE_VAR = 5;
    private final static int COVERAGE_MAN_VAR = 5;

    private Cornerback(final String subPositionName) {
        super(CORNERBACK.getName(), subPositionName);
    }

    public final static Cornerback GenerateCoverageCornerback(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                speedAdjust,
                awarenessAdjust,
                tackleAdjust,
                zoneAdjust,
                manAdjust
        );

        final Cornerback cornerback = new Cornerback(COVERAGE_SUBPOSITION_NAME);
        cornerback.updateAttributes(mods);

        return cornerback;
    }

    public final static Cornerback GenerateBallhawkCornerback(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), BALLHAWK_SPEED_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), BALLHAWK_AWARENESS_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), BALLHAWK_TACKLE_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), BALLHAWK_ZONE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), BALLHAWK_MAN_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), BALLHAWK_CATCHING_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BALLHAWK_STRENGTH_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                speedAdjust,
                awarenessAdjust,
                tackleAdjust,
                zoneAdjust,
                manAdjust,
                catchingAdjust,
                strengthAdjust
        );

        final Cornerback cornerback = new Cornerback(BALLHAWK_SUBPOSITION_NAME);
        cornerback.updateAttributes(mods);

        return cornerback;
    }

    public final static Cornerback GenerateNeutralCornerback(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                speedAdjust,
                awarenessAdjust,
                zoneAdjust,
                manAdjust,
                catchingAdjust
        );

        final Cornerback cornerback = new Cornerback(NEUTRAL_SUBPOSITION_NAME);
        cornerback.updateAttributes(mods);

        return cornerback;
    }
}
