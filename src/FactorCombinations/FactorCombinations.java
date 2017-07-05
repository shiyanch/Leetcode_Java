package FactorCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. Factor Combinations
 *
 * Numbers can be regarded as product of its factors.
 *
 * For example,
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 *
 * Write a function that takes an integer n
 * and return all possible combinations of its factors.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int start) {
        if (n <= 1) {
            if (list.size() > 1) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }

        for (int i=start; i<=n; i++) {
            if (n%i == 0) {
                list.add(i);
                dfs(result, list, n/i, i);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FactorCombinations().getFactors(37));
        System.out.println(new FactorCombinations().getFactors(12));
        System.out.println(new FactorCombinations().getFactors(8));
        System.out.println(new FactorCombinations().getFactors(32));
    }
}
