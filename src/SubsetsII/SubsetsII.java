package SubsetsII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates,
 * nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = (int) Math.pow(2, nums.length);

        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            int count = 0;
            int temp = i;
            while(temp>0) {
                if(temp%2 == 1)
                    list.add(nums[count]);
                temp /= 2;
                count++;
            }
            Collections.sort(list);
            if(!res.contains(list))
                res.add(list);
        }

        return res;
    }
}
