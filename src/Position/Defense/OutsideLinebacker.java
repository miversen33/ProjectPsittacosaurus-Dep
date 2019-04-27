package Position.Defense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.OUTSIDE_LINEBACKER;

public final class OutsideLinebacker extends Position {

    public final static String BLITZ_SUBPOSITION_NAME = "Blitz";
    public final static String COVERAGE_SUBPOSITION_NAME = "Coverage";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double BASE_RATING = .85;

    private final static int COVERAGE_SPEED_VAR = 2;
    private final static int COVERAGE_STRENGTH_VAR = 3;
    private final static int COVERAGE_ACCELERATION_VAR = 2;
    private final static int COVERAGE_TACKLE_VAR = 4;
    private final static int COVERAGE_STAMINA_VAR = 2;
    private final static int COVERAGE_INJURY_VAR = 5;
    private final static double COVERAGE_SPEED_IMPORTANCE = .70;
    private final static double COVERAGE_STRENGTH_IMPORTANCE = .70;
    private final static double COVERAGE_AGILITY_IMPORTANCE = .70;
    private final static double COVERAGE_ACCELERATION_IMPORTANCE = .785;
    private final static double COVERAGE_AWARENESS_IMPORTANCE = .725;
    private final static double COVERAGE_BREAK_BLOCK_IMPORTANCE = .60;
    private final static double COVERAGE_CARRYING_IMPORTANCE = .50;
    private final static double COVERAGE_CATCHING_IMPORTANCE = .57;
    private final static double COVERAGE_TACKLE_IMPORTANCE = .895;
    private final static double COVERAGE_MAN_COVERAGE_IMPORTANCE = .60;
    private final static double COVERAGE_ZONE_COVERAGE_IMPORTANCE = .70;

    private final static int BLITZ_SPEED_VAR = -2;
    private final static int BLITZ_STRENGTH_VAR = 3;
    private final static int BLITZ_ACCELERATION_VAR = -2;
    private final static int BLITZ_TACKLE_VAR = 5;
    private final static int BLITZ_STAMINA_VAR = 2;
    private final static int BLITZ_INJURY_VAR = 5;
    private final static double BLITZ_SPEED_IMPORTANCE = .675;
    private final static double BLITZ_STRENGTH_IMPORTANCE = .925;
    private final static double BLITZ_AGILITY_IMPORTANCE = .65;
    private final static double BLITZ_ACCELERATION_IMPORTANCE = .80;
    private final static double BLITZ_AWARENESS_IMPORTANCE = .675;
    private final static double BLITZ_BREAK_BLOCK_IMPORTANCE = .825;
    private final static double BLITZ_CARRYING_IMPORTANCE = .50;
    private final static double BLITZ_CATCHING_IMPORTANCE = .475;
    private final static double BLITZ_TACKLE_IMPORTANCE = .95;
    private final static double BLITZ_MAN_COVERAGE_IMPORTANCE = .575;
    private final static double BLITZ_ZONE_COVERAGE_IMPORTANCE = .575;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_TACKLE_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .70;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .80;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .70;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .725;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .72;
    private final static double NEUTRAL_BREAK_BLOCK_IMPORTANCE = .70;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .525;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .525;
    private final static double NEUTRAL_TACKLE_IMPORTANCE = .80;
    private final static double NEUTRAL_MAN_COVERAGE_IMPORTANCE = .575;
    private final static double NEUTRAL_ZONE_COVERAGE_IMPORTANCE = .60;

    private OutsideLinebacker(final String subPositionName) {
        super(OUTSIDE_LINEBACKER.getName(), subPositionName, BASE_RATING);
    }

    public final static OutsideLinebacker GenerateCoverageOutsideLinebacker(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), COVERAGE_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), COVERAGE_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), COVERAGE_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), COVERAGE_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), COVERAGE_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), COVERAGE_AGILITY_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), COVERAGE_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), COVERAGE_BREAK_BLOCK_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), COVERAGE_CARRYING_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                tackleAdjust,
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
                catchingImportance,
                tackleImportance,
                breakBlockImportance,
                carryingImportance
        );

        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(COVERAGE_SUBPOSITION_NAME);
        outsideLinebacker.updateAttributes(attrs);
        outsideLinebacker.updateModifiers(mods);
        outsideLinebacker.seedRating(ovrSeed);
        return outsideLinebacker;
    }

    public final static OutsideLinebacker GenerateBlitzOutsideLinebacker(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), BLITZ_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLITZ_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), BLITZ_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BLITZ_STRENGTH_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), BLITZ_TACKLE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), BLITZ_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), BLITZ_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), BLITZ_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), BLITZ_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), BLITZ_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), BLITZ_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), BLITZ_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), BLITZ_AGILITY_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), BLITZ_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), BLITZ_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), BLITZ_BREAK_BLOCK_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), BLITZ_CARRYING_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                tackleAdjust,
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
                catchingImportance,
                tackleImportance,
                breakBlockImportance,
                carryingImportance
        );

        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(BLITZ_SUBPOSITION_NAME);
        outsideLinebacker.updateAttributes(attrs);
        outsideLinebacker.updateModifiers(mods);
        outsideLinebacker.seedRating(ovrSeed);

        return outsideLinebacker;
    }

    public final static OutsideLinebacker GenerateNeutralOutsideLinebacker(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                tackleAdjust,
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
                catchingImportance,
                tackleImportance,
                breakBlockImportance,
                carryingImportance
        );

        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(NEUTRAL_SUBPOSITION_NAME);
        outsideLinebacker.updateAttributes(attrs);
        outsideLinebacker.updateModifiers(mods);
        outsideLinebacker.seedRating(ovrSeed);
        return outsideLinebacker;
    }
}
