package PalindromicSubstrings;

/**
 * 647. Palindromic Substrings
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes
 * are counted as different substrings even they consist of same characters.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j <= 1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
