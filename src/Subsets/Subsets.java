package Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 **/

// 思路：3个元素则会产生8个子集，即2^3
// 考虑从0~8的二进制表示，第n位上的1表示元素组的第n个元素会出现在当前子集中
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
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
            res.add(list);
        }

        return res;
    }
}
