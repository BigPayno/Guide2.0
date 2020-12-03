package study.binaryFind.findrange;

/**
 * @author payno
 * @date 2020/6/24 11:11
 * @description
 */
public class BaseBinaryRangeFind extends AbstractBinaryRangeFind{
    @Override
    boolean tryLowContract(FindContext context) {
        if(context.midVal>context.target){
            context.high = context.mid-1;
            return true;
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
        return context.mid;
    }

}
