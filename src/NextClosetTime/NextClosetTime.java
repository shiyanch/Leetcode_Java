package NextClosetTime;

import java.util.Arrays;

/**
 * 681. Next Closest Time
 *
 * Given a time represented in the format "HH:MM",
 * form the next closest time by reusing the current digits.
 *
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid.
 * For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Sample Input
 * "19:34"
 * "19:44"
 * "23:59"
 * "00:01"
 * "23:32"
 *
 * Sample Output
 * "19:39"
 * "19:49"
 * "22:22"
 * "00:10"
 * "23:33"
 */
public class NextClosetTime {
    public String nextClosestTime(String time) {
        String t = time.substring(0,2) + time.substring(3);
        char[] digits = t.toCharArray();
        Arrays.sort(digits);


        for (int i=3; i>=0; i--) {
            int index = findIndex(digits, t.charAt(i));
            while (index++ < 3) {
                StringBuilder candidate = new StringBuilder(t.substring(0,i));
                candidate.append(digits[index]);
                for (int j=i; j<3; j++) {
                    candidate.append(digits[0]);
                }
                if (isValidTime(candidate.toString())) {
                    candidate.insert(2,':');
                    return candidate.toString();
                }
            }
        }

        StringBuilder candidate = new StringBuilder();
        for (int i=0; i<5; i++) {
            if (i == 2) {
                candidate.append(':');
            } else {
                candidate.append(digits[0]);
            }
        }
        return candidate.toString();
    }

    private int findIndex(char[] digits, char c) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] == c) {
                return i;
            }
        }
        return 0;
    }

    private boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(2));
        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }

    public static void main(String[] args) {
        System.out.println(new NextClosetTime().nextClosestTime("19:34"));
        System.out.println(new NextClosetTime().nextClosestTime("19:44"));
        System.out.println(new NextClosetTime().nextClosestTime("23:59"));
    }
}
