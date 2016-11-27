package GraphValidTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 261. Graph Valid Tree
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];

        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<edges.length;i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];

        if(hasCycle(adj, 0, visited, -1)) {
            return false;
        }

        for(boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int curr, boolean[] visited, int parent) {
        visited[curr] = true;
        for(int neighbor : adj[curr]) {
            if(neighbor == parent) {
                continue;
            }
            if(visited[neighbor] ||hasCycle(adj, neighbor, visited, curr) ) {
                return true;
            }
        }
        return false;
    }
}
