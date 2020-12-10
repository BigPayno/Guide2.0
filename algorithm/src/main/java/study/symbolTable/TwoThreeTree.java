package study.symbolTable;

import java.util.List;
import java.util.Optional;

public class TwoThreeTree<K extends Comparable<K>,V> {

    enum NodeType{
        one,two,tree
    }

   interface Node<K extends Comparable<K>,V>{
        NodeType type();
        Node<K,V> ref();
        K k();
        V v();
        Node<K,V> parentNode();
        void addChild(Node<K,V> node);
        void removeChild(Node<K,V> node);
        Optional<Node<K,V>> queryNode(K k);
    }

    static abstract class Base<K extends Comparable<K>,V> implements Node<K,V>{
        Node<K,V> parent;
        K k;
        V v;

        @Override
        public Node<K, V> parentNode() {
            return parent;
        }

        @Override
        public K k() {
            return k;
        }

        @Override
        public V v() {
            return v;
        }
    }

    static class OneNode<K extends Comparable<K>,V> extends Base<K,V>{

        Node<K,V> ref;
        Node<K,V> left;
        Node<K,V> right;

        @Override
        public NodeType type() {
            return NodeType.one;
        }

        @Override
        public Node<K, V> ref() {
            return this;
        }

        @Override
        public K k() {
            return null;
        }

        @Override
        public void addChild(Node<K, V> node) {
            parentNode().removeChild(this);
            parentNode().addChild(TwoNode.of(this,node));
        }

        @Override
        public void removeChild(Node<K, V> node) {

        }

        @Override
        public Optional<Node<K, V>> queryNode(K k) {
            return Optional.empty();
        }
    }

    static class TwoNode<K extends Comparable<K>,V> extends Base<K,V>{

        Node<K,V> leftRef;
        Node<K,V> rightRef;
        Node<K,V> left;
        Node<K,V> middle;
        Node<K,V> right;

        public static <K extends Comparable<K>,V> TwoNode<K,V> of(OneNode<K,V> oneNode,Node<K,V> node){
            TwoNode<K,V> twoNode = new TwoNode<>();
            if(node.k().compareTo(oneNode.k())>0){
                twoNode.leftRef = oneNode;
                twoNode.rightRef = node;
                twoNode.left = oneNode.left;
                twoNode.middle = oneNode.right;
            }else{
                twoNode.leftRef = node;
                twoNode.rightRef = oneNode;
                twoNode.right = oneNode.right;
                twoNode.middle = oneNode.left;
            }
            return twoNode;
        }

        @Override
        public Node<K, V> ref() {
            return left;
        }

        @Override
        public K k() {
            return null;
        }

        @Override
        public NodeType type() {
            return NodeType.two;
        }

        @Override
        public void addChild(Node<K, V> node) {

        }

        @Override
        public void removeChild(Node<K, V> node) {

        }

        @Override
        public Optional<Node<K, V>> queryNode(K k) {
            return Optional.empty();
        }
    }
}
