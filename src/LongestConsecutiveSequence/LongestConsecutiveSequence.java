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
        int res = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int num:nums) {
            if(hashMap.containsKey(num))
                continue;

            int left = hashMap.getOrDefault(num-1, 0);
            int right = hashMap.getOrDefault(num+1, 0);
            int sum = left+right+1;

            if(sum > res) res = sum;

            hashMap.put(num, sum);
            hashMap.put(num-left, sum);
            hashMap.put(num+right, sum);

        }
        return res;
    }
}
