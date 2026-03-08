package custom.data.structures.graphs;

/**
 * Builds adjacency matrix representations for graphs.
 * It supports directed, undirected, and weighted inputs.
 */
public class AdjacencyMatrix {

  int[][] matrix;
  int rowsLength;
  int columnLength;

  /**
   * Creates a default 10 x 10 matrix.
   */
  public AdjacencyMatrix() {
    this.matrix = new int[10][10];
    this.rowsLength = 10;
    this.columnLength = 10;
  }

  /**
   * Builds a matrix for an undirected graph.
   * @param graph edge list input
   * @return generated matrix
   */
  public int[][] designMatrixForUndirectedGraph(int[][] graph) {

    int max = 0;

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        max = Math.max(max, graph[i][j]);
      }
    }

    this.matrix = new int[max + 1][max + 1];
    this.rowsLength = this.columnLength = max + 1;

    for (int[] row : graph) {
      if (row.length == 2) {
        matrix[row[0]][row[1]] = 1;
        matrix[row[1]][row[0]] = 1;
      }
    }

    printMatrix();
    return matrix;
  }

  /**
   * Builds a matrix for a directed graph.
   * @param graph edge list input
   * @return generated matrix
   */
  public int[][] designMatrixForDirectedGraph(int[][] graph) {

    int max = 0;

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        max = Math.max(max, graph[i][j]);
      }
    }

    this.matrix = new int[max + 1][max + 1];
    this.rowsLength = this.columnLength = max + 1;

    for (int[] row : graph) {
      if (row.length == 2) {
        matrix[row[0]][row[1]] = 1;
      }
    }
    printMatrix();
    return matrix;
  }

  /**
   * Builds a matrix for a weighted undirected graph.
   * @param graph weighted edge list input
   * @return generated matrix
   */
  public int[][] designMatrixForUndirectedWeightedGraph(int[][] graph) {
    int max = 0;

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < 2; j++) {
        max = Math.max(max, graph[i][j]);
      }
    }

    this.matrix = new int[max + 1][max + 1];
    this.rowsLength = this.columnLength = max + 1;

    for (int[] row : graph) {
      if (row.length == 3) {
        matrix[row[0]][row[1]] = row[2];
        matrix[row[1]][row[0]] = row[2];
      }
    }
    printMatrix();
    return matrix;
  }

  /**
   * Builds a matrix for a weighted directed graph.
   * @param graph weighted edge list input
   * @return generated matrix
   */
  public int[][] designMatrixForDirectedWeightedGraph(int[][] graph) {
    int max = 0;

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < 2; j++) {
        max = Math.max(max, graph[i][j]);
      }
    }

    this.matrix = new int[max + 1][max + 1];
    this.rowsLength = this.columnLength = max + 1;

    for (int[] row : graph) {
      if (row.length == 3) {
        matrix[row[0]][row[1]] = row[2];
      }
    }
    printMatrix();
    return matrix;
  }

  /**
   * Prints the current matrix.
   */
  public void printMatrix() {

    for (int[] rows : this.matrix) {
      for (int element : rows) {
        System.out.print(element + "   ");
      }
      System.out.println(" ");
    }
  }
}
