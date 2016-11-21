package MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 *
 * Given a non-empty integer array,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int median = (nums.length % 2 == 0)?(nums[nums.length/2-1]+nums[nums.length/2])/2:nums[nums.length/2];
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num-median);
        }
        return sum;
    }
}
