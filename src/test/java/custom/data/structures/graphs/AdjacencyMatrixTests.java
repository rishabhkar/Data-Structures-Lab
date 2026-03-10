package custom.data.structures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Adjacency Matrix Tests")
class AdjacencyMatrixTests {

    private AdjacencyMatrix matrix;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        matrix = new AdjacencyMatrix();
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Undirected graph should create values on both sides")
    void undirectedGraphCreatesValuesOnBothSides() {
        int[][] result = matrix.designMatrixForUndirectedGraph(new int[][]{{0, 1}, {1, 2}});
        printValue("Matrix size", result.length);
        assertEquals(1, result[0][1]);
        assertEquals(1, result[1][0]);
        assertEquals(1, result[1][2]);
        assertEquals(1, result[2][1]);
    }

    @Test
    @DisplayName("Directed graph should create one way values")
    void directedGraphCreatesOneWayValues() {
        int[][] result = matrix.designMatrixForDirectedGraph(new int[][]{{0, 1}, {1, 2}});
        printValue("Matrix size", result.length);
        assertEquals(1, result[0][1]);
        assertEquals(0, result[1][0]);
        assertEquals(1, result[1][2]);
        assertEquals(0, result[2][1]);
    }

    @Test
    @DisplayName("Weighted undirected graph should store weight on both sides")
    void weightedUndirectedGraphStoresWeightOnBothSides() {
        int[][] result = matrix.designMatrixForUndirectedWeightedGraph(new int[][]{{0, 1, 5}});
        printValue("Weight", result[0][1]);
        assertEquals(5, result[0][1]);
        assertEquals(5, result[1][0]);
    }

    @Test
    @DisplayName("Weighted directed graph should store weight in one direction")
    void weightedDirectedGraphStoresWeightInOneDirection() {
        int[][] result = matrix.designMatrixForDirectedWeightedGraph(new int[][]{{0, 1, 7}});
        printValue("Weight", result[0][1]);
        assertEquals(7, result[0][1]);
        assertEquals(0, result[1][0]);
    }
}

