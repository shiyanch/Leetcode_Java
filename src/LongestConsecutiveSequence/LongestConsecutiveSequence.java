package LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */


// https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                int sum = left+right+1;
                longest = Math.max(longest, sum);

                map.put(num, sum);
                map.put(num-left, sum);
                map.put(num+right, sum);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {100,4,200,1,3,2}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {1,2,4,3,0}));
    }
}
