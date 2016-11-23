package InterleavingString;

/**
 * 97. Interleaving String
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0 || s2.length() == 0) {
            return s1.equals(s3) || s2.equals(s3);
        }

        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j ==0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = (s2.charAt(j-1) == s3.charAt(j-1) && dp[i][j-1]);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][j]);
                    continue;
                }

                if (s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j];
                }
                if (s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
