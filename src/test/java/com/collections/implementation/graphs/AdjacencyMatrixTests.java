package com.collections.implementation.graphs;

import com.collections.implementation.list.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

import java.io.*;
import java.util.concurrent.*;

public class AdjacencyMatrixTests {

      AdjacencyMatrix adjacencyMatrix;
      int[][] graph;

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
            int[][] graph = {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};

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
            int[][] graph = {{1,2},{1,3},{3,4},{2,4},{2,5},{4,5}};

            int[][] matrix = adjacencyMatrix.designMatrixForDirectedGraph(graph);

            Assertions.assertNotNull(matrix);
            Assertions.assertEquals(1, matrix[1][2]);
            Assertions.assertEquals(1, matrix[1][3]);
            Assertions.assertEquals(1, matrix[3][4]);
            Assertions.assertEquals(1, matrix[2][4]);
            Assertions.assertEquals(1, matrix[2][5]);
            Assertions.assertEquals(1, matrix[4][5]);

      }


}
