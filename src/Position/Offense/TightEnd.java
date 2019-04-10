package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.TIGHT_END;

public final class TightEnd extends Position {
    public final static String BLOCKING_SUBPOSITION_NAME = "Blocking";
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String RECEIVING_SUBPOSITION_NAME = "Receiving";

    private final static int BLOCKING_PASS_VAR = 4;
    private final static int BLOCKING_RUN_VAR = 4;
    private final static int BLOCKING_INJURY_VAR = 5;
    private final static int BLOCKING_STAMINA_VAR = 2;
    private final static int BLOCKING_STRENGTH_VAR = 1;

    private final static int NEUTRAL_PASS_VAR = 1;
    private final static int NEUTRAL_RUN_VAR = 1;
    private final static int NEUTRAL_INJURY_VAR = 3;
    private final static int NEUTRAL_STAMINA_VAR = 2;
    private final static int NEUTRAL_CATCHING_VAR = 1;
    private final static int NEUTRAL_BREAK_VAR = 2;

    private final static int RECEIVING_SPEED_VAR = 2;
    private final static int RECEIVING_ACCELERATION_VAR = 2;
    private final static int RECEIVING_CATCHING_VAR = 3;
    private final static int RECEIVING_BREAK_VAR = 2;
    private final static int RECEIVING_INJURY_VAR = 2;
    private final static int RECEIVING_STAMINA_VAR = 3;

    private TightEnd(final String subPositionName) {
        super(TIGHT_END.getName(), subPositionName);
    }

    public final static TightEnd GenerateBlockingTightEnd(){
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), BLOCKING_PASS_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), BLOCKING_RUN_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), BLOCKING_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), BLOCKING_INJURY_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), BLOCKING_STRENGTH_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                runBlockAdjust,
                staminaAdjust,
                passBlockAdjust,
                injuryAdjust,
                strengthAdjust
        );
        
        final TightEnd tightEnd = new TightEnd(BLOCKING_SUBPOSITION_NAME);
        tightEnd.updateAttributes(mods);

        return tightEnd;
    }

    public final static TightEnd GenerateReceivingTightEnd(){
        final Attribute<Integer> speedBlockAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RECEIVING_SPEED_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RECEIVING_ACCELERATION_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), RECEIVING_BREAK_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RECEIVING_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RECEIVING_INJURY_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), RECEIVING_CATCHING_VAR);


        final List<Attribute<Integer>> mods = Arrays.asList(
                accelerationAdjust,
                breakTackleAdjust,
                staminaAdjust,
                speedBlockAdjust,
                injuryAdjust,
                catchingAdjust
        );
        
        final TightEnd tightEnd = new TightEnd(RECEIVING_SUBPOSITION_NAME);
        tightEnd.updateAttributes(mods);

        return tightEnd;
    }

    public final static TightEnd GenerateNeutralTightEnd(){
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_VAR);
        final Attribute<Integer> breakTackleAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), NEUTRAL_BREAK_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_VAR);


        final List<Attribute<Integer>> mods = Arrays.asList(
                runBlockAdjust,
                breakTackleAdjust,
                staminaAdjust,
                passBlockAdjust,
                injuryAdjust,
                catchingAdjust
        );

        final TightEnd tightEnd = new TightEnd(NEUTRAL_SUBPOSITION_NAME);
        tightEnd.updateAttributes(mods);

        return tightEnd;
    }
}
