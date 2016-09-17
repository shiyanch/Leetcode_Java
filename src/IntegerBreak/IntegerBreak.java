package IntegerBreak;

/**
 * 343. Integer Break
 *
 * Given a positive integer n,
 * break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * Hint:
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++)
            for(int j=1;j<=i/2;j++)
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));

        return dp[n];
    }

    // n = 3*power + reminder
    // if(reminder == 1) n = 3*(power-1) + (reminder+3)
    // reminder = 4; power = power-1;
    // result = 3^power*reminder
    public int integerBreak2(int n) {
        if(n == 2 || n == 3)
            return n-1;

        int reminder = n%3;
        int power = n/3;

        if(reminder == 1) {
            power--;
            reminder = 4;
        }
        else if(reminder == 0)
            reminder = 1;

        return (int)Math.pow(3,power)*reminder;
    }
}
