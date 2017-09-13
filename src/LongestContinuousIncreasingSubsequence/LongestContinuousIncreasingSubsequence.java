package LongestContinuousIncreasingSubsequence;

/**
 * 674. Longest Continuous Increasing Subsequence
 *
 * Given an unsorted array of integers,
 * find the length of longest continuous increasing subsequence.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int curLen = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                curLen++;
            } else {
                max = Math.max(max, curLen);
                curLen = 1;
            }
        }
        return Math.max(max, curLen);
    }
}
