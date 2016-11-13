package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    // DP solution
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len+1];
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<>());

        boolean[][] pair = new boolean[len][len];
        for(int i=0;i<len;i++) {
            result[i+1] = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(s.charAt(j) == s.charAt(i) && (i-j<= 1 || pair[j+1][i-1])) {
                    pair[j][i] = true;
                    String str = s.substring(j, i+1);
                    for(List<String> r : result[j]) {
                        List<String> ri = new ArrayList<>(r);
                        ri.add(str);
                        result[i+1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }

    // DFS solution
    public List<List<String>> partitionDFS(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<String>();
        dfs(s, 0, list, result);
        return result;
    }

    private void dfs(String s, int pos, List<String> list, List<List<String>> result) {
        if(pos == s.length()) {
            result.add(new ArrayList<>(list));
        }

        for(int i=pos;i<s.length();i++) {
            if(isPal(s, pos, i)) {
                list.add(s.substring(pos, i+1));
                dfs(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPal(String s, int low, int high) {
        while (low < high) {
            if(s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }

        return true;
    }
}
