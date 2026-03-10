package custom.data.structures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Breadth First Search Tests")
class BreadthFirstSearchTests {

    private BreadthFirstSearch breadthFirstSearch;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        breadthFirstSearch = new BreadthFirstSearch();
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("BFS should mark connected nodes as visited")
    void bfsMarksConnectedNodesAsVisited() {
        boolean[] visited = breadthFirstSearch.breadFirstSearch(new int[][]{{1, 2}, {1, 3}, {3, 4}});
        printValue("Visited 1", visited[1]);
        printValue("Visited 4", visited[4]);
        assertTrue(visited[1]);
        assertTrue(visited[2]);
        assertTrue(visited[3]);
        assertTrue(visited[4]);
    }
}

