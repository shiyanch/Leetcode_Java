package MajorityElement;

/**
 * 169. Majority Element
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class MajorityElement {

    // Moore's Voting Algorithm
    public int majorityElement(int[] nums) {
        int majority=0;
        int count = 0;

        for(int i=0;i<nums.length;i++) {
            if(count == 0) {
                majority = nums[i];
                count++;
            }
            else if(majority == nums[i])
                count++;
            else
                count--;
        }

        return majority;
    }

    // Time Limit Exceeded
    public int anotherSolution(int[] nums) {
        int out,in,min;

        for(out=0;out<nums.length-1;out++) {
            min = out;

            for (in=out+1;in<nums.length;in++) {
                if(nums[in] < nums[min])
                    min = in;
            }
            int temp = nums[min];
            nums[min] = nums[out];
            nums[out] = temp;
        }

        return nums[(nums.length-1)/2];
    }
}
