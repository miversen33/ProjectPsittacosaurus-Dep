package Position.Offense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;
import org.w3c.dom.Attr;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static Position.PositionList.TAILBACK;

public final class Tailback extends Position {

    public final static String SPEED_SUBPOSITION_NAME = "Speed";
    public final static String POWER_SUBPOSITION_NAME = "Power";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double BASE_RATING = .825;

    private final static int SPEED_SPEED_VAR = 2;
    private final static int SPEED_STRENGTH_VAR = 1;
    private final static int SPEED_AGILITY_VAR = 2;
    private final static int SPEED_ACCELERATION_VAR = 3;
    private final static int SPEED_RUN_BLOCK_VAR = 1;
    private final static int SPEED_PASS_BLOCK_VAR = 1;
    private final static int SPEED_BREAK_TACKLE_VAR = -2;
    private final static int SPEED_STAMINA_VAR = 2;
    private final static int SPEED_INJURY_VAR = 0;
    private final static double SPEED_SPEED_IMPORTANCE = .81;
    private final static double SPEED_STRENGTH_IMPORTANCE = .60;
    private final static double SPEED_AGILITY_IMPORTANCE = .79;
    private final static double SPEED_ACCELERATION_IMPORTANCE = .75;
    private final static double SPEED_AWARENESS_IMPORTANCE = .70;
    private final static double SPEED_BREAK_TACKLE_IMPORTANCE = .60;
    private final static double SPEED_ELUSIVENESS_IMPORTANCE = .70;
    private final static double SPEED_CARRYING_IMPORTANCE = .795;
    private final static double SPEED_CATCHING_IMPORTANCE = .60;
    private final static double SPEED_ROUTE_RUNNING_IMPORTANCE = .5;
    private final static double SPEED_RUN_BLOCK_IMPORTANCE = .49;
    private final static double SPEED_PASS_BLOCK_IMPORTANCE = .49;

    private final static int POWER_SPEED_VAR = -2;
    private final static int POWER_AGILITY_VAR = -2;
    private final static int POWER_ACCELERATION_VAR = 2;
    private final static int POWER_STRENGTH_VAR = 1;
    private final static int POWER_RUN_BLOCK_VAR = 1;
    private final static int POWER_PASS_BLOCK_VAR = 1;
    private final static int POWER_BREAK_TACKLE_VAR = 5;
    private final static int POWER_STAMINA_VAR = 2;
    private final static int POWER_INJURY_VAR = 2;
    private final static double POWER_SPEED_IMPORTANCE = .67;
    private final static double POWER_STRENGTH_IMPORTANCE = .84;
    private final static double POWER_AGILITY_IMPORTANCE = .44;
    private final static double POWER_ACCELERATION_IMPORTANCE = .625;
    private final static double POWER_AWARENESS_IMPORTANCE = .70;
    private final static double POWER_BREAK_TACKLE_IMPORTANCE = .84;
    private final static double POWER_ELUSIVENESS_IMPORTANCE = .30;
    private final static double POWER_CARRYING_IMPORTANCE = .975;
    private final static double POWER_CATCHING_IMPORTANCE = .64;
    private final static double POWER_ROUTE_RUNNING_IMPORTANCE = .44;
    private final static double POWER_RUN_BLOCK_IMPORTANCE = .45;
    private final static double POWER_PASS_BLOCK_IMPORTANCE = .74;

    private final static int NEUTRAL_SPEED_VAR = 1;
    private final static int NEUTRAL_AGILITY_VAR = 1;
    private final static int NEUTRAL_ACCELERATION_VAR = 1;
    private final static int NEUTRAL_STRENGTH_VAR = 1;
    private final static int NEUTRAL_RUN_BLOCK_VAR = 1;
    private final static int NEUTRAL_PASS_BLOCK_VAR = 1;
    private final static int NEUTRAL_BREAK_TACKLE_VAR = 1;
    private final static int NEUTRAL_STAMINA_VAR = 1;
    private final static int NEUTRAL_INJURY_VAR = 1;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .7;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .7;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .7;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .7;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .65;
    private final static double NEUTRAL_BREAK_TACKLE_IMPORTANCE = .7;
    private final static double NEUTRAL_ELUSIVENESS_IMPORTANCE = .67;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .7;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .60;
    private final static double NEUTRAL_ROUTE_RUNNING_IMPORTANCE = .60;
    private final static double NEUTRAL_RUN_BLOCK_IMPORTANCE = .575;
    private final static double NEUTRAL_PASS_BLOCK_IMPORTANCE = .575;

    private Tailback(final String subPositionName) {
        super(TAILBACK.getName(), subPositionName, BASE_RATING);
    }

    public final static Tailback GenerateSpeedTailBack(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), SPEED_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), SPEED_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_TACKLE_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), SPEED_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), SPEED_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), SPEED_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), SPEED_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), SPEED_SPEED_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), SPEED_AGILITY_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), SPEED_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), SPEED_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), SPEED_AWARENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), SPEED_CARRYING_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), SPEED_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), SPEED_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), SPEED_ROUTE_RUNNING_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                agilityAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                passBlockAdjust,
                runBlockAdjust,
                injuryAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                speedImportance,
                agilityImportance,
                accelerationImportance,
                breakTackleImportance,
                strengthImportance,
                passBlockImportance,
                runBlockImportance,
                awarenessImportance,
                carryingImportance,
                elusivenessImportance,
                catchingImportance,
                routeRunningImportance
        );

        final Tailback tailback = new Tailback(SPEED_SUBPOSITION_NAME);
        tailback.updateAttributes(attrs);
        tailback.updateModifiers(mods);
        tailback.seedRating(ovrSeed);
        return tailback;
    }

    public final static Tailback GeneratePowerTailback(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), POWER_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), POWER_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POWER_BREAK_TACKLE_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), POWER_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), POWER_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), POWER_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), POWER_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), POWER_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), POWER_SPEED_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), POWER_AGILITY_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), POWER_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), POWER_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), POWER_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), POWER_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), POWER_AWARENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), POWER_CARRYING_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), POWER_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), POWER_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), POWER_ROUTE_RUNNING_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                agilityAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                passBlockAdjust,
                runBlockAdjust,
                injuryAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                speedImportance,
                agilityImportance,
                accelerationImportance,
                breakTackleImportance,
                strengthImportance,
                passBlockImportance,
                runBlockImportance,
                awarenessImportance,
                carryingImportance,
                elusivenessImportance,
                catchingImportance,
                routeRunningImportance
        );

        final Tailback tailback = new Tailback(POWER_SUBPOSITION_NAME);
        tailback.updateAttributes(attrs);
        tailback.updateModifiers(mods);
        tailback.seedRating(ovrSeed);
        
        return tailback;
    }

    public final static Tailback GenerateNeutralTailback(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), NEUTRAL_ROUTE_RUNNING_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                agilityAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                strengthAdjust,
                passBlockAdjust,
                runBlockAdjust,
                injuryAdjust
        );

        final List<ModifierAttribute> mods = Arrays.asList(
                speedImportance,
                agilityImportance,
                accelerationImportance,
                breakTackleImportance,
                strengthImportance,
                passBlockImportance,
                runBlockImportance,
                awarenessImportance,
                carryingImportance,
                elusivenessImportance,
                catchingImportance,
                routeRunningImportance
        );

        final Tailback tailback = new Tailback(NEUTRAL_SUBPOSITION_NAME);
        tailback.updateAttributes(attrs);
        tailback.updateModifiers(mods);
        tailback.seedRating(ovrSeed);
        return tailback;
    }
}
