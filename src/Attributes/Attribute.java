package Attributes;

public class Attribute<ValueType> {
    private final String name;
    private ValueType value;

    public Attribute(final String name, final ValueType value) {
        this.name = name;
        this.value = value;
    }

    public final String getName() {
        return name;
    }

    protected final void updateValue(final ValueType newValue){
        value = newValue;
    }

    public final ValueType getValue() {
        return value;
    }

    public final boolean sameAttribute(final Attribute<ValueType> attr){
        return name.equalsIgnoreCase(attr.getName());
    }

    @Override
    public String toString() {
        return "Attribute "+name+" | Value "+value;
    }
}
