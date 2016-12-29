package TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 *
 * Given an array of words and a length L,
 * format the text such that each line has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 *
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 *
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        int left = 0, right = 0;

        while (left < words.length) {
            right = left;
            int count = 0;
            while (right < words.length && count + words[right].length() <= maxWidth) {
                count += words[right].length()+1;
                right++;
            }

            count -= right-left;
            StringBuilder sb = new StringBuilder();
            if (right == left+1 || right == words.length) {
                while (left < right) {
                    sb.append(words[left++] + " ");
                }
                sb.deleteCharAt(sb.length()-1);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            else {
                StringBuilder[] spaces = new StringBuilder[right - left - 1];
                int index = 0;
                int spacesCount = 0;
                while (maxWidth - count - spacesCount > 0) {
                    if (spaces[index] == null) {
                        spaces[index] = new StringBuilder();
                    }
                    spacesCount++;
                    spaces[index].append(" ");
                    index = (index + 1) % spaces.length;
                }

                index = left;
                while (index < right) {
                    sb.append(words[index]);
                    if (index < right - 1) {
                        sb.append(spaces[index - left].toString());
                    }
                    index++;
                }
            }

            list.add(sb.toString());
            left = right;
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","shall","be."};
        System.out.println(new TextJustification().fullJustify(new String[] {""}, 0));
    }
}
