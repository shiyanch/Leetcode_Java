package MaximumSubarray;

/**
 * 53. Maximum Subarray
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums.length == 0)
            return max;

        if(nums.length == 1)
            return nums[0];

        int currentMax = nums[0];
        max = currentMax;
        for(int i=1;i<nums.length;i++) {
            currentMax = Math.max(currentMax+nums[i], nums[i]);
            if(currentMax > max)
                max = currentMax;
        }
        return max;
    }
}
