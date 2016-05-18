package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 *
 * Given an array nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * Follow up:
 * Could you solve it in linear time?
 *
 * Hint:
 * How about using a data structure such as deque (double-ended queue)?
 * The queue size need not be the same as the window’s size.
 * Remove redundant elements and the queue should store only elements that need to be considered.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int[0];

        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        int maxIndex = -1;

        for(int i=0;i<k;i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        res[0] = max;

        for(int i=1;i<nums.length-k+1;i++) {
            if(max < nums[i+k-1]) {
                max = nums[i+k-1];
                maxIndex = i+k-1;
            }

            if(maxIndex < i) { // need to update max and maxIndex
                max = Integer.MIN_VALUE;
                for(int j=0;j<k;j++) {
                    if(max < nums[i+j]) {
                        max = nums[i+j];
                        maxIndex = i+j;
                    }
                }
            }

            res[i] = max;
        }
        return res;
    }

    // solution from : https://leetcode.com/discuss/46578/java-o-n-solution-using-deque-with-explanation
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || k<=0)
            return new int[0];

        int len = nums.length;
        int[] res = new int[len-k+1];
        int ri = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<len;i++) {
            while(!queue.isEmpty() && queue.peek()<i-k+1)
                queue.poll();

            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            if(i>=k-1) {
                res[ri++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
