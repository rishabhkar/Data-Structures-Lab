package custom.data.structures.trees.binary.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Binary Tree Structure Tests")
class BinaryTreeStructureTests {

    private BinaryTreeStructure root;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        root = new BinaryTreeStructure(10);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Constructor should store the node value")
    void constructorStoresNodeValue() {
        printValue("Root value", root.data);
        assertEquals(10, root.data);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    @DisplayName("Print tree should follow preorder traversal")
    void printTreeFollowsPreorderTraversal() {
        root.left = new BinaryTreeStructure(5);
        root.right = new BinaryTreeStructure(20);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            root.printTree(root);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "");
        printValue("Printed tree", printed.trim());
        assertEquals("10\t5\t20\t", printed);
    }
}

