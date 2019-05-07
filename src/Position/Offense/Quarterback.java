package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class Quarterback extends Position{

    private final static double POSITION_MEAN_OVERALL = 0.72;

    private final static BaseAttribute RUSHING_AWARENESS = new BaseAttribute(
        BaseAttributes.QB_AWARENESS.getMean()-.075, BaseAttributes.QB_AWARENESS.getDeviation()-.01);
    private final static BaseAttribute RUSHING_STRENGTH = new BaseAttribute(
        BaseAttributes.QB_STRENGTH.getMean()+.05, BaseAttributes.QB_STRENGTH.getDeviation());
    private final static BaseAttribute RUSHING_SPEED = new BaseAttribute(
        BaseAttributes.QB_SPEED.getMean()+.174, BaseAttributes.QB_SPEED.getDeviation()-.015);
    private final static BaseAttribute RUSHING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.QB_BREAK_BLOCK.getMean(), BaseAttributes.QB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RUSHING_TACKLE = new BaseAttribute(
        BaseAttributes.QB_TACKLE.getMean(), BaseAttributes.QB_TACKLE.getDeviation());
    private final static BaseAttribute RUSHING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.QB_RUN_BLOCKING.getMean()+.15, BaseAttributes.QB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RUSHING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.QB_PASS_BLOCKING.getMean()-.01, BaseAttributes.QB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RUSHING_CATCHING = new BaseAttribute(
        BaseAttributes.QB_CATCHING.getMean()+.05, BaseAttributes.QB_CATCHING.getDeviation());
    private final static BaseAttribute RUSHING_CARRYING = new BaseAttribute(
        BaseAttributes.QB_CARRYING.getMean()+.045, BaseAttributes.QB_CARRYING.getDeviation()-.01);
    private final static BaseAttribute RUSHING_ACCELERATION = new BaseAttribute(
        BaseAttributes.QB_ACCELERATION.getMean()+.05, BaseAttributes.QB_ACCELERATION.getDeviation());
    private final static BaseAttribute RUSHING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.QB_BREAK_TACKLE.getMean()+.025, BaseAttributes.QB_BREAK_TACKLE.getDeviation()+.01);
    private final static BaseAttribute RUSHING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.QB_ELUSIVENESS.getMean()+.025, BaseAttributes.QB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RUSHING_AGILITY = new BaseAttribute(
        BaseAttributes.QB_AGILITY.getMean()+.02, BaseAttributes.QB_AGILITY.getDeviation()-.01);
    private final static BaseAttribute RUSHING_INJURY = new BaseAttribute(
        BaseAttributes.QB_INJURY.getMean(), BaseAttributes.QB_INJURY.getDeviation());
    private final static BaseAttribute RUSHING_STAMINA = new BaseAttribute(
        BaseAttributes.QB_STAMINA.getMean(), BaseAttributes.QB_STAMINA.getDeviation());
    private final static BaseAttribute RUSHING_THROW_POWER = new BaseAttribute(
        BaseAttributes.QB_THROW_POWER.getMean()-.015, BaseAttributes.QB_THROW_POWER.getDeviation()+.015);
    private final static BaseAttribute RUSHING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.QB_MAN_COVERAGE.getMean(), BaseAttributes.QB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute RUSHING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.QB_ZONE_COVERAGE.getMean(), BaseAttributes.QB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute RUSHING_KICK_POWER = new BaseAttribute(
        BaseAttributes.QB_KICK_POWER.getMean(), BaseAttributes.QB_KICK_POWER.getDeviation());
    private final static BaseAttribute RUSHING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.QB_KICK_ACCURACY.getMean(), BaseAttributes.QB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RUSHING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.QB_THROW_ACCURACY.getMean()-.04, BaseAttributes.QB_THROW_ACCURACY.getDeviation()+.015);
    private final static BaseAttribute RUSHING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.QB_ROUTE_RUNNING.getMean(), BaseAttributes.QB_ROUTE_RUNNING.getDeviation());
    
    private final static BaseAttribute PASSING_AWARENESS = new BaseAttribute(
        BaseAttributes.QB_AWARENESS.getMean()+.08, BaseAttributes.QB_AWARENESS.getDeviation()-.015);
    private final static BaseAttribute PASSING_STRENGTH = new BaseAttribute(
        BaseAttributes.QB_STRENGTH.getMean()+.075, BaseAttributes.QB_STRENGTH.getDeviation());
    private final static BaseAttribute PASSING_SPEED = new BaseAttribute(
        BaseAttributes.QB_SPEED.getMean()-.025, BaseAttributes.QB_SPEED.getDeviation()-.15);
    private final static BaseAttribute PASSING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.QB_BREAK_BLOCK.getMean(), BaseAttributes.QB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute PASSING_TACKLE = new BaseAttribute(
        BaseAttributes.QB_TACKLE.getMean(), BaseAttributes.QB_TACKLE.getDeviation());
    private final static BaseAttribute PASSING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.QB_RUN_BLOCKING.getMean(), BaseAttributes.QB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute PASSING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.QB_PASS_BLOCKING.getMean(), BaseAttributes.QB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute PASSING_CATCHING = new BaseAttribute(
        BaseAttributes.QB_CATCHING.getMean(), BaseAttributes.QB_CATCHING.getDeviation());
    private final static BaseAttribute PASSING_CARRYING = new BaseAttribute(
        BaseAttributes.QB_CARRYING.getMean()-.067, BaseAttributes.QB_CARRYING.getDeviation()+.01);
    private final static BaseAttribute PASSING_ACCELERATION = new BaseAttribute(
        BaseAttributes.QB_ACCELERATION.getMean()+.05, BaseAttributes.QB_ACCELERATION.getDeviation());
    private final static BaseAttribute PASSING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.QB_BREAK_TACKLE.getMean()+.03, BaseAttributes.QB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute PASSING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.QB_ELUSIVENESS.getMean()-.15, BaseAttributes.QB_ELUSIVENESS.getDeviation()-.01);
    private final static BaseAttribute PASSING_AGILITY = new BaseAttribute(
        BaseAttributes.QB_AGILITY.getMean()-.12, BaseAttributes.QB_AGILITY.getDeviation());
    private final static BaseAttribute PASSING_INJURY = new BaseAttribute(
        BaseAttributes.QB_INJURY.getMean(), BaseAttributes.QB_INJURY.getDeviation());
    private final static BaseAttribute PASSING_STAMINA = new BaseAttribute(
        BaseAttributes.QB_STAMINA.getMean(), BaseAttributes.QB_STAMINA.getDeviation());
    private final static BaseAttribute PASSING_THROW_POWER = new BaseAttribute(
        BaseAttributes.QB_THROW_POWER.getMean()+.11, BaseAttributes.QB_THROW_POWER.getDeviation()-.005);
    private final static BaseAttribute PASSING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.QB_MAN_COVERAGE.getMean(), BaseAttributes.QB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute PASSING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.QB_ZONE_COVERAGE.getMean(), BaseAttributes.QB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute PASSING_KICK_POWER = new BaseAttribute(
        BaseAttributes.QB_KICK_POWER.getMean(), BaseAttributes.QB_KICK_POWER.getDeviation());
    private final static BaseAttribute PASSING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.QB_KICK_ACCURACY.getMean(), BaseAttributes.QB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute PASSING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.QB_THROW_ACCURACY.getMean()+.089, BaseAttributes.QB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute PASSING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.QB_ROUTE_RUNNING.getMean(), BaseAttributes.QB_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.QB_AWARENESS.getMean(), BaseAttributes.QB_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.QB_STRENGTH.getMean(), BaseAttributes.QB_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.QB_SPEED.getMean(), BaseAttributes.QB_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.QB_BREAK_BLOCK.getMean(), BaseAttributes.QB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.QB_TACKLE.getMean(), BaseAttributes.QB_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.QB_RUN_BLOCKING.getMean(), BaseAttributes.QB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.QB_PASS_BLOCKING.getMean(), BaseAttributes.QB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.QB_CATCHING.getMean(), BaseAttributes.QB_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.QB_CARRYING.getMean(), BaseAttributes.QB_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.QB_ACCELERATION.getMean(), BaseAttributes.QB_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.QB_BREAK_TACKLE.getMean(), BaseAttributes.QB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.QB_ELUSIVENESS.getMean(), BaseAttributes.QB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.QB_AGILITY.getMean(), BaseAttributes.QB_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.QB_INJURY.getMean(), BaseAttributes.QB_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.QB_STAMINA.getMean(), BaseAttributes.QB_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.QB_THROW_POWER.getMean(), BaseAttributes.QB_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.QB_MAN_COVERAGE.getMean(), BaseAttributes.QB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.QB_ZONE_COVERAGE.getMean(), BaseAttributes.QB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.QB_KICK_POWER.getMean(), BaseAttributes.QB_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.QB_KICK_ACCURACY.getMean(), BaseAttributes.QB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.QB_THROW_ACCURACY.getMean(), BaseAttributes.QB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.QB_ROUTE_RUNNING.getMean(), BaseAttributes.QB_ROUTE_RUNNING.getDeviation());

    private Quarterback(final String  subPositionName){
        super(PositionList.QUARTERBACK.getName(), subPositionName, BaseAttributes.QB_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static Quarterback GenerateRushingQuarterback(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), RUSHING_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), RUSHING_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), RUSHING_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUSHING_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), RUSHING_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUSHING_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUSHING_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), RUSHING_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), RUSHING_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUSHING_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUSHING_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUSHING_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), RUSHING_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), RUSHING_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), RUSHING_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUSHING_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), RUSHING_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), RUSHING_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUSHING_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUSHING_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUSHING_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUSHING_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), RUSHING_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), RUSHING_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), RUSHING_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUSHING_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), RUSHING_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUSHING_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUSHING_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), RUSHING_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), RUSHING_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUSHING_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUSHING_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUSHING_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), RUSHING_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), RUSHING_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), RUSHING_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUSHING_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), RUSHING_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), RUSHING_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUSHING_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUSHING_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUSHING_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUSHING_ROUTE_RUNNING.getDeviation());

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

        final Quarterback quarterback = new Quarterback(SubPositionList.QUARTERBACK.RUSHING);
        quarterback.overwriteAttributes(attrs);
        quarterback.overwriteDeviations(devs);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

    public final static Quarterback GeneratePassingQuarterback(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSING_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSING_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), PASSING_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSING_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), PASSING_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSING_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSING_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), PASSING_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), PASSING_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSING_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSING_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSING_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), PASSING_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), PASSING_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), PASSING_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSING_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), PASSING_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), PASSING_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSING_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSING_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSING_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSING_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSING_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSING_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), PASSING_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSING_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), PASSING_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSING_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSING_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), PASSING_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), PASSING_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSING_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSING_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSING_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), PASSING_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), PASSING_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), PASSING_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSING_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), PASSING_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), PASSING_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSING_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSING_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSING_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSING_ROUTE_RUNNING.getDeviation());

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

        final Quarterback quarterback = new Quarterback(SubPositionList.QUARTERBACK.PASSING);
        quarterback.overwriteAttributes(attrs);
        quarterback.overwriteDeviations(devs);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

    public final static Quarterback GenerateNeutralQuarterback(final int overallSeed){
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

        final Quarterback quarterback = new Quarterback(SubPositionList.QUARTERBACK.NEUTRAL);
        quarterback.overwriteAttributes(attrs);
        quarterback.overwriteDeviations(devs);
        quarterback.seedRating(overallSeed);
        return quarterback;
    }

}