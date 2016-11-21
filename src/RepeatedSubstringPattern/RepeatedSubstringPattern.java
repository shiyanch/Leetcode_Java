package RepeatedSubstringPattern;

/**
 * 459. Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed
 * by taking a substring of it and appending multiple copies of the substring together.
 *
 * You may assume the given string consists of lowercase English letters only
 * and its length will not exceed 10000.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        // 判断[0,i)的子数组是否为repeated pattern
        for (int i = 1; i <= str.length()/2; i++) {
            // 剪枝
            if (str.length() % i != 0) {
                continue;
            }
            boolean repeat = true;
            String cur = str.substring(0, i);
            for (int j = i; j <= str.length() - i; j+=i) {
                if(!cur.equals(str.substring(j, j+i))) {
                    repeat = false;
                    break;
                }
            }
            if (repeat) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abac"));
    }
}
