package Position.Offense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.QUARTERBACK;

public final class Quarterback extends Position {

    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String PASSING_SUBPOSITION_NAME = "Passing";
    public final static String RUNNING_SUBPOSITION_NAME = "Running";

    private final static double BASE_RATING = .935;

    private final static int NEUTRAL_SPEED_VAR = 2;
    private final static int NEUTRAL_STRENGTH_VAR = 2;
    private final static int NEUTRAL_AGILITY_VAR = 2;
    private final static int NEUTRAL_ACCELERATION_VAR = 2;
    private final static int NEUTRAL_AWARENESS_VAR = 2;
    private final static int NEUTRAL_BREAK_TACKLE_VAR = 2;
    private final static int NEUTRAL_ELUSIVENESS_VAR = 2;
    private final static int NEUTRAL_CARRYING_VAR = 2;
    private final static int NEUTRAL_THROW_POWER_VAR = 2;
    private final static int NEUTRAL_THROW_ACCURACY_VAR = 2;
    private final static int NEUTRAL_STAMINA_VAR = 5;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .65;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .59;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .60;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .70;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .675;
    private final static double NEUTRAL_BREAK_TACKLE_IMPORTANCE = .60;
    private final static double NEUTRAL_ELUSIVENESS_IMPORTANCE = .575;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .575;
    private final static double NEUTRAL_THROW_POWER_IMPORTANCE = .90;
    private final static double NEUTRAL_THROW_ACCURACY_IMPORTANCE = .725;

    private final static int PASSING_SPEED_VAR = -1;
    private final static int PASSING_STRENGTH_VAR = 5;
    private final static int PASSING_AGILITY_VAR = -1;
    private final static int PASSING_ACCELERATION_VAR = -1;
    private final static int PASSING_AWARENESS_VAR = 5;
    private final static int PASSING_BREAK_TACKLE_VAR = 2;
    private final static int PASSING_ELUSIVENESS_VAR = -3;
    private final static int PASSING_CARRYING_VAR = -2;
    private final static int PASSING_THROW_POWER_VAR = 5;
    private final static int PASSING_THROW_ACCURACY_VAR = 7;
    private final static int PASSING_STAMINA_VAR = 5;
    private final static double PASSING_SPEED_IMPORTANCE = .625;
    private final static double PASSING_STRENGTH_IMPORTANCE = .675;
    private final static double PASSING_AGILITY_IMPORTANCE = .60;
    private final static double PASSING_ACCELERATION_IMPORTANCE = .70;
    private final static double PASSING_AWARENESS_IMPORTANCE = .775;
    private final static double PASSING_BREAK_TACKLE_IMPORTANCE = .55;
    private final static double PASSING_ELUSIVENESS_IMPORTANCE = .50;
    private final static double PASSING_CARRYING_IMPORTANCE = .50;
    private final static double PASSING_THROW_POWER_IMPORTANCE = .95;
    private final static double PASSING_THROW_ACCURACY_IMPORTANCE = .80;

    private final static int RUNNING_SPEED_VAR = 1;
    private final static int RUNNING_STRENGTH_VAR = 2;
    private final static int RUNNING_AGILITY_VAR = 1;
    private final static int RUNNING_ACCELERATION_VAR = 1;
    private final static int RUNNING_AWARENESS_VAR = 3;
    private final static int RUNNING_BREAK_TACKLE_VAR = 1;
    private final static int RUNNING_ELUSIVENESS_VAR = 1;
    private final static int RUNNING_CARRYING_VAR = 1;
    private final static int RUNNING_THROW_POWER_VAR = 3;
    private final static int RUNNING_THROW_ACCURACY_VAR = 2;
    private final static int RUNNING_STAMINA_VAR = 5;
    private final static double RUNNING_SPEED_IMPORTANCE = .75;
    private final static double RUNNING_STRENGTH_IMPORTANCE = .60;
    private final static double RUNNING_AGILITY_IMPORTANCE = .65;
    private final static double RUNNING_ACCELERATION_IMPORTANCE = .775;
    private final static double RUNNING_AWARENESS_IMPORTANCE = .60;
    private final static double RUNNING_BREAK_TACKLE_IMPORTANCE = .675;
    private final static double RUNNING_ELUSIVENESS_IMPORTANCE = .675;
    private final static double RUNNING_CARRYING_IMPORTANCE = .575;
    private final static double RUNNING_THROW_POWER_IMPORTANCE = .85;
    private final static double RUNNING_THROW_ACCURACY_IMPORTANCE = .675;

    private Quarterback(final String subPositionName) {
        super(QUARTERBACK.getName(), subPositionName, BASE_RATING);
    }

    public final static Quarterback GenerateNeutralQuarterback(final double overallSeed){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), NEUTRAL_THROW_ACCURACY_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> carryAdjust = new Attribute<>(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE_VAR);
        final Attribute<Integer> elusivenessAdjust = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS_VAR);

        final ModifierAttribute throwPowerImportant = new ModifierAttribute(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER_IMPORTANCE);
        final ModifierAttribute throwAccuracyImportant = new ModifierAttribute(StatAttributes.THROW_ACCURACY.getName(), NEUTRAL_THROW_ACCURACY_IMPORTANCE);
        final ModifierAttribute awarenessImportant = new ModifierAttribute(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_IMPORTANCE);
        final ModifierAttribute strengthImportant = new ModifierAttribute(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_IMPORTANCE);
        final ModifierAttribute speedImportant = new ModifierAttribute(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportant = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_IMPORTANCE);
        final ModifierAttribute agilityImportant = new ModifierAttribute(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_IMPORTANCE);
        final ModifierAttribute carryingImportant = new ModifierAttribute(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING_IMPORTANCE);
        final ModifierAttribute breakTackleImportant = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute elusivenessImportant = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                awarenessAdjust,
                speedAdjust,
                carryAdjust,
                staminaAdjust,
                strengthAdjust,
                agilityAdjust,
                accelerationAdjust,
                breakTackleAdjust,
                elusivenessAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                throwPowerImportant,
                throwAccuracyImportant,
                awarenessImportant,
                strengthImportant,
                speedImportant,
                accelerationImportant,
                carryingImportant,
                agilityImportant,
                breakTackleImportant,
                elusivenessImportant
        );

        final Quarterback quarterback = new Quarterback(NEUTRAL_SUBPOSITION_NAME);
        quarterback.updateAttributes(attrs);
        quarterback.updateModifiers(mods);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

    public final static Quarterback GeneratePassingQuarterback(final double overallSeed){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSING_THROW_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSING_THROW_ACCURACY_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSING_AWARENESS_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), PASSING_SPEED_VAR);
        final Attribute<Integer> carryAdjust = new Attribute<>(StatAttributes.CARRYING.getName(), PASSING_CARRYING_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), PASSING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSING_STRENGTH_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), PASSING_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSING_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSING_BREAK_TACKLE_VAR);
        final Attribute<Integer> elusivenessAdjust = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSING_ELUSIVENESS_VAR);

        final ModifierAttribute throwPowerImportant = new ModifierAttribute(StatAttributes.THROW_POWER.getName(), PASSING_THROW_POWER_IMPORTANCE);
        final ModifierAttribute throwAccuracyImportant = new ModifierAttribute(StatAttributes.THROW_ACCURACY.getName(), PASSING_THROW_ACCURACY_IMPORTANCE);
        final ModifierAttribute awarenessImportant = new ModifierAttribute(StatAttributes.AWARENESS.getName(), PASSING_AWARENESS_IMPORTANCE);
        final ModifierAttribute strengthImportant = new ModifierAttribute(StatAttributes.STRENGTH.getName(), PASSING_STRENGTH_IMPORTANCE);
        final ModifierAttribute speedImportant = new ModifierAttribute(StatAttributes.SPEED.getName(), PASSING_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportant = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), PASSING_ACCELERATION_IMPORTANCE);
        final ModifierAttribute agilityImportant = new ModifierAttribute(StatAttributes.AGILITY.getName(), PASSING_AGILITY_IMPORTANCE);
        final ModifierAttribute carryingImportant = new ModifierAttribute(StatAttributes.CARRYING.getName(), PASSING_CARRYING_IMPORTANCE);
        final ModifierAttribute breakTackleImportant = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), PASSING_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute elusivenessImportant = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), PASSING_ELUSIVENESS_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                awarenessAdjust,
                speedAdjust,
                carryAdjust,
                staminaAdjust,
                strengthAdjust,
                agilityAdjust,
                accelerationAdjust,
                breakTackleAdjust,
                elusivenessAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                throwPowerImportant,
                throwAccuracyImportant,
                awarenessImportant,
                strengthImportant,
                speedImportant,
                accelerationImportant,
                carryingImportant,
                agilityImportant,
                breakTackleImportant,
                elusivenessImportant
        );

        final Quarterback quarterback = new Quarterback(PASSING_SUBPOSITION_NAME);
        quarterback.updateAttributes(attrs);
        quarterback.updateModifiers(mods);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }
    
    public final static Quarterback GenerateRunningQuarterback(final int overallSeed){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNNING_THROW_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNNING_THROW_ACCURACY_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNNING_AWARENESS_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUNNING_SPEED_VAR);
        final Attribute<Integer> carryAdjust = new Attribute<>(StatAttributes.CARRYING.getName(), RUNNING_CARRYING_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNNING_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUNNING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNNING_STRENGTH_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), RUNNING_AGILITY_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNNING_BREAK_TACKLE_VAR);
        final Attribute<Integer> elusivenessAdjust = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNNING_ELUSIVENESS_VAR);

        final ModifierAttribute throwPowerImportant = new ModifierAttribute(StatAttributes.THROW_POWER.getName(), RUNNING_THROW_POWER_IMPORTANCE);
        final ModifierAttribute throwAccuracyImportant = new ModifierAttribute(StatAttributes.THROW_ACCURACY.getName(), RUNNING_THROW_ACCURACY_IMPORTANCE);
        final ModifierAttribute awarenessImportant = new ModifierAttribute(StatAttributes.AWARENESS.getName(), RUNNING_AWARENESS_IMPORTANCE);
        final ModifierAttribute speedImportant = new ModifierAttribute(StatAttributes.SPEED.getName(), RUNNING_SPEED_IMPORTANCE);
        final ModifierAttribute carryImportant = new ModifierAttribute(StatAttributes.CARRYING.getName(), RUNNING_CARRYING_IMPORTANCE);
        final ModifierAttribute accelerationImportant = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), RUNNING_ACCELERATION_IMPORTANCE);
        final ModifierAttribute agilityImportant = new ModifierAttribute(StatAttributes.AGILITY.getName(), RUNNING_AGILITY_IMPORTANCE);
        final ModifierAttribute breakTackleImportant = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), RUNNING_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute elusivenessImportant = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), RUNNING_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute strengthImportant = new ModifierAttribute(StatAttributes.STRENGTH.getName(), RUNNING_STRENGTH_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                awarenessAdjust,
                speedAdjust,
                carryAdjust,
                accelerationAdjust,
                staminaAdjust,
                strengthAdjust,
                agilityAdjust,
                breakTackleAdjust,
                elusivenessAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                throwPowerImportant,
                throwAccuracyImportant,
                awarenessImportant,
                speedImportant,
                carryImportant,
                accelerationImportant,
                agilityImportant,
                breakTackleImportant,
                elusivenessImportant,
                strengthImportant
        );

        final Quarterback quarterback = new Quarterback(RUNNING_SUBPOSITION_NAME);
        quarterback.updateAttributes(attrs);
        quarterback.updateModifiers(mods);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

}
