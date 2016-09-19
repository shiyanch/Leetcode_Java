package ReverseBits;

import java.util.HashMap;
import java.util.Map;

/**
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            res += n&1;
            n>>>=1;
            if(i<31)
                res <<= 1;
        }
        return res;
    }

    private final Map<Byte, Integer> cache = new HashMap<>();
    public int reverseBits_optimized(int n) {
        byte[] bytes = new byte[4];
        for(int i=0;i<4;i++)
            bytes[i] = (byte)((n>>>8*i) & 0xFF);
        int res = 0;
        for(int i=0;i<4;i++) {
            res += reverseByte(bytes[i]);
            if(i<3)
                res <<= 8;
        }
        return res;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b);
        if(value != null)
            return value;

        value = 0;
        for(int i=0;i<8;i++) {
            value += ((b>>>i)&1);
            if(i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
}
