package study.binaryFind.faststart;

/**
 * @author payno
 * @date 2020/6/23 23:01
 * @description
 */
public abstract class AbstractBinaryFind implements BinaryFind{
    @Override
    public int binaryFind(int[] nums,int target) {
        int start=0,end=nums.length-1,mid;
        while(start<=end){
            mid = (start+end)>>>1;
            if(limitStart(mid,target,nums)){
                //  收缩起始点
                start = mid +1;
            }else if(limitEnd(mid,target,nums)){
                //  收缩终结点
                end = mid -1;
            }else if(findTarget(mid,target,nums)){
                return mid;
            }else{
                return -1;
            }
        }
        return -1;
    }
    abstract boolean limitStart(int mid,int target,int []nums);
    abstract boolean limitEnd(int mid,int target,int []nums);
    abstract boolean findTarget(int mid,int target,int []nums);
}
