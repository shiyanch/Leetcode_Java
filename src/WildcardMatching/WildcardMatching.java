package WildcardMatching;

/**
 * 44. Wildcard Matching
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int j=1; j<=n; j++) {
            dp[0][j] = (p.charAt(j-1)=='*') && dp[0][j-1];
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}
