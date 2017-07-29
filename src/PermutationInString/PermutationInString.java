package PermutationInString;

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2,
 * write a function to return true if s2 contains the permutation of s1.
 *
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (n < m) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i=0; i<m; i++) {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }

        for (int i=0; i<n-m; i++) {
            if (match(map1, map2)) {
                return true;
            }
            map2[s2.charAt(i)-'a']--;
            map2[s2.charAt(i+m)-'a']++;
        }
        return match(map1, map2);
    }

    private boolean match(int[] map1, int[] map2) {
        for (int i=0; i<map1.length; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
