package LongestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 *
 * We define a harmonious array is an array
 * where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array,
 * you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key: map.keySet()) {
            if (map.containsKey(key+1)) {
                max = Math.max(max, map.get(key)+map.get(key+1));
            }
        }

        return Math.max(0, max);
    }
}
