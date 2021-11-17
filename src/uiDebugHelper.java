import java.util.List;

public class uiDebugHelper {
    public static void display(int[] graph, int[] size, int from, int to, int currentTotalWeight) {
        System.out.println("Edge added: " + from + " - " + to);
        System.out.println("Current weight: " + currentTotalWeight);

        System.out.print("Size:    ");
        for (int s = 1; s < size.length; ++s) {
            System.out.print(size[s] + " ");
        }
        System.out.println(" (of disjoint subgroup with below node as root)");

        int i = 1;
        System.out.print("Node:    ");
        for (int n = 1; n < graph.length; ++n) {
            System.out.print(i++ + " ");
        }
        System.out.println();

        System.out.print("Parent:  ");
        for (int n = 1; n < graph.length; ++n) {
            System.out.print(graph[n] + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void displayEdges(List<List<Integer>> edges) {
        System.out.println("Edges:");
        for (List<Integer> edge : edges) {
            System.out.println(edge.get(0) + " - " + edge.get(1) + "   Weight: " + edge.get(2));
        }
        System.out.println();
    }

    public static void displayTotalWeight(int totalMstWeight) {
        System.out.println("Total weight of MST: " + totalMstWeight);
    }

    public static void displayCompletedMessage() {
        System.out.println("Completed generation of MST.");
    }

    public static void displayTimeTaken(long timeTaken) {
        System.out.println("Time taken: " + timeTaken + " milliseconds");
    }
}
