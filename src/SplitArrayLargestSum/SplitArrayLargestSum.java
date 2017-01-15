package SplitArrayLargestSum;

/**
 * 410. Split Array Largest Sum
 *
 * Given an array which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++)
            sum[i] = sum[i-1]+nums[i];

        int[][] cache = new int[nums.length][];
        for(int i=0;i<nums.length;i++) {
            cache[i] = new int[m];
        }

        return helper(sum, 0, m-1, cache);
    }

    private int helper(int[] sum, int start, int m, int[][] cache) {
        if(start == sum.length-1 && m != 0)
            return 0;
        if(m == 0) {
            return (start > 0)?sum[sum.length - 1] - sum[start - 1]:sum[sum.length-1];
        }

        int min = Integer.MAX_VALUE;
        for(int i=start+1;i<sum.length;i++) {
            int before = sum[i-1];
            if(start > 0)
                before -= sum[start-1];

            int afterI = 0;
            if(cache[i][m-1] != 0) {
                afterI = cache[i][m - 1];
            }
            else {
                afterI = helper(sum, i, m - 1, cache);
                cache[i][m-1] = afterI;
            }

//            System.out.println(start+" "+i+" "+m+" :"+min+" "+before+" "+afterI);
            min = Math.min(Math.max(before, afterI), min);
        }

        return min;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public int splitArray_2(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binary(nums, m, sum, max);
    }

    private long binary(int[] nums, int m, long high, long low) {
        long mid = 0;
        while (low < high) {
            mid = (high-low)/2+low;
            if (valid(nums, m, mid)) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return high;
    }

    private boolean valid(int[] nums, int m, long max) {
        int cur = 0;
        int count = 1;
        for (int num : nums) {
            cur += num;
            if (cur > max) {
                cur = num;
                if (++count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[] {1, 2147483646}, 1));
    }
}
