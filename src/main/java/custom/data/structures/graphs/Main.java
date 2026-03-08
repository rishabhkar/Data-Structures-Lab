package custom.data.structures.graphs;

/**
 * Simple runner for the graphs package.
 */
public class Main {

  public static void main(String[] args) {
    int[][] graph = {
        {1, 2},
        {1, 3},
        {2, 4},
        {3, 5}
    };

    System.out.println("Adjacency matrix");
    new AdjacencyMatrix().designMatrixForUndirectedGraph(graph);

    System.out.println("Adjacency list");
    new AdjacencyLists().designUndirectedAdjacencyList(graph);

    System.out.println("BFS traversal");
    new BreadthFirstSearch().breadFirstSearch(graph);
    System.out.println();

    System.out.println("DFS traversal");
    new DepthFirstSearch().depthFirstSearch(graph);
  }
}

