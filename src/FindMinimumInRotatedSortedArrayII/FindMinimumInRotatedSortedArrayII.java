package FindMinimumInRotatedSortedArrayII;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Duplicates are allowed.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while(low < high) {
            mid = (low + high) >>> 1;
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];

            while (nums[mid] == nums[low] && low < mid)
                low++;
            while (nums[mid] == nums[high] && mid < high)
                high--;

            if(nums[mid] >= nums[low] && nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid-1;
        }

        return nums[low];
    }

    public static void main(String[] args) {
//        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[] {1,1,1,1,2,3}));
//        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[] {2,3,1,1,1,1}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[] {2,2,2,1,1,1}));
    }
}
