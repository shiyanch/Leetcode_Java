package SearchInRotatedSortedArray;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search.
 * If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while (low < high) {
            int mid = (low+high) >>> 1;
            if(nums[mid] == target)
                return mid;

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

        return (nums[low] == target)?low:-1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[] {1,3,5}, 1));
    }
}
