package MaximumLengthOfRepeatedSubarray;

/**
 * 718. Maximum Length of Repeated Subarray
 *
 * Given two integer arrays A and B,
 * return the maximum length of an subarray that appears in both arrays.
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[m][n];

        int max = 0;
        // i for B, j for A
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (B[i] == A[j]) {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0 && A[j-1] == B[i-1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
