package SearchForARange;

/**
 * 34. Search for a Range
 *
 * Given a sorted array of integers,
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = binary_yl_nr(target, nums);
        range[1] = binary_yr_nl(target, nums);

        if(range[0] > nums.length-1 || range[1] < 0 || nums[range[0]] != target || nums[range[1]] != target)
            return new int[] {-1,-1};

        return range;
    }

    private int binary_yl_nr(int key, int[] a) {
        int mid, left=0, right=a.length-1;
        while(left <= right) {
            mid = (left+right) >>> 1;
            if(a[mid]>=key)
                right = mid-1;
            else
                left = mid+1;
        }

        return left;
    }

    private int binary_yr_nl(int key, int[] a) {
        int mid, left=0, right=a.length-1;
        while (left <= right) {
            mid = (left+right) >>> 1;
            if(a[mid]>key)
                right = mid-1;
            else
                left = mid+1;
        }

        return right;
    }

    public static void main(String[] args) {
        new SearchForARange().searchRange(new int[] {2,2}, 3);
    }
}
