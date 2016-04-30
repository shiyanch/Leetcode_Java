package PalindromeNumber;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome.
 * Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int newNum = 0;

        while(x > 0) {
            newNum = newNum * 10 + x%10;
            x %= 10;
        }

        return newNum == x;
    }
}
