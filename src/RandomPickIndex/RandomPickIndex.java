package RandomPickIndex;

import java.util.Random;

/**
 * 398. Random Pick Index
 *
 * Given an array of integers with possible duplicates,
 * randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large.
 * Solution that uses too much extra space will not pass the judge.
 */
public class RandomPickIndex {
    private int[] nums;
    private Random rnd;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }
}
