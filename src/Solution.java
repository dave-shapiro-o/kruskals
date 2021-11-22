import java.util.*;
import java.util.concurrent.TimeUnit;

class Solution {
    public static void main(String[] args) {
        Integer[] from = new Integer[]{1, 3, 4, 2, 1, 5};
        List<Integer> fromNodes = Arrays.asList(from);

        Integer[] to = new Integer[]{2, 2, 3, 4, 4, 1};
        List<Integer> toNodes = Arrays.asList(to);

        Integer[] weights = new Integer[]{1, 150, 99, 100, 100, 200};
        List<Integer> edgeWeights = Arrays.asList(weights);

        long startTime = System.nanoTime();
        int totalMstWeight = Result.kruskals(5, fromNodes, toNodes, edgeWeights);
        uiDebugHelper.displayTotalWeight(totalMstWeight);
        long endTime = System.nanoTime();
        uiDebugHelper.displayTimeTaken(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }
}
