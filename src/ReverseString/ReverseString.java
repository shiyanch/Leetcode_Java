package ReverseString;

/**
 * 344. Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        int head = 0, tail = s.length()-1;
        char[] ans = s.toCharArray();

        while(head < tail) {
            char item = ans[head];
            ans[head] = ans[tail];
            ans[tail] = item;

            head++;
            tail--;
        }

        System.out.println(new String(ans));
        return s;
    }

    public String reverseString2(String s) {
        int length = s.length();
        if(length <= 1)
            return s;

        String leftStr = s.substring(0, length/2);
        String rightStr = s.substring(length/2, length);
        return reverseString2(rightStr) + reverseString2(leftStr);
    }
}
