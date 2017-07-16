package MaximumAverageSubarrayI;

/**
 * 643. Maximum Average Subarray I
 *
 * Given an array consisting of n integers,
 * find the contiguous subarray of given length k that has the maximum average value.
 * And you need to output the maximum average value.
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (i<k) {
                sum += nums[i];
                if (i == k-1) {
                    max = Math.max(max, sum/k);
                }
            } else {
                sum += nums[i] - nums[i-k];
                max = Math.max(max, sum/k);
            }
        }
        return max;
    }
}
