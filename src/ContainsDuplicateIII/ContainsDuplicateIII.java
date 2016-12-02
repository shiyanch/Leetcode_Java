package ContainsDuplicateIII;

import java.util.*;

/**
 * 220. Contains Duplicate III
 *
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array
 * such that the difference between nums[i] and nums[j] is at most t
 * and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    // Bucket 27 ms
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        long w = (long)t + 1;
        for (int i=0; i<nums.length; i++) {
            long m = getID(nums[i], w);

            if (map.containsKey(m)) {
                return true;
            }

            if (map.containsKey(m-1) && Math.abs(nums[i] - map.get(m-1)) < w) {
                return true;
            }

            if (map.containsKey(m+1) && Math.abs(nums[i] - map.get(m+1)) < w) {
                return true;
            }

            // bucket m is empty and no almost duplicate in neighbor buckets
            map.put(m, (long)nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i-k], w));
            }
        }
        return false;
    }

    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0?(x+1)/w - 1:x/w;
    }

    // BST 52 ms
    public boolean containsNearbyAlmostDuplicate_BST(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            Integer floor = treeSet.floor(nums[i]+t);
            Integer ceil = treeSet.ceiling(nums[i]-t);

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            treeSet.add(nums[i]);
            if (i >= k) {
                treeSet.remove(nums[i-k]);
            }
        }

        return false;
    }
}
