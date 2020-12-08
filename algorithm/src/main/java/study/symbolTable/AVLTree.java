package study.symbolTable;

import java.util.Optional;

public class AVLTree<K extends Comparable<K>,V> implements SortedSearchST<K,V>{

    Node<K,V> root;
    int size = 0;

    static class Node<K,V>{
        Node<K,V> left;
        Node<K,V> right;
        K k;
        V v;
        int top;

        public static <K extends Comparable<K>,V> Node<K,V> root(K k,V v){
            Node<K,V> node = new Node<>();
            node.k = k;
            node.v = v;
            node.top = 1;
            return node;
        }

        public static <K extends Comparable<K>,V> Node<K,V> left(Node<K,V> parent,K k,V v){
            Node<K,V> node = new Node<>();
            node.k = k;
            node.v = v;
            parent.left = node;
            return node;
        }

        public static <K extends Comparable<K>,V> Node<K,V> right(Node<K,V> parent,K k,V v){
            Node<K,V> node = new Node<>();
            node.k = k;
            node.v = v;
            parent.right = node;
            return node;
        }
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.empty();
    }

    @Override
    public void put(K key, V val) {
        if(root==null){
            root = Node.root(key, val);
        }
        size ++;
    }

    @Override
    public V selectMin() {
        return null;
    }

    @Override
    public V selectMax() {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
