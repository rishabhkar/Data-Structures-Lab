package com.collections.implementation.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DequeTests {

    private Deque deque;

    @BeforeEach
    void setUp() {
        deque = new Deque(3);
    }

    @Test
    @DisplayName("addFirst and addLast maintain peek/rear order")
    void addFirstAndAddLastMaintainOrder() {
        deque.addLast(10);
        deque.addFirst(5);
        deque.addLast(15);

        assertEquals(3, deque.getSize());
        assertEquals(5, deque.peek());
        assertEquals(15, deque.rear());
    }

    @Test
    @DisplayName("removeFirst and removeLast shrink size and adjust endpoints")
    void removeFirstAndLastShrinkSize() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        deque.removeFirst();
        assertEquals(2, deque.getSize());
        assertEquals(2, deque.peek());

        deque.removeLast();
        assertEquals(1, deque.getSize());
        assertEquals(2, deque.peek());
        assertEquals(2, deque.rear());
    }

    @Test
    @DisplayName("Overflow keeps existing data intact")
    void overflowDoesNotChangeSizeOrOrder() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(99);

        assertEquals(3, deque.getSize());
        assertEquals(1, deque.peek());
        assertEquals(3, deque.rear());
    }

    @Test
    @DisplayName("Underflow keeps queue empty and endpoints indicate emptiness")
    void underflowKeepsSizeZero() {
        deque.removeFirst();
        deque.removeLast();

        assertEquals(0, deque.getSize());
        assertEquals(-1, deque.peek());
        assertEquals(-1, deque.rear());
    }
}
