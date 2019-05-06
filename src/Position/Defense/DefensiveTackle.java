package Position.Defense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;
import Position.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class DefensiveTackle extends Position{

    public final static String RUNRUSH_SUBPOSITION_NAME = "Runrush";
    public final static String PASSRUSH_SUBPOSITION_NAME = "Passrush";
    public final static String NEUTRALRUSH_SUBPOSITION_NAME = "Neutralrush";

    private final static double POSITION_MEAN_OVERALL = 0.74;

    private final static BaseAttribute RUNRUSH_AWARENESS = new BaseAttribute(
        BaseAttributes.DT_AWARENESS.getMean()+.05, BaseAttributes.DT_AWARENESS.getDeviation());
    private final static BaseAttribute RUNRUSH_STRENGTH = new BaseAttribute(
        BaseAttributes.DT_STRENGTH.getMean()+.05, BaseAttributes.DT_STRENGTH.getDeviation());
    private final static BaseAttribute RUNRUSH_SPEED = new BaseAttribute(
        BaseAttributes.DT_SPEED.getMean()-.05, BaseAttributes.DT_SPEED.getDeviation());
    private final static BaseAttribute RUNRUSH_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.DT_BREAK_BLOCK.getMean(), BaseAttributes.DT_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RUNRUSH_TACKLE = new BaseAttribute(
        BaseAttributes.DT_TACKLE.getMean()+.05, BaseAttributes.DT_TACKLE.getDeviation());
    private final static BaseAttribute RUNRUSH_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.DT_RUN_BLOCKING.getMean(), BaseAttributes.DT_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RUNRUSH_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.DT_PASS_BLOCKING.getMean(), BaseAttributes.DT_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RUNRUSH_CATCHING = new BaseAttribute(
        BaseAttributes.DT_CATCHING.getMean(), BaseAttributes.DT_CATCHING.getDeviation());
    private final static BaseAttribute RUNRUSH_CARRYING = new BaseAttribute(
        BaseAttributes.DT_CARRYING.getMean(), BaseAttributes.DT_CARRYING.getDeviation());
    private final static BaseAttribute RUNRUSH_ACCELERATION = new BaseAttribute(
        BaseAttributes.DT_ACCELERATION.getMean()-.05, BaseAttributes.DT_ACCELERATION.getDeviation());
    private final static BaseAttribute RUNRUSH_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.DT_BREAK_TACKLE.getMean(), BaseAttributes.DT_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute RUNRUSH_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.DT_ELUSIVENESS.getMean(), BaseAttributes.DT_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RUNRUSH_AGILITY = new BaseAttribute(
        BaseAttributes.DT_AGILITY.getMean(), BaseAttributes.DT_AGILITY.getDeviation());
    private final static BaseAttribute RUNRUSH_INJURY = new BaseAttribute(
        BaseAttributes.DT_INJURY.getMean(), BaseAttributes.DT_INJURY.getDeviation());
    private final static BaseAttribute RUNRUSH_STAMINA = new BaseAttribute(
        BaseAttributes.DT_STAMINA.getMean(), BaseAttributes.DT_STAMINA.getDeviation());
    private final static BaseAttribute RUNRUSH_THROW_POWER = new BaseAttribute(
        BaseAttributes.DT_THROW_POWER.getMean(), BaseAttributes.DT_THROW_POWER.getDeviation());
    private final static BaseAttribute RUNRUSH_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.DT_MAN_COVERAGE.getMean(), BaseAttributes.DT_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute RUNRUSH_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.DT_ZONE_COVERAGE.getMean(), BaseAttributes.DT_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute RUNRUSH_KICK_POWER = new BaseAttribute(
        BaseAttributes.DT_KICK_POWER.getMean(), BaseAttributes.DT_KICK_POWER.getDeviation());
    private final static BaseAttribute RUNRUSH_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.DT_KICK_ACCURACY.getMean(), BaseAttributes.DT_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RUNRUSH_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.DT_THROW_ACCURACY.getMean(), BaseAttributes.DT_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute RUNRUSH_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.DT_ROUTE_RUNNING.getMean(), BaseAttributes.DT_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> RUNRUSH_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.25);
    private final static Attribute<Double> RUNRUSH_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 3.45);
    private final static Attribute<Double> RUNRUSH_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.15);
    private final static Attribute<Double> RUNRUSH_BREAK_BLOCK_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), 2.00);
    private final static Attribute<Double> RUNRUSH_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.TACKLE.getName(), 3.75);

    private final static BaseAttribute PASSRUSH_AWARENESS = new BaseAttribute(
        BaseAttributes.DT_AWARENESS.getMean()-.05, BaseAttributes.DT_AWARENESS.getDeviation());
    private final static BaseAttribute PASSRUSH_STRENGTH = new BaseAttribute(
        BaseAttributes.DT_STRENGTH.getMean()-.05, BaseAttributes.DT_STRENGTH.getDeviation());
    private final static BaseAttribute PASSRUSH_SPEED = new BaseAttribute(
        BaseAttributes.DT_SPEED.getMean()+.05, BaseAttributes.DT_SPEED.getDeviation());
    private final static BaseAttribute PASSRUSH_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.DT_BREAK_BLOCK.getMean()+.10, BaseAttributes.DT_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute PASSRUSH_TACKLE = new BaseAttribute(
        BaseAttributes.DT_TACKLE.getMean(), BaseAttributes.DT_TACKLE.getDeviation());
    private final static BaseAttribute PASSRUSH_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.DT_RUN_BLOCKING.getMean(), BaseAttributes.DT_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute PASSRUSH_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.DT_PASS_BLOCKING.getMean(), BaseAttributes.DT_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute PASSRUSH_CATCHING = new BaseAttribute(
        BaseAttributes.DT_CATCHING.getMean(), BaseAttributes.DT_CATCHING.getDeviation());
    private final static BaseAttribute PASSRUSH_CARRYING = new BaseAttribute(
        BaseAttributes.DT_CARRYING.getMean(), BaseAttributes.DT_CARRYING.getDeviation());
    private final static BaseAttribute PASSRUSH_ACCELERATION = new BaseAttribute(
        BaseAttributes.DT_ACCELERATION.getMean()+.10, BaseAttributes.DT_ACCELERATION.getDeviation());
    private final static BaseAttribute PASSRUSH_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.DT_BREAK_TACKLE.getMean(), BaseAttributes.DT_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute PASSRUSH_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.DT_ELUSIVENESS.getMean(), BaseAttributes.DT_ELUSIVENESS.getDeviation());
    private final static BaseAttribute PASSRUSH_AGILITY = new BaseAttribute(
        BaseAttributes.DT_AGILITY.getMean(), BaseAttributes.DT_AGILITY.getDeviation());
    private final static BaseAttribute PASSRUSH_INJURY = new BaseAttribute(
        BaseAttributes.DT_INJURY.getMean(), BaseAttributes.DT_INJURY.getDeviation());
    private final static BaseAttribute PASSRUSH_STAMINA = new BaseAttribute(
        BaseAttributes.DT_STAMINA.getMean(), BaseAttributes.DT_STAMINA.getDeviation());
    private final static BaseAttribute PASSRUSH_THROW_POWER = new BaseAttribute(
        BaseAttributes.DT_THROW_POWER.getMean(), BaseAttributes.DT_THROW_POWER.getDeviation());
    private final static BaseAttribute PASSRUSH_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.DT_MAN_COVERAGE.getMean(), BaseAttributes.DT_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute PASSRUSH_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.DT_ZONE_COVERAGE.getMean(), BaseAttributes.DT_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute PASSRUSH_KICK_POWER = new BaseAttribute(
        BaseAttributes.DT_KICK_POWER.getMean(), BaseAttributes.DT_KICK_POWER.getDeviation());
    private final static BaseAttribute PASSRUSH_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.DT_KICK_ACCURACY.getMean(), BaseAttributes.DT_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute PASSRUSH_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.DT_THROW_ACCURACY.getMean(), BaseAttributes.DT_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute PASSRUSH_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.DT_ROUTE_RUNNING.getMean(), BaseAttributes.DT_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> PASSRUSH_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.30);
    private final static Attribute<Double> PASSRUSH_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 3.00);
    private final static Attribute<Double> PASSRUSH_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.85);
    private final static Attribute<Double> PASSRUSH_BREAK_BLOCK_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), 2.00);
    private final static Attribute<Double> PASSRUSH_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.TACKLE.getName(), 3.55);

    private final static BaseAttribute NEUTRALRUSH_AWARENESS = new BaseAttribute(
        BaseAttributes.DT_AWARENESS.getMean(), BaseAttributes.DT_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_STRENGTH = new BaseAttribute(
        BaseAttributes.DT_STRENGTH.getMean(), BaseAttributes.DT_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_SPEED = new BaseAttribute(
        BaseAttributes.DT_SPEED.getMean(), BaseAttributes.DT_SPEED.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.DT_BREAK_BLOCK.getMean(), BaseAttributes.DT_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_TACKLE = new BaseAttribute(
        BaseAttributes.DT_TACKLE.getMean(), BaseAttributes.DT_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.DT_RUN_BLOCKING.getMean(), BaseAttributes.DT_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.DT_PASS_BLOCKING.getMean(), BaseAttributes.DT_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_CATCHING = new BaseAttribute(
        BaseAttributes.DT_CATCHING.getMean(), BaseAttributes.DT_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_CARRYING = new BaseAttribute(
        BaseAttributes.DT_CARRYING.getMean(), BaseAttributes.DT_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_ACCELERATION = new BaseAttribute(
        BaseAttributes.DT_ACCELERATION.getMean(), BaseAttributes.DT_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.DT_BREAK_TACKLE.getMean(), BaseAttributes.DT_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.DT_ELUSIVENESS.getMean(), BaseAttributes.DT_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_AGILITY = new BaseAttribute(
        BaseAttributes.DT_AGILITY.getMean(), BaseAttributes.DT_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_INJURY = new BaseAttribute(
        BaseAttributes.DT_INJURY.getMean(), BaseAttributes.DT_INJURY.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_STAMINA = new BaseAttribute(
        BaseAttributes.DT_STAMINA.getMean(), BaseAttributes.DT_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_THROW_POWER = new BaseAttribute(
        BaseAttributes.DT_THROW_POWER.getMean(), BaseAttributes.DT_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.DT_MAN_COVERAGE.getMean(), BaseAttributes.DT_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.DT_ZONE_COVERAGE.getMean(), BaseAttributes.DT_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_KICK_POWER = new BaseAttribute(
        BaseAttributes.DT_KICK_POWER.getMean(), BaseAttributes.DT_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.DT_KICK_ACCURACY.getMean(), BaseAttributes.DT_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.DT_THROW_ACCURACY.getMean(), BaseAttributes.DT_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRALRUSH_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.DT_ROUTE_RUNNING.getMean(), BaseAttributes.DT_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> NEUTRAL_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.30);
    private final static Attribute<Double> NEUTRAL_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 3.15);
    private final static Attribute<Double> NEUTRAL_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.40);
    private final static Attribute<Double> NEUTRAL_BREAK_BLOCK_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), 2.00);
    private final static Attribute<Double> NEUTRAL_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.TACKLE.getName(), 3.75);
    
    private DefensiveTackle(final String  subPositionName){
        super(PositionList.DEFENSIVE_TACKLE.getName(), subPositionName, BaseAttributes.DT_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static DefensiveTackle GenerateRunrushDefensiveTackle(final int overallSeed){
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

        final List<Attribute<Double>> buffs = Arrays.asList(
                RUNRUSH_AWARENESS_IMPORTANCE,
                RUNRUSH_BREAK_BLOCK_IMPORTANCE,
                RUNRUSH_SPEED_IMPORTANCE,
                RUNRUSH_STRENGTH_IMPORTANCE,
                RUNRUSH_TACKLE_IMPORTANCE
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(RUNRUSH_SUBPOSITION_NAME);
        defensiveTackle.setRatingsBuffs(buffs);
        defensiveTackle.overwriteAttributes(attrs);
        defensiveTackle.overwriteDeviations(devs);
        defensiveTackle.seedRating(overallSeed);
        return defensiveTackle;
    }

    public final static DefensiveTackle GeneratePassrushDefensiveTackle(final int overallSeed){
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

        final List<Attribute<Double>> buffs = Arrays.asList(
                PASSRUSH_AWARENESS_IMPORTANCE,
                PASSRUSH_BREAK_BLOCK_IMPORTANCE,
                PASSRUSH_SPEED_IMPORTANCE,
                PASSRUSH_STRENGTH_IMPORTANCE,
                PASSRUSH_TACKLE_IMPORTANCE
        );
        
        final DefensiveTackle defensiveTackle = new DefensiveTackle(PASSRUSH_SUBPOSITION_NAME);
        defensiveTackle.setRatingsBuffs(buffs);
        defensiveTackle.overwriteAttributes(attrs);
        defensiveTackle.overwriteDeviations(devs);
        defensiveTackle.seedRating(overallSeed);
        return defensiveTackle;
    }

    public final static DefensiveTackle GenerateNeutralrushDefensiveTackle(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRALRUSH_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRALRUSH_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRALRUSH_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRALRUSH_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRALRUSH_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRALRUSH_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRALRUSH_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRALRUSH_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), NEUTRALRUSH_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRALRUSH_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRALRUSH_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRALRUSH_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRALRUSH_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRALRUSH_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRALRUSH_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRALRUSH_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRALRUSH_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRALRUSH_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), NEUTRALRUSH_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), NEUTRALRUSH_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), NEUTRALRUSH_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), NEUTRALRUSH_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRALRUSH_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRALRUSH_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRALRUSH_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRALRUSH_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRALRUSH_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRALRUSH_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRALRUSH_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRALRUSH_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), NEUTRALRUSH_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRALRUSH_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRALRUSH_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRALRUSH_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRALRUSH_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRALRUSH_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRALRUSH_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRALRUSH_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), NEUTRALRUSH_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), NEUTRALRUSH_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), NEUTRALRUSH_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), NEUTRALRUSH_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), NEUTRALRUSH_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), NEUTRALRUSH_ROUTE_RUNNING.getDeviation());

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
                NEUTRAL_BREAK_BLOCK_IMPORTANCE,
                NEUTRAL_SPEED_IMPORTANCE,
                NEUTRAL_STRENGTH_IMPORTANCE,
                NEUTRAL_TACKLE_IMPORTANCE
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(NEUTRALRUSH_SUBPOSITION_NAME);
        defensiveTackle.setRatingsBuffs(buffs);
        defensiveTackle.overwriteAttributes(attrs);
        defensiveTackle.overwriteDeviations(devs);
        defensiveTackle.seedRating(overallSeed);
        return defensiveTackle;
    }

}