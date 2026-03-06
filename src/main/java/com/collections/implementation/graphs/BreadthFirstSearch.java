package com.collections.implementation.graphs;

import java.util.*;

public class BreadthFirstSearch {

  boolean[] visitedArray;
  ArrayDeque<Integer> printQueue;
  AdjacencyLists adjacencyList;

  public BreadthFirstSearch() {
    this.visitedArray = new boolean[10];
    this.printQueue = new ArrayDeque<Integer>();
    this.adjacencyList = new AdjacencyLists();
  }

  public boolean[] breadFirstSearch(int[][] graph) {

    ArrayList<ArrayList<Integer>> adjList = adjacencyList.designUndirectedAdjacencyList(graph);
    visitedArray = new boolean[adjList.size()];
    printQueue.add(1);
    visitedArray[1] = true;

    while (!printQueue.isEmpty()) {
          Integer node = printQueue.poll();
          System.out.print(node + "->");

          for (Integer val : adjList.get(node)) {
                if (visitedArray[val] == false) {
                      visitedArray[val] = true;
                      printQueue.add(val);
                }
          }
    }

    return visitedArray;
  }
}
