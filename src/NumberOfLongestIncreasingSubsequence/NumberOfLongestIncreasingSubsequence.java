package NumberOfLongestIncreasingSubsequence;

/**
 * 673. Number of Longest Increasing Subsequence
 *
 * Given an unsorted array of integers,
 * find the number of longest increasing subsequence.
 *
 * Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int longest = 0, maxCount = 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j]+1) {
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j]+1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > longest) {
                longest = dp[i];
                maxCount = count[i];
            } else if (dp[i] == longest) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
