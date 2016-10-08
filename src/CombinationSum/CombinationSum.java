package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null)
            return res;

        Arrays.sort(candidates);
        List<Integer> dummy = new ArrayList<>();
        dfs(res, dummy, candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> result, List<Integer> dummy, int[] candidates, int i, int target) {
        if(target > 0) {
            for(int j=i;j<candidates.length && candidates[j] <= target;j++) {
                dummy.add(candidates[j]);
                dfs(result, dummy, candidates, j, target-candidates[j]);
                dummy.remove(dummy.size() - 1); // 对于错误的情况，把最后一步撤销
            }

        }
        if(target == 0) {
            result.add(new ArrayList<Integer>(dummy));
        }
    }
}
