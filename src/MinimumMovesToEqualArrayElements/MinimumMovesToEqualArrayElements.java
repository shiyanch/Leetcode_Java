package MinimumMovesToEqualArrayElements;

/**
 * 453. Minimum Moves to Equal Array Elements
 *
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            sum+=nums[i];
        }

        return sum - nums.length*min;
    }
}
