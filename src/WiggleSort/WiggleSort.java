package WiggleSort;

/**
 * 280. Wiggle Sort
 *
 * Given an unsorted array nums,
 * reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * For example, given nums = [3, 5, 2, 1, 6, 4],
 * one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        boolean ascending = true;
        for (int i=0; i<nums.length-1; i++) {
            if ((ascending && nums[i] > nums[i+1]) || (!ascending && nums[i] < nums[i+1])) {
                swap(nums, i, i+1);
            }
            ascending = !ascending;
        }
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] += nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] -= nums[b];
    }
}
