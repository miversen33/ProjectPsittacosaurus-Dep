package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.OFFENSIVE_GUARD;

public final class Guard extends OffensiveLineman{

    public final static String RUNBLOCK_GUARD = "Run Blocker";
    public final static String PASSBLOCK_GUARD = "Pass Blocker";
    public final static String NEUTRALBLOCK_GUARD = "Neutral Blocker";

    private final static int RUNBLOCK_RUN_VAR = 3;
    private final static int RUNBLOCK_SPEED_VAR = 1;
    private final static int RUNBLOCK_AWARENESS_VAR = 2;
    private final static int RUNBLOCK_STAMINA_VAR = 2;
    private final static int RUNBLOCK_INJURY_VAR = -1;

    private final static int PASSBLOCK_PASS_VAR = 2;
    private final static int PASSBLOCK_SPEED_VAR = -1;
    private final static int PASSBLOCK_AWARENESS_VAR = 2;
    private final static int PASSBLOCK_STAMINA_VAR = 1;
    private final static int PASSBLOCK_INJURY_VAR = 2;

    private final static int NEUTRAL_RUN_VAR = 1;
    private final static int NEUTRAL_PASS_VAR = 1;
    private final static int NEUTRAL_AWARENESS_VAR = 2;
    private final static int NEUTRAL_STAMINA_VAR = 1;
    private final static int NEUTRAL_INJURY_VAR = 1;

    private Guard(final String subPositionName) {
        super(OFFENSIVE_GUARD.getName(), subPositionName);
    }

    public final static Guard GenerateRunBlockingGuard(){
        Guard center = new Guard(RUNBLOCK_GUARD);

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUNBLOCK_SPEED_VAR);
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), RUNBLOCK_RUN_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNBLOCK_AWARENESS_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), RUNBLOCK_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), RUNBLOCK_INJURY_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                speedAdjust,
                runBlockAdjust,
                awarenessAdjust,
                staminaAdjust,
                injuryAdjust
        );

        center.updateAttributes(attrs);

        return center;
    }

    public final static Guard GenerateNeutralBlockingGuard(){
        Guard center = new Guard(PASSBLOCK_GUARD);
        
        final Attribute<Integer> runBlockAdjust = new Attribute<>(StatAttributes.RUN_BLOCKING.getName(), NEUTRAL_RUN_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), NEUTRAL_PASS_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), NEUTRAL_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), NEUTRAL_INJURY_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                runBlockAdjust,
                passBlockAdjust,
                awarenessAdjust,
                staminaAdjust,
                injuryAdjust
        );

        center.updateAttributes(attrs);
        
        return center;
    }

    public final static Guard GeneratePassBlockingGuard(){
        Guard center = new Guard(NEUTRALBLOCK_GUARD);

        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), PASSBLOCK_SPEED_VAR);
        final Attribute<Integer> passBlockAdjust = new Attribute<>(StatAttributes.PASS_BLOCKING.getName(), PASSBLOCK_PASS_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSBLOCK_AWARENESS_VAR);
        final Attribute<Integer> staminaAdjust = new Attribute<>(StatAttributes.STAMINA.getName(), PASSBLOCK_STAMINA_VAR);
        final Attribute<Integer> injuryAdjust = new Attribute<>(StatAttributes.INJURY_PREVENTION.getName(), PASSBLOCK_INJURY_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                speedAdjust,
                passBlockAdjust,
                awarenessAdjust,
                staminaAdjust,
                injuryAdjust
        );

        center.updateAttributes(attrs);
        
        return center;
    }
}
