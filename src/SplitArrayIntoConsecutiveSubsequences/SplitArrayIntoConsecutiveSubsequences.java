package SplitArrayIntoConsecutiveSubsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. Split Array into Consecutive Subsequences
 *
 * You are given an integer array sorted in ascending order (may contain duplicates),
 * you need to split them into several subsequences,
 * where each subsequences consist of at least 3 consecutive integers.
 * Return whether you can make such a split.
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Map<Integer, Integer> appendMap = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }

            if (appendMap.getOrDefault(num, 0) > 0) {
                appendMap.put(num+1, appendMap.getOrDefault(num+1,0)+1);
                appendMap.put(num, appendMap.get(num)-1);
            } else {
                if (map.getOrDefault(num+1, 0) > 0 && map.getOrDefault(num+2, 0) > 0) {
                    map.put(num+1, map.get(num+1)-1);
                    map.put(num+2, map.get(num+2)-1);
                    appendMap.put(num+3, appendMap.getOrDefault(num+3,0)+1);
                } else {
                    return false;
                }
            }
            map.put(num, map.get(num)-1);
        }
        return true;
    }
}
