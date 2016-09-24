package RangeSumQueryImmutable;

/**
 * 303. Range Sum Query - Immutable
 *
 * Given an integer array nums,
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    private int[] dp;
    public RangeSumQueryImmutable(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }

        this.dp = nums;
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return dp[j];

        return dp[j]-dp[i-1];
    }
}
