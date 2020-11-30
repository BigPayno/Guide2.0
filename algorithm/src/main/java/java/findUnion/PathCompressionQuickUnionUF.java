package java.findUnion;
/**
 * @author payno
 * @date 2020/2/8 15:52
 * @description
 *      在数据结构修改时，调整数据结构
 */
public class PathCompressionQuickUnionUF extends QuickUnionUF{
    @Override
    int root(int p) {
        while(p!=tree[p]){
            tree[p]=tree[tree[p]];
            p=tree[p];
        }
        return p;
    }
}
