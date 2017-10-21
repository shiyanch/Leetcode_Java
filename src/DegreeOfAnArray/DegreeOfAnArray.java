package DegreeOfAnArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 *
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, count.get(nums[i]));
            if (!start.containsKey(nums[i])) {
                start.put(nums[i], i);
            }
            end.put(nums[i], i);
        }

        int min = nums.length;
        for (int num : nums) {
            if (count.get(num) == max) {
                min = Math.min(min, end.get(num) - start.get(num) + 1);
            }
        }
        return min;
    }
}
