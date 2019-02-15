package Game.GamePlay;

import Event.Event;
import Game.GamePlay.TimeManagement.Clock;
import Game.GamePlay.TimeManagement.Events.GameClockEmptyEvent;
import Game.GamePlay.TimeManagement.Events.PlayClockEmptyEvent;
import Utils.Signature;

import java.util.HashMap;
import java.util.Map;

public final class GameClock{

    private Clock quarter1Clock;
    private Clock quarter2Clock;
    private Clock quarter3Clock;
    private Clock quarter4Clock;

    private Clock overTimeClock;

    private Clock playClock;

    private Clock.ClockOwner playClockListener;

    private int quarter = 1;
    private int mQuarterLength;
    private int mPlayClockLength;

    //    TODO CORRECT THIS. REMOVE STATIC
    private static Clock currentQuarterClock;
    private static Clock.ClockOwner quarterClockListener;

    private final Signature mSig;

    private Map<Integer, Clock> quarterClockManager = new HashMap<>();

    public GameClock(final Signature signature, final Clock.DefaultQuarterLength quarterLength, final Clock.DefaultPlayClock playClockLength){
        mQuarterLength = quarterLength.getTime();
        mPlayClockLength = playClockLength.getTime();
        mSig = signature;
        init();
    }

//    public GameClock(final int quarterLength, final int playClockLength){
//        mQuarterLength = quarterLength;
//        mPlayClockLength = playClockLength;
//        init();
//    }

    private final void init(){
        quarterClockListener = this::handleQuarterTimeIsDun;
        playClockListener = this::handlePlayClockTimeIsDun;

        quarter1Clock = new Clock(mQuarterLength, quarterClockListener);
        quarter2Clock = new Clock(mQuarterLength, quarterClockListener);
        quarter3Clock = new Clock(mQuarterLength, quarterClockListener);
        quarter4Clock = new Clock(mQuarterLength, quarterClockListener);

        playClock = new Clock(mPlayClockLength, playClockListener);

        quarterClockManager.put(1, quarter1Clock);
        quarterClockManager.put(2, quarter2Clock);
        quarterClockManager.put(3, quarter3Clock);
        quarterClockManager.put(4, quarter4Clock);

        currentQuarterClock = quarterClockManager.get(quarter);
    }

    public final int getCurrentQuarter(){
        return quarter;
    }

//    TODO REMOVE STATIC
    public static final int getRemainingTimeInQuarter(){
        return currentQuarterClock.getRemainingTime();
    }

    public static final void tickQuarterClock(){
        currentQuarterClock.tick(quarterClockListener);
    }

    public static final void microTickQuarterClock(){
        currentQuarterClock.microTick(quarterClockListener);
    }

    public final int getPlayclockTime(){
        return playClock.getRemainingTime();
    }

    public final String getQuarterTimeReadable(){
        return currentQuarterClock.getReadableTime();
    }

    private final void handleQuarterTimeIsDun(){
//        For now we dont care much
        new GameClockEmptyEvent(mSig, quarter).fire();
    }

    private final void handlePlayClockTimeIsDun(){
//        For now we dont care much
        new PlayClockEmptyEvent(mSig).fire();
    }
}
