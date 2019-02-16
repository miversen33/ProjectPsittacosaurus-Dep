package Game.GamePlay;

import Game.GamePlay.TimeManagement.Clock;
import PhysicsEngine.Movements.Events.CollisionEvent;
import Utils.Event.EventHandler;
import Utils.Event.EventListener;
import Utils.Event.IEvent;
import Utils.Event.IEventType;
import Game.Field.Field;
import Game.GamePlay.Events.PlayerInEndzoneEventType;
import Game.GamePlay.Events.PlayerOutOfBoundsEventType;
import Game.GamePlay.TimeManagement.Events.GameClockOutEventType;
import Game.GamePlay.TimeManagement.Events.PlayClockOutEventType;
import PhysicsEngine.Movements.Events.CollisionEventType;
import PhysicsEngine.Movements.Events.TackleEventType;
import PhysicsEngine.Movements.MovementEngine;
import Tuple.Tuple2;
import Utils.Location;
import Utils.Observable.Observer;
import Utils.Signature;

import java.util.Arrays;
import java.util.List;

public final class GameManager {

    private final Observer<IEvent> mEventObserver;
    private final EventHandler mEventHandler;
    private final Signature mGameSignature;

    private final GameClock mGameClock;
    private final GameField mField;
    private final GameTeam mHomeTeam;
    private final GameTeam mAwayTeam;

    private final MovementEngine mMovementEngine;

    private final List<IEventType> mEventTypes = Arrays.asList(
            new GameClockOutEventType(),
            new PlayClockOutEventType(),
            new CollisionEventType(),
            new TackleEventType(),
            new PlayerInEndzoneEventType(),
            new PlayerOutOfBoundsEventType()
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
        mAwayTeam = awayTeam;
        mGameClock = generateGameClock(gameClock, playClock);
        mField = generateGameField();
        mMovementEngine = generateMovementEngine();

        init();
    }

    private final void init(){
        if(DEBUG){
            DEBUG_INIT();
        } else {

        }
    }

    private final void DEBUG_INIT(){
//        Lots of assumptions are made here. Obviously we cant actually do most of this

//        These should not be done here, but rather by a coach object or the player themselves
        final Tuple2<Double, Double> ballCarrierLocation = new Tuple2<>(30.0, Field.ENDZONE_HEIGHT);
        final Tuple2<Double, Double> defender1Location = new Tuple2<>(100.0, Field.FIELD_HEIGHT);

        final Tuple2<Double, Double> blockerLocation = new Tuple2<>(21.0, 15.0);
        final Tuple2<Double, Double> defender2Location = new Tuple2<>(10.0, 75.0);
        final Tuple2<Double, Double> defender3Location = new Tuple2<>(35.0, Field.FIELD_HEIGHT - Field.ENDZONE_HEIGHT);

        offense = mHomeTeam;
        defense = mAwayTeam;

        final GamePlayer ballCarrier = offense.getPlayers().get(0);
        ballCarrier.DEBUG_setBallCarrier(true);

        final GamePlayer defender = defense.getPlayers().get(0);

        mField.addPlayer(ballCarrier, new Location(ballCarrierLocation));
        mField.addPlayer(defender, new Location(defender1Location));

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
        return (key, itemChanged) -> {
//            We need a better way to handle this.
            if(itemChanged instanceof CollisionEvent){
                int i = 0;
            }
        };
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
