package study.findUnion;
/**
 * @author payno
 * @date 2020/2/8 15:40
 * @description
 *      在数据结构修改时选择更好的选择
 */
public class WeightedQuickUnionUF implements UnionFind{
    int[] tree;
    int[] size;

    @Override
    public UnionFind of(int capacity) {
        WeightedQuickUnionUF q=new WeightedQuickUnionUF();
        q.tree=new int[capacity];
        q.size=new int[capacity];
        while(capacity>=0){
            q.tree[capacity]=capacity;
            q.size[capacity]=1;
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
        if(i!=j){
            if(size[i]>=size[j]){
                tree[j]=i;
                size[i]+=size[j];
            }else{
                tree[i]=j;
                size[j]+=size[i];
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }
}
