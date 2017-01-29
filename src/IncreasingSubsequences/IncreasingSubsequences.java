package IncreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Increasing Subsequences
 *
 * Given an integer array,
 * your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2 .
 *
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> unique = new HashSet<>();

        for (int i=index; i<nums.length; i++) {
            if ((index > 0 && nums[i] < nums[index-1]) || unique.contains(nums[i])) {
                continue;
            }

            unique.add(nums[i]);
            list.add(nums[i]);
            dfs(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        System.out.println(new IncreasingSubsequences().findSubsequences(nums));
    }
}
