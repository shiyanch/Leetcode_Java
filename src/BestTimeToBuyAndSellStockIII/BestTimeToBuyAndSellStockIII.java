package BestTimeToBuyAndSellStockIII;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int i=0;i<prices.length;i++) {
            sell2 = Math.max(sell2, buy2+prices[i]);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell1 = Math.max(sell1, buy1+prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
    }
}
