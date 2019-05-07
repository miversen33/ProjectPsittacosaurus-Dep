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

public final class DefensiveEnd extends Position{

    private final static double POSITION_MEAN_OVERALL = 0.75;

    private final static BaseAttribute RUNRUSH_AWARENESS = new BaseAttribute(
        BaseAttributes.DE_AWARENESS.getMean()+.05, BaseAttributes.DE_AWARENESS.getDeviation());
    private final static BaseAttribute RUNRUSH_STRENGTH = new BaseAttribute(
        BaseAttributes.DE_STRENGTH.getMean()+.05, BaseAttributes.DE_STRENGTH.getDeviation());
    private final static BaseAttribute RUNRUSH_SPEED = new BaseAttribute(
        BaseAttributes.DE_SPEED.getMean()-.025, BaseAttributes.DE_SPEED.getDeviation());
    private final static BaseAttribute RUNRUSH_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.DE_BREAK_BLOCK.getMean()+.05, BaseAttributes.DE_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RUNRUSH_TACKLE = new BaseAttribute(
        BaseAttributes.DE_TACKLE.getMean()+.05, BaseAttributes.DE_TACKLE.getDeviation());
    private final static BaseAttribute RUNRUSH_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.DE_RUN_BLOCKING.getMean(), BaseAttributes.DE_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RUNRUSH_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.DE_PASS_BLOCKING.getMean(), BaseAttributes.DE_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RUNRUSH_CATCHING = new BaseAttribute(
        BaseAttributes.DE_CATCHING.getMean(), BaseAttributes.DE_CATCHING.getDeviation());
    private final static BaseAttribute RUNRUSH_CARRYING = new BaseAttribute(
        BaseAttributes.DE_CARRYING.getMean(), BaseAttributes.DE_CARRYING.getDeviation());
    private final static BaseAttribute RUNRUSH_ACCELERATION = new BaseAttribute(
        BaseAttributes.DE_ACCELERATION.getMean(), BaseAttributes.DE_ACCELERATION.getDeviation());
    private final static BaseAttribute RUNRUSH_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.DE_BREAK_TACKLE.getMean(), BaseAttributes.DE_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute RUNRUSH_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.DE_ELUSIVENESS.getMean(), BaseAttributes.DE_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RUNRUSH_AGILITY = new BaseAttribute(
        BaseAttributes.DE_AGILITY.getMean(), BaseAttributes.DE_AGILITY.getDeviation());
    private final static BaseAttribute RUNRUSH_INJURY = new BaseAttribute(
        BaseAttributes.DE_INJURY.getMean(), BaseAttributes.DE_INJURY.getDeviation());
    private final static BaseAttribute RUNRUSH_STAMINA = new BaseAttribute(
        BaseAttributes.DE_STAMINA.getMean(), BaseAttributes.DE_STAMINA.getDeviation());
    private final static BaseAttribute RUNRUSH_THROW_POWER = new BaseAttribute(
        BaseAttributes.DE_THROW_POWER.getMean(), BaseAttributes.DE_THROW_POWER.getDeviation());
    private final static BaseAttribute RUNRUSH_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.DE_MAN_COVERAGE.getMean(), BaseAttributes.DE_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute RUNRUSH_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.DE_ZONE_COVERAGE.getMean(), BaseAttributes.DE_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute RUNRUSH_KICK_POWER = new BaseAttribute(
        BaseAttributes.DE_KICK_POWER.getMean(), BaseAttributes.DE_KICK_POWER.getDeviation());
    private final static BaseAttribute RUNRUSH_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.DE_KICK_ACCURACY.getMean(), BaseAttributes.DE_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RUNRUSH_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.DE_THROW_ACCURACY.getMean(), BaseAttributes.DE_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute RUNRUSH_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.DE_ROUTE_RUNNING.getMean(), BaseAttributes.DE_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute PASSRUSH_AWARENESS = new BaseAttribute(
        BaseAttributes.DE_AWARENESS.getMean()-.05, BaseAttributes.DE_AWARENESS.getDeviation());
    private final static BaseAttribute PASSRUSH_STRENGTH = new BaseAttribute(
        BaseAttributes.DE_STRENGTH.getMean()-.025, BaseAttributes.DE_STRENGTH.getDeviation());
    private final static BaseAttribute PASSRUSH_SPEED = new BaseAttribute(
        BaseAttributes.DE_SPEED.getMean()+.05, BaseAttributes.DE_SPEED.getDeviation());
    private final static BaseAttribute PASSRUSH_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.DE_BREAK_BLOCK.getMean()+.05, BaseAttributes.DE_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute PASSRUSH_TACKLE = new BaseAttribute(
        BaseAttributes.DE_TACKLE.getMean()+.05, BaseAttributes.DE_TACKLE.getDeviation());
    private final static BaseAttribute PASSRUSH_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.DE_RUN_BLOCKING.getMean(), BaseAttributes.DE_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute PASSRUSH_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.DE_PASS_BLOCKING.getMean(), BaseAttributes.DE_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute PASSRUSH_CATCHING = new BaseAttribute(
        BaseAttributes.DE_CATCHING.getMean(), BaseAttributes.DE_CATCHING.getDeviation());
    private final static BaseAttribute PASSRUSH_CARRYING = new BaseAttribute(
        BaseAttributes.DE_CARRYING.getMean(), BaseAttributes.DE_CARRYING.getDeviation());
    private final static BaseAttribute PASSRUSH_ACCELERATION = new BaseAttribute(
        BaseAttributes.DE_ACCELERATION.getMean()+.075, BaseAttributes.DE_ACCELERATION.getDeviation());
    private final static BaseAttribute PASSRUSH_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.DE_BREAK_TACKLE.getMean(), BaseAttributes.DE_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute PASSRUSH_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.DE_ELUSIVENESS.getMean(), BaseAttributes.DE_ELUSIVENESS.getDeviation());
    private final static BaseAttribute PASSRUSH_AGILITY = new BaseAttribute(
        BaseAttributes.DE_AGILITY.getMean(), BaseAttributes.DE_AGILITY.getDeviation());
    private final static BaseAttribute PASSRUSH_INJURY = new BaseAttribute(
        BaseAttributes.DE_INJURY.getMean(), BaseAttributes.DE_INJURY.getDeviation());
    private final static BaseAttribute PASSRUSH_STAMINA = new BaseAttribute(
        BaseAttributes.DE_STAMINA.getMean(), BaseAttributes.DE_STAMINA.getDeviation());
    private final static BaseAttribute PASSRUSH_THROW_POWER = new BaseAttribute(
        BaseAttributes.DE_THROW_POWER.getMean(), BaseAttributes.DE_THROW_POWER.getDeviation());
    private final static BaseAttribute PASSRUSH_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.DE_MAN_COVERAGE.getMean(), BaseAttributes.DE_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute PASSRUSH_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.DE_ZONE_COVERAGE.getMean(), BaseAttributes.DE_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute PASSRUSH_KICK_POWER = new BaseAttribute(
        BaseAttributes.DE_KICK_POWER.getMean(), BaseAttributes.DE_KICK_POWER.getDeviation());
    private final static BaseAttribute PASSRUSH_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.DE_KICK_ACCURACY.getMean(), BaseAttributes.DE_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute PASSRUSH_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.DE_THROW_ACCURACY.getMean(), BaseAttributes.DE_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute PASSRUSH_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.DE_ROUTE_RUNNING.getMean(), BaseAttributes.DE_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.DE_AWARENESS.getMean(), BaseAttributes.DE_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.DE_STRENGTH.getMean(), BaseAttributes.DE_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.DE_SPEED.getMean(), BaseAttributes.DE_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.DE_BREAK_BLOCK.getMean(), BaseAttributes.DE_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.DE_TACKLE.getMean(), BaseAttributes.DE_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.DE_RUN_BLOCKING.getMean(), BaseAttributes.DE_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.DE_PASS_BLOCKING.getMean(), BaseAttributes.DE_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.DE_CATCHING.getMean(), BaseAttributes.DE_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.DE_CARRYING.getMean(), BaseAttributes.DE_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.DE_ACCELERATION.getMean(), BaseAttributes.DE_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.DE_BREAK_TACKLE.getMean(), BaseAttributes.DE_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.DE_ELUSIVENESS.getMean(), BaseAttributes.DE_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.DE_AGILITY.getMean(), BaseAttributes.DE_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.DE_INJURY.getMean(), BaseAttributes.DE_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.DE_STAMINA.getMean(), BaseAttributes.DE_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.DE_THROW_POWER.getMean(), BaseAttributes.DE_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.DE_MAN_COVERAGE.getMean(), BaseAttributes.DE_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.DE_ZONE_COVERAGE.getMean(), BaseAttributes.DE_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.DE_KICK_POWER.getMean(), BaseAttributes.DE_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.DE_KICK_ACCURACY.getMean(), BaseAttributes.DE_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.DE_THROW_ACCURACY.getMean(), BaseAttributes.DE_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.DE_ROUTE_RUNNING.getMean(), BaseAttributes.DE_ROUTE_RUNNING.getDeviation());

    private DefensiveEnd(final String  subPositionName){
        super(PositionList.DEFENSIVE_END.getName(), subPositionName, BaseAttributes.DE_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static DefensiveEnd GenerateRunrushDefensiveEnd(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNRUSH_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNRUSH_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), RUNRUSH_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUNRUSH_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), RUNRUSH_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNRUSH_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNRUSH_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), RUNRUSH_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), RUNRUSH_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNRUSH_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNRUSH_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNRUSH_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), RUNRUSH_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), RUNRUSH_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), RUNRUSH_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNRUSH_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), RUNRUSH_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), RUNRUSH_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUNRUSH_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUNRUSH_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNRUSH_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUNRUSH_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNRUSH_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNRUSH_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), RUNRUSH_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUNRUSH_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), RUNRUSH_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNRUSH_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNRUSH_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), RUNRUSH_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), RUNRUSH_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNRUSH_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNRUSH_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNRUSH_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), RUNRUSH_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), RUNRUSH_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), RUNRUSH_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNRUSH_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), RUNRUSH_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), RUNRUSH_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUNRUSH_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUNRUSH_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNRUSH_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUNRUSH_ROUTE_RUNNING.getDeviation());

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

        final DefensiveEnd defensiveEnd = new DefensiveEnd(SubPositionList.DEFENSIVE_END.RUN_RUSH);
        defensiveEnd.overwriteAttributes(attrs);
        defensiveEnd.overwriteDeviations(devs);
        defensiveEnd.seedRating(overallSeed);
        return defensiveEnd;
    }

    public final static DefensiveEnd GeneratePassrushDefensiveEnd(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSRUSH_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSRUSH_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), PASSRUSH_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSRUSH_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), PASSRUSH_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSRUSH_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSRUSH_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), PASSRUSH_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), PASSRUSH_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSRUSH_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSRUSH_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSRUSH_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), PASSRUSH_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), PASSRUSH_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), PASSRUSH_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSRUSH_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), PASSRUSH_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), PASSRUSH_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSRUSH_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSRUSH_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSRUSH_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSRUSH_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSRUSH_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSRUSH_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), PASSRUSH_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSRUSH_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), PASSRUSH_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSRUSH_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSRUSH_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), PASSRUSH_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), PASSRUSH_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSRUSH_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSRUSH_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSRUSH_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), PASSRUSH_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), PASSRUSH_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), PASSRUSH_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSRUSH_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), PASSRUSH_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), PASSRUSH_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSRUSH_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSRUSH_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSRUSH_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSRUSH_ROUTE_RUNNING.getDeviation());

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

        final DefensiveEnd defensiveEnd = new DefensiveEnd(SubPositionList.DEFENSIVE_END.PASS_RUSH);
        defensiveEnd.overwriteAttributes(attrs);
        defensiveEnd.overwriteDeviations(devs);
        defensiveEnd.seedRating(overallSeed);
        return defensiveEnd;
    }

    public final static DefensiveEnd GenerateNeutralrushDefensiveEnd(final int overallSeed){
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

        final DefensiveEnd defensiveEnd = new DefensiveEnd(SubPositionList.DEFENSIVE_END.NEUTRAL);
        defensiveEnd.overwriteAttributes(attrs);
        defensiveEnd.overwriteDeviations(devs);
        defensiveEnd.seedRating(overallSeed);
        return defensiveEnd;
    }

}