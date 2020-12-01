package java.symbolTable;

public interface ST<K,V> {
    void put(K key,V val);
    V get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    Iterable<K> keys();
}
