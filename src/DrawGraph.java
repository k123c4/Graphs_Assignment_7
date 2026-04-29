
public class DrawGraph {
    public static void printAdjacencyMatrix(String[] v) {
        int n = v.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int stepsRight = (2 * i) + 1;
            int rightIndex = (i + stepsRight) % n;
            matrix[i][rightIndex] = 1;
        }

        for (int i = 0; i < n; i++) {
            int stepsLeft = (2 * i) + 2;
            int leftIndex = (i - stepsLeft) % n;
            while (leftIndex < 0) leftIndex += n;
            matrix[i][leftIndex] = 1;
        }

        System.out.println("Adjacency matrix for: " + String.join(" ", v));
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printAdjacencyMatrix(new String[]{"ANT", "CUN", "BOG", "AMA", "DC", "TOL", "SAN"});
    }
}