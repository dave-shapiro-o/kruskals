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
