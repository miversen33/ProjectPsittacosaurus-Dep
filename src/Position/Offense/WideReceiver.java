package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;


import java.util.Arrays;
import java.util.List;

import static Position.PositionList.WIDE_RECEIVER;

public final class WideReceiver extends Position {
    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String SPEED_SUBPOSITION_NAME = "Speed";
    public final static String POSSESSION_SUBPOSITION_NAME = "Possession";

    private final static int NEUTRAL_SPEED_VAR = 2;
    private final static int NEUTRAL_ELUSIVENESS_VAR = 1;
    private final static int NEUTRAL_AGILITY_VAR = 1;
    private final static int NEUTRAL_CATCHING_VAR = 2;

    private final static int SPEED_SPEED_VAR = 5;
    private final static int SPEED_STRENGTH_VAR = -2;
    private final static int SPEED_BREAK_VAR = -2;
    private final static int SPEED_AGILITY_VAR = 3;
    private final static int SPEED_CATCHING_VAR = -1;
    private final static int SPEED_ELUSIVENESS_VAR = 2;

    private final static int POSSESSION_SPEED_VAR = 1;
    private final static int POSSESSION_STRENGTH_VAR = 3;
    private final static int POSSESSION_BREAK_VAR = 1;
    private final static int POSSESSION_CATCHING_VAR = 4;

    private WideReceiver(final String subPositionName) {
        super(WIDE_RECEIVER.getName(), subPositionName);
    }

    public final static WideReceiver GenerateNeutralWideReceiver(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), NEUTRAL_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), NEUTRAL_AGILITY_VAR);
        final Attribute<Integer> elusivenessAdjust = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), NEUTRAL_ELUSIVENESS_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), NEUTRAL_CATCHING_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                agilityAdjust,
                catchingAdjust,
                speedAdjust,
                elusivenessAdjust
        );

        final WideReceiver wideReceiver = new WideReceiver(NEUTRAL_SUBPOSITION_NAME);
        wideReceiver.updateAttributes(mods);

        return wideReceiver;
    }

    public final static WideReceiver GenerateSpeedWideReceiver(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), SPEED_SPEED_VAR);
        final Attribute<Integer> agilityAdjust = new Attribute<>(StatAttributes.AGILITY.getName(), SPEED_AGILITY_VAR);
        final Attribute<Integer> elusivenessAdjust = new Attribute<>(StatAttributes.ELUSIVENESS.getName(), SPEED_ELUSIVENESS_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), SPEED_CATCHING_VAR);
        final Attribute<Integer> breakAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), SPEED_BREAK_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), SPEED_STRENGTH_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                agilityAdjust,
                catchingAdjust,
                speedAdjust,
                elusivenessAdjust,
                breakAdjust,
                strengthAdjust
        );
        
        final WideReceiver wideReceiver = new WideReceiver(SPEED_SUBPOSITION_NAME);
        wideReceiver.updateAttributes(mods);

        return wideReceiver;
    }

    public final static WideReceiver GeneratePossesionWideReceiver(){
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), POSSESSION_SPEED_VAR);
        final Attribute<Integer> breakAdjust = new Attribute<>(StatAttributes.BREAK_TACKLE.getName(), POSSESSION_BREAK_VAR);
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), POSSESSION_STRENGTH_VAR);
        final Attribute<Integer> catchingAdjust = new Attribute<>(StatAttributes.CATCHING.getName(), POSSESSION_CATCHING_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                breakAdjust,
                catchingAdjust,
                speedAdjust,
                strengthAdjust
        );

        final WideReceiver wideReceiver = new WideReceiver(POSSESSION_SUBPOSITION_NAME);
        wideReceiver.updateAttributes(mods);

        return wideReceiver;
    }
}
