package ArrayNesting;

/**
 * 565. Array Nesting
 *
 * A zero-indexed array A consisting of N different integers is given.
 * The array contains all integers in the range [0, N - 1].
 *
 * Sets S[K] for 0 <= K < N are defined as follows:
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
 *
 * Sets S[K] are finite for each K and should NOT contain duplicates.
 * Write a function that given an array A consisting of N integers,
 * return the size of the largest set S[K] for this array.
 */
public class ArrayNesting {
    // 60ms
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            int count = 1;
            int cur = i;
            while (nums[cur] != i) {
                visited[cur] = true;
                cur = nums[cur];
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    // 49ms
    public int arrayNesting2(int[] nums) {
        int res = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] < 0) continue;
            int length = 1, val = nums[i];
            while (Math.abs(val) != i) {
                length++;
                val = nums[Math.abs(val)];
                nums[Math.abs(val)] *= -1;
            }
            res = Math.max(res, length);
        }
        return res;
    }
}
