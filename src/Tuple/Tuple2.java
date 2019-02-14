package Tuple;

public class Tuple2<First, Second> {

    private final First first;
    private final Second second;

    public Tuple2(final First first, final Second second){
        if(first == null) throw new NullPointerException("Provided First in Tuple2 cannot be null");
        if(second == null) throw new NullPointerException("Provided Second in Tuple2 cannot be null");
        this.first = first;
        this.second = second;
    }

    public final First getFirst(){
        return first;
    }

    public final Second getSecond(){
        return second;
    }

    @Override
    public String toString() {
        return "("+first.toString()+","+second.toString()+")";
    }
}
