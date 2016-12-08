package LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int low = 0;

        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
            if (map.size() > k) {
                int toRemove = i;
                for (int index : map.values()) {
                    toRemove = Math.min(toRemove, index);
                }
                map.remove(s.charAt(toRemove));
                low = toRemove+1;
            }
            longest = Math.max(longest, i-low+1);
        }

        return longest;
    }

    public static void main(String[] args) {
        String[] ss = {"abc", "annc", "annncccx", "eceba"};
        for (String s : ss) {
            System.out.println(lengthOfLongestSubstringKDistinct(s, 3));
        }
    }
}
