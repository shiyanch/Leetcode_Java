package SortTransformedArray;

/**
 * 360. Sort Transformed Array
 *
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 *
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * */

/*
 * the problem seems to have many cases a>0, a=0,a<0, (when a=0, b>0, b<0).
 * However, they can be combined into just 2 cases: a>0 or a<0
 *
 * 1.a>0, two ends in original array are bigger than center if you learned middle school math before.
 * 2.a<0, center is bigger than two ends.
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int index = (a>=0)?n:0;
        int i=0, j=n-1;
        while (i <= j) {
            if (a >= 0) {
                result[index--] = equation(nums[i], a, b, c) >= equation(nums[j], a, b, c)?equation(nums[i++], a, b, c):equation(nums[j--], a, b, c);
            }
            else {
                result[index++] = equation(nums[i], a, b, c) >= equation(nums[j], a, b, c)?equation(nums[j--], a, b, c):equation(nums[i++], a, b, c);
            }
        }
        return result;
    }

    private static int equation(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
