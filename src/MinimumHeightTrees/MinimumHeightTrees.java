package MinimumHeightTrees;

import java.util.*;

/**
 * 310. Minimum Height Trees
 *
 * For a undirected graph with tree characteristics,
 * we can choose any node as the root.
 *
 * The result graph is then a rooted tree.
 * Among all possible rooted trees,
 * those with minimum height are called minimum height trees (MHTs).
 *
 * Given such a graph,
 * write a function to find all the MHTs and return a list of their root labels.
 */
public class MinimumHeightTrees {

    // Cut leaves
    // https://discuss.leetcode.com/topic/30572/share-some-thoughts
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1)
            return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for(int i=0;i<n;++i) {
            adj.add(new HashSet<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;++i) {
            if(adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i: leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }


    // One way BFS - TLE
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;

        int[][] matrix = new int[n][n];
        for(int[] pair : edges) {
            matrix[pair[0]][pair[1]] = matrix[pair[1]][pair[0]] = 1;
        }

        for(int i=0;i<n;i++) {
            int level = minLevel(i, matrix, minHeight);
            if(level == -1) {
                continue;
            }

            if(level < minHeight) {
                minHeight = level;
                list.clear();
            }

            if(level == minHeight) {
                list.add(i);
            }
        }

        return list;
    }

    private int minLevel(int index, int[][] matrix, int currMinLevel) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        queue.add(index);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int s=0;s<size;s++) {
                int currNode = queue.poll();
                visited[currNode] = true;
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[currNode][i] == 1 && !visited[i]) {
                        queue.add(i);
                    }
                }
            }

            if(++level > currMinLevel) {
                return -1;
            }
        }
        return level;
    }

}
