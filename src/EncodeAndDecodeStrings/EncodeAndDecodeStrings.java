package EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * 271. Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network
 * and is decoded back to the original list of strings.
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(' ').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int len = 0;
        for (int i=0; i<s.length(); i++) {
            char tc = s.charAt(i);
            if (tc != ' ') {
                len *= 10;
                len += tc-'0';
            }
            else {
                strs.add(s.substring(i+1, i+1+len));
                i += len;
                len = 0;
            }
        }
        return strs;
    }
}
