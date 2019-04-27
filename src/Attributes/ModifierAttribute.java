package Attributes;

public final class ModifierAttribute extends Attribute<Double>{

    public ModifierAttribute(final String name, final Double value) {
        super(name, value);
    }

    public final Double getModifier(){
        return getValue();
    }
}
