package study.binaryFind.findrange;

/**
 * 找到第一个比目标大的元素
 *
 * @author zhaolei22
 * @date 2020/07/22
 */
public class FirstNumberBiggerThanFind extends AbstractBinaryRangeFind{

    @Override
    boolean tryLowContract(FindContext context) {
        if(context.midVal<=context.target){
            context.low = context.mid+1;
            return true;
        }
        return false;
    }

    @Override
    boolean tryHighContract(FindContext context) {
        if(context.midVal>context.target){
            boolean zip = context.high == context.mid;
            if(!zip){
                context.high = context.mid;
                return true;
            }
        }
        return false;
    }

    @Override
    int getResult(FindContext context) {
        return context.midVal;
    }
}
