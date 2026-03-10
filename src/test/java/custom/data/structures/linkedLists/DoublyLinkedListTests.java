package custom.data.structures.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Doubly Linked List Tests")
class DoublyLinkedListTests {

    private DoublyLinkedList<String> helper;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        helper = new DoublyLinkedList<>("A");
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    private List<String> toForwardValues(DoublyLinkedList<String> head) {
        List<String> values = new ArrayList<>();
        DoublyLinkedList<String> current = head;

        while (current != null) {
            values.add(current.getNode());
            current = current.getNext();
        }
        return values;
    }

    private List<String> toBackwardValues(DoublyLinkedList<String> head) {
        List<String> values = new ArrayList<>();

        if (head == null) {
            return values;
        }

        DoublyLinkedList<String> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        while (tail != null) {
            values.add(tail.getNode());
            tail = tail.getPrevious();
        }
        return values;
    }

    @Test
    @DisplayName("Constructor should store value and keep links empty")
    void constructorStoresValueAndKeepsLinksEmpty() {
        DoublyLinkedList<String> node = new DoublyLinkedList<>("Node");
        printValue("Stored value", node.getNode());
        assertEquals("Node", node.getNode());
        assertNull(node.getNext());
        assertNull(node.getPrevious());
    }

    @Test
    @DisplayName("Constructor should throw when value is null")
    void constructorThrowsForNullValue() {
        assertThrows(IllegalArgumentException.class, () -> new DoublyLinkedList<String>(null));
    }

    @Test
    @DisplayName("Insert at beginning should return new head and set previous link")
    void insertAtBeginningReturnsNewHead() {
        DoublyLinkedList<String> head = helper.insertAtBeginning(helper, "Start");
        printValue("Forward values", toForwardValues(head));
        assertEquals(List.of("Start", "A"), toForwardValues(head));
        assertNull(head.getPrevious());
        assertSame(head, head.getNext().getPrevious());
    }

    @Test
    @DisplayName("Insert at end should append values and keep backward links")
    void insertAtEndAppendsValue() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        printValue("Forward values", toForwardValues(head));
        printValue("Backward values", toBackwardValues(head));
        assertEquals(List.of("A", "B", "C"), toForwardValues(head));
        assertEquals(List.of("C", "B", "A"), toBackwardValues(head));
    }

    @Test
    @DisplayName("Insert at index should place value in the middle")
    void insertAtIndexInMiddle() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "C");
        head = helper.insertAtIndex(head, "B", 1);
        printValue("Forward values", toForwardValues(head));
        printValue("Backward values", toBackwardValues(head));
        assertEquals(List.of("A", "B", "C"), toForwardValues(head));
        assertEquals(List.of("C", "B", "A"), toBackwardValues(head));
    }

    @Test
    @DisplayName("Insert at index should throw for negative index")
    void insertAtIndexThrowsForNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> helper.insertAtIndex(helper, "B", -1));
    }

    @Test
    @DisplayName("Print iterative should show values in order")
    void printIterativeShowsCorrectOrder() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));
        try {
            helper.printIterative(head);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "");
        printValue("Printed output", printed.trim());
        assertEquals("A->B->C\n", printed);
    }

    @Test
    @DisplayName("Delete by value should remove head and clear previous link")
    void deleteByValueRemovesHead() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.deleteByValue(head, "A");
        printValue("Forward values", toForwardValues(head));
        assertEquals(List.of("B"), toForwardValues(head));
        assertNull(head.getPrevious());
    }

    @Test
    @DisplayName("Delete from end should remove tail node")
    void deleteFromEndRemovesLastNode() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteFromEnd(head);
        printValue("Forward values", toForwardValues(head));
        assertEquals(List.of("A", "B"), toForwardValues(head));
        assertEquals(List.of("B", "A"), toBackwardValues(head));
    }

    @Test
    @DisplayName("Delete from beginning should remove first node")
    void deleteFromBeginningRemovesFirstNode() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteFromBeginning(head);
        printValue("Forward values", toForwardValues(head));
        assertEquals(List.of("B", "C"), toForwardValues(head));
        assertNull(head.getPrevious());
    }

    @Test
    @DisplayName("Delete from beginning should return null for single node list")
    void deleteFromBeginningReturnsNullForSingleNode() {
        DoublyLinkedList<String> head = helper.deleteFromBeginning(helper);
        printValue("Head after delete", head);
        assertNull(head);
    }

    @Test
    @DisplayName("Delete at index should remove middle node and keep links correct")
    void deleteAtIndexRemovesMiddleNode() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteAtIndex(head, null, 1);
        printValue("Forward values", toForwardValues(head));
        printValue("Backward values", toBackwardValues(head));
        assertEquals(List.of("A", "C"), toForwardValues(head));
        assertEquals(List.of("C", "A"), toBackwardValues(head));
    }

    @Test
    @DisplayName("Delete at index should remove last node")
    void deleteAtIndexRemovesLastNode() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteAtIndex(head, null, 2);
        printValue("Forward values", toForwardValues(head));
        assertEquals(List.of("A", "B"), toForwardValues(head));
        assertEquals(List.of("B", "A"), toBackwardValues(head));
    }

    @Test
    @DisplayName("Delete at index should throw for negative index")
    void deleteAtIndexThrowsForNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> helper.deleteAtIndex(helper, null, -1));
    }

    @Test
    @DisplayName("Reverse should return values in opposite order")
    void reverseReturnsListInReverseOrder() {
        DoublyLinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.reverse(head);
        printValue("Forward values after reverse", toForwardValues(head));
        printValue("Backward values after reverse", toBackwardValues(head));
        assertEquals(List.of("C", "B", "A"), toForwardValues(head));
        assertEquals(List.of("A", "B", "C"), toBackwardValues(head));
    }
}

