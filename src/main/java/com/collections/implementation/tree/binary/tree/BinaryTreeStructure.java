package com.collections.implementation.tree.binary.tree;

public class BinaryTreeStructure {

      int data;
      BinaryTreeStructure left;
      BinaryTreeStructure right;

      public BinaryTreeStructure(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
      }

      public void printTree(BinaryTreeStructure node) {

            // Preorder printing
            System.out.print(node.data + "\t");
            if (node.left != null) printTree(node.left);
            if (node.right != null) printTree(node.right);

      }

}
