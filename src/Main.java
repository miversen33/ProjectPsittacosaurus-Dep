import Game.Field.Field;
import Game.GamePlay.*;
import Game.GamePlay.TimeManagement.Clock;
import Tuple.Tuple2;
import Utils.Location;
import Game.GamePlay.PlayerStrategy.Defense.DefaultDefensiveStrategy;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Game.GamePlay.PlayerStrategy.Offense.BallCarrierStrategy;
import Game.GamePlay.PlayerStrategy.Offense.DefaultOffensiveStrategy;
import PhysicsEngine.Movements.MovementEngine;
import Utils.Signature;

import java.util.Arrays;
import java.util.UUID;

public class Main {

    /**
     * This is the "temp" GameManager class. Used for testing and such for now
     * @param args
     */
    public static void main(String[] args) {
//        This is a pseudo gameManager class. Eventually this will be cleaned up
//        And placed in its own class.

        Signature signature = Signature.GenerateNewSignature();
        MovementEngine engine = new MovementEngine(signature);

        GameField gameField = new GameField(signature);
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

        final GameClock gc = new GameClock(signature, Clock.DefaultQuarterLength.QUARTER_15, Clock.DefaultPlayClock.PLAY_CLOCK_45);

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
                        ,defensivePlayer2
                       ,defensivePlayer3
                       ,defensivePlayer4
                       ,defensivePlayer5
                       ,defensivePlayer6
                ), Field.GetNorthEndzone());
        final Tuple2<Double, Double> ballCarrierLocation = new Tuple2<>(30.0,Field.ENDZONE_HEIGHT);
        final Tuple2<Double, Double> blockerLocation = new Tuple2<>(21.0, 15.0);
        final Tuple2<Double, Double> defender1Location = new Tuple2<>(100.0, Field.FIELD_HEIGHT);
        final Tuple2<Double, Double> defender2Location = new Tuple2<>(10.0, 75.0);
        final Tuple2<Double, Double> defender3Location = new Tuple2<>(35.0, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);
//        final Tuple2<Double, Double> defender4Location = new Tuple2<>(Field.FIELD_WIDTH - 60, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);
//        final Tuple2<Double, Double> defender5Location = new Tuple2<>(Field.FIELD_WIDTH - 90, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);
//        final Tuple2<Double, Double> defender6Location = new Tuple2<>(Field.FIELD_WIDTH - 120, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);

        gameField.addPlayer(ballCarrier, new Location(ballCarrierLocation));
//        gameField.addPlayer(blockerPlayer1, new Location(blockerLocation));
        gameField.addPlayer(defensivePlayer1, new Location(defender1Location));
//        gameField.addPlayer(defensivePlayer2, new Location(defender2Location));
//        gameField.addPlayer(defensivePlayer3, new Location(defender3Location));
//        gameField.addPlayer(defensivePlayer4, new Location(defender4Location));
//        gameField.addPlayer(defensivePlayer5, new Location(defender5Location));
//        gameField.addPlayer(defensivePlayer6, new Location(defender6Location));

        ballCarrier.DEBUG_setBallCarrier(true);

        gameField.lock();

//        Quick loop to cycle movements.

        while(true){
            gameField.DEBUG_DumpPlayerLocations();
            offense.cycle();
            defense.cycle();
            gameField.giveMovementsToEngine(engine);
        }
    }

}

