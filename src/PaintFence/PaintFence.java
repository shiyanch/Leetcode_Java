package PaintFence;

/**
 * 276. Paint Fence
 *
 * There is a fence with n posts,
 * each post can be painted with one of the k colors.
 *
 * You have to paint all the posts
 * such that no more than two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if ( k == 1) {
            return n < 3?1:0;
        }
        if (n == 1) {
            return k;
        }
        // 与前一块不同颜色：dp[i-1]*(k-1)
        // 与前一块相同颜色：dp[i-2]*(k-1)
        // dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1)
        int one = k;
        int two = k*k;
        for (int i=2; i<n; i++) {
            two = (k-1)*(one+two);
            one = two / (k-1) - one;
        }
        return two;
    }
}
