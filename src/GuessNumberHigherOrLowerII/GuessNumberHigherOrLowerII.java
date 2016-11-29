package GuessNumberHigherOrLowerII;

/**
 * 375. Guess Number Higher or Lower II
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong,
 * I'll tell you whether the number I picked is higher or lower.
 *
 * However, when you guess a particular number x, and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 */

// 我们假定选择了一个错误的数x，（1<=x<=n && x!=y ）那么就知道接下来应该从[1,x-1 ] 或者[x+1,n]中进行查找。
// 假如我们已经解决了[1,x-1] 和 [x+1,n]计算问题，我们将其表示为solve(L,x-1) 和solve(x+1,n)，
// 那么我们应该选择max(solve(L,x-1),solve(x+1,n)) 这样就是求最坏情况下的损失。
// 总的损失就是 f(x) = x + max(solve(L,x-1),solve(x+1,n))
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmountBottomUp(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int l=1;l<n;l++) {
            for (int s=1;s+l<=n;s++) {
                dp[s][s+l] = Integer.MAX_VALUE;
                for (int i=s;i<s+l;i++) {
                    dp[s][s+l] = Math.min(dp[s][s+l], i+Math.max(dp[s][i-1], dp[i+1][s+l]));
                }
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return getMax(dp, 0, n);
    }

    private int getMax(int[][] dp, int s, int e) {
        if (s >= e) {
            return 0;
        }

        if (dp[s][e] != 0) {
            return dp[s][e];
        }

        int res = Integer.MAX_VALUE;
        for (int x = s; x <= e; x++) {
            int temp = x + Math.max(getMax(dp, s, x-1), getMax(dp, x+1, e));
            res = Math.min(res, temp);
        }
        dp[s][e] = res;
        return res;
    }
}
