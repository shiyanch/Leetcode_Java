package GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * 320. Generalized Abbreviation
 *
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d",
 * "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        //backtracking(result, "", 0, word);
        backtrack(result, word, 0, "", 0);
        return result;
    }

    // optimized
    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos+1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }

    // original solution
    private void backtracking(List<String> result, String curr, int start, String word) {
        if (start == word.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<curr.length();i++) {
                int count = 0;
                while (i<curr.length() && curr.charAt(i) == '1') {
                    count++;
                    i++;
                }
                if (count != 0) {
                    sb.append(count);
                }
                if (i < curr.length()) {
                    sb.append(curr.charAt(i));
                }
            }
            result.add(sb.toString());
            return;
        }

        backtracking(result, curr+"1", start+1, word);
        backtracking(result, curr+word.charAt(start), start+1, word);
    }

    public static void main(String[] args) {
        System.out.println(new GeneralizedAbbreviation().generateAbbreviations("word"));
    }
}
