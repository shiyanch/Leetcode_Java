package MaximumProductOfThreeNumbers;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 *
 * Given an integer array,
 * find three numbers whose product is maximum and output the maximum product.
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len-2]*nums[len-3], nums[0]*nums[1])*nums[len-1];
    }
}
