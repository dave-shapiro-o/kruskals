
import java.util.*;
import java.util.concurrent.TimeUnit;

class Solution {
    public static void main(String[] args) {
        List<Integer> fromNodes = new ArrayList<>();
        fromNodes.add(1);
        fromNodes.add(3);
        fromNodes.add(4);
        fromNodes.add(2);
        fromNodes.add(1);
        fromNodes.add(5);

        List<Integer> toNodes = new ArrayList<>();
        toNodes.add(2);
        toNodes.add(2);
        toNodes.add(3);
        toNodes.add(4);
        toNodes.add(4);
        toNodes.add(1);

        List<Integer> edgeWeights = new ArrayList<>();
        edgeWeights.add(1);
        edgeWeights.add(150);
        edgeWeights.add(99);
        edgeWeights.add(100);
        edgeWeights.add(100);
        edgeWeights.add(200);

        long startTime = System.nanoTime();
        int totalMstWeight = Result.kruskals(5, fromNodes, toNodes, edgeWeights);
        uiDebugHelper.displayTotalWeight(totalMstWeight);
        long endTime = System.nanoTime();
        uiDebugHelper.displayTimeTaken(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }
}

public class Result {

    static int numComponents;
    static int[] graph;
    static int[] size;

    public static int kruskals(int gNodes, List<Integer> gFrom,
                               List<Integer> gTo, List<Integer> gWeight) {

        int totalWeight = 0;

        // Creates a list of edges from the input data, sorted by weight
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < gFrom.size(); ++i) {
            List<Integer> edge = new ArrayList<>();
            edge.add(gFrom.get(i));
            edge.add(gTo.get(i));
            edge.add(gWeight.get(i));
            edges.add(edge);
        }
        edges.sort(Comparator.comparingInt(o -> o.get(2)));
        uiDebugHelper.displayEdges(edges);

        // The graph array - for each element:
        // the index represents a node, the value represents the node's parent
        graph = new int[gNodes + 1];
        // The size array - for each element :
        // the index represents the root of the disjoint subgroup, the value its size
        size = new int[gNodes + 1];

        // Nodes are numbered starting from 1, ignoring the 0 index of the arrays (hence the +1 array size above)
        // Initially, each node is a disjoint subgroup with itself as root
        for (int i = 1; i <= gNodes; ++i) {
            graph[i] = i;
            size[i] = 1;
        }

        for (List<Integer> edge : edges) {

            int from = edge.get(0);
            int to = edge.get(1);
            int weight = edge.get(2);

            int fromRoot = find(from);
            int toRoot = find(to);
            // Skip this edge if it will create a cycle
            if (fromRoot == toRoot) continue;

            // Otherwise include this edge
            union(fromRoot, toRoot);
            totalWeight += weight;
            uiDebugHelper.display(graph, size, from, to, totalWeight);

            // Once all nodes are in one group, the tree is finished
            for (int n : size)
            if (n == gNodes) {
                uiDebugHelper.displayCompletedMessage();
                break;
            }
        }
        return totalWeight;
    }

    // Returns the parent node of a given node's subgroup
    public static int find(int node) {
        //recursive implementation
        if (graph[node] == node) { return node; }
        return find(graph[node]);

        /* Iterative version with path compression:
        int root = node;
        while (root != graph[root]) {
            root = graph[root];
        }
        while (node != root) {
            // Path compression
            int next = graph[node];
            graph[node] = root;
            node = next;
        }
        return root; */
    }

    public static void union(int rootA, int rootB) {

        if (size[rootA] < size[rootB]) {
            size[rootB] += size[rootA];
            size[rootA] = 0;
            graph[rootA] = rootB;
        } else {
            size[rootA] += size[rootB];
            size[rootB] = 0;
            graph[rootB] = rootA;
        }
        --numComponents;
    }
}