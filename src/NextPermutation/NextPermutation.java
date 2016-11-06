package NextPermutation;

import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * Implement next permutation,
 * which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible,
 * it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples.
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int index = 0;
        for(int i=nums.length-1;i>=1;i--) {
            if(nums[i] > nums[i-1]) {
                index = i;
                break;
            }
        }

        if(index != 0) {
            index--;
            for (int j = nums.length - 1; j > index; j--) {
                if (nums[j] > nums[index]) {
                    int temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            index++;
        }

        // reverse nums of range [i+1, nums.length-1]
        reverse(nums, index);

    }

    private void reverse(int[] a,int i){
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,4,2,6,8,3,4,7};
        int[] nums = {3,2,1};
        new NextPermutation().nextPermutation(nums);
        for(int n:nums) {
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
