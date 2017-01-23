package MaxConsecutiveOnes;

/**
 * 485. Max Consecutive Ones
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i:nums) {
            if (i == 1) {
                count++;
                max = Math.max(max, count);
            }
            else {
                count = 0;
            }
        }
        return max;
    }
}
