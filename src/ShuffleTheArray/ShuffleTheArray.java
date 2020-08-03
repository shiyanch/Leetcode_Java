package ShuffleTheArray;

/**
 * 1470. Shuffle the Array
 *
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[2*i] = nums[i];
            res[2*i+1] = nums[n + i];
        }
        return res;
    }
}
