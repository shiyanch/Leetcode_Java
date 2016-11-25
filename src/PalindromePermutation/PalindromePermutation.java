package PalindromePermutation;

/**
 * 266. Palindrome Permutation
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] dict = new int[256];
        for (char c : s.toCharArray()) {
            dict[c]++;
        }

        boolean foundOdd = false;
        for (int i : dict) {
            if (i % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                else {
                    foundOdd = true;
                }
            }
        }
        return true;
    }
}
