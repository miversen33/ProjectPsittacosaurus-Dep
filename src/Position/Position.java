package Position;

import Attributes.Attribute;
import Attributes.Attributes;
import Utils.Stats;

import java.util.List;

public abstract class Position {
//Consider if this needs to be public or not

    private final String name;
    private final String subPosition;
    private final double meanOverall;
    private final Attributes<Double> attributes = new Attributes<Double>();
    private final Attributes<Double> deviations = new Attributes<Double>();
    private final Attributes<Double> tailCaps = new Attributes<Double>();
    private final Attributes<Double> attrsImportance = new Attributes<Double>();
    private int overall;

    public Position(final String name, final String subPosition, final List<BaseAttributes> baseAttrs, final double meanOverall){
        this.name = name;
        this.subPosition = subPosition;
        this.meanOverall = meanOverall;
        attrsImportance.addAttributes(PositionImportanceValues.GetPositionImportanceValues(name, subPosition));
        handleBaseAttrs(baseAttrs);
    }

    public final int DEBUG_ATTR_COUNT(){
        return attributes.size();
    }

    private final void handleBaseAttrs(final List<BaseAttributes> baseAttrs){
        for(final BaseAttributes baseAttr : baseAttrs){
            attributes.addAttribute(new Attribute<>(baseAttr.getName(), baseAttr.getMean()));
            deviations.addAttribute(new Attribute<>(baseAttr.getName(), baseAttr.getDeviation()));
            tailCaps.addAttribute(new Attribute<>(baseAttr.getName(), baseAttr.getCap()));
        }
        calculateOverall();
    }

    public final Attribute<Double> getAttribute(final String attribute){
        return attributes.getAttribute(attribute);
    }

    private final Attribute<Double> getDeviation(final String deviation){
        return deviations.getAttribute(deviation);
    }

    private final Attribute<Double> getCap(final String cap){
        return tailCaps.getAttribute(cap);
    }

    private final void updateAttribute(final Attribute<Double> updateAttribute, final boolean overwrite){
        Attribute<Double> attr = getAttribute(updateAttribute.getName());
        if(attr == null) return;
        if(overwrite) {
            attr = new Attribute<>(attr.getName(), updateAttribute.getValue());
        } else {
            attr = new Attribute<>(attr.getName(), attr.getValue() + updateAttribute.getValue());
        }
        attributes.overwriteAttribute(attr);
        calculateOverall();
    }

    private final void updateDeviation(final Attribute<Double> updateDeviation, final boolean overwrite){
        Attribute<Double> dev = getDeviation(updateDeviation.getName());
        if(dev == null) return;
        if(overwrite){
            dev = new Attribute<>(dev.getName(), updateDeviation.getValue());

        } else {
            dev = new Attribute<>(dev.getName(), dev.getValue() + updateDeviation.getValue());
        }
        deviations.overwriteAttribute(dev);
        calculateOverall();
    }

    private final void addRatingsBuff(final Attribute<Double> buff){
        if(attrsImportance.containsAttribute(buff)){
//            HANDLE LOGGING TODO
            System.out.println("Unable to add buff as there is already a buff for this attribute");
            return;
        }
        attrsImportance.addAttribute(buff);
    }

    @Deprecated
    protected final void setRatingsBuffs(final List<Attribute<Double>> buffs){
        for(final Attribute<Double> buff : buffs){
            addRatingsBuff(buff);
        }
    }

    protected final void updateAttributes(final List<Attribute<Double>> attrs){
        for(final Attribute<Double> attr : attrs){
            updateAttribute(attr, false);
        }
    }

    protected final void updateDeviations(final List<Attribute<Double>> devs){
        for(final Attribute<Double> dev : devs){
            updateDeviation(dev, false);
        }
    }

    protected final void overwriteAttributes(final List<Attribute<Double>> attrs){
        for(final Attribute<Double> attr : attrs){
            updateAttribute(attr, true);
        }
    }

    protected final void overwriteDeviations(final List<Attribute<Double>> devs){
        for(final Attribute<Double> dev : devs){
            updateDeviation(dev, true);
        }
    }

    protected final void seedRating(final int seed){
        for(final Attribute<Double> attr : attributes){
            double cap = getCap(attr.getName()).getValue()*100;
            double rating = (attr.getValue() / meanOverall) * seed;
            double stat = rating + cap + .01;
            double deviation = getDeviation(attr.getName()).getValue()*100;
            while(stat > rating + cap || stat < rating - cap){
                stat = Stats.Normal(rating, deviation);
            }
            final Attribute<Double> newAttr = new Attribute<>(attr.getName(), stat);
            attributes.overwriteAttribute(newAttr);
        }
        calculateOverall();
    }

    private final void calculateOverall(){
        double rating = 0;
        for(final Attribute<Double> attr : attributes){
            if(attrsImportance.containsAttribute(attr)){
                rating += (attr.getValue() * attrsImportance.getAttribute(attr.getName()).getValue());
            } else {
                rating += attr.getValue();
            }
        }
        overall = ((Double) (rating / attributes.size())).intValue();
    }

    public final int getOverallRating(){
        return overall;
    }

    @Override
    public String toString() {
        return name+":"+subPosition+" | overall is "+getOverallRating();
    }
}
