package com.collections.implementation.tree.binary.search.tree;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTests {

    private BinarySearchTree root;

    @BeforeEach
    void setUp() {
        root = new BinarySearchTree(50);
    }

    @Test
    void insertingValuesKeepsSortedInOrderTraversal() {
        int[] values = {30, 70, 20, 40, 60, 80};
        for (int value : values) {
            root = root.insert(root, value);
        }
        assertEquals("20 30 40 50 60 70 80 ", inOrder(root));
    }

    @Test
    void searchOutputsFoundMessage() {
        root = root.insert(root, 25);
        ByteArrayOutputStream printed = captureSearchOutput(root, 25);
        assertTrue(printed.toString().contains("Data Found"));
    }

    @Test
    void deletingNodesRemovesThemFromTraversal() {
        int[] values = {30, 70, 20, 40, 60, 80};
        for (int value : values) {
            root = root.insert(root, value);
        }
        root = root.delete(root, 70);
        root = root.delete(root, 30);
        assertEquals("20 50 60 ", inOrder(root));
    }

    private String inOrder(BinarySearchTree node) {
        if (node == null) {
            return "";
        }
        return inOrder(node.left) + node.data + " " + inOrder(node.right);
    }

    private ByteArrayOutputStream captureSearchOutput(BinarySearchTree tree, int value) {
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(captured));
        try {
            tree.search(tree, value, 1);
        } finally {
            System.setOut(original);
        }
        return captured;
    }
}
