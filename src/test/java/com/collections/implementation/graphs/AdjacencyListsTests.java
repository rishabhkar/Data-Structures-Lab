package com.collections.implementation.graphs;

import org.junit.jupiter.api.*;

import java.util.*;

public class AdjacencyListsTests {

  AdjacencyLists adjacencyLists;

  @BeforeEach
  void setup() {
    adjacencyLists = new AdjacencyLists();
  }

  @AfterEach
  void tearDown() {
    adjacencyLists = null;
  }

  @Test
  void testAdjacencyMatrixDesignForUndirectedGraph() {
    int[][] graph = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};

    ArrayList<ArrayList<Integer>> list = adjacencyLists.designUndirectedAdjacencyList(graph);

    Assertions.assertNotNull(list);
    Assertions.assertTrue(list.get(1).contains(2));
    Assertions.assertTrue(list.get(1).contains(3));
    Assertions.assertTrue(list.get(2).contains(4));
    Assertions.assertTrue(list.get(2).contains(5));
    Assertions.assertTrue(list.get(5).contains(2));
    Assertions.assertTrue(list.get(5).contains(4));
  }

  @Test
  void testAdjacencyMatrixDesignForDirectedGraph() {
    int[][] graph = {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}, {4, 5}};

    ArrayList<ArrayList<Integer>> list = adjacencyLists.designDirectedAdjacencyList(graph);

    Assertions.assertNotNull(list);
    Assertions.assertTrue(list.get(1).contains(2));
    Assertions.assertTrue(list.get(1).contains(3));
    Assertions.assertTrue(list.get(2).contains(4));
    Assertions.assertTrue(list.get(3).contains(4));
    Assertions.assertTrue(list.get(2).contains(5));
    Assertions.assertTrue(list.get(4).contains(5));
  }

  @Test
  void testWeightedAdjacencyListDesignForUndirectedGraph() {
    int[][] graph = {{1, 2, 3}, {1, 3, 2}, {3, 4, 10}, {2, 4, 3}, {2, 5, 7}, {4, 5, 9}};

    ArrayList<ArrayList<AdjacencyLists.weightedRelation>> list =
        adjacencyLists.designWeightedUndirectedAdjacencyList(graph);

    Assertions.assertNotNull(list);
    Assertions.assertTrue(
        list.get(1).contains(new AdjacencyLists.weightedRelation(2, 3)));
    Assertions.assertTrue(
        list.get(2).contains(new AdjacencyLists.weightedRelation(1, 3)));
    Assertions.assertTrue(
        list.get(1).contains(new AdjacencyLists.weightedRelation(3, 2)));
    Assertions.assertTrue(
        list.get(3).contains(new AdjacencyLists.weightedRelation(1, 2)));
    Assertions.assertTrue(
        list.get(3).contains(new AdjacencyLists.weightedRelation(4, 10)));
    Assertions.assertTrue(
        list.get(4).contains(new AdjacencyLists.weightedRelation(3, 10)));
    Assertions.assertTrue(
        list.get(2).contains(new AdjacencyLists.weightedRelation(4, 3)));
    Assertions.assertTrue(
        list.get(4).contains(new AdjacencyLists.weightedRelation(2, 3)));
    Assertions.assertTrue(
        list.get(2).contains(new AdjacencyLists.weightedRelation(5, 7)));
    Assertions.assertTrue(
        list.get(5).contains(new AdjacencyLists.weightedRelation(2, 7)));
    Assertions.assertTrue(
        list.get(4).contains(new AdjacencyLists.weightedRelation(5, 9)));
    Assertions.assertTrue(
        list.get(5).contains(new AdjacencyLists.weightedRelation(4, 9)));
  }
}
