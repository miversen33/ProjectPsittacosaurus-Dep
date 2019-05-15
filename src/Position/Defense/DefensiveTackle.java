package Position.Defense;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class DefensiveTackle extends Position{

    private DefensiveTackle(final String  subPositionName){
        super(PositionList.DEFENSIVE_TACKLE.getName(), subPositionName);
    }

    public final static DefensiveTackle GenerateRunrushDefensiveTackle(final int overallSeed){
        final DefensiveTackle defensiveTackle = new DefensiveTackle(SubPositionList.DEFENSIVE_TACKLE.RUN_RUSH);
        defensiveTackle.seedRating(overallSeed);
        return defensiveTackle;
    }

    public final static DefensiveTackle GeneratePassrushDefensiveTackle(final int overallSeed){
        final DefensiveTackle defensiveTackle = new DefensiveTackle(SubPositionList.DEFENSIVE_TACKLE.PASS_RUSH);
        defensiveTackle.seedRating(overallSeed);
        return defensiveTackle;
    }

    public final static DefensiveTackle GenerateNeutralrushDefensiveTackle(final int overallSeed){
        final DefensiveTackle defensiveTackle = new DefensiveTackle(SubPositionList.DEFENSIVE_TACKLE.NEUTRAL);
        defensiveTackle.seedRating(overallSeed);
        return defensiveTackle;
    }

}