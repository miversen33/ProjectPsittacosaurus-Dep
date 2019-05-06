package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;
import Position.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class OffensiveTackle extends Position{

    public final static String RUNBLOCK_SUBPOSITION_NAME = "Runblock";
    public final static String PASSBLOCK_SUBPOSITION_NAME = "Passblock";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double POSITION_MEAN_OVERALL = 0.7;

    private final static BaseAttribute RUNBLOCK_AWARENESS = new BaseAttribute(
            BaseAttributes.OT_AWARENESS.getMean(), BaseAttributes.OT_AWARENESS.getDeviation());
    private final static BaseAttribute RUNBLOCK_STRENGTH = new BaseAttribute(
            BaseAttributes.OT_STRENGTH.getMean()-.05, BaseAttributes.OT_STRENGTH.getDeviation());
    private final static BaseAttribute RUNBLOCK_SPEED = new BaseAttribute(
            BaseAttributes.OT_SPEED.getMean()+.05, BaseAttributes.OT_SPEED.getDeviation());
    private final static BaseAttribute RUNBLOCK_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.OT_BREAK_BLOCK.getMean(), BaseAttributes.OT_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RUNBLOCK_TACKLE = new BaseAttribute(
            BaseAttributes.OT_TACKLE.getMean(), BaseAttributes.OT_TACKLE.getDeviation());
    private final static BaseAttribute RUNBLOCK_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.OT_RUN_BLOCKING.getMean()+.15, BaseAttributes.OT_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RUNBLOCK_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.OT_PASS_BLOCKING.getMean()-.15, BaseAttributes.OT_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RUNBLOCK_ACCELERATION = new BaseAttribute(
            BaseAttributes.OT_ACCELERATION.getMean()+.05, BaseAttributes.OT_ACCELERATION.getDeviation());
    private final static BaseAttribute RUNBLOCK_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.OT_BREAK_TACKLE.getMean(), BaseAttributes.OT_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute RUNBLOCK_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.OT_ELUSIVENESS.getMean(), BaseAttributes.OT_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RUNBLOCK_AGILITY = new BaseAttribute(
            BaseAttributes.OT_AGILITY.getMean(), BaseAttributes.OT_AGILITY.getDeviation());
    private final static BaseAttribute RUNBLOCK_INJURY = new BaseAttribute(
            BaseAttributes.OT_INJURY.getMean(), BaseAttributes.OT_INJURY.getDeviation());
    private final static BaseAttribute RUNBLOCK_STAMINA = new BaseAttribute(
            BaseAttributes.OT_STAMINA.getMean(), BaseAttributes.OT_STAMINA.getDeviation());
    private final static BaseAttribute RUNBLOCK_THROW_POWER = new BaseAttribute(
            BaseAttributes.OT_THROW_POWER.getMean(), BaseAttributes.OT_THROW_POWER.getDeviation());
    private final static BaseAttribute RUNBLOCK_KICK_POWER = new BaseAttribute(
            BaseAttributes.OT_KICK_POWER.getMean(), BaseAttributes.OT_KICK_POWER.getDeviation());
    private final static BaseAttribute RUNBLOCK_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.OT_KICK_ACCURACY.getMean(), BaseAttributes.OT_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RUNBLOCK_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.OT_THROW_ACCURACY.getMean(), BaseAttributes.OT_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute RUNBLOCK_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.OT_ROUTE_RUNNING.getMean(), BaseAttributes.OT_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> RUNBLOCK_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 3.00);
    private final static Attribute<Double> RUNBLOCK_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 2.15);
    private final static Attribute<Double> RUNBLOCK_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.75);
    private final static Attribute<Double> RUNBLOCK_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 2.15);
    private final static Attribute<Double> RUNBLOCK_AGILITY_IMPORTANCE = new Attribute<>(StatAttributes.AGILITY.getName(), 1.25);
    private final static Attribute<Double> RUNBLOCK_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 2.75);
    private final static Attribute<Double> RUNBLOCK_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 2.25);

    private final static BaseAttribute PASSBLOCK_AWARENESS = new BaseAttribute(
            BaseAttributes.OT_AWARENESS.getMean(), BaseAttributes.OT_AWARENESS.getDeviation());
    private final static BaseAttribute PASSBLOCK_STRENGTH = new BaseAttribute(
            BaseAttributes.OT_STRENGTH.getMean(), BaseAttributes.OT_STRENGTH.getDeviation());
    private final static BaseAttribute PASSBLOCK_SPEED = new BaseAttribute(
            BaseAttributes.OT_SPEED.getMean()-.05, BaseAttributes.OT_SPEED.getDeviation());
    private final static BaseAttribute PASSBLOCK_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.OT_BREAK_BLOCK.getMean(), BaseAttributes.OT_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute PASSBLOCK_TACKLE = new BaseAttribute(
            BaseAttributes.OT_TACKLE.getMean(), BaseAttributes.OT_TACKLE.getDeviation());
    private final static BaseAttribute PASSBLOCK_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.OT_RUN_BLOCKING.getMean()-.15, BaseAttributes.OT_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute PASSBLOCK_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.OT_PASS_BLOCKING.getMean()+.15, BaseAttributes.OT_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute PASSBLOCK_ACCELERATION = new BaseAttribute(
            BaseAttributes.OT_ACCELERATION.getMean()+.05, BaseAttributes.OT_ACCELERATION.getDeviation());
    private final static BaseAttribute PASSBLOCK_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.OT_BREAK_TACKLE.getMean(), BaseAttributes.OT_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute PASSBLOCK_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.OT_ELUSIVENESS.getMean(), BaseAttributes.OT_ELUSIVENESS.getDeviation());
    private final static BaseAttribute PASSBLOCK_AGILITY = new BaseAttribute(
            BaseAttributes.OT_AGILITY.getMean(), BaseAttributes.OT_AGILITY.getDeviation());
    private final static BaseAttribute PASSBLOCK_INJURY = new BaseAttribute(
            BaseAttributes.OT_INJURY.getMean(), BaseAttributes.OT_INJURY.getDeviation());
    private final static BaseAttribute PASSBLOCK_STAMINA = new BaseAttribute(
            BaseAttributes.OT_STAMINA.getMean(), BaseAttributes.OT_STAMINA.getDeviation());
    private final static BaseAttribute PASSBLOCK_THROW_POWER = new BaseAttribute(
            BaseAttributes.OT_THROW_POWER.getMean(), BaseAttributes.OT_THROW_POWER.getDeviation());
    private final static BaseAttribute PASSBLOCK_KICK_POWER = new BaseAttribute(
            BaseAttributes.OT_KICK_POWER.getMean(), BaseAttributes.OT_KICK_POWER.getDeviation());
    private final static BaseAttribute PASSBLOCK_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.OT_KICK_ACCURACY.getMean(), BaseAttributes.OT_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute PASSBLOCK_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.OT_THROW_ACCURACY.getMean(), BaseAttributes.OT_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute PASSBLOCK_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.OT_ROUTE_RUNNING.getMean(), BaseAttributes.OT_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> PASSBLOCK_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.75);
    private final static Attribute<Double> PASSBLOCK_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.75);
    private final static Attribute<Double> PASSBLOCK_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.70);
    private final static Attribute<Double> PASSBLOCK_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 2.00);
    private final static Attribute<Double> PASSBLOCK_AGILITY_IMPORTANCE = new Attribute<>(StatAttributes.AGILITY.getName(), 1.25);
    private final static Attribute<Double> PASSBLOCK_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 2.75);
    private final static Attribute<Double> PASSBLOCK_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 3.25);

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
            BaseAttributes.OT_AWARENESS.getMean(), BaseAttributes.OT_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
            BaseAttributes.OT_STRENGTH.getMean(), BaseAttributes.OT_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
            BaseAttributes.OT_SPEED.getMean(), BaseAttributes.OT_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.OT_BREAK_BLOCK.getMean(), BaseAttributes.OT_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
            BaseAttributes.OT_TACKLE.getMean(), BaseAttributes.OT_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.OT_RUN_BLOCKING.getMean(), BaseAttributes.OT_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.OT_PASS_BLOCKING.getMean(), BaseAttributes.OT_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
            BaseAttributes.OT_ACCELERATION.getMean(), BaseAttributes.OT_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.OT_BREAK_TACKLE.getMean(), BaseAttributes.OT_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.OT_ELUSIVENESS.getMean(), BaseAttributes.OT_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
            BaseAttributes.OT_AGILITY.getMean(), BaseAttributes.OT_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
            BaseAttributes.OT_INJURY.getMean(), BaseAttributes.OT_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
            BaseAttributes.OT_STAMINA.getMean(), BaseAttributes.OT_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
            BaseAttributes.OT_THROW_POWER.getMean(), BaseAttributes.OT_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
            BaseAttributes.OT_KICK_POWER.getMean(), BaseAttributes.OT_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.OT_KICK_ACCURACY.getMean(), BaseAttributes.OT_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.OT_THROW_ACCURACY.getMean(), BaseAttributes.OT_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.OT_ROUTE_RUNNING.getMean(), BaseAttributes.OT_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> NEUTRAL_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 3.00);
    private final static Attribute<Double> NEUTRAL_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.75);
    private final static Attribute<Double> NEUTRAL_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 2.00);
    private final static Attribute<Double> NEUTRAL_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 2.25);
    private final static Attribute<Double> NEUTRAL_AGILITY_IMPORTANCE = new Attribute<>(StatAttributes.AGILITY.getName(), 1.25);
    private final static Attribute<Double> NEUTRAL_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 2.65);
    private final static Attribute<Double> NEUTRAL_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 2.65);

    private OffensiveTackle(final String  subPositionName){
        super(PositionList.OFFENSIVE_TACKLE.getName(), subPositionName, BaseAttributes.OT_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static OffensiveTackle GenerateRunblockOffensiveTackle(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUNBLOCK_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), RUNBLOCK_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_BLOCKING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNBLOCK_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNBLOCK_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNBLOCK_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), RUNBLOCK_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), RUNBLOCK_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNBLOCK_THROW_POWER.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUNBLOCK_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUNBLOCK_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNBLOCK_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUNBLOCK_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
                awarenessAttribute,
                strengthAttribute,
                speedAttribute,
                breakBlockAttribute,
                tackleAttribute,
                runBlockingAttribute,
                passBlockingAttribute,
                accelerationAttribute,
                breakTackleAttribute,
                elusivenessAttribute,
                agilityAttribute,
                injuryAttribute,
                staminaAttribute,
                throwPowerAttribute,
                kickPowerAttribute,
                kickAccuracyAttribute,
                throwAccuracyAttribute,
                routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUNBLOCK_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), RUNBLOCK_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_BLOCKING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNBLOCK_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNBLOCK_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNBLOCK_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), RUNBLOCK_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), RUNBLOCK_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNBLOCK_THROW_POWER.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUNBLOCK_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUNBLOCK_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNBLOCK_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUNBLOCK_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
                awarenessDeviation,
                strengthDeviation,
                speedDeviation,
                breakBlockDeviation,
                tackleDeviation,
                runBlockingDeviation,
                passBlockingDeviation,
                accelerationDeviation,
                breakTackleDeviation,
                elusivenessDeviation,
                agilityDeviation,
                injuryDeviation,
                staminaDeviation,
                throwPowerDeviation,
                kickPowerDeviation,
                kickAccuracyDeviation,
                throwAccuracyDeviation,
                routeRunningDeviation
        );

        final List<Attribute<Double>> buffs = Arrays.asList(
                RUNBLOCK_AGILITY_IMPORTANCE,
                RUNBLOCK_AWARENESS_IMPORTANCE,
                RUNBLOCK_SPEED_IMPORTANCE,
                RUNBLOCK_ACCELERATION_IMPORTANCE,
                RUNBLOCK_STRENGTH_IMPORTANCE,
                RUNBLOCK_PASS_BLOCKING_IMPORTANCE,
                RUNBLOCK_RUN_BLOCKING_IMPORTANCE
        );

        final OffensiveTackle offensiveTackle = new OffensiveTackle(RUNBLOCK_SUBPOSITION_NAME);
        offensiveTackle.setRatingsBuffs(buffs);
        offensiveTackle.overwriteAttributes(attrs);
        offensiveTackle.overwriteDeviations(devs);
        offensiveTackle.seedRating(overallSeed);
        return offensiveTackle;
    }

    public final static OffensiveTackle GeneratePassblockOffensiveTackle(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSBLOCK_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), PASSBLOCK_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_BLOCKING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSBLOCK_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSBLOCK_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSBLOCK_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), PASSBLOCK_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), PASSBLOCK_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSBLOCK_THROW_POWER.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSBLOCK_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSBLOCK_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSBLOCK_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSBLOCK_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
                awarenessAttribute,
                strengthAttribute,
                speedAttribute,
                breakBlockAttribute,
                tackleAttribute,
                runBlockingAttribute,
                passBlockingAttribute,
                accelerationAttribute,
                breakTackleAttribute,
                elusivenessAttribute,
                agilityAttribute,
                injuryAttribute,
                staminaAttribute,
                throwPowerAttribute,
                kickPowerAttribute,
                kickAccuracyAttribute,
                throwAccuracyAttribute,
                routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSBLOCK_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), PASSBLOCK_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_BLOCKING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSBLOCK_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSBLOCK_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSBLOCK_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), PASSBLOCK_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), PASSBLOCK_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSBLOCK_THROW_POWER.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSBLOCK_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSBLOCK_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSBLOCK_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSBLOCK_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
                awarenessDeviation,
                strengthDeviation,
                speedDeviation,
                breakBlockDeviation,
                tackleDeviation,
                runBlockingDeviation,
                passBlockingDeviation,
                accelerationDeviation,
                breakTackleDeviation,
                elusivenessDeviation,
                agilityDeviation,
                injuryDeviation,
                staminaDeviation,
                throwPowerDeviation,
                kickPowerDeviation,
                kickAccuracyDeviation,
                throwAccuracyDeviation,
                routeRunningDeviation
        );

        final List<Attribute<Double>> buffs = Arrays.asList(
                PASSBLOCK_AGILITY_IMPORTANCE,
                PASSBLOCK_AWARENESS_IMPORTANCE,
                PASSBLOCK_SPEED_IMPORTANCE,
                PASSBLOCK_ACCELERATION_IMPORTANCE,
                PASSBLOCK_STRENGTH_IMPORTANCE,
                PASSBLOCK_PASS_BLOCKING_IMPORTANCE,
                PASSBLOCK_RUN_BLOCKING_IMPORTANCE
        );

        final OffensiveTackle offensiveTackle = new OffensiveTackle(PASSBLOCK_SUBPOSITION_NAME);
        offensiveTackle.setRatingsBuffs(buffs);
        offensiveTackle.overwriteAttributes(attrs);
        offensiveTackle.overwriteDeviations(devs);
        offensiveTackle.seedRating(overallSeed);
        return offensiveTackle;
    }

    public final static OffensiveTackle GenerateNeutralOffensiveTackle(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCKING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRAL_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), NEUTRAL_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), NEUTRAL_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), NEUTRAL_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), NEUTRAL_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
                awarenessAttribute,
                strengthAttribute,
                speedAttribute,
                breakBlockAttribute,
                tackleAttribute,
                runBlockingAttribute,
                passBlockingAttribute,
                accelerationAttribute,
                breakTackleAttribute,
                elusivenessAttribute,
                agilityAttribute,
                injuryAttribute,
                staminaAttribute,
                throwPowerAttribute,
                kickPowerAttribute,
                kickAccuracyAttribute,
                throwAccuracyAttribute,
                routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCKING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRAL_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), NEUTRAL_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), NEUTRAL_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), NEUTRAL_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), NEUTRAL_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
                awarenessDeviation,
                strengthDeviation,
                speedDeviation,
                breakBlockDeviation,
                tackleDeviation,
                runBlockingDeviation,
                passBlockingDeviation,
                accelerationDeviation,
                breakTackleDeviation,
                elusivenessDeviation,
                agilityDeviation,
                injuryDeviation,
                staminaDeviation,
                throwPowerDeviation,
                kickPowerDeviation,
                kickAccuracyDeviation,
                throwAccuracyDeviation,
                routeRunningDeviation
        );

        final List<Attribute<Double>> buffs = Arrays.asList(
                NEUTRAL_AGILITY_IMPORTANCE,
                NEUTRAL_AWARENESS_IMPORTANCE,
                NEUTRAL_SPEED_IMPORTANCE,
                NEUTRAL_ACCELERATION_IMPORTANCE,
                NEUTRAL_STRENGTH_IMPORTANCE,
                NEUTRAL_PASS_BLOCKING_IMPORTANCE,
                NEUTRAL_RUN_BLOCKING_IMPORTANCE
        );

        final OffensiveTackle offensiveTackle = new OffensiveTackle(NEUTRAL_SUBPOSITION_NAME);
        offensiveTackle.setRatingsBuffs(buffs);
        offensiveTackle.overwriteAttributes(attrs);
        offensiveTackle.overwriteDeviations(devs);
        offensiveTackle.seedRating(overallSeed);
        return offensiveTackle;
    }

}