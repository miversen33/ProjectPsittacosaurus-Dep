package Position.Defense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.DEFENSIVE_TACKLE;

public final class DefensiveTackle extends Position {

    public final static String RUN_SUBPOSITION_NAME = "Run Rusher";
    public final static String PASS_SUBPOSITION_NAME = "Pass Rusher";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double BASE_RATING = 1.01;

    private final static int PASS_SPEED_VAR = 2;
    private final static int PASS_STRENGTH_VAR = 3;
    private final static int PASS_ACCELERATION_VAR = 2;
    private final static int PASS_TACKLE_VAR = 4;
    private final static int PASS_STAMINA_VAR = 2;
    private final static int PASS_INJURY_VAR = 5;
    private final static double PASS_SPEED_IMPORTANCE = .60;
    private final static double PASS_STRENGTH_IMPORTANCE = .95;
    private final static double PASS_AGILITY_IMPORTANCE = .55;
    private final static double PASS_ACCELERATION_IMPORTANCE = .60;
    private final static double PASS_AWARENESS_IMPORTANCE = .80;
    private final static double PASS_BREAK_BLOCK_IMPORTANCE = .95;
    private final static double PASS_CATCHING_IMPORTANCE = .15;
    private final static double PASS_TACKLE_IMPORTANCE = .90;
    private final static double PASS_MAN_COVERAGE_IMPORTANCE = .10;
    private final static double PASS_ZONE_COVERAGE_IMPORTANCE = .10;

    private final static int RUN_SPEED_VAR = -2;
    private final static int RUN_STRENGTH_VAR = 3;
    private final static int RUN_ACCELERATION_VAR = -2;
    private final static int RUN_TACKLE_VAR = 5;
    private final static int RUN_STAMINA_VAR = 2;
    private final static int RUN_INJURY_VAR = 5;
    private final static double RUN_SPEED_IMPORTANCE = .70;
    private final static double RUN_STRENGTH_IMPORTANCE = .90;
    private final static double RUN_AGILITY_IMPORTANCE = .65;
    private final static double RUN_ACCELERATION_IMPORTANCE = .65;
    private final static double RUN_AWARENESS_IMPORTANCE = .65;
    private final static double RUN_BREAK_BLOCK_IMPORTANCE = .95;
    private final static double RUN_CATCHING_IMPORTANCE = .15;
    private final static double RUN_TACKLE_IMPORTANCE = .90;
    private final static double RUN_MAN_COVERAGE_IMPORTANCE = .10;
    private final static double RUN_ZONE_COVERAGE_IMPORTANCE = .10;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_TACKLE_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .65;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .60;
    private final static double NEUTRAL_BREAK_BLOCK_IMPORTANCE = .95;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .15;
    private final static double NEUTRAL_TACKLE_IMPORTANCE = .80;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .90;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .70;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .70;
    private final static double NEUTRAL_MAN_COVERAGE_IMPORTANCE = .20;
    private final static double NEUTRAL_ZONE_COVERAGE_IMPORTANCE = .20;

    private DefensiveTackle(final String subPositionName) {
        super(DEFENSIVE_TACKLE.getName(), subPositionName, BASE_RATING);
    }

    public final static DefensiveTackle GeneratePassDefensiveTackle(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), PASS_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASS_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), PASS_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), PASS_STRENGTH_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), PASS_TACKLE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), PASS_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), PASS_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), PASS_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), PASS_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), PASS_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), PASS_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), PASS_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), PASS_AGILITY_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), PASS_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), PASS_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), PASS_BREAK_BLOCK_IMPORTANCE);

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
                breakBlockImportance
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(PASS_SUBPOSITION_NAME);
        defensiveTackle.updateAttributes(attrs);
        defensiveTackle.updateModifiers(mods);
        defensiveTackle.seedRating(ovrSeed);
        return defensiveTackle;
    }

    public final static DefensiveTackle GenerateRunDefensiveTackle(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUN_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUN_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUN_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RUN_STRENGTH_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), RUN_TACKLE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RUN_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), RUN_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), RUN_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), RUN_STRENGTH_IMPORTANCE);
        final ModifierAttribute zoneCoverageImportance = new ModifierAttribute(StatAttributes.ZONE_COVERAGE.getName(), RUN_ZONE_COVERAGE_IMPORTANCE);
        final ModifierAttribute manCoverageImportance = new ModifierAttribute(StatAttributes.MAN_COVERAGE.getName(), RUN_MAN_COVERAGE_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), RUN_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), RUN_AGILITY_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), RUN_CATCHING_IMPORTANCE);
        final ModifierAttribute tackleImportance = new ModifierAttribute(StatAttributes.TACKLE.getName(), RUN_TACKLE_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), RUN_BREAK_BLOCK_IMPORTANCE);

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
                breakBlockImportance
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(RUN_SUBPOSITION_NAME);
        defensiveTackle.updateAttributes(attrs);
        defensiveTackle.updateModifiers(mods);
        defensiveTackle.seedRating(ovrSeed);

        return defensiveTackle;
    }

    public final static DefensiveTackle GenerateNeutralDefensiveTackle(final int ovrSeed){
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
                breakBlockImportance
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(NEUTRAL_SUBPOSITION_NAME);
        defensiveTackle.updateAttributes(attrs);
        defensiveTackle.updateModifiers(mods);
        defensiveTackle.seedRating(ovrSeed);
        return defensiveTackle;
    }
}
