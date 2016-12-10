package LargestRectangleInHistogram;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i=0; i<heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        int lastIndex = stack.peek();
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (lastIndex - stack.peek()));
        }
        return maxArea;
    }
}
