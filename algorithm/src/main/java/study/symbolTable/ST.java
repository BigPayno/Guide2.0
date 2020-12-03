package study.symbolTable;

import java.util.Optional;

public interface ST<K,V> {
    void put(K key,V val);
    Optional<V> get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    Iterable<K> keys();
}
