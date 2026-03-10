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

@DisplayName("Linked List Tests")
class LinkedListTests {

    private LinkedList<String> helper;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        helper = new LinkedList<>("A");
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    private List<String> toValues(LinkedList<String> head) {
        List<String> values = new ArrayList<>();
        LinkedList<String> current = head;

        while (current != null) {
            values.add(current.getNode());
            current = current.getNext();
        }
        return values;
    }

    @Test
    @DisplayName("Constructor should store the passed value")
    void constructorStoresValue() {
        LinkedList<String> node = new LinkedList<>("Node");
        printValue("Stored value", node.getNode());
        assertEquals("Node", node.getNode());
        assertNull(node.getNext());
    }

    @Test
    @DisplayName("Constructor should throw when value is null")
    void constructorThrowsForNullValue() {
        assertThrows(IllegalArgumentException.class, () -> new LinkedList<String>(null));
    }

    @Test
    @DisplayName("Insert at beginning should return new head")
    void insertAtBeginningReturnsNewHead() {
        LinkedList<String> head = helper.insertAtBeginning(helper, "Start");
        printValue("List after insert at beginning", toValues(head));
        assertEquals(List.of("Start", "A"), toValues(head));
    }

    @Test
    @DisplayName("Insert at beginning should allow empty head")
    void insertAtBeginningAllowsEmptyHead() {
        LinkedList<String> head = helper.insertAtBeginning(null, "Only");
        printValue("List after insert on empty head", toValues(head));
        assertEquals(List.of("Only"), toValues(head));
    }

    @Test
    @DisplayName("Insert at end should append value")
    void insertAtEndAppendsValue() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        printValue("List after insert at end", toValues(head));
        assertEquals(List.of("A", "B"), toValues(head));
    }

    @Test
    @DisplayName("Insert at end should allow empty head")
    void insertAtEndAllowsEmptyHead() {
        LinkedList<String> head = helper.insertAtEnd(null, "Only");
        printValue("List after insert at end on empty head", toValues(head));
        assertEquals(List.of("Only"), toValues(head));
    }

    @Test
    @DisplayName("Insert at index zero should behave like insert at beginning")
    void insertAtIndexZeroInsertsAtBeginning() {
        LinkedList<String> head = helper.insertAtIndex(helper, "Start", 0);
        printValue("List after insert at index zero", toValues(head));
        assertEquals(List.of("Start", "A"), toValues(head));
    }

    @Test
    @DisplayName("Insert at middle index should place value correctly")
    void insertAtIndexInMiddle() {
        LinkedList<String> head = helper.insertAtEnd(helper, "C");
        head = helper.insertAtIndex(head, "B", 1);
        printValue("List after insert at middle", toValues(head));
        assertEquals(List.of("A", "B", "C"), toValues(head));
    }

    @Test
    @DisplayName("Insert at last index should append value correctly")
    void insertAtLastIndexAppendsCorrectly() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtIndex(head, "C", 2);
        printValue("List after insert at last index", toValues(head));
        assertEquals(List.of("A", "B", "C"), toValues(head));
    }

    @Test
    @DisplayName("Insert at index should throw for invalid negative index")
    void insertAtIndexThrowsForNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> helper.insertAtIndex(helper, "B", -1));
    }

    @Test
    @DisplayName("Insert at index should throw when index is beyond list size")
    void insertAtIndexThrowsWhenIndexIsTooLarge() {
        assertThrows(IndexOutOfBoundsException.class, () -> helper.insertAtIndex(helper, "B", 5));
    }

    @Test
    @DisplayName("Print iterative should show nodes in order")
    void printIterativeShowsCorrectOrder() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
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
        printValue("Iterative output", printed.trim());
        assertEquals("A->B->C\n", printed);
    }

    @Test
    @DisplayName("Print recursive should show nodes in order")
    void printRecursiveShowsCorrectOrder() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));
        try {
            helper.printRecursive(head);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "");
        printValue("Recursive output", printed.trim());
        assertEquals("A->B->C\n", printed);
    }

    @Test
    @DisplayName("Delete by value should remove matching head node")
    void deleteByValueRemovesHead() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.deleteByValue(head, "A");
        printValue("List after deleting head by value", toValues(head));
        assertEquals(List.of("B"), toValues(head));
    }

    @Test
    @DisplayName("Delete by value should remove matching middle node")
    void deleteByValueRemovesMiddleNode() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteByValue(head, "B");
        printValue("List after deleting middle value", toValues(head));
        assertEquals(List.of("A", "C"), toValues(head));
    }

    @Test
    @DisplayName("Delete by value should keep list unchanged when value is missing")
    void deleteByValueKeepsListWhenValueIsMissing() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.deleteByValue(head, "Missing");
        printValue("List after deleting missing value", toValues(head));
        assertEquals(List.of("A", "B"), toValues(head));
    }

    @Test
    @DisplayName("Delete by value should throw when head is null")
    void deleteByValueThrowsForNullHead() {
        assertThrows(IllegalArgumentException.class, () -> helper.deleteByValue(null, "A"));
    }

    @Test
    @DisplayName("Delete from end should remove last node")
    void deleteFromEndRemovesLastNode() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteFromEnd(head);
        printValue("List after delete from end", toValues(head));
        assertEquals(List.of("A", "B"), toValues(head));
    }

    @Test
    @DisplayName("Delete from end should return null for single-node list")
    void deleteFromEndReturnsNullForSingleNode() {
        LinkedList<String> head = helper.deleteFromEnd(helper);
        printValue("Head after deleting last node", head);
        assertNull(head);
    }

    @Test
    @DisplayName("Delete from beginning should remove first node")
    void deleteFromBeginningRemovesFirstNode() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.deleteFromBeginning(head);
        printValue("List after delete from beginning", toValues(head));
        assertEquals(List.of("B"), toValues(head));
    }

    @Test
    @DisplayName("Delete at index zero should remove head")
    void deleteAtIndexZeroRemovesHead() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.deleteAtIndex(head, null, 0);
        printValue("List after delete at index zero", toValues(head));
        assertEquals(List.of("B"), toValues(head));
    }

    @Test
    @DisplayName("Delete at middle index should remove correct node")
    void deleteAtIndexRemovesCorrectNode() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.deleteAtIndex(head, null, 1);
        printValue("List after delete at middle index", toValues(head));
        assertEquals(List.of("A", "C"), toValues(head));
    }

    @Test
    @DisplayName("Delete at index should throw for invalid index")
    void deleteAtIndexThrowsForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> helper.deleteAtIndex(helper, null, 2));
    }

    @Test
    @DisplayName("Reverse should return list in opposite order")
    void reverseReturnsListInReverseOrder() {
        LinkedList<String> head = helper.insertAtEnd(helper, "B");
        head = helper.insertAtEnd(head, "C");
        head = helper.reverse(head);
        printValue("List after reverse", toValues(head));
        assertEquals(List.of("C", "B", "A"), toValues(head));
    }

    @Test
    @DisplayName("Reverse should keep single-node list unchanged")
    void reverseKeepsSingleNodeList() {
        LinkedList<String> head = helper.reverse(helper);
        printValue("Single-node reverse", toValues(head));
        assertEquals(List.of("A"), toValues(head));
    }

    @Test
    @DisplayName("Reverse should return null for empty list")
    void reverseReturnsNullForEmptyList() {
        LinkedList<String> head = helper.reverse(null);
        printValue("Reverse empty list result", head);
        assertNull(head);
    }
}

