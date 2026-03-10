package custom.data.structures.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Simple Queue Tests")
class SimpleQueueTests {

    private SimpleQueue queue;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        queue = new SimpleQueue(3);
        System.out.println("\nRunning: " + testInfo.getDisplayName());
    }

    private void printValue(String label, Object value) {
        System.out.println(label + ": " + value);
    }

    @Test
    @DisplayName("Constructor should create an empty queue")
    void constructorCreatesEmptyQueue() {
        printValue("Capacity", queue.getCapacity());
        printValue("Size", queue.getSize());
        assertEquals(3, queue.getCapacity());
        assertEquals(0, queue.getSize());
    }

    @Test
    @DisplayName("Enqueue should add values in order")
    void enqueueAddsValuesInOrder() {
        queue.enqueue(10);
        queue.enqueue(20);
        printValue("Front value", queue.peek());
        printValue("Rear value", queue.rear());
        assertEquals(2, queue.getSize());
        assertEquals(10, queue.peek());
        assertEquals(20, queue.rear());
    }

    @Test
    @DisplayName("Dequeue should remove the front value")
    void dequeueRemovesFrontValue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        printValue("Front after dequeue", queue.peek());
        printValue("Rear after dequeue", queue.rear());
        assertEquals(2, queue.getSize());
        assertEquals(20, queue.peek());
        assertEquals(30, queue.rear());
    }

    @Test
    @DisplayName("Peek on empty queue should return minus one")
    void peekOnEmptyQueueReturnsMinusOne() {
        int value = queue.peek();
        printValue("Peek value", value);
        assertEquals(-1, value);
    }

    @Test
    @DisplayName("Rear on empty queue should return minus one")
    void rearOnEmptyQueueReturnsMinusOne() {
        int value = queue.rear();
        printValue("Rear value", value);
        assertEquals(-1, value);
    }

    @Test
    @DisplayName("Enqueue on full queue should keep size unchanged")
    void enqueueOnFullQueueKeepsSizeUnchanged() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(output));
            queue.enqueue(40);
        } finally {
            System.setOut(original);
        }

        String printed = output.toString().replace("\r", "").trim();
        printValue("Console output", printed);
        assertEquals(3, queue.getSize());
        assertEquals("SimpleQueue Full", printed);
    }
}

