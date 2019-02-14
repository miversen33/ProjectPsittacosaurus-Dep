package Game.GamePlay.TimeManagement;

public final class Clock {

    public interface ClockOwner{
        void outOfTime();
    }

    public enum DefaultValues{

        QUARTER_15(900000),
        QUARTER_10(600000),
        QUARTER_7(420000),
        PLAY_CLOCK_45(45000),
        PLAY_CLOCK_30(30000);

        private final int time;

        DefaultValues(int amount){
            time = amount;
        }

        public final int getTime(){
            return time;
        }

        public final boolean isQuarterTime(){
            return (QUARTER_15.equals(this) || QUARTER_10.equals(this) || QUARTER_7.equals(this));
        }
    }


    private final static int MILLISECONDS_IN_MINUTE = 60000;
    private final static int MILLISECONDS_IN_SECOND = 1000;

    private final static int TICK = -1 * MILLISECONDS_IN_SECOND;
    private final static int MICRO_TICK = -200;

    private final int timeLimit;
    private int remainingTime;
    private ClockOwner owner;

    /**
     * Clock operates in milliseconds.
     */
    public Clock(final int startTime, final ClockOwner clockOwner){
        timeLimit = startTime;
        remainingTime = timeLimit;
        owner = clockOwner;
    }

    /**
     * Clock operates in milliseconds.
     */
    public Clock(final DefaultValues startTime, final ClockOwner clockOwner){
        this(startTime.getTime(), clockOwner);
    }

    public final void resetClock(final ClockOwner clockOwner){
        if(!owner.equals(clockOwner)){
//            Log shenanigans about failed security check
            return;
        }
        if(remainingTime > 0){
//            Log reset when not at 0 time.
        }
        remainingTime = timeLimit;
    }
    public final int getRemainingTime(){
        return remainingTime;
    }

//    Returns time in mm:ss format
    public final String getReadableTime(){
        if(remainingTime <= MILLISECONDS_IN_MINUTE) return Integer.toString(remainingTime);
        int minutes = remainingTime / MILLISECONDS_IN_MINUTE;
        int seconds = (remainingTime % MILLISECONDS_IN_MINUTE) / MILLISECONDS_IN_SECOND;
        return minutes + " : " + seconds;
    }

    public final void tick(final ClockOwner clockOwner){
        adjust(TICK, clockOwner);
    }

    public final void microTick(final ClockOwner clockOwner){
        adjust(MICRO_TICK, clockOwner);
    }

    /**
     * Make sure that timeToAdjust is the correct sign. IE
     * if you are expecting to remove time from the clock, this needs
     * to be a negative number. If you are looking to add time to the clock
     * this should be a positive number
     */
    public final void adjust(final int timeToAdjust, final ClockOwner clockOwner){
        if(!owner.equals(clockOwner)){
//            Log invalid clock owner. Do not adjust time. Someone is gonna be upset.
//            TODO
            return;
        }
        adjust(timeToAdjust);
    }

    public final void skip(final int skipAmountInMillis, final ClockOwner clockOwner){
        adjust(skipAmountInMillis * -1, clockOwner);
    }

    private final void adjust(final int timeToAdjust){
        if(remainingTime > 0) remainingTime += timeToAdjust;
        if(remainingTime <= 0) owner.outOfTime();
    }

}
