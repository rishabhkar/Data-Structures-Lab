package com.collections.implementation.stack;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedStackTests {

  FixedStack stack;

  @BeforeEach
  void setup() {
    stack = new FixedStack(10);
  }

  @Test
  @DisplayName("Push Test")
  public void pushTest() {

    stack.push(2);
    stack.push(3);
    stack.push(5);

    System.out.println("Stack size: " + stack.size);
    System.out.println("Top Element: " + stack.getTop());

    System.out.println("Printing Stack:");
    stack.printStack();
  }

  @Test
  @DisplayName("Pop removes the top and shrinks the stack")
  public void popRemovesTopElement() {

    stack.push(7);
    stack.push(8);
    stack.push(9);

    stack.pop();

    assertEquals(2, stack.size);
    assertEquals(8, stack.getTop());
  }
}
