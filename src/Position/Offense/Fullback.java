package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.FULLBACK;

public final class Fullback extends Position {

    public final static String BLOCKING_SUBPOSITION_NAME = "Blocking";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String RUSHING_SUBPOSITION_NAME = "Rushing";

    private final static int BLOCKING_PASSBLOCK_VAR = 2;
    private final static int BLOCKING_RUNBLOCK_VAR = 2;
    private final static int BLOCKING_INJURY_VAR = 5;
    private final static int BLOCKING_STAMINA_VAR = 2;
    private final static int BLOCKING_STRENGTH_VAR = 2;

    private final static int NEUTRAL_PASSBLOCK_VAR = 1;
    private final static int NEUTRAL_RUNBLOCK_VAR = 1;
    private final static int NEUTRAL_INJURY_VAR = 2;
    private final static int NEUTRAL_STAMINA_VAR = 2;
    private final static int NEUTRAL_BREAK_VAR = 3;

    private final static int RUSHING_SPEED_VAR = 1;
    private final static int RUSHING_AGILITY_VAR = 1;
    private final static int RUSHING_BREAK_VAR = 5;
    private final static int RUSHING_INJURY_VAR = 2;
    private final static int RUSHING_STAMINA_VAR = 2;

    private Fullback(final String subPositionName) {
        super(FULLBACK.getName(), subPositionName);
    }

    public final static Fullback GenerateBlockingFullback(){
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASSBLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUNBLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), BLOCKING_INJURY_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), BLOCKING_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                passBlockAdjust,
                runBlockAdjust,
                injuryAdjust,
                staminaAdjust,
                strengthAdjust
        );

        final Fullback fullback = new Fullback(BLOCKING_SUBPOSITION_NAME);
        fullback.updateAttributes(mods);

        return fullback;
    }

    public final static Fullback GenerateNeutralFullback(){
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASSBLOCK_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUNBLOCK_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_BREAK_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                passBlockAdjust,
                runBlockAdjust,
                injuryAdjust,
                staminaAdjust,
                strengthAdjust
        );

        final Fullback fullback = new Fullback(NEUTRAL_SUBPOSITION_NAME);
        fullback.updateAttributes(mods);

        return fullback;
    }

    public final static Fullback GenerateRushingFullback(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUSHING_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), RUSHING_AGILITY_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RUSHING_INJURY_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUSHING_STAMINA_VAR);
        final Attribute<Integer> breakAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RUSHING_BREAK_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                speedAdjust,
                agilityAdjust,
                injuryAdjust,
                staminaAdjust,
                breakAdjust
         );

        final Fullback fullback = new Fullback(RUSHING_SUBPOSITION_NAME);
        fullback.updateAttributes(mods);

        return fullback;
    }
}
