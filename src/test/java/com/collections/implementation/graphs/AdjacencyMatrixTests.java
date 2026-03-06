package com.collections.implementation.graphs;

import com.collections.implementation.list.*;
import java.io.*;
import java.util.concurrent.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

public class AdjacencyMatrixTests {

  AdjacencyMatrix adjacencyMatrix;

  @BeforeEach
  void setup() {
    adjacencyMatrix = new AdjacencyMatrix();
  }

  @AfterEach
  void tearDown() {
    adjacencyMatrix = null;
  }

  @Test
  void testAdjacencyMatrixDesignForUndirectedGraph() {
    int[][] graph = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};

    int[][] matrix = adjacencyMatrix.designMatrixForUndirectedGraph(graph);

    Assertions.assertNotNull(matrix);
    Assertions.assertEquals(1, matrix[1][2]);
    Assertions.assertEquals(1, matrix[1][3]);
    Assertions.assertEquals(1, matrix[3][4]);
    Assertions.assertEquals(1, matrix[4][2]);
    Assertions.assertEquals(1, matrix[2][5]);
    Assertions.assertEquals(1, matrix[5][4]);
  }

  @Test
  void testAdjacencyMatrixDesignForDirectedGraph() {
    int[][] graph = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};

    int[][] matrix = adjacencyMatrix.designMatrixForDirectedGraph(graph);

    Assertions.assertNotNull(matrix);
    Assertions.assertEquals(1, matrix[1][2]);
    Assertions.assertEquals(1, matrix[1][3]);
    Assertions.assertEquals(1, matrix[3][4]);
    Assertions.assertEquals(1, matrix[2][4]);
    Assertions.assertEquals(1, matrix[2][5]);
    Assertions.assertEquals(1, matrix[4][5]);
  }

  @Test
  void testAdjacencyMatrixDesignForUndirectedWeightedGraph() {
    int[][] graph = {{1, 2, 3}, {1, 3, 2}, {3, 4, 10}, {2, 4, 3}, {2, 5, 7}, {4, 5, 9}};

    int[][] matrix = adjacencyMatrix.designMatrixForUndirectedWeightedGraph(graph);

    Assertions.assertNotNull(matrix);
    Assertions.assertEquals(3, matrix[1][2]);
    Assertions.assertEquals(2, matrix[1][3]);
    Assertions.assertEquals(10, matrix[3][4]);
    Assertions.assertEquals(3, matrix[4][2]);
    Assertions.assertEquals(7, matrix[2][5]);
    Assertions.assertEquals(9, matrix[5][4]);
  }

  @Test
  void testAdjacencyMatrixDesignForDirectedWeightedGraph() {
    int[][] graph = {{1, 2, 3}, {1, 3, 2}, {3, 4, 10}, {2, 4, 3}, {2, 5, 7}, {4, 5, 9}};

    int[][] matrix = adjacencyMatrix.designMatrixForDirectedWeightedGraph(graph);

    Assertions.assertNotNull(matrix);
    Assertions.assertEquals(3, matrix[1][2]);
    Assertions.assertEquals(2, matrix[1][3]);
    Assertions.assertEquals(10, matrix[3][4]);
    Assertions.assertEquals(3, matrix[2][4]);
    Assertions.assertEquals(7, matrix[2][5]);
    Assertions.assertEquals(9, matrix[4][5]);
  }
}
