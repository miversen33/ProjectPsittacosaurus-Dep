package Position.Defense;

import Position.Lists.SubPositionList;
import Position.Position;
import Position.Lists.PositionList;

public final class DefensiveEnd extends Position {

    private DefensiveEnd(final String subPositionName) {
        super(PositionList.DEFENSIVE_END.getName(), subPositionName);
    }

    public final static DefensiveEnd GenerateRunrushDefensiveEnd(final int overallSeed) {
        final DefensiveEnd defensiveEnd = new DefensiveEnd(SubPositionList.DEFENSIVE_END.RUN_RUSH);
        defensiveEnd.seedRating(overallSeed);
        return defensiveEnd;
    }

    public final static DefensiveEnd GeneratePassrushDefensiveEnd(final int overallSeed) {
        final DefensiveEnd defensiveEnd = new DefensiveEnd(SubPositionList.DEFENSIVE_END.PASS_RUSH);
        defensiveEnd.seedRating(overallSeed);
        return defensiveEnd;
    }

    public final static DefensiveEnd GenerateNeutralrushDefensiveEnd(final int overallSeed) {
        final DefensiveEnd defensiveEnd = new DefensiveEnd(SubPositionList.DEFENSIVE_END.NEUTRAL);
        defensiveEnd.seedRating(overallSeed);
        return defensiveEnd;
    }

}