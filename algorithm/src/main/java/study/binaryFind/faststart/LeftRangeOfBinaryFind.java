package study.binaryFind.faststart;

/**
 * @author payno
 * @date 2020/6/23 23:05
 * @description
 */
public class LeftRangeOfBinaryFind extends AbstractBinaryFind{
    @Override
    boolean limitStart(int mid, int target, int[] nums) {
        int midVal = nums[mid];
        if(midVal<target){
            return true;
        }
        if(midVal==target){
            if(mid!=0&&mid!=nums.length-1){
                return nums[mid+1]!=target;
            }
        }
        return false;
    }

    @Override
    boolean limitEnd(int mid, int target, int[] nums) {
        int midVal = nums[mid];
        if(midVal>target){
            return true;
        }
        if(midVal==target){
            if(mid!=0){
                return nums[mid-1]==target;
            }
        }
        return false;
    }

    @Override
    boolean findTarget(int mid, int target, int[] nums) {
        if(nums[mid]==target){
            return mid==0?true:(nums[mid-1]<target);
        }
        return false;
    }
}
