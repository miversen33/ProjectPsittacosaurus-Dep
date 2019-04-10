package Attributes;

//This might not be the best way to do this
public enum PhysicalAttributes {

    WEIGHT("Weight",0),
//    Inches or Centimeters will work here. Probably best to have a locale to determine this though.
    HEIGHT("Height",65);

    private final Attribute<Integer> attr;

    PhysicalAttributes(final String name, final Integer value){
        attr = new Attribute<>(name, value);
    }

    public final String getName(){
        return attr.getName();
    }

    public final Integer getValue(){
        return attr.getValue();
    }
}
