package Attributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatAttributes{

    SPEED             ("Speed",             50),
    STRENGTH          ("Strength",          50),
    AGILITY           ("Agility",           50),
    ACCELERATION      ("Acceleration",      50),
    AWARENESS         ("Awareness",         50),
    BREAK_TACKLE      ("Break Tackle",      40),
    ELUSIVENESS       ("Elusiveness",       40),
    CARRYING          ("Carrying",          40),
    CATCHING          ("Catching",          40),
    ROUTE_RUNNING     ("Route Running",     40),
    THROW_POWER       ("Throw Power",       40),
    THROW_ACCURACY    ("Throw Accuracy",    40),
    TACKLE            ("Tackle",            50),
    BREAK_BLOCK       ("Break Block",       40),
    MAN_COVERAGE      ("Man Coverage",      40),
    ZONE_COVERAGE     ("Zone Coverage",     40),
    PASS_BLOCKING     ("Pass Blocking",     40),
    RUN_BLOCKING      ("Run Blocking",      40),
    KICK_POWER        ("Kick Power",        40),
    KICK_ACCURACY     ("Kick Accuracy",     40),
    STAMINA           ("Stamina",           80),
    INJURY_PREVENTION ("Injury Prevention", 80);

    private final static List<Attribute<Integer>> DEFAULTS = Arrays.asList(
        SPEED.attr,
        STRENGTH.attr,
        AGILITY.attr,
        ACCELERATION.attr,
        AWARENESS.attr,
        BREAK_TACKLE.attr,
        ELUSIVENESS.attr,
        CARRYING.attr,
        CATCHING.attr,
        ROUTE_RUNNING.attr,
        THROW_POWER.attr,
        THROW_ACCURACY.attr,
        TACKLE.attr,
        BREAK_BLOCK.attr,
        MAN_COVERAGE.attr,
        ZONE_COVERAGE.attr,
        PASS_BLOCKING.attr,
        RUN_BLOCKING.attr,
        KICK_POWER.attr,
        KICK_ACCURACY.attr,
        STAMINA.attr,
        INJURY_PREVENTION.attr
    );

    private final Attribute<Integer> attr;

    StatAttributes(final String name, final Integer base){
        attr = new Attribute<>(name, base);
    }

    public final String getName(){
        return attr.getName();
    }

    public final Integer getValue(){
        return attr.getValue();
    }

    public final static List<Attribute<Integer>> GetBaseAttributes(){
        return new ArrayList<>(DEFAULTS);
    }
}
