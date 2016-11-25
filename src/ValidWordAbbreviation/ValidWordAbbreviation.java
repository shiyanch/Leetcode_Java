package ValidWordAbbreviation;

import StringToInteger.StringToInteger;

/**
 * 408. Valid Word Abbreviation
 *
 * Given a non-empty string s and an abbreviation abbr,
 * return whether the string matches with the given abbreviation.
 *
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
 * "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * Notice that only the above abbreviations are valid abbreviations of the string "word".
 * Any other string is not a valid abbreviation of "word".
 *
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() == 0 || abbr.length() == 0) {
            return word.length() == 0 && abbr.length() == 0;
        }

        int indexW = 0;
        int indexA = 0;
        while (indexW < word.length() && indexA < abbr.length()) {
            int integer = 0;
            while (indexA < abbr.length() && Character.isDigit(abbr.charAt(indexA))) {
                if (integer == 0 && abbr.charAt(indexA) == '0') {
                    return false;
                }
                integer = 10 * integer + (abbr.charAt(indexA)-'0');
                indexA++;
            }

            // 数字大于word中剩余字符数
            if ((indexW += integer) > word.length()) {
                return false;
            }
            // 以数字结尾
            else if (indexW == word.length()) {
                return indexA == abbr.length();
            }
            // abbr已经走完，而word还有剩余字符
            else if (indexA == abbr.length()) {
                return false;
            }

            // 字符不匹配
            if (word.charAt(indexW) != abbr.charAt(indexA)) {
                return false;
            }
            indexA++;
            indexW++;
        }

        return indexA == abbr.length() && indexW == word.length();
    }

    public static void main(String[] args) {
        String word = "word";
        // String abbr = "i12iz4n";
        //String[] abbrs = {"word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"};
        String[] abbrs = {"2"};
        for (String abbr : abbrs) {
            System.out.println(new ValidWordAbbreviation().validWordAbbreviation(word, abbr));
        }
    }
}
