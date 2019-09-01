package Game.GamePlay;

import Game.GamePlay.TimeManagement.Clock;
import Game.GamePlay.TimeManagement.Events.GameClockEmptyEvent;
import Game.GamePlay.TimeManagement.Events.PlayClockEmptyEvent;

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

    private Clock currentQuarterClock;
    private Clock.ClockOwner quarterClockListener;

    private Map<Integer, Clock> quarterClockManager = new HashMap<>();

    public GameClock(final Clock.DefaultQuarterLength quarterLength, final Clock.DefaultPlayClock playClockLength){
        mQuarterLength = quarterLength.getTime();
        mPlayClockLength = playClockLength.getTime();
        init();
    }

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

    public final int getRemainingTimeInQuarter(){
        return currentQuarterClock.getRemainingTime();
    }

    public final void tickQuarterClock(){
        currentQuarterClock.tick(quarterClockListener);
    }

    public final void microTickQuarterClock(){
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
        new GameClockEmptyEvent(quarter).fire();
    }

    private final void handlePlayClockTimeIsDun(){
//        For now we dont care much
        new PlayClockEmptyEvent().fire();
    }
}
