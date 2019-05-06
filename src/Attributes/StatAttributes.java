package Attributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatAttributes{

    SPEED             ("Speed",             50.0),
    STRENGTH          ("Strength",          50.0),
    AGILITY           ("Agility",           50.0),
    ACCELERATION      ("Acceleration",      50.0),
    AWARENESS         ("Awareness",         50.0),
    BREAK_TACKLE      ("Break Tackle",      40.0),
    ELUSIVENESS       ("Elusiveness",       40.0),
    CARRYING          ("Carrying",          40.0),
    CATCHING          ("Catching",          40.0),
    ROUTE_RUNNING     ("Route Running",     40.0),
    THROW_POWER       ("Throw Power",       40.0),
    THROW_ACCURACY    ("Throw Accuracy",    40.0),
    TACKLE            ("Tackle",            50.0),
    BREAK_BLOCK       ("Break Block",       40.0),
    MAN_COVERAGE      ("Man Coverage",      40.0),
    ZONE_COVERAGE     ("Zone Coverage",     40.0),
    PASS_BLOCKING     ("Pass Blocking",     40.0),
    RUN_BLOCKING      ("Run Blocking",      40.0),
    KICK_POWER        ("Kick Power",        40.0),
    KICK_ACCURACY     ("Kick Accuracy",     40.0),
    STAMINA           ("Stamina",           80.0),
    INJURY            ("Injury Prevention", 80.0);

    private final static List<Attribute<Double>> DEFAULTS_ATTRS = Arrays.asList(
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
        INJURY.attr
    );

    private final Attribute<Double> attr;

    StatAttributes(final String name, final Double base){
        attr = new Attribute<>(name, base);
    }

    public final String getName(){
        return attr.getName();
    }

    @Deprecated
    public final Double getValue(){
        return attr.getValue();
    }

    public final static Attributes<Double> GetBaseAttributes(){
        final ArrayList<Attribute<Double>> attrs = new ArrayList<>(DEFAULTS_ATTRS.size());
        for(Attribute<Double> attr : DEFAULTS_ATTRS){
            attrs.add(attr.cloneAttribute());
        }
        return new Attributes<Double>(new ArrayList<>(DEFAULTS_ATTRS));
    }

}
