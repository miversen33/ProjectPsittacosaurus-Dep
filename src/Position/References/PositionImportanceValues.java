package Position;

import Attributes.Attributes;
import Attributes.Attribute;
import Attributes.StatAttributes;
import Position.Lists.PositionList;
import Position.Lists.SubPositionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PositionImportanceValues {

    CB_COVERAGE(PositionList.CORNERBACK.getName(), SubPositionList.CORNERBACK.COVERAGE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.01)
            )
    )),
    CB_HARDHITTER(PositionList.CORNERBACK.getName(), SubPositionList.CORNERBACK.HARDHITTER, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 1.90),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.02),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.20)
            )
    )),
    CB_NEUTRAL(PositionList.CORNERBACK.getName(), SubPositionList.CORNERBACK.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 1.85),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.65),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.10)
            )
    )),
    DE_RUNRUSH(PositionList.DEFENSIVE_END.getName(), SubPositionList.DEFENSIVE_END.RUN_RUSH, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 3.0)
            )
    )),
    DE_PASSRUSH(PositionList.DEFENSIVE_END.getName(), SubPositionList.DEFENSIVE_END.PASS_RUSH, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 3.0)
            )
    )),
    DE_NEUTRAL(PositionList.DEFENSIVE_END.getName(), SubPositionList.DEFENSIVE_END.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.30),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 3.15),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 3.50)
            )
    )),
    DT_RUNRUSH(PositionList.DEFENSIVE_TACKLE.getName(), SubPositionList.DEFENSIVE_TACKLE.RUN_RUSH, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 3.45),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 3.75)

            )
    )),
    DT_PASSRUSH(PositionList.DEFENSIVE_TACKLE.getName(), SubPositionList.DEFENSIVE_TACKLE.PASS_RUSH, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.30),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.85),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 3.55)

            )
    )),
    DT_NEUTRAL(PositionList.DEFENSIVE_TACKLE.getName(), SubPositionList.DEFENSIVE_TACKLE.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.30),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 3.15),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 3.75)
            )
    )),
    FS_HARDHITTER(PositionList.FREE_SAFETY.getName(), SubPositionList.FREE_SAFETY.HARDHITTER, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.10),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.10),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.10),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.35),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.15)
            )
    )),
    FS_COVERAGE(PositionList.FREE_SAFETY.getName(), SubPositionList.FREE_SAFETY.COVERAGE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.30),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.65),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.15)
            )
    )),
    FS_NEUTRAL(PositionList.FREE_SAFETY.getName(), SubPositionList.FREE_SAFETY.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 1.90),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.60)
            )
    )),
    MLB_BLITZING(PositionList.MIDDLE_LINEBACKER.getName(), SubPositionList.MIDDLE_LINEBACKER.BLITZING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.01)
            )
    )),
    MLB_COVERAGE(PositionList.MIDDLE_LINEBACKER.getName(), SubPositionList.MIDDLE_LINEBACKER.COVERAGE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.95),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.50)
            )
    )),
    MLB_NEUTRAL(PositionList.MIDDLE_LINEBACKER.getName(), SubPositionList.MIDDLE_LINEBACKER.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.25)
            )
    )),
    OLB_BLITZING(PositionList.OUTSIDE_LINEBACKER.getName(), SubPositionList.OUTSIDE_LINEBACKER.BLITZING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.85),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.01)
            )
    )),
    OLB_COVERAGE(PositionList.OUTSIDE_LINEBACKER.getName(), SubPositionList.OUTSIDE_LINEBACKER.COVERAGE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.95),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.75)
            )
    )),
    OLB_NEUTRAL(PositionList.OUTSIDE_LINEBACKER.getName(), SubPositionList.OUTSIDE_LINEBACKER.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.90),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.85),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.25)
            )
    )),
    SS_COVERAGE(PositionList.STRONG_SAFETY.getName(), SubPositionList.STRONG_SAFETY.COVERAGE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.01)
            )
    )),
    SS_HARDHITTER(PositionList.STRONG_SAFETY.getName(), SubPositionList.STRONG_SAFETY.HARDHITTER, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.20),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.40)
            )
    )),
    SS_NEUTRAL(PositionList.STRONG_SAFETY.getName(), SubPositionList.STRONG_SAFETY.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.35),
                    new Attribute<Double>(StatAttributes.MAN_COVERAGE.getName(), 2.05),
                    new Attribute<Double>(StatAttributes.ZONE_COVERAGE.getName(), 2.05),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.65),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.20)
            )
    )),
    C_RUNBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.RUN_BLOCK, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.25)
            )
    )),
    C_PASSBLOCK(PositionList.CENTER.getName(), SubPositionList.CENTER.PASS_BLOCK, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 3.25)
            )
    )),
    C_NEUTRAL(PositionList.CENTER.getName(), SubPositionList.CENTER.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.65)
            )
    )),
    G_RUNBLOCK(PositionList.GUARD.getName(), SubPositionList.GUARD.RUN_BLOCK, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.25)
            )
    )),
    G_PASSBLOCK(PositionList.GUARD.getName(), SubPositionList.GUARD.PASS_BLOCK, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 3.25)
            )
    )),
    G_NEUTRAL(PositionList.GUARD.getName(), SubPositionList.GUARD.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.65)
            )
    )),
    OT_RUNBLOCK(PositionList.OFFENSIVE_TACKLE.getName(), SubPositionList.OFFENSIVE_TACKLE.RUN_BLOCK, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.25)
            )
    )),
    OT_PASSBLOCK(PositionList.OFFENSIVE_TACKLE.getName(), SubPositionList.OFFENSIVE_TACKLE.PASS_BLOCK, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 3.25)
            )
    )),
    OT_NEUTRAL(PositionList.OFFENSIVE_TACKLE.getName(), SubPositionList.OFFENSIVE_TACKLE.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.65),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.65)
            )
    )),
    FB_BLOCKING(PositionList.FULLBACK.getName(), SubPositionList.FULLBACK.BLOCKING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.40)
            )
    )),
    FB_RUSHING(PositionList.FULLBACK.getName(), SubPositionList.FULLBACK.RUSHING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.20),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.20),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.75)
            )
    )),
    FB_NEUTRAL(PositionList.FULLBACK.getName(), SubPositionList.FULLBACK.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.05),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.60)
            )
    )),
    HB_POWER(PositionList.HALFBACK.getName(), SubPositionList.HALFBACK.POWER, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.50)
            )
    )),
    HB_SPEED(PositionList.HALFBACK.getName(), SubPositionList.HALFBACK.SPEED, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.20),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.05),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.05),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.35)
            )
    )),
    HB_NEUTRAL(PositionList.HALFBACK.getName(), SubPositionList.HALFBACK.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.AGILITY.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.50)
            )
    )),
    QB_PASSING(PositionList.QUARTERBACK.getName(), SubPositionList.QUARTERBACK.PASSING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.01),
                    new Attribute<Double>(StatAttributes.THROW_POWER.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.THROW_ACCURACY.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50)
            )
    )),
    QB_RUSHING(PositionList.QUARTERBACK.getName(), SubPositionList.QUARTERBACK.RUSHING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.95),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.THROW_POWER.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.THROW_ACCURACY.getName(), 2.75),
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.55)
            )
    )),
    QB_NEUTRAL(PositionList.QUARTERBACK.getName(), SubPositionList.QUARTERBACK.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.30),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.05),
                    new Attribute<Double>(StatAttributes.THROW_POWER.getName(), 2.5),
                    new Attribute<Double>(StatAttributes.THROW_ACCURACY.getName(), 3.25),
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.75)
            )
    )),
    TE_BLOCKING(PositionList.TIGHT_END.getName(), SubPositionList.TIGHT_END.BLOCKING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.10),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 2.0),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 2.0),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.20),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.35)
            )
    )),
    TE_RECEIVING(PositionList.TIGHT_END.getName(), SubPositionList.TIGHT_END.RECEIVING, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.20),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.55),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.55)
            )
    )),
    TE_NEUTRAL(PositionList.TIGHT_END.getName(), SubPositionList.TIGHT_END.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.20),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.RUN_BLOCKING.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.PASS_BLOCKING.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.40),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.35)
            )
    )),
    WR_POSSESSION(PositionList.WIDE_RECEIVER.getName(), SubPositionList.WIDE_RECEIVER.POSSESSION, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 2.10),
                    new Attribute<Double>(StatAttributes.ROUTE_RUNNING.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.50),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.35),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.01)
            )
    )),
    WR_SPEED(PositionList.WIDE_RECEIVER.getName(), SubPositionList.WIDE_RECEIVER.SPEED, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 1.95),
                    new Attribute<Double>(StatAttributes.ROUTE_RUNNING.getName(), 1.85),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.80),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.45),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.15),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.10)
            )
    )),
    WR_NEUTRAL(PositionList.WIDE_RECEIVER.getName(), SubPositionList.WIDE_RECEIVER.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 2.15),
                    new Attribute<Double>(StatAttributes.CATCHING.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.ROUTE_RUNNING.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.60),
                    new Attribute<Double>(StatAttributes.STRENGTH.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.CARRYING.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.ELUSIVENESS.getName(), 1.25),
                    new Attribute<Double>(StatAttributes.BREAK_TACKLE.getName(), 1.15)
            )
    )),
    K_POWER(PositionList.KICKER.getName(), SubPositionList.KICKER.POWER, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_POWER.getName(), 3.50),
                    new Attribute<Double>(StatAttributes.KICK_ACCURACY.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75)
            )
    )),
    K_ACCURATE(PositionList.KICKER.getName(), SubPositionList.KICKER.ACCURATE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_POWER.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.KICK_ACCURACY.getName(), 3.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75)
            )
    )),
    K_NEUTRAL(PositionList.KICKER.getName(), SubPositionList.KICKER.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_POWER.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_ACCURACY.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 2.00),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75)
            )
    )),
    P_POWER(PositionList.PUNTER.getName(), SubPositionList.PUNTER.POWER, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_POWER.getName(), 3.50),
                    new Attribute<Double>(StatAttributes.KICK_ACCURACY.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.90),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75)
            )
    )),
    P_ACCURATE(PositionList.PUNTER.getName(), SubPositionList.PUNTER.ACCURATE, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_POWER.getName(), 2.50),
                    new Attribute<Double>(StatAttributes.KICK_ACCURACY.getName(), 3.50),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.90),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.75),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.75)
            )
    )),
    P_NEUTRAL(PositionList.PUNTER.getName(), SubPositionList.PUNTER.NEUTRAL, new Attributes<Double>(
            Arrays.asList(
                    new Attribute<Double>(StatAttributes.AWARENESS.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_POWER.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.KICK_ACCURACY.getName(), 3.00),
                    new Attribute<Double>(StatAttributes.SPEED.getName(), 2.25),
                    new Attribute<Double>(StatAttributes.TACKLE.getName(), 1.90),
                    new Attribute<Double>(StatAttributes.BREAK_BLOCK.getName(), 1.70),
                    new Attribute<Double>(StatAttributes.ACCELERATION.getName(), 1.70)
            )
    ))
    ;

    private final static List<PositionImportanceValues> values = Arrays.asList(
        CB_COVERAGE,
        CB_HARDHITTER,
        CB_NEUTRAL,
        DE_RUNRUSH,
        DE_PASSRUSH,
        DE_NEUTRAL,
        DT_RUNRUSH,
        DT_PASSRUSH,
        DT_NEUTRAL,
        FS_COVERAGE,
        FS_HARDHITTER,
        FS_NEUTRAL,
        MLB_BLITZING,
        MLB_COVERAGE,
        MLB_NEUTRAL,
        OLB_BLITZING,
        OLB_COVERAGE,
        OLB_NEUTRAL,
        SS_COVERAGE,
        SS_HARDHITTER,
        SS_NEUTRAL,
        C_PASSBLOCK,
        C_RUNBLOCK,
        C_NEUTRAL,
        G_PASSBLOCK,
        G_RUNBLOCK,
        G_NEUTRAL,
        OT_PASSBLOCK,
        OT_RUNBLOCK,
        OT_NEUTRAL,
        FB_BLOCKING,
        FB_RUSHING,
        FB_NEUTRAL,
        HB_SPEED,
        HB_POWER,
        HB_NEUTRAL,
        QB_PASSING,
        QB_RUSHING,
        QB_NEUTRAL,
        TE_BLOCKING,
        TE_RECEIVING,
        TE_NEUTRAL,
        WR_SPEED,
        WR_POSSESSION,
        WR_NEUTRAL,
        K_ACCURATE,
        K_POWER,
        K_NEUTRAL,
        P_ACCURATE,
        P_POWER,
        P_NEUTRAL
    );

    private final String position;
    private final String subPosition;
    private final Attributes<Double> importance;

    PositionImportanceValues(final String positionName, final String subPositionName, Attributes<Double> attrs){
        this.position = positionName;
        this.subPosition = subPositionName;
        for(final String attr : StatAttributes.GetAttributeNames()){
            if(!attrs.containsAttribute(attr))  attrs.addAttribute(new Attribute<>(attr, 1.00));
        }
        this.importance = attrs;
    }

    public final String getPositionName(){
        return position;
    }

    public final String getSubPositionName(){
        return subPosition;
    }

    private final List<Attribute<Double>> getImportance(){
        return importance.asList();
    }

    public final static List<Attribute<Double>> GetPositionImportanceValues(final String position, final String subPosition){
        for(final PositionImportanceValues p : values){
            if(p.getPositionName().equalsIgnoreCase(position) && p.getSubPositionName().equalsIgnoreCase(subPosition)) return p.getImportance();
        }
        System.out.println("Unable to find "+position+", "+subPosition+" importance values. Please check your pair again");
        return new ArrayList<>();
    }

}
