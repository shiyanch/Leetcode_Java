package FindIfPathExistsInGraph;

import java.util.*;

/**
 * 1971. Find if Path Exists in Graph
 *
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes
 * a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
 * and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to
 * destination, or false otherwise.
 */
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<Integer>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<Integer>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return findPath(graph, visited, source, destination);
    }

    private static boolean findPath(Map<Integer, List<Integer>> graph, Set<Integer> visited, int currentVertex, int destination) {
        if (currentVertex == destination) {
            return true;
        }
        visited.add(currentVertex);

        for (int neighbor : graph.getOrDefault(currentVertex, new ArrayList<Integer>())) {
            if (!visited.contains(neighbor) && findPath(graph, visited, neighbor, destination)) {
                return true;
            }
        }

        return false;
    }
}
