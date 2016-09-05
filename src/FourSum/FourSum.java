package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:[
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        if(nums.length < 4 || nums[0]*4 > target || nums[nums.length-1]*4 < target )
            return res;


        for(int outer = 0;outer<nums.length-3;outer++) {
            if(outer>0 && nums[outer-1] == nums[outer])
                continue;

            for (int inner = outer + 1; inner < nums.length - 2; inner++) {
                if(inner>outer+1 && nums[inner-1] == nums[inner])
                    continue;

                int low = inner+1, high = nums.length-1;

                while(low < high) {
                    int sum = nums[outer] + nums[inner] + nums[low] + nums[high];
                    if( sum == target) {
                        res.add(Arrays.asList(nums[outer], nums[inner], nums[low], nums[high]));
                        while(low < high && nums[low]==nums[low+1])
                            low++;

                        while(low < high && nums[high]==nums[high-1])
                            high--;

                        low++;
                        high--;
                    }
                    else if(sum < target)
                        low++;
                    else
                        high--;
                }
            }
        }

        return res;
    }
}
