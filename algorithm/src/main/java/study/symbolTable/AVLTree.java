package study.symbolTable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AVLTree<K extends Comparable<K>,V> implements SortedSearchST<K,V>{

    List<AVLBalanceStrategy> avlBalanceStrategies;
    Node<K,V> root;
    int size = 0;

    static class Node<K extends Comparable<K>,V>{
        Node<K,V> left;
        Node<K,V> right;
        K k;
        V v;
        int depth = 0;

        public void updateDepth(){
            if(left!=null){
                left.updateDepth();
            }
            if(right!=null){
                right.updateDepth();
            }
            if(left==null&&right==null){
                depth = 0;
            }
            if(left==null){
                depth = right.depth+1;
            }
            if(right==null){
                depth = left.depth+1;
            }
            depth = left.depth>right.depth?left.depth+1:right.depth+1;
        }

        public boolean balance(){
            if(left==null&&right==null){
                return true;
            }
            if(left==null){
                return right.depth == 1;
            }
            if(right==null){
                return left.depth == 1;
            }
            return right.depth-left.depth<=1 && right.depth-left.depth>=-1;
        }

        public static <K extends Comparable<K>,V> Node<K,V> root(K k,V v){
            Node<K,V> node = new Node<>();
            node.k = k;
            node.v = v;
            node.depth = 1;
            return node;
        }

        public static <K extends Comparable<K>,V> Node<K,V> child(Node<K,V> parent,K k,V v){
            Node<K,V> node = new Node<>();
            node.k = k;
            node.v = v;
            if(parent.k.compareTo(k)>0){
                parent.left = node;
            }else{
                parent.right = node;
            }
            return node;
        }

        public void addChild(Node<K,V> child){
            if(this.k.compareTo(child.k)>0){
                this.left = child;
            }else{
                this.right = child;
            }
        }
    }

    private Optional<Node<K,V>> get(K key,@Nullable List<Node<K,V>> queryChain){
        Node<K,V> cur = root;
        while(cur !=null){
            int compareVal = cur.k.compareTo(key);
            if(compareVal==0){
                if(queryChain!=null){
                    queryChain.add(cur);
                }
                return Optional.of(cur);
            }else if(compareVal<0){
                if(queryChain!=null){
                    queryChain.add(cur);
                }
                cur = cur.right;
            }else{
                if(queryChain!=null){
                    queryChain.add(cur);
                }
                cur = cur.left;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<V> get(K key) {
        if(root==null){
            return Optional.empty();
        }
        return get(key, null).map(node->node.v);
    }

    @Override
    public void put(K key, V val) {
        if(root==null){
            root = Node.root(key, val);
            size ++;
        }
        List<Node<K,V>> queryChain = new ArrayList<>();
        Optional<Node<K, V>> targetNode = get(key, queryChain);
        if(targetNode.isPresent()){
            targetNode.get().v = val;
        }else{
            Node<K,V> parentNodeToInsert = queryChain.get(queryChain.size()-1);
            Node<K,V> insertNode = Node.child(parentNodeToInsert, key, val);
            Integer unbalanceNodeIndex = null;
            Node<K,V> curNode = null;
            root.updateDepth();
            for (int i = queryChain.size()-1; i >= 0; i--) {
                curNode = queryChain.get(i);
                if(unbalanceNodeIndex==null&&!curNode.balance()){
                    unbalanceNodeIndex = i;
                }
            }
            queryChain.add(insertNode);
            balance(queryChain, unbalanceNodeIndex);
            size ++;
        }
    }

    private void balance(List<Node<K,V>> queryChain, Integer unbalanceNodeIndex){
        if(unbalanceNodeIndex==null){
            return;
        }
        for(AVLBalanceStrategy strategy: avlBalanceStrategies){
            if(strategy.support(queryChain, unbalanceNodeIndex)){
                strategy.handle(this, queryChain, unbalanceNodeIndex);
                return;
            }
        }
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
