package NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 323. Number of Connected Components in an Undirected Graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    // Union Find solution
    // 如果两个节点连通，将其合并
    // 即roots数组将一个节点的root设置为另一个节点
    // 这样会形成树状结构
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i=0; i<n; i++) {
            roots[i] = i;
        }

        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);

            if (root1 != root2) {
                roots[root1] = root2;
                n--;
            }
        }
        return n;
    }

    // 查找本节点所连接的根
    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            // 路径压缩，将叶子节点直接连到根节点，加快后续对相同id的查找
            roots[id] = roots[roots[id]]; // path compression
            id = roots[id];
        }
        return id;
    }


    public int countComponents_Graph(int n, int[][] edges) {
        int[][] matrix = buildAdjMatrix(n, edges);
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                count++;
                bfs(matrix, i, visited);
            }
        }

        return count;
    }

    private void dfs(int[][] matrix, int start, boolean[] visited) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (int i=0; i<matrix.length; i++) {
            if (matrix[start][i] == 1 && !visited[i]) {
                dfs(matrix, i, visited);
            }
        }
    }

    private void bfs(int[][] matrix, int start, boolean[] visited) {
        if (visited[start]) {
            return;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (int i=0; i<matrix.length; i++) {
                if (matrix[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }

    private int[][] buildAdjMatrix(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            matrix[x][y] = matrix[y][x] = 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(new NumberOfConnectedComponentsInAnUndirectedGraph().countComponents(5, edges));
    }
}
