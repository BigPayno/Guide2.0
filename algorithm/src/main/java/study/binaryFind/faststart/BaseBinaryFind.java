package study.binaryFind.faststart;

/**
 * @author payno
 * @date 2020/6/23 23:03
 * @description
 */
public class BaseBinaryFind extends AbstractBinaryFind{

    @Override
    boolean limitStart(int mid, int target, int[] nums) {
        return nums[mid]<target;
    }

    @Override
    boolean limitEnd(int mid, int target, int[] nums) {
        return nums[mid]>target;
    }

    @Override
    boolean findTarget(int mid, int target, int[] nums) {
        return nums[mid]==target;
    }
}
