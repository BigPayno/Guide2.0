package java.dynamicPlanning.subSequence.longestIncreasingSubSequence;

public class MainTest {
    public static void main(String[] args) {
        LongestIncreSubsequence lis = new BaseLIS();
        System.out.println(lis.longestIncrementSubsequence(new int[]{10,9,2,5,3,-1,111}));
    }
}
