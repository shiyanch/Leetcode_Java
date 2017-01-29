package MaxConsecutiveOnesII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 487. Max Consecutive Ones II
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 *
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 * After flipping, the maximum number of consecutive 1s is 4.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnesII {
    // 10 ms
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, q = -1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                l = q + 1;
                q = h;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    // 24 ms
    public int findMaxConsecutiveOnes_2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            left[i] = (nums[i] == 0)?0:((i>0&&nums[i-1]==1)?left[i-1]+1:1);
            right[nums.length-1-i] = (nums[nums.length-1-i]==0)?0:((i>0&&nums[nums.length-i]==1)?right[nums.length-i]+1:1);
        }
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                int sum = (i>0?left[i-1]:0) + (i<nums.length-1?right[i+1]:0) + 1;
                max = Math.max(max, sum);
            }
            else max = Math.max(max, left[i]);
        }
        return max;
    }

    // 18 ms
    public int findMaxConsecutiveOnes_3(int[] nums) {
        int prev = -1;
        int cur = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                cur++;
            }
            else {
                prev = (i>0 && nums[i-1]==0)?0:cur+1;
                cur = 0;
            }
            max = Math.max(max, (prev<=0)?cur:cur+prev);
        }
        return max;
    }

    public int findMaxConsecutiveOnes_k_followUp(int[] nums) {
        int max = 0, k = 1;
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (int l=0, h=0; h<nums.length; h++) {
            if (nums[h] == 0) {
                zeroIndex.offer(h);
            }
            if (zeroIndex.size() > k) {
                l = zeroIndex.poll()+1;
            }
            max = Math.max(max, h-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(nums));
    }
}
