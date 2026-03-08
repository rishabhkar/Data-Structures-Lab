package custom.data.structures.graphs;

import java.util.*;

/**
 * Runs a simple depth-first search on an undirected graph.
 * The graph is first converted into an adjacency list.
 */
public class DepthFirstSearch {

  AdjacencyLists adjacencyList;
  boolean[] visited;

  /**
   * Creates helper objects used during DFS.
   */
  public DepthFirstSearch() {
    this.adjacencyList = new AdjacencyLists();
    this.visited = new boolean[10];
  }

  /**
   * Runs depth-first search starting from node 1.
   * @param graph edge list input
   * @return visited state for each node
   */
  public boolean[] depthFirstSearch(int[][] graph) {

    ArrayList<ArrayList<Integer>> adjList = adjacencyList.designUndirectedAdjacencyList(graph);
    visited = new boolean[adjList.size()];

    visited[0] = true;

    dfs(adjList, 1);

    return visited;
  }

  /**
   * Visits connected nodes recursively.
   * @param adjList adjacency list of the graph
   * @param index current node index
   */
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
