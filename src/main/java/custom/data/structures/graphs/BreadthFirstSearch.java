package custom.data.structures.graphs;

import java.util.*;

/**
 * Runs a simple breadth-first search on an undirected graph.
 * The graph is first converted into an adjacency list.
 */
public class BreadthFirstSearch {

  boolean[] visitedArray;
  ArrayDeque<Integer> printQueue;
  AdjacencyLists adjacencyList;

  /**
   * Creates helper objects used during BFS.
   */
  public BreadthFirstSearch() {
    this.visitedArray = new boolean[10];
    this.printQueue = new ArrayDeque<Integer>();
    this.adjacencyList = new AdjacencyLists();
  }

  /**
   * Runs breadth-first search starting from node 1.
   * @param graph edge list input
   * @return visited state for each node
   */
  public boolean[] breadFirstSearch(int[][] graph) {

    ArrayList<ArrayList<Integer>> adjList = adjacencyList.designUndirectedAdjacencyList(graph);
    visitedArray = new boolean[adjList.size()];
    printQueue.add(1);
    visitedArray[1] = true;

    while (!printQueue.isEmpty()) {
          Integer node = printQueue.poll();
          System.out.print(node + "->");

          for (Integer val : adjList.get(node)) {
                if (!visitedArray[val]) {
                      visitedArray[val] = true;
                      printQueue.add(val);
                }
          }
    }

    return visitedArray;
  }
}
