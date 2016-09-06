package Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Given a collection of distinct numbers,
 * return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return ans;

        List<Integer> init = new ArrayList<Integer>();
        init.add(nums[0]);
        ans.add(init);

        for(int i=1;i<nums.length;++i) {
            List<List<Integer>> new_ans = new ArrayList<>();
            for(int j=0;j<=i;++j) {
                for(List<Integer> list : ans) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(j, nums[i]);
                    new_ans.add(temp);
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}
