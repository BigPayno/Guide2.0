package java.symbolTable;

/**
 * 二叉搜索树:加权，调整
 *
 * @author zhaolei22
 * @date 2020/12/01
 */
public class BinarySearchTree<K extends Comparable<K>,V> implements ST<K,V>{
    @Override
    public void put(K key, V val) {
        //  加到底部
    }

    @Override
    public V get(K key) {
        //  减枝
        return null;
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
}
