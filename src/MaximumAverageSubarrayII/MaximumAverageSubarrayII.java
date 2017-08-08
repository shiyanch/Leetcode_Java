package MaximumAverageSubarrayII;

/**
 * 644. Maximum Average Subarray II
 *
 * Given an array consisting of n integers,
 * find the contiguous subarray whose length is greater than or equal to k
 * that has the maximum average value.
 *
 * And you need to output the maximum average value.
 */
public class MaximumAverageSubarrayII {
    // Explanation on Leetcode.
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        double max = nums[0];
        double min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        double prev_mid = max, error = Integer.MAX_VALUE;
        while (error > 0.00001) {
            double mid = (max+min)*0.5;
            if (check(nums, mid, k)) {
                min = mid;
            } else {
                max = mid;
            }
            error = Math.abs(prev_mid - mid);
            prev_mid = mid;
        }
        return min;
    }

    private boolean check(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, min_sum = 0;
        for (int i=0; i<k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        for (int i=k; i<nums.length; i++) {
            sum += nums[i]-mid;
            prev += nums[i-k]-mid;
            min_sum = Math.min(prev, min_sum);
            if (sum >= min_sum) {
                return true;
            }
        }
        return false;
    }
}
