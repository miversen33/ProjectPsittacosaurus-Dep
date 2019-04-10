package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.OFFENSIVE_CENTER;

public final class Center extends OffensiveLineman{

    public final static String RUNBLOCK_CENTER = "Run Blocker";
    public final static String PASSBLOCK_CENTER = "Pass Blocker";
    public final static String NEUTRALBLOCK_CENTER = "Neutral Blocker";

    private final static int RUNBLOCK_STRENGTH_VAR = 2;
    private final static int RUNBLOCK_RUN_VAR = 5;
    private final static int RUNBLOCK_AWARENESS_VAR = 2;
    private final static int RUNBLOCK_STAMINA_VAR = 5;
    private final static int RUNBLOCK_INJURY_VAR = -5;
    private final static int RUNBLOCK_PASS_VAR = -3;

    private final static int PASSBLOCK_STRENGTH_VAR = 2;
    private final static int PASSBLOCK_RUN_VAR = -3;
    private final static int PASSBLOCK_AWARENESS_VAR = 2;
    private final static int PASSBLOCK_STAMINA_VAR = -3;
    private final static int PASSBLOCK_INJURY_VAR = 5;
    private final static int PASSBLOCK_PASS_VAR = 5;

    private final static int NEUTRAL_STRENGTH_VAR = 2;
    private final static int NEUTRAL_RUN_VAR = 2;
    private final static int NEUTRAL_AWARENESS_VAR = 2;
    private final static int NEUTRAL_STAMINA_VAR = 2;
    private final static int NEUTRAL_INJURY_VAR = 2;
    private final static int NEUTRAL_PASS_VAR = 2;

    private Center(final String subPositionName) {
        super(OFFENSIVE_CENTER.getName(), subPositionName);
    }

    public final static Center GenerateRunBlockingCenter(){
        Center center = new Center(RUNBLOCK_CENTER);

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), RUNBLOCK_STRENGTH_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), RUNBLOCK_PASS_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RUNBLOCK_INJURY_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                runBlockAdjust,
                passBlockAdjust,
                awarenessAdjust,
                staminaAdjust,
                injuryAdjust
        );

        center.updateAttributes(attrs);

        return center;
    }

    public final static Center GenerateNeutralBlockingCenter(){
        Center center = new Center(PASSBLOCK_CENTER);
        
        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), PASSBLOCK_STRENGTH_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), PASSBLOCK_RUN_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), PASSBLOCK_INJURY_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                runBlockAdjust,
                passBlockAdjust,
                awarenessAdjust,
                staminaAdjust,
                injuryAdjust
        );

        center.updateAttributes(attrs);
        
        return center;
    }

    public final static Center GeneratePassBlockingCenter(){
        Center center = new Center(NEUTRALBLOCK_CENTER);

        final Attribute<Integer> strengthAdjust = new Attribute<>(StatAttributes.STRENGTH.getName(), NEUTRAL_STRENGTH_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                strengthAdjust,
                runBlockAdjust,
                passBlockAdjust,
                awarenessAdjust,
                staminaAdjust,
                injuryAdjust
        );

        center.updateAttributes(attrs);
        
        return center;
    }
}
