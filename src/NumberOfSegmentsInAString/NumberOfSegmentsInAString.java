package NumberOfSegmentsInAString;

import java.util.Arrays;

/**
 * 434. Number of Segments in a String
 *
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        return s.trim().length()==0?0:s.trim().split("\\s+").length;
        //return ("x " + s).split(" +").length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInAString().countSegments("     "));
    }
}
