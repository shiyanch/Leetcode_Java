package RemoveElement;

/**
 * 27. Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * Testcases:
 * {3,2,2,3,4,5,6,7,3}, 3 -> 6
 * {1}, 1 -> 0
 * {1}, 0 -> 1
 * {4, 5}, 4 -> 1
 * {4, 5}, 5 -> 1
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int flag = length-1;

        int i;
        int count=0;
        for(i=0; i<=flag; i++) {
            while (nums[i] == val && flag>=i) {
                swap(nums, i, flag);
                flag--;
                count++;
            }
        }

        return length-i;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
