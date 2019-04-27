package Position.SpecialTeams;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.KICKER;

public final class Punter extends Position {
    public final static String POWER_SUBPOSITION_NAME = "Power";
    public final static String ACCURATE_SUBPOSITION_NAME = "Accurate";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double BASE_RATING = 1.125;

    private final static int ACCURATE_SPEED_VAR = 2;
    private final static int ACCURATE_STRENGTH_VAR = 3;
    private final static int ACCURATE_ACCELERATION_VAR = 2;
    private final static int ACCURATE_MAN_COVERAGE_VAR = 4;
    private final static int ACCURATE_ZONE_COVERAGE_VAR = 4;
    private final static int ACCURATE_STAMINA_VAR = 2;
    private final static int ACCURATE_INJURY_VAR = 5;
    private final static double ACCURATE_SPEED_IMPORTANCE = .65;
    private final static double ACCURATE_STRENGTH_IMPORTANCE = .30;
    private final static double ACCURATE_AGILITY_IMPORTANCE = .60;
    private final static double ACCURATE_ACCELERATION_IMPORTANCE = .65;
    private final static double ACCURATE_AWARENESS_IMPORTANCE = .60;
    private final static double ACCURATE_BREAK_BLOCK_IMPORTANCE = .0;
    private final static double ACCURATE_KICK_POWER_IMPORTANCE = .85;
    private final static double ACCURATE_KICK_ACCURACY_IMPORTANCE = .9;

    private final static int POWER_SPEED_VAR = -2;
    private final static int POWER_STRENGTH_VAR = 3;
    private final static int POWER_ACCELERATION_VAR = -2;
    private final static int POWER_MAN_COVERAGE_VAR = 2;
    private final static int POWER_ZONE_COVERAGE_VAR = 5;
    private final static int POWER_STAMINA_VAR = 2;
    private final static int POWER_INJURY_VAR = 5;
    private final static double POWER_SPEED_IMPORTANCE = .65;
    private final static double POWER_STRENGTH_IMPORTANCE = .30;
    private final static double POWER_AGILITY_IMPORTANCE = .60;
    private final static double POWER_ACCELERATION_IMPORTANCE = .65;
    private final static double POWER_AWARENESS_IMPORTANCE = .60;
    private final static double POWER_BREAK_BLOCK_IMPORTANCE = .0;
    private final static double POWER_KICK_POWER_IMPORTANCE = .9;
    private final static double POWER_KICK_ACCURACY_IMPORTANCE = .85;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_MAN_COVERAGE_VAR = 1;
    private final static int NEUTRAL_ZONE_COVERAGE_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .65;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .30;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .60;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .65;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .60;
    private final static double NEUTRAL_BREAK_BLOCK_IMPORTANCE = .0;
    private final static double NEUTRAL_KICK_POWER_IMPORTANCE = .85;
    private final static double NEUTRAL_KICK_ACCURACY_IMPORTANCE = .85;


    private Punter(final String subPositionName) {
        super(KICKER.getName(), subPositionName, BASE_RATING);
    }

    public final static Punter GenerateAccuratePunter(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), ACCURATE_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), ACCURATE_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), ACCURATE_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), ACCURATE_STRENGTH_VAR);
        final Attribute<Integer> zoneCoverageAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), ACCURATE_ZONE_COVERAGE_VAR);
        final Attribute<Integer> manCoverageAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), ACCURATE_MAN_COVERAGE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), ACCURATE_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), ACCURATE_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), ACCURATE_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), ACCURATE_STRENGTH_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), ACCURATE_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), ACCURATE_AGILITY_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), ACCURATE_BREAK_BLOCK_IMPORTANCE);
        final ModifierAttribute kickAccuracyImportance = new ModifierAttribute(StatAttributes.KICK_ACCURACY.getName(), ACCURATE_KICK_ACCURACY_IMPORTANCE);
        final ModifierAttribute kickPowerImportance = new ModifierAttribute(StatAttributes.KICK_POWER.getName(), ACCURATE_KICK_POWER_IMPORTANCE);

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
                awarenessImportance,
                agilityImportance,
                kickAccuracyImportance,
                kickPowerImportance,
                breakBlockImportance
        );

        final Punter punter = new Punter(ACCURATE_SUBPOSITION_NAME);
        punter.updateAttributes(attrs);
        punter.updateModifiers(mods);
        punter.seedRating(ovrSeed);
        return punter;
    }

    public final static Punter GeneratePowerPunter(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), POWER_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), POWER_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), POWER_STRENGTH_VAR);
        final Attribute<Integer> zoneCoverageAdjust = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), POWER_ZONE_COVERAGE_VAR);
        final Attribute<Integer> manCoverageAdjust = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), POWER_MAN_COVERAGE_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), POWER_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), POWER_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), POWER_STRENGTH_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), POWER_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), POWER_AGILITY_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), POWER_BREAK_BLOCK_IMPORTANCE);
        final ModifierAttribute kickAccuracyImportance = new ModifierAttribute(StatAttributes.KICK_ACCURACY.getName(), POWER_KICK_ACCURACY_IMPORTANCE);
        final ModifierAttribute kickPowerImportance = new ModifierAttribute(StatAttributes.KICK_POWER.getName(), POWER_KICK_POWER_IMPORTANCE);

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
                awarenessImportance,
                agilityImportance,
                kickAccuracyImportance,
                kickPowerImportance,
                breakBlockImportance
        );

        final Punter punter = new Punter(POWER_SUBPOSITION_NAME);
        punter.updateAttributes(attrs);
        punter.updateModifiers(mods);
        punter.seedRating(ovrSeed);
        return punter;
    }

    public final static Punter GenerateNeutralPunter(final int ovrSeed){
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
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_IMPORTANCE);
        final ModifierAttribute breakBlockImportance = new ModifierAttribute(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK_IMPORTANCE);
        final ModifierAttribute kickAccuracyImportance = new ModifierAttribute(StatAttributes.KICK_ACCURACY.getName(), NEUTRAL_KICK_ACCURACY_IMPORTANCE);
        final ModifierAttribute kickPowerImportance = new ModifierAttribute(StatAttributes.KICK_POWER.getName(), NEUTRAL_KICK_POWER_IMPORTANCE);

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
                awarenessImportance,
                agilityImportance,
                kickAccuracyImportance,
                kickPowerImportance,
                breakBlockImportance
        );

        final Punter punter = new Punter(NEUTRAL_SUBPOSITION_NAME);
        punter.updateAttributes(attrs);
        punter.updateModifiers(mods);
        punter.seedRating(ovrSeed);
        return punter;
    }
}
