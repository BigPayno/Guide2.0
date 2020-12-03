package study.findUnion;
/**
 * @author payno
 * @date 2020/2/8 14:38
 * @description
 */
public class QuickUnionUF implements UnionFind{
    int[] tree;

    @Override
    public UnionFind of(int capacity) {
        QuickUnionUF q=new QuickUnionUF();
        q.tree=new int[capacity];
        while(capacity>=0){
            q.tree[capacity]=capacity;
            capacity--;
        }
        return q;
    }

    int root(int p){
        while(p!=tree[p]){
            p=tree[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i=root(p);
        int j=root(q);
        tree[i]=j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }
}
