package PalindromePartitioningII;

import java.util.Arrays;

/**
 * 132. Palindrome Partitioning II
 *
 * Given a string s,
 * partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        boolean[][] pair = new boolean[s.length()+1][s.length()+1];
        int[] cut = new int[s.length()+1];
        Arrays.fill(cut, Integer.MAX_VALUE);
        cut[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || pair[j+1][i-1])) {
                    pair[j][i] = true;
                    if (j == 0) {
                        cut[i+1] = 0;
                    }
                    else {
                        cut[i+1] = Math.min(cut[i+1], cut[j]+1);
                    }
                }
            }
        }
        return cut[s.length()];
    }
}
