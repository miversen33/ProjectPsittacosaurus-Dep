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

public final class Guard extends Position{

    private final static double POSITION_MEAN_OVERALL = 0.7;

    private final static BaseAttribute RUNBLOCK_AWARENESS = new BaseAttribute(
            BaseAttributes.G_AWARENESS.getMean(), BaseAttributes.G_AWARENESS.getDeviation());
    private final static BaseAttribute RUNBLOCK_STRENGTH = new BaseAttribute(
            BaseAttributes.G_STRENGTH.getMean()-.05, BaseAttributes.G_STRENGTH.getDeviation());
    private final static BaseAttribute RUNBLOCK_SPEED = new BaseAttribute(
            BaseAttributes.G_SPEED.getMean()+.05, BaseAttributes.G_SPEED.getDeviation());
    private final static BaseAttribute RUNBLOCK_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.G_BREAK_BLOCK.getMean(), BaseAttributes.G_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute RUNBLOCK_TACKLE = new BaseAttribute(
            BaseAttributes.G_TACKLE.getMean(), BaseAttributes.G_TACKLE.getDeviation());
    private final static BaseAttribute RUNBLOCK_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.G_RUN_BLOCKING.getMean()+.15, BaseAttributes.G_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute RUNBLOCK_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.G_PASS_BLOCKING.getMean()-.15, BaseAttributes.G_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute RUNBLOCK_ACCELERATION = new BaseAttribute(
            BaseAttributes.G_ACCELERATION.getMean()+.05, BaseAttributes.G_ACCELERATION.getDeviation());
    private final static BaseAttribute RUNBLOCK_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.G_BREAK_TACKLE.getMean(), BaseAttributes.G_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute RUNBLOCK_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.G_ELUSIVENESS.getMean(), BaseAttributes.G_ELUSIVENESS.getDeviation());
    private final static BaseAttribute RUNBLOCK_AGILITY = new BaseAttribute(
            BaseAttributes.G_AGILITY.getMean(), BaseAttributes.G_AGILITY.getDeviation());
    private final static BaseAttribute RUNBLOCK_INJURY = new BaseAttribute(
            BaseAttributes.G_INJURY.getMean(), BaseAttributes.G_INJURY.getDeviation());
    private final static BaseAttribute RUNBLOCK_STAMINA = new BaseAttribute(
            BaseAttributes.G_STAMINA.getMean(), BaseAttributes.G_STAMINA.getDeviation());
    private final static BaseAttribute RUNBLOCK_THROW_POWER = new BaseAttribute(
            BaseAttributes.G_THROW_POWER.getMean(), BaseAttributes.G_THROW_POWER.getDeviation());
    private final static BaseAttribute RUNBLOCK_KICK_POWER = new BaseAttribute(
            BaseAttributes.G_KICK_POWER.getMean(), BaseAttributes.G_KICK_POWER.getDeviation());
    private final static BaseAttribute RUNBLOCK_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.G_KICK_ACCURACY.getMean(), BaseAttributes.G_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute RUNBLOCK_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.G_THROW_ACCURACY.getMean(), BaseAttributes.G_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute RUNBLOCK_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.G_ROUTE_RUNNING.getMean(), BaseAttributes.G_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute PASSBLOCK_AWARENESS = new BaseAttribute(
            BaseAttributes.G_AWARENESS.getMean(), BaseAttributes.G_AWARENESS.getDeviation());
    private final static BaseAttribute PASSBLOCK_STRENGTH = new BaseAttribute(
            BaseAttributes.G_STRENGTH.getMean(), BaseAttributes.G_STRENGTH.getDeviation());
    private final static BaseAttribute PASSBLOCK_SPEED = new BaseAttribute(
            BaseAttributes.G_SPEED.getMean()-.05, BaseAttributes.G_SPEED.getDeviation());
    private final static BaseAttribute PASSBLOCK_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.G_BREAK_BLOCK.getMean(), BaseAttributes.G_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute PASSBLOCK_TACKLE = new BaseAttribute(
            BaseAttributes.G_TACKLE.getMean(), BaseAttributes.G_TACKLE.getDeviation());
    private final static BaseAttribute PASSBLOCK_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.G_RUN_BLOCKING.getMean()-.15, BaseAttributes.G_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute PASSBLOCK_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.G_PASS_BLOCKING.getMean()+.15, BaseAttributes.G_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute PASSBLOCK_ACCELERATION = new BaseAttribute(
            BaseAttributes.G_ACCELERATION.getMean()+.05, BaseAttributes.G_ACCELERATION.getDeviation());
    private final static BaseAttribute PASSBLOCK_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.G_BREAK_TACKLE.getMean(), BaseAttributes.G_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute PASSBLOCK_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.G_ELUSIVENESS.getMean(), BaseAttributes.G_ELUSIVENESS.getDeviation());
    private final static BaseAttribute PASSBLOCK_AGILITY = new BaseAttribute(
            BaseAttributes.G_AGILITY.getMean(), BaseAttributes.G_AGILITY.getDeviation());
    private final static BaseAttribute PASSBLOCK_INJURY = new BaseAttribute(
            BaseAttributes.G_INJURY.getMean(), BaseAttributes.G_INJURY.getDeviation());
    private final static BaseAttribute PASSBLOCK_STAMINA = new BaseAttribute(
            BaseAttributes.G_STAMINA.getMean(), BaseAttributes.G_STAMINA.getDeviation());
    private final static BaseAttribute PASSBLOCK_THROW_POWER = new BaseAttribute(
            BaseAttributes.G_THROW_POWER.getMean(), BaseAttributes.G_THROW_POWER.getDeviation());
    private final static BaseAttribute PASSBLOCK_KICK_POWER = new BaseAttribute(
            BaseAttributes.G_KICK_POWER.getMean(), BaseAttributes.G_KICK_POWER.getDeviation());
    private final static BaseAttribute PASSBLOCK_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.G_KICK_ACCURACY.getMean(), BaseAttributes.G_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute PASSBLOCK_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.G_THROW_ACCURACY.getMean(), BaseAttributes.G_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute PASSBLOCK_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.G_ROUTE_RUNNING.getMean(), BaseAttributes.G_ROUTE_RUNNING.getDeviation());

    private final static BaseAttribute NEUTRAL_AWARENESS = new BaseAttribute(
            BaseAttributes.G_AWARENESS.getMean(), BaseAttributes.G_AWARENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_STRENGTH = new BaseAttribute(
            BaseAttributes.G_STRENGTH.getMean(), BaseAttributes.G_STRENGTH.getDeviation());
    private final static BaseAttribute NEUTRAL_SPEED = new BaseAttribute(
            BaseAttributes.G_SPEED.getMean(), BaseAttributes.G_SPEED.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_BLOCK = new BaseAttribute(
            BaseAttributes.G_BREAK_BLOCK.getMean(), BaseAttributes.G_BREAK_BLOCK.getDeviation());
    private final static BaseAttribute NEUTRAL_TACKLE = new BaseAttribute(
            BaseAttributes.G_TACKLE.getMean(), BaseAttributes.G_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_RUN_BLOCKING = new BaseAttribute(
            BaseAttributes.G_RUN_BLOCKING.getMean(), BaseAttributes.G_RUN_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_PASS_BLOCKING = new BaseAttribute(
            BaseAttributes.G_PASS_BLOCKING.getMean(), BaseAttributes.G_PASS_BLOCKING.getDeviation());
    private final static BaseAttribute NEUTRAL_ACCELERATION = new BaseAttribute(
            BaseAttributes.G_ACCELERATION.getMean(), BaseAttributes.G_ACCELERATION.getDeviation());
    private final static BaseAttribute NEUTRAL_BREAK_TACKLE = new BaseAttribute(
            BaseAttributes.G_BREAK_TACKLE.getMean(), BaseAttributes.G_BREAK_TACKLE.getDeviation());
    private final static BaseAttribute NEUTRAL_ELUSIVENESS = new BaseAttribute(
            BaseAttributes.G_ELUSIVENESS.getMean(), BaseAttributes.G_ELUSIVENESS.getDeviation());
    private final static BaseAttribute NEUTRAL_AGILITY = new BaseAttribute(
            BaseAttributes.G_AGILITY.getMean(), BaseAttributes.G_AGILITY.getDeviation());
    private final static BaseAttribute NEUTRAL_INJURY = new BaseAttribute(
            BaseAttributes.G_INJURY.getMean(), BaseAttributes.G_INJURY.getDeviation());
    private final static BaseAttribute NEUTRAL_STAMINA = new BaseAttribute(
            BaseAttributes.G_STAMINA.getMean(), BaseAttributes.G_STAMINA.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_POWER = new BaseAttribute(
            BaseAttributes.G_THROW_POWER.getMean(), BaseAttributes.G_THROW_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_POWER = new BaseAttribute(
            BaseAttributes.G_KICK_POWER.getMean(), BaseAttributes.G_KICK_POWER.getDeviation());
    private final static BaseAttribute NEUTRAL_KICK_ACCURACY = new BaseAttribute(
            BaseAttributes.G_KICK_ACCURACY.getMean(), BaseAttributes.G_KICK_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_THROW_ACCURACY = new BaseAttribute(
            BaseAttributes.G_THROW_ACCURACY.getMean(), BaseAttributes.G_THROW_ACCURACY.getDeviation());
    private final static BaseAttribute NEUTRAL_ROUTE_RUNNING = new BaseAttribute(
            BaseAttributes.G_ROUTE_RUNNING.getMean(), BaseAttributes.G_ROUTE_RUNNING.getDeviation());

    private Guard(final String  subPositionName){
        super(PositionList.GUARD.getName(), subPositionName, BaseAttributes.G_ATTRIBUTES, POSITION_MEAN_OVERALL);
    }

    public final static Guard GenerateRunblockGuard(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUNBLOCK_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), RUNBLOCK_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_BLOCKING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNBLOCK_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNBLOCK_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNBLOCK_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), RUNBLOCK_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), RUNBLOCK_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNBLOCK_THROW_POWER.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUNBLOCK_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUNBLOCK_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNBLOCK_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUNBLOCK_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
                awarenessAttribute,
                strengthAttribute,
                speedAttribute,
                breakBlockAttribute,
                tackleAttribute,
                runBlockingAttribute,
                passBlockingAttribute,
                accelerationAttribute,
                breakTackleAttribute,
                elusivenessAttribute,
                agilityAttribute,
                injuryAttribute,
                staminaAttribute,
                throwPowerAttribute,
                kickPowerAttribute,
                kickAccuracyAttribute,
                throwAccuracyAttribute,
                routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUNBLOCK_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), RUNBLOCK_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_BLOCKING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNBLOCK_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUNBLOCK_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), RUNBLOCK_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), RUNBLOCK_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), RUNBLOCK_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNBLOCK_THROW_POWER.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), RUNBLOCK_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), RUNBLOCK_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNBLOCK_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), RUNBLOCK_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
                awarenessDeviation,
                strengthDeviation,
                speedDeviation,
                breakBlockDeviation,
                tackleDeviation,
                runBlockingDeviation,
                passBlockingDeviation,
                accelerationDeviation,
                breakTackleDeviation,
                elusivenessDeviation,
                agilityDeviation,
                injuryDeviation,
                staminaDeviation,
                throwPowerDeviation,
                kickPowerDeviation,
                kickAccuracyDeviation,
                throwAccuracyDeviation,
                routeRunningDeviation
        );

        final Guard guard = new Guard(SubPositionList.GUARD.RUN_BLOCK);
        guard.overwriteAttributes(attrs);
        guard.overwriteDeviations(devs);
        guard.seedRating(overallSeed);
        return guard;
    }

    public final static Guard GeneratePassblockGuard(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSBLOCK_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), PASSBLOCK_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_BLOCKING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSBLOCK_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSBLOCK_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSBLOCK_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), PASSBLOCK_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), PASSBLOCK_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSBLOCK_THROW_POWER.getMean());
        final Attribute<Double> kickPowerAttribute = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSBLOCK_KICK_POWER.getMean());
        final Attribute<Double> kickAccuracyAttribute = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSBLOCK_KICK_ACCURACY.getMean());
        final Attribute<Double> throwAccuracyAttribute = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSBLOCK_THROW_ACCURACY.getMean());
        final Attribute<Double> routeRunningAttribute = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSBLOCK_ROUTE_RUNNING.getMean());

        final List<Attribute<Double>> attrs = Arrays.asList(
                awarenessAttribute,
                strengthAttribute,
                speedAttribute,
                breakBlockAttribute,
                tackleAttribute,
                runBlockingAttribute,
                passBlockingAttribute,
                accelerationAttribute,
                breakTackleAttribute,
                elusivenessAttribute,
                agilityAttribute,
                injuryAttribute,
                staminaAttribute,
                throwPowerAttribute,
                kickPowerAttribute,
                kickAccuracyAttribute,
                throwAccuracyAttribute,
                routeRunningAttribute
        );

        final Attribute<Double> awarenessDeviation = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS.getDeviation());
        final Attribute<Double> strengthDeviation = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH.getDeviation());
        final Attribute<Double> speedDeviation = new Attribute<>(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED.getDeviation());
        final Attribute<Double> breakBlockDeviation = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASSBLOCK_BREAK_BLOCK.getDeviation());
        final Attribute<Double> tackleDeviation = new Attribute<>(StatAttributes.TACKLE.getName(), PASSBLOCK_TACKLE.getDeviation());
        final Attribute<Double> runBlockingDeviation = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_BLOCKING.getDeviation());
        final Attribute<Double> passBlockingDeviation = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_BLOCKING.getDeviation());
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), PASSBLOCK_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), PASSBLOCK_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), PASSBLOCK_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), PASSBLOCK_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), PASSBLOCK_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSBLOCK_THROW_POWER.getDeviation());
        final Attribute<Double> kickPowerDeviation = new Attribute<>(StatAttributes.KICK_POWER.getName(), PASSBLOCK_KICK_POWER.getDeviation());
        final Attribute<Double> kickAccuracyDeviation = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), PASSBLOCK_KICK_ACCURACY.getDeviation());
        final Attribute<Double> throwAccuracyDeviation = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSBLOCK_THROW_ACCURACY.getDeviation());
        final Attribute<Double> routeRunningDeviation = new Attribute<>(StatAttributes.ROUTE_RUNNING.getName(), PASSBLOCK_ROUTE_RUNNING.getDeviation());

        final List<Attribute<Double>> devs = Arrays.asList(
                awarenessDeviation,
                strengthDeviation,
                speedDeviation,
                breakBlockDeviation,
                tackleDeviation,
                runBlockingDeviation,
                passBlockingDeviation,
                accelerationDeviation,
                breakTackleDeviation,
                elusivenessDeviation,
                agilityDeviation,
                injuryDeviation,
                staminaDeviation,
                throwPowerDeviation,
                kickPowerDeviation,
                kickAccuracyDeviation,
                throwAccuracyDeviation,
                routeRunningDeviation
        );

        final Guard guard = new Guard(SubPositionList.GUARD.PASS_BLOCK);
        guard.overwriteAttributes(attrs);
        guard.overwriteDeviations(devs);
        guard.seedRating(overallSeed);
        return guard;
    }

    public final static Guard GenerateNeutralGuard(final int overallSeed){
        final Attribute<Double> awarenessAttribute = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS.getMean());
        final Attribute<Double> strengthAttribute = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH.getMean());
        final Attribute<Double> speedAttribute = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED.getMean());
        final Attribute<Double> breakBlockAttribute = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_BLOCK.getMean());
        final Attribute<Double> tackleAttribute = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE.getMean());
        final Attribute<Double> runBlockingAttribute = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_BLOCKING.getMean());
        final Attribute<Double> passBlockingAttribute = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_BLOCKING.getMean());
        final Attribute<Double> accelerationAttribute = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION.getMean());
        final Attribute<Double> breakTackleAttribute = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE.getMean());
        final Attribute<Double> elusivenessAttribute = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS.getMean());
        final Attribute<Double> agilityAttribute = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY.getMean());
        final Attribute<Double> injuryAttribute = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRAL_INJURY.getMean());
        final Attribute<Double> staminaAttribute = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA.getMean());
        final Attribute<Double> throwPowerAttribute = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER.getMean());
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
                accelerationAttribute,
                breakTackleAttribute,
                elusivenessAttribute,
                agilityAttribute,
                injuryAttribute,
                staminaAttribute,
                throwPowerAttribute,
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
        final Attribute<Double> accelerationDeviation = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION.getDeviation());
        final Attribute<Double> breakTackleDeviation = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_TACKLE.getDeviation());
        final Attribute<Double> elusivenessDeviation = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS.getDeviation());
        final Attribute<Double> agilityDeviation = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY.getDeviation());
        final Attribute<Double> injuryDeviation = new Attribute<>(StatAttributes.INJURY.getName(), NEUTRAL_INJURY.getDeviation());
        final Attribute<Double> staminaDeviation = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA.getDeviation());
        final Attribute<Double> throwPowerDeviation = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_THROW_POWER.getDeviation());
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
                accelerationDeviation,
                breakTackleDeviation,
                elusivenessDeviation,
                agilityDeviation,
                injuryDeviation,
                staminaDeviation,
                throwPowerDeviation,
                kickPowerDeviation,
                kickAccuracyDeviation,
                throwAccuracyDeviation,
                routeRunningDeviation
        );

        final Guard guard = new Guard(SubPositionList.GUARD.NEUTRAL);
        guard.overwriteAttributes(attrs);
        guard.overwriteDeviations(devs);
        guard.seedRating(overallSeed);
        return guard;
    }

}