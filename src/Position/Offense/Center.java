package Position.Offense;

import Attributes.Attribute;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.OFFENSIVE_CENTER;

public final class Center extends OffensiveLineman{

    public final static String RUNBLOCK_SUBPOSITION_NAME = "Run Blocker";
    public final static String NEUTRALBLOCK_SUBPOSITION_NAME = "Neutral Blocker";
    public final static String PASSBLOCK_SUBPOSITION_NAME = "Pass Blocker";

    private final static int RUNBLOCK_SPEED_VAR = 1;
    private final static int RUNBLOCK_STRENGTH_VAR = 3;
    private final static int RUNBLOCK_ACCELERATION_VAR = -2;
    private final static int RUNBLOCK_RUN_BLOCK_VAR = 5;
    private final static int RUNBLOCK_PASS_BLOCK_VAR = 2;
    private final static int RUNBLOCK_STAMINA_VAR = 2;
    private final static int RUNBLOCK_INJURY_VAR = 5;
    private final static double RUNBLOCK_SPEED_IMPORTANCE = .1;
    private final static double RUNBLOCK_STRENGTH_IMPORTANCE = .98;
    private final static double RUNBLOCK_ACCELERATION_IMPORTANCE = .3;
    private final static double RUNBLOCK_AWARENESS_IMPORTANCE = .9;
    private final static double RUNBLOCK_RUN_BLOCK_IMPORTANCE = .9;
    private final static double RUNBLOCK_PASS_BLOCK_IMPORTANCE = .7;

    private final static int PASSBLOCK_SPEED_VAR = -2;
    private final static int PASSBLOCK_STRENGTH_VAR = 3;
    private final static int PASSBLOCK_ACCELERATION_VAR = -2;
    private final static int PASSBLOCK_RUN_BLOCK_VAR = 2;
    private final static int PASSBLOCK_PASS_BLOCK_VAR = 5;
    private final static int PASSBLOCK_STAMINA_VAR = 2;
    private final static int PASSBLOCK_INJURY_VAR = 5;
    private final static double PASSBLOCK_SPEED_IMPORTANCE = .3;
    private final static double PASSBLOCK_STRENGTH_IMPORTANCE = .98;
    private final static double PASSBLOCK_ACCELERATION_IMPORTANCE = .3;
    private final static double PASSBLOCK_AWARENESS_IMPORTANCE = .9;
    private final static double PASSBLOCK_RUN_BLOCK_IMPORTANCE = .7;
    private final static double PASSBLOCK_PASS_BLOCK_IMPORTANCE = .9;

    private final static int NEUTRAL_SPEED_VAR = 0;
    private final static int NEUTRAL_ACCELERATION_VAR = -1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_RUN_BLOCK_VAR = 1;
    private final static int NEUTRAL_PASS_BLOCK_VAR = 4;
    private final static int NEUTRAL_STAMINA_VAR = 3;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static double NEUTRAL_SPEED_IMPORTANCE = .3;
    private final static double NEUTRAL_STRENGTH_IMPORTANCE = .98;
    private final static double NEUTRAL_ACCELERATION_IMPORTANCE = .3;
    private final static double NEUTRAL_AWARENESS_IMPORTANCE = .9;
    private final static double NEUTRAL_RUN_BLOCK_IMPORTANCE = .8;
    private final static double NEUTRAL_PASS_BLOCK_IMPORTANCE = .8;

    private Center(final String subPositionName) {
        super(OFFENSIVE_CENTER.getName(), subPositionName);
    }

    public final static Center GenerateRunBlockingCenter(final int ovrSeed){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNBLOCK_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RUNBLOCK_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), RUNBLOCK_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS_IMPORTANCE);

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
                awarenessImportance
        );

        final Center center = new Center(RUNBLOCK_SUBPOSITION_NAME);
        center.updateAttributes(attrs);
        center.updateModifiers(mods);
        center.seedRating(ovrSeed);
        return center;
    }

    public final static Center GeneratePassBlockingCenter(final int ovrSeed){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSBLOCK_ACCELERATION_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_BLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_BLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), PASSBLOCK_INJURY_VAR);

        final ModifierAttribute speedImportance = new ModifierAttribute(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED_IMPORTANCE);
        final ModifierAttribute accelerationImportance = new ModifierAttribute(StatAttributes.ACCELERATION.getName(), PASSBLOCK_ACCELERATION_IMPORTANCE);
        final ModifierAttribute strengthImportance = new ModifierAttribute(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH_IMPORTANCE);
        final ModifierAttribute passBlockImportance = new ModifierAttribute(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_BLOCK_IMPORTANCE);
        final ModifierAttribute runBlockImportance = new ModifierAttribute(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_BLOCK_IMPORTANCE);
        final ModifierAttribute awarenessImportance = new ModifierAttribute(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS_IMPORTANCE);

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
                awarenessImportance
        );

        final Center center = new Center(PASSBLOCK_SUBPOSITION_NAME);
        center.updateAttributes(attrs);
        center.updateModifiers(mods);
        center.seedRating(ovrSeed);

        return center;
    }

    public final static Center GenerateNeutralCenter(final int ovrSeed){
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
                awarenessImportance
        );

        final Center center = new Center(NEUTRALBLOCK_SUBPOSITION_NAME);
        center.updateAttributes(attrs);
        center.updateModifiers(mods);
        center.seedRating(ovrSeed);
        return center;
    }
}
