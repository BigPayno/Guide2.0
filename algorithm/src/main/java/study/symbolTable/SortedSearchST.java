package study.symbolTable;

public interface SortedSearchST<K extends Comparable<K>,V> extends ST<K,V>{
    V selectMin();
    V selectMax();
}
