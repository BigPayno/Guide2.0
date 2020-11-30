package java.binaryFind.faststart;

/**
 * @author payno
 * @date 2020/6/23 23:12
 * @description
 */
public class MainTest {
    public static void main(String[] args) {
        BinaryFind baseFind = new BaseBinaryFind();
        System.out.println(baseFind.binaryFind(new int[]{1,2,3,4,5,7,10},7));
        System.out.println(baseFind.binaryFind(new int[]{1,2,3,4,5,7,10},1));
        System.out.println(baseFind.binaryFind(new int[]{1,2,3,4,5,7,10},10));
        System.out.println(baseFind.binaryFind(new int[]{1,2,3,4,5,7,10},11));
        System.out.println(baseFind.binaryFind(new int[]{1,2,3,4,5,7,10},0));

        BinaryFind leftRangeFind = new LeftRangeOfBinaryFind();
        System.out.println(leftRangeFind.binaryFind(new int[]{1,2,3,4,5,7,7,7,10},7));
        System.out.println(leftRangeFind.binaryFind(new int[]{1,2,3,4,5,7,7,7,10},1));
        System.out.println(leftRangeFind.binaryFind(new int[]{1,2,3,4,5,7,7,7,10},10));
        System.out.println(leftRangeFind.binaryFind(new int[]{1,2,3,4,5,7,7,7,10},11));
        System.out.println(leftRangeFind.binaryFind(new int[]{1,2,3,4,5,7,7,7,10},0));
    }
}
