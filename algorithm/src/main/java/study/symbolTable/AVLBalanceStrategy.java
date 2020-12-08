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
                    node1.right = node0;
                }else{
                    queryChain.get(unbalanceNodeIndex-1)
                            .addChild(node1);
                    node1.right = node0;
                    node0.left = node2;
                }
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
                    node1.left = node0;
                }else{
                    queryChain.get(unbalanceNodeIndex-1)
                            .addChild(node1);
                    node1.left = node0;
                    node0.left = node2;
                }
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
                //TODO
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
                //TODO
            }
        };
    }
}
