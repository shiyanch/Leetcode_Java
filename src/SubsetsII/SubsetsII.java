package SubsetsII;

import java.util.*;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates,
 * nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = (int) Math.pow(2, nums.length);

        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            int count = 0;
            int temp = i;
            while(temp>0) {
                if(temp%2 == 1)
                    list.add(nums[count]);
                temp /= 2;
                count++;
            }
            Collections.sort(list);
            if(!res.contains(list))
                res.add(list);
        }

        return res;
    }

    public List<List<Integer>> subsetsWithDup_iterative(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for (int i=0; i<nums.length; i++) {
            int size = result.size();
            for (int j=0; j<size; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                if (!set.contains(newList)) {
                    result.add(newList);
                    set.add(newList);
                }
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup_backtracking(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void backtracking(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curr, int[] nums, int index) {
        result.add(new ArrayList<Integer>(curr));
        System.out.println(index+" "+curr);

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1])
                continue;
            curr.add(nums[i]);
            backtracking(result, curr, nums,i+1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2};
        System.out.println(new SubsetsII().subsetsWithDup_backtracking(nums));
    }
}
