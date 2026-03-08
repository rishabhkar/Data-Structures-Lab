package custom.data.structures.trees.binary.search.tree;

/**
 * Simple binary search tree node.
 * It also contains the basic insert, search, and delete operations.
 */
public class BinarySearchTree {

  int data;
  BinarySearchTree left;
  BinarySearchTree right;

  /**
   * Creates one tree node.
   * @param data value stored in the node
   */
  public BinarySearchTree(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  /**
   * Inserts a value into the BST.
   * @param parent current root node
   * @param data value to insert
   * @return updated root node
   */
  public BinarySearchTree insert(BinarySearchTree parent, int data) {

    if (parent == null) return new BinarySearchTree(data);

    if (data < parent.data) parent.left = insert(parent.left, data);
    if (data > parent.data) parent.right = insert(parent.right, data);
    return parent;
  }

  /**
   * Searches for a value and prints the level.
   * @param parent current root node
   * @param data value to search
   * @param level current tree level
   */
  public void search(BinarySearchTree parent, int data, int level) {

    if (parent == null) {
      System.out.println("Data not found");
      return;
    }

    if (data == parent.data) {
      System.out.println("Data Found at level " + level);
      return;
    }

    if (data < parent.data) search(parent.left, data, level + 1);
    if (data > parent.data) search(parent.right, data, level + 1);
  }

  /**
   * Deletes a value from the BST.
   * @param root current root node
   * @param data value to delete
   * @return updated root node
   */
  public BinarySearchTree delete(BinarySearchTree root, int data) {

    // Case 1: Complete tree is null
    if (root == null) return null;

    BinarySearchTree parent = null;
    BinarySearchTree current = root;

    while (current != null && current.data != data) {
      parent = current;
      current = (data < current.data) ? current.left : current.right;
    }

    // Case 2: No data found
    if (current == null) {
      System.out.println("Data not found");
      return root;
    }

    // Case 3: Deletion from leaf node
    if (current.left == null && current.right == null) {
      if (parent == null) return null;
      if (parent.left == current) parent.left = null;
      else parent.right = null;
      return root;
    }

    // Case 4: Deletion from the middle with 1 child node (Parent should point to child)

    if ((current.left != null || current.right == null)
        || (current.left == null && current.right != null)) {

      BinarySearchTree child = (current.left != null) ? current.left : current.right;

      if (parent == null) return child; // deleting root

      if (parent.left == current) parent.left = child;
      else parent.right = child;

      return root;
    }

    // Case 4: Deletion from middle with 2 child nodes (take right as replacement)
    if (current.left != null && current.right != null) {

      BinarySearchTree child = current.right; // replacement (right subtree root)

      // put current.left under the leftmost node of the right subtree
      BinarySearchTree temp = child;
      while (temp.left != null) temp = temp.left;
      temp.left = current.left;

      if (parent == null) return child; // deleting root

      if (parent.left == current) parent.left = child;
      else parent.right = child;

      return root;
    }
    return root;
  }
}
