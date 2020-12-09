package study.symbolTable;

import study.symbolTable.AVLTree.Node;

import java.util.List;

public interface AVLBalanceStrategy{
    <K extends Comparable<K>,V> boolean support(List<Node<K,V>> queryChain, Integer unbalanceNodeIndex);
    <K extends Comparable<K>,V> void handle(AVLTree<K,V> tree,List<Node<K,V>> queryChain, Integer unbalanceNodeIndex);

    enum Rotate implements AVLBalanceStrategy{
        LL{
            @Override
            public <K extends Comparable<K>, V> boolean support(List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                return node0.left==node1&&node1.left==node2;
            }

            @Override
            public <K extends Comparable<K>, V> void handle(AVLTree<K, V> tree, List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                if(unbalanceNodeIndex==0){
                    tree.root = node1;
                }else{
                    queryChain.get(unbalanceNodeIndex-1)
                            .addChild(node1);
                }
                node0.removeChild(node1);
                node0.left = node1.right;
                node1.left = node2;
                node1.right = node0;
                node1.updateDepth();
            }
        },
        RR{
            @Override
            public <K extends Comparable<K>, V> boolean support(List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                return node0.right==node1&&node1.right==node2;
            }

            @Override
            public <K extends Comparable<K>, V> void handle(AVLTree<K, V> tree, List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                if(unbalanceNodeIndex==0){
                    tree.root = node1;
                }else{
                    queryChain.get(unbalanceNodeIndex-1)
                            .addChild(node1);
                }
                node0.removeChild(node1);
                node0.right = node1.left;
                node1.left = node0;
                node1.right = node2;
                node1.updateDepth();
            }
        },
        LR{
            @Override
            public <K extends Comparable<K>, V> boolean support(List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                return node0.left==node1&&node1.right==node2;
            }

            @Override
            public <K extends Comparable<K>, V> void handle(AVLTree<K, V> tree, List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                if(unbalanceNodeIndex==0){
                    tree.root = node2;
                }else{
                    queryChain.get(unbalanceNodeIndex-1)
                            .addChild(node2);
                }
                node1.removeChild(node2);
                node0.removeChild(node1);
                node0.right = node2.left;
                node1.left = node2.right;
                node2.left = node1;
                node2.right = node0;
                node2.updateDepth();
            }
        },
        RL{
            @Override
            public <K extends Comparable<K>, V> boolean support(List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                return node0.right==node1&&node1.left==node2;
            }

            @Override
            public <K extends Comparable<K>, V> void handle(AVLTree<K, V> tree, List<Node<K, V>> queryChain, Integer unbalanceNodeIndex) {
                Node<K, V> node0 = queryChain.get(unbalanceNodeIndex);
                Node<K, V> node1 = queryChain.get(unbalanceNodeIndex+1);
                Node<K, V> node2 = queryChain.get(unbalanceNodeIndex+2);
                if(unbalanceNodeIndex==0){
                    tree.root = node2;
                    node1.removeChild(node2);
                }else{
                    queryChain.get(unbalanceNodeIndex-1)
                            .addChild(node2);
                }
                node1.removeChild(node2);
                node0.removeChild(node1);
                node0.right = node2.left;
                node1.left = node2.right;
                node2.left = node0;
                node2.right = node1;
                node2.updateDepth();
            }
        };
    }
}
