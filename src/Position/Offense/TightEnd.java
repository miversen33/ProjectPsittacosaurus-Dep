package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;
import Position.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class TightEnd extends Position{

    public final static String BLOCKING_SUBPOSITION_NAME = "Blocking";
    public final static String RECEIVING_SUBPOSITION_NAME = "Receiving";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double POSITION_MEAN_OVERALL = 0.69;

    private final static BaseAttribute BLOCKING_AWARENESS = new BaseAttribute(
        BaseAttributes.TE_AWARENESS.getMean()+.05, BaseAttributes.TE_AWARENESS.getDeviation());
    private final static BaseAttribute BLOCKING_STRENGTH = new BaseAttribute(
        BaseAttributes.TE_STRENGTH.getMean(), BaseAttributes.TE_STRENGTH.getDeviation());
    private final static BaseAttribute BLOCKING_SPEED = new BaseAttribute(
        BaseAttributes.TE_SPEED.getMean()-.05, BaseAttributes.TE_SPEED.getDeviation());
    private final static BaseAttribute BLOCKING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.TE_BREAK_BLOCK.getMean(), BaseAttributes.TE_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute BLOCKING_TACKLE = new BaseAttribute(
        BaseAttributes.TE_TACKLE.getMean(), BaseAttributes.TE_TACKLE.getDeviation());
    private final static BaseAttribute BLOCKING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.TE_RUN_BLOCKING.getMean()+.05, BaseAttributes.TE_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute BLOCKING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.TE_PASS_BLOCKING.getMean()+.05, BaseAttributes.TE_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute BLOCKING_CATCHING = new BaseAttribute(
        BaseAttributes.TE_CATCHING.getMean()-.05, BaseAttributes.TE_CATCHING.getDeviation());
    private final static BaseAttribute BLOCKING_CARRYING = new BaseAttribute(
        BaseAttributes.TE_CARRYING.getMean(), BaseAttributes.TE_CARRYING.getDeviation());
    private final static BaseAttribute BLOCKING_ACCELERATION = new BaseAttribute(
        BaseAttributes.TE_ACCELERATION.getMean(), BaseAttributes.TE_ACCELERATION.getDeviation());
    private final static BaseAttribute BLOCKING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.TE_BREAK_TACKLE.getMean(), BaseAttributes.TE_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute BLOCKING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.TE_ELUSIVENESS.getMean()-.1, BaseAttributes.TE_ELUSIVENESS.getDeviation());
    private final static BaseAttribute BLOCKING_AGILITY = new BaseAttribute(
        BaseAttributes.TE_AGILITY.getMean()-.1, BaseAttributes.TE_AGILITY.getDeviation());
    private final static BaseAttribute BLOCKING_INJURY = new BaseAttribute(
        BaseAttributes.TE_INJURY.getMean(), BaseAttributes.TE_INJURY.getDeviation());
    private final static BaseAttribute BLOCKING_STAMINA = new BaseAttribute(
        BaseAttributes.TE_STAMINA.getMean(), BaseAttributes.TE_STAMINA.getDeviation());
    private final static BaseAttribute BLOCKING_THROW_POWER = new BaseAttribute(
        BaseAttributes.TE_THROW_POWER.getMean(), BaseAttributes.TE_THROW_POWER.getDeviation());
    private final static BaseAttribute BLOCKING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.TE_MAN_COVERAGE.getMean(), BaseAttributes.TE_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute BLOCKING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.TE_ZONE_COVERAGE.getMean(), BaseAttributes.TE_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute BLOCKING_KICK_POWER = new BaseAttribute(
        BaseAttributes.TE_KICK_POWER.getMean(), BaseAttributes.TE_KICK_POWER.getDeviation());
    private final static BaseAttribute BLOCKING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.TE_KICK_ACCURACY.getMean(), BaseAttributes.TE_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute BLOCKING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.TE_THROW_ACCURACY.getMean(), BaseAttributes.TE_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute BLOCKING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.TE_ROUTE_RUNNING.getMean(), BaseAttributes.TE_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> BLOCKING_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.50);
    private final static Attribute<Double> BLOCKING_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 2.10);
    private final static Attribute<Double> BLOCKING_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.25);
    private final static Attribute<Double> BLOCKING_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 2.0);
    private final static Attribute<Double> BLOCKING_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 2.0);
    private final static Attribute<Double> BLOCKING_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 1.25);
    private final static Attribute<Double> BLOCKING_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.20);
    private final static Attribute<Double> BLOCKING_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.35);
    private final static Attribute<Double> BLOCKING_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.35);

    private final static BaseAttribute RECEIVING_AWARENESS = new BaseAttribute(
        BaseAttributes.TE_AWARENESS.getMean()+.05, BaseAttributes.TE_AWARENESS.getDeviation());
    private final static BaseAttribute RECEIVING_STRENGTH = new BaseAttribute(
        BaseAttributes.TE_STRENGTH.getMean()-.05, BaseAttributes.TE_STRENGTH.getDeviation());
    private final static BaseAttribute RECEIVING_SPEED = new BaseAttribute(
        BaseAttributes.TE_SPEED.getMean()+.05, BaseAttributes.TE_SPEED.getDeviation());
    private final static BaseAttribute RECEIVING_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.TE_BREAK_BLOCK.getMean(), BaseAttributes.TE_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RECEIVING_TACKLE = new BaseAttribute(
        BaseAttributes.TE_TACKLE.getMean(), BaseAttributes.TE_TACKLE.getDeviation());
    private final static BaseAttribute RECEIVING_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.TE_RUN_BLOCKING.getMean()-.05, BaseAttributes.TE_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RECEIVING_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.TE_PASS_BLOCKING.getMean()-.05, BaseAttributes.TE_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RECEIVING_CATCHING = new BaseAttribute(
        BaseAttributes.TE_CATCHING.getMean()+.1, BaseAttributes.TE_CATCHING.getDeviation());
    private final static BaseAttribute RECEIVING_CARRYING = new BaseAttribute(
        BaseAttributes.TE_CARRYING.getMean()+.1, BaseAttributes.TE_CARRYING.getDeviation());
    private final static BaseAttribute RECEIVING_ACCELERATION = new BaseAttribute(
        BaseAttributes.TE_ACCELERATION.getMean(), BaseAttributes.TE_ACCELERATION.getDeviation());
    private final static BaseAttribute RECEIVING_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.TE_BREAK_TACKLE.getMean(), BaseAttributes.TE_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute RECEIVING_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.TE_ELUSIVENESS.getMean(), BaseAttributes.TE_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RECEIVING_AGILITY = new BaseAttribute(
        BaseAttributes.TE_AGILITY.getMean(), BaseAttributes.TE_AGILITY.getDeviation());
    private final static BaseAttribute RECEIVING_INJURY = new BaseAttribute(
        BaseAttributes.TE_INJURY.getMean(), BaseAttributes.TE_INJURY.getDeviation());
    private final static BaseAttribute RECEIVING_STAMINA = new BaseAttribute(
        BaseAttributes.TE_STAMINA.getMean(), BaseAttributes.TE_STAMINA.getDeviation());
    private final static BaseAttribute RECEIVING_THROW_POWER = new BaseAttribute(
        BaseAttributes.TE_THROW_POWER.getMean(), BaseAttributes.TE_THROW_POWER.getDeviation());
    private final static BaseAttribute RECEIVING_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.TE_MAN_COVERAGE.getMean(), BaseAttributes.TE_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute RECEIVING_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.TE_ZONE_COVERAGE.getMean(), BaseAttributes.TE_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute RECEIVING_KICK_POWER = new BaseAttribute(
        BaseAttributes.TE_KICK_POWER.getMean(), BaseAttributes.TE_KICK_POWER.getDeviation());
    private final static BaseAttribute RECEIVING_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.TE_KICK_ACCURACY.getMean(), BaseAttributes.TE_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RECEIVING_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.TE_THROW_ACCURACY.getMean(), BaseAttributes.TE_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute RECEIVING_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.TE_ROUTE_RUNNING.getMean(), BaseAttributes.TE_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> RECEIVING_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.20);
    private final static Attribute<Double> RECEIVING_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 1.70);
    private final static Attribute<Double> RECEIVING_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.50);
    private final static Attribute<Double> RECEIVING_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 1.55);
    private final static Attribute<Double> RECEIVING_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 1.55);
    private final static Attribute<Double> RECEIVING_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 2.00);
    private final static Attribute<Double> RECEIVING_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.40);
    private final static Attribute<Double> RECEIVING_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.15);
    private final static Attribute<Double> RECEIVING_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.55);

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
        BaseAttributes.TE_AWARENESS.getMean(), BaseAttributes.TE_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
        BaseAttributes.TE_STRENGTH.getMean(), BaseAttributes.TE_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
        BaseAttributes.TE_SPEED.getMean(), BaseAttributes.TE_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
        BaseAttributes.TE_BREAK_BLOCK.getMean(), BaseAttributes.TE_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
        BaseAttributes.TE_TACKLE.getMean(), BaseAttributes.TE_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
        BaseAttributes.TE_RUN_BLOCKING.getMean(), BaseAttributes.TE_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
        BaseAttributes.TE_PASS_BLOCKING.getMean(), BaseAttributes.TE_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
        BaseAttributes.TE_CATCHING.getMean(), BaseAttributes.TE_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
        BaseAttributes.TE_CARRYING.getMean(), BaseAttributes.TE_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
        BaseAttributes.TE_ACCELERATION.getMean(), BaseAttributes.TE_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
        BaseAttributes.TE_BREAK_TACKLE.getMean(), BaseAttributes.TE_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
        BaseAttributes.TE_ELUSIVENESS.getMean(), BaseAttributes.TE_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
        BaseAttributes.TE_AGILITY.getMean(), BaseAttributes.TE_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
        BaseAttributes.TE_INJURY.getMean(), BaseAttributes.TE_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
        BaseAttributes.TE_STAMINA.getMean(), BaseAttributes.TE_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
        BaseAttributes.TE_THROW_POWER.getMean(), BaseAttributes.TE_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
        BaseAttributes.TE_MAN_COVERAGE.getMean(), BaseAttributes.TE_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
        BaseAttributes.TE_ZONE_COVERAGE.getMean(), BaseAttributes.TE_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
        BaseAttributes.TE_KICK_POWER.getMean(), BaseAttributes.TE_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
        BaseAttributes.TE_KICK_ACCURACY.getMean(), BaseAttributes.TE_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
        BaseAttributes.TE_THROW_ACCURACY.getMean(), BaseAttributes.TE_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
        BaseAttributes.TE_ROUTE_RUNNING.getMean(), BaseAttributes.TE_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> NEUTRAL_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 2.20);
    private final static Attribute<Double> NEUTRAL_STRENGTH_IMPORTANCE = new Attribute<>(StatAttributes.STRENGTH.getName(), 2.00);
    private final static Attribute<Double> NEUTRAL_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 1.40);
    private final static Attribute<Double> NEUTRAL_RUN_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), 1.75);
    private final static Attribute<Double> NEUTRAL_PASS_BLOCKING_IMPORTANCE = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), 1.75);
    private final static Attribute<Double> NEUTRAL_CATCHING_IMPORTANCE = new Attribute<>(StatAttributes.CATCHING.getName(), 1.75);
    private final static Attribute<Double> NEUTRAL_CARRYING_IMPORTANCE = new Attribute<>(StatAttributes.CARRYING.getName(), 1.40);
    private final static Attribute<Double> NEUTRAL_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.15);
    private final static Attribute<Double> NEUTRAL_BREAK_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), 1.35);

    private TightEnd(final String  subPositionName){
        super(PositionList.TIGHT_END.getName(), subPositionName, BaseAttributes.TE_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static TightEnd GenerateBlockingTightEnd(final int overallSeed){
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

        final List<Attribute<Double>> buffs = Arrays.asList(
            BLOCKING_ACCELERATION_IMPORTANCE,
            BLOCKING_AWARENESS_IMPORTANCE,
            BLOCKING_CARRYING_IMPORTANCE,
            BLOCKING_CATCHING_IMPORTANCE,
            BLOCKING_SPEED_IMPORTANCE,
            BLOCKING_STRENGTH_IMPORTANCE,
            BLOCKING_BREAK_TACKLE_IMPORTANCE,
            BLOCKING_PASS_BLOCKING_IMPORTANCE,
            BLOCKING_RUN_BLOCKING_IMPORTANCE
        );

        final TightEnd tightend = new TightEnd(BLOCKING_SUBPOSITION_NAME);
        tightend.setRatingsBuffs(buffs);
        tightend.overwriteAttributes(attrs);
        tightend.overwriteDeviations(devs);
        tightend.seedRating(overallSeed);
        return tightend;
    }

    public final static TightEnd GenerateReceivingTightEnd(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), RECEIVING_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), RECEIVING_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), RECEIVING_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RECEIVING_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), RECEIVING_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RECEIVING_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RECEIVING_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), RECEIVING_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), RECEIVING_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), RECEIVING_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RECEIVING_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RECEIVING_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), RECEIVING_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), RECEIVING_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), RECEIVING_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), RECEIVING_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), RECEIVING_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), RECEIVING_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), RECEIVING_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RECEIVING_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RECEIVING_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RECEIVING_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), RECEIVING_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), RECEIVING_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), RECEIVING_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RECEIVING_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), RECEIVING_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RECEIVING_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RECEIVING_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), RECEIVING_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), RECEIVING_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), RECEIVING_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RECEIVING_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RECEIVING_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), RECEIVING_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), RECEIVING_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), RECEIVING_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), RECEIVING_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), RECEIVING_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), RECEIVING_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), RECEIVING_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RECEIVING_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RECEIVING_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RECEIVING_ROUTE_RUNNING.getDeviation());

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
            RECEIVING_ACCELERATION_IMPORTANCE,
            RECEIVING_AWARENESS_IMPORTANCE,
            RECEIVING_CARRYING_IMPORTANCE,
            RECEIVING_CATCHING_IMPORTANCE,
            RECEIVING_SPEED_IMPORTANCE,
            RECEIVING_STRENGTH_IMPORTANCE,
            RECEIVING_BREAK_TACKLE_IMPORTANCE,
            RECEIVING_PASS_BLOCKING_IMPORTANCE,
            RECEIVING_RUN_BLOCKING_IMPORTANCE
        );

        final TightEnd tightend = new TightEnd(RECEIVING_SUBPOSITION_NAME);
        tightend.setRatingsBuffs(buffs);
        tightend.overwriteAttributes(attrs);
        tightend.overwriteDeviations(devs);
        tightend.seedRating(overallSeed);
        return tightend;
    }

    public final static TightEnd GenerateNeutralTightEnd(final int overallSeed){
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
            NEUTRAL_AWARENESS_IMPORTANCE,
            NEUTRAL_CARRYING_IMPORTANCE,
            NEUTRAL_CATCHING_IMPORTANCE,
            NEUTRAL_SPEED_IMPORTANCE,
            NEUTRAL_STRENGTH_IMPORTANCE,
            NEUTRAL_BREAK_TACKLE_IMPORTANCE,
            NEUTRAL_PASS_BLOCKING_IMPORTANCE,
            NEUTRAL_RUN_BLOCKING_IMPORTANCE
        );

        final TightEnd tightend = new TightEnd(NEUTRAL_SUBPOSITION_NAME);
        tightend.setRatingsBuffs(buffs);
        tightend.overwriteAttributes(attrs);
        tightend.overwriteDeviations(devs);
        tightend.seedRating(overallSeed);
        return tightend;
    }

}