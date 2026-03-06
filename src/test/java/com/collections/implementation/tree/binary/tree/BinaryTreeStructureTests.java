package com.collections.implementation.tree.binary.tree;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeStructureTests {

    @Test
    void printTreeProducesPreOrderString() {
        BinaryTreeStructure root = new BinaryTreeStructure(1);
        BinaryTreeStructure left = new BinaryTreeStructure(2);
        BinaryTreeStructure right = new BinaryTreeStructure(3);
        BinaryTreeStructure leftLeft = new BinaryTreeStructure(4);

        root.left = left;
        root.right = right;
        left.left = leftLeft;

        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(captured));
        try {
            root.printTree(root);
        } finally {
            System.setOut(original);
        }

        String printed = captured.toString().trim();
        assertTrue(printed.startsWith("1"));
        assertTrue(printed.contains("2"));
        assertTrue(printed.contains("4"));
        assertTrue(printed.contains("3"));
    }
}

