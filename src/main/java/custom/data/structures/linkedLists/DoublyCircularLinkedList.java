package custom.data.structures.linkedLists;

/**
 * Simple doubly circular linked list node.
 * The same class also provides basic circular linked list operations.
 *
 * @param <T> type of value stored in the node
 */
public class DoublyCircularLinkedList<T> {

  private T node;
  private DoublyCircularLinkedList<T> next;
  private DoublyCircularLinkedList<T> previous;

  /**
   * Creates one doubly linked list node.
   *
   * @param value value stored in the node
   * @throws IllegalArgumentException when value is null
   */
  public DoublyCircularLinkedList(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Value passed is not correct");
    }
    this.node = value;
    this.next = null;
    this.previous = null;
  }

  /**
   * Returns the value stored in this node.
   *
   * @return current node value
   */
  public T getNode() {
    return this.node;
  }

  /**
   * Returns the next node.
   *
   * @return next linked node or null
   */
  public DoublyCircularLinkedList<T> getNext() {
    return this.next;
  }

  /**
   * Returns the previous node.
   *
   * @return previous linked node or null
   */
  public DoublyCircularLinkedList<T> getPrevious() {
    return this.previous;
  }

  /**
   * Inserts a new node at the start of the list.
   *
   * @param head current head node
   * @param value value to insert
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   */
  public DoublyCircularLinkedList<T> insertAtBeginning(DoublyCircularLinkedList<T> head, T value) {

    // Case 1: If value passed is null -> Argument is illegal -> Throw exception
    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    // Case 2: Normal insert at the beginning of the circular list
    DoublyCircularLinkedList<T> newNode = new DoublyCircularLinkedList<>(value);
    DoublyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode.next != head) {
      temporaryNode.next = newNode;
      newNode.previous = temporaryNode;

      newNode.next = head;
      head.previous = newNode;
      head = newNode;
    }

    return head;
  }

  /**
   * Inserts a new node at the end of the list.
   *
   * @param head current head node
   * @param value value to insert
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   */
  public DoublyCircularLinkedList<T> insertAtEnd(DoublyCircularLinkedList<T> head, T value) {

    // Case 1: If value passed is null -> Argument is illegal -> Throw Exception
    if (value == null) {
      throw new IllegalArgumentException("Parameters passed are not correct");
    }

    // Case 2: If head passed is null -> No Linked List exists yet -> Create and return single node List
    if (head == null) {
      return new DoublyCircularLinkedList<>(value);
    }

    // Case 3: Normal insert at the end of the circular list
    DoublyCircularLinkedList<T> newNode = new DoublyCircularLinkedList<>(value);
    DoublyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode.next != head) {
      temporaryNode.next = newNode;
      newNode.previous = temporaryNode;

      newNode.next = head;
      head.previous = newNode;
    }

    return head;
  }

  /**
   * Inserts a new node at the given index.
   *
   * @param head current head node
   * @param value value to insert
   * @param index position where the node should be inserted
   * @return updated head node
   * @throws IllegalArgumentException when value is null
   * @throws IndexOutOfBoundsException when index is invalid
   */
  public DoublyCircularLinkedList<T> insertAtIndex(
      DoublyCircularLinkedList<T> head, T value, int index) {

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
    DoublyCircularLinkedList<T> previousNode = head;

    while (counter < index - 1 && previousNode != null) {
      previousNode = previousNode.next;
      counter++;
    }

    // Case 5: If previous node is invalid -> Index is outside the list -> Throw exception
    if (previousNode == null && previousNode.next == null) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    // Case 6: Normal insert in the middle or near the end of the list
    DoublyCircularLinkedList<T> newNode = new DoublyCircularLinkedList<>(value);
    newNode.next = previousNode.next;
    previousNode.next = newNode;
    newNode.previous = previousNode;
    newNode.next.previous = newNode;

    return head;
  }

  /**
   * Prints the list from start to end using a loop.
   *
   * @param head head node of the list
   */
  public void printIterative(DoublyCircularLinkedList<T> head) {

    DoublyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode != null) {
      System.out.print(temporaryNode.node + ((temporaryNode.next != null) ? "->" : ""));
      temporaryNode = temporaryNode.next;
    }
    System.out.println();
  }

  /**
   * Prints the list from start to end using recursion.
   *
   * @param head head node of the list
   */
  public void printRecursive(
      SinglyCircularLinkedList<T> head, SinglyCircularLinkedList<T> startPointer) {

    if (head == null) {
      System.out.println();
      return;
    }

    System.out.print(startPointer.getNode() + ((startPointer.getNext() != head) ? "->" : ""));

    if (startPointer.getNext() == head) {
      System.out.println();
      return;
    }

    printRecursive(head, startPointer.getNext());
  }

  /**
   * Deletes the first node with the given value.
   *
   * @param head current head node
   * @param value value to delete
   * @return updated head node
   * @throws IllegalArgumentException when head is null or value is null
   */
  public DoublyCircularLinkedList<T> deleteByValue(DoublyCircularLinkedList<T> head, T value) {

    // Case 1: If head or value is null -> Argument is illegal -> Throw exception
    if (head == null || value == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: If value is present at head -> Remove head and return next node
    if (head.node.equals(value)) {
      return head.next;
    }

    DoublyCircularLinkedList<T> temporaryNode = head;

    // Case 3: Parse through the list until the matching value is found or full circle is reached
    while (temporaryNode.next != head && !temporaryNode.next.node.equals(value)) {
      temporaryNode = temporaryNode.next;
    }

    // Case 4: If value is found away from head -> Bypass that node
    if (temporaryNode.next != head) {
      temporaryNode.next = temporaryNode.next.next;
      temporaryNode.next.previous = temporaryNode;
    }

    return head;
  }

  /**
   * Deletes the last node from the list.
   *
   * @param head current head node
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   */
  public DoublyCircularLinkedList<T> deleteFromEnd(DoublyCircularLinkedList<T> head) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: If only one node exists -> Return null
    if (head.next == null) {
      return null;
    }

    // Case 3: Parse till the second last node and disconnect the last node
    DoublyCircularLinkedList<T> temporaryNode = head;

    while (temporaryNode.next.next != head) {
      temporaryNode = temporaryNode.next;
    }

    head.previous = temporaryNode;
    temporaryNode.next = head;

    return head;
  }

  /**
   * Deletes the first node from the list.
   *
   * @param head current head node
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   */
  public DoublyCircularLinkedList<T> deleteFromBeginning(DoublyCircularLinkedList<T> head) {

    // Case 1: If head is null -> Argument is illegal -> Throw exception
    if (head == null) {
      throw new IllegalArgumentException("Head pointer is empty.");
    }

    // Case 2: Move head to the next node and reconnect the tail
    DoublyCircularLinkedList<T> temporaryNode = head;

    while(temporaryNode.next != head) {
      temporaryNode = temporaryNode.next;
    }

    head = head.next;
    temporaryNode.next = head;
    head.previous = temporaryNode;

    return head;
  }

  /**
   * Deletes the node at the given index.
   *
   * @param head current head node
   * @param value unused compatibility parameter
   * @param index position to delete
   * @return updated head node
   * @throws IllegalArgumentException when head is null
   * @throws IndexOutOfBoundsException when index is invalid
   */
  public DoublyCircularLinkedList<T> deleteAtIndex(
      DoublyCircularLinkedList<T> head, T value, int index) {

    // Case 1: If head passed is null -> Argument Illegal -> Throw Exception
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

    // Case 4: Parse till the node just before the target index
    int counter = 0;
    DoublyCircularLinkedList<T> previousNode = head;

    while (counter < index - 1 && previousNode != null) {
      previousNode = previousNode.next;
      counter++;
    }

    // Case 5: If node before target is invalid -> Throw exception
    if (previousNode == null || previousNode.next == null) {
      throw new IndexOutOfBoundsException("Index passed is not correct");
    }

    // Case 6: Normal delete from the middle or end of the list
    previousNode.next.next.previous = previousNode;
    previousNode.next = previousNode.next.next;

    return head;
  }

  /**
   * Reverses the list.
   *
   * @param head current head node
   * @return new head after reversing the list
   */
  public DoublyCircularLinkedList<T> reverse(DoublyCircularLinkedList<T> head) {

    // Case 1: Usual case of reversing a circular list
    DoublyCircularLinkedList<T> previousNode = head;
    DoublyCircularLinkedList<T> currentNode = head.next;

    while (currentNode != head) {
      // Assign a new pointer to point towards next node
      DoublyCircularLinkedList<T> nextNode = currentNode.next;

      // Change current node pointers
      currentNode.next = previousNode;
      currentNode.previous = nextNode;

      previousNode = currentNode;
      currentNode = nextNode;
    }

    return previousNode;
  }
}
