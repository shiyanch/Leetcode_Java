package PermutationsII;

import java.util.*;

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
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(result, new ArrayList<Integer>(), nums, visited);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> currList, int[] nums, boolean[] visited) {
        if (currList.size() == nums.length) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                    continue;
                }
                visited[i] = true;
                currList.add(nums[i]);
                backtracking(result, currList, nums, visited);
                currList.remove(currList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique_iterative(int[] nums) {
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

    public static void main(String[] args) {
        int[] num = {1,1,2};
        System.out.println(new PermutationsII().permuteUnique(num));
    }
}
