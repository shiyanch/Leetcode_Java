package Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
//        backtracking(result, new ArrayList<Integer>(), 1, n, k);
        backtracking_bad(result, new ArrayList<>(), n, k, 1);
        return result;

    }

    private void backtracking(List<List<Integer>> result, List<Integer> currList, int index, int n, int k) {
        if(currList.size() == k) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }

        for(int i=index;i<=n;i++) {
            currList.add(i);
            backtracking(result, currList, i+1, n, k);
            currList.remove(currList.size()-1);
        }
    }

    private void backtracking_bad(List<List<Integer>> res, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }

        if (index > n) {
            return;
        }

        list.add(index);
        backtracking_bad(res, list, n, k, index + 1);

        list.remove(list.size() - 1);
        backtracking_bad(res, list, n, k, index + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = (new Combinations()).combine(4,2);
        System.out.println(result.toString());
    }
}
