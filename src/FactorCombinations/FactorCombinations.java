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
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), 2, n);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> currList, int start, int number) {
        int upperBound = Integer.MAX_VALUE;
        for (int i=start; i<number && i<upperBound; i++) {
            // 注意下界，每次除法结果不能低于下界，否则这样的组合之前已经生成过了
            if (number % i == 0 && number/i >= start) {
                currList.add(i);
                currList.add(number/i);
                list.add(new ArrayList<>(currList)); // 当前除得尽，是一对因子，保存进结果
                currList.remove(currList.size()-1);

                upperBound = number / i;
                backtracking(list, currList, i, number/i); // 当前i是一个因子，继续递归后续因子
                currList.remove(currList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FactorCombinations().getFactors(37));
        System.out.println(new FactorCombinations().getFactors(12));
        System.out.println(new FactorCombinations().getFactors(32));


    }
}
