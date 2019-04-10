package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.TAILBACK;

public final class Tailback extends Position {

    public final static String SPEED_SUBPOSITION_NAME = "Speed";
    public final static String POWER_SUBPOSITION_NAME = "Power";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";

    private final static int SPEED_SPEED_VAR = 2;
    private final static int SPEED_AGILITY_VAR = 2;
    private final static int SPEED_ACCELERATION_VAR = 3;
    private final static int SPEED_BREAK_VAR = -2;
    private final static int SPEED_STAMINA_VAR = 2;

    private final static int POWER_SPEED_VAR = -2;
    private final static int POWER_AGILITY_VAR = -2;
    private final static int POWER_ACCELERATION_VAR = 2;
    private final static int POWER_BREAK_VAR = 5;
    private final static int POWER_STAMINA_VAR = 2;
    private final static int POWER_INJURY_VAR = 2;

    private final static int NEUTRAL_SPEED_VAR = 1;
    private final static int NEUTRAL_AGILITY_VAR = 1;
    private final static int NEUTRAL_ACCELERATION_VAR = 1;
    private final static int NEUTRAL_BREAK_VAR = 1;
    private final static int NEUTRAL_STAMINA_VAR = 1;
    private final static int NEUTRAL_INJURY_VAR = 1;
    private final static int NEUTRAL_STRENGTH_VAR = 1;

    private Tailback(final String subPositionName) {
        super(TAILBACK.getName(), subPositionName);
    }

    public final static Tailback GenerateSpeedTailBack(){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), SPEED_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), SPEED_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), SPEED_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), SPEED_STAMINA_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                agilityAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedAdjust,
                accelerationAdjust
        );

        final Tailback tailback = new Tailback(SPEED_SUBPOSITION_NAME);
        tailback.updateAttributes(mods);

        return tailback;
    }

    public final static Tailback GeneratePowerTailback(){
        
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), POWER_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), POWER_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), POWER_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POWER_BREAK_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), POWER_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), POWER_INJURY_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                agilityAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                injuryAdjust
        );
        
        final Tailback tailback = new Tailback(POWER_SUBPOSITION_NAME);
        tailback.updateAttributes(mods);

        return tailback;
    }

    public final static Tailback GenerateNeutralTailback(){

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), NEUTRAL_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                agilityAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedAdjust,
                accelerationAdjust,
                injuryAdjust,
                strengthAdjust
        );

        final Tailback tailback = new Tailback(NEUTRAL_SUBPOSITION_NAME);
        tailback.updateAttributes(mods);

        return tailback;
    }
}
