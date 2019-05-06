package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;
import Position.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class WideReceiver extends Position{

    public final static String POSSESSION_SUBPOSITION_NAME = "Possession";
    public final static String SPEED_SUBPOSITION_NAME = "Speed";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double POSITION_MEAN_OVERALL = 0.73;

    private final static BaseAttribute POSSESSION_AWARENESS = new BaseAttribute(
        BaseAttributes.WR_AWARENESS.getMean(), BaseAttributes.WR_AWARENESS.getDeviation());
    private final static BaseAttribute POSSESSION_STRENGTH = new BaseAttribute(
        BaseAttributes.WR_STRENGTH.getMean()+.10, BaseAttributes.WR_STRENGTH.getDeviation());
    private final static BaseAttribute POSSESSION_SPEED = new BaseAttribute(
        BaseAttributes.WR_SPEED.getMean()-.025, BaseAttributes.WR_SPEED.getDeviation());
    private final static BaseAttribute POSSESSION_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.WR_BREAK_BLOCK.getMean(), BaseAttributes.WR_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute POSSESSION_TACKLE = new BaseAttribute(
        BaseAttributes.WR_TACKLE.getMean(), BaseAttributes.WR_TACKLE.getDeviation());
    private final static BaseAttribute POSSESSION_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.WR_RUN_BLOCKING.getMean()+.10, BaseAttributes.WR_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute POSSESSION_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.WR_PASS_BLOCKING.getMean()+.075, BaseAttributes.WR_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute POSSESSION_CATCHING = new BaseAttribute(
        BaseAttributes.WR_CATCHING.getMean()+.025, BaseAttributes.WR_CATCHING.getDeviation());
    private final static BaseAttribute POSSESSION_CARRYING = new BaseAttribute(
        BaseAttributes.WR_CARRYING.getMean()+.10, BaseAttributes.WR_CARRYING.getDeviation());
    private final static BaseAttribute POSSESSION_ACCELERATION = new BaseAttribute(
        BaseAttributes.WR_ACCELERATION.getMean()-.05, BaseAttributes.WR_ACCELERATION.getDeviation());
    private final static BaseAttribute POSSESSION_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.WR_BREAK_TACKLE.getMean()+.05, BaseAttributes.WR_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute POSSESSION_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.WR_ELUSIVENESS.getMean()-.05, BaseAttributes.WR_ELUSIVENESS.getDeviation());
    private final static BaseAttribute POSSESSION_AGILITY = new BaseAttribute(
        BaseAttributes.WR_AGILITY.getMean()-.05, BaseAttributes.WR_AGILITY.getDeviation());
    private final static BaseAttribute POSSESSION_INJURY = new BaseAttribute(
        BaseAttributes.WR_INJURY.getMean(), BaseAttributes.WR_INJURY.getDeviation());
    private final static BaseAttribute POSSESSION_STAMINA = new BaseAttribute(
        BaseAttributes.WR_STAMINA.getMean(), BaseAttributes.WR_STAMINA.getDeviation());
    private final static BaseAttribute POSSESSION_THROW_POWER = new BaseAttribute(
        BaseAttributes.WR_THROW_POWER.getMean(), BaseAttributes.WR_THROW_POWER.getDeviation());
    private final static BaseAttribute POSSESSION_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.WR_MAN_COVERAGE.getMean(), BaseAttributes.WR_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute POSSESSION_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.WR_ZONE_COVERAGE.getMean(), BaseAttributes.WR_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute POSSESSION_KICK_POWER = new BaseAttribute(
        BaseAttributes.WR_KICK_POWER.getMean(), BaseAttributes.WR_KICK_POWER.getDeviation());
    private final static BaseAttribute POSSESSION_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.WR_KICK_ACCURACY.getMean(), BaseAttributes.WR_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute POSSESSION_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.WR_THROW_ACCURACY.getMean(), BaseAttributes.WR_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute POSSESSION_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.WR_ROUTE_RUNNING.getMean(), BaseAttributes.WR_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> POSSESSION_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.15);
    private final static Attribute<Double> POSSESSION_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 2.10);
    private final static Attribute<Double> POSSESSION_ROUTE_RUNNING_IMPORTANCE = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), 1.75);
    private final static Attribute<Double> POSSESSION_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.50);
    private final static Attribute<Double> POSSESSION_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.50);
    private final static Attribute<Double> POSSESSION_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.45);
    private final static Attribute<Double> POSSESSION_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.50);
    private final static Attribute<Double> POSSESSION_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.35);
    private final static Attribute<Double> POSSESSION_ELUSIVENESS_IMPORTANCE = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), 1.01);

    private final static BaseAttribute SPEED_AWARENESS = new BaseAttribute(
        BaseAttributes.WR_AWARENESS.getMean()-.05, BaseAttributes.WR_AWARENESS.getDeviation());
    private final static BaseAttribute SPEED_STRENGTH = new BaseAttribute(
        BaseAttributes.WR_STRENGTH.getMean()-.10, BaseAttributes.WR_STRENGTH.getDeviation());
    private final static BaseAttribute SPEED_SPEED = new BaseAttribute(
        BaseAttributes.WR_SPEED.getMean()+.05, BaseAttributes.WR_SPEED.getDeviation());
    private final static BaseAttribute SPEED_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.WR_BREAK_BLOCK.getMean(), BaseAttributes.WR_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute SPEED_TACKLE = new BaseAttribute(
        BaseAttributes.WR_TACKLE.getMean(), BaseAttributes.WR_TACKLE.getDeviation());
    private final static BaseAttribute SPEED_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.WR_RUN_BLOCKING.getMean()-.10, BaseAttributes.WR_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute SPEED_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.WR_PASS_BLOCKING.getMean()-.05, BaseAttributes.WR_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute SPEED_CATCHING = new BaseAttribute(
        BaseAttributes.WR_CATCHING.getMean(), BaseAttributes.WR_CATCHING.getDeviation());
    private final static BaseAttribute SPEED_CARRYING = new BaseAttribute(
        BaseAttributes.WR_CARRYING.getMean(), BaseAttributes.WR_CARRYING.getDeviation());
    private final static BaseAttribute SPEED_ACCELERATION = new BaseAttribute(
        BaseAttributes.WR_ACCELERATION.getMean()+.025, BaseAttributes.WR_ACCELERATION.getDeviation());
    private final static BaseAttribute SPEED_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.WR_BREAK_TACKLE.getMean()-.05, BaseAttributes.WR_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute SPEED_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.WR_ELUSIVENESS.getMean()+.075, BaseAttributes.WR_ELUSIVENESS.getDeviation());
    private final static BaseAttribute SPEED_AGILITY = new BaseAttribute(
        BaseAttributes.WR_AGILITY.getMean()+.025, BaseAttributes.WR_AGILITY.getDeviation());
    private final static BaseAttribute SPEED_INJURY = new BaseAttribute(
        BaseAttributes.WR_INJURY.getMean(), BaseAttributes.WR_INJURY.getDeviation());
    private final static BaseAttribute SPEED_STAMINA = new BaseAttribute(
        BaseAttributes.WR_STAMINA.getMean(), BaseAttributes.WR_STAMINA.getDeviation());
    private final static BaseAttribute SPEED_THROW_POWER = new BaseAttribute(
        BaseAttributes.WR_THROW_POWER.getMean(), BaseAttributes.WR_THROW_POWER.getDeviation());
    private final static BaseAttribute SPEED_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.WR_MAN_COVERAGE.getMean(), BaseAttributes.WR_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute SPEED_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.WR_ZONE_COVERAGE.getMean(), BaseAttributes.WR_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute SPEED_KICK_POWER = new BaseAttribute(
        BaseAttributes.WR_KICK_POWER.getMean(), BaseAttributes.WR_KICK_POWER.getDeviation());
    private final static BaseAttribute SPEED_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.WR_KICK_ACCURACY.getMean(), BaseAttributes.WR_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute SPEED_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.WR_THROW_ACCURACY.getMean(), BaseAttributes.WR_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute SPEED_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.WR_ROUTE_RUNNING.getMean(), BaseAttributes.WR_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> SPEED_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.15);
    private final static Attribute<Double> SPEED_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 2.00);
    private final static Attribute<Double> SPEED_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 1.95);
    private final static Attribute<Double> SPEED_ROUTE_RUNNING_IMPORTANCE = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), 1.85);
    private final static Attribute<Double> SPEED_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.80);
    private final static Attribute<Double> SPEED_ELUSIVENESS_IMPORTANCE = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), 1.45);
    private final static Attribute<Double> SPEED_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.15);
    private final static Attribute<Double> SPEED_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.15);
    private final static Attribute<Double> SPEED_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.10);

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.WR_AWARENESS.getMean(), BaseAttributes.WR_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.WR_STRENGTH.getMean(), BaseAttributes.WR_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.WR_SPEED.getMean(), BaseAttributes.WR_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.WR_BREAK_BLOCK.getMean(), BaseAttributes.WR_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.WR_TACKLE.getMean(), BaseAttributes.WR_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.WR_RUN_BLOCKING.getMean(), BaseAttributes.WR_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.WR_PASS_BLOCKING.getMean(), BaseAttributes.WR_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.WR_CATCHING.getMean(), BaseAttributes.WR_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.WR_CARRYING.getMean(), BaseAttributes.WR_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.WR_ACCELERATION.getMean(), BaseAttributes.WR_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.WR_BREAK_TACKLE.getMean(), BaseAttributes.WR_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.WR_ELUSIVENESS.getMean(), BaseAttributes.WR_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.WR_AGILITY.getMean(), BaseAttributes.WR_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.WR_INJURY.getMean(), BaseAttributes.WR_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.WR_STAMINA.getMean(), BaseAttributes.WR_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.WR_THROW_POWER.getMean(), BaseAttributes.WR_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.WR_MAN_COVERAGE.getMean(), BaseAttributes.WR_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.WR_ZONE_COVERAGE.getMean(), BaseAttributes.WR_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.WR_KICK_POWER.getMean(), BaseAttributes.WR_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.WR_KICK_ACCURACY.getMean(), BaseAttributes.WR_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.WR_THROW_ACCURACY.getMean(), BaseAttributes.WR_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.WR_ROUTE_RUNNING.getMean(), BaseAttributes.WR_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> NEUTRAL_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.15);
    private final static Attribute<Double> NEUTRAL_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 2.00);
    private final static Attribute<Double> NEUTRAL_ROUTE_RUNNING_IMPORTANCE = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), 1.75);
    private final static Attribute<Double> NEUTRAL_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.75);
    private final static Attribute<Double> NEUTRAL_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.60);
    private final static Attribute<Double> NEUTRAL_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.25);
    private final static Attribute<Double> NEUTRAL_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.25);
    private final static Attribute<Double> NEUTRAL_ELUSIVENESS_IMPORTANCE = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), 1.25);
    private final static Attribute<Double> NEUTRAL_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.15);

    private WideReceiver(final String  subPositionName){
        super(PositionList.WIDE_RECEIVER.getName(), subPositionName, BaseAttributes.WR_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static WideReceiver GeneratePossessionWideReceiver(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), POSSESSION_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), POSSESSION_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), POSSESSION_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), POSSESSION_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), POSSESSION_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), POSSESSION_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), POSSESSION_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), POSSESSION_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), POSSESSION_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), POSSESSION_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POSSESSION_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), POSSESSION_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), POSSESSION_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), POSSESSION_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), POSSESSION_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), POSSESSION_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), POSSESSION_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), POSSESSION_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), POSSESSION_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), POSSESSION_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), POSSESSION_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), POSSESSION_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), POSSESSION_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), POSSESSION_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), POSSESSION_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), POSSESSION_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), POSSESSION_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), POSSESSION_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), POSSESSION_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), POSSESSION_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), POSSESSION_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), POSSESSION_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POSSESSION_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), POSSESSION_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), POSSESSION_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), POSSESSION_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), POSSESSION_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), POSSESSION_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), POSSESSION_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), POSSESSION_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), POSSESSION_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), POSSESSION_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), POSSESSION_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), POSSESSION_ROUTE_RUNNING.getDeviation());

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
                POSSESSION_AWARENESS_IMPORTANCE,
                POSSESSION_SPEED_IMPORTANCE,
                POSSESSION_STRENGTH_IMPORTANCE,
                POSSESSION_CATCHING_IMPORTANCE,
                POSSESSION_CARRYING_IMPORTANCE,
                POSSESSION_ELUSIVENESS_IMPORTANCE,
                POSSESSION_ACCELERATION_IMPORTANCE,
                POSSESSION_BREAK_TACKLE_IMPORTANCE,
                POSSESSION_ROUTE_RUNNING_IMPORTANCE
        );

        final WideReceiver widereceiver = new WideReceiver(POSSESSION_SUBPOSITION_NAME);
        widereceiver.setRatingsBuffs(buffs);
        widereceiver.overwriteAttributes(attrs);
        widereceiver.overwriteDeviations(devs);
        widereceiver.seedRating(overallSeed);
        return widereceiver;
    }

    public final static WideReceiver GenerateSpeedWideReceiver(final int overallSeed){
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
                SPEED_AWARENESS_IMPORTANCE,
                SPEED_SPEED_IMPORTANCE,
                SPEED_STRENGTH_IMPORTANCE,
                SPEED_CATCHING_IMPORTANCE,
                SPEED_CARRYING_IMPORTANCE,
                SPEED_ELUSIVENESS_IMPORTANCE,
                SPEED_ACCELERATION_IMPORTANCE,
                SPEED_BREAK_TACKLE_IMPORTANCE,
                SPEED_ROUTE_RUNNING_IMPORTANCE
        );

        final WideReceiver widereceiver = new WideReceiver(SPEED_SUBPOSITION_NAME);
        widereceiver.setRatingsBuffs(buffs);
        widereceiver.overwriteAttributes(attrs);
        widereceiver.overwriteDeviations(devs);
        widereceiver.seedRating(overallSeed);
        return widereceiver;
    }

    public final static WideReceiver GenerateNeutralWideReceiver(final int overallSeed){
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
            NEUTRAL_AWARENESS_IMPORTANCE,
            NEUTRAL_SPEED_IMPORTANCE,
            NEUTRAL_STRENGTH_IMPORTANCE,
            NEUTRAL_CATCHING_IMPORTANCE,
            NEUTRAL_CARRYING_IMPORTANCE,
            NEUTRAL_ELUSIVENESS_IMPORTANCE,
            NEUTRAL_ACCELERATION_IMPORTANCE,
            NEUTRAL_BREAK_TACKLE_IMPORTANCE,
            NEUTRAL_ROUTE_RUNNING_IMPORTANCE
        );

        final WideReceiver widereceiver = new WideReceiver(NEUTRAL_SUBPOSITION_NAME);
        widereceiver.setRatingsBuffs(buffs);
        widereceiver.overwriteAttributes(attrs);
        widereceiver.overwriteDeviations(devs);
        widereceiver.seedRating(overallSeed);
        return widereceiver;
    }

}