package RichestCustomerWealth;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1672. Richest Customer Wealth
 *
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the
 * jth bank. Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int wealth = 0;
            for (int money : account) {
                wealth += money;
            }
            max = Math.max(max, wealth);
        }
        return max;
    }
}
