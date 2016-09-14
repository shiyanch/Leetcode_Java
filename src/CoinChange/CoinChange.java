package CoinChange;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++) {
            int j=0;
            int min = Integer.MAX_VALUE;
            while(j<coins.length && coins[j]<=i) {
                if(res[i-coins[j]] >= 0 && res[i-coins[j]] < min)
                    min = res[i-coins[j]]+1;
                j++;
            }

            res[i] = (Integer.MAX_VALUE == min)?-1:min;
        }

        return res[amount];

    }
}
