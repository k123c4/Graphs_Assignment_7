import java.util.*;

public class WeakConnection {

    public static boolean isWeaklyConnected(int[][] matrix, int n) {
        if (n == 0) return true;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Start traversal from the first node
        visited[0] = true;
        queue.add(0);
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor = 0; neighbor < n; neighbor++) {
                // Check for an edge in EITHER direction (ignoring orientation)
                if (!visited[neighbor] && (matrix[current][neighbor] == 1 || matrix[neighbor][current] == 1)) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    visitedCount++;
                }
            }
        }

        // If we reached all nodes, it is weakly connected
        return visitedCount == n;
    }

    public static void main(String[] args) {
        //number of nodes
        int n = 3;

        //  adjacency matrix weakly connected
        int[][] matrix = {
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
//        //  adjacency matrix NOT weakly connected
//        int[][] matrix = {
//                {1, 0, 1},
//                {0, 0, 0},
//                {0, 0, 0}
//        };

        if (isWeaklyConnected(matrix, n)) {
            System.out.println("Result: The graph is weakly connected.");
        } else {
            System.out.println("Result: The graph is NOT weakly connected.");
        }
    }
}
