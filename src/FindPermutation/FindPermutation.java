package FindPermutation;

/**
 * 484. Find Permutation
 *
 * By now, you are given a secret signature consisting of character 'D' and 'I'.
 * 'D' represents a decreasing relationship between two numbers,
 * 'I' represents an increasing relationship between two numbers.
 *
 * And our secret signature was constructed by a special integer array,
 * which contains uniquely all the different number from 1 to n
 * (n is the length of the secret signature plus 1).
 *
 * For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2],
 * but won't be constructed by array [3,2,4] or [2,1,3,4],
 * which are both illegal constructing special string that can't represent the "DI" secret signature.
 *
 * On the other hand, now your job is to find the lexicographically smallest permutation
 * of [1, 2, ... n] could refer to the given secret signature in the input.
 */
public class FindPermutation {
    // For each k continuous D starting at index i
    // we need to reverse [i, i+k] portion of the sorted sequence.
    public int[] findPermutation(String s) {
        int n = s.length(), arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) arr[i] = i + 1; // sorted
        for (int h = 0; h < n; h++) {
            if (s.charAt(h) == 'D') {
                int l = h;
                while (h < n && s.charAt(h) == 'D') h++;
                reverse(arr, l, h);
            }
        }
        return arr;
    }

    void reverse(int[] arr, int l, int h) {
        while (l < h) {
            arr[l] ^= arr[h];
            arr[h] ^= arr[l];
            arr[l] ^= arr[h];
            l++; h--;
        }
    }
}
