package DeleteOperationForTwoStrings;

/**
 * 583. Delete Operation for Two Strings
 *
 * Given two words word1 and word2,
 * find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 0;
        for (int i=1; i<=s.length(); i++) {
            dp[i][0] = dp[i-1][0]+1;
        }

        for (int j=1; j<=t.length(); j++) {
            dp[0][j] = dp[0][j-1]+1;
        }

        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+1;
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
