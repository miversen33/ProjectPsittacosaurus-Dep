package Position.References;

import Attributes.Attribute;
import Attributes.Attributes;
import Attributes.StatAttributes;
import Position.References.Lists.PositionList;
import Position.References.Lists.SubPositionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SubPositionAttributes {

    CB_COVERAGE(PositionList.CORNERBACK.getName(), SubPositionList.CORNERBACK.COVERAGE,Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(), BaseAttributes.CB_AWARENESS.getMean()+.025, BaseAttributes.CB_AWARENESS.getDeviation()-.0175),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.CB_STRENGTH.getMean()-.07, BaseAttributes.CB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(), BaseAttributes.CB_SPEED.getMean()+.05, BaseAttributes.CB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.CB_BREAK_BLOCK.getMean()-.05, BaseAttributes.CB_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.CB_TACKLE.getMean()-.075, BaseAttributes.CB_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(), BaseAttributes.CB_CATCHING.getMean()+.425, BaseAttributes.CB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(), BaseAttributes.CB_CARRYING.getMean()+.075, BaseAttributes.CB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(), BaseAttributes.CB_MAN_COVERAGE.getMean()+.061, BaseAttributes.CB_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(), BaseAttributes.CB_ZONE_COVERAGE.getMean()+.106, BaseAttributes.CB_ZONE_COVERAGE.getDeviation())
        )
    ),
    CB_HARDHITTER(PositionList.CORNERBACK.getName(), SubPositionList.CORNERBACK.HARDHITTER, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.CB_AWARENESS.getMean()-.084, BaseAttributes.CB_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.CB_STRENGTH.getMean()+.13, BaseAttributes.CB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.CB_SPEED.getMean()-.0213, BaseAttributes.CB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.CB_BREAK_BLOCK.getMean()+.048, BaseAttributes.CB_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.CB_TACKLE.getMean()+.125, BaseAttributes.CB_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.CB_CATCHING.getMean()-.005, BaseAttributes.CB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.CB_CARRYING.getMean()-.002, BaseAttributes.CB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.CB_ACCELERATION.getMean()+.024, BaseAttributes.CB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.INJURY.getName(),BaseAttributes.CB_INJURY.getMean()-.044, BaseAttributes.CB_INJURY.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.CB_MAN_COVERAGE.getMean()-.009, BaseAttributes.CB_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.CB_ZONE_COVERAGE.getMean()-.004, BaseAttributes.CB_ZONE_COVERAGE.getDeviation())
        )
    ),
    DE_RUNRUSH(PositionList.DEFENSIVE_END.getName(), SubPositionList.DEFENSIVE_END.RUN_RUSH, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.DE_AWARENESS.getMean()+.05, BaseAttributes.DE_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.DE_STRENGTH.getMean()+.05, BaseAttributes.DE_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.DE_SPEED.getMean()-.025, BaseAttributes.DE_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.DE_BREAK_BLOCK.getMean()+.05, BaseAttributes.DE_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.DE_TACKLE.getMean()+.05, BaseAttributes.DE_TACKLE.getDeviation())
    )),
    DE_PASSRUSH(PositionList.DEFENSIVE_END.getName(), SubPositionList.DEFENSIVE_END.PASS_RUSH, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.DE_AWARENESS.getMean()-.05, BaseAttributes.DE_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.DE_STRENGTH.getMean()-.025, BaseAttributes.DE_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.DE_SPEED.getMean()+.05, BaseAttributes.DE_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.DE_BREAK_BLOCK.getMean()+.05, BaseAttributes.DE_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.DE_TACKLE.getMean()+.05, BaseAttributes.DE_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.DE_ACCELERATION.getMean()+.075, BaseAttributes.DE_ACCELERATION.getDeviation())
    )),
//    TODO Needs Nerfs by about 1-2 points
    DT_RUNRUSH(PositionList.DEFENSIVE_TACKLE.getName(), SubPositionList.DEFENSIVE_TACKLE.RUN_RUSH, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.DT_AWARENESS.getMean()+.05, BaseAttributes.DT_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.DT_STRENGTH.getMean()+.05, BaseAttributes.DT_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.DT_SPEED.getMean()-.05, BaseAttributes.DT_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.DT_ACCELERATION.getMean()-.05, BaseAttributes.DT_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.DT_TACKLE.getMean()+.05, BaseAttributes.DT_TACKLE.getDeviation())
    )),
    DT_PASSRUSH(PositionList.DEFENSIVE_TACKLE.getName(), SubPositionList.DEFENSIVE_TACKLE.PASS_RUSH, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.DT_AWARENESS.getMean()-.05, BaseAttributes.DT_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.DT_STRENGTH.getMean()-.05, BaseAttributes.DT_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.DT_SPEED.getMean()+.05, BaseAttributes.DT_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.DT_BREAK_BLOCK.getMean()+.10, BaseAttributes.DT_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.DT_ACCELERATION.getMean()+.10, BaseAttributes.DT_ACCELERATION.getDeviation())
    )),
    FS_COVERAGE(PositionList.FREE_SAFETY.getName(), SubPositionList.FREE_SAFETY.COVERAGE, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.FS_AWARENESS.getMean()+.05, BaseAttributes.FS_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.FS_STRENGTH.getMean()-.10, BaseAttributes.FS_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.FS_BREAK_BLOCK.getMean()-.10, BaseAttributes.FS_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.FS_CATCHING.getMean()+.10, BaseAttributes.FS_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.FS_CARRYING.getMean()+.025, BaseAttributes.FS_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.FS_ACCELERATION.getMean()+.025, BaseAttributes.FS_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.FS_BREAK_TACKLE.getMean()+.025, BaseAttributes.FS_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.FS_MAN_COVERAGE.getMean()+.079, BaseAttributes.FS_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.FS_ZONE_COVERAGE.getMean()+.0507, BaseAttributes.FS_ZONE_COVERAGE.getDeviation())
    )),
    FS_HARDHITTER(PositionList.FREE_SAFETY.getName(), SubPositionList.FREE_SAFETY.HARDHITTER, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.FS_AWARENESS.getMean()-.05, BaseAttributes.FS_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.FS_STRENGTH.getMean()+.125, BaseAttributes.FS_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.FS_SPEED.getMean()+.025, BaseAttributes.FS_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.FS_BREAK_BLOCK.getMean()+.05, BaseAttributes.FS_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.FS_TACKLE.getMean()+.076, BaseAttributes.FS_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.FS_CATCHING.getMean()-.05, BaseAttributes.FS_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.FS_CARRYING.getMean()-.05, BaseAttributes.FS_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.FS_MAN_COVERAGE.getMean()+.01, BaseAttributes.FS_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.FS_ZONE_COVERAGE.getMean()+.01, BaseAttributes.FS_ZONE_COVERAGE.getDeviation())
    )),
    MLB_BLITZING(PositionList.MIDDLE_LINEBACKER.getName(), SubPositionList.MIDDLE_LINEBACKER.BLITZING, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.MLB_AWARENESS.getMean()+.025, BaseAttributes.MLB_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.MLB_STRENGTH.getMean()+.05, BaseAttributes.MLB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.MLB_SPEED.getMean()+.025, BaseAttributes.MLB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.MLB_BREAK_BLOCK.getMean()+.1, BaseAttributes.MLB_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.MLB_TACKLE.getMean()+.05, BaseAttributes.MLB_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.MLB_CATCHING.getMean()-.1, BaseAttributes.MLB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.MLB_CARRYING.getMean()-.1, BaseAttributes.MLB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.MLB_MAN_COVERAGE.getMean()-.1, BaseAttributes.MLB_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.MLB_ZONE_COVERAGE.getMean()-.1, BaseAttributes.MLB_ZONE_COVERAGE.getDeviation())
    )),
    MLB_COVERAGE(PositionList.MIDDLE_LINEBACKER.getName(), SubPositionList.MIDDLE_LINEBACKER.COVERAGE, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.MLB_AWARENESS.getMean()+.025, BaseAttributes.MLB_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.MLB_STRENGTH.getMean()-.05, BaseAttributes.MLB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.MLB_BREAK_BLOCK.getMean()-.05, BaseAttributes.MLB_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.MLB_TACKLE.getMean()+.025, BaseAttributes.MLB_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.MLB_CATCHING.getMean()+.05, BaseAttributes.MLB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.MLB_MAN_COVERAGE.getMean()+.05, BaseAttributes.MLB_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.MLB_ZONE_COVERAGE.getMean()+.05, BaseAttributes.MLB_ZONE_COVERAGE.getDeviation())
    )),
    OLB_BLITZING(PositionList.OUTSIDE_LINEBACKER.getName(), SubPositionList.OUTSIDE_LINEBACKER.BLITZING, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.OLB_STRENGTH.getMean()+.05, BaseAttributes.OLB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.OLB_SPEED.getMean()+.075, BaseAttributes.OLB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.OLB_BREAK_BLOCK.getMean()+.05, BaseAttributes.OLB_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.OLB_TACKLE.getMean()+.05, BaseAttributes.OLB_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.OLB_CATCHING.getMean()-.1, BaseAttributes.OLB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.OLB_CARRYING.getMean()-.1, BaseAttributes.OLB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.OLB_ACCELERATION.getMean()+.05, BaseAttributes.OLB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.OLB_MAN_COVERAGE.getMean()-.1, BaseAttributes.OLB_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.OLB_ZONE_COVERAGE.getMean()-.75, BaseAttributes.OLB_ZONE_COVERAGE.getDeviation())
    )),
    OLB_COVERAGE(PositionList.OUTSIDE_LINEBACKER.getName(), SubPositionList.OUTSIDE_LINEBACKER.COVERAGE, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.OLB_AWARENESS.getMean()+.025, BaseAttributes.OLB_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.OLB_STRENGTH.getMean()-.075, BaseAttributes.OLB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.OLB_BREAK_BLOCK.getMean()-.075, BaseAttributes.OLB_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.OLB_TACKLE.getMean()+.025, BaseAttributes.OLB_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.OLB_CATCHING.getMean()+.075, BaseAttributes.OLB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.OLB_MAN_COVERAGE.getMean()+.075, BaseAttributes.OLB_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.OLB_ZONE_COVERAGE.getMean()+.075, BaseAttributes.OLB_ZONE_COVERAGE.getDeviation())
    )),
    SS_COVERAGE(PositionList.STRONG_SAFETY.getName(), SubPositionList.STRONG_SAFETY.COVERAGE, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.SS_AWARENESS.getMean()+.1, BaseAttributes.SS_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.SS_STRENGTH.getMean()-.1, BaseAttributes.SS_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.SS_BREAK_BLOCK.getMean()-.15, BaseAttributes.SS_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.SS_CATCHING.getMean()+.05, BaseAttributes.SS_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.MAN_COVERAGE.getName(),BaseAttributes.SS_MAN_COVERAGE.getMean()+.1, BaseAttributes.SS_MAN_COVERAGE.getDeviation()),
            new BaseAttribute(StatAttributes.ZONE_COVERAGE.getName(),BaseAttributes.SS_ZONE_COVERAGE.getMean()+.1, BaseAttributes.SS_ZONE_COVERAGE.getDeviation())
    )),
    SS_HARDHITTER(PositionList.STRONG_SAFETY.getName(), SubPositionList.STRONG_SAFETY.HARDHITTER, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.SS_STRENGTH.getMean()+.15, BaseAttributes.SS_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.SS_SPEED.getMean()-.05, BaseAttributes.SS_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_BLOCK.getName(),BaseAttributes.SS_BREAK_BLOCK.getMean()+.05, BaseAttributes.SS_BREAK_BLOCK.getDeviation()),
            new BaseAttribute(StatAttributes.TACKLE.getName(),BaseAttributes.SS_TACKLE.getMean()+.15, BaseAttributes.SS_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.SS_CATCHING.getMean()-.05, BaseAttributes.SS_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.SS_CARRYING.getMean()-.05, BaseAttributes.SS_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.SS_ACCELERATION.getMean()+.05, BaseAttributes.SS_ACCELERATION.getDeviation())
    )),
    C_RUNBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.RUN_BLOCK, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.C_STRENGTH.getMean()-.05, BaseAttributes.C_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.C_SPEED.getMean()+.05, BaseAttributes.C_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.C_RUN_BLOCKING.getMean()+.15, BaseAttributes.C_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.C_PASS_BLOCKING.getMean()-.15, BaseAttributes.C_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.C_ACCELERATION.getMean()+.05, BaseAttributes.C_ACCELERATION.getDeviation())
    )),
    C_PASSBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.PASS_BLOCK, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.C_STRENGTH.getMean()+.05, BaseAttributes.C_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.C_SPEED.getMean()-.05, BaseAttributes.C_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.C_RUN_BLOCKING.getMean()-.15, BaseAttributes.C_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.C_PASS_BLOCKING.getMean()+.15, BaseAttributes.C_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.C_ACCELERATION.getMean()+.05, BaseAttributes.C_ACCELERATION.getDeviation())
    )),
    G_RUNBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.RUN_BLOCK, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.G_STRENGTH.getMean()-.05, BaseAttributes.G_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.G_SPEED.getMean()+.05, BaseAttributes.G_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.G_RUN_BLOCKING.getMean()+.15, BaseAttributes.G_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.G_PASS_BLOCKING.getMean()-.15, BaseAttributes.G_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.G_ACCELERATION.getMean()+.05, BaseAttributes.G_ACCELERATION.getDeviation())
    )),
    G_PASSBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.PASS_BLOCK, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.G_STRENGTH.getMean()+.05, BaseAttributes.G_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.G_SPEED.getMean()-.05, BaseAttributes.G_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.G_RUN_BLOCKING.getMean()-.15, BaseAttributes.G_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.G_PASS_BLOCKING.getMean()+.15, BaseAttributes.G_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.G_ACCELERATION.getMean()+.05, BaseAttributes.G_ACCELERATION.getDeviation())
    )),
    OT_RUNBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.RUN_BLOCK, Arrays.asList(
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.OT_SPEED.getMean()+.05, BaseAttributes.OT_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.OT_RUN_BLOCKING.getMean()+.15, BaseAttributes.OT_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.OT_PASS_BLOCKING.getMean()-.15, BaseAttributes.OT_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.OT_ACCELERATION.getMean()+.05, BaseAttributes.OT_ACCELERATION.getDeviation())
    )),
    OT_PASSBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.PASS_BLOCK, Arrays.asList(
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.OT_SPEED.getMean()-.05, BaseAttributes.OT_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.OT_RUN_BLOCKING.getMean()-.15, BaseAttributes.OT_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.OT_PASS_BLOCKING.getMean()+.15, BaseAttributes.OT_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.OT_ACCELERATION.getMean()+.05, BaseAttributes.OT_ACCELERATION.getDeviation())
    )),
    FB_BLOCKING(PositionList.FULLBACK.getName(), SubPositionList.FULLBACK.BLOCKING, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.FB_STRENGTH.getMean()+.1, BaseAttributes.FB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.FB_SPEED.getMean()-.05, BaseAttributes.FB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.FB_RUN_BLOCKING.getMean()+.075, BaseAttributes.FB_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.FB_PASS_BLOCKING.getMean()+.075, BaseAttributes.FB_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.FB_CATCHING.getMean()-.05, BaseAttributes.FB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.FB_ACCELERATION.getMean()-.05, BaseAttributes.FB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.FB_BREAK_TACKLE.getMean()-.1, BaseAttributes.FB_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.FB_ELUSIVENESS.getMean()-.1, BaseAttributes.FB_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.FB_AGILITY.getMean()-.1, BaseAttributes.FB_AGILITY.getDeviation())
    )),
    FB_RUSHING(PositionList.FULLBACK.getName(), SubPositionList.FULLBACK.RUSHING, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.FB_STRENGTH.getMean()-.05, BaseAttributes.FB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.FB_SPEED.getMean()+.1, BaseAttributes.FB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.FB_RUN_BLOCKING.getMean()-.10, BaseAttributes.FB_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.FB_PASS_BLOCKING.getMean()-.10, BaseAttributes.FB_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.FB_CATCHING.getMean()+.05, BaseAttributes.FB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.FB_CARRYING.getMean()+.10, BaseAttributes.FB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.FB_ACCELERATION.getMean()+.05, BaseAttributes.FB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.FB_BREAK_TACKLE.getMean()+.1, BaseAttributes.FB_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.FB_ELUSIVENESS.getMean()+.05, BaseAttributes.FB_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.FB_AGILITY.getMean()+.05, BaseAttributes.FB_AGILITY.getDeviation())
    )),
    HB_SPEED(PositionList.HALFBACK.getName(), SubPositionList.HALFBACK.SPEED, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.HB_STRENGTH.getMean()-.1, BaseAttributes.HB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.HB_SPEED.getMean()+.1, BaseAttributes.HB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.HB_RUN_BLOCKING.getMean()-.05, BaseAttributes.HB_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.HB_PASS_BLOCKING.getMean()-.05, BaseAttributes.HB_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.HB_CATCHING.getMean()+.075, BaseAttributes.HB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.HB_CARRYING.getMean()-.05, BaseAttributes.HB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.HB_ACCELERATION.getMean()+.05, BaseAttributes.HB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.HB_BREAK_TACKLE.getMean()-.05, BaseAttributes.HB_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.HB_ELUSIVENESS.getMean()+.1, BaseAttributes.HB_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.HB_AGILITY.getMean()+.1, BaseAttributes.HB_AGILITY.getDeviation())
    )),
    HB_POWER(PositionList.HALFBACK.getName(), SubPositionList.HALFBACK.POWER, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.HB_STRENGTH.getMean()+.1, BaseAttributes.HB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.HB_SPEED.getMean()-.05, BaseAttributes.HB_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.HB_RUN_BLOCKING.getMean()+.05, BaseAttributes.HB_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.HB_PASS_BLOCKING.getMean()+.10, BaseAttributes.HB_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.HB_CARRYING.getMean()+.10, BaseAttributes.HB_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.HB_ACCELERATION.getMean()+.05, BaseAttributes.HB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.HB_BREAK_TACKLE.getMean()+.10, BaseAttributes.HB_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.HB_ELUSIVENESS.getMean()-.05, BaseAttributes.HB_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.HB_AGILITY.getMean()-.10, BaseAttributes.HB_AGILITY.getDeviation())
    )),
    QB_RUSHING(PositionList.QUARTERBACK.getName(), SubPositionList.QUARTERBACK.RUSHING, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.QB_AWARENESS.getMean()-.075, BaseAttributes.QB_AWARENESS.getDeviation()-.01),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.QB_STRENGTH.getMean()+.05, BaseAttributes.QB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.QB_SPEED.getMean()+.174, BaseAttributes.QB_SPEED.getDeviation()-.015),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.QB_RUN_BLOCKING.getMean()+.15, BaseAttributes.QB_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.QB_PASS_BLOCKING.getMean()-.01, BaseAttributes.QB_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.QB_CATCHING.getMean()+.05, BaseAttributes.QB_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.QB_CARRYING.getMean()+.045, BaseAttributes.QB_CARRYING.getDeviation()-.01),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.QB_ACCELERATION.getMean()+.05, BaseAttributes.QB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.QB_BREAK_TACKLE.getMean()+.025, BaseAttributes.QB_BREAK_TACKLE.getDeviation()+.01),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.QB_ELUSIVENESS.getMean()+.025, BaseAttributes.QB_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.QB_AGILITY.getMean()+.02, BaseAttributes.QB_AGILITY.getDeviation()-.01),
            new BaseAttribute(StatAttributes.THROW_POWER.getName(),BaseAttributes.QB_THROW_POWER.getMean()-.015, BaseAttributes.QB_THROW_POWER.getDeviation()+.015),
            new BaseAttribute(StatAttributes.THROW_ACCURACY.getName(),BaseAttributes.QB_THROW_ACCURACY.getMean()-.04, BaseAttributes.QB_THROW_ACCURACY.getDeviation()+.015)
    )),
    QB_PASSING(PositionList.QUARTERBACK.getName(), SubPositionList.QUARTERBACK.PASSING, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.QB_AWARENESS.getMean()+.08, BaseAttributes.QB_AWARENESS.getDeviation()-.015),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.QB_STRENGTH.getMean()+.075, BaseAttributes.QB_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.QB_SPEED.getMean()-.025, BaseAttributes.QB_SPEED.getDeviation()-.15),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.QB_CARRYING.getMean()-.067, BaseAttributes.QB_CARRYING.getDeviation()+.01),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.QB_ACCELERATION.getMean()+.05, BaseAttributes.QB_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.QB_BREAK_TACKLE.getMean()+.03, BaseAttributes.QB_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.QB_ELUSIVENESS.getMean()-.15, BaseAttributes.QB_ELUSIVENESS.getDeviation()-.01),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.QB_AGILITY.getMean()-.12, BaseAttributes.QB_AGILITY.getDeviation()),
            new BaseAttribute(StatAttributes.THROW_POWER.getName(),BaseAttributes.QB_THROW_POWER.getMean()+.11, BaseAttributes.QB_THROW_POWER.getDeviation()-.005),
            new BaseAttribute(StatAttributes.THROW_ACCURACY.getName(),BaseAttributes.QB_THROW_ACCURACY.getMean()+.089, BaseAttributes.QB_THROW_ACCURACY.getDeviation())
    )),
    TE_RECEIVING(PositionList.TIGHT_END.getName(), SubPositionList.TIGHT_END.RECEIVING, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.TE_AWARENESS.getMean()+.05, BaseAttributes.TE_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.TE_STRENGTH.getMean()-.05, BaseAttributes.TE_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.TE_SPEED.getMean()+.05, BaseAttributes.TE_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.TE_RUN_BLOCKING.getMean()-.05, BaseAttributes.TE_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.TE_PASS_BLOCKING.getMean()-.05, BaseAttributes.TE_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.TE_CATCHING.getMean()+.1, BaseAttributes.TE_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.TE_CARRYING.getMean()+.1, BaseAttributes.TE_CARRYING.getDeviation())
    )),
    TE_BLOCKING(PositionList.TIGHT_END.getName(), SubPositionList.TIGHT_END.BLOCKING, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.TE_AWARENESS.getMean()+.05, BaseAttributes.TE_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.TE_SPEED.getMean()-.05, BaseAttributes.TE_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.TE_RUN_BLOCKING.getMean()+.05, BaseAttributes.TE_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.TE_PASS_BLOCKING.getMean()+.05, BaseAttributes.TE_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.TE_CATCHING.getMean()-.05, BaseAttributes.TE_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.TE_ELUSIVENESS.getMean()-.1, BaseAttributes.TE_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.TE_AGILITY.getMean()-.1, BaseAttributes.TE_AGILITY.getDeviation())
    )),
    WR_POSSESSION(PositionList.WIDE_RECEIVER.getName(), SubPositionList.WIDE_RECEIVER.POSSESSION, Arrays.asList(
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.WR_STRENGTH.getMean()+.10, BaseAttributes.WR_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.WR_SPEED.getMean()-.025, BaseAttributes.WR_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.WR_RUN_BLOCKING.getMean()+.10, BaseAttributes.WR_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.WR_PASS_BLOCKING.getMean()+.075, BaseAttributes.WR_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.CATCHING.getName(),BaseAttributes.WR_CATCHING.getMean()+.025, BaseAttributes.WR_CATCHING.getDeviation()),
            new BaseAttribute(StatAttributes.CARRYING.getName(),BaseAttributes.WR_CARRYING.getMean()+.10, BaseAttributes.WR_CARRYING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.WR_ACCELERATION.getMean()-.05, BaseAttributes.WR_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.WR_BREAK_TACKLE.getMean()+.05, BaseAttributes.WR_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.WR_ELUSIVENESS.getMean()-.05, BaseAttributes.WR_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.WR_AGILITY.getMean()-.05, BaseAttributes.WR_AGILITY.getDeviation())
    )),
    WR_SPEED(PositionList.WIDE_RECEIVER.getName(), SubPositionList.WIDE_RECEIVER.SPEED, Arrays.asList(
            new BaseAttribute(StatAttributes.AWARENESS.getName(),BaseAttributes.WR_AWARENESS.getMean()-.05, BaseAttributes.WR_AWARENESS.getDeviation()),
            new BaseAttribute(StatAttributes.STRENGTH.getName(),BaseAttributes.WR_STRENGTH.getMean()-.10, BaseAttributes.WR_STRENGTH.getDeviation()),
            new BaseAttribute(StatAttributes.SPEED.getName(),BaseAttributes.WR_SPEED.getMean()+.05, BaseAttributes.WR_SPEED.getDeviation()),
            new BaseAttribute(StatAttributes.RUN_BLOCKING.getName(),BaseAttributes.WR_RUN_BLOCKING.getMean()-.10, BaseAttributes.WR_RUN_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.PASS_BLOCKING.getName(),BaseAttributes.WR_PASS_BLOCKING.getMean()-.05, BaseAttributes.WR_PASS_BLOCKING.getDeviation()),
            new BaseAttribute(StatAttributes.ACCELERATION.getName(),BaseAttributes.WR_ACCELERATION.getMean()+.025, BaseAttributes.WR_ACCELERATION.getDeviation()),
            new BaseAttribute(StatAttributes.BREAK_TACKLE.getName(),BaseAttributes.WR_BREAK_TACKLE.getMean()-.05, BaseAttributes.WR_BREAK_TACKLE.getDeviation()),
            new BaseAttribute(StatAttributes.ELUSIVENESS.getName(),BaseAttributes.WR_ELUSIVENESS.getMean()+.075, BaseAttributes.WR_ELUSIVENESS.getDeviation()),
            new BaseAttribute(StatAttributes.AGILITY.getName(),BaseAttributes.WR_AGILITY.getMean()+.025, BaseAttributes.WR_AGILITY.getDeviation())
    )),
    K_POWER(PositionList.KICKER.getName(), SubPositionList.KICKER.POWER, Arrays.asList(
            new BaseAttribute(StatAttributes.KICK_POWER.getName(),BaseAttributes.K_KICK_POWER.getMean()+.025, BaseAttributes.K_KICK_POWER.getDeviation()),
            new BaseAttribute(StatAttributes.KICK_ACCURACY.getName(),BaseAttributes.K_KICK_ACCURACY.getMean()-.025, BaseAttributes.K_KICK_ACCURACY.getDeviation())
    )),
    K_ACCURATE(PositionList.KICKER.getName(), SubPositionList.KICKER.ACCURATE, Arrays.asList(
            new BaseAttribute(StatAttributes.KICK_POWER.getName(),BaseAttributes.K_KICK_POWER.getMean()-.025, BaseAttributes.K_KICK_POWER.getDeviation()),
            new BaseAttribute(StatAttributes.KICK_ACCURACY.getName(),BaseAttributes.K_KICK_ACCURACY.getMean()+.025, BaseAttributes.K_KICK_ACCURACY.getDeviation())
    )),
    P_POWER(PositionList.PUNTER.getName(), SubPositionList.PUNTER.POWER, Arrays.asList(
            new BaseAttribute(StatAttributes.KICK_POWER.getName(),BaseAttributes.P_KICK_POWER.getMean()+.025, BaseAttributes.P_KICK_POWER.getDeviation()),
            new BaseAttribute(StatAttributes.KICK_ACCURACY.getName(),BaseAttributes.P_KICK_ACCURACY.getMean()-.025, BaseAttributes.P_KICK_ACCURACY.getDeviation())
    )),
    P_ACCURATE(PositionList.PUNTER.getName(), SubPositionList.PUNTER.ACCURATE, Arrays.asList(
            new BaseAttribute(StatAttributes.KICK_POWER.getName(),BaseAttributes.P_KICK_POWER.getMean()-.025, BaseAttributes.P_KICK_POWER.getDeviation()),
            new BaseAttribute(StatAttributes.KICK_ACCURACY.getName(),BaseAttributes.P_KICK_ACCURACY.getMean()+.025, BaseAttributes.P_KICK_ACCURACY.getDeviation())
    ))


    ;

    private final static List<SubPositionAttributes> values = Arrays.asList(
        CB_COVERAGE,
        CB_HARDHITTER,
        DE_PASSRUSH,
        DE_RUNRUSH,
        DT_PASSRUSH,
        DT_RUNRUSH,
        FS_COVERAGE,
        FS_HARDHITTER,
        MLB_BLITZING,
        MLB_COVERAGE,
        OLB_BLITZING,
        OLB_COVERAGE,
        SS_COVERAGE,
        SS_HARDHITTER,
        C_RUNBLOCK,
        C_PASSBLOCK,
        G_PASSBLOCK,
        G_RUNBLOCK,
        OT_PASSBLOCK,
        OT_RUNBLOCK,
        FB_BLOCKING,
        FB_RUSHING,
        HB_POWER,
        HB_SPEED,
        QB_PASSING,
        QB_RUSHING,
        TE_BLOCKING,
        TE_RECEIVING,
        WR_POSSESSION,
        WR_SPEED,
        K_ACCURATE,
        K_POWER,
        P_ACCURATE,
        P_POWER
    );

    private final String position;
    private final String subPosition;
    private final Attributes<Double> attrs = new Attributes<Double>();
    private final Attributes<Double> devs = new Attributes<Double>();

    SubPositionAttributes(final String position, final String subPosition, final List<BaseAttribute> a){
        this.position = position;
        this.subPosition = subPosition;
        for(final BaseAttribute b : a){
            attrs.addAttribute(new Attribute<>(b.getName(), b.getMean()));
            devs.addAttribute(new Attribute<>(b.getName(), b.getDeviation()));
        }
    }

    public final String getPositionName(){
        return position;
    }

    public final String getSubPositionName(){
        return subPosition;
    }

    private final List<Attribute<Double>> getAttributes(){
        return attrs.asList();
    }

    private final List<Attribute<Double>> getDeviations(){
        return devs.asList();
    }

    public final static List<Attribute<Double>> GetPositionAttributes(final String position, final String subPosition){
        for(final SubPositionAttributes s : values){
            if(s.getPositionName().equalsIgnoreCase(position) && s.getSubPositionName().equalsIgnoreCase(subPosition)) return s.getAttributes();
        }
        System.out.println("Unable to find "+position+", "+subPosition+" attributes. Please check your pair again");
        return new ArrayList<>();
    }

    public final static List<Attribute<Double>> GetPostitionDeviations(final String position, final String subPosition){
        for(final SubPositionAttributes s : values){
            if(s.getPositionName().equalsIgnoreCase(position) && s.getSubPositionName().equalsIgnoreCase(subPosition)) return s.getDeviations();
        }
        System.out.println("Unable to find "+position+", "+subPosition+" deviations. Please check your pair again");
        return new ArrayList<>();
    }
}
