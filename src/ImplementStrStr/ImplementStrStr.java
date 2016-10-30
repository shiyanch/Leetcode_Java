package ImplementStrStr;

/**
 * 28. Implement strStr()
 *
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null)
            return -1;
        if(haystack.equals(needle) || needle.length() == 0)
            return 0;

        for(int i=0;i<=haystack.length()-needle.length();i++) {
            int j;
            for(j=0;j<needle.length();j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                else if(j == needle.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("", ""));
    }
}
