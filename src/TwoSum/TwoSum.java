package TwoSum;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Hashtable hashtable = new Hashtable();
        for(int i=0;i<nums.length;i++)
            hashtable.put(nums[i],i);

        for(int i=0;i<nums.length;i++) {
            int remain = target - nums[i];
            if(hashtable.containsKey(remain)) {
                int pair = (int) hashtable.get(remain);
                if(pair != i) {
                    return new int[]{i, pair};
                }
            }
        }
        return new int[2];
    }
}
