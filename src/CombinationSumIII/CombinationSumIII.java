package CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used
 * and each combination should be a unique set of numbers.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<10;i++) {
            dfs_helper(k, n, i, res, new ArrayList<>());
        }
        return res;
    }

    private void dfs_helper(int k, int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (k < 0) {
            return;
        }
        if (k == 0 && n == 0)
            res.add(new ArrayList<Integer>(list));

        for (int i = start; i < Math.min(10, n + 1); i++) {
            list.add(start);
            dfs_helper(k-1, n - start, i+1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
