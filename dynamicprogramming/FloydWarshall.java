package dynamicprogramming;

public class FloydWarshall {

    static int INF = 9999;

    public static void allPairShortestPath(int[][] graph) {

        int vertices = graph.length;

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {

                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }

                }
            }
        }

        // Print result
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {

                if (graph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };

        allPairShortestPath(graph);
    }
}