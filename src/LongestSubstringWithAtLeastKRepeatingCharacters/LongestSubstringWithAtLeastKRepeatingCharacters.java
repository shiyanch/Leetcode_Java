package LongestSubstringWithAtLeastKRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 *
 * Find the length of the longest substring T of a given string
 * (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length(), k);
    }

    private int divideAndConquer(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] cnt = new int[26];
        for (int i = start; i < end; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (cnt[s.charAt(i) - 'a'] < k) {
                return Math.max(divideAndConquer(s, start, i, k), divideAndConquer(s, i + 1, end, k));
            }
        }
        return end - start;
    }

    // O(n^2) -> TLE
    public int longestSubstring2(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char[] array = s.toCharArray();
        int longest = Integer.MIN_VALUE;

        for(int i=0;i<s.length();i++) {
            if(longest >= s.length() - i) {
                return longest;
            }

            int[] alphabet = new int[26];
            Set<Character> set = new HashSet<>();
            for(int j=i;j<s.length();j++) {
                alphabet[array[j]-'a']++;
                if(alphabet[array[j]-'a'] >= k) {
                    set.remove(array[j]);
                }
                else {
                    set.add(array[j]);
                }

                if(set.isEmpty() && j-i+1 > longest) {
                    longest = j-i+1;
                }
            }
        }

        return longest == Integer.MIN_VALUE?0:longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("aaaabb", 3));
    }
}
