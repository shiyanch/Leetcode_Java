package SearchInRotatedSortedArrayII;

/**
 * 81. Search in Rotated Sorted Array II
 *
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while (low < high) {
            int mid = (low+high) >>> 1;
            if(nums[mid] == target)
                return true;

            while (nums[mid] == nums[low] && low < mid)
                low++;
            while (nums[mid] == nums[high] && mid < high)
                high--;

            if(nums[mid] >= nums[low]) {
                if(nums[mid] < target || (nums[high] >= target && nums[low] > target)) {
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
            else {
                if(nums[mid] > target || (nums[high] < target)) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
        }

        return (nums[low] == target);
    }
}
