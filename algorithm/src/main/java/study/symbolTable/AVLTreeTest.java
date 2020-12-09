package study.symbolTable;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class AVLTreeTest {

    @Test
    public void addRR(){
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        avlTree.put(1,1);
        avlTree.put(0,0);
        avlTree.put(2,2);
        avlTree.put(3,3);
        avlTree.put(4,4);
        avlTree.print();
    }

    @Test
    public void addLL(){
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        avlTree.put(1,1);
        avlTree.put(0,0);
        avlTree.put(2,2);
        avlTree.put(-1,-1);
        avlTree.put(-2,-2);
        avlTree.print();
    }

    @Test
    public void addLR(){
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        avlTree.put(1,1);
        avlTree.put(-1,-1);
        avlTree.put(0,0);
        avlTree.print();
    }

    @Test
    public void addRL(){
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        avlTree.put(-1,-1);
        avlTree.put(1,1);
        avlTree.put(0,0);
        avlTree.print();
    }

    @Test
    public void addRandom(){
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        Random random = new Random();
        IntStream.range(0,20).forEach(num->avlTree.put(random.nextInt(50),0));
        avlTree.print();
        System.out.println("balance="+avlTree.root.balance());
    }

    @Test
    public void remove(){
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        avlTree.put(1,1);
        avlTree.put(0,0);
        avlTree.put(2,2);
        avlTree.put(-1,-1);
        avlTree.put(-2,-2);
        avlTree.put(-3,-3);
        avlTree.print();
        System.out.println();
        avlTree.delete(-1);
        avlTree.print();
    }
}
