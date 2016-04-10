package RotateArray;

/**
 * 189. Rotate Array
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3,
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {

        int length = nums.length;
        if(length == 0)
            return;

        int key = k%length;
        int[] result = new int[length];

        for(int i=0;i<key;i++) {
            result[i] = nums[length-key+i];
        }

        for(int i=key;i<length;i++)
            result[i] = nums[i-key];

        for(int i=0;i<length;i++)
            nums[i] = result[i];
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        if(length == 0)
            return;
        int key = k%length;

        reverse(nums,0,length-1);
        reverse(nums,0,key-1);
        reverse(nums,key,length-1);

        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
