package custom.data.structures.stacks;

/**
 * Simple stack node used for a linked-list stack.
 * The same class stores node data and stack helper methods.
 */
public class DynamicStackLinkedList {

  public int data;
  public DynamicStackLinkedList next;

  /**
   * Creates one stack node.
   * @param data value stored in the node
   */
  public DynamicStackLinkedList(int data) {
    this.data = data;
    this.next = null;
  }

  /**
   * Pushes a new value to the front of the stack.
   * @param head current top node
   * @param data value to push
   * @return new top node
   */
  public DynamicStackLinkedList push(DynamicStackLinkedList head, int data) {

    DynamicStackLinkedList dynamicStackObject = new DynamicStackLinkedList(data);
    dynamicStackObject.next = head;
    return dynamicStackObject;
  }

  /**
   * Removes the top node from the stack.
   * @param head current top node
   * @return next node after removing the top
   */
  public DynamicStackLinkedList pop(DynamicStackLinkedList head) {
    if (head == null) return null;
    return head.next;
  }

  /**
   * Counts how many nodes are in the stack.
   * @param head current top node
   * @return number of nodes
   */
  public int getSize(DynamicStackLinkedList head) {
    DynamicStackLinkedList pointer = head;
    int counter = 0;

    while (pointer != null) {
      pointer = pointer.next;
      counter++;
    }
    return counter;
  }

  /**
   * Returns the value at the top node.
   * @param head current top node
   * @return top value
   */
  public int getTop(DynamicStackLinkedList head) {
    return head.data;
  }
}
