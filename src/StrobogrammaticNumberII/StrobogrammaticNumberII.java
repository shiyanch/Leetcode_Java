package StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.List;

/**
 * 247. Strobogrammatic Number II
 *
 * A strobogrammatic number is a number that looks the same
 * when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 */
public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }
        if (n % 2 == 0) {
            backtracking(result, "", n);
        }
        else {
            backtracking(result, "1", n);
            backtracking(result, "0", n);
            backtracking(result, "8", n);
        }
        return result;
    }

    private void backtracking(List<String> result, String curr, int n) {
        if (curr.length() == n || curr.length() == n+1) {
            result.add(curr);
            return;
        }

        backtracking(result, "1"+curr+"1", n);
        backtracking(result, "8"+curr+"8", n);
        backtracking(result, "6"+curr+"9", n);
        backtracking(result, "9"+curr+"6", n);
        if (curr.length() < n-2) {
            backtracking(result, "0"+curr+"0", n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new StrobogrammaticNumberII().findStrobogrammatic(1));
        System.out.println(new StrobogrammaticNumberII().findStrobogrammatic(2));
        System.out.println(new StrobogrammaticNumberII().findStrobogrammatic(3));
        System.out.println(new StrobogrammaticNumberII().findStrobogrammatic(4));
    }
}
