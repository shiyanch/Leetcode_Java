package CloneGraph;

import java.util.*;

/**
 * 133. Clone Graph
 *
 * Clone an undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {

    // Use Map<originalNode, copyNode> to keep synchronized
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);

        map.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();

            for(UndirectedGraphNode neighbor : currNode.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }

                map.get(currNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        CloneGraph graph = new CloneGraph();
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
//        node0.neighbors.add(node1);
//        node0.neighbors.add(node2);
//        node1.neighbors.add(node0);
//        node1.neighbors.add(node2);
//        node2.neighbors.add(node0);
//        node2.neighbors.add(node1);
//        node2.neighbors.add(node2);
        node0.neighbors.add(node0);
        node0.neighbors.add(node0);
        UndirectedGraphNode copied = graph.cloneGraph(node0);
        System.out.println((copied.neighbors).toString());
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}