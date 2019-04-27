package Position.Defense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.CORNERBACK;

public final class FreeSafety extends Position {

    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String HARDHITTER_SUBPOSITION_NAME= "Hard Hitter";
    public final static String COVERAGE_SUBPOSITION_NAME = "Coverage";

    private final static double BASE_RATING = .795;

    private final static int COVERAGE_SPEED_VAR = 2;
    private final static int COVERAGE_STRENGTH_VAR = 3;
    private final static int COVERAGE_ACCELERATION_VAR = 2;
    private final static int COVERAGE_MAN_COVERAGE_VAR = 4;
    private final static int COVERAGE_ZONE_COVERAGE_VAR = 4;
    private final static int COVERAGE_STAMINA_VAR = 2;
    private final static int COVERAGE_INJURY_VAR = 5;
    private final static double COVERAGE_SPEED_IMPORTANCE = .995;
    private final static double COVERAGE_ACCELERATION_IMPORTANCE = .995;
    private final static double COVERAGE_AGILITY_IMPORTANCE = .90;
    private final static double COVERAGE_BREAK_BLOCK_IMPORTANCE = .30;
    private final static double COVERAGE_CARRYING_IMPORTANCE = .625;
    private final static double COVERAGE_CATCHING_IMPORTANCE = .675;
    private final static double COVERAGE_TACKLE_IMPORTANCE = .55;
    private final static double COVERAGE_STRENGTH_IMPORTANCE = .45;
    private final static double COVERAGE_AWARENESS_IMPORTANCE = .80;
    private final static double COVERAGE_MAN_COVERAGE_IMPORTANCE = .725;
    private final static double COVERAGE_ZONE_COVERAGE_IMPORTANCE = .725;

    private final static int HARDHITTER_SPEED_VAR = -2;
    private final static int HARDHITTER_STRENGTH_VAR = 3;
    private final static int HARDHITTER_ACCELERATION_VAR = -2;
    private final static int HARDHITTER_MAN_COVERAGE_VAR = 2;
    private final static int HARDHITTER_ZONE_COVERAGE_VAR = 5;
    private final static int HARDHITTER_STAMINA_VAR = 2;
    private final static int HARDHITTER_INJURY_VAR = 5;
    private final static double HARDHITTER_SPEED_IMPORTANCE = .925;
    private final static double HARDHITTER_AGILITY_IMPORTANCE = .825;
    private final static double HARDHITTER_STRENGTH_IMPORTANCE = .75;
    private final static double HARDHITTER_BREAK_BLOCK_IMPORTANCE = .60;
    private final static double HARDHITTER_CARRYING_IMPORTANCE = .575;
    private final static double HARDHITTER_CATCHING_IMPORTANCE = .575;
    private final static double HARDHITTER_TACKLE_IMPORTANCE = .725;
    private final static double HARDHITTER_ACCELERATION_IMPORTANCE = .925;
    private final static double HARDHITTER_AWARENESS_IMPORTANCE = .60;
    private final static double HARDHITTER_MAN_COVERAGE_IMPORTANCE = .65;
    private final static double HARDHITTER_ZONE_COVERAGE_IMPORTANCE = .65;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_MAN_COVERAGE_VAR = 1;
    private final static int NEUTRAL_ZONE_COVERAGE_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .975;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .85;
    private final static double NEUTRAL_BREAK_BLOCK_IMPORTANCE = .50;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .60;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .65;
    private final static double NEUTRAL_TACKLE_IMPORTANCE = .625;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .65;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .975;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .65;
    private final static double NEUTRAL_MAN_COVERAGE_IMPORTANCE = .69;
    private final static double NEUTRAL_ZONE_COVERAGE_IMPORTANCE = .70;

    private FreeSafety(final String subPositionName) {
        super(CORNERBACK.getName(), subPositionName, BASE_RATING);
    }

    public final static FreeSafety GenerateCoverageFreeSafety(final int ovrSeed){

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

        final FreeSafety freeSafety = new FreeSafety(COVERAGE_SUBPOSITION_NAME);
        freeSafety.updateAttributes(attrs);
        freeSafety.updateModifiers(mods);
        freeSafety.seedRating(ovrSeed);
        return freeSafety;
    }

    public final static FreeSafety GenerateHardhitterFreeSafety(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), HARDHITTER_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), HARDHITTER_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), HARDHITTER_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), HARDHITTER_STRENGTH_VAR);
        final Attribute<Integer> zoneCoverageAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), HARDHITTER_ZONE_COVERAGE_VAR);
        final Attribute<Integer> manCoverageAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), HARDHITTER_MAN_COVERAGE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), HARDHITTER_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), HARDHITTER_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), HARDHITTER_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), HARDHITTER_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), HARDHITTER_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), HARDHITTER_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), HARDHITTER_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), HARDHITTER_AGILITY_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), HARDHITTER_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), HARDHITTER_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), HARDHITTER_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), HARDHITTER_BREAK_BLOCK_IMPORTANCE);

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

        final FreeSafety freeSafety = new FreeSafety(HARDHITTER_SUBPOSITION_NAME);
        freeSafety.updateAttributes(attrs);
        freeSafety.updateModifiers(mods);
        freeSafety.seedRating(ovrSeed);

        return freeSafety;
    }

    public final static FreeSafety GenerateNeutralFreeSafety(final int ovrSeed){
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

        final FreeSafety freeSafety = new FreeSafety(NEUTRAL_SUBPOSITION_NAME);
        freeSafety.updateAttributes(attrs);
        freeSafety.updateModifiers(mods);
        freeSafety.seedRating(ovrSeed);
        return freeSafety;
    }
}
