package java.findUnion;
/**
 * @author payno
 * @date 2020/2/8 14:04
 * @description
 */
public interface UnionFind {
    /**
     * of
     * @author: payno
     * @time: 2020/2/8 14:07
     * @description:
     * @param capacity
     * @return: UnionFind
     */
    UnionFind of(int capacity);

    /**
     * union
     * @author: payno
     * @time: 2020/2/8 14:07
     * @description:
     * @param p
     * @param q
     * @return: void
     */
    void union(int p,int q);

    /**
     * connected
     * @author: payno
     * @time: 2020/2/8 14:08
     * @description:
     * @param p
     * @param q
     * @return: boolean
     */
    boolean connected(int p,int q);
}
