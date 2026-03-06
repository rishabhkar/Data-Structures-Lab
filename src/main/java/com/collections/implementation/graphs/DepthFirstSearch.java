package com.collections.implementation.graphs;

import java.util.*;

public class DepthFirstSearch {

  AdjacencyLists adjacencyList;
  boolean[] visited;

  public DepthFirstSearch() {
    this.adjacencyList = new AdjacencyLists();
    this.visited = new boolean[10];
  }

  public boolean[] depthFirstSearch(int[][] graph) {

    ArrayList<ArrayList<Integer>> adjList = adjacencyList.designUndirectedAdjacencyList(graph);
    visited = new boolean[adjList.size()];

    visited[0] = true;

    dfs(adjList, 1);

    return visited;
  }

  public void dfs(ArrayList<ArrayList<Integer>> adjList, int index) {

    if (visited[index]) {
      return;
    }

    visited[index] = true;
    System.out.println(index + "->");

    if (adjList.get(index).size() != 0) {
      for (Integer value : adjList.get(index)) {
        dfs(adjList, value);
      }
    }
  }
}
