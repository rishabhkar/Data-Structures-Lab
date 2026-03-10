package custom.data.structures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Depth First Search Tests")
class DepthFirstSearchTests {

    private DepthFirstSearch depthFirstSearch;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        depthFirstSearch = new DepthFirstSearch();
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("DFS should mark connected nodes as visited")
    void dfsMarksConnectedNodesAsVisited() {
        boolean[] visited = depthFirstSearch.depthFirstSearch(new int[][]{{1, 2}, {1, 3}, {3, 4}});
        printValue("Visited 1", visited[1]);
        printValue("Visited 4", visited[4]);
        assertTrue(visited[1]);
        assertTrue(visited[2]);
        assertTrue(visited[3]);
        assertTrue(visited[4]);
    }
}

