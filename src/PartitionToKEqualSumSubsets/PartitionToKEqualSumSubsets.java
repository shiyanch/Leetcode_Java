package PartitionToKEqualSumSubsets;

import java.util.Arrays;

/**
 * 698. Partition to K Equal Sum Subsets
 *
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);

        return dfs(nums, new int[k], 0, sum/k);
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }

    private boolean dfs(int[] nums, int[] sum, int index, int target) {
        if (index == nums.length) {
            for (int i=1; i<sum.length; i++) {
                if (sum[i] != sum[0]) {
                    return false;
                }
            }
            return true;
        }

        for (int i=0; i<sum.length; i++) {
            if (sum[i] + nums[index] > target) {
                continue;
            }

            sum[i] += nums[index];
            if (dfs(nums, sum, index+1, target)) {
                return true;
            }
            sum[i] -= nums[index];
        }
        return false;
    }
}
