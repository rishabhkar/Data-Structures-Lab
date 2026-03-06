package com.collections.implementation.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SimpleQueueTests {

    private SimpleQueue queue;

    @BeforeEach
    void setUp() {
        queue = new SimpleQueue(3);
    }

    @Test
    @DisplayName("Enqueue updates size, peek, and rear")
    void enqueueUpdatesPeekRearAndSize() {
        queue.enqueue(5);
        queue.enqueue(9);

        assertEquals(2, queue.getSize());
        assertEquals(5, queue.peek());
        assertEquals(9, queue.rear());
        assertEquals(3, queue.getCapacity());
    }

    @Test
    @DisplayName("Overflow does not corrupt existing values")
    void overflowDoesNotChangeState() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4); // should print message and return

        assertEquals(3, queue.getSize());
        assertEquals(1, queue.peek());
        assertEquals(3, queue.rear());
    }

    @Test
    @DisplayName("Dequeue moves front pointer and shrinks size")
    void dequeueShiftsFront() {
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);

        queue.dequeue();

        assertEquals(2, queue.getSize());
        assertEquals(8, queue.peek());
        assertEquals(9, queue.rear());
    }

    @Test
    @DisplayName("Peek and rear return -1 when queue is empty")
    void peekAndRearReturnNegativeOneWhenEmpty() {
        queue.dequeue();
        queue.dequeue();

        assertEquals(0, queue.getSize());
        assertEquals(-1, queue.peek());
        assertEquals(-1, queue.rear());
    }
}
