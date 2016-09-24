package WiggleSubsequence;

import java.util.Arrays;

/**
 * 376. Wiggle Subsequence
 *
 * A sequence of numbers is called a wiggle sequence
 * if the differences between successive numbers strictly alternate between positive and negative.
 *
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3)
 * are alternately positive and negative.
 *
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences,
 * the first because its first two differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 *
 * Examples:
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 *
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length.
 * One is [1,17,10,13,10,16,8].
 *
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 */
public class WiggleSubsequence {
    // greedy solution
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1)
            return nums.length;

        int k = 1;
        while(k<nums.length && nums[k]==nums[k-1])
            k++;
        if(k == nums.length)
            return 1;

        int maxLen = 2;
        boolean isIncreasing = nums[k] > nums[k-1];
        for(int i=k+1;i<nums.length;i++) {
            if((isIncreasing && nums[i]<nums[i-1]) || (!isIncreasing && nums[i]>nums[i-1])) {
                maxLen++;
                isIncreasing = !isIncreasing;
            }
        }
        return maxLen;
    }

    // dp solution
    public int wiggleMaxLength_DP(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int len = nums.length;
        int[] ends_large = new int[len];
        int[] ends_small = new int[len];
        Arrays.fill(ends_large, 1);
        Arrays.fill(ends_small, 1);

        for(int i=1;i<len;i++) {
            for(int j=i-1;j>=0;j--) {
                if(nums[i] > nums[j])
                    ends_large[i] = Math.max(ends_large[i], ends_small[j]+1);
                else if(nums[i] < nums[j])
                    ends_small[i] = Math.max(ends_small[i], ends_large[j]+1);
            }
        }

        return Math.max(ends_large[len-1], ends_small[len-1]);
    }
}
