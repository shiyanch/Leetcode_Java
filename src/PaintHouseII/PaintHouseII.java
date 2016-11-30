package PaintHouseII;

import java.util.Arrays;

/**
 * 265. Paint House II
 *
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 *
 * Find the minimum cost to paint all houses.
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        int last_one = Integer.MAX_VALUE;
        int last_two = Integer.MAX_VALUE;
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i=0; i<n; i++) {
            int cur_one = Integer.MAX_VALUE;
            int cur_two = Integer.MAX_VALUE;
            for (int j=0; j<k; j++) {
                if (dp[j] == last_one) {
                    dp[j] = (i==0)?costs[i][j]:costs[i][j] + last_two;
                }
                else {
                    dp[j] = (i==0)?costs[i][j]:costs[i][j] + last_one;
                }

                if (cur_one > dp[j]) {
                    cur_two = cur_one;
                    cur_one = dp[j];
                }
                else {
                    cur_two = Math.min(cur_two, dp[j]);
                }
            }
            last_one = cur_one;
            last_two = cur_two;
        }

        return last_one;
    }
}
