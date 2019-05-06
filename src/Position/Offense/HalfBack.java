package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;
import Position.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class HalfBack extends Position{

    public final static String SPEED_SUBPOSITION_NAME = "Speed";
    public final static String POWER_SUBPOSITION_NAME = "Power";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double POSITION_MEAN_OVERALL = 0.74;

    private final static BaseAttribute SPEED_AWARENESS = new BaseAttribute(
        BaseAttributes.HB_AWARENESS.getMean(), BaseAttributes.HB_AWARENESS.getDeviation());
    private final static BaseAttribute SPEED_STRENGTH = new BaseAttribute(
        BaseAttributes.HB_STRENGTH.getMean()-.1, BaseAttributes.HB_STRENGTH.getDeviation());
    private final static BaseAttribute SPEED_SPEED = new BaseAttribute(
        BaseAttributes.HB_SPEED.getMean()+.1, BaseAttributes.HB_SPEED.getDeviation());
    private final static BaseAttribute SPEED_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.HB_BREAK_BLOCK.getMean()-.1, BaseAttributes.HB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute SPEED_TACKLE = new BaseAttribute(
        BaseAttributes.HB_TACKLE.getMean(), BaseAttributes.HB_TACKLE.getDeviation());
    private final static BaseAttribute SPEED_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.HB_RUN_BLOCKING.getMean()-.05, BaseAttributes.HB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute SPEED_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.HB_PASS_BLOCKING.getMean()-.05, BaseAttributes.HB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute SPEED_CATCHING = new BaseAttribute(
        BaseAttributes.HB_CATCHING.getMean()+.075, BaseAttributes.HB_CATCHING.getDeviation());
    private final static BaseAttribute SPEED_CARRYING = new BaseAttribute(
        BaseAttributes.HB_CARRYING.getMean()-.05, BaseAttributes.HB_CARRYING.getDeviation());
    private final static BaseAttribute SPEED_ACCELERATION = new BaseAttribute(
        BaseAttributes.HB_ACCELERATION.getMean()+.05, BaseAttributes.HB_ACCELERATION.getDeviation());
    private final static BaseAttribute SPEED_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.HB_BREAK_TACKLE.getMean()-.05, BaseAttributes.HB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute SPEED_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.HB_ELUSIVENESS.getMean()+.1, BaseAttributes.HB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute SPEED_AGILITY = new BaseAttribute(
        BaseAttributes.HB_AGILITY.getMean()+.1, BaseAttributes.HB_AGILITY.getDeviation());
    private final static BaseAttribute SPEED_INJURY = new BaseAttribute(
        BaseAttributes.HB_INJURY.getMean(), BaseAttributes.HB_INJURY.getDeviation());
    private final static BaseAttribute SPEED_STAMINA = new BaseAttribute(
        BaseAttributes.HB_STAMINA.getMean(), BaseAttributes.HB_STAMINA.getDeviation());
    private final static BaseAttribute SPEED_THROW_POWER = new BaseAttribute(
        BaseAttributes.HB_THROW_POWER.getMean(), BaseAttributes.HB_THROW_POWER.getDeviation());
    private final static BaseAttribute SPEED_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.HB_MAN_COVERAGE.getMean(), BaseAttributes.HB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute SPEED_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.HB_ZONE_COVERAGE.getMean(), BaseAttributes.HB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute SPEED_KICK_POWER = new BaseAttribute(
        BaseAttributes.HB_KICK_POWER.getMean(), BaseAttributes.HB_KICK_POWER.getDeviation());
    private final static BaseAttribute SPEED_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.HB_KICK_ACCURACY.getMean(), BaseAttributes.HB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute SPEED_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.HB_THROW_ACCURACY.getMean(), BaseAttributes.HB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute SPEED_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.HB_ROUTE_RUNNING.getMean(), BaseAttributes.HB_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> SPEED_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.50);
    private final static Attribute<Double> SPEED_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.15);
    private final static Attribute<Double> SPEED_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 2.20);
    private final static Attribute<Double> SPEED_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 1.05);
    private final static Attribute<Double> SPEED_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 1.05);
    private final static Attribute<Double> SPEED_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 1.45);
    private final static Attribute<Double> SPEED_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.45);
    private final static Attribute<Double> SPEED_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.80);
    private final static Attribute<Double> SPEED_AGILITY_IMPORTANCE = new Attribute<>(StatAttributes.AGILITY.getName(), 1.35);
    private final static Attribute<Double> SPEED_ELUSIVENESS_IMPORTANCE = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), 1.45);
    private final static Attribute<Double> SPEED_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.35);

    private final static BaseAttribute POWER_AWARENESS = new BaseAttribute(
        BaseAttributes.HB_AWARENESS.getMean(), BaseAttributes.HB_AWARENESS.getDeviation());
    private final static BaseAttribute POWER_STRENGTH = new BaseAttribute(
        BaseAttributes.HB_STRENGTH.getMean()+.1, BaseAttributes.HB_STRENGTH.getDeviation());
    private final static BaseAttribute POWER_SPEED = new BaseAttribute(
        BaseAttributes.HB_SPEED.getMean()-.05, BaseAttributes.HB_SPEED.getDeviation());
    private final static BaseAttribute POWER_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.HB_BREAK_BLOCK.getMean(), BaseAttributes.HB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute POWER_TACKLE = new BaseAttribute(
        BaseAttributes.HB_TACKLE.getMean(), BaseAttributes.HB_TACKLE.getDeviation());
    private final static BaseAttribute POWER_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.HB_RUN_BLOCKING.getMean()+.05, BaseAttributes.HB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute POWER_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.HB_PASS_BLOCKING.getMean()+.10, BaseAttributes.HB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute POWER_CATCHING = new BaseAttribute(
        BaseAttributes.HB_CATCHING.getMean(), BaseAttributes.HB_CATCHING.getDeviation());
    private final static BaseAttribute POWER_CARRYING = new BaseAttribute(
        BaseAttributes.HB_CARRYING.getMean()+.10, BaseAttributes.HB_CARRYING.getDeviation());
    private final static BaseAttribute POWER_ACCELERATION = new BaseAttribute(
        BaseAttributes.HB_ACCELERATION.getMean()+.05, BaseAttributes.HB_ACCELERATION.getDeviation());
    private final static BaseAttribute POWER_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.HB_BREAK_TACKLE.getMean()+.10, BaseAttributes.HB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute POWER_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.HB_ELUSIVENESS.getMean()-.05, BaseAttributes.HB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute POWER_AGILITY = new BaseAttribute(
        BaseAttributes.HB_AGILITY.getMean()-.10, BaseAttributes.HB_AGILITY.getDeviation());
    private final static BaseAttribute POWER_INJURY = new BaseAttribute(
        BaseAttributes.HB_INJURY.getMean(), BaseAttributes.HB_INJURY.getDeviation());
    private final static BaseAttribute POWER_STAMINA = new BaseAttribute(
        BaseAttributes.HB_STAMINA.getMean(), BaseAttributes.HB_STAMINA.getDeviation());
    private final static BaseAttribute POWER_THROW_POWER = new BaseAttribute(
        BaseAttributes.HB_THROW_POWER.getMean(), BaseAttributes.HB_THROW_POWER.getDeviation());
    private final static BaseAttribute POWER_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.HB_MAN_COVERAGE.getMean(), BaseAttributes.HB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute POWER_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.HB_ZONE_COVERAGE.getMean(), BaseAttributes.HB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute POWER_KICK_POWER = new BaseAttribute(
        BaseAttributes.HB_KICK_POWER.getMean(), BaseAttributes.HB_KICK_POWER.getDeviation());
    private final static BaseAttribute POWER_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.HB_KICK_ACCURACY.getMean(), BaseAttributes.HB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute POWER_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.HB_THROW_ACCURACY.getMean(), BaseAttributes.HB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute POWER_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.HB_ROUTE_RUNNING.getMean(), BaseAttributes.HB_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> POWER_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.50);
    private final static Attribute<Double> POWER_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.35);
    private final static Attribute<Double> POWER_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.80);
    private final static Attribute<Double> POWER_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 1.15);
    private final static Attribute<Double> POWER_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 1.15);
    private final static Attribute<Double> POWER_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 1.45);
    private final static Attribute<Double> POWER_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.45);
    private final static Attribute<Double> POWER_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.55);
    private final static Attribute<Double> POWER_AGILITY_IMPORTANCE = new Attribute<>(StatAttributes.AGILITY.getName(), 1.40);
    private final static Attribute<Double> POWER_ELUSIVENESS_IMPORTANCE = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), 1.45);
    private final static Attribute<Double> POWER_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.50);

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.HB_AWARENESS.getMean(), BaseAttributes.HB_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.HB_STRENGTH.getMean(), BaseAttributes.HB_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.HB_SPEED.getMean(), BaseAttributes.HB_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.HB_BREAK_BLOCK.getMean(), BaseAttributes.HB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.HB_TACKLE.getMean(), BaseAttributes.HB_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.HB_RUN_BLOCKING.getMean(), BaseAttributes.HB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.HB_PASS_BLOCKING.getMean(), BaseAttributes.HB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.HB_CATCHING.getMean(), BaseAttributes.HB_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.HB_CARRYING.getMean(), BaseAttributes.HB_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.HB_ACCELERATION.getMean(), BaseAttributes.HB_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.HB_BREAK_TACKLE.getMean(), BaseAttributes.HB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.HB_ELUSIVENESS.getMean(), BaseAttributes.HB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.HB_AGILITY.getMean(), BaseAttributes.HB_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.HB_INJURY.getMean(), BaseAttributes.HB_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.HB_STAMINA.getMean(), BaseAttributes.HB_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.HB_THROW_POWER.getMean(), BaseAttributes.HB_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.HB_MAN_COVERAGE.getMean(), BaseAttributes.HB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.HB_ZONE_COVERAGE.getMean(), BaseAttributes.HB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.HB_KICK_POWER.getMean(), BaseAttributes.HB_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.HB_KICK_ACCURACY.getMean(), BaseAttributes.HB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.HB_THROW_ACCURACY.getMean(), BaseAttributes.HB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.HB_ROUTE_RUNNING.getMean(), BaseAttributes.HB_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> NEUTRAL_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.50);
    private final static Attribute<Double> NEUTRAL_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.35);
    private final static Attribute<Double> NEUTRAL_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.80);
    private final static Attribute<Double> NEUTRAL_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 1.15);
    private final static Attribute<Double> NEUTRAL_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 1.15);
    private final static Attribute<Double> NEUTRAL_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 1.50);
    private final static Attribute<Double> NEUTRAL_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.50);
    private final static Attribute<Double> NEUTRAL_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.55);
    private final static Attribute<Double> NEUTRAL_AGILITY_IMPORTANCE = new Attribute<>(StatAttributes.AGILITY.getName(), 1.50);
    private final static Attribute<Double> NEUTRAL_ELUSIVENESS_IMPORTANCE = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), 1.50);
    private final static Attribute<Double> NEUTRAL_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.50);

    private HalfBack(final String  subPositionName){
        super(PositionList.HALFBACK.getName(), subPositionName, BaseAttributes.HB_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static HalfBack GenerateSpeedHalfBack(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), SPEED_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), SPEED_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), SPEED_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), SPEED_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), SPEED_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), SPEED_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), SPEED_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), SPEED_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), SPEED_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), SPEED_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), SPEED_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), SPEED_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), SPEED_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), SPEED_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), SPEED_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), SPEED_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), SPEED_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), SPEED_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), SPEED_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
            awarenessAttribute,
            strengthAttribute,
            speedAttribute,
            breakBlockAttribute,
            tackleAttribute,
            runBlockingAttribute,
            passBlockingAttribute,
            catchingAttribute,
            carryingAttribute,
            accelerationAttribute,
            breakTackleAttribute,
            elusivenessAttribute,
            agilityAttribute,
            injuryAttribute,
            staminaAttribute,
            throwPowerAttribute,
            manCoverageAttribute,
            zoneCoverageAttribute,
            kickPowerAttribute,
            kickAccuracyAttribute,
            throwAccuracyAttribute,
            routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), SPEED_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), SPEED_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), SPEED_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), SPEED_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), SPEED_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), SPEED_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), SPEED_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), SPEED_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), SPEED_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), SPEED_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), SPEED_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), SPEED_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), SPEED_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), SPEED_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), SPEED_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), SPEED_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), SPEED_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), SPEED_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), SPEED_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
            awarenessDeviation,
            strengthDeviation,
            speedDeviation,
            breakBlockDeviation,
            tackleDeviation,
            runBlockingDeviation,
            passBlockingDeviation,
            catchingDeviation,
            carryingDeviation,
            accelerationDeviation,
            breakTackleDeviation,
            elusivenessDeviation,
            agilityDeviation,
            injuryDeviation,
            staminaDeviation,
            throwPowerDeviation,
            manCoverageDeviation,
            zoneCoverageDeviation,
            kickPowerDeviation,
            kickAccuracyDeviation,
            throwAccuracyDeviation,
            routeRunningDeviation
        );

        final List<Attribute<Double>> buffs = Arrays.asList(
                SPEED_ACCELERATION_IMPORTANCE,
                SPEED_AGILITY_IMPORTANCE,
                SPEED_AWARENESS_IMPORTANCE,
                SPEED_CARRYING_IMPORTANCE,
                SPEED_CATCHING_IMPORTANCE,
                SPEED_ELUSIVENESS_IMPORTANCE,
                SPEED_SPEED_IMPORTANCE,
                SPEED_STRENGTH_IMPORTANCE,
                SPEED_BREAK_TACKLE_IMPORTANCE,
                SPEED_PASS_BLOCKING_IMPORTANCE,
                SPEED_RUN_BLOCKING_IMPORTANCE
        );

        final HalfBack halfback = new HalfBack(SPEED_SUBPOSITION_NAME);
        halfback.setRatingsBuffs(buffs);
        halfback.overwriteAttributes(attrs);
        halfback.overwriteDeviations(devs);
        halfback.seedRating(overallSeed);
        return halfback;
    }

    public final static HalfBack GeneratePowerHalfBack(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), POWER_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), POWER_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), POWER_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), POWER_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), POWER_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), POWER_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), POWER_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), POWER_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), POWER_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POWER_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), POWER_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), POWER_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), POWER_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), POWER_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), POWER_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), POWER_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), POWER_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), POWER_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), POWER_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), POWER_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), POWER_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
            awarenessAttribute,
            strengthAttribute,
            speedAttribute,
            breakBlockAttribute,
            tackleAttribute,
            runBlockingAttribute,
            passBlockingAttribute,
            catchingAttribute,
            carryingAttribute,
            accelerationAttribute,
            breakTackleAttribute,
            elusivenessAttribute,
            agilityAttribute,
            injuryAttribute,
            staminaAttribute,
            throwPowerAttribute,
            manCoverageAttribute,
            zoneCoverageAttribute,
            kickPowerAttribute,
            kickAccuracyAttribute,
            throwAccuracyAttribute,
            routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), POWER_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), POWER_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), POWER_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), POWER_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), POWER_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), POWER_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), POWER_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), POWER_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), POWER_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POWER_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), POWER_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), POWER_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), POWER_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), POWER_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), POWER_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), POWER_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), POWER_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), POWER_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), POWER_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), POWER_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), POWER_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
            awarenessDeviation,
            strengthDeviation,
            speedDeviation,
            breakBlockDeviation,
            tackleDeviation,
            runBlockingDeviation,
            passBlockingDeviation,
            catchingDeviation,
            carryingDeviation,
            accelerationDeviation,
            breakTackleDeviation,
            elusivenessDeviation,
            agilityDeviation,
            injuryDeviation,
            staminaDeviation,
            throwPowerDeviation,
            manCoverageDeviation,
            zoneCoverageDeviation,
            kickPowerDeviation,
            kickAccuracyDeviation,
            throwAccuracyDeviation,
            routeRunningDeviation
        );

        final List<Attribute<Double>> buffs = Arrays.asList(
                POWER_ACCELERATION_IMPORTANCE,
                POWER_AGILITY_IMPORTANCE,
                POWER_AWARENESS_IMPORTANCE,
                POWER_CARRYING_IMPORTANCE,
                POWER_CATCHING_IMPORTANCE,
                POWER_ELUSIVENESS_IMPORTANCE,
                POWER_SPEED_IMPORTANCE,
                POWER_STRENGTH_IMPORTANCE,
                POWER_BREAK_TACKLE_IMPORTANCE,
                POWER_PASS_BLOCKING_IMPORTANCE,
                POWER_RUN_BLOCKING_IMPORTANCE
        );

        final HalfBack halfback = new HalfBack(POWER_SUBPOSITION_NAME);
        halfback.setRatingsBuffs(buffs);
        halfback.overwriteAttributes(attrs);
        halfback.overwriteDeviations(devs);
        halfback.seedRating(overallSeed);
        return halfback;
    }

    public final static HalfBack GenerateNeutralHalfBack(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRAL_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_COVERAGE.getMean());
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
            catchingAttribute,
            carryingAttribute,
            accelerationAttribute,
            breakTackleAttribute,
            elusivenessAttribute,
            agilityAttribute,
            injuryAttribute,
            staminaAttribute,
            throwPowerAttribute,
            manCoverageAttribute,
            zoneCoverageAttribute,
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
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), NEUTRAL_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRAL_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRAL_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRAL_ZONE_COVERAGE.getDeviation());
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
            catchingDeviation,
            carryingDeviation,
            accelerationDeviation,
            breakTackleDeviation,
            elusivenessDeviation,
            agilityDeviation,
            injuryDeviation,
            staminaDeviation,
            throwPowerDeviation,
            manCoverageDeviation,
            zoneCoverageDeviation,
            kickPowerDeviation,
            kickAccuracyDeviation,
            throwAccuracyDeviation,
            routeRunningDeviation
        );

        final List<Attribute<Double>> buffs = Arrays.asList(
                NEUTRAL_ACCELERATION_IMPORTANCE,
                NEUTRAL_AGILITY_IMPORTANCE,
                NEUTRAL_AWARENESS_IMPORTANCE,
                NEUTRAL_CARRYING_IMPORTANCE,
                NEUTRAL_CATCHING_IMPORTANCE,
                NEUTRAL_ELUSIVENESS_IMPORTANCE,
                NEUTRAL_SPEED_IMPORTANCE,
                NEUTRAL_STRENGTH_IMPORTANCE,
                NEUTRAL_BREAK_TACKLE_IMPORTANCE,
                NEUTRAL_PASS_BLOCKING_IMPORTANCE,
                NEUTRAL_RUN_BLOCKING_IMPORTANCE
        );

        final HalfBack halfback = new HalfBack(NEUTRAL_SUBPOSITION_NAME);
        halfback.setRatingsBuffs(buffs);
        halfback.overwriteAttributes(attrs);
        halfback.overwriteDeviations(devs);
        halfback.seedRating(overallSeed);
        return halfback;
    }

}