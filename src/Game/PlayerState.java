package Game;

import PhysicsEngine.Movements.Events.CollisionEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum PlayerState {

    /**
     * Jamming a receiver is technically blocking, so it receives the same state
     */
    BLOCKING (0),
    IS_BLOCKED (85),
    TACKLING (0),
    IS_TACKLED (95),
    BREAK_BLOCK (55),
    BREAK_TACKLE (80),
    COLLIDING (0),
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
        map.put(BLOCKING, IS_BLOCKED);
        map.put(TACKLING, IS_TACKLED);
        RESULT_STATES = Collections.unmodifiableMap(map);
    }

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

    public final boolean isBlocking(){ return this.equals(BLOCKING); }
    public final boolean isBlocked(){ return this.equals(IS_BLOCKED); }
    public final boolean isTackling(){ return this.equals(TACKLING); }
    public final boolean isTackled(){ return this.equals(IS_TACKLED); }
    public final boolean isColliding(){ return this.equals(COLLIDING); }
    public final boolean breakBlock(){ return this.equals(BREAK_BLOCK); }
    public final boolean breakTackle(){ return this.equals(BREAK_TACKLE); }
    public final boolean isNull() { return this.equals(NULL); }

}

//    DOWN,
//    BLOCKED,
//    TACKLED,
//    CATCHING,
//    COLLIDING,
//    NULL;
//
//    public final boolean isDown(){ return DOWN.equals(this); }
//
//    public final boolean isBlocked(){ return BLOCKED.equals(this); }
//
//    public final boolean isTackled(){ return TACKLED.equals(this); }
//
//    public final boolean isCatching(){ return CATCHING.equals(this); }
//
//    public final boolean isColliding(){ return COLLIDING.equals(this); }
//
//    public final boolean isNull(){ return NULL.equals(this); }
//}
