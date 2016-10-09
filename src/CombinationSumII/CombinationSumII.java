package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;

        Arrays.sort(candidates);
        dfs(new ArrayList<>(), res, candidates, target, 0);
        return res;
    }

    private void dfs(List<Integer> path, List<List<Integer>> res, int[] candidates, int target, int start) {
        if(target > 0) {
            for(int i=start; i<candidates.length && candidates[i]<=target;i++) {
                // 去除重复值
                if(i > start && candidates[i] == candidates[i-1])
                    continue;

                path.add(candidates[i]);
                dfs(path, res, candidates, target-candidates[i], i+1); // 不能重复，故i+1
                path.remove(path.size()-1);
            }
        }

        if(target == 0) {
            res.add(new ArrayList<Integer>(path));
        }
    }
}
