package PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) return ans;

        List<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        ans.add(init);
        Set<List<Integer>> set = new HashSet<>();

        for(int i=1;i<nums.length;i++) {
            List<List<Integer>> new_ans = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                for(List<Integer> list:ans) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(j,nums[i]);
                    if(!set.contains(temp)) {
                        new_ans.add(temp);
                        set.add(temp);
                    }
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}
