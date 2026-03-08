package custom.data.structures.graphs;

import java.util.*;

/**
 * Small record used in weighted adjacency lists.
 * It stores the target node and the edge weight.
 */
record weightedRelation(Integer node, Integer weight) {}

/**
 * Builds adjacency list representations for graphs.
 * It supports simple directed, undirected, and weighted cases.
 */
public class AdjacencyLists {

  ArrayList<ArrayList<Integer>> adjList;
  ArrayList<ArrayList<weightedRelation>> weightedAdjList;

  /**
   * Creates empty adjacency list containers.
   */
  public AdjacencyLists() {
    this.adjList = new ArrayList<>();
    this.weightedAdjList = new ArrayList<>();
  }

  /**
   * Builds an undirected adjacency list.
   * @param graph edge list input
   * @return generated adjacency list
   */
  public ArrayList<ArrayList<Integer>> designUndirectedAdjacencyList(int[][] graph) {

    int max = 0;

    for (int[] row : graph) {
      for (int value : row) {
        max = Math.max(max, value);
      }
    }

    for (int i = 0; i <= max + 1; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < graph.length; i++) {
      adjList.get(graph[i][0]).add(graph[i][1]);
      adjList.get(graph[i][1]).add(graph[i][0]);
    }

    printAdjacencyList();

    return adjList;
  }

  /**
   * Prints the simple adjacency list.
   */
  public void printAdjacencyList() {
    for (ArrayList<Integer> list : adjList) {
      System.out.print("{");
      for (Integer val : list) {
        System.out.print(val + "  ");
      }
      System.out.print("}");
      System.out.println(" ");
    }
  }

  /**
   * Builds a directed adjacency list.
   * @param graph edge list input
   * @return generated adjacency list
   */
  public ArrayList<ArrayList<Integer>> designDirectedAdjacencyList(int[][] graph) {

    int max = 0;

    for (int[] row : graph) {
      for (int value : row) {
        max = Math.max(max, value);
      }
    }

    for (int i = 0; i <= max + 1; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < graph.length; i++) {
      adjList.get(graph[i][0]).add(graph[i][1]);
    }

    printAdjacencyList();

    return adjList;
  }

  /**
   * Prints the weighted adjacency list.
   */
  public void printWeightedAdjacencyList() {
    for (ArrayList<weightedRelation> list : weightedAdjList) {
      System.out.print("{");
      for (weightedRelation rel : list) {
        System.out.print(rel.node() + "(" + rel.weight() + ")  ");
      }
      System.out.print("}");
      System.out.println(" ");
    }
  }

  /**
   * Builds a weighted undirected adjacency list.
   * @param graph weighted edge list input
   * @return generated weighted adjacency list
   */
  public ArrayList<ArrayList<weightedRelation>> designWeightedUndirectedAdjacencyList(
      int[][] graph) {

    int max = 0;

    for (int[] row : graph) {
      for (int value : row) {
        max = Math.max(max, value);
      }
    }

    for (int i = 0; i <= max + 1; i++) {
      weightedAdjList.add(new ArrayList<weightedRelation>());
    }

    for (int i = 0; i < graph.length; i++) {
      weightedRelation weightedNode = new weightedRelation(graph[i][1], graph[i][2]);
      weightedAdjList.get(graph[i][0]).add(weightedNode);

      weightedNode = new weightedRelation(graph[i][0], graph[i][2]);
      weightedAdjList.get(graph[i][1]).add(weightedNode);
    }

    printWeightedAdjacencyList();

    return weightedAdjList;
  }
}
