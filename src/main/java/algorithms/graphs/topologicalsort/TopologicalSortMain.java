package algorithms.graphs.topologicalsort;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner for the topological sort example.
 */
public class TopologicalSortMain {

  private static final Logger log = LoggerFactory.getLogger(TopologicalSortMain.class);

  /**
   * Creates the sample adjacency list and logs it for quick testing.
   *
   * <p>Adjacency list used:
   * 0 -> {}
   * 1 -> {}
   * 2 -> {3}
   * 3 -> {1}
   * 4 -> {0, 1}
   * 5 -> {0, 2}
   */
  public static void main(String[] args) {
    runDfsTest();
    runKahnTest();
    runCycleTest();
  }

  private static void runDfsTest() {
    List<List<Integer>> adjacencyList = Arrays.asList(
        new ArrayList<>(),
        new ArrayList<>(),
        Arrays.asList(3),
        Arrays.asList(1),
        Arrays.asList(0, 1),
        Arrays.asList(0, 2)
    );
    TopologicalSort topologicalSort = new TopologicalSort();
    log.info("[DFS] Adjacency list: {}", adjacencyList);
    log.info("[DFS] Topological order: {}", topologicalSort.topologicalSortDfs(adjacencyList));
  }

  private static void runKahnTest() {
    List<List<Integer>> adjacencyList = Arrays.asList(
        new ArrayList<>(),
        new ArrayList<>(),
        Arrays.asList(3),
        Arrays.asList(1),
        Arrays.asList(0, 1),
        Arrays.asList(0, 2)
    );
    TopologicalSort topologicalSort = new TopologicalSort();
    log.info("[Kahn] Adjacency list: {}", adjacencyList);
    log.info("[Kahn] Topological order: {}", topologicalSort.kahnsAlgorithm(adjacencyList));
  }

  private static void runCycleTest() {
    // Simple cyclic graph: 0 -> 1 -> 2 -> 0
    List<List<Integer>> cyclic = Arrays.asList(
        Arrays.asList(1),
        Arrays.asList(2),
        Arrays.asList(0)
    );
    TopologicalSort topologicalSort = new TopologicalSort();
    log.info("[Cycle] Adjacency list: {}", cyclic);
    log.info("[Cycle] Kahn result (empty if cycle detected): {}", topologicalSort.kahnsAlgorithm(cyclic));
  }
}
