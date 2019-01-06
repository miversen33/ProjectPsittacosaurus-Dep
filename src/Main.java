import Game.Field.Field;
import Game.Field.Location;
import Game.GameField;
import Game.GameManager;
import Game.GamePlayer;
import Game.IGameTeam;
import Game.PlayerStrategy.Defense.DefaultDefensiveStrategy;
import Game.PlayerStrategy.Offense.BallCarrierStrategy;
import PhysicsEngine.MovementEngine;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        This is a pseudo gameManager class. Eventually this will be cleaned up
//        And placed in its own class.

        Field field = new Field();
        GameField gameField = new GameField(field);
        MovementEngine engine = new MovementEngine();

        final BallCarrierStrategy offensiveStrategy = new BallCarrierStrategy();
        final DefaultDefensiveStrategy defensiveStrategy      = new DefaultDefensiveStrategy();

        final GamePlayer offensivePlayer = new GamePlayer("Quarterback", offensiveStrategy);
        final GamePlayer defensivePlayer1 = new GamePlayer("Linebacker1", defensiveStrategy);
        final GamePlayer defensivePlayer2 = new GamePlayer("Linebacker2",defensiveStrategy);

//        Consider breaking the endzone out into its own class that the Field holds onto, so you can reference it later when needed without having to remember which endzone you need
        final IGameTeam offense = new IGameTeam(Collections.singletonList(offensivePlayer), field.getSouthEndzone());
        final IGameTeam defense = new IGameTeam(Arrays.asList(defensivePlayer1, defensivePlayer2), field.getNorthEndzone());

        final int xOLocation = 30;
        final int xDLocation = 10;
        final double xDLocation2 = Field.FIELD_WIDTH - 10;

        final double yOLocation = 30;
        final double yDLocation = Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT;
        final double yDLocation2 = Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT;

        gameField.addPlayer(offensivePlayer, new Location(xOLocation, yOLocation));
        gameField.setBallCarrier(offensivePlayer);

        gameField.addPlayer(defensivePlayer1, new Location(xDLocation, yDLocation));
        gameField.addPlayer(defensivePlayer2, new Location(xDLocation2, yDLocation2));

        gameField.lock();

//        Quick loop to cycle movements.
        while(!GameManager.DEBUG_DUN){
            if(Math.abs(offensivePlayer.getLocation().getSecond() - defensivePlayer1.getLocation().getSecond()) <= 1){
//                Just a break because we dont have any way to handle tackles yet
                int i = 0;
            }
            System.out.println("Offensive Player Location is | ("+offensivePlayer.getLocation().getFirst()+","+offensivePlayer.getLocation().getSecond()+")");
            System.out.println("Defensive Player Location (1) is | ("+defensivePlayer1.getLocation().getFirst()+","+defensivePlayer1.getLocation().getSecond()+")");
            System.out.println("Defensive Player Location (2) is | ("+defensivePlayer2.getLocation().getFirst()+","+defensivePlayer2.getLocation().getSecond()+")");

            offense.cycle();
            defense.cycle();
            engine.cycleQueue(gameField.getMovementQueue(), gameField);
        }

    }
}
