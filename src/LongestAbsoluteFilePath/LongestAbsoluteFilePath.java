package LongestAbsoluteFilePath;

import java.util.Stack;

/**
 * 388. Longest Absolute File Path
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] segments = input.split("\n");
        int max = 0;
        int curLen = 0;
        Stack<Integer> path = new Stack<>();

        for(String segment : segments) {
            int level = countLevel(segment);

            while(path.size() > level) {
                curLen -= path.pop();
            }

            int len = segment.replace("\t","").length()+1;
            curLen += len;
            if(segment.contains("."))
                max = Math.max(max, curLen-1);

            path.push(len);
        }

        return max;
    }

    private int countLevel(String segment) {
        String parse = segment.replaceAll("\t","");
        return segment.length() - parse.length();
    }

    public static void main(String[] args) {
        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("\t\t\t\thehe.txt"));
//        System.out.println(new LongestAbsoluteFilePath().lengthLongestPath("a\nbb\ncc\nddd\n\t1.t"));

    }
}
