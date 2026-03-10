package custom.data.structures.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Singly Circular Linked List Tests")
class SinglyCircularLinkedListTests {

    private SinglyCircularLinkedList<String> helper;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        helper = new SinglyCircularLinkedList<>("A");
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    private void setNext(SinglyCircularLinkedList<String> node, SinglyCircularLinkedList<String> next) {
        try {
            Field nextField = SinglyCircularLinkedList.class.getDeclaredField("next");
            nextField.setAccessible(true);
            nextField.set(node, next);
        } catch (ReflectiveOperationException exception) {
            fail("Could not prepare test list: " + exception.getMessage());
        }
    }

    private SinglyCircularLinkedList<String> buildCircularList(String... values) {
        if (values.length == 0) {
            return null;
        }

        SinglyCircularLinkedList<String> head = new SinglyCircularLinkedList<>(values[0]);
        setNext(head, head);
        SinglyCircularLinkedList<String> tail = head;

        for (int i = 1; i < values.length; i++) {
            SinglyCircularLinkedList<String> node = new SinglyCircularLinkedList<>(values[i]);
            setNext(node, head);
            setNext(tail, node);
            tail = node;
        }

        return head;
    }

    private List<String> toValues(SinglyCircularLinkedList<String> head, int expectedCount) {
        List<String> values = new ArrayList<>();

        if (head == null) {
            return values;
        }

        SinglyCircularLinkedList<String> current = head;
        int steps = 0;

        do {
            values.add(current.getNode());
            current = current.getNext();
            steps++;

            if (current == null || steps > expectedCount) {
                fail("List is not circular as expected");
            }
        } while (current != head);

        return values;
    }

    @Test
    @DisplayName("Constructor should store value and keep next empty")
    void constructorStoresValueAndKeepsNextEmpty() {
        SinglyCircularLinkedList<String> node = new SinglyCircularLinkedList<>("Node");
        printValue("Stored value", node.getNode());
        assertEquals("Node", node.getNode());
        assertNull(node.getNext());
    }

    @Test
    @DisplayName("Constructor should throw when value is null")
    void constructorThrowsForNullValue() {
        assertThrows(IllegalArgumentException.class, () -> new SinglyCircularLinkedList<String>(null));
    }

    @Test
    @DisplayName("Insert at end should append value in a one node circular list")
    void insertAtEndAppendsValueForSingleNodeCircularList() {
        SinglyCircularLinkedList<String> head = buildCircularList("A");
        head = helper.insertAtEnd(head, "B");
        List<String> values = toValues(head, 2);
        printValue("Values after insert at end", values);
        assertEquals(List.of("A", "B"), values);
    }

    @Test
    @DisplayName("Insert at beginning should return new head in a one node circular list")
    void insertAtBeginningReturnsNewHeadForSingleNodeCircularList() {
        SinglyCircularLinkedList<String> head = buildCircularList("A");
        head = helper.insertAtBeginning(head, "Start");
        List<String> values = toValues(head, 2);
        printValue("Values after insert at beginning", values);
        assertEquals(List.of("Start", "A"), values);
    }

    @Test
    @DisplayName("Insert at index should throw when index is beyond circular list size")
    void insertAtIndexThrowsWhenIndexIsTooLarge() {
        SinglyCircularLinkedList<String> head = buildCircularList("A", "B");
        assertThrows(IndexOutOfBoundsException.class, () -> helper.insertAtIndex(head, "C", 5));
    }

    @Test
    @DisplayName("Print iterative should show all nodes in circular order")
    void printIterativeShowsAllNodes() {
        SinglyCircularLinkedList<String> head = buildCircularList("A", "B", "C");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;

        try {
            System.setOut(new PrintStream(output));
            helper.printIterative(head);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "");
        printValue("Printed output", printed.trim());
        assertEquals("A->B->C\n", printed);
    }

    @Test
    @DisplayName("Delete by value should keep circular link when head is removed")
    void deleteByValueKeepsCircularLinkWhenHeadIsRemoved() {
        SinglyCircularLinkedList<String> head = buildCircularList("A", "B", "C");
        head = helper.deleteByValue(head, "A");
        List<String> values = toValues(head, 2);
        printValue("Values after deleting head", values);
        assertEquals(List.of("B", "C"), values);
    }

    @Test
    @DisplayName("Delete from beginning should return null for a one node circular list")
    void deleteFromBeginningReturnsNullForSingleNodeCircularList() {
        SinglyCircularLinkedList<String> head = buildCircularList("A");
        SinglyCircularLinkedList<String> updatedHead = helper.deleteFromBeginning(head);
        printValue("Head after delete from beginning", updatedHead);
        assertNull(updatedHead);
    }

    @Test
    @DisplayName("Delete from end should return null for a one node circular list")
    void deleteFromEndReturnsNullForSingleNodeCircularList() {
        SinglyCircularLinkedList<String> head = buildCircularList("A");
        SinglyCircularLinkedList<String> updatedHead = helper.deleteFromEnd(head);
        printValue("Head after delete from end", updatedHead);
        assertNull(updatedHead);
    }

    @Test
    @DisplayName("Reverse should keep the list circular and reverse the order")
    void reverseKeepsListCircularAndReversesOrder() {
        SinglyCircularLinkedList<String> head = buildCircularList("A", "B", "C");
        assertNotNull(head);
        head = helper.reverse(head);
        List<String> values = toValues(head, 3);
        printValue("Values after reverse", values);
        assertEquals(List.of("C", "B", "A"), values);
    }
}
