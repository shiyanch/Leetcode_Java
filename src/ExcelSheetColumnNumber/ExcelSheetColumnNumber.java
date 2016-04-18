package ExcelSheetColumnNumber;

/**
 * 171. Excel Sheet Column Number
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet
 * return its corresponding column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] alphabet = s.toCharArray();

        int sum = 0;
        for(int i=0;i<alphabet.length;i++) {
            sum += ((int)alphabet[i]-64)*Math.pow(26,alphabet.length-i-1);
        }
        return sum;
    }

}
