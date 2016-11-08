package UTF8Validation;

import PacificAtlanticWaterFlow.PacificAtlanticWaterFlow;

/**
 * 393. UTF-8 Validation
 *
 * A character in UTF8 can be from 1 to 4 bytes long,
 * subjected to the following rules:
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 *
 * For n-bytes character, the first n-bits are all one's,
 * the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 *
 * This is how the UTF-8 encoding would work:
 * Char. number range  |        UTF-8 octet sequence
 * (hexadecimal)    |              (binary)
 * --------------------+---------------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * Given an array of integers representing the data,
 * return whether it is a valid utf-8 encoding.
 *
 * Note:
 * The input is an array of integers.
 * Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int[] mask = {192, 224, 240, 128};

        int bytes = 1;
        for(int num : data) {
            if(bytes == 1) {
                if((num & 128) == 0) {
                    continue;
                }
                else if((num & 192) == 192 && (num & 32) == 0) {
                    bytes = 2;
                }
                else if((num & 224) == 224 && (num & 16) == 0) {
                    bytes = 3;
                }
                else if((num & 240) == 240 && (num & 8) == 0) {
                    bytes = 4;
                }
                else {
                    return false;
                }
            }
            else {
                if((num & 64) == 0 && (num & 128) == 128) {
                    bytes--;
                }
                else {
                    return false;
                }
            }
        }
        return bytes == 1;
    }

    public static void main(String[] args) {
        System.out.println(new UTF8Validation().validUtf8(new int[] {197, 130, 1}));
    }
}
