package study.symbolTable;

import java.util.Iterator;
import java.util.Optional;

/**
 * 二叉搜索树:加权，调整
 *
 * @author zhaolei22
 * @date 2020/12/01
 */
public class BinarySearchTree<K extends Comparable<K>,V> implements SortedSearchST<K,V>{

    Node<K,V> root = new Node<>();
    int size = 0;

    static class Node<K extends Comparable<K>,V>{
        K k;
        V v;
        Node<K,V> parent;
        Node<K,V> left;
        Node<K,V> right;

        Node<K,V> remove(){
            if(parent!=null){
                int compare = parent.k.compareTo(this.k);
                if(compare>0){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
            return this;
        }

        void clear(){
            this.parent = null;
            this.left = null;
            this.right = null;
            this.k = null;
            this.v = null;
        }

        boolean isSmallThanParent(){
             return parent.k.compareTo(this.k)>0;
        }

        Node<K,V> selectMin(){
            Node<K,V> cur = this;
            while(cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }

        Node<K,V> selectMax(){
            Node<K,V> cur = this;
            while(cur.right!=null){
                cur = cur.right;
            }
            return cur;
        }

        Node<K,V> selectOneBigger(){
            Node<K, V> cur = this;
            if (cur.right==null){
                if(cur.isSmallThanParent()){
                    return cur.parent;
                }
                while (!cur.isSmallThanParent()){
                    cur = cur.parent;
                }
                 return cur;
            }else{
                return cur.right.selectMin();
            }
        }

        boolean hasOneBigger(){
            if(this.right!=null){
                return true;
            }
            Node<K, V> cur = this;
            while (cur!=null&&cur.parent!=null){
                if(cur.isSmallThanParent()){
                    return true;
                }
                cur = cur.parent;
            }
            return false;
        }
    }

    @Override
    public void put(K key, V val) {
        if(key==null){
            return;
        }
        Node<K,V> cur = this.root;
        int compareResult;
        while(cur!=null&&cur.k!=null){
            compareResult = key.compareTo(cur.k);
            if(compareResult == 0){
                cur.v = val;
                return;
            }else if (compareResult > 0){
                if(cur.right==null){
                    cur.right = new Node<>();
                    cur.right.parent = cur;
                }
                cur = cur.right;
            }else{
                if(cur.left==null){
                    cur.left = new Node<>();
                    cur.left.parent = cur;
                }
                cur = cur.left;
            }
        }
        size++;
        cur.k = key;
        cur.v = val;
    }

    private Optional<Node<K,V>> getNode(K key){
        if(key==null||root.k==null){
            return Optional.empty();
        }
        Node<K,V> cur = this.root;
        V v = null;
        int compareResult;
        while(cur!=null){
            compareResult = key.compareTo(cur.k);
            if(compareResult == 0){
                break;
            }else if (compareResult > 0){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return Optional.ofNullable(cur);
    }

    @Override
    public Optional<V> get(K key) {
        return getNode(key).map(node->node.v);
    }

    @Override
    public void delete(K key) {
        Optional<Node<K, V>> targetOpt = getNode(key);
        if(!targetOpt.isPresent()){
            return;
        }else{
            Node<K, V> target = targetOpt.get();
            if(target.left==null&&target.right==null){
                target.remove().clear();
            }else if(target.right!=null){
                Node<K, V> minNodeInRightTree = target.right.selectMin();
                minNodeInRightTree.remove();
                if(target.parent==null){
                    root = minNodeInRightTree;
                    minNodeInRightTree.parent = null;
                }else{
                    target.parent.right = minNodeInRightTree;
                    minNodeInRightTree.parent = target.parent;
                }
                minNodeInRightTree.left = target.left;
            }else{
                Node<K, V> maxNodeInLeftTree = target.left.selectMax();
                maxNodeInLeftTree.remove();
                if(target.parent==null){
                    root = maxNodeInLeftTree;
                    maxNodeInLeftTree.parent = null;
                }else{
                    target.parent.left = maxNodeInLeftTree;
                    maxNodeInLeftTree.parent = target.parent;
                }
                maxNodeInLeftTree.right = target.right;
            }
            target.clear();
            size--;
        }
    }

    @Override
    public boolean contains(K key) {
        return get(key).isPresent();
    }

    @Override
    public boolean isEmpty() {
        return root.k==null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return () -> new Iterator<K>() {

            Node<K,V> cur = null;

            @Override
            public boolean hasNext() {
                if(cur==null){
                    return BinarySearchTree.this.root.k!=null;
                }
                return cur.hasOneBigger();
            }

            @Override
            public K next() {
                if(cur==null){
                    cur = BinarySearchTree.this.root.selectMin();
                    return cur.k;
                }
                cur = cur.selectOneBigger();
                return cur.k;
            }
        };
    }

    @Override
    public V selectMin() {
        return root.selectMin().v;
    }

    @Override
    public V selectMax() {
        return root.selectMax().v;
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
        binarySearchTree.put(10,1);
        binarySearchTree.get(5).ifPresent(System.out::println);
        binarySearchTree.get(null).ifPresent(System.out::println);
        binarySearchTree.get(0).ifPresent(System.out::println);
        Integer maxValue = binarySearchTree.selectMax();
        System.out.println(maxValue);
        binarySearchTree.keys().forEach(System.out::print);
        System.out.println();
        binarySearchTree.delete(1);
        binarySearchTree.keys().forEach(System.out::print);
        binarySearchTree.delete(3);
        System.out.println();
        binarySearchTree.keys().forEach(System.out::print);
        binarySearchTree.delete(6);
        System.out.println();
        binarySearchTree.keys().forEach(System.out::print);
    }
}
