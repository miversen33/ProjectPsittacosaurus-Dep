package Game.GamePlay;

import Game.GamePlay.Events.PlayerInEndzoneEvent;
import Game.GamePlay.Events.PlayerOutOfBoundsEvent;
import Game.GamePlay.TimeManagement.Clock;
import Game.GamePlay.TimeManagement.Events.GameClockEmptyEvent;
import Game.GamePlay.TimeManagement.Events.PlayClockEmptyEvent;
import PhysicsEngine.Movements.Events.*;
import Utils.Event.EventHandler;
import Utils.Event.EventListener;
import Utils.Event.IEvent;
import Game.Field.Field;
import PhysicsEngine.Movements.MovementEngine;
import Tuple.Tuple2;
import Utils.Location;
import Utils.Observable.Observer;
import Utils.Signature;

import java.util.Arrays;
import java.util.List;

public final class GameManager {

    public final static int ON_FIELD_TEAM_SIZE = 11;

    private final Observer<IEvent> mEventObserver;
    private final EventHandler mEventHandler;
    private final Signature mGameSignature;

    private final GameClock mGameClock;
    private final GameField mField;
    private final GameTeam mHomeTeam;
    private final GameTeam mAwayTeam;

    private final MovementEngine mMovementEngine;

    private final List<String> mEventTypes = Arrays.asList(
            GameClockEmptyEvent.NAME,
            PlayClockEmptyEvent.NAME,
            CollisionEvent.NAME,
            TackleEvent.NAME,
            PlayerInEndzoneEvent.NAME,
            PlayerOutOfBoundsEvent.NAME,
            BreakTackleEvent.NAME
    );

    private GameTeam offense;
    private GameTeam defense;

    private String fieldLock;

    private final boolean DEBUG = true;

    public GameManager(final GameTeam homeTeam, final GameTeam awayTeam, final Clock.DefaultQuarterLength gameClock, final Clock.DefaultPlayClock playClock){
        mEventObserver = getEventObserver();
        mEventHandler = getEventHandler();
        mGameSignature = mEventHandler.getSignature();

        mHomeTeam = homeTeam;
        mHomeTeam.signTeam(mGameSignature);
        mHomeTeam.setGameManager(this);
        mAwayTeam = awayTeam;
        mAwayTeam.signTeam(mGameSignature);
        mAwayTeam.setGameManager(this);

        mGameClock = generateGameClock(gameClock, playClock);
        mField = generateGameField();
        mMovementEngine = generateMovementEngine();

        init();
    }

    private final void init(){
        if(DEBUG){
            DEBUG_INIT();
        } else {
            finishInit();
        }
    }

    private final void finishInit(){

    }

    private final void DEBUG_INIT(){
        //TODO
//        Lots of assumptions are made here. Obviously we cant actually do most of this

//        These should not be done here, but rather by a coach object or the player themselves
        final Tuple2<Double, Double> offensive1Location = new Tuple2<>(Field.FIELD_WIDTH - 20, Field.FIELD_HEIGHT - 30);
        final Tuple2<Double, Double> defender1Location = new Tuple2<>(offensive1Location.getFirst() - 30, offensive1Location.getSecond() - 25);
        final Tuple2<Double, Double> defender2Location = new Tuple2<>(offensive1Location.getFirst() - 75, offensive1Location.getSecond() - 25);

        offense = mHomeTeam;
        defense = mAwayTeam;

        final GamePlayer offensive1 = offense.getPlayers().get(0);
        offensive1.DEBUG_setBallCarrier(true);

        mField.addPlayer(offensive1, new Location(offensive1Location));

        final GamePlayer defender = defense.getPlayers().get(0);
        final GamePlayer defender2 = defense.getPlayers().get(1);

        mField.addPlayer(defender, new Location(defender1Location));
        mField.addPlayer(defender2, new Location(defender2Location));

        fieldLock = mField.lock();
    }

//    \/ Generating stuff needed for gameplay

    private final GameClock generateGameClock(final Clock.DefaultQuarterLength g, final Clock.DefaultPlayClock p){
        return new GameClock(mGameSignature, g, p);
    }

    private final GameField generateGameField(){
        return new GameField(mGameSignature);
    }

    private final MovementEngine generateMovementEngine(){
        return new MovementEngine(mGameSignature);
    }

    private final EventHandler getEventHandler(){
        return EventListener.CreateListener(mEventObserver, mEventTypes);
    }

    private final Observer<IEvent> getEventObserver(){
//        This should be handled by an external manager. We should register ourselves as an event
//        handler for the following events.
        return (key, event) -> {
            switch (key.toString()){
                case PlayerInEndzoneEvent.NAME:
                    handlePlayerInEndzone((PlayerInEndzoneEvent) event);
                    break;

                case GameClockEmptyEvent.NAME:
                    handleQuarterClockEmpty();
                    break;

                case PlayClockEmptyEvent.NAME:
                    handlePlayClockEmpty();
                    break;

                case CollisionEvent.NAME:
                    handleCollisionCheck((CollisionEvent) event);
                    break;

                case PlayerOutOfBoundsEvent.NAME:
                    handlePlayerOutOfBounds((PlayerOutOfBoundsEvent) event);
                    break;

                case TackleEvent.NAME:
                    handleTackle((TackleEvent) event);
                    break;

                case BreakTackleEvent.NAME:
                    handleBreakTackle((BreakTackleEvent) event);
            }
        };
    }

    private final void handleBreakTackle(final BreakTackleEvent event){
        int i = 0;
    }

    private final void handleTackle(final TackleEvent event){
        int i = 0;
    }

    private final void handlePlayerInEndzone(final PlayerInEndzoneEvent event){
        if(event.getPlayer().getBallCarrier().equals(event.getPlayer())){
            int i = 0;
        }
    }

    private final void handleQuarterClockEmpty(){
        int i = 0;
    }

    private final void handlePlayClockEmpty(){
        int i = 0;
    }

    private final void handleCollisionCheck(final CollisionEvent event){
        int i = 0;
    }

    private final void handlePlayerOutOfBounds(final PlayerOutOfBoundsEvent event){
        int i = 0;
    }

//    /\ Generating stuff needed for gameplay

    public final void cycle(){
        mField.DEBUG_DumpPlayerLocations();
        offense.cycle();
        defense.cycle();
        mMovementEngine.cycleQueue(mField.getMovements(mGameSignature), mField,this);
    }

    public final void tickGameClock(final Signature signature){
        if(!Signature.ValidateSignatures(mGameSignature, signature)){
//            Handle logging due to possible malicious clock attempt
//            TODO LOGGING
            return;
        }
        mGameClock.tickQuarterClock();
    }

    public final void microTickGameClock(final Signature signature){
        if(!Signature.ValidateSignatures(mGameSignature, signature)){
//            Handle logging due to possible malicious clock attempt
//            TODO LOGGING
            return;
        }
        mGameClock.microTickQuarterClock();
    }

    public final int getTimeStamp(){
        return mGameClock.getRemainingTimeInQuarter();
    }

}
