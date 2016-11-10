package Combinations;

import java.util.ArrayList;
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
        backtracking(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> currList, int index, int n, int k) {
        if(currList.size() == k) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }

        // bad code, consume much time!
//        for(int i=index;i<=n;i++) {
//            List<Integer> copy = new ArrayList<>(currList);
//            copy.add(i);
//            backtracking(result, copy, i+1, n, k);
//        }

        for(int i=index;i<=n;i++) {
            currList.add(i);
            backtracking(result, currList, i+1, n, k);
            currList.remove(currList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = (new Combinations()).combine(4,2);
        System.out.println(result.toString());
    }
}
