package MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k,
 * find the maximum length of a subarray that sums to k.
 *
 * If there isn't one, return 0 instead.
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int max = 0;
        // 把0先存进去，防止数组开头的和为0
        map.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            // 对于相同的值，只存一次
            // 如果在i出现了s，在j又出现了s，说明i-j之间的和为0
            // 为求最长串，需要把这些和为0的长度算进去
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5};
        int k = 5;
        System.out.println(new MaximumSizeSubarraySumEqualsK().maxSubArrayLen(nums, k));
    }
}
