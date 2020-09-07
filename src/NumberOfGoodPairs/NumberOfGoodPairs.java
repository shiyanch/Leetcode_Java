package NumberOfGoodPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512. Number of Good Pairs
 *
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * Return the number of good pairs.
 */
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            int goodPairs = counts.getOrDefault(num, 0);
            result += goodPairs;
            counts.put(num, goodPairs + 1);
        }
        return result;
    }
}
