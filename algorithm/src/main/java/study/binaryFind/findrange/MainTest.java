package study.binaryFind.findrange;

/**
 * @author payno
 * @date 2020/6/24 11:03
 * @description
 */
public class MainTest {

    private static void test(BinaryFind find,FindContext context){
        System.out.println(find.binaryFind(context));
    }

    public static void main(String[] args) {
        BinaryFind leftRangeFind = new LeftRangeBinaryRangeFind();
        BinaryFind rightRangeFind = new RightRangeBinaryRangeFind();
        test(leftRangeFind,FindContext.of(new int[]{1},1,0,1));
        test(leftRangeFind,FindContext.of(new int[]{1},0,0,1));
        int [] nums = new int[]{0,1,2,3,4,4,4,5,5,6};
        int low = leftRangeFind.binaryFind(FindContext.of(nums,5,0,nums.length-1));
        if(low==-1){
            System.out.println("[-1,-1]");
        }else{
            int high = rightRangeFind.binaryFind(FindContext.of(nums,5,low,nums.length-1));
            System.out.println("["+low+","+high+"]");
        }
    }
}
