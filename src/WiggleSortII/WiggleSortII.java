package WiggleSortII;

/**
 * 324. Wiggle Sort II
 *
 * Given an unsorted array nums,
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n+1)/2);
        int left=0, i=0, right=n-1;

        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        int p = quickSelect(a, 0, n - 1, n - k + 1);
        return a[p];
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    private int quickSelect(int[] a, int low, int high, int k) {
        int i = low, j = high, pivot = a[high];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, high);
        int m = i - low + 1;

        if (m == k) {
            return i;
        }
        else if (m > k) {
            return quickSelect(a, low, i - 1, k);
        }
        else {
            return quickSelect(a, i + 1, high, k - m);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
