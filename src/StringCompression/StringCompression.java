package StringCompression;

/**
 * 443. String Compression
 *
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 */
public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        int count = 1;
        int prev = 0;
        for (int i=1; i<chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                count++;
            } else {
                if (count > 1) {
                    String sb = count+"";
                    for (char c : sb.toCharArray()) {
                        chars[++prev] = c;
                    }
                }
                chars[++prev] = chars[i];
                count = 1;
            }
        }

        if (count > 1) {
            String sb = count+"";
            for (char c : sb.toCharArray()) {
                chars[++prev] = c;
            }
        }

        return prev+1;
    }
}
