package com.collections.implementation.graphs;

import org.junit.jupiter.api.*;

public class DepthFirstSearchTests {

  DepthFirstSearch depthFirstSearch;

  @BeforeEach
  void setup() {
    depthFirstSearch = new DepthFirstSearch();
  }

  @AfterEach
  void tearDown() {
    depthFirstSearch = null;
  }

  @Test
  void testDepthFirstSearchOnConnectedGraph() {
    int[][] graph = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertTrue(visited[3]);
    Assertions.assertTrue(visited[4]);
    Assertions.assertTrue(visited[5]);
  }

  @Test
  void testDepthFirstSearchWithUnreachableNodes() {
    int[][] graph = {{1, 2}, {2, 3}, {4, 5}};

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertTrue(visited[3]);
    Assertions.assertFalse(visited[4]);
    Assertions.assertFalse(visited[5]);
  }

  @Test
  void testDepthFirstSearchWithExplicitAdjacencyExample() {
    // 0 ->
    // 1 -> 2,6
    // 2 -> 3,4,1
    // 3 -> 2
    // 4 -> 2,5
    // 5 -> 4,8
    // 6 -> 1,7,9
    // 7 -> 6,8
    // 8 -> 5,7
    // 9 -> 6
    int[][] graph = {
      {1, 2}, {1, 6},
      {2, 3}, {2, 4}, {2, 1},
      {3, 2},
      {4, 2}, {4, 5},
      {5, 4}, {5, 8},
      {6, 1}, {6, 7}, {6, 9},
      {7, 6}, {7, 8},
      {8, 5}, {8, 7},
      {9, 6}
    };

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertTrue(visited[3]);
    Assertions.assertTrue(visited[4]);
    Assertions.assertTrue(visited[5]);
    Assertions.assertTrue(visited[6]);
    Assertions.assertTrue(visited[7]);
    Assertions.assertTrue(visited[8]);
    Assertions.assertTrue(visited[9]);
  }

  @Test
  void testDepthFirstSearchWithIsolatedStartNode() {
    // Node 1 is isolated; DFS always starts from 1
    int[][] graph = {{2, 3}, {3, 4}};

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertFalse(visited[2]);
    Assertions.assertFalse(visited[3]);
    Assertions.assertFalse(visited[4]);
  }

  @Test
  void testDepthFirstSearchWithSeparateComponents() {
    int[][] graph = {{1, 2}, {3, 4}};

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertFalse(visited[3]);
    Assertions.assertFalse(visited[4]);
  }

  @Test
  void testDepthFirstSearchOnSimpleCycleGraph() {
    int[][] graph = {{1, 2}, {2, 3}, {3, 1}};

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertTrue(visited[3]);
  }

  @Test
  void testDepthFirstSearchOnSingleNodeGraph() {
    // Represent single node with a self-loop so it appears in adjacency list
    int[][] graph = {{1, 1}};

    boolean[] visited = depthFirstSearch.depthFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
  }
}

