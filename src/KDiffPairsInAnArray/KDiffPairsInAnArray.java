package KDiffPairsInAnArray;

import java.util.HashSet;
import java.util.Set;

/**
 * 532. K-diff Pairs in an Array
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                if (k == 0 && !added.contains(num)) {
                    count++;
                    added.add(num);
                }
                continue;
            }

            if (set.contains(num-k)) {
                count++;
            }

            if (set.contains(k+num)) {
                count++;
            }

            set.add(num);
        }
        return count;
    }
}
