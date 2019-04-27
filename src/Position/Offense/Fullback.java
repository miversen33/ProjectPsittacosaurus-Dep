package Position.Offense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.FULLBACK;

public final class Fullback extends Position {

    public final static String BLOCKING_SUBPOSITION_NAME = "Blocking";
    public final static String RUSHING_SUBPOSITION_NAME = "Rushing";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double BASE_RATING = .80;

    private final static int BLOCKING_SPEED_VAR = 1;
    private final static int BLOCKING_STRENGTH_VAR = 3;
    private final static int BLOCKING_AGILITY_VAR = 1;
    private final static int BLOCKING_ACCELERATION_VAR = 1;
    private final static int BLOCKING_RUN_BLOCK_VAR = 5;
    private final static int BLOCKING_PASS_BLOCK_VAR = 5;
    private final static int BLOCKING_BREAK_TACKLE_VAR = 5;
    private final static int BLOCKING_STAMINA_VAR = 2;
    private final static int BLOCKING_INJURY_VAR = 5;
    private final static double BLOCKING_SPEED_IMPORTANCE = .575;
    private final static double BLOCKING_STRENGTH_IMPORTANCE = .95;
    private final static double BLOCKING_AGILITY_IMPORTANCE = .4;
    private final static double BLOCKING_ACCELERATION_IMPORTANCE = .575;
    private final static double BLOCKING_AWARENESS_IMPORTANCE = .9;
    private final static double BLOCKING_BREAK_TACKLE_IMPORTANCE = .75;
    private final static double BLOCKING_ELUSIVENESS_IMPORTANCE = .3;
    private final static double BLOCKING_CARRYING_IMPORTANCE = .875;
    private final static double BLOCKING_CATCHING_IMPORTANCE = .55;
    private final static double BLOCKING_ROUTE_RUNNING_IMPORTANCE = .35;
    private final static double BLOCKING_RUN_BLOCK_IMPORTANCE = .9;
    private final static double BLOCKING_PASS_BLOCK_IMPORTANCE = .9;

    private final static int RUSHING_SPEED_VAR = -2;
    private final static int RUSHING_AGILITY_VAR = -2;
    private final static int RUSHING_ACCELERATION_VAR = 2;
    private final static int RUSHING_STRENGTH_VAR = 1;
    private final static int RUSHING_RUN_BLOCK_VAR = 1;
    private final static int RUSHING_PASS_BLOCK_VAR = 1;
    private final static int RUSHING_BREAK_TACKLE_VAR = 5;
    private final static int RUSHING_STAMINA_VAR = 2;
    private final static int RUSHING_INJURY_VAR = 2;
    private final static double RUSHING_SPEED_IMPORTANCE = .65;
    private final static double RUSHING_STRENGTH_IMPORTANCE = .9;
    private final static double RUSHING_AGILITY_IMPORTANCE = .44;
    private final static double RUSHING_ACCELERATION_IMPORTANCE = .65;
    private final static double RUSHING_AWARENESS_IMPORTANCE = .75;
    private final static double RUSHING_BREAK_TACKLE_IMPORTANCE = .84;
    private final static double RUSHING_ELUSIVENESS_IMPORTANCE = .44;
    private final static double RUSHING_CARRYING_IMPORTANCE = .98;
    private final static double RUSHING_CATCHING_IMPORTANCE = .64;
    private final static double RUSHING_ROUTE_RUNNING_IMPORTANCE = .44;
    private final static double RUSHING_RUN_BLOCK_IMPORTANCE = .45;
    private final static double RUSHING_PASS_BLOCK_IMPORTANCE = .74;

    private final static int NEUTRAL_SPEED_VAR = 1;
    private final static int NEUTRAL_AGILITY_VAR = 1;
    private final static int NEUTRAL_ACCELERATION_VAR = 1;
    private final static int NEUTRAL_STRENGTH_VAR = 1;
    private final static int NEUTRAL_RUN_BLOCK_VAR = 1;
    private final static int NEUTRAL_PASS_BLOCK_VAR = 1;
    private final static int NEUTRAL_BREAK_TACKLE_VAR = 1;
    private final static int NEUTRAL_STAMINA_VAR = 1;
    private final static int NEUTRAL_INJURY_VAR = 1;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .625;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .8;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .4;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .625;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .80;
    private final static double NEUTRAL_BREAK_TACKLE_IMPORTANCE = .80;
    private final static double NEUTRAL_ELUSIVENESS_IMPORTANCE = .40;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .90;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .70;
    private final static double NEUTRAL_ROUTE_RUNNING_IMPORTANCE = .50;
    private final static double NEUTRAL_RUN_BLOCK_IMPORTANCE = .7;
    private final static double NEUTRAL_PASS_BLOCK_IMPORTANCE = .7;

    private Fullback(final String subPositionName) {
        super(FULLBACK.getName(), subPositionName, BASE_RATING);
    }

    public final static Fullback GenerateBlockingFullBack(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), BLOCKING_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), BLOCKING_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLOCKING_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), BLOCKING_BREAK_TACKLE_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), BLOCKING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), BLOCKING_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), BLOCKING_SPEED_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), BLOCKING_AGILITY_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), BLOCKING_ACCELERATION_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), BLOCKING_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), BLOCKING_AWARENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), BLOCKING_CARRYING_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), BLOCKING_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), BLOCKING_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), BLOCKING_ROUTE_RUNNING_IMPORTANCE);

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

        final Fullback fullback = new Fullback(BLOCKING_SUBPOSITION_NAME);
        fullback.updateAttributes(attrs);
        fullback.updateModifiers(mods);
        fullback.seedRating(ovrSeed);
        return fullback;
    }

    public final static Fullback GenerateRushingFullback(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUSHING_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), RUSHING_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUSHING_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUSHING_BREAK_TACKLE_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUSHING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RUSHING_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUSHING_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUSHING_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RUSHING_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), RUSHING_SPEED_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), RUSHING_AGILITY_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), RUSHING_ACCELERATION_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), RUSHING_BREAK_TACKLE_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), RUSHING_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), RUSHING_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), RUSHING_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), RUSHING_AWARENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), RUSHING_CARRYING_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), RUSHING_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), RUSHING_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), RUSHING_ROUTE_RUNNING_IMPORTANCE);

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

        final Fullback fullback = new Fullback(RUSHING_SUBPOSITION_NAME);
        fullback.updateAttributes(attrs);
        fullback.updateModifiers(mods);
        fullback.seedRating(ovrSeed);

        return fullback;
    }

    public final static Fullback GenerateNeutralFullback(final int ovrSeed){
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

        final Fullback fullback = new Fullback(NEUTRAL_SUBPOSITION_NAME);
        fullback.updateAttributes(attrs);
        fullback.updateModifiers(mods);
        fullback.seedRating(ovrSeed);
        return fullback;
    }
}
