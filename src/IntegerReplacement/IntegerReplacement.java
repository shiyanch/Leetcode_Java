package IntegerReplacement;

/**
 * 397. Integer Replacement
 *
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 */
public class IntegerReplacement {
    // look at least two-bit
    // if is 11 then increase
    // if is 01 then decrease
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if((n & 1) == 0) {
                n >>>= 1;
            }
            else if(n == 3 || ((n >>> 1) & 1) == 0) {
                --n;
            }
            else {
                ++n;
            }
            count++;
        }

        return count;
    }

    // Memory Limit Exceeded
    public int integerReplacement_dp(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;

        for(int i=2;i<=n;i++) {
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i/2]+1, dp[i-1]+1);
            }
            else {
                dp[i] = Math.min(Math.min(dp[i/2]+2, dp[(i+1)/2]+2), dp[i-1]+1);
            }
        }
        return dp[n];
    }
}
