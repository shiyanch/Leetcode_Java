package CoinChangeII;

/**
 *
 * 518. Coin Change II
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 每一枚Coin只有用或不用两种状态
        // 如果像下面被注释的代码这样写，会出现1+2和2+1被同时累加进结果

        // for (int i = 1; i <= amount; i++) {
        //     for (int j = 0; j < coins.length && coins[j] <= i; j++) {
        //         dp[i] += dp[i - coins[j]];
        //     }
        // }

        // 按照下面这样写，内循环是在考虑当前用（一个或多个）coins[j]能构成的枚举数
        // 当j移位之后，coins[j-1]不会再出现在内循环中
        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                dp[i] += dp[i - coins[j]];
            }
        }
        return dp[amount];
    }
}
