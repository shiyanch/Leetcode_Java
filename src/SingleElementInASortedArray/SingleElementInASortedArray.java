package SingleElementInASortedArray;

/**
 * 540. Single Element in a Sorted Array
 *
 * Given a sorted array consisting of only integers where every element appears twice
 * except for one element which appears once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, l = 0, r = n/2;
        while (l < r) {
            int m = (l+r)/2;
            if (nums[2*m] != nums[2*m+1]) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return nums[2*r];
    }
}
