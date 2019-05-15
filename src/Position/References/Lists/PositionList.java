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
}
