package Position.Defense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.DEFENSIVE_TACKLE;

public final class DefensiveTackle extends Position {

    public final static String RUN_SUBPOSITITON_NAME = "Run Rusher";
    public final static String PASS_SUBPOSITITON_NAME = "Pass Rusher";
    public final static String NEUTRAL_SUBPOSITITON_NAME = "Neutral";

    private final static int RUN_AGILITY_VAR = 2;
    private final static int RUN_STRENGTH_VAR = 4;
    private final static int RUN_TACKLE_VAR = 6;
    private final static int RUN_BREAK_VAR = 3;

    private final static int PASS_SPEED_VAR = 1;
    private final static int PASS_STRENGTH_VAR = 5;
    private final static int PASS_TACKLE_VAR = 3;
    private final static int PASS_BREAK_VAR = 4;

    private final static int NEUTRAL_SPEED_VAR = 1;
    private final static int NEUTRAL_AGILITY_VAR = 1;
    private final static int NEUTRAL_STRENGTH_VAR = 3;
    private final static int NEUTRAL_TACKLE_VAR = 2;
    private final static int NEUTRAL_BREAK_VAR = 3;

    private DefensiveTackle(final String subPositionName) {
        super(DEFENSIVE_TACKLE.getName(), subPositionName);
    }

    public final static DefensiveTackle GeneratePassRushDefensiveTackle(){

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), PASS_STRENGTH_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), PASS_SPEED_VAR);
        final Attribute<Integer> breakBlockAdjust = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), PASS_BREAK_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), PASS_TACKLE_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                speedAdjust,
                breakBlockAdjust,
                tackleAdjust
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(PASS_SUBPOSITITON_NAME);
        defensiveTackle.updateAttributes(attrs);

        return defensiveTackle;
    }

    public final static DefensiveTackle GenerateRunRushDefensiveTackle(){

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RUN_STRENGTH_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), RUN_AGILITY_VAR);
        final Attribute<Integer> breakBlockAdjust = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), RUN_BREAK_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), RUN_TACKLE_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                agilityAdjust,
                breakBlockAdjust,
                tackleAdjust
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(RUN_SUBPOSITITON_NAME);
        defensiveTackle.updateAttributes(attrs);

        return defensiveTackle;
    }

    public final static DefensiveTackle GenerateNeutralRushDefensiveTackle(){

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_VAR);
        final Attribute<Integer> breakBlockAdjust = new Attribute<>(StatAttributes.BREAK_BLOCK.getName(), NEUTRAL_BREAK_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                speedAdjust,
                breakBlockAdjust,
                tackleAdjust,
                agilityAdjust
        );

        final DefensiveTackle defensiveTackle = new DefensiveTackle(NEUTRAL_SUBPOSITITON_NAME);
        defensiveTackle.updateAttributes(attrs);

        return defensiveTackle;
    }
}
