package Position.SpecialTeams;

import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Position;

import java.util.Arrays;
import java.util.List;

import static Position.PositionList.KICKER;

public final class Punter extends Position {
    public final static String POWER_SUBPOSITION_NAME = "Power";
    public final static String ACCURATE_SUBPOSITITON_NAME = "Accurate";
    public final static String NEUTRAL_SUBPOSITITON_NAME = "Neutral";

    private final static int NEUTRAL_POWER_VAR = 2;
    private final static int NEUTRAL_ACCURACY_VAR = 2;
    private final static int NEUTRAL_TACKLE_VAR = 1;

    private final static int POWER_POWER_VAR = 3;
    private final static int POWER_ACCURACY_VAR = 1;
    private final static int POWER_TACKLE_VAR = 2;

    private final static int ACCURATE_POWER_VAR = 1;
    private final static int ACCURATE_ACCURACY_VAR = 5;
    private final static int ACCURATE_TACKLE_VAR = 2;

    private Punter(final String subPositionName) {
        super(KICKER.getName(), subPositionName);
    }

    public final static Punter GenerateNeutralPunter(){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.KICK_POWER.getName(), NEUTRAL_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), NEUTRAL_ACCURACY_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), NEUTRAL_TACKLE_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                tackleAdjust
        );

        final Punter punter = new Punter(NEUTRAL_SUBPOSITITON_NAME);
        punter.updateAttributes(attrs);

        return punter;
    }

    public final static Punter GeneratePowerPunter(){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.KICK_POWER.getName(), POWER_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), POWER_ACCURACY_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), POWER_TACKLE_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                tackleAdjust
        );

        final Punter punter = new Punter(POWER_SUBPOSITION_NAME);
        punter.updateAttributes(attrs);

        return punter;
    }

    public final static Punter GenerateAccuratePunter(){
        final Attribute<Integer> powerAdjust = new Attribute<>(StatAttributes.KICK_POWER.getName(), ACCURATE_POWER_VAR);
        final Attribute<Integer> accuracyAdjust = new Attribute<>(StatAttributes.KICK_ACCURACY.getName(), ACCURATE_ACCURACY_VAR);
        final Attribute<Integer> tackleAdjust = new Attribute<>(StatAttributes.TACKLE.getName(), ACCURATE_TACKLE_VAR);

        final List<Attribute<Integer>> attrs = Arrays.asList(
                powerAdjust,
                accuracyAdjust,
                tackleAdjust
        );

        final Punter punter = new Punter(ACCURATE_SUBPOSITITON_NAME);
        punter.updateAttributes(attrs);

        return punter;
    }
}
