package algorithms.graphs.topologicalsort;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Produces a topological ordering for a directed acyclic graph.
 */
@Slf4J
public class TopologicalSort {

    private static final Logger log = LoggerFactory.getLogger(TopologicalSort.class);

    /**
     * Returns a topological ordering for the given adjacency list.
     *
     * @param adjacencyList directed graph where each index stores outgoing edges
     * @return nodes in topological order
     */
    public List<Integer> topologicalSortDfs(List<List<Integer>> adjacencyList) {
        log.info("Starting topological sort for {} nodes", adjacencyList.size());
        int size = adjacencyList.size();
        boolean[] vis = new boolean[size];
        Stack<Integer> storeStack = new Stack<>();

        for (int i = 0; i < size; i++) {
            if (!vis[i]) {
                // Visit every node so disconnected components are also included.
                dfs(i, vis, storeStack, adjacencyList);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!storeStack.empty()) {
            answer.add(storeStack.peek());
            storeStack.pop();
        }
        log.info("Topological order computed: {}", answer);
        return answer;
    }

    /**
     * Depth-first traversal that pushes a node after all of its neighbours.
     *
     * @param node          current node
     * @param vis           visited markers
     * @param storeStack    stack used to reverse the DFS finish order
     * @param adjacencyList directed graph adjacency list
     */
    private void dfs(Integer node, boolean[] vis,
                     Stack<Integer> storeStack, List<List<Integer>> adjacencyList) {
        vis[node] = true;
        log.debug("Visiting node {}", node);

        for (Integer it : adjacencyList.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, storeStack, adjacencyList);
            }
        }
        storeStack.push(node);
        log.debug("Pushed node {}", node);
    }


    /**
     * Produces a topological ordering of the given directed graph using Kahn's algorithm.
     *
     * <p>The input is an adjacency list where the index represents a node and the list at that
     * index contains all outgoing neighbours. The method returns a list of nodes in a valid
     * topological order when the graph is a DAG. If the graph contains a cycle, an empty list
     * is returned and a warning is logged.
     *
     * <p>Time complexity: O(V + E), where V is the number of nodes and E the number of edges.
     * Space complexity: O(V).
     *
     * @param adjacencyList directed graph adjacency list
     * @return nodes in topological order, or an empty list if the graph contains a cycle
     */
    public List<Integer> kahnsAlgorithm(List<List<Integer>> adjacencyList) {
        log.info("Starting Kahn's algorithm for {} nodes", adjacencyList.size());

        int size = adjacencyList.size();
        int[] indegree = new int[size];

        // Compute indegrees for all nodes.
        for (int i = 0; i < size; i++) {
            for (int it : adjacencyList.get(i)) {
                indegree[it]++;
            }
        }
        log.debug("Computed indegrees: {}", Arrays.toString(indegree));

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        log.debug("Initial zero-indegree nodes: {}", queue);

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll(); // remove from queue
            log.debug("Processing node {}", node);
            ans.add(node);

n            for (Integer it : adjacencyList.get(node)) {
                indegree[it]--;
                log.debug("Decremented indegree of {}: {}", it, indegree[it]);
                if (indegree[it] == 0) {
                    queue.add(it);
                    log.debug("Node {} now has zero indegree, added to queue", it);
                }
            }
        }

n        if (ans.size() != size) {
            // Graph has a cycle; Kahn's algorithm couldn't include all nodes.
            log.warn("Cycle detected: graph is not a DAG, topological ordering not possible");
            return Collections.emptyList();
        }

n        log.info("Kahn's algorithm produced order: {}", ans);
        return ans;
    }

}
