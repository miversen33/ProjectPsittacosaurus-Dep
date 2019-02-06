import Game.Field.Field;
import Game.Field.GameField;
import Tuple.Tuple2;
import Utils.Location;
import Game.GameManager;
import Game.Field.GamePlayer;
import Game.GameTeam;
import Game.PlayerStrategy.Defense.DefaultDefensiveStrategy;
import Game.PlayerStrategy.IPlayerStrategy;
import Game.PlayerStrategy.Offense.BallCarrierStrategy;
import Game.PlayerStrategy.Offense.DefaultOffensiveStrategy;
import PhysicsEngine.Movements.MovementEngine;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        This is a pseudo gameManager class. Eventually this will be cleaned up
//        And placed in its own class.

        Field field = new Field();
        GameField gameField = new GameField(field);
        MovementEngine engine = new MovementEngine();

        final IPlayerStrategy ballCarrierStrategy = new BallCarrierStrategy();
        final IPlayerStrategy blockerStrategy   = new DefaultOffensiveStrategy();
        final IPlayerStrategy defensivePlayerStrategy1 = new DefaultDefensiveStrategy();
//        final IPlayerStrategy defensivePlayerStrategy2 = new DefaultDefensiveStrategy();

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
        final GamePlayer defensivePlayer1 = new GamePlayer(d1Mass, "Linebacker1", defensivePlayerStrategy1);
        final GamePlayer defensivePlayer2 = new GamePlayer(d2Mass, "Linebacker2",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer3 = new GamePlayer(d3Mass, "Linebacker3",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer4 = new GamePlayer(d4Mass, "Linebacker4",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer5 = new GamePlayer(d5Mass, "Linebacker5",defensivePlayerStrategy1);
        final GamePlayer defensivePlayer6 = new GamePlayer(d6Mass, "Linebacker6",defensivePlayerStrategy1);

        final GameTeam offense = new GameTeam(
                Arrays.asList(
                        ballCarrier
//                        ,blockerPlayer1
                ), Field.GetSouthEndzone());
        final GameTeam defense = new GameTeam(
                Arrays.asList(
                        defensivePlayer1
//                        ,defensivePlayer2
//                       ,defensivePlayer3
//                       ,defensivePlayer4
//                       ,defensivePlayer5
//                       ,defensivePlayer6
                ), Field.GetNorthEndzone());
        final Tuple2<Double, Double> ballCarrierLocation = new Tuple2<>(30.0,10.0);
        final Tuple2<Double, Double> blockerLocation = new Tuple2<>(0.0, 0.0);
        final Tuple2<Double, Double> defender1Location = new Tuple2<>(30.0, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);
        final Tuple2<Double, Double> defender2Location = new Tuple2<>(Field.FIELD_WIDTH - 10, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);
//        final Tuple2<Double, Double> defender3Location = new Tuple2<>(Field.FIELD_WIDTH - 30, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);
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
        while(!GameManager.DEBUG_DUN){
            if(Field.IsInEndzone(ballCarrier.getTeamGoal(), ballCarrier)) {
                int i = 0;
            }

            System.out.println("BallCarrier Location is | ("+ballCarrier.getLocation().getFirst()+","+ballCarrier.getLocation().getSecond()+")");
//            System.out.println("Blocker1 Location is | ("+blockerPlayer1.getLocation().getFirst()+","+blockerPlayer1.getLocation().getSecond()+")");
            System.out.println("Defensive Player Location (1) is | ("+defensivePlayer1.getLocation().getFirst()+","+defensivePlayer1.getLocation().getSecond()+")");
//            System.out.println("Defensive Player Location (2) is | ("+defensivePlayer2.getLocation().getFirst()+","+defensivePlayer2.getLocation().getSecond()+")");
            if(defensivePlayer1.getLocation().getSecond() - ballCarrier.getLocation().getSecond() <= 4){
                int i = 0;
            }
            offense.cycle();
            defense.cycle();
            gameField.giveMovementsToEngine(engine);
        }
    }

}

