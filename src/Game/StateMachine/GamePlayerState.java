package Game.StateMachine;

import StateMachines.State;

import java.util.*;

public final class GamePlayerState extends State {

    public final static String PASS_BLOCKING = "Pass Blocking";
    public final static String RUN_BLOCKING  = "Run Blocking";
    public final static String IS_BLOCKED    = "Blocked";
    public final static String TACKLING      = "Tackling";
    public final static String IS_TACKLED    = "Tackled";
    public final static String BREAK_BLOCK   = "Break Block";
    public final static String BREAK_TACKLE  = "Break Tackle";
    public final static String COLLIDING     = "Colliding";
    public final static String COVERING      = "Covering";
    public final static String IS_COVERED    = "Covered";
    private final static String BACKPEDALING = "Back Pedaling";
    private final static String NULL         = "Null";

    public final static GamePlayerState PassBlocking = new GamePlayerState(PASS_BLOCKING, 0);
    public final static GamePlayerState RunBlocking  = new GamePlayerState(RUN_BLOCKING, 0);
    public final static GamePlayerState IsBlocked    = new GamePlayerState(IS_BLOCKED, 85);
    public final static GamePlayerState Tackling     = new GamePlayerState(TACKLING, 0);
    public final static GamePlayerState IsTackled    = new GamePlayerState(IS_TACKLED, 95);
    public final static GamePlayerState BreakBlock   = new GamePlayerState(BREAK_BLOCK, 55);
    public final static GamePlayerState BreakTackle  = new GamePlayerState(BREAK_TACKLE, 80);
    public final static GamePlayerState Colliding    = new GamePlayerState(COLLIDING, 0);
    public final static GamePlayerState Covering     = new GamePlayerState(COVERING, 0);
    public final static GamePlayerState IsCovered    = new GamePlayerState(IS_COVERED, 0);
    public final static GamePlayerState Backpedaling = new GamePlayerState(BACKPEDALING, 0);
    public final static GamePlayerState Null         = new GamePlayerState(NULL, 0);


    private final static Map<GamePlayerState, GamePlayerState> COUNTER_STATES;
    static {
        Map<GamePlayerState, GamePlayerState> map = new HashMap<>();
        map.put(IsBlocked, BreakBlock);
        map.put(IsTackled, BreakTackle);
        COUNTER_STATES = Collections.unmodifiableMap(map);
    }

    private final static Map<GamePlayerState, GamePlayerState> RESULT_STATES;
    static {
        Map<GamePlayerState, GamePlayerState> map = new HashMap<>();
        map.put(PassBlocking, IsBlocked);
        map.put(RunBlocking, IsBlocked);
        map.put(Tackling, IsTackled);
        map.put(Covering, IsCovered);
        RESULT_STATES = Collections.unmodifiableMap(map);
    }

    private final static List<GamePlayerState> OVERRIDABLE = Arrays.asList(
            Null
    );

    private final double counter;
    private GamePlayerState(final String newState, final int defaultCounterValue) {
        super(newState);
        counter = defaultCounterValue;
    }

    public final double getCounterValue(){
        return counter;
    }

    public final GamePlayerState getCounterState(){
        if(!COUNTER_STATES.containsKey(this)) return Null;
        return COUNTER_STATES.get(this);
    }

    public final GamePlayerState getResultState(){
        if(!RESULT_STATES.containsKey(this)) return Null;
        return RESULT_STATES.get(this);
    }

    public final boolean isBlocking(){
        return equals(PassBlocking) || equals(RunBlocking);
    }

    public final boolean isBlocked(){
        return equals(IsBlocked);
    }

    public final boolean isTackling(){
        return equals(Tackling);
    }

    public final boolean isTackled(){
        return equals(IsTackled);
    }

    public final boolean isColliding(){
        return equals(Colliding);
    }

    public final boolean breakBlock(){
        return equals(BreakBlock);
    }

    public final boolean breakTackle(){
        return equals(BreakTackle);
    }

    public final boolean isBackPedaling(){
        return equals(Backpedaling);
    }

    public final boolean isCovering(){
        return equals(Covering);
    }

    public final boolean isCovered(){
        return equals(IsCovered);
    }

    public final boolean isNull(){
        return equals(Null);
    }

    @Deprecated
    public final boolean isOverridable(){
        return OVERRIDABLE.contains(this);
    }

}
