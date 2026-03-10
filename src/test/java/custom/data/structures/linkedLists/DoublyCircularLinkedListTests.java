package custom.data.structures.linkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Doubly Circular Linked List Tests")
class DoublyCircularLinkedListTests {

    private DoublyCircularLinkedList<String> helper;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        helper = new DoublyCircularLinkedList<>("A");
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    private void setNext(DoublyCircularLinkedList<String> node, DoublyCircularLinkedList<String> next) {
        try {
            Field nextField = DoublyCircularLinkedList.class.getDeclaredField("next");
            nextField.setAccessible(true);
            nextField.set(node, next);
        } catch (ReflectiveOperationException exception) {
            fail("Could not prepare test list: " + exception.getMessage());
        }
    }

    private void setPrevious(DoublyCircularLinkedList<String> node, DoublyCircularLinkedList<String> previous) {
        try {
            Field previousField = DoublyCircularLinkedList.class.getDeclaredField("previous");
            previousField.setAccessible(true);
            previousField.set(node, previous);
        } catch (ReflectiveOperationException exception) {
            fail("Could not prepare test list: " + exception.getMessage());
        }
    }

    private DoublyCircularLinkedList<String> buildCircularList(String... values) {
        if (values.length == 0) {
            return null;
        }

        DoublyCircularLinkedList<String> head = new DoublyCircularLinkedList<>(values[0]);
        setNext(head, head);
        setPrevious(head, head);
        DoublyCircularLinkedList<String> tail = head;

        for (int i = 1; i < values.length; i++) {
            DoublyCircularLinkedList<String> node = new DoublyCircularLinkedList<>(values[i]);
            setNext(node, head);
            setPrevious(node, tail);
            setNext(tail, node);
            setPrevious(head, node);
            tail = node;
        }

        return head;
    }

    private List<String> toForwardValues(DoublyCircularLinkedList<String> head, int expectedCount) {
        List<String> values = new ArrayList<>();

        if (head == null) {
            return values;
        }

        DoublyCircularLinkedList<String> current = head;
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

    private List<String> toBackwardValues(DoublyCircularLinkedList<String> head, int expectedCount) {
        List<String> values = new ArrayList<>();

        if (head == null) {
            return values;
        }

        DoublyCircularLinkedList<String> current = head.getPrevious();
        if (current == null) {
            fail("Previous link is missing");
        }

        DoublyCircularLinkedList<String> start = current;
        int steps = 0;

        do {
            values.add(current.getNode());
            current = current.getPrevious();
            steps++;

            if (current == null || steps > expectedCount) {
                fail("Backward links are not circular as expected");
            }
        } while (current != start);

        return values;
    }

    @Test
    @DisplayName("Constructor should store value and keep links empty")
    void constructorStoresValueAndKeepsLinksEmpty() {
        DoublyCircularLinkedList<String> node = new DoublyCircularLinkedList<>("Node");
        printValue("Stored value", node.getNode());
        assertEquals("Node", node.getNode());
        assertNull(node.getNext());
        assertNull(node.getPrevious());
    }

    @Test
    @DisplayName("Constructor should throw when value is null")
    void constructorThrowsForNullValue() {
        assertThrows(IllegalArgumentException.class, () -> new DoublyCircularLinkedList<String>(null));
    }

    @Test
    @DisplayName("Insert at beginning should return new head in a one node circular list")
    void insertAtBeginningReturnsNewHeadForSingleNodeCircularList() {
        DoublyCircularLinkedList<String> head = buildCircularList("A");
        head = helper.insertAtBeginning(head, "Start");
        List<String> forwardValues = toForwardValues(head, 2);
        List<String> backwardValues = toBackwardValues(head, 2);
        printValue("Forward values after insert at beginning", forwardValues);
        printValue("Backward values after insert at beginning", backwardValues);
        assertEquals(List.of("Start", "A"), forwardValues);
        assertEquals(List.of("A", "Start"), backwardValues);
    }

    @Test
    @DisplayName("Insert at end should append value in a one node circular list")
    void insertAtEndAppendsValueForSingleNodeCircularList() {
        DoublyCircularLinkedList<String> head = buildCircularList("A");
        head = helper.insertAtEnd(head, "B");
        List<String> forwardValues = toForwardValues(head, 2);
        List<String> backwardValues = toBackwardValues(head, 2);
        printValue("Forward values after insert at end", forwardValues);
        printValue("Backward values after insert at end", backwardValues);
        assertEquals(List.of("A", "B"), forwardValues);
        assertEquals(List.of("B", "A"), backwardValues);
    }

    @Test
    @DisplayName("Delete by value should remove middle node and keep both links circular")
    void deleteByValueRemovesMiddleNodeAndKeepsLinksCircular() {
        DoublyCircularLinkedList<String> head = buildCircularList("A", "B", "C");
        head = helper.deleteByValue(head, "B");
        List<String> forwardValues = toForwardValues(head, 2);
        List<String> backwardValues = toBackwardValues(head, 2);
        printValue("Forward values after delete by value", forwardValues);
        printValue("Backward values after delete by value", backwardValues);
        assertEquals(List.of("A", "C"), forwardValues);
        assertEquals(List.of("C", "A"), backwardValues);
    }

    @Test
    @DisplayName("Delete from beginning should return null for a one node circular list")
    void deleteFromBeginningReturnsNullForSingleNodeCircularList() {
        DoublyCircularLinkedList<String> head = buildCircularList("A");
        DoublyCircularLinkedList<String> updatedHead = helper.deleteFromBeginning(head);
        printValue("Head after delete from beginning", updatedHead);
        assertNull(updatedHead);
    }

    @Test
    @DisplayName("Delete from end should return null for a one node circular list")
    void deleteFromEndReturnsNullForSingleNodeCircularList() {
        DoublyCircularLinkedList<String> head = buildCircularList("A");
        DoublyCircularLinkedList<String> updatedHead = helper.deleteFromEnd(head);
        printValue("Head after delete from end", updatedHead);
        assertNull(updatedHead);
    }

    @Test
    @DisplayName("Delete at index should throw when index is beyond circular list size")
    void deleteAtIndexThrowsWhenIndexIsTooLarge() {
        DoublyCircularLinkedList<String> head = buildCircularList("A", "B");
        assertThrows(IndexOutOfBoundsException.class, () -> helper.deleteAtIndex(head, null, 5));
    }

    @Test
    @DisplayName("Reverse should keep both links circular and reverse the order")
    void reverseKeepsBothLinksCircularAndReversesOrder() {
        DoublyCircularLinkedList<String> head = buildCircularList("A", "B", "C");
        head = helper.reverse(head);
        List<String> forwardValues = toForwardValues(head, 3);
        List<String> backwardValues = toBackwardValues(head, 3);
        printValue("Forward values after reverse", forwardValues);
        printValue("Backward values after reverse", backwardValues);
        assertEquals(List.of("C", "B", "A"), forwardValues);
        assertEquals(List.of("A", "B", "C"), backwardValues);
    }
}

