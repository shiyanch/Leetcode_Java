package ReverseWordsInAStringIII;

/**
 * 557. Reverse Words in a String III
 *
 * Given a string, you need to reverse the order of characters
 * in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        String[] strs = sb.reverse().toString().split(" ");
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.insert(0, str+" ");
        }
        return res.toString().substring(0, res.length()-1);
    }
}
