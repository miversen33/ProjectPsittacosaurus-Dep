package Game.GamePlay;

import Event.EventHandler;
import Event.EventListener;
import Event.IEvent;
import Event.IEventType;
import Game.GamePlay.Events.PlayerInEndzoneEventType;
import Game.GamePlay.Events.PlayerOutOfBoundsEventType;
import Game.GamePlay.TimeManagement.Clock;
import Game.GamePlay.TimeManagement.Events.GameClockOutEventType;
import Game.GamePlay.TimeManagement.Events.PlayClockOutEventType;
import PhysicsEngine.Movements.Events.CollisionEventType;
import PhysicsEngine.Movements.Events.TackleEventType;
import PhysicsEngine.Movements.MovementEngine;
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


    public GameManager(final GameTeam homeTeam, final GameTeam awayTeam, final Clock.DefaultQuarterLength gameClock, final Clock.DefaultPlayClock playClock){
        mEventObserver = getEventObserver();
        mEventHandler = getEventHandler();
        mGameSignature = mEventHandler.getSignature();

        mHomeTeam = homeTeam;
        mAwayTeam = awayTeam;
        mGameClock = generateGameClock(gameClock, playClock);
        mField = generateGameField();
        mMovementEngine = generateMovementEngine();
    }

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

        };
    }

}
