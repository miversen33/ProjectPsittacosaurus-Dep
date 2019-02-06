package Utils.Observable;

import java.util.*;

public class Observable<Type> {

    public final static String NULL_KEY = "NULL";

    private final Map<Object, List<Observer<Type>>> mObservers = new HashMap<>();

    public Observable(){
        mObservers.clear();
        mObservers.put(NULL_KEY, new ArrayList<>());
    }

    public final void registerObserver(final Observer<Type> observer){
        registerObserver(null, observer);
    }

    public final void registerObserver(Object key, final Observer<Type> observer){
        if(observer == null) throw new NullPointerException("Cannot pass null observer to observable");
        if(key == null) key = NULL_KEY;
        if(mObservers.keySet().contains(key) && mObservers.get(key).contains(observer)) return;

        List<Observer<Type>> entries = mObservers.get(key);
        if(entries == null) entries = new ArrayList<>();
        entries.add(observer);
        mObservers.put(key, entries);
    }

    public final void unregisterObserver(final Observer<Type> observer){
        mObservers.remove(observer);
    }

    public final void updateObservers(final Object key, final Type itemChanged){
        if(mObservers.size() == 0) return;
        final Set<Observer<Type>> observers = new HashSet<>(mObservers.get(NULL_KEY));
        if(mObservers.keySet().contains(key)) observers.addAll(mObservers.get(key));
        for(final Observer<Type> observer : observers){
            observer.updateObserver(key, itemChanged);
        }
    }

}
