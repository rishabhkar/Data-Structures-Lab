package custom.data.structures.trees.binary.search.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Binary Search Tree Tests")
class BinarySearchTreeTests {

    private BinarySearchTree root;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        root = new BinarySearchTree(50);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Insert should place smaller and larger values correctly")
    void insertPlacesSmallerAndLargerValuesCorrectly() {
        root = root.insert(root, 30);
        root = root.insert(root, 70);
        printValue("Left child", root.left.data);
        printValue("Right child", root.right.data);
        assertEquals(30, root.left.data);
        assertEquals(70, root.right.data);
    }

    @Test
    @DisplayName("Search should print the level when data is found")
    void searchPrintsLevelWhenDataIsFound() {
        root = root.insert(root, 30);
        root = root.insert(root, 20);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            root.search(root, 20, 0);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "").trim();
        printValue("Search output", printed);
        assertEquals("Data Found at level 2", printed);
    }

    @Test
    @DisplayName("Search should print not found when data is missing")
    void searchPrintsNotFoundWhenDataIsMissing() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            root.search(root, 99, 0);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "").trim();
        printValue("Search output", printed);
        assertEquals("Data not found", printed);
    }

    @Test
    @DisplayName("Delete should remove a leaf node")
    void deleteRemovesLeafNode() {
        root = root.insert(root, 30);
        root = root.insert(root, 70);
        root = root.delete(root, 30);
        printValue("Left child after delete", root.left);
        assertNull(root.left);
        assertEquals(70, root.right.data);
    }
}

