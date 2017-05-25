package ShortestUnsortedContinuousSubarray;

/**
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array, you need to find one continuous subarray
 * that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        Integer left_min = null;
        Integer right_max = null;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                left_min = (left_min == null ? nums[i] : Math.min(left_min, nums[i]));
            }

            if (nums[nums.length-i] < nums[nums.length-i-1]) {
                right_max = (right_max == null? nums[nums.length-i-1] : Math.max(right_max, nums[nums.length-i-1]));
            }
        }

        if (left_min == null || right_max == null) {
            return 0;
        }

        int left = 0, right = nums.length-1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > left_min) {
                left = i;
                break;
            }
        }

        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] < right_max) {
                right = i;
                break;
            }
        }

        return right-left+1;
    }
}
