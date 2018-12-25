import Game.Field.Field;
import Game.Field.Location;
import Game.GameField;
import Game.GameManager;
import Game.GamePlayer;
import Game.GameTeam;
import Game.PlayerStrategy.Defense.RusherStrategy;
import Game.PlayerStrategy.Offense.BallCarrierStrategy;
import PhysicsEngine.MovementEngine;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        GameField gameField = new GameField(field);
        MovementEngine engine = new MovementEngine();

        final BallCarrierStrategy offensiveStrategy = new BallCarrierStrategy();
        final RusherStrategy defensiveStrategy      = new RusherStrategy();

        final GamePlayer offensivePlayer = new GamePlayer("Quarterback", offensiveStrategy);
        final GamePlayer defensivePlayer1 = new GamePlayer("Linebacker1", defensiveStrategy);
        final GamePlayer defensivePlayer2 = new GamePlayer("Linebacker2",defensiveStrategy);

        final GameTeam offense = new GameTeam(Collections.singletonList(offensivePlayer), field.getSouthEndzone());
        final GameTeam defense = new GameTeam(Arrays.asList(defensivePlayer1, defensivePlayer2), field.getNorthEndzone());

        final int xOLocation = 30;
        final int xDLocation = 35;
        final int xDLocation2 = 25;
        gameField.addPlayer(offensivePlayer, new Location(xOLocation, - 2));
        gameField.addPlayer(defensivePlayer1, new Location(xDLocation, Field.FIELD_HEIGHT - 2));
//        gameField.addPlayer(defensivePlayer2, new Location(xDLocation2, Field.FIELD_HEIGHT - 2));

        gameField.lock();

//        Quick loop to cycle movements.
        while(!GameManager.DEBUG_DUN){
            if(offensivePlayer.getLocation() != null && offensivePlayer.getLocation().getSecond() >= 330){
//                Just a break because we dont have any way to handle touchdowns yet
                int i = 0;
            }
            if(offensivePlayer.getLocation() != null &&
            (defensivePlayer1.getLocation().getSecond() - offensivePlayer.getLocation().getSecond()) <= 45 &&
            (defensivePlayer1.getLocation().getSecond() >= offensivePlayer.getLocation().getSecond())){
                System.out.println("Offensive Player Location is | ("+offensivePlayer.getLocation().getFirst()+","+offensivePlayer.getLocation().getSecond()+")");
                System.out.println("Defensive Player Location (1) is | ("+defensivePlayer1.getLocation().getFirst()+","+defensivePlayer1.getLocation().getSecond()+")");
//                System.out.println("Defensive Player Location (2) is | ("+defensivePlayer2.getLocation().getFirst()+","+defensivePlayer2.getLocation().getSecond()+")");
            }
            offense.cycle();
            defense.cycle();
            engine.cycleQueue(gameField.getMovementQueue(), gameField);
        }

    }
}
