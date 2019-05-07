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

public final class FreeSafety extends Position{

    private final static double POSITION_MEAN_OVERALL = 0.74;

    private final static BaseAttribute COVERAGE_AWARENESS = new BaseAttribute(
        BaseAttributes.FS_AWARENESS.getMean()+.05, BaseAttributes.FS_AWARENESS.getDeviation());
    private final static BaseAttribute COVERAGE_STRENGTH = new BaseAttribute(
        BaseAttributes.FS_STRENGTH.getMean()-.10, BaseAttributes.FS_STRENGTH.getDeviation());
    private final static BaseAttribute COVERAGE_SPEED = new BaseAttribute(
        BaseAttributes.FS_SPEED.getMean(), BaseAttributes.FS_SPEED.getDeviation());
    private final static BaseAttribute COVERAGE_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.FS_BREAK_BLOCK.getMean()-.10, BaseAttributes.FS_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute COVERAGE_TACKLE = new BaseAttribute(
        BaseAttributes.FS_TACKLE.getMean(), BaseAttributes.FS_TACKLE.getDeviation());
    private final static BaseAttribute COVERAGE_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.FS_RUN_BLOCKING.getMean(), BaseAttributes.FS_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute COVERAGE_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.FS_PASS_BLOCKING.getMean(), BaseAttributes.FS_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute COVERAGE_CATCHING = new BaseAttribute(
        BaseAttributes.FS_CATCHING.getMean()+.10, BaseAttributes.FS_CATCHING.getDeviation());
    private final static BaseAttribute COVERAGE_CARRYING = new BaseAttribute(
        BaseAttributes.FS_CARRYING.getMean()+.025, BaseAttributes.FS_CARRYING.getDeviation());
    private final static BaseAttribute COVERAGE_ACCELERATION = new BaseAttribute(
        BaseAttributes.FS_ACCELERATION.getMean()+.025, BaseAttributes.FS_ACCELERATION.getDeviation());
    private final static BaseAttribute COVERAGE_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.FS_BREAK_TACKLE.getMean()+.025, BaseAttributes.FS_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute COVERAGE_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.FS_ELUSIVENESS.getMean(), BaseAttributes.FS_ELUSIVENESS.getDeviation());
    private final static BaseAttribute COVERAGE_AGILITY = new BaseAttribute(
        BaseAttributes.FS_AGILITY.getMean(), BaseAttributes.FS_AGILITY.getDeviation());
    private final static BaseAttribute COVERAGE_INJURY = new BaseAttribute(
        BaseAttributes.FS_INJURY.getMean(), BaseAttributes.FS_INJURY.getDeviation());
    private final static BaseAttribute COVERAGE_STAMINA = new BaseAttribute(
        BaseAttributes.FS_STAMINA.getMean(), BaseAttributes.FS_STAMINA.getDeviation());
    private final static BaseAttribute COVERAGE_THROW_POWER = new BaseAttribute(
        BaseAttributes.FS_THROW_POWER.getMean(), BaseAttributes.FS_THROW_POWER.getDeviation());
    private final static BaseAttribute COVERAGE_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.FS_MAN_COVERAGE.getMean()+.079, BaseAttributes.FS_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute COVERAGE_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.FS_ZONE_COVERAGE.getMean()+.0507, BaseAttributes.FS_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute COVERAGE_KICK_POWER = new BaseAttribute(
        BaseAttributes.FS_KICK_POWER.getMean(), BaseAttributes.FS_KICK_POWER.getDeviation());
    private final static BaseAttribute COVERAGE_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.FS_KICK_ACCURACY.getMean(), BaseAttributes.FS_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute COVERAGE_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.FS_THROW_ACCURACY.getMean(), BaseAttributes.FS_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute COVERAGE_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.FS_ROUTE_RUNNING.getMean(), BaseAttributes.FS_ROUTE_RUNNING.getDeviation());
    
    private final static BaseAttribute HARDHITTING_AWARENESS = new BaseAttribute(
        BaseAttributes.FS_AWARENESS.getMean()-.05, BaseAttributes.FS_AWARENESS.getDeviation());
    private final static BaseAttribute HARDHITTING_STRENGTH = new BaseAttribute(
        BaseAttributes.FS_STRENGTH.getMean()+.125, BaseAttributes.FS_STRENGTH.getDeviation());
    private final static BaseAttribute HARDHITTING_SPEED = new BaseAttribute(
        BaseAttributes.FS_SPEED.getMean()+.025, BaseAttributes.FS_SPEED.getDeviation());
    private final static BaseAttribute HARDHITTING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.FS_BREAK_BLOCK.getMean()+.05, BaseAttributes.FS_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute HARDHITTING_TACKLE = new BaseAttribute(
        BaseAttributes.FS_TACKLE.getMean()+.076, BaseAttributes.FS_TACKLE.getDeviation());
    private final static BaseAttribute HARDHITTING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.FS_RUN_BLOCKING.getMean(), BaseAttributes.FS_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute HARDHITTING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.FS_PASS_BLOCKING.getMean(), BaseAttributes.FS_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute HARDHITTING_CATCHING = new BaseAttribute(
        BaseAttributes.FS_CATCHING.getMean()-.05, BaseAttributes.FS_CATCHING.getDeviation());
    private final static BaseAttribute HARDHITTING_CARRYING = new BaseAttribute(
        BaseAttributes.FS_CARRYING.getMean()-.05, BaseAttributes.FS_CARRYING.getDeviation());
    private final static BaseAttribute HARDHITTING_ACCELERATION = new BaseAttribute(
        BaseAttributes.FS_ACCELERATION.getMean(), BaseAttributes.FS_ACCELERATION.getDeviation());
    private final static BaseAttribute HARDHITTING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.FS_BREAK_TACKLE.getMean(), BaseAttributes.FS_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute HARDHITTING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.FS_ELUSIVENESS.getMean(), BaseAttributes.FS_ELUSIVENESS.getDeviation());
    private final static BaseAttribute HARDHITTING_AGILITY = new BaseAttribute(
        BaseAttributes.FS_AGILITY.getMean(), BaseAttributes.FS_AGILITY.getDeviation());
    private final static BaseAttribute HARDHITTING_INJURY = new BaseAttribute(
        BaseAttributes.FS_INJURY.getMean(), BaseAttributes.FS_INJURY.getDeviation());
    private final static BaseAttribute HARDHITTING_STAMINA = new BaseAttribute(
        BaseAttributes.FS_STAMINA.getMean(), BaseAttributes.FS_STAMINA.getDeviation());
    private final static BaseAttribute HARDHITTING_THROW_POWER = new BaseAttribute(
        BaseAttributes.FS_THROW_POWER.getMean(), BaseAttributes.FS_THROW_POWER.getDeviation());
    private final static BaseAttribute HARDHITTING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.FS_MAN_COVERAGE.getMean()+.01, BaseAttributes.FS_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute HARDHITTING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.FS_ZONE_COVERAGE.getMean()+.01, BaseAttributes.FS_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute HARDHITTING_KICK_POWER = new BaseAttribute(
        BaseAttributes.FS_KICK_POWER.getMean(), BaseAttributes.FS_KICK_POWER.getDeviation());
    private final static BaseAttribute HARDHITTING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.FS_KICK_ACCURACY.getMean(), BaseAttributes.FS_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute HARDHITTING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.FS_THROW_ACCURACY.getMean(), BaseAttributes.FS_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute HARDHITTING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.FS_ROUTE_RUNNING.getMean(), BaseAttributes.FS_ROUTE_RUNNING.getDeviation());
    
    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.FS_AWARENESS.getMean(), BaseAttributes.FS_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.FS_STRENGTH.getMean(), BaseAttributes.FS_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.FS_SPEED.getMean(), BaseAttributes.FS_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.FS_BREAK_BLOCK.getMean(), BaseAttributes.FS_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.FS_TACKLE.getMean(), BaseAttributes.FS_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.FS_RUN_BLOCKING.getMean(), BaseAttributes.FS_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.FS_PASS_BLOCKING.getMean(), BaseAttributes.FS_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.FS_CATCHING.getMean(), BaseAttributes.FS_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.FS_CARRYING.getMean(), BaseAttributes.FS_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.FS_ACCELERATION.getMean(), BaseAttributes.FS_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.FS_BREAK_TACKLE.getMean(), BaseAttributes.FS_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.FS_ELUSIVENESS.getMean(), BaseAttributes.FS_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.FS_AGILITY.getMean(), BaseAttributes.FS_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.FS_INJURY.getMean(), BaseAttributes.FS_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.FS_STAMINA.getMean(), BaseAttributes.FS_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.FS_THROW_POWER.getMean(), BaseAttributes.FS_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.FS_MAN_COVERAGE.getMean(), BaseAttributes.FS_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.FS_ZONE_COVERAGE.getMean(), BaseAttributes.FS_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.FS_KICK_POWER.getMean(), BaseAttributes.FS_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.FS_KICK_ACCURACY.getMean(), BaseAttributes.FS_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.FS_THROW_ACCURACY.getMean(), BaseAttributes.FS_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.FS_ROUTE_RUNNING.getMean(), BaseAttributes.FS_ROUTE_RUNNING.getDeviation());

    private FreeSafety(final String  subPositionName){
        super(PositionList.FREE_SAFETY.getName(), subPositionName, BaseAttributes.FS_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static FreeSafety GenerateCoverageFreeSafety(final int overallSeed){
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

        final FreeSafety freesafety = new FreeSafety(SubPositionList.FREE_SAFETY.COVERAGE);
        freesafety.overwriteAttributes(attrs);
        freesafety.overwriteDeviations(devs);
        freesafety.seedRating(overallSeed);
        return freesafety;
    }

    public final static FreeSafety GenerateHardhittingFreeSafety(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), HARDHITTING_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), HARDHITTING_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), HARDHITTING_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), HARDHITTING_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), HARDHITTING_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), HARDHITTING_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), HARDHITTING_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), HARDHITTING_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), HARDHITTING_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), HARDHITTING_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), HARDHITTING_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), HARDHITTING_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), HARDHITTING_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), HARDHITTING_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), HARDHITTING_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), HARDHITTING_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), HARDHITTING_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), HARDHITTING_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), HARDHITTING_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), HARDHITTING_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), HARDHITTING_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), HARDHITTING_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), HARDHITTING_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), HARDHITTING_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), HARDHITTING_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), HARDHITTING_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), HARDHITTING_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), HARDHITTING_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), HARDHITTING_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), HARDHITTING_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), HARDHITTING_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), HARDHITTING_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), HARDHITTING_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), HARDHITTING_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), HARDHITTING_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), HARDHITTING_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), HARDHITTING_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), HARDHITTING_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), HARDHITTING_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), HARDHITTING_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), HARDHITTING_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), HARDHITTING_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), HARDHITTING_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), HARDHITTING_ROUTE_RUNNING.getDeviation());

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
        
        final FreeSafety freesafety = new FreeSafety(SubPositionList.FREE_SAFETY.HARDHITTER);
        freesafety.overwriteAttributes(attrs);
        freesafety.overwriteDeviations(devs);
        freesafety.seedRating(overallSeed);
        return freesafety;
    }

    public final static FreeSafety GenerateNeutralFreeSafety(final int overallSeed){
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

        final FreeSafety freesafety = new FreeSafety(SubPositionList.FREE_SAFETY.NEUTRAL);
        freesafety.overwriteAttributes(attrs);
        freesafety.overwriteDeviations(devs);
        freesafety.seedRating(overallSeed);
        return freesafety;
    }

}