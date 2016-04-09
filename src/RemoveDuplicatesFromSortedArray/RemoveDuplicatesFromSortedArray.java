package RemoveDuplicatesFromSortedArray;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array
 * you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the new length.
 *
 * Testcases:
 * {1}
 * {1,1,2}
 * {1,2,2}
 * {1,1,2,3,3,4,4,5,6,7,7}
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l=1,r=nums.length-1;
        int count=0;

        for(;l<=r;l++) {
            while(nums[l] == nums[l-1] && l <=r) {
                for(int i=l;i<r;i++)
                    nums[i] = nums[i+1];
                r--;
                count++;
            }
        }
        return nums.length-count;
    }
}
