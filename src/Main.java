import Game.Field.Field;
import Game.GamePlay.*;
import Game.GamePlay.TimeManagement.Clock;
import Game.GamePlay.PlayerStrategy.Defense.DefaultDefensiveStrategy;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Game.GamePlay.PlayerStrategy.Offense.BallCarrierStrategy;
import Game.GamePlay.PlayerStrategy.Offense.DefaultOffensiveStrategy;

import java.util.Arrays;

public class Main {

    /**
     * This is the "temp" GameManager class. Used for testing and such for now
     * @param args
     */
    public static void main(String[] args) {
//        This is a pseudo gameManager class. Eventually this will be cleaned up
//        And placed in its own class.

        final IPlayerStrategy ballCarrierStrategy = new BallCarrierStrategy();
        final IPlayerStrategy blockerStrategy   = new DefaultOffensiveStrategy();
        final IPlayerStrategy defensivePlayerStrategy1 = new DefaultDefensiveStrategy();
        final IPlayerStrategy defensivePlayerStrategy2 = new DefaultDefensiveStrategy();
        final IPlayerStrategy defensivePlayerStrategy3 = new DefaultDefensiveStrategy();

        final double bcMass = 74.84;
        final double b1Mass = 108.86;
        final double d1Mass = 113.40;
        final double d2Mass = 113.40;
        final double d3Mass = 113.40;
        final double d4Mass = 90.718;
        final double d5Mass = 90.718;
        final double d6Mass = 90.718;

        final GamePlayer ballCarrier = new GamePlayer(bcMass, "BallCarrier", ballCarrierStrategy);
        final GamePlayer blockerPlayer1 = new GamePlayer(b1Mass, "Blocker1",blockerStrategy);
        final GamePlayer defensivePlayer1 = new GamePlayer(d1Mass, "Linebacker1",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer2 = new GamePlayer(d2Mass, "Linebacker2",defensivePlayerStrategy2);
        final GamePlayer defensivePlayer3 = new GamePlayer(d3Mass, "Linebacker3",defensivePlayerStrategy3);
        final GamePlayer defensivePlayer4 = new GamePlayer(d4Mass, "Linebacker4",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer5 = new GamePlayer(d5Mass, "Linebacker5",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer6 = new GamePlayer(d6Mass, "Linebacker6",defensivePlayerStrategy1);

        final GameTeam offense = new GameTeam(
                Arrays.asList(
                        ballCarrier
                        ,blockerPlayer1
                ), Field.GetSouthEndzone());
        final GameTeam defense = new GameTeam(
                Arrays.asList(
                        defensivePlayer1
//                       ,defensivePlayer2
//                       ,defensivePlayer3
//                       ,defensivePlayer4
//                       ,defensivePlayer5
//                       ,defensivePlayer6
                ), Field.GetNorthEndzone());

        final GameManager gameManager = new GameManager(offense, defense, Clock.DefaultQuarterLength.QUARTER_15, Clock.DefaultPlayClock.PLAY_CLOCK_45);

//        Quick loop to cycle movements.

        while(true){
            gameManager.cycle();
        }
    }

}

