package com.collections.implementation.graphs;

import org.junit.jupiter.api.*;

public class BFSTests {

  BreadthFirstSearch breadthFirstSearch;

  @BeforeEach
  void setup() {
    breadthFirstSearch = new BreadthFirstSearch();
  }

  @AfterEach
  void tearDown() {
    breadthFirstSearch = null;
  }

  @Test
  void testBreadFirstSearchOnConnectedGraph() {
    int[][] graph = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};

    boolean[] visited = breadthFirstSearch.breadFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertTrue(visited[3]);
    Assertions.assertTrue(visited[4]);
    Assertions.assertTrue(visited[5]);
  }

  @Test
  void testBreadFirstSearchWithUnreachableNodes() {
    int[][] graph = {{1, 2}, {2, 3}, {4, 5}};

    boolean[] visited = breadthFirstSearch.breadFirstSearch(graph);

    Assertions.assertNotNull(visited);
    Assertions.assertTrue(visited[1]);
    Assertions.assertTrue(visited[2]);
    Assertions.assertTrue(visited[3]);
    Assertions.assertFalse(visited[4]);
    Assertions.assertFalse(visited[5]);
  }

  @Test
  void testBreadFirstSearchWithExplicitAdjacencyExample() {
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

    boolean[] visited = breadthFirstSearch.breadFirstSearch(graph);

    Assertions.assertNotNull(visited);
    // BFS starts from 1 in BreadthFirstSearch, so all nodes 1..9 should be reachable and visited
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
}
