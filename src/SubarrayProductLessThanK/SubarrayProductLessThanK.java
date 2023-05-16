package SubarrayProductLessThanK;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        long[] products = new long[nums.length];
        products[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i];
        }
        for (long num : products) {
            System.out.print(num);
            System.out.print(" ");
        }

        for (int i = 0; i < products.length; i++) {
            if (products[i] < k) {
                sum += i + 1;
            } else {
                int j = 0;
                while (j < i && products[i] / products[j] >= k) {
                    j++;
                }
                if (i != j) {
                    sum += i - j;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;

        System.out.println("\n" + new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
    }
}
