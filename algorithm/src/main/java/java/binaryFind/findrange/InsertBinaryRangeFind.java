package java.binaryFind.findrange;

/**
 * Leetcode 35
 *
 * @author zhaolei22
 * @date 2020/08/24
 */
public class InsertBinaryRangeFind extends AbstractBinaryRangeFind {

    @Override
    boolean tryLowContract(FindContext context) {
        if(context.midVal>context.target){
            boolean contract = context.low == context.mid;
            context.high = context.mid;
            return contract;
        }
        return false;
    }

    @Override
    boolean tryHighContract(FindContext context) {
        if(context.midVal<context.target){
            context.low = context.mid+1;
            return true;
        }
        return false;
    }

    @Override
    int getResult(FindContext context) {
        if(context.midVal == context.target){
            return context.mid;
        }else{
            if(context.target<=context.nums[context.low]){
                return context.low;
            }else{
                return context.low;
            }
        }
    }
}
