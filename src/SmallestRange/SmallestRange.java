package SmallestRange;

import java.util.*;

/**
 * 632. Smallest Range
 *
 * You have k lists of sorted integers in ascending order.
 * Find the smallest range that includes at least one number from each of the k lists.
 *
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 *
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        // <value, corresponding index in nums>
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        int[] count = new int[nums.size()];
        Set<Integer> numOfLists = new HashSet<>();
        List<Integer> res = new ArrayList<>(2);

        for (int i=0; i<nums.size(); i++) {
            for (int num : nums.get(i)) {
                if (!map.containsKey(num)) {
                    map.put(num, new HashSet<Integer>());
                }
                map.get(num).add(i);
            }
        }

        Integer left = map.firstKey();
        Integer right = map.firstKey();

        while (right != null) {
            // Add right pointer into window
            Set<Integer> indices = map.get(right);
            for (int index : indices) {
                count[index]++;
                numOfLists.add(index);
            }

            // If every list is covered, shrink the window by move left pointer
            while (numOfLists.size() == nums.size() && left<=right) {
                if (res.isEmpty() || res.get(1)-res.get(0) > right-left) {
                    res.clear();
                    res.add(left);
                    res.add(right);
                }

                Set<Integer> leftIndices = map.get(left);
                for (int index : leftIndices) {
                    if (--count[index] == 0) {
                        numOfLists.remove(index);
                    }
                }
                left = map.higherKey(left);
            }
            right = map.higherKey(right);
        }

        return res.isEmpty() ? new int[0] : new int[] {res.get(0), res.get(1)};
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(4,10,15,24,26));
        lists.add(Arrays.asList(0,9,12,20));
        lists.add(Arrays.asList(5,18,22,30));
        int[] res = new SmallestRange().smallestRange(lists);
        if (res != null) {
            System.out.println(res[0]+" "+res[1]);
        }
        System.out.println("Done");
    }
}
