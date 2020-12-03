package study.stacksAndQueues;

public class DoublePointer {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int i = 0,j = nums.length-1;
            while(i<=j){
                if(nums[i]+nums[j]==target){
                    break;
                }
                if(nums[i]+nums[j]<target){
                    i++;
                }
                if(nums[i]+nums[j]>target){
                    j--;
                }
            }
            if(nums[i]+nums[j]==target){
                return new int[]{i, j};
            }else{
                return new int[]{};
            }
        }
    }

}
