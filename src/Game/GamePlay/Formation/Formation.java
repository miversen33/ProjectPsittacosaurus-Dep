package Game.GamePlay.Formation;


import JavaXMLUtility.MalformedXMLException;
import JavaXMLUtility.XMLHeader;

import java.util.ArrayList;
import java.util.List;

public class Formation {

    private final String name;
    private final List<FormationSlot> slots;
    private final int id;

    private final static String XML_TITLE = "formation";
    private final static String ID_ATTRIBUTE = "id";
    private final static String NAME_ATTRIBUTE = "name";
    private final static String SLOT_CHILD = "slot";

    public Formation(final XMLHeader input) throws MalformedXMLException {
        verifyXMLInput(input);
        name = input.getAttribute(NAME_ATTRIBUTE).getAttribute();
        id = Integer.parseInt(input.getAttribute(ID_ATTRIBUTE).getAttribute());
        slots = parseSlots(input);
    }

    private final void verifyXMLInput(final XMLHeader input) throws MalformedXMLException {
        if(!input.getName().equalsIgnoreCase(XML_TITLE)) throw new MalformedXMLException("Invalid XML Input "+input.getName()+ "for formation");
//        TODO Create an "intelligent" way to handle situations where we are missing the index
        if(!input.containsAttribute(ID_ATTRIBUTE)) throw new MalformedXMLException("Formation is missing the assigned id.");
        if(!input.containsAttribute(NAME_ATTRIBUTE)) throw new MalformedXMLException("Formation is missing name.");
        if(!input.containsChild(SLOT_CHILD)) throw new MalformedXMLException("Formation is missing slot(s).");
    }

    private final List<FormationSlot> parseSlots(final XMLHeader input) throws MalformedXMLException {
        if(!input.containsChild(SLOT_CHILD)) throw new MalformedXMLException("FormationSlot is missing location");
        final List<FormationSlot> slots = new ArrayList<>();

        for(final XMLHeader header: input.getChildren()){
            if(header.getName().equals(SLOT_CHILD)) slots.add(new FormationSlot(header));
        }

        return slots;
    }

    public final String getName(){
        return name;
    }

    public final FormationSlot getSlot(final int slot){
        return slots.get(slot);
    }

    public final int getId(){
        return id;
    }

}
