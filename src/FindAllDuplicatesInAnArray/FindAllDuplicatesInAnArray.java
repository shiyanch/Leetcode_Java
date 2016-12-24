package FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index-1] > 0) {
                nums[index-1] = -nums[index-1];
            }
            else {
                list.add(index);
            }
        }

        return list;
    }
}
