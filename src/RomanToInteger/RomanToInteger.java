package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * */
public class RomanToInteger {

    public int romnToInt(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;

        char[] roman = s.toCharArray();
        char last = roman[0];
        int value = 0;
        int temp = a[last-'A'];

        for (int i = 1; i < roman.length; i++) {
            char cur = roman[i];
            if (a[cur-'A'] > a[last-'A']) {
                value += (a[cur-'A'] - temp);

                if (i + 1 < roman.length) {
                    last = roman[i + 1];
                    temp = a[last-'A'];
                } else
                    temp = 0;

                i++;
            } else {
                value += temp;
                temp = a[cur-'A'];
                last = roman[i];
            }
        }

        return value + temp;
    }

    public int romanToInt2(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;

        char prev = 'A';
        int sum = 0;

        for(char c : s.toCharArray()) {
            if(a[c-'A'] > a[prev-'A']) {
                sum -= 2*a[prev-'A'];
            }

            sum += a[c-'A'];
            prev = c;
        }

        return sum;
    }
}
