package SortColors;

/**
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue
 * sort them so that objects of the same color are adjacent
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int nElems = nums.length;
        int in,out;

        for(out=1;out<nElems;out++) {
            int temp = nums[out];
            in = out;

            while (in > 0 && nums[in-1]>=temp) {
                nums[in] = nums[in-1];
                --in;

            }
            nums[in] = temp;
        }
    }

    public void sortColors2(int[] nums) {
        int zero = 0, second = nums.length-1;

        // while保证swap之后换到nums[i]的元素值不能是0或2
        for(int i=0; i<=second; i++) {
            while(nums[i]==2 && i<second)
                swap(nums, i, second--);
            while(nums[i]==0 && i>zero)
                swap(nums, i, zero++);
        }

        for(int i:nums)
            System.out.print(i+" ");
    }

    private void swap(int[] nums, int index1, int index2 ) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
