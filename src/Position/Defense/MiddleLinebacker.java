package Position.Defense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.MIDDLE_LINEBACKER;

public final class MiddleLinebacker extends Position {

    public final static String BLITZING_SUBPOSITITON_NAME = "Blitz";
    public final static String COVERAGE_SUBPOSITITON_NAME = "Coverage";
    public final static String NEUTRAL_SUBPOSITITON_NAME = "Neutral";

    private final static int BLITZ_AGILITY_VAR = 3;
    private final static int BLITZ_AWARENESS_VAR = 6;
    private final static int BLITZ_SPEED_VAR = 4;
    private final static int BLITZ_STRENGTH_VAR = 4;
    private final static int BLITZ_TACKLE_VAR = 5;
    private final static int BLITZ_BREAK_VAR = 4;

    private final static int COVERAGE_SPEED_VAR = 2;
    private final static int COVERAGE_AWARENESS_VAR = 6;
    private final static int COVERAGE_STRENGTH_VAR = 2;
    private final static int COVERAGE_TACKLE_VAR = 3;
    private final static int COVERAGE_MAN_VAR = 3;
    private final static int COVERAGE_ZONE_VAR = 5;
    private final static int COVERAGE_BREAK_VAR = 2;

    private final static int NEUTRAL_SPEED_VAR = 2;
    private final static int NEUTRAL_AWARENESS_VAR = 3;
    private final static int NEUTRAL_STRENGTH_VAR = 5;
    private final static int NEUTRAL_TACKLE_VAR = 5;
    private final static int NEUTRAL_BREAK_VAR = 1;
    private final static int NEUTRAL_MAN_VAR = 1;
    private final static int NEUTRAL_ZONE_VAR = 2;
    private final static int NEUTRAL_AGILITY_VAR = 1;

    private MiddleLinebacker(final String subPositionName) {
        super(MIDDLE_LINEBACKER.getName(), subPositionName);
    }

    public final static MiddleLinebacker GenerateCoverageMiddleLinebacker(){

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED_VAR);
        final Attribute<Integer> breakBlockAdjust = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), COVERAGE_BREAK_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                speedAdjust,
                breakBlockAdjust,
                tackleAdjust,
                manAdjust,
                zoneAdjust,
                awarenessAdjust
        );

        final MiddleLinebacker middleLinebacker = new MiddleLinebacker(COVERAGE_SUBPOSITITON_NAME);
        middleLinebacker.updateAttributes(attrs);

        return middleLinebacker;
    }

    public final static MiddleLinebacker GenerateBlitzMiddleLinebacker(){

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BLITZ_STRENGTH_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), BLITZ_AGILITY_VAR);
        final Attribute<Integer> breakBlockAdjust = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), BLITZ_BREAK_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), BLITZ_TACKLE_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), BLITZ_AWARENESS_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), BLITZ_SPEED_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                agilityAdjust,
                breakBlockAdjust,
                tackleAdjust,
                awarenessAdjust,
                speedAdjust
        );

        final MiddleLinebacker middleLinebacker = new MiddleLinebacker(BLITZING_SUBPOSITITON_NAME);
        middleLinebacker.updateAttributes(attrs);

        return middleLinebacker;
    }

    public final static MiddleLinebacker GenerateNeutralMiddleLinebacker(){

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_VAR);
        final Attribute<Integer> breakBlockAdjust = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_VAR);
        final Attribute<Integer> manAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_VAR);
        final Attribute<Integer> zoneAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                speedAdjust,
                breakBlockAdjust,
                tackleAdjust,
                agilityAdjust,
                manAdjust,
                zoneAdjust,
                awarenessAdjust
        );

        final MiddleLinebacker middleLinebacker = new MiddleLinebacker(NEUTRAL_SUBPOSITITON_NAME);
        middleLinebacker.updateAttributes(attrs);

        return middleLinebacker;
    }
}
