package study.binaryFind.findrange;

/**
 * @author payno
 * @date 2020/6/24 10:16
 * @description
 */
public class FindContext {
    public int low;
    public int high;
    public int target;
    public int [] nums;
    public int mid;
    public int midVal;
    public static FindContext of(int [] nums,int target,int low,int high){
        FindContext context =new FindContext();
        context.nums = nums;
        context.low = low;
        context.high = high;
        context.target = target;
        return context;
    }
}
