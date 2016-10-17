/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1)
            return s;

        int step = 0;
        StringBuilder sb = new StringBuilder();
        for(int level = 0;level<numRows;level++) {
            for(int i=level;i<s.length();i+=step) {
                sb.append(s.charAt(i));
                do {
                    step = 2*numRows-2-step;
                }while (step == 0);
            }
            step = 2*(level+1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("abcdefghijk", 5));
    }
}
