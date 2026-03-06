package com.collections.implementation.graphs;

import java.util.*;

public class AdjacencyLists {

  public record weightedRelation(Integer node, Integer weight) {}
  ;

  ArrayList<ArrayList<Integer>> adjList;
  ArrayList<ArrayList<weightedRelation>> weightedAdjList;

  public AdjacencyLists() {
    this.adjList = new ArrayList<>();
    this.weightedAdjList = new ArrayList<>();
  }

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
