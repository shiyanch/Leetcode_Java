package FindMinimumInRotatedSortedArray;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while(low < high) {
            mid = (low + high) >> 1;
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            if(nums[mid] >= nums[low] && nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid-1;
        }

        return nums[low];
    }
}
