package MajorityElementII;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 *
 * Given an integer array of size n,
 * find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>(2);

        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 1;

        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }
            else if(num == candidate2) {
                count2++;
            }
            else if(count1 == 0) {
                candidate1 = num;
                count1++;
            }
            else if(count2 == 0) {
                candidate2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }

            if(num == candidate2) {
                count2++;
            }
        }

        if(count1 > nums.length/3) {
            list.add(candidate1);
        }

        if(count2 > nums.length/3) {
            list.add(candidate2);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,5,6};
        System.out.println(new MajorityElementII().majorityElement(nums).toString());
    }

}
