package Observable;

import java.util.*;

public class Observable {

    private final Map<Object,List<Observer>> mObservers = new HashMap<>();
    private final String NULL_KEY = UUID.randomUUID().toString();

    public Observable(){
        mObservers.clear();
        mObservers.put(NULL_KEY, new ArrayList<>());
    }

    public final void registerObserver(final Observer observer){
        registerObserver(null, observer);
    }

    public final void registerObserver(Object key, final Observer observer){
        if(observer == null) throw new NullPointerException("Cannot pass null observer to observable");
        if(key == null) key = NULL_KEY;
        if(mObservers.keySet().contains(key) && mObservers.get(key).contains(observer)) return;

        List<Observer> entries = mObservers.get(key);
        if(entries == null) entries = new ArrayList<>();
        entries.add(observer);
        mObservers.put(key, entries);
    }

    public final void unregisterObserver(final Observer observer){
        mObservers.remove(observer);
    }

    public final void updateObservers(final Object key, final Object itemChanged){
        if(mObservers.size() == 0) return;
        final Set<Observer> observers = new HashSet<>(mObservers.get(NULL_KEY));
        if(mObservers.keySet().contains(key)) observers.addAll(mObservers.get(key));
        for(final Observer observer : observers){
            observer.updateObserver(key, itemChanged);
        }
    }

    public final void updateObservers(){
        updateObservers(null, null);
    }

}
