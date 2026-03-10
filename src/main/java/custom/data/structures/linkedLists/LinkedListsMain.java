package custom.data.structures.linkedLists;

/**
 * Simple runner for the linked list folder.
 */
public class LinkedListsMain {

  public static void main(String[] args) {
    LinkedList<String> head = new LinkedList<>("A");

    System.out.println("Singly linked list");
    System.out.println("Initial list:");
    head.printIterative(head);

    head = head.insertAtBeginning(head, "Start");
    head = head.insertAtEnd(head, "End");
    head = head.insertAtIndex(head, "Middle", 2);

    System.out.println("After insert operations:");
    head.printIterative(head);

    System.out.println("Recursive print:");
    head.printRecursive(head);

    head = head.deleteByValue(head, "Middle");
    head = head.deleteFromBeginning(head);
    head = head.deleteFromEnd(head);

    System.out.println("After delete operations:");
    head.printIterative(head);

    head = head.reverse(head);
    System.out.println("After reverse:");
    head.printIterative(head);

    DoublyLinkedList<String> doublyHead = new DoublyLinkedList<>("A");

    System.out.println();
    System.out.println("Doubly linked list");
    System.out.println("Initial list:");
    doublyHead.printIterative(doublyHead);

    doublyHead = doublyHead.insertAtBeginning(doublyHead, "Start");
    doublyHead = doublyHead.insertAtEnd(doublyHead, "End");
    doublyHead = doublyHead.insertAtIndex(doublyHead, "Middle", 2);

    System.out.println("After insert operations:");
    doublyHead.printIterative(doublyHead);

    System.out.println("Recursive print:");
    doublyHead.printRecursive(doublyHead);

    doublyHead = doublyHead.deleteByValue(doublyHead, "Middle");
    doublyHead = doublyHead.deleteFromBeginning(doublyHead);
    doublyHead = doublyHead.deleteFromEnd(doublyHead);

    System.out.println("After delete operations:");
    doublyHead.printIterative(doublyHead);

    doublyHead = doublyHead.reverse(doublyHead);
    System.out.println("After reverse:");
    doublyHead.printIterative(doublyHead);
  }
}
