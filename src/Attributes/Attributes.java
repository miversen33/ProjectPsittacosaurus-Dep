package Attributes;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Attributes<ValueType> implements Iterable<Attribute<ValueType>> {
    //    Consider requiring a signature so others cannot manipulate this
    private final List<Attribute<ValueType>> attributes = new ArrayList<>();

    public Attributes() {

    }

    public Attributes(final Attributes<ValueType> attrs){
        this(attrs.asList());
    }

    public Attributes(final List<Attribute<ValueType>> attrs) {
        addAttributes(attrs);
    }

    public Attributes(final Attribute<ValueType>... attrs) {
        addAttributes(attrs);
    }

    public final List<Attribute<ValueType>> asList(){
        final List<Attribute<ValueType>> attrs = new ArrayList<>(attributes.size());
        for(final Attribute<ValueType> attr : attributes){
            attrs.add(attr.cloneAttribute());
        }
        return attrs;
    }

    public final void addAttribute(final Attribute<ValueType> attr) {
        if (attributes.contains(attr)) {
//            TODO Log invalid overwrite attempt
            System.out.println("Unable to replace existing attribute " + attr.getName() + ". Please see overwriteAttribute(attribute) instead.");
            return;
        }
        attributes.add(attr);
    }

    public final void addAttributes(final List<Attribute<ValueType>> attrs) {
        for (final Attribute<ValueType> attr : attrs) {
            addAttribute(attr);
        }
    }

    public final void addAttributes(final Attribute<ValueType>... attrs) {
        for (final Attribute<ValueType> attr : attrs) {
            addAttribute(attr);
        }
    }

    public final boolean containsAttribute(final Attribute<ValueType> attr) {
        for (final Attribute<ValueType> attribute : attributes) {
            if (attribute.getName().equalsIgnoreCase(attr.getName())) return true;
        }
        return false;
    }

    public final boolean containsAttribute(final String attrTitle){
        for (final Attribute attr : attributes){
            if(attr.getName().equalsIgnoreCase(attrTitle)) return true;
        } return false;
    }

    public final Attribute<ValueType> getAttribute(final String attributeName) {
        for (final Attribute<ValueType> attr : attributes) {
            if (attr.getName().equalsIgnoreCase(attributeName)) return attr;
        }
//        TODO Handle logging of invalid attribute
//        We need to create a logger that has various levels to it so this can be used if needed, but most of the time is ignored
//        System.out.println("Unable to find attribute " + attributeName);
        return null;
    }

    public final void overwriteAttribute(final Attribute<ValueType> newAttribute) {
        final String errorLog = "Unable to update attribute " + newAttribute.getName() + " as it does not exist currently. Please see addAttribute(newAttribute) instead.";

        if (!containsAttribute(newAttribute)) {
//            TODO Log invalid update attempt
            System.out.println(errorLog);
            return;
        }
        final Attribute<ValueType> attribute = getAttribute(newAttribute.getName());
        if (attribute == null) {
//            TODO log invalid update attempt
            System.out.println(errorLog);
            return;
        }
        attribute.updateValue(newAttribute.getValue());
    }

    public final int size(){
        return attributes.size();
    }

    @Override
    public Iterator<Attribute<ValueType>> iterator() {
        return attributes.iterator();
    }
}
