package RemoveDuplicatesFromSortedArrayII;

/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int l=0,r=nums.length-1;
        int count=0;

        for(l=2;l<=r;l++) {
            while (nums[l]==nums[l-1] && nums[l-1]==nums[l-2] && l<=r) {
                for(int i=l;i<r;i++) {
                    nums[i] = nums[i+1];
                }
                r--;
                count++;
            }
        }
        return nums.length-count;
    }
}
