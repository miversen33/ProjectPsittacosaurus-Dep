package Position.Defense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class OutsideLinebacker extends Position{

    private final static double POSITION_MEAN_OVERALL = 0.72;

    private final static BaseAttribute BLITZING_AWARENESS = new BaseAttribute(
            BaseAttributes.OLB_AWARENESS.getMean(), BaseAttributes.OLB_AWARENESS.getDeviation());
    private final static BaseAttribute BLITZING_STRENGTH = new BaseAttribute(
            BaseAttributes.OLB_STRENGTH.getMean()+.05, BaseAttributes.OLB_STRENGTH.getDeviation());
    private final static BaseAttribute BLITZING_SPEED = new BaseAttribute(
            BaseAttributes.OLB_SPEED.getMean()+.075, BaseAttributes.OLB_SPEED.getDeviation());
    private final static BaseAttribute BLITZING_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.OLB_BREAK_BLOCK.getMean()+.05, BaseAttributes.OLB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute BLITZING_TACKLE = new BaseAttribute(
            BaseAttributes.OLB_TACKLE.getMean()+.05, BaseAttributes.OLB_TACKLE.getDeviation());
    private final static BaseAttribute BLITZING_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.OLB_RUN_BLOCKING.getMean(), BaseAttributes.OLB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute BLITZING_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.OLB_PASS_BLOCKING.getMean(), BaseAttributes.OLB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute BLITZING_CATCHING = new BaseAttribute(
            BaseAttributes.OLB_CATCHING.getMean()-.1, BaseAttributes.OLB_CATCHING.getDeviation());
    private final static BaseAttribute BLITZING_CARRYING = new BaseAttribute(
            BaseAttributes.OLB_CARRYING.getMean()-.1, BaseAttributes.OLB_CARRYING.getDeviation());
    private final static BaseAttribute BLITZING_ACCELERATION = new BaseAttribute(
            BaseAttributes.OLB_ACCELERATION.getMean()+.05, BaseAttributes.OLB_ACCELERATION.getDeviation());
    private final static BaseAttribute BLITZING_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.OLB_BREAK_TACKLE.getMean(), BaseAttributes.OLB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute BLITZING_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.OLB_ELUSIVENESS.getMean(), BaseAttributes.OLB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute BLITZING_AGILITY = new BaseAttribute(
            BaseAttributes.OLB_AGILITY.getMean(), BaseAttributes.OLB_AGILITY.getDeviation());
    private final static BaseAttribute BLITZING_INJURY = new BaseAttribute(
            BaseAttributes.OLB_INJURY.getMean(), BaseAttributes.OLB_INJURY.getDeviation());
    private final static BaseAttribute BLITZING_STAMINA = new BaseAttribute(
            BaseAttributes.OLB_STAMINA.getMean(), BaseAttributes.OLB_STAMINA.getDeviation());
    private final static BaseAttribute BLITZING_THROW_POWER = new BaseAttribute(
            BaseAttributes.OLB_THROW_POWER.getMean(), BaseAttributes.OLB_THROW_POWER.getDeviation());
    private final static BaseAttribute BLITZING_MAN_COVERAGE = new BaseAttribute(
            BaseAttributes.OLB_MAN_COVERAGE.getMean()-.1, BaseAttributes.OLB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute BLITZING_ZONE_COVERAGE = new BaseAttribute(
            BaseAttributes.OLB_ZONE_COVERAGE.getMean()-.75, BaseAttributes.OLB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute BLITZING_KICK_POWER = new BaseAttribute(
            BaseAttributes.OLB_KICK_POWER.getMean(), BaseAttributes.OLB_KICK_POWER.getDeviation());
    private final static BaseAttribute BLITZING_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.OLB_KICK_ACCURACY.getMean(), BaseAttributes.OLB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute BLITZING_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.OLB_THROW_ACCURACY.getMean(), BaseAttributes.OLB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute BLITZING_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.OLB_ROUTE_RUNNING.getMean(), BaseAttributes.OLB_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute COVERAGE_AWARENESS = new BaseAttribute(
            BaseAttributes.OLB_AWARENESS.getMean()+.025, BaseAttributes.OLB_AWARENESS.getDeviation());
    private final static BaseAttribute COVERAGE_STRENGTH = new BaseAttribute(
            BaseAttributes.OLB_STRENGTH.getMean()-.075, BaseAttributes.OLB_STRENGTH.getDeviation());
    private final static BaseAttribute COVERAGE_SPEED = new BaseAttribute(
            BaseAttributes.OLB_SPEED.getMean(), BaseAttributes.OLB_SPEED.getDeviation());
    private final static BaseAttribute COVERAGE_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.OLB_BREAK_BLOCK.getMean()-.075, BaseAttributes.OLB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute COVERAGE_TACKLE = new BaseAttribute(
            BaseAttributes.OLB_TACKLE.getMean()+.025, BaseAttributes.OLB_TACKLE.getDeviation());
    private final static BaseAttribute COVERAGE_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.OLB_RUN_BLOCKING.getMean(), BaseAttributes.OLB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute COVERAGE_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.OLB_PASS_BLOCKING.getMean(), BaseAttributes.OLB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute COVERAGE_CATCHING = new BaseAttribute(
            BaseAttributes.OLB_CATCHING.getMean()+.075, BaseAttributes.OLB_CATCHING.getDeviation());
    private final static BaseAttribute COVERAGE_CARRYING = new BaseAttribute(
            BaseAttributes.OLB_CARRYING.getMean(), BaseAttributes.OLB_CARRYING.getDeviation());
    private final static BaseAttribute COVERAGE_ACCELERATION = new BaseAttribute(
            BaseAttributes.OLB_ACCELERATION.getMean(), BaseAttributes.OLB_ACCELERATION.getDeviation());
    private final static BaseAttribute COVERAGE_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.OLB_BREAK_TACKLE.getMean(), BaseAttributes.OLB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute COVERAGE_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.OLB_ELUSIVENESS.getMean(), BaseAttributes.OLB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute COVERAGE_AGILITY = new BaseAttribute(
            BaseAttributes.OLB_AGILITY.getMean(), BaseAttributes.OLB_AGILITY.getDeviation());
    private final static BaseAttribute COVERAGE_INJURY = new BaseAttribute(
            BaseAttributes.OLB_INJURY.getMean(), BaseAttributes.OLB_INJURY.getDeviation());
    private final static BaseAttribute COVERAGE_STAMINA = new BaseAttribute(
            BaseAttributes.OLB_STAMINA.getMean(), BaseAttributes.OLB_STAMINA.getDeviation());
    private final static BaseAttribute COVERAGE_THROW_POWER = new BaseAttribute(
            BaseAttributes.OLB_THROW_POWER.getMean(), BaseAttributes.OLB_THROW_POWER.getDeviation());
    private final static BaseAttribute COVERAGE_MAN_COVERAGE = new BaseAttribute(
            BaseAttributes.OLB_MAN_COVERAGE.getMean()+.075, BaseAttributes.OLB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute COVERAGE_ZONE_COVERAGE = new BaseAttribute(
            BaseAttributes.OLB_ZONE_COVERAGE.getMean()+.075, BaseAttributes.OLB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute COVERAGE_KICK_POWER = new BaseAttribute(
            BaseAttributes.OLB_KICK_POWER.getMean(), BaseAttributes.OLB_KICK_POWER.getDeviation());
    private final static BaseAttribute COVERAGE_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.OLB_KICK_ACCURACY.getMean(), BaseAttributes.OLB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute COVERAGE_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.OLB_THROW_ACCURACY.getMean(), BaseAttributes.OLB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute COVERAGE_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.OLB_ROUTE_RUNNING.getMean(), BaseAttributes.OLB_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
            BaseAttributes.OLB_AWARENESS.getMean(), BaseAttributes.OLB_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
            BaseAttributes.OLB_STRENGTH.getMean(), BaseAttributes.OLB_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
            BaseAttributes.OLB_SPEED.getMean(), BaseAttributes.OLB_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.OLB_BREAK_BLOCK.getMean(), BaseAttributes.OLB_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
            BaseAttributes.OLB_TACKLE.getMean(), BaseAttributes.OLB_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.OLB_RUN_BLOCKING.getMean(), BaseAttributes.OLB_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.OLB_PASS_BLOCKING.getMean(), BaseAttributes.OLB_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
            BaseAttributes.OLB_CATCHING.getMean(), BaseAttributes.OLB_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
            BaseAttributes.OLB_CARRYING.getMean(), BaseAttributes.OLB_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
            BaseAttributes.OLB_ACCELERATION.getMean(), BaseAttributes.OLB_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.OLB_BREAK_TACKLE.getMean(), BaseAttributes.OLB_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.OLB_ELUSIVENESS.getMean(), BaseAttributes.OLB_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
            BaseAttributes.OLB_AGILITY.getMean(), BaseAttributes.OLB_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
            BaseAttributes.OLB_INJURY.getMean(), BaseAttributes.OLB_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
            BaseAttributes.OLB_STAMINA.getMean(), BaseAttributes.OLB_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
            BaseAttributes.OLB_THROW_POWER.getMean(), BaseAttributes.OLB_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
            BaseAttributes.OLB_MAN_COVERAGE.getMean(), BaseAttributes.OLB_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
            BaseAttributes.OLB_ZONE_COVERAGE.getMean(), BaseAttributes.OLB_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
            BaseAttributes.OLB_KICK_POWER.getMean(), BaseAttributes.OLB_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.OLB_KICK_ACCURACY.getMean(), BaseAttributes.OLB_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.OLB_THROW_ACCURACY.getMean(), BaseAttributes.OLB_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.OLB_ROUTE_RUNNING.getMean(), BaseAttributes.OLB_ROUTE_RUNNING.getDeviation());

    private OutsideLinebacker(final String  subPositionName){
        super(PositionList.OUTSIDE_LINEBACKER.getName(), subPositionName, BaseAttributes.OLB_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static OutsideLinebacker GenerateBlitzingOutsideLinebacker(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), BLITZING_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), BLITZING_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), BLITZING_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), BLITZING_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), BLITZING_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLITZING_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLITZING_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), BLITZING_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), BLITZING_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLITZING_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), BLITZING_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), BLITZING_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), BLITZING_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), BLITZING_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), BLITZING_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), BLITZING_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), BLITZING_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), BLITZING_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), BLITZING_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), BLITZING_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), BLITZING_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), BLITZING_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), BLITZING_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), BLITZING_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), BLITZING_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), BLITZING_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), BLITZING_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLITZING_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLITZING_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), BLITZING_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), BLITZING_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), BLITZING_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), BLITZING_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), BLITZING_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), BLITZING_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), BLITZING_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), BLITZING_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), BLITZING_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), BLITZING_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), BLITZING_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), BLITZING_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), BLITZING_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), BLITZING_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), BLITZING_ROUTE_RUNNING.getDeviation());

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

        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(SubPositionList.OUTSIDE_LINEBACKER.BLITZING);
        outsideLinebacker.overwriteAttributes(attrs);
        outsideLinebacker.overwriteDeviations(devs);
        outsideLinebacker.seedRating(overallSeed);
        return outsideLinebacker;
    }

    public final static OutsideLinebacker GenerateCoverageOutsideLinebacker(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), COVERAGE_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), COVERAGE_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), COVERAGE_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), COVERAGE_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), COVERAGE_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), COVERAGE_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), COVERAGE_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), COVERAGE_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), COVERAGE_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), COVERAGE_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), COVERAGE_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), COVERAGE_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), COVERAGE_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), COVERAGE_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), COVERAGE_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), COVERAGE_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), COVERAGE_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), COVERAGE_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), COVERAGE_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), COVERAGE_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), COVERAGE_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), COVERAGE_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), COVERAGE_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), COVERAGE_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), COVERAGE_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), COVERAGE_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), COVERAGE_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), COVERAGE_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), COVERAGE_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), COVERAGE_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), COVERAGE_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), COVERAGE_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), COVERAGE_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), COVERAGE_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), COVERAGE_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), COVERAGE_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), COVERAGE_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), COVERAGE_ROUTE_RUNNING.getDeviation());

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

        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(SubPositionList.OUTSIDE_LINEBACKER.COVERAGE);
        outsideLinebacker.overwriteAttributes(attrs);
        outsideLinebacker.overwriteDeviations(devs);
        outsideLinebacker.seedRating(overallSeed);
        return outsideLinebacker;
    }

    public final static OutsideLinebacker GenerateNeutralOutsideLinebacker(final int overallSeed){
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

        final OutsideLinebacker outsideLinebacker = new OutsideLinebacker(SubPositionList.OUTSIDE_LINEBACKER.NEUTRAL);
        outsideLinebacker.overwriteAttributes(attrs);
        outsideLinebacker.overwriteDeviations(devs);
        outsideLinebacker.seedRating(overallSeed);
        return outsideLinebacker;
    }

}