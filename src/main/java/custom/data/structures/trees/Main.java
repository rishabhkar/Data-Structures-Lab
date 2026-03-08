package custom.data.structures.trees;

import custom.data.structures.trees.binary.search.tree.BinarySearchTree;
import custom.data.structures.trees.binary.tree.BinaryTreeStructure;

/**
 * Simple runner for the trees package.
 */
public class Main {

  public static void main(String[] args) {
    BinaryTreeStructure node = new BinaryTreeStructure(10);
    System.out.println("Binary tree preorder:");
    node.printTree(node);
    System.out.println();

    BinarySearchTree root = new BinarySearchTree(50);
    root = root.insert(root, 30);
    root = root.insert(root, 70);
    root = root.insert(root, 20);
    root = root.insert(root, 40);

    System.out.println("BST search output:");
    root.search(root, 40, 0);

    root = root.delete(root, 20);
    System.out.println("BST search after delete:");
    root.search(root, 20, 0);
  }
}
