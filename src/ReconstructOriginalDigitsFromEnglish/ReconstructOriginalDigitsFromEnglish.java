package ReconstructOriginalDigitsFromEnglish;

import java.util.ArrayList;

/**
 * 423. Reconstruct Original Digits from English
 *
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 *
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] map = new int[10];
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }

        if(count['z'-'a'] != 0) {
            map[0] = count['z'-'a'];
            count['e'-'a'] -= count['z'-'a'];
            count['r'-'a'] -= count['z'-'a'];
            count['o'-'a'] -= count['z'-'a'];
            count['z'-'a'] = 0;
        }

        if(count['w'-'a'] != 0) {
            map[2] = count['w'-'a'];
            count['t'-'a'] -= count['w'-'a'];
            count['o'-'a'] -= count['w'-'a'];
            count['w'-'a'] = 0;
        }

        if(count['g'-'a'] != 0) {
            map[8] = count['g'-'a'];
            count['e'-'a'] -= count['g'-'a'];
            count['i'-'a'] -= count['g'-'a'];
            count['h'-'a'] -= count['g'-'a'];
            count['t'-'a'] -= count['g'-'a'];
            count['g'-'a'] = 0;
        }

        if(count['u'-'a'] != 0) {
            map[4] = count['u'-'a'];
            count['f'-'a'] -= count['u'-'a'];
            count['o'-'a'] -= count['u'-'a'];
            count['r'-'a'] -= count['u'-'a'];
            count['u'-'a'] -= 0;
        }

        if(count['x'-'a'] != 0) {
            map[6] = count['x'-'a'];
            count['s'-'a'] -= count['x'-'a'];
            count['i'-'a'] -= count['x'-'a'];
            count['x'-'a'] = 0;
        }

        if(count['h'-'a'] != 0) {
            map[3] = count['h'-'a'];
            count['t'-'a'] -= count['h'-'a'];
            count['r'-'a'] -= count['h'-'a'];
            count['e'-'a'] -= 2*count['h'-'a'];
            count['h'-'a'] = 0;
        }

        if(count['s'-'a'] != 0) {
            map[7] = count['s'-'a'];
            count['e'-'a'] -= 2*count['s'-'a'];
            count['v'-'a'] -= count['s'-'a'];
            count['n'-'a'] -= count['s'-'a'];
            count['s'-'a'] = 0;
        }

        if(count['o'-'a'] != 0) {
            map[1] = count['o'-'a'];
            count['n'-'a'] -= count['o'-'a'];
            count['e'-'a'] -= count['o'-'a'];
            count['o'-'a'] = 0;
        }

        if(count['n'-'a'] != 0) {
            map[9] = count['n'-'a']/2;
            count['e'-'a'] -= count['n'-'a']/2;
            count['i'-'a'] -= count['n'-'a']/2;
            count['n'-'a'] -= 0;
        }

        if(count['i'-'a'] != 0) {
            map[5] = count['i'-'a'];
            count['f'-'a'] -= count['i'-'a'];
            count['v'-'a'] -= count['i'-'a'];
            count['e'-'a'] -= count['i'-'a'];
            count['i'-'a'] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++) {
            if(map[i] != 0) {
                for(int j=0;j<map[i];j++) {
                    sb.append(i);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits("nnei"));
    }
}
