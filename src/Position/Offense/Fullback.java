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

public final class Fullback extends Position{

    private final static double POSITION_MEAN_OVERALL = 0.67;

    private final static BaseAttribute BLOCKING_AWARENESS = new BaseAttribute(
        BaseAttributes.FB_AWARENESS.getMean(), BaseAttributes.FB_AWARENESS.getDeviation());
    private final static BaseAttribute BLOCKING_STRENGTH = new BaseAttribute(
        BaseAttributes.FB_STRENGTH.getMean()+.1, BaseAttributes.FB_STRENGTH.getDeviation());
    private final static BaseAttribute BLOCKING_SPEED = new BaseAttribute(
        BaseAttributes.FB_SPEED.getMean()-.05, BaseAttributes.FB_SPEED.getDeviation());
    private final static BaseAttribute BLOCKING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.FB_BREAK_BLOCK.getMean(), BaseAttributes.FB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute BLOCKING_TACKLE = new BaseAttribute(
        BaseAttributes.FB_TACKLE.getMean(), BaseAttributes.FB_TACKLE.getDeviation());
    private final static BaseAttribute BLOCKING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.FB_RUN_BLOCKING.getMean()+.075, BaseAttributes.FB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute BLOCKING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.FB_PASS_BLOCKING.getMean()+.075, BaseAttributes.FB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute BLOCKING_CATCHING = new BaseAttribute(
        BaseAttributes.FB_CATCHING.getMean()-.05, BaseAttributes.FB_CATCHING.getDeviation());
    private final static BaseAttribute BLOCKING_CARRYING = new BaseAttribute(
        BaseAttributes.FB_CARRYING.getMean(), BaseAttributes.FB_CARRYING.getDeviation());
    private final static BaseAttribute BLOCKING_ACCELERATION = new BaseAttribute(
        BaseAttributes.FB_ACCELERATION.getMean()-.05, BaseAttributes.FB_ACCELERATION.getDeviation());
    private final static BaseAttribute BLOCKING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.FB_BREAK_TACKLE.getMean()-.1, BaseAttributes.FB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute BLOCKING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.FB_ELUSIVENESS.getMean()-.1, BaseAttributes.FB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute BLOCKING_AGILITY = new BaseAttribute(
        BaseAttributes.FB_AGILITY.getMean()-.1, BaseAttributes.FB_AGILITY.getDeviation());
    private final static BaseAttribute BLOCKING_INJURY = new BaseAttribute(
        BaseAttributes.FB_INJURY.getMean(), BaseAttributes.FB_INJURY.getDeviation());
    private final static BaseAttribute BLOCKING_STAMINA = new BaseAttribute(
        BaseAttributes.FB_STAMINA.getMean(), BaseAttributes.FB_STAMINA.getDeviation());
    private final static BaseAttribute BLOCKING_THROW_POWER = new BaseAttribute(
        BaseAttributes.FB_THROW_POWER.getMean(), BaseAttributes.FB_THROW_POWER.getDeviation());
    private final static BaseAttribute BLOCKING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.FB_MAN_COVERAGE.getMean(), BaseAttributes.FB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute BLOCKING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.FB_ZONE_COVERAGE.getMean(), BaseAttributes.FB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute BLOCKING_KICK_POWER = new BaseAttribute(
        BaseAttributes.FB_KICK_POWER.getMean(), BaseAttributes.FB_KICK_POWER.getDeviation());
    private final static BaseAttribute BLOCKING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.FB_KICK_ACCURACY.getMean(), BaseAttributes.FB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute BLOCKING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.FB_THROW_ACCURACY.getMean(), BaseAttributes.FB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute BLOCKING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.FB_ROUTE_RUNNING.getMean(), BaseAttributes.FB_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute RUSHING_AWARENESS = new BaseAttribute(
        BaseAttributes.FB_AWARENESS.getMean(), BaseAttributes.FB_AWARENESS.getDeviation());
    private final static BaseAttribute RUSHING_STRENGTH = new BaseAttribute(
        BaseAttributes.FB_STRENGTH.getMean()-.05, BaseAttributes.FB_STRENGTH.getDeviation());
    private final static BaseAttribute RUSHING_SPEED = new BaseAttribute(
        BaseAttributes.FB_SPEED.getMean()+.1, BaseAttributes.FB_SPEED.getDeviation());
    private final static BaseAttribute RUSHING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.FB_BREAK_BLOCK.getMean(), BaseAttributes.FB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RUSHING_TACKLE = new BaseAttribute(
        BaseAttributes.FB_TACKLE.getMean(), BaseAttributes.FB_TACKLE.getDeviation());
    private final static BaseAttribute RUSHING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.FB_RUN_BLOCKING.getMean()-.10, BaseAttributes.FB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RUSHING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.FB_PASS_BLOCKING.getMean()-.10, BaseAttributes.FB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RUSHING_CATCHING = new BaseAttribute(
        BaseAttributes.FB_CATCHING.getMean()+.05, BaseAttributes.FB_CATCHING.getDeviation());
    private final static BaseAttribute RUSHING_CARRYING = new BaseAttribute(
        BaseAttributes.FB_CARRYING.getMean()+.10, BaseAttributes.FB_CARRYING.getDeviation());
    private final static BaseAttribute RUSHING_ACCELERATION = new BaseAttribute(
        BaseAttributes.FB_ACCELERATION.getMean()+.05, BaseAttributes.FB_ACCELERATION.getDeviation());
    private final static BaseAttribute RUSHING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.FB_BREAK_TACKLE.getMean()+.1, BaseAttributes.FB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute RUSHING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.FB_ELUSIVENESS.getMean()+.05, BaseAttributes.FB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RUSHING_AGILITY = new BaseAttribute(
        BaseAttributes.FB_AGILITY.getMean()+.05, BaseAttributes.FB_AGILITY.getDeviation());
    private final static BaseAttribute RUSHING_INJURY = new BaseAttribute(
        BaseAttributes.FB_INJURY.getMean(), BaseAttributes.FB_INJURY.getDeviation());
    private final static BaseAttribute RUSHING_STAMINA = new BaseAttribute(
        BaseAttributes.FB_STAMINA.getMean(), BaseAttributes.FB_STAMINA.getDeviation());
    private final static BaseAttribute RUSHING_THROW_POWER = new BaseAttribute(
        BaseAttributes.FB_THROW_POWER.getMean(), BaseAttributes.FB_THROW_POWER.getDeviation());
    private final static BaseAttribute RUSHING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.FB_MAN_COVERAGE.getMean(), BaseAttributes.FB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute RUSHING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.FB_ZONE_COVERAGE.getMean(), BaseAttributes.FB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute RUSHING_KICK_POWER = new BaseAttribute(
        BaseAttributes.FB_KICK_POWER.getMean(), BaseAttributes.FB_KICK_POWER.getDeviation());
    private final static BaseAttribute RUSHING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.FB_KICK_ACCURACY.getMean(), BaseAttributes.FB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RUSHING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.FB_THROW_ACCURACY.getMean(), BaseAttributes.FB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute RUSHING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.FB_ROUTE_RUNNING.getMean(), BaseAttributes.FB_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.FB_AWARENESS.getMean(), BaseAttributes.FB_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.FB_STRENGTH.getMean(), BaseAttributes.FB_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.FB_SPEED.getMean(), BaseAttributes.FB_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.FB_BREAK_BLOCK.getMean(), BaseAttributes.FB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.FB_TACKLE.getMean(), BaseAttributes.FB_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.FB_RUN_BLOCKING.getMean(), BaseAttributes.FB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.FB_PASS_BLOCKING.getMean(), BaseAttributes.FB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.FB_CATCHING.getMean(), BaseAttributes.FB_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.FB_CARRYING.getMean(), BaseAttributes.FB_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.FB_ACCELERATION.getMean(), BaseAttributes.FB_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.FB_BREAK_TACKLE.getMean(), BaseAttributes.FB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.FB_ELUSIVENESS.getMean(), BaseAttributes.FB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.FB_AGILITY.getMean(), BaseAttributes.FB_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.FB_INJURY.getMean(), BaseAttributes.FB_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.FB_STAMINA.getMean(), BaseAttributes.FB_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.FB_THROW_POWER.getMean(), BaseAttributes.FB_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.FB_MAN_COVERAGE.getMean(), BaseAttributes.FB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.FB_ZONE_COVERAGE.getMean(), BaseAttributes.FB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.FB_KICK_POWER.getMean(), BaseAttributes.FB_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.FB_KICK_ACCURACY.getMean(), BaseAttributes.FB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.FB_THROW_ACCURACY.getMean(), BaseAttributes.FB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.FB_ROUTE_RUNNING.getMean(), BaseAttributes.FB_ROUTE_RUNNING.getDeviation());
    
    private Fullback(final String  subPositionName){
        super(PositionList.FULLBACK.getName(), subPositionName, BaseAttributes.FB_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static Fullback GenerateBlockingFullback(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), BLOCKING_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), BLOCKING_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), BLOCKING_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), BLOCKING_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), BLOCKING_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), BLOCKING_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLOCKING_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), BLOCKING_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), BLOCKING_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), BLOCKING_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), BLOCKING_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), BLOCKING_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), BLOCKING_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), BLOCKING_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), BLOCKING_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), BLOCKING_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), BLOCKING_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), BLOCKING_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), BLOCKING_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), BLOCKING_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), BLOCKING_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), BLOCKING_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), BLOCKING_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), BLOCKING_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), BLOCKING_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLOCKING_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), BLOCKING_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), BLOCKING_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), BLOCKING_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), BLOCKING_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), BLOCKING_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), BLOCKING_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), BLOCKING_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), BLOCKING_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), BLOCKING_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), BLOCKING_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), BLOCKING_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), BLOCKING_ROUTE_RUNNING.getDeviation());

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

        final Fullback fullback = new Fullback(SubPositionList.FULLBACK.BLOCKING);
        fullback.overwriteAttributes(attrs);
        fullback.overwriteDeviations(devs);
        fullback.seedRating(overallSeed);
        return fullback;
    }

    public final static Fullback GenerateRushingFullback(final int overallSeed){
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

        final Fullback fullback = new Fullback(SubPositionList.FULLBACK.RUSHING);
        fullback.overwriteAttributes(attrs);
        fullback.overwriteDeviations(devs);
        fullback.seedRating(overallSeed);
        return fullback;
    }

    public final static Fullback GenerateNeutralFullback(final int overallSeed){
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

        final Fullback fullback = new Fullback(SubPositionList.FULLBACK.NEUTRAL);
        fullback.overwriteAttributes(attrs);
        fullback.overwriteDeviations(devs);
        fullback.seedRating(overallSeed);
        return fullback;
    }

}