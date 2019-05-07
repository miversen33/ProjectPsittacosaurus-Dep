package Position.Lists;

public class SubPositionList{

    public final static String NEUTRAL = "Neutral";
    private final static String COVERAGE = "Coverage";
    private final static String HARDHITTER = "Hard Hitter";
    private final static String RUN_RUSH = "Run Rush";
    private final static String PASS_RUSH = "Pass Rush";
    private final static String BLITZING = "Blitzing";
    private final static String PASS_BLOCK = "Pass Block";
    private final static String RUN_BLOCK = "Pass Block";
    private final static String BLOCKING = "Blocking";
    private final static String RUSHING = "Rushing";
    private final static String SPEED = "Speed";
    private final static String POWER = "Power";
    private final static String PASSING = "Passing";
    private final static String RECEIVING = "Receiving";
    private final static String POSSESSION = "Possession";
    private final static String ACCURATE = "Accurate";

    private static class NEUTRAL{
        public final static String NEUTRAL = SubPositionList.NEUTRAL;
    }

    public final static class CORNERBACK extends NEUTRAL{
        public final static String COVERAGE = SubPositionList.COVERAGE;
        public final static String HARDHITTER = SubPositionList.HARDHITTER;
    }

    public final static class DEFENSIVE_END extends NEUTRAL{
        public final static String RUN_RUSH = SubPositionList.RUN_RUSH;
        public final static String PASS_RUSH = SubPositionList.PASS_RUSH;
    }

    public final static class DEFENSIVE_TACKLE extends NEUTRAL{
        public final static String RUN_RUSH = SubPositionList.RUN_RUSH;
        public final static String PASS_RUSH = SubPositionList.PASS_RUSH;
    }

    public final static class FREE_SAFETY extends NEUTRAL{
        public final static String COVERAGE = SubPositionList.COVERAGE;
        public final static String HARDHITTER = SubPositionList.HARDHITTER;
    }

    public final static class STRONG_SAFETY extends NEUTRAL{
        public final static String COVERAGE = SubPositionList.COVERAGE;
        public final static String HARDHITTER = SubPositionList.HARDHITTER;
    }

    public final static class MIDDLE_LINEBACKER extends NEUTRAL{
        public final static String BLITZING = SubPositionList.BLITZING;
        public final static String COVERAGE = SubPositionList.COVERAGE;
    }

    public final static class OUTSIDE_LINEBACKER extends NEUTRAL{
        public final static String BLITZING = SubPositionList.BLITZING;
        public final static String COVERAGE = SubPositionList.COVERAGE;
    }
    
    public final static class CENTER extends NEUTRAL{
        public final static String RUN_BLOCK = SubPositionList.RUN_BLOCK;
        public final static String PASS_BLOCK = SubPositionList.PASS_BLOCK;
    }

    public final static class GUARD extends NEUTRAL{
        public final static String RUN_BLOCK = SubPositionList.RUN_BLOCK;
        public final static String PASS_BLOCK = SubPositionList.PASS_BLOCK;
    }

    public final static class OFFENSIVE_TACKLE extends NEUTRAL{
        public final static String RUN_BLOCK = SubPositionList.RUN_BLOCK;
        public final static String PASS_BLOCK = SubPositionList.PASS_BLOCK;
    }

    public final static class FULLBACK extends NEUTRAL{
        public final static String BLOCKING = SubPositionList.BLOCKING;
        public final static String RUSHING = SubPositionList.RUSHING;
    }

    public final static class HALFBACK extends NEUTRAL{
        public final static String SPEED = SubPositionList.SPEED;
        public final static String POWER = SubPositionList.POWER;
    }

    public final static class QUARTERBACK extends NEUTRAL{
        public final static String PASSING = SubPositionList.PASSING;
        public final static String RUSHING = SubPositionList.RUSHING;
    }

    public final static class TIGHT_END extends NEUTRAL{
        public final static String BLOCKING = SubPositionList.BLOCKING;
        public final static String RECEIVING = SubPositionList.RECEIVING;
    }

    public final static class WIDE_RECEIVER extends NEUTRAL{
        public final static String SPEED = SubPositionList.SPEED;
        public final static String POSSESSION = SubPositionList.POSSESSION;
    }

    public final static class KICKER extends NEUTRAL{
        public final static String POWER = SubPositionList.POWER;
        public final static String ACCURATE = SubPositionList.ACCURATE;
    }

    public final static class PUNTER extends NEUTRAL{
        public final static String POWER = SubPositionList.POWER;
        public final static String ACCURATE = SubPositionList.ACCURATE;
    }
}
