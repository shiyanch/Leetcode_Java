package ThreeSumClosest;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * Given an array S of n integers,
 * find three integers in S such that the sum is closest to a given number, target.
 *
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nearest = nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-2;i++) {

            // 剪枝但效果不明显
            int cur = nums[i]+nums[i+1]+nums[i+2];
            if(cur > target && Math.abs(cur - target) < Math.abs(nearest - target)) {
                nearest = cur;
                continue;
            }

            // 剪枝但效果不明显
            cur = nums[i]+nums[nums.length-1]+nums[nums.length-2];
            if(cur < target && Math.abs(cur - target) < Math.abs(nearest - target)) {
                nearest = cur;
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                cur = nums[left] + nums[right] + nums[i];
                if(cur == target)
                    return cur;

                if(Math.abs(cur - target) < Math.abs(nearest - target))
                    nearest = cur;

                if(cur < target)
                    left++;
                else
                    right--;
            }
        }

        return nearest;
    }
}
