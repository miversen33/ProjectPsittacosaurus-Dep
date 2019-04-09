package Game;

import java.util.*;

public enum PlayerState {

    /**
     * Jamming a receiver is technically blocking, so it receives the same state
     */
    PASS_BLOCKING(0),
    RUN_BLOCKING (0),
    IS_BLOCKED (85),
    TACKLING (0),
    IS_TACKLED (95),
    BREAK_BLOCK (55),
    BREAK_TACKLE (80),
    COLLIDING (0),
    @Deprecated
    LOOK_FOR_BALL(0),
    BACKPEDALING(0),
    COVERING(0),
//    Consider if this needs a value
    IS_COVERED(0),
    NULL(0);

    private final static Map<PlayerState, PlayerState> COUNTER_STATES;
    static {
        Map<PlayerState, PlayerState> map = new HashMap<>();
        map.put(IS_BLOCKED, BREAK_BLOCK);
        map.put(IS_TACKLED, BREAK_TACKLE);
        COUNTER_STATES = Collections.unmodifiableMap(map);
    }

    private final static Map<PlayerState, PlayerState> RESULT_STATES;
    static {
        Map<PlayerState, PlayerState> map = new HashMap<>();
        map.put(PASS_BLOCKING, IS_BLOCKED);
        map.put(RUN_BLOCKING, IS_BLOCKED);
        map.put(TACKLING, IS_TACKLED);
        map.put(COVERING, IS_COVERED);
        RESULT_STATES = Collections.unmodifiableMap(map);
    }

    private final static List<PlayerState> OVERRIDABLE = Arrays.asList(
        NULL, LOOK_FOR_BALL
    );

    private final double defaultCounterValue;

    PlayerState(final double counterValue){
        defaultCounterValue = counterValue;
    }

    public final double getDefaultCounterValue(){
        return defaultCounterValue;
    }

    public final PlayerState getCounterState(){
        if(!COUNTER_STATES.containsKey(this)) return NULL;
        return COUNTER_STATES.get(this);
    }

    public final PlayerState getResultState(){
        if(!RESULT_STATES.containsKey(this)) return NULL;
        return RESULT_STATES.get(this);
    }

    public final boolean isBlocking(){ return this.equals(PASS_BLOCKING) || this.equals(RUN_BLOCKING); }
    public final boolean isBlocked(){ return this.equals(IS_BLOCKED); }
    public final boolean isTackling(){ return this.equals(TACKLING); }
    public final boolean isTackled(){ return this.equals(IS_TACKLED); }
    public final boolean isColliding(){ return this.equals(COLLIDING); }
    public final boolean breakBlock(){ return this.equals(BREAK_BLOCK); }
    public final boolean breakTackle(){ return this.equals(BREAK_TACKLE); }
    public final boolean isBackPedaling(){ return this.equals(BACKPEDALING); }
    public final boolean isCovering(){ return this.equals(COVERING); }
    public final boolean isCovered(){ return this.equals(IS_COVERED); }
    public final boolean isNull() { return this.equals(NULL); }

    public final boolean isOverridable(){ return OVERRIDABLE.contains(this); }

}
