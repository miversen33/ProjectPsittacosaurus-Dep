package Position.Offense;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.QUARTERBACK;

public final class Quarterback extends Position {

    public final static String NEUTRAL_SUBPOSITION_NAME = "Neutral";
    public final static String PASSING_SUBPOSITION_NAME = "Passing";
    public final static String RUNNING_SUBPOSITION_NAME = "Running";

    private final static int NEUTRAL_POWER_VAR = 3;
    private final static int NEUTRAL_ACCURACY_VAR = 3;
    private final static int NEUTRAL_AWARENESS_VAR = 3;

    private final static int PASSING_POWER_VAR = 5;
    private final static int PASSING_ACCURACY_VAR = 7;
    private final static int PASSING_AWARENESS_VAR = 5;
    private final static int PASSING_SPEED_VAR = -1;
    private final static int PASSING_CARRYING_VAR = -3;

    private final static int RUNNING_POWER_VAR = 2;
    private final static int RUNNING_ACCURACY_VAR = -1;
    private final static int RUNNING_AWARENESS_VAR = 3;
    private final static int RUNNING_SPEED_VAR = 3;
    private final static int RUNNING_ACCELERATION_VAR = 2;
    private final static int RUNNING_CARRYING_VAR = 2;

    private Quarterback(final String subPositionName) {
        super(QUARTERBACK.getName(), subPositionName);
    }

    public final static Quarterback GenerateNeutralQuarterback(){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.THROW_POWER.getName(), NEUTRAL_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), NEUTRAL_ACCURACY_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), NEUTRAL_AWARENESS_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                awarenessAdjust
        );

        final Quarterback quarterback = new Quarterback(NEUTRAL_SUBPOSITION_NAME);
        quarterback.updateAttributes(mods);

        return quarterback;
    }

    public final static Quarterback GeneratePassingQuarterback(){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.THROW_POWER.getName(), PASSING_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), PASSING_ACCURACY_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), PASSING_AWARENESS_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), PASSING_SPEED_VAR);
        final Attribute<Integer> carryAdjust = new Attribute<>(StatAttributes.CARRYING.getName(), PASSING_CARRYING_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                awarenessAdjust,
                speedAdjust,
                carryAdjust
        );

        final Quarterback quarterback = new Quarterback(PASSING_SUBPOSITION_NAME);
        quarterback.updateAttributes(mods);

        return quarterback;
    }
    
    public final static Quarterback GenerateRunningQuarterback(){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.THROW_POWER.getName(), RUNNING_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.THROW_ACCURACY.getName(), RUNNING_ACCURACY_VAR);
        final Attribute<Integer> awarenessAdjust = new Attribute<>(StatAttributes.AWARENESS.getName(), RUNNING_AWARENESS_VAR);
        final Attribute<Integer> speedAdjust = new Attribute<>(StatAttributes.SPEED.getName(), RUNNING_SPEED_VAR);
        final Attribute<Integer> carryAdjust = new Attribute<>(StatAttributes.CARRYING.getName(), RUNNING_CARRYING_VAR);
        final Attribute<Integer> accelerationAdjust = new Attribute<>(StatAttributes.ACCELERATION.getName(), RUNNING_ACCELERATION_VAR);

        final List<Attribute<Integer>> mods = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                awarenessAdjust,
                speedAdjust,
                carryAdjust,
                accelerationAdjust
        );

        final Quarterback quarterback = new Quarterback(RUNNING_SUBPOSITION_NAME);
        quarterback.updateAttributes(mods);

        return quarterback;
    }

}
