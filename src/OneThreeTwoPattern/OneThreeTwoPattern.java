package OneThreeTwoPattern;

/**
 * 456. 132 Pattern
 *
 * Given a sequence of n integers a1, a2, ..., an,
 * a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 *
 * Design an algorithm that takes a list of n numbers as input
 * and checks whether there is a 132 pattern in the list.
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int start = 0;

        while (start < nums.length-2) {
            while (start < nums.length-2 && nums[start] >= nums[start+1]) {
                start++;
            }

            int mid = start+1;
            while (mid < nums.length-1 && nums[mid] <= nums[mid+1]) {
                mid++;
            }

            for (int end = mid+1; end < nums.length; end++) {
                if (nums[end] > nums[start] && nums[end] < nums[mid]) {
                    return true;
                }
            }

            start++;
        }
        return false;
    }
}
