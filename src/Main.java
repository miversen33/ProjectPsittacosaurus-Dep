import Game.Field.Ball.GameBall;
import Game.Field.Ball.GameBallState;
import Game.Field.CardinalDirection;
import Game.Field.Endzone;
import Game.Field.Field;
import Game.GamePlay.GameManager;
import Game.GamePlay.GamePlayer;
import Game.GamePlay.GameTeam;
import Game.GamePlay.PlayerStrategy.Defense.DefaultDefensiveStrategy;
import Game.GamePlay.PlayerStrategy.IPlayerStrategy;
import Game.GamePlay.PlayerStrategy.Offense.DefaultOffensiveStrategy;
import Game.GamePlay.TimeManagement.Clock;
import Game.Routes.Route;
import Game.Routes.RouteActions.IRouteAction;
import Game.Routes.RouteActions.RouteActionMove;
import Game.Routes.RouteActions.RouteActionZoneCoverage;
import Game.Routes.RouteFactory;
import Position.Defense.*;
import Position.Offense.*;
import Position.Position;
import Position.SpecialTeams.Kicker;
import Position.SpecialTeams.Punter;
import Tuple.Tuple2;
import Utils.PhysicsObjects.Vector;
import Utils.RNG;
import Utils.Signature;
import Utils.XML.XMLEntry;
import Utils.XML.XMLParent;
import Utils.XML.XMLReader;
import Utils.XML.XMLWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static Utils.XML.XMLStrings.LINE_BREAK;

public class Main {

    /**
     * This is the "temp" GameManager class. Used for testing and such for now
     * @param args
     */
    public static void main(String[] args) {

        testXMLReader();
//        testGameBall();
//        testSeedGeneration(80);
//        testSeedGeneration(40);
//        testSeedGeneration(70);
//        testSeedGeneration(99);
//        testSeedGeneration(150);

//        testNormalGeneration(495);

//        testRoutes();
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

    private final static void testXMLReader(){
        final String fileLocation = "/home/mike/git/ProjectPsittacosaurus/testResources/";
//        final String fileLocation = "/home/miversen33/git/ProjectPsittacosaurus/testResources/";
//        final String inputFile = fileLocation + "formationTest.xml";
        final String outputFile = fileLocation + "formationOutputTest.xml";
        final String inputFile = fileLocation + "formationOutputTest.xml";
        XMLEntry entry = null;
        try {
            entry = XMLReader.Read(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XMLParent p = (XMLParent) entry;
        try {
            XMLWriter.NewInstance(outputFile, p).write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final static void testGameBall(){
        final Signature signature = Signature.GenerateNewSignature();
        final GameManager m = new GameManager();
        final GameBall ball = new GameBall(signature, m);

        double startTime = System.currentTimeMillis();
        double count = 1000;

        while(true) {
            if (startTime + count < System.currentTimeMillis()) {
                double rng = RNG.Generate(0,100);
                if (rng < 50) {
                    if(ball.getPossessionState().isInPossession()){
                        ball.lostPossession(m);
                    }
                } else {
                    ball.changePossession(m);
                }
                startTime = System.currentTimeMillis();
            }
        }
    }

    private final static void testSeedGeneration(final int seedValue){

        Position coverageCornerback = Cornerback.GenerateCoverageCornerback(seedValue);
        Position neutralCornerback = Cornerback.GenerateNeutralCornerback(seedValue);
        Position ballhawkCornerback = Cornerback.GenerateHardhittingCornerback(seedValue);

        Position passDefensiveEnd = DefensiveEnd.GeneratePassrushDefensiveEnd(seedValue);
        Position runDefensiveEnd = DefensiveEnd.GenerateRunrushDefensiveEnd(seedValue);
        Position neutralDefensiveEnd = DefensiveEnd.GenerateNeutralrushDefensiveEnd(seedValue);

        Position runDefensiveTackle = DefensiveTackle.GenerateRunrushDefensiveTackle(seedValue);
        Position passDefensiveTackle = DefensiveTackle.GeneratePassrushDefensiveTackle(seedValue);
        Position neutralDefensiveTackle = DefensiveTackle.GenerateNeutralrushDefensiveTackle(seedValue);
//
        Position coverageFreeSafety = FreeSafety.GenerateCoverageFreeSafety(seedValue);
        Position hardhitterFreeSafety = FreeSafety.GenerateHardhittingFreeSafety(seedValue);
        Position neutralFreeSafety = FreeSafety.GenerateNeutralFreeSafety(seedValue);

        Position coverageMiddleLinebacker = MiddleLinebacker.GenerateCoverageMiddleLinebacker(seedValue);
        Position blitzMiddleLinebacker = MiddleLinebacker.GenerateBlitzingMiddleLinebacker(seedValue);
        Position neutralMiddleLinebacker = MiddleLinebacker.GenerateNeutralMiddleLinebacker(seedValue);

        Position coverageOutsideLinebacker = OutsideLinebacker.GenerateCoverageOutsideLinebacker(seedValue);
        Position blitzOutsideLinebacker = OutsideLinebacker.GenerateBlitzingOutsideLinebacker(seedValue);
        Position neutralOutsideLinebacker = OutsideLinebacker.GenerateNeutralOutsideLinebacker(seedValue);

        Position coverageStrongSafety = StrongSafety.GenerateCoverageStrongSafety(seedValue);
        Position hardHitterStrongSafety = StrongSafety.GenerateHardhittingStrongSafety(seedValue);
        Position neutralStrongSafety = StrongSafety.GenerateNeutralStrongSafety(seedValue);

        Position runBlockingCenter = Center.GenerateRunblockCenter(seedValue);
        Position passBlockingCenter = Center.GeneratePassblockCenter(seedValue);
        Position neutralCenter = Center.GenerateNeutralCenter(seedValue);

        Position runBlockingGuard = Guard.GenerateRunblockGuard(seedValue);
        Position passBlockingGuard = Guard.GeneratePassblockGuard(seedValue);
        Position neutralGuard = Guard.GenerateNeutralGuard(seedValue);

        Position runBlockingOffensiveTackle = OffensiveTackle.GenerateRunblockOffensiveTackle(seedValue);
        Position passBlockingOffensiveTackle = OffensiveTackle.GeneratePassblockOffensiveTackle(seedValue);
        Position neutralOffensiveTackle = OffensiveTackle.GenerateNeutralOffensiveTackle(seedValue);

        Position rushingFullback = Fullback.GenerateRushingFullback(seedValue);
        Position blockingFullBack = Fullback.GenerateBlockingFullback(seedValue);
        Position neutralFullback = Fullback.GenerateNeutralFullback(seedValue);

        Position speedHalfBack = HalfBack.GenerateSpeedHalfBack(seedValue);
        Position powerHalfBack = HalfBack.GeneratePowerHalfBack(seedValue);
        Position neutralHalfBack = HalfBack.GenerateNeutralHalfBack(seedValue);

        Position runningQuarterback = Quarterback.GenerateRushingQuarterback(seedValue);
        Position passingQuarterback = Quarterback.GeneratePassingQuarterback(seedValue);
        Position neutralQuarterback = Quarterback.GenerateNeutralQuarterback(seedValue);

        Position blockingTightEnd = TightEnd.GenerateBlockingTightEnd(seedValue);
        Position receivingTightEnd = TightEnd.GenerateReceivingTightEnd(seedValue);
        Position neutralTightEnd = TightEnd.GenerateNeutralTightEnd(seedValue);

        Position possessionWideReceiver = WideReceiver.GeneratePossessionWideReceiver(seedValue);
        Position speedWideReceiver = WideReceiver.GenerateSpeedWideReceiver(seedValue);
        Position neutralWideReceiver = WideReceiver.GenerateNeutralWideReceiver(seedValue);

        Position accurateKicker = Kicker.GenerateAccurateKicker(seedValue);
        Position powerKicker = Kicker.GeneratePowerKicker(seedValue);
        Position neutralKicker = Kicker.GenerateNeutralKicker(seedValue);

        Position accuratePunter = Punter.GenerateAccuratePunter(seedValue);
        Position powerPunter = Punter.GeneratePowerPunter(seedValue);
        Position neutralPunter = Punter.GenerateNeutralPunter(seedValue);

        int i = 0;
    }

//    private final static void testPositionGeneration(){
//        double time = System.currentTimeMillis();
//         Position position = Quarterback.GenerateRunningQuarterback(80);
//         Position position = Quarterback.GeneratePassingQuarterback(80);
//         Position position = Quarterback.GenerateNeutralQuarterback(80);

//         Position position = HalfBack.GenerateSpeedTailBack(80);
//         Position position = HalfBack.GeneratePowerHalfBack(80);
//         Position position = HalfBack.GenerateNeutralHalfBack(80);

//         Position position = Fullback.GenerateRushingFullback(80);
//         Position position = Fullback.GenerateBlockingFullBack(80);
//         Position position = Fullback.GenerateNeutralFullback(80);

//         Position position = Guard.GenerateRunblockGuard(80);
//         Position position = Guard.GeneratePassblockGuard(80);
//         Position position = Guard.GenerateNeutralGuard(80);

//         Position position = Center.GenerateRunblockCenter(80);
//         Position position = Center.GeneratePassblockCenter(80);
//         Position position = Center.GenerateNeutralCenter(80);

//        Position position = OffensiveTackle.GenerateRunblockOffensiveTackle(80);
//        Position position = OffensiveTackle.GeneratePassblockOffensiveTackle(80);
//        Position position = OffensiveTackle.GenerateNeutralOffensiveTackle(80);

//        Position position = TightEnd.GenerateBlockingTightEnd(80);
//        Position position = TightEnd.GenerateReceivingTightEnd(80);
//        Position position = TightEnd.GenerateNeutralTightEnd(80);

//        Position position = WideReceiver.GeneratePossessionWideReceiver(80);
//        Position position = WideReceiver.GenerateSpeedWideReceiver(80);
//        Position position = WideReceiver.GenerateNeutralWideReceiver(80);

//        Position position = Cornerback.GenerateCoverageCornerback(80);
//        Position position = Cornerback.GenerateBallhawkCornerback(80);
//        Position position = Cornerback.GenerateNeutralCornerback(80);

//        Position position = DefensiveEnd.GeneratePassDefensiveEnd(80);
//        Position position = DefensiveEnd.GenerateRunDefensiveEnd(80);
//        Position position = DefensiveEnd.GenerateNeutralDefensiveEnd(80);

//        Position position = DefensiveTackle.GenerateRunDefensiveTackle(80);
//        Position position = DefensiveTackle.GeneratePassDefensiveTackle(80);
//        Position position = DefensiveTackle.GenerateNeutralDefensiveTackle(80);

//        Position position = MiddleLinebacker.GenerateCoverageMiddleLinebacker(80);
//        Position position = MiddleLinebacker.GenerateBlitzMiddleLinebacker(80);
//        Position position = MiddleLinebacker.GenerateNeutralMiddleLinebacker(80);

//        Position position = OutsideLinebacker.GenerateCoverageOutsideLinebacker(80);
//        Position position = OutsideLinebacker.GenerateBlitzOutsideLinebacker(80);
//        Position position = OutsideLinebacker.GenerateNeutralOutsideLinebacker(80);

//        Position position = FreeSafety.GenerateNeutralFreeSafety(80);
//        Position position = FreeSafety.GenerateCoverageFreeSafety(80);
//        Position position = FreeSafety.GenerateHardhitterFreeSafety(80);

//        Position position = StrongSafety.GenerateCoverageStrongSafety(80);
//        Position position = StrongSafety.GenerateHardHitterStrongSafety(80);
//        Position position = StrongSafety.GenerateNeutralStrongSafety(80);

//        Position position = Kicker.GenerateAccurateKicker(80);
//        Position position = Kicker.GeneratePowerKicker(80);
//        Position position = Kicker.GenerateNeutralKicker(80);

//        Position position = Punter.GenerateAccuratePunter(80);
//        Position position = Punter.GeneratePowerPunter(80);
//        Position position = Punter.GenerateNeutralPunter(80);

//        System.out.println("Player Generation Took Approx: "+(System.currentTimeMillis() - time)+" ms");
//        System.out.println("Position Overall Rating is "+position.getOverallRating());
//        int i = 0;
//    }

    private final static void testRoutes(){
        final Signature signature = Signature.GenerateNewSignature();
        final Endzone offensiveGoal = Endzone.NORTH;
        final Endzone defensiveGoal = Endzone.SOUTH;

        final Route offensivePlayerRoute =
                getChairRoute(CardinalDirection.WEST, offensiveGoal.getCardinalDirection());
//                getInRoute(CardinalDirection.WEST, offensiveGoal.getCardinalDirection(), 15);

        final IPlayerStrategy offensivePlayerStrat = new DefaultOffensiveStrategy(offensivePlayerRoute);

        final GamePlayer offensivePlayer = new GamePlayer(100, "Offensive Game Player", offensivePlayerStrat, signature);

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

        final GamePlayer defensivePlayer = new GamePlayer(100, "Defensive Game Player 1", defensivePlayerStrat, signature);
        final GamePlayer defensivePlayer2 = new GamePlayer(100, "Defensive Game Player 2", defensivePlayer2Strat, signature);

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

