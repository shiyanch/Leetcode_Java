package ContiguousArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 *
 * Given a binary array,
 * find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    // 76ms
    // The idea is to change 0 in the original array to -1.
    // Thus, if we find SUM[i, j] == 0 then we know there are even number of -1 and 1 between index i and j.
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }

    // 89ms
    // 0和1相差的个数作为key，如果之前出现过这个key，则这一段内0和1的个数相同
    public int findMaxLength_mine(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count0++;
            }
            else {
                count1++;
            }
            int key = count0-count1;
            if (map.containsKey(key)) {
                max = Math.max(max, i-map.get(key));
            }
            else {
                map.put(key, i);
            }
        }

        return max;
    }
}
