package LargestDivisibleSubset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 *
 * Given a set of distinct positive integers,
 * find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0)
            return new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i=1;i<nums.length;i++) {
            dp[i] = Integer.MIN_VALUE;
            for(int j=i-1;j>=0;j--) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] == Integer.MIN_VALUE)
                dp[i] = 1;
        }

        int maxIndex = 0;
        for(int i=1;i<nums.length;i++)
            maxIndex = (dp[i]>dp[maxIndex])?i:maxIndex;

        int temp = nums[maxIndex];
        for(int i=maxIndex;i>=0;i--) {
            if(temp % nums[i] == 0 && dp[maxIndex]-dp[i] <= 1) {
                list.add(nums[i]);
                temp = nums[i];
                maxIndex = i;
            }
        }

        return list;
    }
}
