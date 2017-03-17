package ReverseStringII;

/**
 * 541. Reverse String II
 *
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string.
 *
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int index = 0;
        while (index < s.length()) {
            int right = Math.min(index+k, s.length())-1;
            int left = index;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            index += 2*k;
        }
        return new String(arr);
    }
}
