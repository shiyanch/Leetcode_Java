package MissingRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 *
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(getRange(lower, upper));
            return res;
        }

        if (nums[0] > lower) {
            res.add(getRange(lower, nums[0]-1));
        }

        for (int i=1;i<nums.length;i++) {
            if (nums[i] <= nums[i-1]+1)
                continue;

            res.add(getRange(nums[i-1]+1, nums[i]-1));
        }

        if (nums[nums.length-1] < upper) {
            res.add(getRange(nums[nums.length-1]+1, upper));
        }
        return res;
    }

    private String getRange(int a, int b) {
        return (a==b)?a+"":a+"->"+b;
    }
}
