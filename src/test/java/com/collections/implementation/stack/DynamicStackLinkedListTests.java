package com.collections.implementation.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStackLinkedListTests {

    private DynamicStackLinkedList helper;

    @BeforeEach
    void setUp() {
        helper = new DynamicStackLinkedList(0);
    }

    @Test
    @DisplayName("push returns the new head with latest value")
    void pushReturnsNewHead() {
        DynamicStackLinkedList head = null;

        head = helper.push(head, 5);
        assertNotNull(head);
        assertEquals(5, head.data);
        assertEquals(1, helper.getSize(head));
        assertEquals(5, helper.getTop(head));

        head = helper.push(head, 8);
        assertEquals(2, helper.getSize(head));
        assertEquals(8, helper.getTop(head));
    }

    @Test
    @DisplayName("pop removes the head and reveals the next node")
    void popRemovesTopNode() {
        DynamicStackLinkedList head = null;
        head = helper.push(head, 10);
        head = helper.push(head, 20);
        head = helper.push(head, 30);

        head = helper.pop(head);
        assertEquals(2, helper.getSize(head));
        assertEquals(20, helper.getTop(head));

        head = helper.pop(head);
        assertEquals(1, helper.getSize(head));
        assertEquals(10, helper.getTop(head));
    }

    @Test
    @DisplayName("pop on empty stack returns null")
    void popReturnsNullWhenEmpty() {
        DynamicStackLinkedList head = null;

        head = helper.pop(head);

        assertNull(head);
        assertEquals(0, helper.getSize(head));
    }
}

