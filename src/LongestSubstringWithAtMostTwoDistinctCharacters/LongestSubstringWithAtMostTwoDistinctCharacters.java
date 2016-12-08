package LongestSubstringWithAtMostTwoDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int low = 0;

        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
            if (map.size() > 2) {
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
            System.out.println(lengthOfLongestSubstringTwoDistinct(s));
        }
    }
}
