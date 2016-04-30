package ReverseVowelsOfAString;

/**
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int low = 0;
        int high = s.length()-1;

        char[] array = s.toCharArray();

        while(low < high) {
            if(!isVowel(array[low])) {
                low++;
                continue;
            }
            if (!isVowel(array[high])) {
                high--;
                continue;
            }

            char temp = array[low];
            array[low] = array[high];
            array[high] = temp;

            low++;
            high--;

        }
        return new String(array);
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e'
                || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I'
                || c == 'O' || c == 'U');
    }
}
