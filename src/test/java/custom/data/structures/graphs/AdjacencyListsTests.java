package custom.data.structures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Adjacency Lists Tests")
class AdjacencyListsTests {

    private AdjacencyLists adjacencyLists;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        adjacencyLists = new AdjacencyLists();
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Undirected adjacency list should add both sides")
    void undirectedAdjacencyListAddsBothSides() {
        ArrayList<ArrayList<Integer>> result = adjacencyLists.designUndirectedAdjacencyList(new int[][]{{0, 1}, {1, 2}});
        printValue("Neighbours of 1", result.get(1));
        assertTrue(result.get(0).contains(1));
        assertTrue(result.get(1).contains(0));
        assertTrue(result.get(1).contains(2));
    }

    @Test
    @DisplayName("Directed adjacency list should add one side only")
    void directedAdjacencyListAddsOneSideOnly() {
        ArrayList<ArrayList<Integer>> result = adjacencyLists.designDirectedAdjacencyList(new int[][]{{0, 1}, {1, 2}});
        printValue("Neighbours of 1", result.get(1));
        assertTrue(result.get(0).contains(1));
        assertFalse(result.get(1).contains(0));
        assertTrue(result.get(1).contains(2));
    }

    @Test
    @DisplayName("Weighted undirected adjacency list should store node and weight")
    void weightedUndirectedAdjacencyListStoresNodeAndWeight() {
        ArrayList<ArrayList<weightedRelation>> result = adjacencyLists.designWeightedUndirectedAdjacencyList(new int[][]{{0, 1, 9}});
        weightedRelation relation = result.get(0).get(0);
        printValue("Weighted relation", relation);
        assertEquals(1, relation.node());
        assertEquals(9, relation.weight());
        assertEquals(0, result.get(1).get(0).node());
    }
}

