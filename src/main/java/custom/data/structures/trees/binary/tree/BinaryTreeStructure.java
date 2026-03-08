package custom.data.structures.trees.binary.tree;

/**
 * Simple binary tree node.
 * It stores one value and links to left and right children.
 */
public class BinaryTreeStructure {

      int data;
      BinaryTreeStructure left;
      BinaryTreeStructure right;

      /**
       * Creates one binary tree node.
       * @param data value stored in the node
       */
      public BinaryTreeStructure(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
      }

      /**
       * Prints the tree using preorder traversal.
       * @param node node to start printing from
       */
      public void printTree(BinaryTreeStructure node) {

            // Preorder printing
            System.out.print(node.data + "\t");
            if (node.left != null) printTree(node.left);
            if (node.right != null) printTree(node.right);

      }

}
