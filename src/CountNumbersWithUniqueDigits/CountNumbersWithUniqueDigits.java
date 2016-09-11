package CountNumbersWithUniqueDigits;

/**
 * 357. Count Numbers with Unique Digits
 *
 * Given a non-negative integer n,
 * count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 * Given n = 2, return 91.
 * (The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;

        while( availableNumber > 0 && n-- > 1) {
            uniqueDigits = uniqueDigits*availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }

        return res;
    }
}
