package ClimbingStairs;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a stair case.
 * It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStaris(int n) {
        if(n <= 2)
            return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++)
            dp[i] = dp[i-1]+dp[i-2];

        return dp[n];
    }
}
