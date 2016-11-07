package LongestRepeatingCharacterReplacement;

/**
 * 424. Longest Repeating Character Replacement
 *
 * Given a string that consists of only uppercase English letters,
 * you can replace any letter in the string with another letter at most k times.
 *
 * Find the length of a longest substring containing all repeating letters you can get
 * after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        char[] array = s.toCharArray();
        int[] count = new int[26];

        int start = 0, maxCount = 0, maxLen = 0;
        for(int end = 0;end<s.length();end++) {
            maxCount = Math.max(maxCount, ++count[array[end]-'A']);
            while (end - start + 1 - maxCount > k) {
                count[array[start]-'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABABBABBBA",4));
    }
}
