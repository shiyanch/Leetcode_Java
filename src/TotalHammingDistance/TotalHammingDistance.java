package TotalHammingDistance;

/**
 * 477. Total Hamming Distance
 *
 * The Hamming distance between two integers is
 * the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 */
public class TotalHammingDistance {

    // O(n) time, O(1) space
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }

    // O(n) time, O(32) space
    public int totalHammingDistance_2(int[] nums) {
        // 统计每一位上1和0的个数
        // 这一位的total distance是从1里挑一个乘以0里挑一个
        // 对32位进行计算再求和 就是结果
        int[] ones = new int[31];

        for (int j=0; j<nums.length; j++) {
            int n = nums[j];
            for (int i=0; i<31; i++) {
                ones[i] += n&1;
                n >>>= 1;
            }
        }

        int sum = 0;
        for (int i=0; i<31; i++) {
            sum += (nums.length - ones[i]) * ones[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(new TotalHammingDistance().totalHammingDistance(nums));
    }
}
