package NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 *
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 *
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 *
 * If it doesn't exist, output -1 for this number.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i=0; i<2*len; i++) {
            int index = i%len;
            while (!stack.isEmpty() && nums[stack.peek()%len] < nums[index]) {
                res[stack.pop()%len] = nums[index];
            }
            stack.push(index);
        }

        return res;
    }
}
