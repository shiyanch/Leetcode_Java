package MaximumProductOfWordLengths;

/**
 * 318. Maximum Product of Word Lengths
 *
 * Given a string array words,
 * find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters.
 *
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        int max = 0;

        for(int i=0;i<len;i++) {
            for(char c:words[i].toCharArray()) {
                mask[i] |= 1 << (c-'a');
            }
        }

        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                if((mask[i] & mask[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
