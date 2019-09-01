package Position.References.Lists;

import Game.SideOfBall;

public enum PositionList {

    QUARTERBACK("Quarterback","QB",SideOfBall.OFFENSE),
    HALFBACK("Halfback","HB",SideOfBall.OFFENSE),
    FULLBACK("Fullback","FB",SideOfBall.OFFENSE),
    WIDE_RECEIVER("Wide Receiver","WR",SideOfBall.OFFENSE),
    TIGHT_END("Tight End","TE",SideOfBall.OFFENSE),
    OFFENSIVE_TACKLE("Offensive Tackle","OT",SideOfBall.OFFENSE),
    CENTER("Center", "C", SideOfBall.OFFENSE),
    GUARD("Offensive Guard","OG", SideOfBall.OFFENSE),
    DEFENSIVE_TACKLE("Defensive Tackle","DT",SideOfBall.DEFENSE),
    DEFENSIVE_END("Defensive End","DE",SideOfBall.DEFENSE),
    MIDDLE_LINEBACKER("Middle Linebacker","MLB",SideOfBall.DEFENSE),
    OUTSIDE_LINEBACKER("Outside Linebacker","OLB",SideOfBall.DEFENSE),
    CORNERBACK("Cornerback","CB",SideOfBall.DEFENSE),
    FREE_SAFETY("Free Safety","FS",SideOfBall.DEFENSE),
    STRONG_SAFETY("Strong Safety","SS",SideOfBall.DEFENSE),
    PUNTER("Punter","P",SideOfBall.OFFENSE),
    KICKER("Kicker","K",SideOfBall.OFFENSE);

    private final String name;
    private final String abbreviatedName;
    private final SideOfBall sideOfBall;

    PositionList(final String n, final String an, final SideOfBall s){
        name = n;
        abbreviatedName = an;
        sideOfBall = s;
    }

    public final String getName(){
        return name;
    }

    public final String getAbbreviatedName(){
        return abbreviatedName;
    }

    public final SideOfBall getSideOfBall(){
        return sideOfBall;
    }

    public final static PositionList Parse(final String parser){
//        While Ugly, this is probably the best way to handle this
        if(parser.equals(QUARTERBACK.name) || parser.equals(QUARTERBACK.abbreviatedName)) return QUARTERBACK;
        if(parser.equals(HALFBACK.name) || parser.equals(HALFBACK.abbreviatedName)) return HALFBACK;
        if(parser.equals(FULLBACK.name) || parser.equals(FULLBACK.abbreviatedName)) return FULLBACK;
        if(parser.equals(WIDE_RECEIVER.name) || parser.equals(WIDE_RECEIVER.abbreviatedName)) return WIDE_RECEIVER;
        if(parser.equals(TIGHT_END.name) || parser.equals(TIGHT_END.abbreviatedName)) return TIGHT_END;
        if(parser.equals(OFFENSIVE_TACKLE.name) || parser.equals(OFFENSIVE_TACKLE.abbreviatedName)) return OFFENSIVE_TACKLE;
        if(parser.equals(CENTER.name) || parser.equals(CENTER.abbreviatedName)) return CENTER;
        if(parser.equals(GUARD.name) || parser.equals(GUARD.abbreviatedName)) return GUARD;
        if(parser.equals(DEFENSIVE_TACKLE.name) || parser.equals(DEFENSIVE_TACKLE.abbreviatedName)) return DEFENSIVE_TACKLE;
        if(parser.equals(DEFENSIVE_END.name) || parser.equals(DEFENSIVE_END.abbreviatedName)) return DEFENSIVE_END;
        if(parser.equals(MIDDLE_LINEBACKER.name) || parser.equals(MIDDLE_LINEBACKER.abbreviatedName)) return MIDDLE_LINEBACKER;
        if(parser.equals(OUTSIDE_LINEBACKER.name) || parser.equals(OUTSIDE_LINEBACKER.abbreviatedName)) return OUTSIDE_LINEBACKER;
        if(parser.equals(CORNERBACK.name) || parser.equals(CORNERBACK.abbreviatedName)) return CORNERBACK;
        if(parser.equals(FREE_SAFETY.name) || parser.equals(FREE_SAFETY.abbreviatedName)) return FREE_SAFETY;
        if(parser.equals(STRONG_SAFETY.name) || parser.equals(STRONG_SAFETY.abbreviatedName)) return STRONG_SAFETY;
        if(parser.equals(PUNTER.name) || parser.equals(PUNTER.abbreviatedName)) return PUNTER;
        if(parser.equals(KICKER.name) || parser.equals(KICKER.abbreviatedName)) return KICKER;
//       TODO Implement Logging System
        System.out.println("Unable to parse "+parser);
        return null;
    }
}
