package LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] alphabet = new int[256];
        for(int i=0;i<alphabet.length;i++) alphabet[i] = -1;
        int max = 0;
        int m = 0;

        for(int i=0;i<s.length();i++) {
            m = Math.max(alphabet[s.charAt(i)]+1, m);
            alphabet[s.charAt(i)] = i;
            max = Math.max(max, i-m+1);
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] hash = new int[256];
        int longest = 0;
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            if(hash[s.charAt(right++)]++ > 0) {
                count++;
            }

            while (count > 0) {
                if(hash[s.charAt(left++)]-- > 1) {
                    count--;
                }
            }

            longest = Math.max(longest, right-left);
        }

        return longest;
    }

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("abba");
    }
}
