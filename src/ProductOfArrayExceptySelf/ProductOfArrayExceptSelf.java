package ProductOfArrayExceptySelf;

/**
 * 238. Product of Array Except Self
 * Given an array of n integers where n > 1, nums
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */


public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] output = new int[size];
        int zeroCount = 0;

        int product = 1;
        for(int i=0; i<size; i++) {
            if(nums[i] == 0) {
                output[i] = -1;
                zeroCount++;
                continue;
            }
            product *= nums[i];

        }

        if(zeroCount == 1) {
            for(int i=0; i<size; i++) {
                if(output[i] == -1)
                    output[i] = product;
            }
        }
        else if(zeroCount > 1) {
            return new int[size];
        }
        else {
            for(int i=0; i<size; i++) {
                output[i] = product/nums[i];
            }
        }

        return output;
    }

    public int[] productExceptSelf2(int[] nums) {
        int size = nums.length;
        int[] output = new int[size];
        for(int i=0; i<size; i++) {output[i] = 1;}

        int left = 1, right = 1;

        for(int i=0,j=size-1; i<size-1; i++,j--) {
            left *= nums[i];
            output[i+1] *= left;
            right *= nums[j];
            output[j-1] *= right;
        }

        return output;
    }
}
