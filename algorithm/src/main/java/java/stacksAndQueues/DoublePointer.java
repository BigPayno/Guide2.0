package java.stacksAndQueues;

import java.util.stream.Stream;

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

        public static void main(String[] args) {
            Solution solution = new Solution();
            Stream.of(solution.twoSum(int[]{1,3,5,7},9));
        }
    }

}
