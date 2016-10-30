package StringToInteger;

/**
 * 8. String to Integer (atoi)
 *
 * Implement atoi to convert a string to an integer.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        int flag = 1;
        int count = 0;
        double result = 0;
        for(char c : str.toCharArray()) {
            count++;
            if(c >= '0' && c <= '9') {
                result *= 10;
                result += c-'0';
            }
            else if(c == '-' && count==1) {
                flag = -1;
            }
            else if(c == '+' && count==1) {
                flag = 1;
            }
            else
                break;
        }

        if(result > Integer.MAX_VALUE) {
            if(flag > 0) {
                return Integer.MAX_VALUE;
            }
            else
                return Integer.MIN_VALUE;
        }

        return  (int)(flag*result);
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("9223372036854775809"));
    }
}
