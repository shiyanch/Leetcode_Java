package BestTimeToBuyAndSellStockIII;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class BestTimeToBuyAndSellStockIII {
    /**
     * 1. 定义sell2为第i天结束后以第二次sell事件收尾的最大值
     * 2. 定义buy2为第i天结束后以第二次buy事件收尾的最大值
     * 3. 定义sell1为第i天结束后以第一次sell事件收尾的最大值
     * 2. 定义buy1为第i天结束后以第一次buy事件收尾的最大值
     *
     * buy事件必须初始化为Integer.MIN_VALUE，此后均为负值
     * sell事件必须初始化为0，此后均为正值**
     *
     * 第一次和第二次交易的关联在于buy2
     * 计算buy2的时候，要么这一天不交易，取前一天的buy2；要么在sell1的基础上买入当前price
     *
     * 如果只有2天，怎么更新到sell2？
     * 第一天结束后，sell1==0，buy1 == -prices[0]，buy2==-prices[0], sell2==0
     * 第二天结束后，sell2已经更新为prices[1]-prices[0]，与sell1此时一致
     * 再往后，sell2和buy2建立在sell1和buy1基础上
     */
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
