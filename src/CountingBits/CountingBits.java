package CountingBits;

/**
 * 338. Counting Bits
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 *
 * Follow up:
 * - It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * - But can you do it in linear time O(n) /possibly in a single pass?
 * - Space complexity should be O(n).
 * - Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * Hint:
 * 1. You should make use of what you have produced already.
 * 2. Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on.
 * 3. And try to generate new range from previous.
 * 4. Or does the odd/even status of the number help you in calculating the number of 1s?
 *
 * 0:      0
 * 1:     01
 * 2:     10
 * 3:     11
 *
 * 4:    100 (0的二进制前面加10)
 * 5:    101 (1的二进制前面加1)
 * 6:    110 (2的二进制前面加1)
 * 7:    111 (13的二进制前面加1)
 *
 * 8:   1000 (0的二进制前面加100)
 * 9:   1001 (1的二进制前面加10)
 * 10:  1010 (2的二进制前面加10)
 * 11:  1011 (3的二进制前面加10)
 * 12:  1100 (4的二进制前面加10)
 * 13:  1101 (5的二进制前面加10)
 * 14:  1110 (6的二进制前面加10)
 * 15:  1111 (7的二进制前面加10)
 * 16: 10000 (8的二进制前面加10)
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];

        if(num == 0)
            return res;

        res[1] = 1;
        int mod = 1;

        for( int i=2; i<=num; i++) {
            if(i == 2*mod) {
                mod *= 2;
                res[i] = 1;
            }
            else {
                res[i] = res[mod] + res[i-mod];
            }
        }

        return res;
    }
}
