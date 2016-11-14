package ReverseWordsInAString;

/**
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();

        for(int i=strs.length-1;i>=0;i--) {
            sb.append(strs[i]+" ");
        }
        return sb.toString().trim();
    }
}
