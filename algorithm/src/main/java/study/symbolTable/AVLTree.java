package study.symbolTable;

import com.google.common.collect.Lists;
import study.symbolTable.AVLBalanceStrategy.Rotate;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AVLTree<K extends Comparable<K>,V> implements SortedSearchST<K,V>{

    Set<Rotate> avlBalanceStrategies = EnumSet.allOf(Rotate.class);
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
                return;
            }
            if(left==null){
                depth = right.depth+1;
                return;
            }
            if(right==null){
                depth = left.depth+1;
                return;
            }
            depth = left.depth>right.depth?left.depth+1:right.depth+1;
        }

        public boolean balance(){
            if(left==null&&right==null){
                return true;
            }
            if(left==null){
                return right.depth <= 0;
            }
            if(right==null){
                return left.depth <= 0;
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

        public void removeChild(Node<K,V> child){
            if(this.k.compareTo(child.k)>0){
                this.left = null;
            }else{
                this.right = null;
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
            queryChain.add(insertNode);
            Integer unbalanceNodeIndex = null;
            Node<K,V> curNode = null;
            root.updateDepth();
            for (int i = queryChain.size()-1; i >= 0; i--) {
                curNode = queryChain.get(i);
                if(unbalanceNodeIndex==null&&!curNode.balance()){
                    unbalanceNodeIndex = i;
                    break;
                }
            }
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

    public void print(){
        List<Node<K,V>> curNodes = Lists.newArrayList(root);
        while(curNodes.size()!=0){
            curNodes.forEach(curNode-> System.out.printf("%s[left:%s,right:%s]",curNode.k.toString(),curNode.left==null?" ":curNode.left.k.toString(),curNode.right==null?" ":curNode.right.k.toString()));
            curNodes = curNodes.stream()
                    .flatMap(curNode-> Stream.of(curNode.left,curNode.right).filter(Objects::nonNull))
                    .collect(Collectors.toList());
            System.out.println();
        }
        System.out.println("size="+size);
    }
}
