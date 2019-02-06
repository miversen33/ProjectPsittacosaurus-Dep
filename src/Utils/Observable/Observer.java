package Utils.Observable;

public interface Observer<Type> {

    void updateObserver(final Object key, final Type itemChanged);
}
