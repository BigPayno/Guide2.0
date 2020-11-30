package java.binaryFind.findrange;

/**
 * @author payno
 * @date 2020/6/24 09:54
 * @description
 */
public class LeftRangeBinaryRangeFind extends AbstractBinaryRangeFind{

    @Override
    boolean tryLowContract(FindContext context) {
        if(context.target > context.midVal){
            context.low = context.mid +1;
            return true;
        }
        return false;
    }

    @Override
    boolean tryHighContract(FindContext context) {
        if(context.target < context.midVal){
            context.high = context.mid -1;
            return true;
        }
        if(context.target == context.midVal){
            context.high = context.mid;
            if(context.low == context.high){
                //  如果low==high，那么context.high = context.mid相当于没有收缩空间
                return false;
            }else{
                return true;
            }
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
