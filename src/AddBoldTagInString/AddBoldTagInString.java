package AddBoldTagInString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 616. Add Bold Tag in String
 *
 * Given a string s and a list of strings dict,
 * you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict.
 *
 * If two such substrings overlap,
 * you need to wrap them together by only one pair of closed bold tag.
 *
 * Also, if two substrings wrapped by bold tags are consecutive,
 * you need to combine them.
 *
 * Example 1:
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 *
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 *
 * Example 2:
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 *
 * Output:
 * "<b>aaabbc</b>c"
 */
public class AddBoldTagInString {
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = makeIntervals(s, dict);
        if (intervals.size() == 0) {
            return s;
        }
        mergeIntervals(intervals);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        // 双指针时要注意任一个指针越界
        for (int i=0; i<s.length(); i++) {
            if (index < intervals.size()) {
                if (i == intervals.get(index).start) {
                    sb.append("<b>");
                } else if (i == intervals.get(index).end) {
                    sb.append("</b>");
                    index++;
                }
            }
            sb.append(s.charAt(i));
        }
        if (index < intervals.size()) {
            sb.append("</b>");
        }
        return sb.toString();
    }

    private void mergeIntervals(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return;
        }

        Interval prev = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start > prev.end) {
                prev = curr;
            } else {
                prev.end = Math.max(prev.end, curr.end);
                intervals.remove(i);
                i--;
            }
        }
    }

    private List<Interval> makeIntervals(String s, String[] dict) {
        List<Interval> list = new ArrayList<>();
        for (String word: dict) {
            int index = s.indexOf(word);
            while (index != -1) {
                list.add(new Interval(index, index+word.length()));
                index = s.indexOf(word, index+1);
            }
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start == i2.start? i1.end-i2.end: i1.start-i2.start;
            }
        });
        return list;
    }
}
