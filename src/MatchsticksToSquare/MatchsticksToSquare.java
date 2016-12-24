package MatchsticksToSquare;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square
 *
 * Remember the story of Little Match Girl?
 * By now, you know exactly what matchsticks the little match girl has,
 * please find out a way you can make one square by using up all those matchsticks.
 *
 * You should not break any stick, but you can link them up,
 * and each matchstick must be used exactly one time.
 *
 * Your input will be several matchsticks the girl has,
 * represented with their stick length.
 *
 * Your output will either be true or false,
 * to represent whether you could make one square using all the matchsticks the little match girl has.
 */
public class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);

        return dfs(nums, new int[4], 0, sum/4);
    }

    private void reverse(int[] nums) {
        int i=0, j=nums.length-1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    private boolean dfs(int[] nums, int[] sum, int index, int target) {
        if (index == nums.length) {
            return  (sum[0] == sum[1] && sum[0] == sum[2] && sum[0] == sum[3]);
        }

        for (int i=0; i<4; i++) {
            if (sum[i] + nums[index] > target) {
                continue;
            }

            sum[i] += nums[index];
            if (dfs(nums, sum, index+1, target)) {
                return true;
            }
            sum[i] -= nums[index];
        }

        return false;
    }
}
