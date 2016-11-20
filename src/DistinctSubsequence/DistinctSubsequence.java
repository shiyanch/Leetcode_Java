package DistinctSubsequence;

/**
 * 115. Distinct Subsequences
 *
 * Given a string S and a string T,
 * count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class DistinctSubsequence {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() == 0) {
            return T.length() == 0?1:0;
        }
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[0][j] = 1;
                if (T.charAt(i-1) == S.charAt(j-1)) {
                    // dp[i-1][j-1]表示当前第i个字符能够构成subsequence的次数
                    // dp[i][j-1]表示在当前字符在i之前已经能够构成subsequence的次数
                    // 两者相加，则dp[i][j]表示为当前字符在T[0,i]在S[0,j]之间能够构成subsequence的次数
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else {
                    // 保持字符T[i-1]在字符S[j]之前出能够构成subsequence的次数
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
