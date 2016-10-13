package JumpGameII;

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int step = 0;
        int fareast = 0;
        int max = 0;

        for(int i=0;i<nums.length-1;i++) {
            max = Math.max(max, nums[i]+i);
            if(i == fareast) {
                fareast = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[] {2,3,1,1,4}));
    }
}
