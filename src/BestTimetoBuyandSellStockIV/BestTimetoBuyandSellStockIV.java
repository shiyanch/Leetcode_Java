package BestTimetoBuyandSellStockIV;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete at most k transactions.
 */
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }

        if (k >=  prices.length/2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] sell = new int[k][prices.length+1];
        int[][] buy = new int[k][prices.length+1];

        for (int i=0;i<k;i++) {
            Arrays.fill(buy[i], Integer.MIN_VALUE);
        }

        for (int i=1;i<=prices.length;i++) {
            for (int j=k-1;j>=0;j--) {
                sell[j][i] = Math.max(sell[j][i-1], buy[j][i-1]+prices[i-1]);
                buy[j][i] = (j == 0)?Math.max(buy[j][i-1], -prices[i-1]):Math.max(buy[j][i-1], sell[j-1][i-1]-prices[i-1]);
            }
        }
        return sell[k-1][prices.length];
    }

    public static void main(String[] args) {
        int[] prices = {1,2};
        int k = 2;
        System.out.println(new BestTimetoBuyandSellStockIV().maxProfit(k, prices));
    }
}

