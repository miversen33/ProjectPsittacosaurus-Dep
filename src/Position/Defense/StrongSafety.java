package Position.Defense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.CORNERBACK;

public final class StrongSafety extends Position {

    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String HARDHITTER_SUBPOSITION_NAME= "Hard Hitter";
    public final static String COVERAGE_SUBPOSITION_NAME = "Coverage";

    private final static int NEUTRAL_SPEED_VAR = 1;
    private final static int NEUTRAL_CATCHING_VAR = 1;
    private final static int NEUTRAL_AWARENESS_VAR = 2;
    private final static int NEUTRAL_ZONE_VAR = 3;
    private final static int NEUTRAL_MAN_VAR = 3;
    private final static int NEUTRAL_TACKLE_VAR = 2;

    private final static int HARDHITTER_AWARENESS_VAR = 4;
    private final static int HARDHITTER_TACKLE_VAR = 4;
    private final static int HARDHITTER_STRENGTH_VAR = 5;
    private final static int HARDHITTER_ZONE_VAR = 1;
    private final static int HARDHITTER_MAN_VAR = 1;

    private final static int COVERAGE_SPEED_VAR = 2;
    private final static int COVERAGE_CATCHING_VAR = 2;
    private final static int COVERAGE_AWARENESS_VAR = 4;
    private final static int COVERAGE_TACKLE_VAR = 4;
    private final static int COVERAGE_ZONE_VAR = 3;
    private final static int COVERAGE_MAN_VAR = 2;

    private StrongSafety(final String subPositionName) {
        super(CORNERBACK.getName(), subPositionName);
    }

    public final static StrongSafety GenerateCoverageStrongSafety(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), COVERAGE_CATCHING_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                speedAdjust,
                awarenessAdjust,
                tackleAdjust,
                zoneAdjust,
                manAdjust,
                catchingAdjust
        );

        final StrongSafety strongSafety = new StrongSafety(COVERAGE_SUBPOSITION_NAME);
        strongSafety.updateAttributes(mods);

        return strongSafety;
    }

    public final static StrongSafety GenerateHardHitterStrongSafety(){
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), HARDHITTER_AWARENESS_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), HARDHITTER_TACKLE_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), HARDHITTER_ZONE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), HARDHITTER_MAN_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), HARDHITTER_STRENGTH_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                awarenessAdjust,
                tackleAdjust,
                zoneAdjust,
                manAdjust,
                strengthAdjust
        );

        final StrongSafety strongSafety = new StrongSafety(HARDHITTER_SUBPOSITION_NAME);
        strongSafety.updateAttributes(mods);

        return strongSafety;
    }

    public final static StrongSafety GenerateNeutralStrongSafety(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                speedAdjust,
                awarenessAdjust,
                zoneAdjust,
                manAdjust,
                catchingAdjust,
                tackleAdjust
        );

        final StrongSafety strongSafety = new StrongSafety(NEUTRAL_SUBPOSITION_NAME);
        strongSafety.updateAttributes(mods);

        return strongSafety;
    }
}
