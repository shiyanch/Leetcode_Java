package ConvertANumberToHexadecimal;

/**
 * 405. Convert a Number to Hexadecimal
 *
 * Given an integer, write an algorithm to convert it to hexadecimal.
 * For negative integer, two’s complement method is used.
 * Note:
 *
 * 1. All letters in hexadecimal (a-f) must be in lowercase.
 *
 * 2. The hexadecimal string must not contain extra leading 0s.
 * If the number is zero, it is represented by a single zero character '0'; otherwise,
 * the first character in the hexadecimal string will not be the zero character.
 *
 * 3. The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * 4. You must not use any method provided by the library which converts/formats the number to hex directly.
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0)
            return "0";

        String[] dict = new String[] {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String hex = "";
        while (num != 0) {
            hex = dict[num&15]+hex;
            num >>>= 4;
        }
        return hex;
    }
}
