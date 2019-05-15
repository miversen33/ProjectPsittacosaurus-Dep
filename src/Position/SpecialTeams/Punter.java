package Position.SpecialTeams;

import Position.References.Lists.SubPositionList;
import Position.Position;
import Position.References.Lists.PositionList;

public final class Punter extends Position{

    private Punter(final String  subPositionName){
        super(PositionList.PUNTER.getName(), subPositionName);
    }

    public final static Punter GeneratePowerPunter(final int overallSeed){
        final Punter punter = new Punter(SubPositionList.PUNTER.POWER);
        punter.seedRating(overallSeed);
        return punter;
    }

    public final static Punter GenerateAccuratePunter(final int overallSeed){
        final Punter punter = new Punter(SubPositionList.PUNTER.ACCURATE);
        punter.seedRating(overallSeed);
        return punter;
    }

    public final static Punter GenerateNeutralPunter(final int overallSeed){
        final Punter punter = new Punter(SubPositionList.PUNTER.NEUTRAL);
        punter.seedRating(overallSeed);
        return punter;
    }

}