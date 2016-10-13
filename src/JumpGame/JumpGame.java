package JumpGame;

/**
 * 55. Jump Game
 *
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = 0;
        for(int i=0;i<nums.length;i++) {
            if(i > len)
                return false;
            len = Math.max(len, i+nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        new JumpGame().canJump(new int[] {1,1,1,1,0,0,1});
    }
}
