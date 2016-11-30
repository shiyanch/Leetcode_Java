package SentenceScreenFitting;

/**
 * 418. Sentence Screen Fitting
 *
 * Given a rows x cols screen and a sentence represented by a list of words,
 * find how many times the given sentence can be fitted on the screen.
 *
 * Note:
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 */
public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        // 记录走过的下标
        int start = 0;
        String s = String.join(" ",sentence) + " ";

        for (int i=0; i<rows; i++) {
            start += cols;
            // 如果当前为空格，刚好能放一整行
            if (s.charAt(start % s.length()) == ' ') {
                start++;
            }
            else {
                // 当前不是空格，将start回退到第一个空格之后的那个位置，完成这一行
                while (start > 0 && s.charAt((start-1) % s.length()) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }

    // TLE
    public int wordsTyping_TLE(String[] sentence, int rows, int cols) {
        int count = 0;
        int remainCols = cols;
        int remainRows = rows;
        int index = 0;

        while (remainRows > 0) {
            while(remainCols >= sentence[index].length()) {
                // if (remainCols > sentence[index].length()) {
                remainCols -= sentence[index].length();
                // }
                if (remainCols > 0) {
                    remainCols--;
                }
                index++;
                if (index == sentence.length) {
                    index = 0;
                    count++;
                }
            }
            remainRows--;
            remainCols = cols;
        }

        return count;
    }
}
