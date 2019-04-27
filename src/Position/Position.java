package Position;

import Attributes.Attribute;
import Attributes.Attributes;
import Attributes.ModifierAttribute;
import Attributes.StatAttributes;
import Utils.RNG;

import java.util.List;

public abstract class Position {
    private static final double MODIFIER_BREAK_POINT = .5;
    private static final int SEED_LOOP_LIMIT = 2;

    private final String positionName;
    private final String subPositionName;
    private final Attributes<Integer> attributes = StatAttributes.GetBaseAttributes();
    private final Attributes<Double> attributeModifiers = new Attributes<Double>();
    private final double baseRating;

    private final static double BASE_MODIFIER = .1;

    protected Position(final String positionName, final String subPositionName, final double baseRating){
        this.positionName = positionName;
        this.subPositionName = subPositionName;
        this.baseRating = baseRating;
    }

    private final void updateAttribute(final Attribute<Integer> updateAttribute){
        Attribute<Integer> attr = getAttribute(updateAttribute.getName());
        if(attr == null) return;
        attr = new Attribute<>(attr.getName(), attr.getValue() + updateAttribute.getValue());
        attributes.overwriteAttribute(attr);
    }

    protected final void updateAttributes(final List<Attribute<Integer>> mods){
        for(final Attribute<Integer> attr : mods){
            updateAttribute(attr);
        }
    }

    private final void updateModifier(final ModifierAttribute modAttr){
        ModifierAttribute mod = getModifier(modAttr.getName());
        if(mod == null){
            attributeModifiers.addAttribute(modAttr);
            return;
        }
        mod = new ModifierAttribute(mod.getName(), mod.getValue() + modAttr.getValue());
        attributeModifiers.overwriteAttribute(mod);
    }

    protected final void updateModifiers(final List<ModifierAttribute> mods){
        for(final ModifierAttribute mod : mods){
            updateModifier(mod);
        }
    }

    public final String getPositionName(){
        return positionName;
    }

    public final String getSubPositionName(){
        return subPositionName;
    }

    public final Attribute<Integer> getAttribute(final String attribute){
        return attributes.getAttribute(attribute);
    }

    private final ModifierAttribute getModifier(final String attribute){
        return (ModifierAttribute) attributeModifiers.getAttribute(attribute);
    }

//    In order to accurately seed a player above the first level of difficulty, it is advised
//    to create the player at the first level of difficulty and then train them up to
//    the appropriate level
    protected final void seedRating(final double ovrSeed){
        seedRating(ovrSeed, getOverallRating(), 0);
    }

    private final void seedRating(final double ovrSeed, final double previousOvr, final int count){
        if(count >= SEED_LOOP_LIMIT) return;
        if(previousOvr > ovrSeed - 2) return;
        generateSeed(ovrSeed);
        if(getOverallRating() > previousOvr){
            seedRating(ovrSeed, getOverallRating(), count + 1);
        }else{
            seedRating(ovrSeed, previousOvr, count + 1);
        }
    }

    private final void generateSeed(final double ovrSeed){
        double modBuff = .05;
        double modNerf1 = 1.75;
        double modNerf2 = 1.471;
        double seedLimit = 1.2125;

        for(final Attribute<Double> mod : attributeModifiers){
            final Attribute<Integer> attr = getAttribute(mod.getName());
            double baseMax;
            double baseMin;
            if(mod.getValue() < MODIFIER_BREAK_POINT){
                baseMax = ovrSeed * (mod.getValue() * modNerf1);
                baseMin = attr.getValue() * (1+(mod.getValue() + modBuff));
            }else{
                baseMax = ovrSeed * (mod.getValue() * modNerf2);
                baseMin = attr.getValue() * (1+(mod.getValue() + modBuff));
            }
            if(baseMin < attr.getValue()) baseMin = attr.getValue();
            if(baseMax > ovrSeed * seedLimit) baseMax = ovrSeed * seedLimit;
            if(baseMax < baseMin) baseMin = baseMax - 10;
            double baseValue = RNG.Generate(baseMin, baseMax);

            double baseDiff = baseMax - baseValue;
            double baseAdjust = baseDiff * mod.getValue();

            double adjustMin = (baseDiff * - 1) + baseAdjust;
            double adjustMax = baseAdjust;
            double adjust = RNG.Generate(adjustMin, adjustMax);

            int value = ((Double) (baseValue + adjust)).intValue();
            if(value < attr.getValue()) continue;

            final Attribute<Integer> newAtt = new Attribute<>(mod.getName(), value);
            attributes.overwriteAttribute(newAtt);
        }
    }

    public final int getOverallRating(){
        Double rating = 0.0;
        for(final Attribute<Integer> attr : attributes){
            final ModifierAttribute mod = getModifier(attr.getName());
            if(mod == null) rating += attr.getValue() * (baseRating+BASE_MODIFIER);
            else rating += attr.getValue() * (baseRating + mod.getModifier());
        }
        rating = rating / attributes.size();
        return rating.intValue();
    }
}
