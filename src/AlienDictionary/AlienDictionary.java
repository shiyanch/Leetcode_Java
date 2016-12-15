package AlienDictionary;

import java.util.*;

/**
 * 269. Alien Dictionary
 *
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *
 * For example,
 * Given the following words in dictionary,
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 *
 * visited[i] = -1. Not even exist.
 * visited[i] = 0. Exist. Non-visited.
 * visited[i] = 1. Visiting.
 * visited[i] = 2. Visited.
 */
public class AlienDictionary {
    private final int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {
                if(visited[j] == 1) {
                    return false;
                }
                if(visited[j] == 0) {
                    if(!dfs(adj, visited, sb, j)) {
                        return false;
                    }
                }
            }
        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                if (!w1.equals(w2) && w1.startsWith(w2)) {
                    Arrays.fill(visited, 2);
                    return;
                }
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"ab", "ac", "ab"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
