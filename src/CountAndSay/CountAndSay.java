package CountAndSay;

/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public String countAndSay(int n) {

        if(n <= 1)
            return "1";
        if(n == 2)
            return "11";

        String s = "11";
        while(n-- > 2) {
            StringBuilder sb = new StringBuilder("");
            char[] temp = s.toCharArray();
            char last = temp[0];
            int same = 0;

            for( char c : temp) {
                if(c == last) {
                    same++;
                }
                else {
                    sb.append(same+""+last);
                    same = 1;
                }
                last = c;
            }

            if(same != 0) {
                sb.append(same+""+last);
            }
            s = sb.toString();
        }
        return s;
    }
}
