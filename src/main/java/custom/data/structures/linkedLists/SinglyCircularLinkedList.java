package custom.data.structures.linkedLists;

/**
 * Simple singly circular linked list node.
 * The same class also provides basic circular linked list operations.
 * @param <T> type of value stored in the node
 */
public class SinglyCircularLinkedList<T> {

  private T node;
  private SinglyCircularLinkedList<T> next;

  /**
   * Creates one linked list node.
   * @param value value stored in the node
   * @throws IllegalArgumentException when value is null
   */
  public SinglyCircularLinkedList(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Value passed is not correct");
    }
    this.node = value;
    this.next = null;
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
  public SinglyCircularLinkedList<T> getNext() {
    return this.next;
  }

  /**
   * Inserts a new node at the start of the list.
   * @param head current head node
   * @param value value to insert
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   */
  public SinglyCircularLinkedList<T> insertAtBeginning(SinglyCircularLinkedList<T> head, T value) {

    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    // If head is null, create a single-node circular list
    if (head == null) {
      SinglyCircularLinkedList<T> newNode = new SinglyCircularLinkedList<>(value);
      newNode.next = newNode;
      return newNode;
    }

    SinglyCircularLinkedList<T> newNode = new SinglyCircularLinkedList<>(value);

    // Find tail (node whose next points to head)
    SinglyCircularLinkedList<T> temporaryNode = head;
    while (temporaryNode.next != head) {
      if (temporaryNode.next == null) {
        throw new IllegalStateException("Singly Linked ListImplementation is not circular");
      }
      temporaryNode = temporaryNode.next;
    }

    temporaryNode.next = newNode;
    newNode.next = head;
    return newNode;
  }

  /**
   * Inserts a new node at the end of the list.
   * @param head current head node
   * @param value value to insert
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   */
  public SinglyCircularLinkedList<T> insertAtEnd(SinglyCircularLinkedList<T> head, T value) {

    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    if (head == null) {
      return new SinglyCircularLinkedList<>(value);
    }

    SinglyCircularLinkedList<T> newNode = new SinglyCircularLinkedList<>(value);
    SinglyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode.next != head) {
      temporaryNode = temporaryNode.next;
    }

    temporaryNode.next = newNode;
    newNode.next = head;

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
  public SinglyCircularLinkedList<T> insertAtIndex(SinglyCircularLinkedList<T> head, T value, int index) {

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

    // Case 4: If head is null -> ListImplementation does not exist -> Throw exception
    if (head == null) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    int counter = 0;
    SinglyCircularLinkedList<T> previousNode = head;

    // Walk index-1 steps but never loop back to head (would mean index too large)
    while (counter < index - 1) {
      previousNode = previousNode.next;
      counter++;
      if (previousNode == null || previousNode == head) {
        throw new IndexOutOfBoundsException("Index passed is not correct");
      }
    }

    // Case 6: Normal insert in the middle or near the end of the list
    SinglyCircularLinkedList<T> newNode = new SinglyCircularLinkedList<>(value);
    newNode.next = previousNode.next;
    previousNode.next = newNode;

    return head;
  }

  /**
   * Prints the list from start to end using a loop.
   * @param head head node of the list
   */
  public void printIterative(SinglyCircularLinkedList<T> head) {

    if (head == null) {
      System.out.println();
      return;
    }

    SinglyCircularLinkedList<T> temporaryNode = head;
    do {
      System.out.print(temporaryNode.node + ((temporaryNode.next != head) ? "->" : ""));
      temporaryNode = temporaryNode.next;
      if (temporaryNode == null) {
        throw new IllegalStateException("Singly Linked ListImplementation is not circular");
      }
    } while (temporaryNode != head);
    System.out.println();
  }

  /**
   * Prints the list from start to end using recursion.
   * @param head head node of the list
   * @param startPointer starts with same value as head, keeps incrementing to prevent an infinite loop
   */
  public void printRecursive(SinglyCircularLinkedList<T> head, SinglyCircularLinkedList<T> startPointer) {

    if (head == null) {
      System.out.println();
      return;
    }

    System.out.print(startPointer.node + ((startPointer.next != head) ? "->" : ""));

    if (startPointer.next == head) {
      System.out.println();
      return;
    }

    printRecursive(head, startPointer.next);
  }

  /**
   * Deletes the first node with the given value.
   * @param head current head node
   * @param value value to delete
   * @return updated head node
   * @throws IllegalArgumentException when head is null or value is null
   */
  public SinglyCircularLinkedList<T> deleteByValue(SinglyCircularLinkedList<T> head, T value) {

    // Case 1: If head or value is null -> Argument is illegal -> Throw exception
    if (head == null || value == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: If value is present at head
    if (head.node.equals(value)) {
      // Single-node circular list
      if (head.next == head) {
        return null;
      }

      // Find tail and move head
      SinglyCircularLinkedList<T> tail = head;
      while (tail.next != head) {
        if (tail.next == null) {
          throw new IllegalStateException("Singly Linked ListImplementation is not circular");
        }
        tail = tail.next;
      }

      SinglyCircularLinkedList<T> newHead = head.next;
      tail.next = newHead;
      return newHead;
    }

    SinglyCircularLinkedList<T> temporaryNode = head;

    // Case 3: Parse through the list until the matching value is found or full circle is reached
    while (temporaryNode.next != head && !temporaryNode.next.node.equals(value)) {
      temporaryNode = temporaryNode.next;
    }

    // Case 4: If value is found away from head -> Bypass that node
    if (temporaryNode.next != head) {
      temporaryNode.next = temporaryNode.next.next;
    }

    return head;
  }

  /**
   * Deletes the last node from the list.
   * @param head current head node
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   */
  public SinglyCircularLinkedList<T> deleteFromEnd(SinglyCircularLinkedList<T> head) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: If only one node exists -> Return null
    if (head.next == head) {
      return null;
    }

    // Case 3: Parse till the second last node and disconnect the last node
    SinglyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode.next.next != head) {
      temporaryNode = temporaryNode.next;
    }

    temporaryNode.next = head;

    return head;
  }

  /**
   * Deletes the first node from the list.
   * @param head current head node
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   */
  public SinglyCircularLinkedList<T> deleteFromBeginning(SinglyCircularLinkedList<T> head) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: Single-node circular list
    if (head.next == head) {
      return null;
    }

    // Case 3: Parse till the tail node and move head to the next node
    SinglyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode.next != head) {
      if (temporaryNode.next == null) {
        throw new IllegalStateException("Singly Linked ListImplementation is not circular");
      }
      temporaryNode = temporaryNode.next;
    }

    SinglyCircularLinkedList<T> newHead = head.next;
    temporaryNode.next = newHead;
    return newHead;
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
  public SinglyCircularLinkedList<T> deleteAtIndex(SinglyCircularLinkedList<T> head, T value, int index) {

    if (head == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    if (index < 0) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    if (index == 0) {
      return deleteFromBeginning(head);
    }

    int counter = 0;
    SinglyCircularLinkedList<T> previousNode = head;

    while (counter < index - 1) {
      previousNode = previousNode.next;
      counter++;
      if (previousNode == null || previousNode == head) {
        throw new IndexOutOfBoundsException("Index passed is not correct");
      }
    }

    previousNode.next = previousNode.next.next;

    return head;
  }

  /**
   * Reverses the list.
   * @param head current head node
   * @return new head after reversing the list
   */
  public SinglyCircularLinkedList<T> reverse(SinglyCircularLinkedList<T> head) {

    if (head == null) {
      return null;
    }
    if (head.next == head) {
      return head;
    }

    SinglyCircularLinkedList<T> previousNode = head;
    SinglyCircularLinkedList<T> currentNode = head.next;

    while (currentNode != head) {
      SinglyCircularLinkedList<T> nextNode = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
    }

    // close the circle and return new head
    head.next = previousNode;
    return previousNode;
  }
}
