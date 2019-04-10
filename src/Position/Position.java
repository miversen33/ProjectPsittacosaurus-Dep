package Position;

import Attributes.Attribute;
import Attributes.StatAttributes;

import java.util.List;

public abstract class Position {

    private final String positionName;
    private final String subPositionName;
//    Consider a holder class for attributes?
    private final List<Attribute<Integer>> baseAttributes;

    protected Position(final String positionName, final String subPositionName){
        this.positionName = positionName;
        this.subPositionName = subPositionName;
        baseAttributes = StatAttributes.GetBaseAttributes();
    }

//    Ensure that you're only providing the change attribute, not the actual attribute.
//    EG, Attribute("Speed",4) for a plus 4 speed.
    protected final void updateAttribute(final Attribute<Integer> updateAttribute){
        Attribute<Integer> key = null;
        for(final Attribute<Integer> attr : baseAttributes){
            if(attr.getName().equalsIgnoreCase(updateAttribute.getName())){
                key = attr;
                break;
            }
        }
        if(key == null) return;
        final Attribute<Integer> updatedAttr = new Attribute<>(key.getName(), key.getValue() + updateAttribute.getValue());
        baseAttributes.set(baseAttributes.indexOf(key), updatedAttr);
    }

    protected final void updateAttributes(final List<Attribute<Integer>> mods){
        for(final Attribute<Integer> attr : mods){
            updateAttribute(attr);
        }
    }

    public final String getPositionName(){
        return positionName;
    }

    public final String getSubPositionName(){
        return subPositionName;
    }

    public final Attribute<Integer> getAttribute(final String attribute){
        for(Attribute<Integer> attr : baseAttributes){
            if(attr.getName().equalsIgnoreCase(attribute)) return attr;
        }
        return null;
    }
}
