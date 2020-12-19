package CircularArrayLoop;

/**
 * 457. Circular Array Loop
 *
 * You are given a circular array nums of positive and negative integers.
 * If a number k at an index is positive, then move forward k steps.
 * Conversely, if it's negative (-k), move backward k steps.
 * Since the array is circular, you may assume that the last element's next element is the first element,
 * and the first element's previous element is the last element.
 *
 * Determine if there is a loop (or a cycle) in nums.
 *
 * A cycle must start and end at the same index and the cycle's length > 1.
 * Furthermore, movements in a cycle must all follow a single direction.
 * In other words, a cycle must not consist of both forward and backward movements.
 *
 * Example 1:
 * Input: [2,-1,1,2,2]
 * Output: true
 *
 * Example 2:
 * Input: [-1,2]
 * Output: false
 *
 * Example 3:
 * Input: [-2,1,-1,-2,-2]
 * Output: false
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        // 0 for unvisited, 1 for visited in current run, 2 for visited in previour run.
        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0 && foundCircle(nums, i, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean foundCircle(int[] nums, int curr, int[] visited) {
        if (visited[curr] == 2) {
            return false;
        }
        if (visited[curr] == 1) {
            return true;
        }
        visited[curr] = 1;
        int nextIndex = nextIndex(curr, nums[curr], nums.length);
        if (nums[nextIndex] * nums[curr] < 0 || nextIndex == curr) {
            visited[curr] = 2;
            return false;
        }

        if (foundCircle(nums, nextIndex, visited)) {
            return true;
        }
        visited[curr] = 2;
        return false;
    }

    private int nextIndex(int curr, int steps, int length) {
        int nextIndex = (curr + steps) % length;
        return nextIndex < 0 ? nextIndex + length : nextIndex;
    }
}
