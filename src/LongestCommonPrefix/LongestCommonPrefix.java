package LongestCommonPrefix;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    // 4ms
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer("");

        if(strs == null || strs.length == 0)
            return sb.toString();

        int index = 0;

        while (true) {
            if(strs[0] == null || strs[0].equals("") || index == strs[0].length())
                return sb.toString();

            char common = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || strs[i] == null || strs[i].equals(""))
                    return sb.toString();

                if (strs[i].charAt(index) != common)
                    return sb.toString();
            }

            index++;
            sb.append(common);
        }
    }

    // 1ms
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        String pre = strs[0];
        int i=1;

        while(i < strs.length) {
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length()-1);
            i++;
        }

        return pre;

    }
}
