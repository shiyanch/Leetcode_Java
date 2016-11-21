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
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        int j = nums.length-1;
        while(i < j) {
            sum += (nums[j--]-nums[i++]);
        }
        return sum;
    }
}
