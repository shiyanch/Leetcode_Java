package MaximumProductSubarray;

/**
 * 152. Maximum Product Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int positive = 0;
        int negative = 0;

        if(nums[0] > 0) {
            positive = nums[0];
        }
        else {
            negative = nums[0];
        }

        int max = positive;
        for(int i=1;i<nums.length;i++) {
            int lastPos = positive;
            int lastNeg = negative;

            if(nums[i] == 0) {
                positive = negative = 0;
            }
            else if(nums[i] > 0) {
                positive = (positive == 0)?nums[i]:lastPos*nums[i];
                negative = (negative == 0)?0:lastNeg*nums[i];
            }
            else {
                positive = (negative == 0)?0:lastNeg*nums[i];
                negative = (positive == 0)?nums[i]:lastPos*nums[i];
            }

            if(positive > max)
                max = positive;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[] {2,-5,-2,-4,3}));
    }
}
