package Position.SpecialTeams;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;
import Position.PositionList;
import Position.BaseAttribute;
import Position.BaseAttributes;

import java.util.Arrays;
import java.util.List;

public final class Punter extends Position{

    public final static String POWER_SUBPOSITION_NAME = "Power";
    public final static String ACCURATE_SUBPOSITION_NAME = "Accurate";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static double POSITION_MEAN_OVERALL = 0.79;

    private final static BaseAttribute POWER_AWARENESS = new BaseAttribute(
            BaseAttributes.P_AWARENESS.getMean(), BaseAttributes.P_AWARENESS.getDeviation());
    private final static BaseAttribute POWER_STRENGTH = new BaseAttribute(
            BaseAttributes.P_STRENGTH.getMean(), BaseAttributes.P_STRENGTH.getDeviation());
    private final static BaseAttribute POWER_SPEED = new BaseAttribute(
            BaseAttributes.P_SPEED.getMean(), BaseAttributes.P_SPEED.getDeviation());
    private final static BaseAttribute POWER_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.P_BREAK_BLOCK.getMean(), BaseAttributes.P_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute POWER_TACKLE = new BaseAttribute(
            BaseAttributes.P_TACKLE.getMean(), BaseAttributes.P_TACKLE.getDeviation());
    private final static BaseAttribute POWER_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.P_RUN_BLOCKING.getMean(), BaseAttributes.P_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute POWER_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.P_PASS_BLOCKING.getMean(), BaseAttributes.P_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute POWER_CATCHING = new BaseAttribute(
            BaseAttributes.P_CATCHING.getMean(), BaseAttributes.P_CATCHING.getDeviation());
    private final static BaseAttribute POWER_CARRYING = new BaseAttribute(
            BaseAttributes.P_CARRYING.getMean(), BaseAttributes.P_CARRYING.getDeviation());
    private final static BaseAttribute POWER_ACCELERATION = new BaseAttribute(
            BaseAttributes.P_ACCELERATION.getMean(), BaseAttributes.P_ACCELERATION.getDeviation());
    private final static BaseAttribute POWER_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.P_BREAK_TACKLE.getMean(), BaseAttributes.P_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute POWER_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.P_ELUSIVENESS.getMean(), BaseAttributes.P_ELUSIVENESS.getDeviation());
    private final static BaseAttribute POWER_AGILITY = new BaseAttribute(
            BaseAttributes.P_AGILITY.getMean(), BaseAttributes.P_AGILITY.getDeviation());
    private final static BaseAttribute POWER_INJURY = new BaseAttribute(
            BaseAttributes.P_INJURY.getMean(), BaseAttributes.P_INJURY.getDeviation());
    private final static BaseAttribute POWER_STAMINA = new BaseAttribute(
            BaseAttributes.P_STAMINA.getMean(), BaseAttributes.P_STAMINA.getDeviation());
    private final static BaseAttribute POWER_THROW_POWER = new BaseAttribute(
            BaseAttributes.P_THROW_POWER.getMean(), BaseAttributes.P_THROW_POWER.getDeviation());
    private final static BaseAttribute POWER_MAN_COVERAGE = new BaseAttribute(
            BaseAttributes.P_MAN_COVERAGE.getMean(), BaseAttributes.P_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute POWER_ZONE_COVERAGE = new BaseAttribute(
            BaseAttributes.P_ZONE_COVERAGE.getMean(), BaseAttributes.P_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute POWER_KICK_POWER = new BaseAttribute(
            BaseAttributes.P_KICK_POWER.getMean()+.025, BaseAttributes.P_KICK_POWER.getDeviation());
    private final static BaseAttribute POWER_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.P_KICK_ACCURACY.getMean()-.025, BaseAttributes.P_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute POWER_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.P_THROW_ACCURACY.getMean(), BaseAttributes.P_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute POWER_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.P_ROUTE_RUNNING.getMean(), BaseAttributes.P_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> POWER_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 3.00);
    private final static Attribute<Double> POWER_KICK_POWER_IMPORTANCE = new Attribute<>(StatAttributes.KICK_POWER.getName(), 3.50);
    private final static Attribute<Double> POWER_KICK_ACCURACY_IMPORTANCE = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), 2.50);
    private final static Attribute<Double> POWER_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 2.25);
    private final static Attribute<Double> POWER_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.TACKLE.getName(), 1.90);
    private final static Attribute<Double> POWER_BREAK_BLOCK_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), 1.75);
    private final static Attribute<Double> POWER_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.75);

    private final static BaseAttribute ACCURATE_AWARENESS = new BaseAttribute(
            BaseAttributes.P_AWARENESS.getMean(), BaseAttributes.P_AWARENESS.getDeviation());
    private final static BaseAttribute ACCURATE_STRENGTH = new BaseAttribute(
            BaseAttributes.P_STRENGTH.getMean(), BaseAttributes.P_STRENGTH.getDeviation());
    private final static BaseAttribute ACCURATE_SPEED = new BaseAttribute(
            BaseAttributes.P_SPEED.getMean(), BaseAttributes.P_SPEED.getDeviation());
    private final static BaseAttribute ACCURATE_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.P_BREAK_BLOCK.getMean(), BaseAttributes.P_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute ACCURATE_TACKLE = new BaseAttribute(
            BaseAttributes.P_TACKLE.getMean(), BaseAttributes.P_TACKLE.getDeviation());
    private final static BaseAttribute ACCURATE_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.P_RUN_BLOCKING.getMean(), BaseAttributes.P_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute ACCURATE_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.P_PASS_BLOCKING.getMean(), BaseAttributes.P_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute ACCURATE_CATCHING = new BaseAttribute(
            BaseAttributes.P_CATCHING.getMean(), BaseAttributes.P_CATCHING.getDeviation());
    private final static BaseAttribute ACCURATE_CARRYING = new BaseAttribute(
            BaseAttributes.P_CARRYING.getMean(), BaseAttributes.P_CARRYING.getDeviation());
    private final static BaseAttribute ACCURATE_ACCELERATION = new BaseAttribute(
            BaseAttributes.P_ACCELERATION.getMean(), BaseAttributes.P_ACCELERATION.getDeviation());
    private final static BaseAttribute ACCURATE_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.P_BREAK_TACKLE.getMean(), BaseAttributes.P_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute ACCURATE_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.P_ELUSIVENESS.getMean(), BaseAttributes.P_ELUSIVENESS.getDeviation());
    private final static BaseAttribute ACCURATE_AGILITY = new BaseAttribute(
            BaseAttributes.P_AGILITY.getMean(), BaseAttributes.P_AGILITY.getDeviation());
    private final static BaseAttribute ACCURATE_INJURY = new BaseAttribute(
            BaseAttributes.P_INJURY.getMean(), BaseAttributes.P_INJURY.getDeviation());
    private final static BaseAttribute ACCURATE_STAMINA = new BaseAttribute(
            BaseAttributes.P_STAMINA.getMean(), BaseAttributes.P_STAMINA.getDeviation());
    private final static BaseAttribute ACCURATE_THROW_POWER = new BaseAttribute(
            BaseAttributes.P_THROW_POWER.getMean(), BaseAttributes.P_THROW_POWER.getDeviation());
    private final static BaseAttribute ACCURATE_MAN_COVERAGE = new BaseAttribute(
            BaseAttributes.P_MAN_COVERAGE.getMean(), BaseAttributes.P_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute ACCURATE_ZONE_COVERAGE = new BaseAttribute(
            BaseAttributes.P_ZONE_COVERAGE.getMean(), BaseAttributes.P_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute ACCURATE_KICK_POWER = new BaseAttribute(
            BaseAttributes.P_KICK_POWER.getMean()-.05, BaseAttributes.P_KICK_POWER.getDeviation());
    private final static BaseAttribute ACCURATE_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.P_KICK_ACCURACY.getMean()+.05, BaseAttributes.P_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute ACCURATE_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.P_THROW_ACCURACY.getMean(), BaseAttributes.P_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute ACCURATE_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.P_ROUTE_RUNNING.getMean(), BaseAttributes.P_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> ACCURATE_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 3.00);
    private final static Attribute<Double> ACCURATE_KICK_POWER_IMPORTANCE = new Attribute<>(StatAttributes.KICK_POWER.getName(), 2.50);
    private final static Attribute<Double> ACCURATE_KICK_ACCURACY_IMPORTANCE = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), 3.50);
    private final static Attribute<Double> ACCURATE_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 2.25);
    private final static Attribute<Double> ACCURATE_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.TACKLE.getName(), 1.90);
    private final static Attribute<Double> ACCURATE_BREAK_BLOCK_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), 1.75);
    private final static Attribute<Double> ACCURATE_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.75);

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
            BaseAttributes.P_AWARENESS.getMean(), BaseAttributes.P_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
            BaseAttributes.P_STRENGTH.getMean(), BaseAttributes.P_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
            BaseAttributes.P_SPEED.getMean(), BaseAttributes.P_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.P_BREAK_BLOCK.getMean(), BaseAttributes.P_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
            BaseAttributes.P_TACKLE.getMean(), BaseAttributes.P_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.P_RUN_BLOCKING.getMean(), BaseAttributes.P_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.P_PASS_BLOCKING.getMean(), BaseAttributes.P_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_CATCHING = new BaseAttribute(
            BaseAttributes.P_CATCHING.getMean(), BaseAttributes.P_CATCHING.getDeviation());
    private final static BaseAttribute NEUTRAL_CARRYING = new BaseAttribute(
            BaseAttributes.P_CARRYING.getMean(), BaseAttributes.P_CARRYING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
            BaseAttributes.P_ACCELERATION.getMean(), BaseAttributes.P_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.P_BREAK_TACKLE.getMean(), BaseAttributes.P_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.P_ELUSIVENESS.getMean(), BaseAttributes.P_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
            BaseAttributes.P_AGILITY.getMean(), BaseAttributes.P_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
            BaseAttributes.P_INJURY.getMean(), BaseAttributes.P_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
            BaseAttributes.P_STAMINA.getMean(), BaseAttributes.P_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
            BaseAttributes.P_THROW_POWER.getMean(), BaseAttributes.P_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_MAN_COVERAGE = new BaseAttribute(
            BaseAttributes.P_MAN_COVERAGE.getMean(), BaseAttributes.P_MAN_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_ZONE_COVERAGE = new BaseAttribute(
            BaseAttributes.P_ZONE_COVERAGE.getMean(), BaseAttributes.P_ZONE_COVERAGE.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
            BaseAttributes.P_KICK_POWER.getMean(), BaseAttributes.P_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.P_KICK_ACCURACY.getMean(), BaseAttributes.P_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.P_THROW_ACCURACY.getMean(), BaseAttributes.P_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.P_ROUTE_RUNNING.getMean(), BaseAttributes.P_ROUTE_RUNNING.getDeviation());
    private final static Attribute<Double> NEUTRAL_AWARENESS_IMPORTANCE = new Attribute<>(StatAttributes.AWARENESS.getName(), 3.00);
    private final static Attribute<Double> NEUTRAL_KICK_POWER_IMPORTANCE = new Attribute<>(StatAttributes.KICK_POWER.getName(), 3.00);
    private final static Attribute<Double> NEUTRAL_KICK_ACCURACY_IMPORTANCE = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), 3.00);
    private final static Attribute<Double> NEUTRAL_SPEED_IMPORTANCE = new Attribute<>(StatAttributes.SPEED.getName(), 2.25);
    private final static Attribute<Double> NEUTRAL_TACKLE_IMPORTANCE = new Attribute<>(StatAttributes.TACKLE.getName(), 1.90);
    private final static Attribute<Double> NEUTRAL_BREAK_BLOCK_IMPORTANCE = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), 1.70);
    private final static Attribute<Double> NEUTRAL_ACCELERATION_IMPORTANCE = new Attribute<>(StatAttributes.ACCELERATION.getName(), 1.70);

    private Punter(final String  subPositionName){
        super(PositionList.KICKER.getName(), subPositionName, BaseAttributes.P_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static Punter GeneratePowerPunter(final int overallSeed){
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
                POWER_AWARENESS_IMPORTANCE,
                POWER_SPEED_IMPORTANCE,
                POWER_TACKLE_IMPORTANCE,
                POWER_BREAK_BLOCK_IMPORTANCE,
                POWER_KICK_ACCURACY_IMPORTANCE,
                POWER_KICK_POWER_IMPORTANCE
        );

        final Punter punter = new Punter(POWER_SUBPOSITION_NAME);
        punter.setRatingsBuffs(buffs);
        punter.overwriteAttributes(attrs);
        punter.overwriteDeviations(devs);
        punter.seedRating(overallSeed);
        return punter;
    }

    public final static Punter GenerateAccuratePunter(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), ACCURATE_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), ACCURATE_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), ACCURATE_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), ACCURATE_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), ACCURATE_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), ACCURATE_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), ACCURATE_PASS_BLOCKING.getMean());
        final Attribute<Double> catchingAttribute = new Attribute<>(StatAttributes.CATCHING.getName(), ACCURATE_CATCHING.getMean());
        final Attribute<Double> carryingAttribute = new Attribute<>(StatAttributes.CARRYING.getName(), ACCURATE_CARRYING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), ACCURATE_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), ACCURATE_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), ACCURATE_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), ACCURATE_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), ACCURATE_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), ACCURATE_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), ACCURATE_THROW_POWER.getMean());
        final Attribute<Double> manCoverageAttribute = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), ACCURATE_MAN_COVERAGE.getMean());
        final Attribute<Double> zoneCoverageAttribute = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), ACCURATE_ZONE_COVERAGE.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), ACCURATE_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), ACCURATE_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), ACCURATE_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), ACCURATE_ROUTE_RUNNING.getMean());

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

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), ACCURATE_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), ACCURATE_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), ACCURATE_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), ACCURATE_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), ACCURATE_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), ACCURATE_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), ACCURATE_PASS_BLOCKING.getDeviation());
        final Attribute<Double> catchingDeviation = new Attribute<>(StatAttributes.CATCHING.getName(), ACCURATE_CATCHING.getDeviation());
        final Attribute<Double> carryingDeviation = new Attribute<>(StatAttributes.CARRYING.getName(), ACCURATE_CARRYING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), ACCURATE_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), ACCURATE_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), ACCURATE_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), ACCURATE_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), ACCURATE_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), ACCURATE_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), ACCURATE_THROW_POWER.getDeviation());
        final Attribute<Double> manCoverageDeviation = new Attribute<>(StatAttributes.MAN_COVERAGE.getName(), ACCURATE_MAN_COVERAGE.getDeviation());
        final Attribute<Double> zoneCoverageDeviation = new Attribute<>(StatAttributes.ZONE_COVERAGE.getName(), ACCURATE_ZONE_COVERAGE.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), ACCURATE_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), ACCURATE_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), ACCURATE_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), ACCURATE_ROUTE_RUNNING.getDeviation());

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
                ACCURATE_ACCELERATION_IMPORTANCE,
                ACCURATE_AWARENESS_IMPORTANCE,
                ACCURATE_SPEED_IMPORTANCE,
                ACCURATE_TACKLE_IMPORTANCE,
                ACCURATE_BREAK_BLOCK_IMPORTANCE,
                ACCURATE_KICK_ACCURACY_IMPORTANCE,
                ACCURATE_KICK_POWER_IMPORTANCE
        );

        final Punter punter = new Punter(ACCURATE_SUBPOSITION_NAME);
        punter.setRatingsBuffs(buffs);
        punter.overwriteAttributes(attrs);
        punter.overwriteDeviations(devs);
        punter.seedRating(overallSeed);
        return punter;
    }

    public final static Punter GenerateNeutralPunter(final int overallSeed){
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
                NEUTRAL_SPEED_IMPORTANCE,
                NEUTRAL_TACKLE_IMPORTANCE,
                NEUTRAL_BREAK_BLOCK_IMPORTANCE,
                NEUTRAL_KICK_ACCURACY_IMPORTANCE,
                NEUTRAL_KICK_POWER_IMPORTANCE
        );

        final Punter punter = new Punter(NEUTRAL_SUBPOSITION_NAME);
        punter.setRatingsBuffs(buffs);
        punter.overwriteAttributes(attrs);
        punter.overwriteDeviations(devs);
        punter.seedRating(overallSeed);
        return punter;
    }

}