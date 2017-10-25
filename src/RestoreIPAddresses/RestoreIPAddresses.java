package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
//        DFS(result, s, new String[3], 0, 4);
        backtrack(result, s, 0, "", 0);
        return result;
    }

    private void backtrack(List<String> list, String s, int index, String cur, int cnt) {
        if (index == s.length()) {
            if (cnt == 4) {
                list.add(cur.substring(0, cur.length()-1));
            }
            return;
        }

        if (cnt > 3) {
            return;
        }

        backtrack(list, s, index+1, cur+s.charAt(index)+".", cnt+1);

        if (s.charAt(index) == '0') {
            return;
        }

        if (index < s.length() - 1) {
            backtrack(list, s, index+2, cur+s.substring(index, index+2)+".", cnt+1);
        }

        if (index < s.length() - 2) {
            int part = Integer.parseInt(s.substring(index, index+3));
            if (part < 256) {
                backtrack(list, s, index+3, cur+part+".", cnt+1);
            }
        }
    }

    private void DFS(List<String> result,String s, String[] parts, int index, int toRestore) {
        if(index >= s.length()) {
            return;
        }

        if(toRestore == 1) {
            if(s.substring(index).length() > 3 || (s.substring(index).length() > 1 && s.charAt(index) == '0')) {
                return;
            }
            int remain = Integer.parseInt(s.substring(index));
            if(remain <= 255) {
                StringBuilder sb = new StringBuilder();
                for(String part : parts) {
                    sb.append(part).append(".");
                }
                result.add(sb.append(remain).toString());
            }
            return;
        }

        // 1位
        parts[4-toRestore] = s.charAt(index)+"";
        DFS(result, s, parts, index+1, toRestore-1);

        // 2位
        if(s.charAt(index) != '0' && index + 1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(index, index+2));
            parts[4-toRestore] = twoDigits+"";
            DFS(result, s, parts, index+2, toRestore-1);
        }

        // 3位
        if(index + 2 < s.length() && s.charAt(index) != '0') {
            int threeDigits = Integer.parseInt(s.substring(index, index+3));
            if(threeDigits <= 255) {
                parts[4-toRestore] = threeDigits+"";
                DFS(result, s, parts, index+3, toRestore-1);
            }
        }
    }

    public static void main(String[] args) {
//        String ip = "010010";
        String ip = "25500123";
        System.out.println(new RestoreIPAddresses().restoreIpAddresses(ip).toString());
    }
}
