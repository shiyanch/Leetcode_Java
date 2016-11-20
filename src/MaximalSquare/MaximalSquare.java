package MaximalSquare;

/**
 * 221. Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else {
                    dp[i][j] = matrix[i][j] == '1'? (Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1) : 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
