package PartitionEqualSubsetSum;

/**
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;

        int target = 0;
        for(int num:nums) {
            target += num;
        }

        if(target%2 != 0)
            return false;

        target /= 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int i=1;i<=nums.length;i++) {
            for(int j=target;j>=nums[i-1];j--){
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition2(new int[] {1,2,3}));
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        int target = 0;
        for (int num : nums) {
            target += num;
        }

        if (target % 2 != 0)
            return false;

        target /= 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 不推荐，这是可重复取数的写法
        for(int i=1;i<target+1;i++) {
            for(int j=0;j<nums.length;j++) {
                if(i >= nums[j])
                    dp[i] = dp[i] || dp[i-nums[j]];
            }
        }

        return dp[target];
    }
}
