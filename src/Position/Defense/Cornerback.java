package Position.Defense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.CORNERBACK;

public final class Cornerback extends Position {

    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String BALLHAWK_SUBPOSITION_NAME= "Ball Hawk";
    public final static String COVERAGE_SUBPOSITION_NAME = "Coverage";

    private final static double BASE_RATING = .785;

    private final static int COVERAGE_SPEED_VAR = 2;
    private final static int COVERAGE_STRENGTH_VAR = 3;
    private final static int COVERAGE_ACCELERATION_VAR = 2;
    private final static int COVERAGE_MAN_COVERAGE_VAR = 4;
    private final static int COVERAGE_ZONE_COVERAGE_VAR = 4;
    private final static int COVERAGE_STAMINA_VAR = 2;
    private final static int COVERAGE_INJURY_VAR = 5;
    private final static double COVERAGE_SPEED_IMPORTANCE = .95;
    private final static double COVERAGE_STRENGTH_IMPORTANCE = .65;
    private final static double COVERAGE_AGILITY_IMPORTANCE = .825;
    private final static double COVERAGE_ACCELERATION_IMPORTANCE = .95;
    private final static double COVERAGE_AWARENESS_IMPORTANCE = .65;
    private final static double COVERAGE_BREAK_BLOCK_IMPORTANCE = .55;
    private final static double COVERAGE_CARRYING_IMPORTANCE = .30;
    private final static double COVERAGE_CATCHING_IMPORTANCE = .6;
    private final static double COVERAGE_TACKLE_IMPORTANCE = .70;
    private final static double COVERAGE_MAN_COVERAGE_IMPORTANCE = .90;
    private final static double COVERAGE_ZONE_COVERAGE_IMPORTANCE = .90;

    private final static int BALLHAWK_SPEED_VAR = -2;
    private final static int BALLHAWK_STRENGTH_VAR = 3;
    private final static int BALLHAWK_ACCELERATION_VAR = -2;
    private final static int BALLHAWK_MAN_COVERAGE_VAR = 2;
    private final static int BALLHAWK_ZONE_COVERAGE_VAR = 5;
    private final static int BALLHAWK_STAMINA_VAR = 2;
    private final static int BALLHAWK_INJURY_VAR = 5;
    private final static double BALLHAWK_SPEED_IMPORTANCE = .95;
    private final static double BALLHAWK_STRENGTH_IMPORTANCE = .8;
    private final static double BALLHAWK_AGILITY_IMPORTANCE = .85;
    private final static double BALLHAWK_ACCELERATION_IMPORTANCE = .95;
    private final static double BALLHAWK_AWARENESS_IMPORTANCE = .65;
    private final static double BALLHAWK_BREAK_BLOCK_IMPORTANCE = .4;
    private final static double BALLHAWK_CARRYING_IMPORTANCE = .45;
    private final static double BALLHAWK_CATCHING_IMPORTANCE = .75;
    private final static double BALLHAWK_TACKLE_IMPORTANCE = .60;
    private final static double BALLHAWK_MAN_COVERAGE_IMPORTANCE = .70;
    private final static double BALLHAWK_ZONE_COVERAGE_IMPORTANCE = .70;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_MAN_COVERAGE_VAR = 1;
    private final static int NEUTRAL_ZONE_COVERAGE_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .925;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .65;
    private final static double NEUTRAL_BREAK_BLOCK_IMPORTANCE = .65;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .65;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .65;
    private final static double NEUTRAL_TACKLE_IMPORTANCE = .75;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .65;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .925;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .65;
    private final static double NEUTRAL_MAN_COVERAGE_IMPORTANCE = .70;
    private final static double NEUTRAL_ZONE_COVERAGE_IMPORTANCE = .70;

    private Cornerback(final String subPositionName) {
        super(CORNERBACK.getName(), subPositionName, BASE_RATING);
    }

    public final static Cornerback GenerateCoverageCornerback(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), COVERAGE_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), COVERAGE_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH_VAR);
        final Attribute<Integer> zoneCoverageAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_COVERAGE_VAR);
        final Attribute<Integer> manCoverageAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_COVERAGE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), COVERAGE_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), COVERAGE_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), COVERAGE_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), COVERAGE_AGILITY_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), COVERAGE_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), COVERAGE_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), COVERAGE_BREAK_BLOCK_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                zoneCoverageAdjust,
                manCoverageAdjust,
                injuryAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                speedImportance,
                accelerationImportance,
                strengthImportance,
                zoneCoverageImportance,
                manCoverageImportance,
                awarenessImportance,
                agilityImportance,
                carryingImportance,
                catchingImportance,
                tackleImportance,
                breakBlockImportance
        );

        final Cornerback cornerback = new Cornerback(COVERAGE_SUBPOSITION_NAME);
        cornerback.updateAttributes(attrs);
        cornerback.updateModifiers(mods);
        cornerback.seedRating(ovrSeed);
        return cornerback;
    }

    public final static Cornerback GenerateBallhawkCornerback(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), BALLHAWK_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), BALLHAWK_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), BALLHAWK_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BALLHAWK_STRENGTH_VAR);
        final Attribute<Integer> zoneCoverageAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), BALLHAWK_ZONE_COVERAGE_VAR);
        final Attribute<Integer> manCoverageAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), BALLHAWK_MAN_COVERAGE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), BALLHAWK_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), BALLHAWK_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), BALLHAWK_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), BALLHAWK_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), BALLHAWK_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), BALLHAWK_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), BALLHAWK_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), BALLHAWK_AGILITY_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), BALLHAWK_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), BALLHAWK_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), BALLHAWK_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), BALLHAWK_BREAK_BLOCK_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                zoneCoverageAdjust,
                manCoverageAdjust,
                injuryAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                speedImportance,
                accelerationImportance,
                strengthImportance,
                zoneCoverageImportance,
                manCoverageImportance,
                awarenessImportance,
                agilityImportance,
                carryingImportance,
                catchingImportance,
                tackleImportance,
                breakBlockImportance
        );

        final Cornerback cornerback = new Cornerback(BALLHAWK_SUBPOSITION_NAME);
        cornerback.updateAttributes(attrs);
        cornerback.updateModifiers(mods);
        cornerback.seedRating(ovrSeed);

        return cornerback;
    }

    public final static Cornerback GenerateNeutralCornerback(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> zoneCoverageAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_COVERAGE_VAR);
        final Attribute<Integer> manCoverageAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_COVERAGE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                zoneCoverageAdjust,
                manCoverageAdjust,
                injuryAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                speedImportance,
                accelerationImportance,
                strengthImportance,
                zoneCoverageImportance,
                manCoverageImportance,
                awarenessImportance,
                agilityImportance,
                carryingImportance,
                catchingImportance,
                tackleImportance,
                breakBlockImportance
        );

        final Cornerback cornerback = new Cornerback(NEUTRAL_SUBPOSITION_NAME);
        cornerback.updateAttributes(attrs);
        cornerback.updateModifiers(mods);
        cornerback.seedRating(ovrSeed);
        return cornerback;
    }
}
