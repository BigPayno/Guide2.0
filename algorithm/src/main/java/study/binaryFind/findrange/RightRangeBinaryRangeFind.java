package study.binaryFind.findrange;

/**
 * @author payno
 * @date 2020/6/24 11:26
 * @description
 */
public class RightRangeBinaryRangeFind extends AbstractBinaryRangeFind{
    @Override
    boolean tryLowContract(FindContext context) {
        if(context.midVal < context.target){
            context.low = context.mid+1;
            return true;
        }
        if(context.midVal == context.target){
            if(context.low < context.mid){
                context.low = context.mid;
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    boolean tryHighContract(FindContext context) {
        if(context.midVal > context.target){
            context.high = context.mid-1;
            return true;
        }
        if(context.midVal == context.target){
            context.high = context.mid;
            return context.low != context.high;
        }
        return false;
    }

    @Override
    int getResult(FindContext context) {
        if(context.low == context.high){
            return context.low;
        }
        return -1;
    }
}
