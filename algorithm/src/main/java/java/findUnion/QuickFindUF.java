package java.findUnion;
/**
 * @author payno
 * @date 2020/2/8 14:16
 * @description
 */
public class QuickFindUF implements UnionFind{
    int[] id;

    @Override
    public UnionFind of(int capacity) {
        QuickFindUF q=new QuickFindUF();
        q.id=new int[capacity];
        while(capacity>=0){
            q.id[capacity]=capacity;
            capacity--;
        }
        return q;
    }

    @Override
    public void union(int p, int q) {
        int pSet=id[p];
        int qSet=id[q];
        int start=pSet>qSet?qSet:pSet;
        int changeSet=pSet+qSet-start;
        for(int i=start;i<id.length;i++){
            if(id[i]==changeSet){
                id[i]=start;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }
}
