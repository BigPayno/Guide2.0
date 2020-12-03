package study.symbolTable;

import java.util.Optional;

/**
 * 二叉搜索树:加权，调整
 *
 * @author zhaolei22
 * @date 2020/12/01
 */
public class BinarySearchTree<K extends Comparable<K>,V> implements SortedSearchST<K,V>{

    Node<K,V> cur = new Node<>();

    static class Node<K extends Comparable<K>,V>{
        K k;
        V v;
        Node<K,V> left;
        Node<K,V> right;
    }

    @Override
    public void put(K key, V val) {
        if(key==null){
            return;
        }
        Node<K,V> cur = this.cur;
        int compareResult;
        while(cur!=null&&cur.k!=null){
            compareResult = key.compareTo(cur.k);
            if(compareResult == 0){
                cur.v = val;
                return;
            }else if (compareResult > 0){
                if(cur.right==null){
                    cur.right = new Node<>();
                }
                cur = cur.right;
            }else{
                if(cur.left==null){
                    cur.left = new Node<>();
                }
                cur = cur.left;
            }
        }
        cur.k = key;
        cur.v = val;
    }

    @Override
    public Optional<V> get(K key) {
        if(key==null){
            return Optional.empty();
        }
        Node<K,V> cur = this.cur;
        V v = null;
        int compareResult;
        while(cur!=null){
            compareResult = key.compareTo(cur.k);
            if(compareResult == 0){
                return Optional.of(cur.v);
            }else if (compareResult > 0){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(K key) {
        //  替代结点，左边最大or右边最小
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

    @Override
    public V selectMin() {
        return null;
    }

    @Override
    public V selectMax() {
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer,Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.put(1,2);
        binarySearchTree.put(2,3);
        binarySearchTree.put(5,7);
        binarySearchTree.put(3,3);
        binarySearchTree.put(6,4);
        binarySearchTree.put(null,4);
        binarySearchTree.put(6,null);
        binarySearchTree.get(5).ifPresent(System.out::println);
        binarySearchTree.get(null).ifPresent(System.out::println);
        binarySearchTree.get(0).ifPresent(System.out::println);
    }
}
