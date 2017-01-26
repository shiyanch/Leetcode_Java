package TargetSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer,
 * you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class TargetSum {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        dfs(nums, 0, 0, S);
        return count;
    }

    // 707ms
    private void dfs(int[] nums, int index, int sum, int S) {
        if (index > nums.length) {
            return;
        }
        if (index == nums.length) {
            if (S == sum) {
                count++;
            }
            return;
        }

        dfs(nums, index+1, sum + nums[index], S);
        dfs(nums, index+1, sum - nums[index], S);
    }

    // 144ms
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        map.put(-nums[0], map.getOrDefault(-nums[0], 0)+1);

        int[] flags = {1, -1};
        for (int i=1; i<nums.length; i++) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Integer key : map.keySet()) {
                for (int flag : flags) {
                    int sum = key + flag * nums[i];
                    newMap.put(sum, newMap.getOrDefault(sum, 0)+map.get(key));
                }
            }
            map = newMap;
        }

        return map.getOrDefault(S, 0);
    }

    // 14ms
    public int findTargetSumWays_dp(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum < S || (sum+S)%2 > 0) {
            return 0;
        }

        S = (S+sum)/2;
        int[] dp = new int[S+1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = S; i >= n; i--) {
                dp[i] += dp[i-n];
            }
        }
        return dp[S];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(new TargetSum().findTargetSumWays2(nums, 3));
    }
}
