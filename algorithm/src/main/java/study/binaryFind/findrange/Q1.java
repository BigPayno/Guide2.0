package study.binaryFind.findrange;

/**
 * @author payno
 * @date 2020/6/24 11:56
 * @description
 */
public class Q1 {
    static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(left_bound(new int[]{0,1,1,3},2));
    }
}
