package custom.data.structures.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dynamic Stack Linked List Tests")
class DynamicStackLinkedListTests {

    private DynamicStackLinkedList helper;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        helper = new DynamicStackLinkedList(10);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Push should return a new head node")
    void pushReturnsNewHeadNode() {
        DynamicStackLinkedList head = helper.push(helper, 20);
        printValue("New head data", head.data);
        assertEquals(20, head.data);
        assertSame(helper, head.next);
    }

    @Test
    @DisplayName("Pop should return the next node")
    void popReturnsNextNode() {
        DynamicStackLinkedList head = helper.push(helper, 20);
        DynamicStackLinkedList updatedHead = helper.pop(head);
        printValue("Head after pop", updatedHead.data);
        assertSame(helper, updatedHead);
    }

    @Test
    @DisplayName("Pop on null should return null")
    void popOnNullReturnsNull() {
        DynamicStackLinkedList updatedHead = helper.pop(null);
        printValue("Head after pop", updatedHead);
        assertNull(updatedHead);
    }

    @Test
    @DisplayName("Get size should count all nodes")
    void getSizeCountsAllNodes() {
        DynamicStackLinkedList head = helper.push(helper, 20);
        head = helper.push(head, 30);
        int size = helper.getSize(head);
        printValue("Stack size", size);
        assertEquals(3, size);
    }

    @Test
    @DisplayName("Get top should return the head data")
    void getTopReturnsHeadData() {
        DynamicStackLinkedList head = helper.push(helper, 20);
        int top = helper.getTop(head);
        printValue("Top value", top);
        assertEquals(20, top);
    }
}

