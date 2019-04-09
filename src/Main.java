import Game.Field.CardinalDirection;
import Game.Field.Endzone;
import Game.Field.Field;
import Game.GamePlay.*;
import Game.GamePlay.TimeManagement.Clock;
import Game.GamePlay.PlayerStrategy.Defense.DefaultDefensiveStrategy;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Game.GamePlay.PlayerStrategy.Offense.DefaultOffensiveStrategy;
import Game.Routes.Route;
import Game.Routes.RouteActions.*;
import Game.Routes.RouteFactory;
import Utils.PhysicsObjects.Vector;
import Tuple.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * This is the "temp" GameManager class. Used for testing and such for now
     * @param args
     */
    public static void main(String[] args) {

        testRoutes();
//        This is a pseudo gameManager class. Eventually this will be cleaned up
//        And placed in its own class.

//        final IPlayerStrategy ballCarrierStrategy = new BallCarrierStrategy(null);
//        final IPlayerStrategy offensivePlayer1   = new DefaultOffensiveStrategy();
//        final IPlayerStrategy defensivePlayerStrategy1 = new DefaultDefensiveStrategy(null);
//        final IPlayerStrategy defensivePlayerStrategy2 = new DefaultDefensiveStrategy(null);
//        final IPlayerStrategy defensivePlayerStrategy3 = new DefaultDefensiveStrategy(null);
//
//        final double bcMass = 74.84;
//        final double b1Mass = 108.86;
//        final double d1Mass = 113.40;
//        final double d2Mass = 113.40;
//        final double d3Mass = 113.40;
//        final double d4Mass = 90.718;
//        final double d5Mass = 90.718;
//        final double d6Mass = 90.718;
//
//        final GamePlayer ballCarrier = new GamePlayer(bcMass, "BallCarrier", ballCarrierStrategy);
//        final GamePlayer blockerPlayer1 = new GamePlayer(b1Mass, "Blocker1",offensivePlayer1);
//        final GamePlayer defensivePlayer1 = new GamePlayer(d1Mass, "Linebacker1",defensivePlayerStrategy1);
//        final GamePlayer defensivePlayer2 = new GamePlayer(d2Mass, "Linebacker2",defensivePlayerStrategy2);
//        final GamePlayer defensivePlayer3 = new GamePlayer(d3Mass, "Linebacker3",defensivePlayerStrategy3);
//        final GamePlayer defensivePlayer4 = new GamePlayer(d4Mass, "Linebacker4",defensivePlayerStrategy1);
//        final GamePlayer defensivePlayer5 = new GamePlayer(d5Mass, "Linebacker5",defensivePlayerStrategy1);
//        final GamePlayer defensivePlayer6 = new GamePlayer(d6Mass, "Linebacker6",defensivePlayerStrategy1);
//
//        final GameTeam offense = new GameTeam(
//                Arrays.asList(
//                        ballCarrier
//                        ,blockerPlayer1
//                ), Field.GetSouthEndzone());
//        final GameTeam defense = new GameTeam(
//                Arrays.asList(
//                        defensivePlayer1
////                       ,defensivePlayer2
////                       ,defensivePlayer3
////                       ,defensivePlayer4
////                       ,defensivePlayer5
////                       ,defensivePlayer6
//                ), Field.GetNorthEndzone());
//
//        final GameManager gameManager = new GameManager(offense, defense, Clock.DefaultQuarterLength.QUARTER_15, Clock.DefaultPlayClock.PLAY_CLOCK_45);
//
////        Quick loop to cycle movements.
//
//        while(true){
//            gameManager.cycle();
//        }
    }

    private final static void testRoutes(){
        final Endzone offensiveGoal = Endzone.NORTH;
        final Endzone defensiveGoal = Endzone.SOUTH;

        final Route offensivePlayerRoute = getInRoute(CardinalDirection.WEST, offensiveGoal.getCardinalDirection(), 15);

        final IPlayerStrategy offensivePlayerStrat = new DefaultOffensiveStrategy(offensivePlayerRoute);

        final GamePlayer offensivePlayer = new GamePlayer(100, "Offensive Game Player", offensivePlayerStrat);

//        final IRouteAction defensiveFirstMovement = new RouteActionManCoverage(offensivePlayer);
        final IRouteAction firstDefenderMovement = new RouteActionZoneCoverage(15);
        final IRouteAction secondDefenderMovement = new RouteActionZoneCoverage(15);

        final Route defender1 = new RouteFactory().
                addToRoute(firstDefenderMovement).
                build().getRoute();

        final Route defender2 = new RouteFactory().
                addToRoute(secondDefenderMovement).
                build().getRoute();

        final IPlayerStrategy defensivePlayerStrat = new DefaultDefensiveStrategy(defender1);
        final IPlayerStrategy defensivePlayer2Strat = new DefaultDefensiveStrategy(defender2);

        final GamePlayer defensivePlayer = new GamePlayer(100, "Defensive Game Player 1", defensivePlayerStrat);
        final GamePlayer defensivePlayer2 = new GamePlayer(100, "Defensive Game Player 2", defensivePlayer2Strat);

        final List<GamePlayer> homeTeamList = Arrays.asList(
            offensivePlayer
        );

        final List<GamePlayer> awayTeamList = Arrays.asList(
            defensivePlayer,
            defensivePlayer2
        );

        final GameTeam homeTeam = new GameTeam(homeTeamList, offensiveGoal);
        final GameTeam awayTeam = new GameTeam(awayTeamList, defensiveGoal);
        final GameManager gameManager = new GameManager(homeTeam, awayTeam, Clock.DefaultQuarterLength.QUARTER_15, Clock.DefaultPlayClock.PLAY_CLOCK_45);

        while(true){
            gameManager.cycle();
        }
    }

    private final static Route getCurlRoute(final double distanceBeforeCurl, final CardinalDirection curlSide){
        final int sideCorrection = curlSide.getMovementAxisModifier();
        final Vector offensiveFirstMove = new Vector(new Tuple2<>(0.0, distanceBeforeCurl));
        final Vector offensiveSecondMove = new Vector(new Tuple2<>(3.0*sideCorrection, -3.0));

        final IRouteAction offensiveFirstMovement = new RouteActionMove(offensiveFirstMove);
        final IRouteAction offensiveSecondMovement = new RouteActionMove(offensiveSecondMove);

        final Route offensivePlayerRoute = new RouteFactory().
                addToRoute(offensiveFirstMovement).
                addToRoute(offensiveSecondMovement).
                build().getRoute();

        return offensivePlayerRoute;
    }

    private final static Route getDragRoute(final CardinalDirection dragSide){
        final int sideCorrection = dragSide.getMovementAxisModifier();
        final Vector firstMove  = new Vector(new Tuple2<>(0.0, 3.0));
        final Vector secondMove = new Vector(new Tuple2<>(1.0 * sideCorrection, 2.0));
        final Vector thirdMove  = new Vector(new Tuple2<>(2.0 * sideCorrection, 1.0));
        final Vector fourthMove = new Vector(new Tuple2<>(3.0 * sideCorrection, 0.0));
        final Vector fifthMove  = new Vector(sideCorrection == 1 ? 0.0 : Math.PI, Field.FIELD_WIDTH);

        final IRouteAction offensiveFirstMovement = new RouteActionMove(firstMove);
        final IRouteAction offensiveSecondMovement = new RouteActionMove(secondMove);
        final IRouteAction offensiveThirdMovement = new RouteActionMove(thirdMove);
        final IRouteAction offensiveFourthMovement = new RouteActionMove(fourthMove);
        final IRouteAction offensiveFifthMovement = new RouteActionMove(fifthMove);
//        final IRouteAction offensiveSixthMovement = new RouteActionLookForBall();
//        final IRouteAction finalMovement = new RouteActionLookForBall();

        final Route offensivePlayerRoute = new RouteFactory().
                addToRoute(offensiveFirstMovement).
                addToRoute(offensiveSecondMovement).
                addToRoute(offensiveThirdMovement).
                addToRoute(offensiveFourthMovement).
                addToRoute(offensiveFifthMovement).
                build().getRoute();

        return offensivePlayerRoute;
    }

    private final static Route getChairRoute(final CardinalDirection dragSide, final CardinalDirection goalSide){
        final int sideCorrection = dragSide.getMovementAxisModifier();
        final double distanceToChangeToUp = sideCorrection == 1 ?
                (Field.FIELD_WIDTH - 15):
                15;

        final Vector firstMove  = new Vector(new Tuple2<>(0.0, 3.0));
        final Vector secondMove = new Vector(new Tuple2<>(1.0 * sideCorrection, 2.0));
        final Vector thirdMove  = new Vector(new Tuple2<>(2.0 * sideCorrection, 1.0));
        final Vector fourthMove = new Vector(new Tuple2<>(3.0 * sideCorrection, 0.0));
        final Tuple2<Double, Double> fifthMove = new Tuple2<>(distanceToChangeToUp, Double.POSITIVE_INFINITY);
        final Tuple2<Double, Double> sixthMove = new Tuple2<>(Double.POSITIVE_INFINITY,
                goalSide.isNorth() ? 2 : Field.FIELD_HEIGHT - 2
                );
//        final Vector fifthMove  = new Vector(sideCorrection == 1 ? 0.0 : Math.PI, distanceToChangeToUp);
//        final Vector sixthMove  = new Vector(sideCorrection * (Math.PI / 2),
//                Field.FIELD_HEIGHT - receiver.getLocation().getSecond() - 1 -
//                    (new Vector(firstMove.getVectorAsTuple2(), fifthMove.getVectorAsTuple2()).getChangeY()));

        final IRouteAction offensiveFirstMovement = new RouteActionMove(firstMove);
        final IRouteAction offensiveSecondMovement = new RouteActionMove(secondMove);
        final IRouteAction offensiveThirdMovement = new RouteActionMove(thirdMove);
        final IRouteAction offensiveFourthMovement = new RouteActionMove(fourthMove);
        final IRouteAction offensiveFifthMovement = new RouteActionMove(fifthMove);
        final IRouteAction offensiveSixthMove = new RouteActionMove(sixthMove);

        final Route offensivePlayerRoute = new RouteFactory().
                addToRoute(offensiveFirstMovement).
                addToRoute(offensiveSecondMovement).
                addToRoute(offensiveThirdMovement).
                addToRoute(offensiveFourthMovement).
                addToRoute(offensiveFifthMovement).
                addToRoute(offensiveSixthMove).
                build().getRoute();

        return offensivePlayerRoute;
    }

    private final static Route getInRoute(final CardinalDirection inSide, final CardinalDirection yAxis, final double distanceBeforeCut){
        final Vector firstMove = new Vector(new Tuple2<>(0.0, distanceBeforeCut * yAxis.getMovementAxisModifier()));
        final Vector secondMove = new Vector(new Tuple2<>(Field.FIELD_HEIGHT * inSide.getMovementAxisModifier(), 0.0));

        final IRouteAction offensiveFirstMove = new RouteActionMove(firstMove);
        final IRouteAction offensiveSecondMove = new RouteActionMove(secondMove);

        final Route offensivePlayerRoute = new RouteFactory().
                addToRoute(offensiveFirstMove).
                addToRoute(offensiveSecondMove).
                build().getRoute();

        return offensivePlayerRoute;
    }

}

