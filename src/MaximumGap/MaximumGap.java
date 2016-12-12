package MaximumGap;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 *
 * Given an unsorted array,
 * find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers
 * and fit in the 32-bit signed integer range.
 */

// The maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].
//
// We divide all numbers in the array into n-1 buckets,
// where k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap).
//
// Since there are n-2 numbers that are not equal min or max and there are n-1 buckets,
// at least one of the buckets are empty.
// We only need to store the largest number and the smallest number in each bucket.
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int maxEle = nums[0];
        int minEle = nums[0];
        for (int num : nums) {
            maxEle = Math.max(maxEle, num);
            minEle = Math.min(minEle, num);
        }

        int gap = (int) Math.ceil((double) (maxEle-minEle)/(nums.length-1));
        int[] bucketsMin = new int[nums.length-1];
        int[] bucketsMax = new int[nums.length-1];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);

        for (int num : nums) {
            if (num == maxEle || num == minEle) {
                continue;
            }

            int index = (num - minEle)/gap;
            bucketsMax[index] = Math.max(bucketsMax[index], num);
            bucketsMin[index] = Math.min(bucketsMin[index], num);
        }

        int maxGap = 0;
        int prev = minEle;

        for (int i=0; i<nums.length-1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                continue;
            }

            maxGap = Math.max(maxGap, bucketsMin[i] - prev);
            prev = bucketsMax[i];
        }

        return Math.max(maxGap, maxEle - prev);
    }
}
