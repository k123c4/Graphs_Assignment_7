import java.util.*;
public class FindCycles {
    public static void DFS(int[][] graph, int start, int current, int length,
                           boolean[] visited, String path){
        visited[current]= true;

        for (int neighbor = 0; neighbor < graph.length; neighbor++){
            if(graph[current][neighbor]>0){
                if (length == 4 && neighbor == start){
                    System.out.println("Cycle: "+ path+ "-> " +start);
                }
                else if (length < 4 && ! visited[neighbor]){
                    DFS(graph, start,neighbor,
                            length + 1, visited, path + " -> " + neighbor);
                }
            }
        }
        visited[current] = false;

    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {7, 0, 0, 0}
        };
//        int[][] graph = {
//                // Nodes: 0, 1, 2, 3, 4, 5
//                {0, 1, 1, 0, 0, 0},
//                {0, 0, 1, 0, 1, 0},
//                {0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0},
//                {0, 1, 0, 1, 0, 0},
//                {0, 0, 0, 1, 1, 0}
//        };

        int n = graph.length;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            DFS(graph, i, i, 1, new boolean[n], i + "");
        }
    }
}
