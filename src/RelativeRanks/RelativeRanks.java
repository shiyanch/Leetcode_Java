package RelativeRanks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 506. Relative Ranks
 *
 * Given scores of N athletes,
 * find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores,
 * so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 *
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {
    private static class Pair implements Comparable<Pair> {
        public final int index;
        public final int num;
        Pair(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Pair other) {
            return other.num - this.num;
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        List<Pair> list = new ArrayList<Pair>(nums.length);
        for (int i=0; i<nums.length; i++) {
            list.add(new Pair(i, nums[i]));
        }

        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            Pair curr = list.get(i);
            switch (i) {
                case 0:
                    res[curr.index] = "Gold Medal";
                    break;
                case 1:
                    res[curr.index] = "Silver Medal";
                    break;
                case 2:
                    res[curr.index] = "Bronze Medal";
                    break;
                default:
                    res[curr.index] = i+1+"";
                    break;
            }
        }

        return res;
    }
}
