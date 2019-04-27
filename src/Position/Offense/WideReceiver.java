package Position.Offense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;


import java.util.Arrays;
import java.util.List;

import static Position.PositionList.WIDE_RECEIVER;

public final class WideReceiver extends Position {
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String SPEED_SUBPOSITION_NAME = "Speed";
    public final static String POSSESSION_SUBPOSITION_NAME = "Possession";

    private final static double BASE_RATING = .810;

    private final static int POSSESSION_SPEED_VAR = 2;
    private final static int POSSESSION_STRENGTH_VAR = 3;
    private final static int POSSESSION_ACCELERATION_VAR = 2;
    private final static int POSSESSION_RUN_BLOCK_VAR = 4;
    private final static int POSSESSION_PASS_BLOCK_VAR = 3;
    private final static int POSSESSION_STAMINA_VAR = 2;
    private final static int POSSESSION_INJURY_VAR = 5;
    private final static double POSSESSION_SPEED_IMPORTANCE = .675;
    private final static double POSSESSION_STRENGTH_IMPORTANCE = .70;
    private final static double POSSESSION_AGILITY_IMPORTANCE = .60;
    private final static double POSSESSION_ACCELERATION_IMPORTANCE = .675;
    private final static double POSSESSION_AWARENESS_IMPORTANCE = .69;
    private final static double POSSESSION_BREAK_TACKLE_IMPORTANCE = .75;
    private final static double POSSESSION_ELUSIVENESS_IMPORTANCE = .50;
    private final static double POSSESSION_CARRYING_IMPORTANCE = .925;
    private final static double POSSESSION_CATCHING_IMPORTANCE = .925;
    private final static double POSSESSION_ROUTE_RUNNING_IMPORTANCE = .79;
    private final static double POSSESSION_RUN_BLOCK_IMPORTANCE = .45;
    private final static double POSSESSION_PASS_BLOCK_IMPORTANCE = .34;

    private final static int SPEED_SPEED_VAR = -2;
    private final static int SPEED_STRENGTH_VAR = 3;
    private final static int SPEED_ACCELERATION_VAR = -2;
    private final static int SPEED_RUN_BLOCK_VAR = 2;
    private final static int SPEED_PASS_BLOCK_VAR = 5;
    private final static int SPEED_STAMINA_VAR = 2;
    private final static int SPEED_INJURY_VAR = 5;
    private final static double SPEED_SPEED_IMPORTANCE = .925;
    private final static double SPEED_STRENGTH_IMPORTANCE = .575;
    private final static double SPEED_AGILITY_IMPORTANCE = .70;
    private final static double SPEED_ACCELERATION_IMPORTANCE = .85;
    private final static double SPEED_AWARENESS_IMPORTANCE = .65;
    private final static double SPEED_BREAK_TACKLE_IMPORTANCE = .575;
    private final static double SPEED_ELUSIVENESS_IMPORTANCE = .725;
    private final static double SPEED_CARRYING_IMPORTANCE = .725;
    private final static double SPEED_CATCHING_IMPORTANCE = .825;
    private final static double SPEED_ROUTE_RUNNING_IMPORTANCE = .75;
    private final static double SPEED_RUN_BLOCK_IMPORTANCE = .35;
    private final static double SPEED_PASS_BLOCK_IMPORTANCE = .30;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_RUN_BLOCK_VAR = 1;
    private final static int NEUTRAL_PASS_BLOCK_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .75;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .66;
    private final static double NEUTRAL_BREAK_TACKLE_IMPORTANCE = .66;
    private final static double NEUTRAL_ELUSIVENESS_IMPORTANCE = .66;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .70;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .70;
    private final static double NEUTRAL_ROUTE_RUNNING_IMPORTANCE = .66;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .66;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .66;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .66;
    private final static double NEUTRAL_RUN_BLOCK_IMPORTANCE = .66;
    private final static double NEUTRAL_PASS_BLOCK_IMPORTANCE = .66;

    private WideReceiver(final String subPositionName) {
        super(WIDE_RECEIVER.getName(), subPositionName, BASE_RATING);
    }

    public final static WideReceiver GeneratePossessionWideReceiver(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), POSSESSION_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), POSSESSION_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), POSSESSION_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), POSSESSION_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), POSSESSION_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), POSSESSION_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), POSSESSION_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), POSSESSION_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), POSSESSION_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), POSSESSION_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), POSSESSION_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), POSSESSION_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), POSSESSION_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), POSSESSION_AGILITY_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), POSSESSION_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), POSSESSION_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), POSSESSION_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), POSSESSION_ROUTE_RUNNING_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), POSSESSION_BREAK_TACKLE_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
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
                accelerationImportance,
                strengthImportance,
                passBlockImportance,
                runBlockImportance,
                awarenessImportance,
                agilityImportance,
                elusivenessImportance,
                carryingImportance,
                catchingImportance,
                routeRunningImportance,
                breakTackleImportance
        );

        final WideReceiver wideReceiver = new WideReceiver(POSSESSION_SUBPOSITION_NAME);
        wideReceiver.updateAttributes(attrs);
        wideReceiver.updateModifiers(mods);
        wideReceiver.seedRating(ovrSeed);
        return wideReceiver;
    }

    public final static WideReceiver GenerateSpeedWideReceiver(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), SPEED_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), SPEED_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), SPEED_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), SPEED_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), SPEED_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), SPEED_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), SPEED_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), SPEED_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), SPEED_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), SPEED_AGILITY_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), SPEED_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), SPEED_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), SPEED_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), SPEED_ROUTE_RUNNING_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_TACKLE_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
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
                accelerationImportance,
                strengthImportance,
                passBlockImportance,
                runBlockImportance,
                awarenessImportance,
                agilityImportance,
                elusivenessImportance,
                carryingImportance,
                catchingImportance,
                routeRunningImportance,
                breakTackleImportance
        );

        final WideReceiver wideReceiver = new WideReceiver(SPEED_SUBPOSITION_NAME);
        wideReceiver.updateAttributes(attrs);
        wideReceiver.updateModifiers(mods);
        wideReceiver.seedRating(ovrSeed);

        return wideReceiver;
    }

    public final static WideReceiver GenerateNeutralWideReceiver(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), NEUTRAL_ROUTE_RUNNING_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE_IMPORTANCE);

        final List<Attribute<Integer>> attrs = Arrays.asList(
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
                accelerationImportance,
                strengthImportance,
                passBlockImportance,
                runBlockImportance,
                awarenessImportance,
                agilityImportance,
                elusivenessImportance,
                carryingImportance,
                catchingImportance,
                routeRunningImportance,
                breakTackleImportance
        );

        final WideReceiver wideReceiver = new WideReceiver(NEUTRAL_SUBPOSITION_NAME);
        wideReceiver.updateAttributes(attrs);
        wideReceiver.updateModifiers(mods);
        wideReceiver.seedRating(ovrSeed);
        return wideReceiver;
    }
}
