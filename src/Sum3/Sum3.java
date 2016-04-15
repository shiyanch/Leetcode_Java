package Sum3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum
 * Given an array S of n integers
 * are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();

        for(int i=0;i<nums.length-2;i++) {
            if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
                int low = i+1;
                int high = nums.length-1;
                int sum = 0-nums[i];

                // 使用双pointers将N^2降为N(前提是不能重复)
                while(low < high) {
                    if(nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < sum)
                        low++;
                    else
                        high--;
                }
            }
        }
        return res;
    }
}
