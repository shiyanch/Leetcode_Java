package MinimumGeneticMutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 433. Minimum Genetic Mutation
 *
 * A gene string can be represented by an 8-character long string,
 * with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"),
 * where ONE mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations.
 * A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank,
 * your task is to determine what is the minimum number of mutations
 * needed to mutate from "start" to "end".
 *
 * If there is no such a mutation, return -1.
 *
 * Note:
 * Starting point is assumed to be valid,
 * so it might not be included in the bank.
 *
 * If multiple mutations are needed,
 * all mutations during in the sequence must be valid.
 *
 * You may assume start and end string is not the same.
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        Set<String> dict = new HashSet<String>();
        for (String gene : bank) {
            dict.add(gene);
        }

        return bfs(start, end, 0, dict, 0);
    }

    private int bfs(String start, String end, int count, Set<String> dict, int pos) {
        int level = 0;
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return level;
                }

                char[] currArray = curr.toCharArray();
                for (int i=0; i<currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (!visited.contains(next) && dict.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] bank = {"TA"};
        String start = "TT";
        String end = "TA";
        System.out.println(new MinimumGeneticMutation().minMutation(start, end, bank));
    }
}
