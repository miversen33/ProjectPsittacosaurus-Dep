package Position.Offense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.TIGHT_END;

public final class TightEnd extends Position {
    public final static String BLOCKING_SUBPOSITION_NAME = "Blocking";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String RECEIVING_SUBPOSITION_NAME = "Receiving";

    private final static double BASE_RATING = .95;

    private final static int BLOCKING_SPEED_VAR = 2;
    private final static int BLOCKING_STRENGTH_VAR = 3;
    private final static int BLOCKING_ACCELERATION_VAR = 2;
    private final static int BLOCKING_RUN_BLOCK_VAR = 4;
    private final static int BLOCKING_PASS_BLOCK_VAR = 3;
    private final static int BLOCKING_STAMINA_VAR = 2;
    private final static int BLOCKING_INJURY_VAR = 5;
    private final static double BLOCKING_SPEED_IMPORTANCE = .49;
    private final static double BLOCKING_AGILITY_IMPORTANCE = .49;
    private final static double BLOCKING_BREAK_TACKLE_IMPORTANCE = .51;
    private final static double BLOCKING_ELUSIVENESS_IMPORTANCE = .30;
    private final static double BLOCKING_CARRYING_IMPORTANCE = .59;
    private final static double BLOCKING_CATCHING_IMPORTANCE = .51;
    private final static double BLOCKING_ROUTE_RUNNING_IMPORTANCE = .51;
    private final static double BLOCKING_STRENGTH_IMPORTANCE = .74;
    private final static double BLOCKING_ACCELERATION_IMPORTANCE = .49;
    private final static double BLOCKING_AWARENESS_IMPORTANCE = .69;
    private final static double BLOCKING_RUN_BLOCK_IMPORTANCE = .80;
    private final static double BLOCKING_PASS_BLOCK_IMPORTANCE = .80;

    private final static int RECEIVING_SPEED_VAR = -2;
    private final static int RECEIVING_STRENGTH_VAR = 3;
    private final static int RECEIVING_ACCELERATION_VAR = -2;
    private final static int RECEIVING_RUN_BLOCK_VAR = 2;
    private final static int RECEIVING_PASS_BLOCK_VAR = 5;
    private final static int RECEIVING_STAMINA_VAR = 2;
    private final static int RECEIVING_INJURY_VAR = 5;
    private final static double RECEIVING_SPEED_IMPORTANCE = .63;
    private final static double RECEIVING_AGILITY_IMPORTANCE = .53;
    private final static double RECEIVING_BREAK_TACKLE_IMPORTANCE = .66;
    private final static double RECEIVING_ELUSIVENESS_IMPORTANCE = .49;
    private final static double RECEIVING_CARRYING_IMPORTANCE = .70;
    private final static double RECEIVING_CATCHING_IMPORTANCE = .75;
    private final static double RECEIVING_ROUTE_RUNNING_IMPORTANCE = .60;
    private final static double RECEIVING_STRENGTH_IMPORTANCE = .62;
    private final static double RECEIVING_ACCELERATION_IMPORTANCE = .55;
    private final static double RECEIVING_AWARENESS_IMPORTANCE = .70;
    private final static double RECEIVING_RUN_BLOCK_IMPORTANCE = .55;
    private final static double RECEIVING_PASS_BLOCK_IMPORTANCE = .55;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_RUN_BLOCK_VAR = 1;
    private final static int NEUTRAL_PASS_BLOCK_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .60;
    private final static double NEUTRAL_AGILITY_IMPORTANCE = .60;
    private final static double NEUTRAL_BREAK_TACKLE_IMPORTANCE = .60;
    private final static double NEUTRAL_ELUSIVENESS_IMPORTANCE = .60;
    private final static double NEUTRAL_CARRYING_IMPORTANCE = .60;
    private final static double NEUTRAL_CATCHING_IMPORTANCE = .60;
    private final static double NEUTRAL_ROUTE_RUNNING_IMPORTANCE = .60;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .60;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .60;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .60;
    private final static double NEUTRAL_RUN_BLOCK_IMPORTANCE = .60;
    private final static double NEUTRAL_PASS_BLOCK_IMPORTANCE = .60;

    private TightEnd(final String subPositionName) {
        super(TIGHT_END.getName(), subPositionName, BASE_RATING);
    }

    public final static TightEnd GenerateBlockingTightEnd(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), BLOCKING_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLOCKING_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), BLOCKING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), BLOCKING_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), BLOCKING_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), BLOCKING_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), BLOCKING_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), BLOCKING_AGILITY_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), BLOCKING_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), BLOCKING_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), BLOCKING_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), BLOCKING_ROUTE_RUNNING_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), BLOCKING_BREAK_TACKLE_IMPORTANCE);

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

        final TightEnd tightEnd = new TightEnd(BLOCKING_SUBPOSITION_NAME);
        tightEnd.updateAttributes(attrs);
        tightEnd.updateModifiers(mods);
        tightEnd.seedRating(ovrSeed);
        return tightEnd;
    }

    public final static TightEnd GenerateReceivingTightEnd(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RECEIVING_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RECEIVING_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RECEIVING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RECEIVING_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RECEIVING_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RECEIVING_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RECEIVING_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), RECEIVING_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), RECEIVING_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), RECEIVING_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), RECEIVING_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), RECEIVING_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), RECEIVING_AWARENESS_IMPORTANCE);
        final ModifierAttribute agilityImportance = new ModifierAttribute(StatAttributes.AGILITY.getName(), RECEIVING_AGILITY_IMPORTANCE);
        final ModifierAttribute elusivenessImportance = new ModifierAttribute(StatAttributes.ELUSIVENESS.getName(), RECEIVING_ELUSIVENESS_IMPORTANCE);
        final ModifierAttribute carryingImportance = new ModifierAttribute(StatAttributes.CARRYING.getName(), RECEIVING_CARRYING_IMPORTANCE);
        final ModifierAttribute catchingImportance = new ModifierAttribute(StatAttributes.CATCHING.getName(), RECEIVING_CATCHING_IMPORTANCE);
        final ModifierAttribute routeRunningImportance = new ModifierAttribute(StatAttributes.ROUTE_RUNNING.getName(), RECEIVING_ROUTE_RUNNING_IMPORTANCE);
        final ModifierAttribute breakTackleImportance = new ModifierAttribute(StatAttributes.BREAK_TACKLE.getName(), RECEIVING_BREAK_TACKLE_IMPORTANCE);

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

        final TightEnd tightEnd = new TightEnd(RECEIVING_SUBPOSITION_NAME);
        tightEnd.updateAttributes(attrs);
        tightEnd.updateModifiers(mods);
        tightEnd.seedRating(ovrSeed);

        return tightEnd;
    }

    public final static TightEnd GenerateNeutralTightEnd(final int ovrSeed){
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

        final TightEnd tightEnd = new TightEnd(NEUTRAL_SUBPOSITION_NAME);
        tightEnd.updateAttributes(attrs);
        tightEnd.updateModifiers(mods);
        tightEnd.seedRating(ovrSeed);
        return tightEnd;
    }
}
