
public interface MyList<T> extends MyIterable<T>{
    void add(T value);
    T get(int index);
    boolean insert(T value, int index);
    boolean isEmpty();
    boolean remove(int index);
    boolean remove(T value);
    boolean set(T value, int index);
    int size();
}
