package LongestIncreasingSubsequence;

/**
 * 300. Longest Increasing Subsequence
 *
 * Given an unsorted array of integers,
 * find the length of longest increasing subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101],
 * therefore the length is 4.
 *
 * Note that there may be more than one LIS combination,
 * it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] sum = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            sum[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && sum[j] >= sum[i])
                    sum[i] = sum[j] + 1;
            }
        }

        for(int n:sum) {
            if(n > max)
                max = n;
        }
        return max;
    }

}
