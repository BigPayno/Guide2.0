package java.dynamicPlanning.subSequence.longestIncreasingSubSequence;

import java.util.Arrays;

public class BaseLIS implements LongestIncreSubsequence{
    @Override
    public int longestIncrementSubsequence(int[] nums) {
        int [] longestLength = new int[nums.length];
        Arrays.fill(longestLength,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0;j< i;j++){
                if(nums[j]<nums[i]){
                    longestLength[i] = Math.max(longestLength[i],longestLength[j]+1);
                }
            }
        }
        int result = 0;
        for (int i=0;i<nums.length;i++){
            result = Math.max(result,longestLength[i]);
        }
        return result;
    }
}
