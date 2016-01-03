package MoveZeroes;

/**
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        /*
        case 0: [0,1,0,3,12]
        result: [1,3,12,0,0]

        case 1: [0]
        result: [0]

        case 2: [1,2,3]
        result: [1,2,3]

        case 3: [0,1,3]
        result: [1,3,0]

        case 4: [0,1,0,3]
        result: [1,3,0,0]

        case 5: [0,1,0,3,0]
        result: [1,3,0,0,0]

        case 6: [0,0,1]
        result: [1,0,0]
         */


        int index = 0;
        int length = nums.length;

        for(int i=0;i<length;i++) {
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }

        for(int i=index;i<length;i++)
            nums[i] = 0;
    }

    public void anotherSolution(int[] nums) {
        int in=0;
        int out=nums.length-1;

        while(in < out) {
            while(nums[in] == 0) {
                for(int i=in;i<out;i++)
                    nums[i] = nums[i+1];

                nums[out] = 0;
                if(out>in)
                    out--;
                else
                    break;
            }
            in++;
        }

        for(int num:nums){
            System.out.print(" "+num);
        }
    }
}
