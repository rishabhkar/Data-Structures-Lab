package custom.data.structures.linkedLists;

/**
 * Simple singly linked list node.
 * The same class also provides basic linked list operations.
 * @param <T> type of value stored in the node
 */
public class DoublyLinkedList<T> {

  private T node;
  private DoublyLinkedList<T> next;
  private DoublyLinkedList<T> previous;

  /**
   * Creates one doubly linked list node.
   * @param value value stored in the node
   * @throws IllegalArgumentException when value is null
   */
  public DoublyLinkedList(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Value passed is not correct");
    }
    this.node = value;
    this.next = null;
    this.previous = null;
  }

  /**
   * Returns the value stored in this node.
   * @return current node value
   */
  public T getNode() {
    return this.node;
  }

  /**
   * Returns the next node.
   * @return next linked node or null
   */
  public DoublyLinkedList<T> getNext() {
    return this.next;
  }

  public DoublyLinkedList<T> getPrevious() { return this.previous; }

  /**
   * Inserts a new node at the start of the list.
   * @param head current head node
   * @param value value to insert
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   */
  public DoublyLinkedList<T> insertAtBeginning(DoublyLinkedList<T> head, T value) {

    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    DoublyLinkedList<T> newNode = new DoublyLinkedList<>(value);
    newNode.next = head;
    head.previous = newNode;

    return newNode;
  }

  /**
   * Inserts a new node at the end of the list.
   * @param head current head node
   * @param value value to insert
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   */
  public DoublyLinkedList<T> insertAtEnd(DoublyLinkedList<T> head, T value) {

    // Case 1: If value passed is null -> Argument is illegal -> Throw exception
    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    // Case 2: If head is null -> Create and return a single node list
    if (head == null) {
      return new DoublyLinkedList<>(value);
    }

    // Case 3: Normal insert at the end of the list
    DoublyLinkedList<T> newNode = new DoublyLinkedList<>(value);
    DoublyLinkedList<T> temporaryNode = head;

    while (temporaryNode.next != null) {
      temporaryNode = temporaryNode.next;
    }

    temporaryNode.next = newNode;
    newNode.previous = temporaryNode;

    return head;
  }

  /**
   * Inserts a new node at the given index.
   * @param head current head node
   * @param value value to insert
   * @param index position where the node should be inserted
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   * @throws IndexOutOfBoundsException when index is invalid
   */
  public DoublyLinkedList<T> insertAtIndex(DoublyLinkedList<T> head, T value, int index) {

    // Case 1: If value passed is null -> Argument is illegal -> Throw exception
    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    // Case 2: If index is negative -> Index is invalid -> Throw exception
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    // Case 3: If index is zero -> Insert at beginning logic should handle it
    if (index == 0) {
      return insertAtBeginning(head, value);
    }

    // Case 4: If head is null -> List does not exist -> Throw exception
    if (head == null) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    int counter = 0;
    DoublyLinkedList<T> previousNode = head;

    while (counter < index - 1 && previousNode != null) {
      previousNode = previousNode.next;
      counter++;
    }

    // Case 5: If previous node is invalid -> Index is outside the list -> Throw exception
    if (previousNode == null && previousNode.next == null) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    // Case 6: Normal insert in the middle or near the end of the list
    DoublyLinkedList<T> newNode = new DoublyLinkedList<>(value);
    newNode.next = previousNode.next;
    previousNode.next = newNode;
    newNode.previous = previousNode;
    newNode.next.previous = newNode;

    return head;
  }

  /**
   * Prints the list from start to end using a loop.
   * @param head head node of the list
   */
  public void printIterative(DoublyLinkedList<T> head) {

    DoublyLinkedList<T> temporaryNode = head;

    while (temporaryNode != null) {
      System.out.print(temporaryNode.node + ((temporaryNode.next != null) ? "->" : ""));
      temporaryNode = temporaryNode.next;
    }
    System.out.println();
  }

  /**
   * Prints the list from start to end using recursion.
   * @param head head node of the list
   */
  public void printRecursive(DoublyLinkedList<T> head) {

    if (head == null) {
      System.out.println();
      return;
    }

    System.out.print(head.node + ((head.next != null) ? "->" : ""));

    if (head.next == null) {
      System.out.println();
      return;
    }

    printRecursive(head.next);
  }

  /**
   * Deletes the first node with the given value.
   * @param head current head node
   * @param value value to delete
   * @return updated head node
   * @throws IllegalArgumentException when head is null or value is null
   */
  public DoublyLinkedList<T> deleteByValue(DoublyLinkedList<T> head, T value) {

    // Case 1: If head or value is null -> Argument is illegal -> Throw exception
    if (head == null || value == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: If value is present at head -> Remove head logic runs
    if (head.node.equals(value)) {
      head.next.previous = null;
      head = null;
      return head;
    }

    DoublyLinkedList<T> temporaryNode = head;

    // Case 3: Parse through the list until the matching value is found or list ends
    while (temporaryNode.next != null && !temporaryNode.next.node.equals(value)) {
      temporaryNode = temporaryNode.next;
    }

    // Case 4: If value is found away from head -> Bypass that node and fix previous link
    if (temporaryNode.next != null) {
      temporaryNode.next = temporaryNode.next.next;
      temporaryNode.next.previous = temporaryNode;
    }

    return head;
  }

  /**
   * Deletes the last node from the list.
   * @param head current head node
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   */
  public DoublyLinkedList<T> deleteFromEnd(DoublyLinkedList<T> head) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: If only one node exists -> Return null
    if (head.next == null) {
      return null;
    }

    // Case 3: Parse till the second last node and disconnect the last node
    DoublyLinkedList<T> temporaryNode = head;

    while (temporaryNode.next.next != null) {
      temporaryNode = temporaryNode.next;
    }

    temporaryNode.next.previous = null;
    temporaryNode.next = null;

    return head;
  }

  /**
   * Deletes the first node from the list.
   * @param head current head node
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   */
  public DoublyLinkedList<T> deleteFromBeginning(DoublyLinkedList<T> head) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: Move head to the next node and clear old links
    DoublyLinkedList<T> temporaryNode = head;
    head = head.next;
    temporaryNode.next = null;
    head.previous = null;

    return head;
  }

  /**
   * Deletes the node at the given index.
   * @param head current head node
   * @param value unused compatibility parameter
   * @param index position to delete
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   * @throws IndexOutOfBoundsException when index is invalid
   */
  public DoublyLinkedList<T> deleteAtIndex(DoublyLinkedList<T> head, T value, int index) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    // Case 2: If index is negative -> Index is invalid -> Throw exception
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    // Case 3: If index is zero -> Remove head and return next node
    if (index == 0) {
      return head.next;
    }

    int counter = 0;
    DoublyLinkedList<T> previousNode = head;

    while (counter < index - 1 && previousNode != null) {
      previousNode = previousNode.next;
      counter++;
    }

    // Case 4: If node before target is invalid -> Throw exception
    if (previousNode == null || previousNode.next == null) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    // Case 5: Normal delete from the middle or end of the list
    if (previousNode.next.next != null) {
      previousNode.next.next.previous = previousNode;
      previousNode.next = previousNode.next.next;
    } else {
      previousNode.next = null;
    }

    return head;
  }

  /**
   * Reverses the list.
   * @param head current head node
   * @return new head after reversing the list
   */
  public DoublyLinkedList<T> reverse(DoublyLinkedList<T> head) {

    DoublyLinkedList<T> previousNode = null;
    DoublyLinkedList<T> currentNode = head;

    while (currentNode != null) {
      // Assign a new pointer to point towards next node
      DoublyLinkedList<T> nextNode = currentNode.next;

      // Change current node pointers
      currentNode.next = previousNode;
      currentNode.previous = nextNode;

      previousNode = currentNode;
      currentNode = nextNode;
    }

    return previousNode;
  }
}
