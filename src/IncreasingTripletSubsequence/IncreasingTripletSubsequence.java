package IncreasingTripletSubsequence;

/**
 * 334. Increasing Triplet Subsequence
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 */
public class IncreasingTripletSubsequence {

    // 1 ms
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n<=small) {
                small = n;
            }
            else if(n <= big) {
                big = n;
            }
            else {
                return true;
            }
        }

        return false;
    }

    // 105 ms
    public boolean increasingTriplet_Min(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        int[] counts = new int[nums.length];
        int[] min = new int[nums.length];

        min[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > min[i-1]) {
                counts[i] = 1;
            }

            min[i] = Math.min(nums[i], min[i-1]);
        }

        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && counts[j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,2,2};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }
}
