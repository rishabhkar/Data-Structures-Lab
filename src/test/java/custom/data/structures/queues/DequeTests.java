package custom.data.structures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Deque Tests")
class DequeTests {

    private Deque deque;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        deque = new Deque(3);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Add first should place value at the front")
    void addFirstPlacesValueAtFront() {
        deque.addLast(20);
        deque.addFirst(10);
        printValue("Front value", deque.peek());
        printValue("Rear value", deque.rear());
        assertEquals(2, deque.getSize());
        assertEquals(10, deque.peek());
        assertEquals(20, deque.rear());
    }

    @Test
    @DisplayName("Add last should place value at the rear")
    void addLastPlacesValueAtRear() {
        deque.addLast(10);
        deque.addLast(20);
        printValue("Front value", deque.peek());
        printValue("Rear value", deque.rear());
        assertEquals(10, deque.peek());
        assertEquals(20, deque.rear());
    }

    @Test
    @DisplayName("Remove first should remove the front value")
    void removeFirstRemovesFrontValue() {
        deque.addLast(10);
        deque.addLast(20);
        deque.removeFirst();
        printValue("Front after removeFirst", deque.peek());
        assertEquals(1, deque.getSize());
        assertEquals(20, deque.peek());
    }

    @Test
    @DisplayName("Remove last should remove the rear value")
    void removeLastRemovesRearValue() {
        deque.addLast(10);
        deque.addLast(20);
        deque.removeLast();
        printValue("Rear after removeLast", deque.rear());
        assertEquals(1, deque.getSize());
        assertEquals(10, deque.rear());
    }

    @Test
    @DisplayName("Peek and rear on empty deque should return minus one")
    void peekAndRearOnEmptyDequeReturnMinusOne() {
        printValue("Front value", deque.peek());
        printValue("Rear value", deque.rear());
        assertEquals(-1, deque.peek());
        assertEquals(-1, deque.rear());
    }

    @Test
    @DisplayName("Add on full deque should keep size unchanged")
    void addOnFullDequeKeepsSizeUnchanged() {
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            deque.addFirst(5);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "").trim();
        printValue("Console output", printed);
        assertEquals(3, deque.getSize());
        assertEquals("Queue Full", printed);
    }
}

